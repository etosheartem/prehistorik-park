#!/usr/bin/env python3
"""Reconcile remake attachments with painted silhouettes, preserving source data.

Structural coaster segments use the locally upscaled source geometry: independently
painted miniature segments cannot guarantee matching joints. Rope endpoints snap
at most four logical pixels to actual opaque pixels of neighboring painted parts.
"""
import copy
import json
import shutil
from pathlib import Path

import numpy as np
from PIL import Image

ROOT = Path(__file__).resolve().parents[1]
HD = ROOT / "game/assets/hd"


def main():
    source = json.loads((ROOT / "game/assets/original/commands.json").read_text())
    parts = json.loads((HD / "part_manifest.json").read_text())
    upscale = json.loads((ROOT / "game/assets/upscaled/part_manifest.json").read_text())
    repairs = {}
    out = HD / "parts/structural"
    out.mkdir(exist_ok=True)
    for key, entry in upscale.items():
        if not key.startswith("1:12:"):
            continue
        filename = key.replace(":", "_") + ".png"
        shutil.copy2(ROOT / "game" / entry["path"].removeprefix("res://"), out / filename)
        repairs[key] = dict(entry, path="res://assets/hd/parts/structural/" + filename)
    parts.update(repairs)
    commands = copy.deepcopy(source)
    pixels = {}
    for key, entry in parts.items():
        path = ROOT / "game" / entry["path"].removeprefix("res://")
        if path.suffix != ".png":
            continue
        alpha = np.asarray(Image.open(path).convert("RGBA"))[:, :, 3]
        ys, xs = np.where(alpha >= 180)
        scale = np.array([alpha.shape[1] / int(key.split(":")[-2]), alpha.shape[0] / int(key.split(":")[-1])])
        pixels[key] = (np.column_stack([xs, ys]) + 0.5) / scale
    changed = 0
    for frames in commands["rides"]:
        for frame in frames:
            sprites = []
            for cmd in frame:
                if cmd[0] != 0:
                    continue
                key = ":".join(map(str, cmd[1:7]))
                if key in pixels:
                    sprites.append(pixels[key] + np.array(cmd[7:9]))
            if not sprites:
                continue
            cloud = np.concatenate(sprites)
            for cmd in frame:
                if cmd[0] != 1:
                    continue
                for offset in (1, 3):
                    point = np.array(cmd[offset:offset + 2], dtype=float)
                    distances = np.square(cloud - point).sum(axis=1)
                    nearest = int(distances.argmin())
                    if 0.7 ** 2 < distances[nearest] <= 4.0 ** 2:
                        cmd[offset:offset + 2] = [round(float(x), 3) for x in cloud[nearest]]
                        changed += 1
    (HD / "structural_manifest.json").write_text(json.dumps(repairs, indent=2) + "\n")
    (HD / "commands_repaired.json").write_text(json.dumps(commands, separators=(",", ":")) + "\n")
    report = {"structural_parts": len(repairs), "attached_rope_endpoints": changed, "max_attachment_correction_logical_pixels": 4, "source_commands_unchanged": True}
    (ROOT / "art/local/geometry_report.json").write_text(json.dumps(report, indent=2) + "\n")
    print(report)


if __name__ == "__main__":
    main()
