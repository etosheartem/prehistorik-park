#!/usr/bin/env python3
"""Create fixed-cell references for optional HD ride art; no network or API.

The parts contract allows thousands of original motion commands to reuse a
small number of sprites. Generated artwork is never installed by this script.
"""
from pathlib import Path
import argparse
import hashlib
import json
import math
import sys
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parent.parent
OUT = ROOT / "art/reference/ride_parts"


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--normalized", action="store_true", help="Enlarge each part within its cell; omit tiny line/peg parts from AI references")
    parser.add_argument("--scenery", action="store_true", help="Additional scenery parts only; reuse ride parts instead of regenerating them")
    parser.add_argument("--extras", action="store_true", help="One 5x4 sheet of world entrances, flower borders, bench and corner details")
    args = parser.parse_args()
    if args.scenery and args.extras:
        parser.error("Choose one group at a time")
    out = OUT.with_name("ride_parts_normalized") if args.normalized else OUT
    if args.scenery:
        out = OUT.with_name("scenery_parts_normalized" if args.normalized else "scenery_parts")
    if args.extras:
        out = OUT.with_name("extras_parts_normalized" if args.normalized else "extras_parts")
    source = json.loads((ROOT / "original/export/graphics.json").read_text())
    unique = {}
    for ride in source["rides"]:
        for phase, commands in enumerate(ride["commands"]):
            for command in commands:
                if command["kind"] != "sprite":
                    continue
                key = (command["pack"], command["index"], *command["rect"])
                item = unique.setdefault(key, {"source_pack": key[0], "source_index": key[1],
                    "source_rect": list(key[2:]), "ride_ids": set(), "references": 0})
                item["ride_ids"].add(ride["id"])
                item["references"] += 1
    shared_ride_keys = set(unique)
    if args.scenery:
        from scenery_geometry import commands_for
        unique = {}
        original_data = json.loads((ROOT / "original/data/game_data.json").read_text())
        for prop in original_data["props"]:
            if prop["id"] in [14, 22]:
                continue  # Locally repaired vector kiosks are already scalable.
            for frames in commands_for(prop).values():
                for commands in frames:
                    for command in commands:
                        key = (command["pack"], command["index"], *command["rect"])
                        if key in shared_ride_keys:
                            continue
                        item = unique.setdefault(key, {"source_pack": key[0], "source_index": key[1],
                            "source_rect": list(key[2:]), "ride_ids": set(), "references": 0})
                        item["ride_ids"].add(prop["id"])
                        item["references"] += 1
    if args.extras:
        known = set(shared_ride_keys)
        scenery_contract = json.loads((ROOT / "art/reference/scenery_parts_normalized/parts.json").read_text())
        for item in scenery_contract["parts"] + scenery_contract.get("aliases", []) + scenery_contract["keep_local"]:
            known.add((item["source_pack"], item["source_index"], *item["source_rect"]))
        unique = {}
        extras = []
        for group in ["edges", "details"]:
            for index, frame in enumerate(source["tiles"][group]):
                if group == "edges" and index == 0:
                    continue # Root supplies the local terrain material.
                extras.append((f"{group}_{index}", (1, 2, *frame["rect"])))
        extras.extend((f"park_entry_{index}", key) for index, key in enumerate([
            (1, 6, 0, 112, 15, 12), (1, 2, 90, 83, 15, 20), (1, 2, 105, 84, 18, 13)]))
        for name, key in extras:
            if key not in known:
                unique[key] = {"source_pack": key[0], "source_index": key[1], "source_rect": list(key[2:]),
                               "name": name, "ride_ids": set(), "references": 1}
    parts = []
    out.mkdir(parents=True, exist_ok=True)
    scale, columns, rows, cell_w, cell_h = 8, 4, 4, 64, 96
    if args.extras:
        columns, cell_w, cell_h = 5, 72, 120 # Exact3:4 provider-compatible canvas.
    atlases = []
    keys = sorted(unique)
    excluded = []
    if args.normalized:
        excluded = [key for key in keys if max(key[4:6]) <= 8]
        keys = [key for key in keys if key not in excluded]
    aliases = []
    if args.scenery or args.extras:
        # Several mirrored source pieces are pixel-identical. Pay for their
        # canonical part only and mirror locally after geometric alignment.
        seen_images = {}
        canonical = []
        for key in keys:
            pack, index, x, y, width, height = key
            if (pack, index) == (1, 7):
                pack, index = 0, 10
            path = ROOT / "game/assets/original/packs" / f"gpack{pack}_{index}.png"
            im = Image.open(path).convert("RGBA").crop((x, y, x + width, y + height))
            visible = Image.new("RGBA", im.size)
            visible.paste(im, mask=im.getchannel("A"))
            digest = (width, height, hashlib.sha256(visible.tobytes()).hexdigest())
            mirrored = (width, height, hashlib.sha256(visible.transpose(Image.Transpose.FLIP_LEFT_RIGHT).tobytes()).hexdigest())
            match = digest if digest in seen_images else mirrored if mirrored in seen_images else None
            if match:
                aliases.append({"source_pack": key[0], "source_index": key[1], "source_rect": list(key[2:]),
                                "canonical_source_key": list(seen_images[match]), "flip_x": match == mirrored})
            else:
                seen_images[digest] = key
                canonical.append(key)
        keys = canonical
    for sheet in range(math.ceil(len(keys) / (columns * rows))):
        im = Image.new("RGBA", (columns * cell_w, rows * cell_h))
        current = keys[sheet * columns * rows:(sheet + 1) * columns * rows]
        for index, key in enumerate(current):
            item = unique[key]
            crop = item["source_rect"]
            x, y, width, height = crop
            path = ROOT / "game/assets/original/packs" / f"gpack{key[0]}_{key[1]}.png"
            if (key[0], key[1]) == (1, 7):
                path = ROOT / "game/assets/original/packs/gpack0_10.png"
            part = Image.open(path).convert("RGBA").crop((x, y, x + width, y + height))
            source_digest = hashlib.sha256(part.tobytes()).hexdigest()
            draw_width, draw_height = width, height
            fit = 1.0
            if args.normalized:
                fit = min((cell_w - 16) / width, (cell_h - 16) / height)
                draw_width, draw_height = round(width * fit), round(height * fit)
                part = part.resize((draw_width, draw_height), Image.Resampling.NEAREST)
            column, row = index % columns, index // columns
            px = column * cell_w + (cell_w - draw_width) // 2
            py = row * cell_h + cell_h - draw_height - 8
            im.alpha_composite(part, (px, py))
            part_id = sheet * columns * rows + index
            parts.append({**item, "id": part_id, "ride_ids": sorted(item["ride_ids"]),
                "atlas": sheet, "cell": [column, row],
                "atlas_rect_native": [px, py, draw_width, draw_height],
                "atlas_rect_hd": [px * scale, py * scale, draw_width * scale, draw_height * scale],
                "part_scale_xy": [draw_width * scale / width, draw_height * scale / height],
                "sha256_rgba": source_digest,
                "reference_sha256_rgba": hashlib.sha256(part.tobytes()).hexdigest()})
        im = im.resize((im.width * scale, im.height * scale), Image.Resampling.NEAREST)
        name = f"atlas_{sheet}.png"
        im.save(out / name)
        review = Image.new("RGB", im.size, (42, 50, 40))
        review.paste(im, (0, 0), im)
        draw = ImageDraw.Draw(review)
        for index in range(len(current)):
            x, y = index % columns * cell_w * scale, index // columns * cell_h * scale
            draw.rectangle([x, y, x + cell_w * scale - 1, y + cell_h * scale - 1], outline=(118, 126, 106), width=2)
            draw.text((x + 12, y + 12), f"part {sheet * columns * rows + index}", fill="white")
        review.save(out / f"review_{sheet}.png")
        atlases.append({"id": sheet, "file": name, "size": list(im.size), "parts": len(current)})
    result = {"schema": 1, "scale": scale, "columns": columns, "rows": rows,
        "cell_native_size": [cell_w, cell_h], "cell_hd_size": [cell_w * scale, cell_h * scale],
        "atlases": atlases, "parts": parts, "cost_usd": 0, "normalized": args.normalized,
        "group": "extras" if args.extras else "scenery" if args.scenery else "rides", "aliases": aliases,
        "keep_local": [{"source_pack": key[0], "source_index": key[1], "source_rect": list(key[2:]),
                        "reason": "Tiny line or peg: preserve original pixels or draw locally; do not spend API budget."} for key in excluded],
        "contract": ["Cells and part rectangles must never move or be trimmed independently.",
                     "Return true transparent alpha; no ground, captions, labels or baked shadows.",
                     "Each source rectangle is a reusable part; retain connection endpoints for rails and supports.",
                     "Original sprite offset and depth are per command, not per atlas part.",
                     "Source drawLine commands remain vector lines; these are not image parts.",
                     "Rescale the extracted HD crop to source_rect.size in world units.",
                     "Do not install an AI result before reviewing seams, alpha, anchors and every affected animation."]}
    (out / "parts.json").write_text(json.dumps(result, ensure_ascii=False, indent=2) + "\n")
    print(f"PART ATLAS OK: {len(parts)} reusable parts, {len(atlases)} sheets, {sum(p['references'] for p in parts)} draw calls, $0")


if __name__ == "__main__":
    main()
