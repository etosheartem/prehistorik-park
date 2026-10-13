#!/usr/bin/env python3
"""Lossless reconstruction of Prehistorik Park J2ME graphics (no API calls).

Inputs are the original length-prefixed gpack PNGs, arr tables exported by
export_data.py and the decompiled rendering methods e.aD-aQ / e.dJ.
All coordinates retain the original 40x20 isometric world scale. See ASSETS.md.
"""
from __future__ import annotations

import argparse
import hashlib
import io
import json
import math
from pathlib import Path
import re
import struct
import subprocess
import sys

from PIL import Image, ImageDraw
from scenery_geometry import commands_for as scenery_commands

ROOT = Path(__file__).resolve().parent.parent
SOURCE = ROOT / "original/jar"
REPORT = ROOT / "original/export"
DEST = ROOT / "game/assets/original"
PACKS: dict[tuple[int, int], Image.Image] = {}
META: dict = {"schema": 1, "tile_size": [40, 20], "api_cost_usd": 0,
              "packs": [], "tiles": {}, "actors": [], "rides": [], "scenery": [], "ui": {}}
CHECKS = 0
CLIPPED_RECTS = set()


def write_json(path, value):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2) + "\n")


def resource(path):
    return "res://" + str(path.relative_to(ROOT / "game"))


def save_image(path, im):
    path.parent.mkdir(parents=True, exist_ok=True)
    im.save(path, compress_level=9)
    return resource(path)


def region(pack, index, rect):
    global CHECKS
    im = PACKS[pack, index]
    x, y, w, h = map(int, rect)
    assert w >= 0 and h >= 0, (pack, index, rect)
    if w == 0 or h == 0:
        return Image.new("RGBA", (max(1, w), max(1, h)))
    if not (0 <= x < im.width and 0 <= y < im.height and x + w <= im.width and y + h <= im.height):
        # A handful of dormant closed/unstaffed marker rectangles exceed the
        # original sheet. Preserve authored geometry, pad outside with alpha.
        CLIPPED_RECTS.add((pack, index, x, y, w, h, *im.size))
    CHECKS += 1
    return im.crop((x, y, x + w, y + h))


def unpack():
    for pack, count in enumerate([11, 13, 12]):
        blob = (SOURCE / f"gpack{pack}.dat").read_bytes()
        pos = 0
        for index in range(count):
            size, = struct.unpack_from("<H", blob, pos)
            pos += 2
            record = {"pack": pack, "index": index, "bytes": size, "offset": pos}
            if size:
                png = blob[pos:pos + size]
                assert len(png) == size and png.startswith(b"\x89PNG\r\n\x1a\n")
                image = Image.open(io.BytesIO(png))
                image.load()
                PACKS[pack, index] = image.convert("RGBA")
                path = DEST / "packs" / f"gpack{pack}_{index}.png"
                path.parent.mkdir(parents=True, exist_ok=True)
                path.write_bytes(png)  # Preserve the original PNG bytes and palette.
                record.update(path=resource(path), size=list(image.size), mode=image.mode,
                              sha256=hashlib.sha256(png).hexdigest())
                if image.mode == "P":
                    palette = image.getpalette()
                    record["palette_rgb"] = [palette[i:i + 3] for i in range(0, len(palette), 3)]
                    tr = image.info.get("transparency", 255)
                    record["transparency"] = list(tr) if isinstance(tr, bytes) else tr
            else:
                assert (pack, index) == (1, 7)
                record["alias"] = [0, 10]
            META["packs"].append(record)
            pos += size
        assert pos == len(blob), (pack, pos, len(blob))
    PACKS[1, 7] = PACKS[0, 10]
    for name in ("icon", "splash0", "splash1", "splash2"):
        im = Image.open(SOURCE / f"{name}.png").convert("RGBA")
        META["ui"][name] = {"path": save_image(DEST / "ui" / f"{name}.png", im), "size": list(im.size)}


def font(tables):
    xs = [[2, 13, 22, 31, 38, 49, 56, 68, 77, 86, 95, 103, 113, 126, 135, 144, 153, 161],
          [2, 10, 19, 29, 41, 49, 60, 68, 82, 97, 107, 118, 126, 135, 147, 156, 163, 180],
          [2, 13, 20, 30, 40, 51, 62, 72, 83, 94, 102, 106, 111, 116, 120, 129, 132, 139, 146, 149, 158, 172]]
    ys, hs = [0, 19, 36], [19, 17, 19]
    glyphs = {}
    for cp in range(0x410, 0x430):
        i = cp - 0x410 if cp < 0x421 else 30 + cp - 0x421
        glyphs[chr(cp)] = i
        glyphs[chr(cp + 32)] = i
    glyphs.update({" ": 45, "~": 46})
    glyphs.update({str(n): 60 + n for n in range(10)})
    glyphs.update({bytes([n & 255]).decode("cp1251"): 70 + i for i, n in enumerate(tables[130])})
    originals = {}
    for ch, number in glyphs.items():
        row, col = divmod(number, 30)
        originals[ch] = region(2, 6, [xs[row][col], ys[row], xs[row][col + 1] - xs[row][col], hs[row]])
    # The original renderer maps lower-case to capitals and does not contain Ё.
    # Locally assemble it from original Е plus dots from the original colon.
    e = originals["Е"]
    yo = Image.new("RGBA", (e.width, 22))
    yo.alpha_composite(e, (0, 3))
    d = ImageDraw.Draw(yo)
    for x in (max(1, e.width // 3), max(4, 2 * e.width // 3)):
        d.rectangle((x, 0, x + 1, 1), fill=(255, 221, 40, 255))
    originals["Ё"] = originals["ё"] = yo
    scale = 4
    atlas = Image.new("RGBA", (1024, 512))
    entries, x, y, row_h = [], 4, 4, 0
    for ch, im in sorted(originals.items(), key=lambda pair: ord(pair[0])):
        w, h = im.width * scale, im.height * scale
        if x + w + 4 > atlas.width:
            x, y, row_h = 4, y + row_h + 4, 0
        assert y + h + 4 <= atlas.height
        atlas.alpha_composite(im.resize((w, h), Image.Resampling.NEAREST), (x, y))
        entries.append({"id": ord(ch), "x": x, "y": y, "width": w, "height": h,
                        "xoffset": 0, "yoffset": 0 if ch in "Ёё" else 12,
                        "xadvance": (im.width + 1) * scale, "page": 0, "chnl": 15})
        x += w + 4
        row_h = max(row_h, h)
    atlas_path = DEST / "fonts/original.png"
    save_image(atlas_path, atlas)
    lines = ['info face="Prehistorik Park Original" size=88 bold=0 italic=0 charset="" unicode=1 stretchH=100 smooth=0 aa=1 padding=0,0,0,0 spacing=0,0',
             'common lineHeight=88 base=80 scaleW=1024 scaleH=512 pages=1 packed=0',
             'page id=0 file="original.png"', f'chars count={len(entries)}']
    lines.extend("char " + " ".join(f"{k}={v}" for k, v in entry.items()) for entry in entries)
    (DEST / "fonts/original.fnt").write_text("\n".join(lines) + "\n")
    META["font"] = {"path": resource(DEST / "fonts/original.fnt"), "source": "gpack2[6]",
                    "glyphs": len(entries), "native_height": 22, "atlas_scale": scale,
                    "lowercase": "original uppercase glyph", "assembled": ["Ё", "ё"]}


def export_tiles(tables):
    for n, y in enumerate([0, 20, 40]):
        for kind, pack, index in [("grass", 2, 0), ("cursor", 2, 1)]:
            p = DEST / "tiles" / f"{kind}_{n}.png"
            META["tiles"][f"{kind}_{n}"] = {"path": save_image(p, region(pack, index, [0, y, 38, 20])), "offset": [0, 0]}
    for name, rect in {"path_dirt": [0, 104, 38, 20], "path_stone": [38, 104, 38, 20]}.items():
        META["tiles"][name] = {"path": save_image(DEST / "tiles" / f"{name}.png", region(1, 2, rect)), "offset": [0, 0]}
    for n in range(3):
        name = f"water_{n}"
        META["tiles"][name] = {"path": save_image(DEST / "tiles" / f"{name}.png", region(1, 5, [0, n * 19, 38, 20])), "offset": [0, -1]}
    for name, first in [("edges", 59), ("details", 65)]:
        META["tiles"][name] = []
        for i in range(len(tables[first])):
            rect = [tables[first + k][i] for k in range(4)]
            im = region(1, 2, rect)
            META["tiles"][name].append({"path": save_image(DEST / "tiles" / f"{name}_{i}.png", im),
                "rect": rect, "offset": [tables[first + 4][i], tables[first + 5][i]] if i < len(tables[first + 4]) else [0, 0]})


def actors(t):
    def crop(actor, animation, frame, rect, anchor):
        path = DEST / "actors" / str(actor) / f"{animation}_{frame}.png"
        return {"path": save_image(path, region(0, actor, rect)), "rect": rect, "offset": [-anchor[0], -anchor[1]]}
    for actor in range(11):
        animations = {}
        for direction in range(4):
            frames = []
            for frame in range(3):
                i = actor * 12 + direction * 3 + frame
                rect = [t[1][i], t[19][actor * 4 + direction], t[2][i], t[20][actor * 4 + direction]]
                frames.append(crop(actor, f"walk_{direction}", frame, rect, [rect[2] // 2, rect[3]]))
            animations[f"walk_{direction}"] = {"frames": frames, "sequence": [0, 1, 0, 2]}
        for kind, count in [("sit", 2), ("ride", 3), ("pose", 1), ("special", 7)]:
            if actor >= 8:
                continue  # Only the eight guests have ride-specific poses.
            frames = []
            for f in range(count):
                if kind == "sit": rect = [t[21][actor * 2 + f], t[42][actor], t[43][actor], t[44][actor]]
                elif kind == "ride": rect = [t[22 + k][actor * 3 + f] for k in range(4)]
                elif kind == "pose": rect = [t[45 + k][actor] for k in range(4)]
                else: rect = t[3][actor * 28 + f * 4:actor * 28 + f * 4 + 4]
                if kind == "ride": anchor = [0, rect[3] if f == 0 else 0]
                elif kind == "special": anchor = [rect[2] // 2 * t[26][f * 2], rect[3] // 2 * t[26][f * 2 + 1]]
                else: anchor = [rect[2] // 2, rect[3]]
                frames.append(crop(actor, kind, f, rect, anchor))
            animations[kind] = {"frames": frames}
        META["actors"].append({"id": actor, "animations": animations})


def ui_regions(t):
    for name, first, pack, index in [("icons", 71, 2, 7), ("cursors", 13, 2, 9),
            ("menu_glyphs", 112, 2, 7), ("buttons", 116, 2, 3),
            ("button_labels", 120, 2, 3), ("touch_buttons", 126, 2, 2)]:
        frames = []
        for i in range(len(t[first])):
            rect = [t[first + k][i] for k in range(4)]
            frames.append({"path": save_image(DEST / "ui" / name / f"{i}.png", region(pack, index, rect)), "rect": rect})
        META["ui"][name] = frames


def repair_ticket_booths():
    # This is a new repo-native vector asset, not a lossy edit/upscale of the
    # extracted bitmaps. arr.dat references missing/incorrect ticket booth art.
    body = '''<g stroke="#271d0c" stroke-width="0.8" stroke-linejoin="round">
<path d="M3 31L21 22L37 31L19 41Z" fill="#4b5526"/>
<path d="M6 17L19 23L19 36L6 29Z" fill="#69431d"/>
<path d="M19 23L34 15L34 29L19 36Z" fill="#9a692a"/>
<path d="M20 23L32 17L32 28L20 34Z" fill="#302312"/>
<path d="M8 19L16 23L16 29L8 25Z" fill="#38270f"/>
<g id="cashier">
<path d="M23 28L26 24L30 26L30 30L23 34Z" fill="#965129"/>
<path d="M24 23L25 20L28 19L30 21L29 25L27 26L24 25Z" fill="#d9a556"/>
<path d="M24 23L23 21L25 19L28 18L30 21L28 21L27 20L25 22Z" fill="#463119"/>
</g>
<path d="M19 31L34 23L36 25L21 33Z" fill="#d1a259"/>
<path d="M22 30L27 27L29 29L24 32Z" fill="#eadcb6"/>
<path d="M5 16L7 17L7 31L5 30ZM32 13L34 14L34 29L32 30Z" fill="#bb9650"/>
<path d="M1 13L19 3L37 12L19 23Z" fill="#88652b"/>
<path d="M1 13L19 21L37 12L36 16L19 26L2 17Z" fill="#68441d"/>
<path d="M1 13L19 3L37 12L19 21Z" fill="#b5954d"/>
<path d="M5 11L22 19M10 8L28 16M15 5L32 14" fill="none" stroke="#8d682a"/>
<path d="M15 8L20 6L24 9L23 11L19 13L15 11Z" fill="#f1dfac"/>
<path d="M18 8L21 10M17 10L19 11" stroke="#816532"/>
<path d="M7 30L19 36L34 28L34 32L19 40L7 34Z" fill="#76501f"/>
<path d="M8 33L18 38M22 37L32 32" stroke="#bd9250"/>
<path d="M3 34L6 31L8 34L5 36ZM31 34L35 32L37 35L33 37Z" fill="#717349"/>
</g>'''
    for index, mirrored in [(14, False), (22, True)]:
        for state in ["working", "closed", "unstaffed"]:
            content = body
            if state != "working":
                content = re.sub(r'<g id="cashier">.*?</g>', '', content, flags=re.S)
            if state == "closed":
                content += '<path d="M20 24L32 18L32 28L20 34Z" fill="#655128" stroke="#271d0c" stroke-width="0.8"/>'
            if mirrored:
                content = '<g transform="translate(38 0) scale(-1 1)">' + content + '</g>'
            path = DEST / "scenery" / str(index) / f"ticket_{state}.svg"
            path.write_text('<svg xmlns="http://www.w3.org/2000/svg" width="38" height="44" viewBox="0 0 38 44">' + content + '</svg>\n')
            prop = META["scenery"][index]
            prop.setdefault("source_variants", {})[state] = prop["variants"][state]
            prop["variants"][state] = [{"path": resource(path), "offset": [0, -25], "size": [38, 44]}]
        prop["frames"] = prop["variants"]["working"]
        prop["local_repair"] = "Original arr.dat uses ice cream pixels for booth14 and exceeds the PNG for booth22. New wood/bone vector kiosks preserve the1x1 footprint; raw originals are source_variants."


def sprite_command(index, rect, offset, depth=0):
    return {"kind": "sprite", "pack": 1, "index": index, "rect": rect,
            "offset": offset, "depth": depth}


def line_command(points, color, depth=0):
    return {"kind": "line", "points": points, "color": color, "depth": depth}


def iso(tile):
    return [(tile[0] + tile[1]) * 20, (tile[0] - tile[1]) * 10]


def compile_frames(commands_per_frame, folder):
    # Common bounds for every frame preserve ground anchors and prevent jitter.
    left = top = math.inf
    right = bottom = -math.inf
    for commands in commands_per_frame:
        for command in commands:
            if command["kind"] == "sprite":
                x, y = command["offset"]
                w, h = command["rect"][2:]
                left, top, right, bottom = min(left, x), min(top, y), max(right, x + w), max(bottom, y + h)
            else:
                x1, y1, x2, y2 = command["points"]
                left, top, right, bottom = min(left, x1, x2), min(top, y1, y2), max(right, x1 + 1, x2 + 1), max(bottom, y1 + 1, y2 + 1)
    assert left != math.inf, folder
    size = (max(1, right - left), max(1, bottom - top))
    result = []
    unique = {}
    for number, commands in enumerate(commands_per_frame):
        im = Image.new("RGBA", size)
        for cmd in sorted(commands, key=lambda c: c["depth"]):
            if cmd["kind"] == "sprite":
                image = region(cmd["pack"], cmd["index"], cmd["rect"])
                im.alpha_composite(image, (cmd["offset"][0] - left, cmd["offset"][1] - top))
            else:
                p = cmd["points"]
                color = cmd["color"]
                ImageDraw.Draw(im).line((p[0] - left, p[1] - top, p[2] - left, p[3] - top), fill=(color >> 16 & 255, color >> 8 & 255, color & 255, 255))
        digest = hashlib.sha256(im.tobytes()).hexdigest()
        if digest not in unique:
            unique[digest] = save_image(DEST / folder / f"{number}.png", im)
        result.append({"path": unique[digest], "offset": [left, top], "size": list(size)})
    return result


def scenery(data):
    for prop in data["props"]:
        s, h, index = prop["sections"], prop["header"], prop["id"]
        variants = {}
        for state, frames in scenery_commands(prop).items():
            variants[state] = compile_frames(frames, f"scenery/{index}/{state}")
        META["scenery"].append({"id": index, "frames": variants["working"], "variants": variants,
                                "period": max(1, h["aH"]), "footprint": [1, 1]})


STATIC_COLORS = [[], [0], [0], [0], [0], [], [], [], [], [], [], [], [], [], [], [0], [], [8022300, 8022300], [], [], [], [], [], []]
DYNAMIC_COLORS = [[], [0], [0], [0, 0, 0, 0], [0, 0, 0, 0], [], [0, 0, 0], [], [], [], [], [], [], [],
                  [2166272, 2166272, 3745030, 3745030, 2166272, 2166272, 3745030], [], [0], [0], [0, 0, 0, 0], [], [], [], [], []]


def rides(data):
    for ride in data["rides"]:
        s, h, index = ride["sections"], ride["header"], ride["id"]
        width, height = s[0]
        layouts = [s[37][n * width * height:(n + 1) * width * height] for n in range(2)]
        entries = []
        for layout in layouts:
            entry = layout.index(10) if 10 in layout else 0
            entries.append([entry // height, entry % height])
        frames = []
        for phase in range(max(1, h["at"])):
            commands = []
            # aE: the list of static pieces is split between isometric cells.
            for cell in range(max(0, len(s[33]) - 1)):
                tile = [cell // (height - 1), cell % (height - 1) + 1]
                pos = iso(tile)
                for k in range(s[33][cell], s[33][cell + 1]):
                    i = s[32][k]
                    if s[4][1] == 1 or s[40][phase * h["an"] + i] == 1:
                        commands.append(sprite_command(s[11][i], [s[5 + n][i] for n in range(4)],
                            [pos[0] + s[9][i], pos[1] + s[10][i]], pos[1] * 10))
            entry = entries[0]
            base = iso([entry[0] + s[36][0], entry[1] + s[36][1]]) if s[36] else iso(entry)
            for i in range(h["ao"]):
                points = s[19][i * 4:i * 4 + 4]
                commands.append(line_command([points[0] + base[0], points[1] + base[1], points[2] + base[0], points[3] + base[1]], STATIC_COLORS[index][i], base[1] * 10 + 1))
            # aF: moving pieces can switch their isometric depth cell.
            anchor_phase = 0 if s[3][1] else phase
            if s[34]:
                tile = [entry[0] + s[34][anchor_phase * 2], entry[1] + s[34][anchor_phase * 2 + 1]]
                pos = iso(tile)
                for i in range(h["ap"]):
                    if s[4][1] == 1 or s[41][phase * h["ap"] + i] == 1:
                        dx = s[17][(phase if s[2][0] else 0) * h["ap"] + i]
                        dy = s[18][(phase if s[2][1] else 0) * h["ap"] + i]
                        commands.append(sprite_command(s[16][i], [s[12 + n][i] for n in range(4)], [pos[0] + dx, pos[1] + dy], pos[1] * 10 + 2))
            for i in range(h["aq"]):
                if s[4][2] == 0 and i % 2:
                    continue
                p = phase * (h["aq"] + 1) * 2 + i * 2
                points = s[20][p:p + 4]
                commands.append(line_command([points[0] + base[0], points[1] + base[1], points[2] + base[0], points[3] + base[1]], DYNAMIC_COLORS[index][i], base[1] * 10 + 3))
            # aD: short-lived segments (splashes, ropes, coaster cars) use
            # independent phase ranges, with no guessed frame interpolation.
            offset = 0
            for i in range(h["ar"]):
                start, end = s[1][i * 2:i * 2 + 2]
                if start <= phase <= end:
                    p = offset + phase - start
                    ap = 0 if s[3][3] else phase
                    pos = iso([entry[0] + s[36][ap * 2], entry[1] + s[36][ap * 2 + 1]])
                    commands.append(sprite_command(s[29][i], [s[25 + n][i] for n in range(4)],
                        [pos[0] + s[30][p], pos[1] + s[31][p]], pos[1] * 10 + 4))
                offset += end - start + 1
            if index == 22:  # Water course is a connectable terrain object.
                for tx in range(width):
                    for ty in range(height):
                        if layouts[0][tx * height + ty] == 13:
                            pos = iso([tx, ty])
                            commands.append(sprite_command(5, [0, 0, 38, 20], [pos[0], pos[1] - 1], pos[1]))
            if index == 23:  # Additional cafe furniture follows ay/b per tile.
                t = data["tables"]
                for tx in range(width):
                    for ty in range(height):
                        tile_kind = layouts[0][tx * height + ty]
                        pos = iso([tx, ty])
                        for i in ([3] if tile_kind == 9 else [6, 4, 5] if tile_kind == 4 else []):
                            offset_i = i if i == 3 else i + 3 * tx
                            commands.append(sprite_command(t[88][i], [t[80 + n][i] for n in range(4)],
                                [pos[0] + t[84][offset_i], pos[1] + t[85][offset_i]], pos[1] * 10))
            frames.append(commands)
        output = compile_frames(frames, f"rides/{index}")
        META["rides"].append({"id": index, "frames": output, "period": max(1, h["at"]),
            "footprint": [width, height], "entry_tile": entries[0], "entry_tiles": entries, "layouts": layouts,
            "commands": frames, "drawing_notes": "Unoccupied ride, entrance/fence and passengers are separate world layers."})


def contact_sheets():
    for category in ["rides", "scenery", "actors"]:
        items = META[category]
        tile_w, tile_h = (280, 240) if category == "rides" else (180, 160)
        cols = 4 if category == "rides" else 6
        sheet = Image.new("RGB", (cols * tile_w, math.ceil(len(items) / cols) * tile_h), (32, 47, 35))
        draw = ImageDraw.Draw(sheet)
        for n, entry in enumerate(items):
            if category == "actors": frame = entry["animations"]["walk_0"]["frames"][0]
            else: frame = entry["frames"][0]
            im = Image.open(ROOT / "game" / frame["path"][6:]).convert("RGBA")
            scale = max(1, min((tile_w - 12) // im.width, (tile_h - 30) // im.height))
            im = im.resize((im.width * scale, im.height * scale), Image.Resampling.NEAREST)
            x, y = n % cols * tile_w, n // cols * tile_h
            draw.text((x + 5, y + 5), f"{category} {entry['id']}", fill="white")
            sheet.paste(im, (x + (tile_w - im.width) // 2, y + 25), im)
        sheet.save(REPORT / f"{category}_contact.png")


def main():
    argparse.ArgumentParser(description=__doc__).parse_args()
    REPORT.mkdir(parents=True, exist_ok=True)
    unpack()
    data_path = ROOT / "original/data/game_data.json"
    if not data_path.exists():
        subprocess.run([sys.executable, str(ROOT / "original/export_data.py")], cwd=ROOT, check=True)
    data = json.loads(data_path.read_text())
    tables = data["tables"]
    font(tables)
    export_tiles(tables)
    actors(tables)
    ui_regions(tables)
    scenery(data)
    rides(data)
    contact_sheets()
    repair_ticket_booths()
    META["validation"] = {"rectangles_checked": CHECKS, "source_out_of_bounds_rects": sorted(CLIPPED_RECTS), "pack_slots": len(PACKS),
                          "actors": len(META["actors"]), "rides": len(META["rides"]), "scenery": len(META["scenery"])}
    write_json(REPORT / "graphics.json", META)
    runtime = {k: v for k, v in META.items() if k != "packs"}
    runtime["rides"] = [{k: v for k, v in ride.items() if k != "commands"} for ride in META["rides"]]
    write_json(DEST / "graphics.json", runtime)
    print("GRAPHICS OK", META["validation"])


if __name__ == "__main__":
    main()
