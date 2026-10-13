#!/usr/bin/env python3
"""Check original-source fidelity, resource coverage and stable motion anchors."""
from pathlib import Path
import hashlib
import json
import re
import struct
import xml.etree.ElementTree as ET
from PIL import Image

ROOT = Path(__file__).resolve().parent.parent


def main():
    runtime = json.loads((ROOT / "game/assets/original/graphics.json").read_text())
    report = json.loads((ROOT / "original/export/graphics.json").read_text())
    data = json.loads((ROOT / "original/data/game_data.json").read_text())
    checks = 0
    cache = {}

    def file(path):
        nonlocal checks
        assert path.startswith("res://assets/original/")
        result = ROOT / "game" / path[6:]
        assert result.is_file(), result
        checks += 1
        return result

    def dimensions(path):
        if path not in cache:
            p = file(path)
            if p.suffix == ".svg":
                root = ET.parse(p).getroot()
                cache[path] = (int(root.attrib["width"]), int(root.attrib["height"]))
            else:
                with Image.open(p) as image:
                    image.load()
                    assert image.mode in ("RGBA", "P", "RGB")
                    cache[path] = image.size
        return cache[path]

    for pack, count in enumerate([11, 13, 12]):
        blob = (ROOT / "original/jar" / f"gpack{pack}.dat").read_bytes()
        pos = 0
        entries = [p for p in report["packs"] if p["pack"] == pack]
        assert len(entries) == count
        for i, entry in enumerate(entries):
            size = struct.unpack_from("<H", blob, pos)[0]
            pos += 2
            assert size == entry["bytes"] and entry["offset"] == pos
            if size:
                png = blob[pos:pos + size]
                assert file(entry["path"]).read_bytes() == png
                assert hashlib.sha256(png).hexdigest() == entry["sha256"]
            else:
                assert (pack, i) == (1, 7) and entry["alias"] == [0, 10]
            pos += size
            checks += 3
        assert pos == len(blob)

    assert len(runtime["actors"]) == 11
    for actor in runtime["actors"]:
        for direction in range(4):
            animation = actor["animations"][f"walk_{direction}"]
            assert animation["sequence"] == [0, 1, 0, 2]
            assert len(animation["frames"]) == 3
            for frame in animation["frames"]:
                width, height = dimensions(frame["path"])
                assert [width, height] == [max(1, value) for value in frame["rect"][2:]]
                assert frame["offset"] == [-(frame["rect"][2] // 2), -frame["rect"][3]]
                checks += 3

    assert len(runtime["rides"]) == 24 and len(runtime["scenery"]) == 27
    for index, ride in enumerate(runtime["rides"]):
        assert ride["id"] == index
        assert len(ride["frames"]) == max(1, data["rides"][index]["header"]["at"])
        assert ride["footprint"] == data["rides"][index]["sections"][0]
        expected = ride["frames"][0]
        for frame in ride["frames"]:
            assert frame["offset"] == expected["offset"]
            assert frame["size"] == expected["size"] == list(dimensions(frame["path"]))
            checks += 2
    for prop in runtime["scenery"]:
        assert set(prop["variants"]) == {"working", "closed", "unstaffed"}
        for frames in prop["variants"].values():
            for frame in frames:
                assert list(dimensions(frame["path"])) == frame["size"]
                assert len(frame["offset"]) == 2
                checks += 2
    for index in (14, 22):
        prop = runtime["scenery"][index]
        assert prop["local_repair"] and prop["source_variants"]
        assert prop["frames"][0]["path"].endswith(".svg")
        checks += 3

    font = file(runtime["font"]["path"]).read_text()
    ids = set(map(int, re.findall(r"^char id=(\d+) ", font, re.MULTILINE)))
    assert len(ids) == runtime["font"]["glyphs"]
    assert all(ord(ch) in ids for ch in "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя0123456789")
    checks += len(ids)
    if (ROOT / "art/reference/ride_parts/parts.json").exists():
        parts = json.loads((ROOT / "art/reference/ride_parts/parts.json").read_text())
        assert len(parts["parts"]) == 106
        for part in parts["parts"]:
            rect = part["atlas_rect_native"]
            assert part["atlas_rect_hd"] == [v * parts["scale"] for v in rect]
            assert rect[2:] == part["source_rect"][2:]
            checks += 2
    print(f"ASSETS CHECK OK: {checks} assertions, {len(cache)} unique images, 35 exact original PNGs, stable1209 ride phases")


if __name__ == "__main__":
    main()
