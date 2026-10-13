#!/usr/bin/env python3
"""Prepare walking-pose references, sharing one fixed scale and anchor per actor."""
from __future__ import annotations

import json
from pathlib import Path
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "art/reference/actors"
CELL = (256, 576)
SIZE = (CELL[0] * 9, CELL[1] * 4)


def main() -> None:
    graphics = json.loads((ROOT / "game/assets/original/graphics.json").read_text())
    OUT.mkdir(parents=True, exist_ok=True)
    atlas_images = [Image.new("RGBA", SIZE) for _ in range(4)]
    parts = []
    actors = []
    for actor in graphics["actors"]:
        actor_id = actor["id"]
        frames = [frame for name, animation in actor["animations"].items() if name.startswith("walk_") for frame in animation["frames"]]
        left = min(frame["offset"][0] for frame in frames)
        right = max(frame["offset"][0] + frame["rect"][2] for frame in frames)
        top = min(frame["offset"][1] for frame in frames)
        scale = min(CELL[0] * .80 / (right - left), CELL[1] * .85 / -top)
        atlas_id = actor_id // 3
        actor_column = actor_id % 3 * 3
        actors.append({"id": actor_id, "atlas": atlas_id, "column_start": actor_column, "scale": scale})
        for direction in range(4):
            animation = actor["animations"][f"walk_{direction}"]
            for phase, frame in enumerate(animation["frames"]):
                image = Image.open(ROOT / "game" / frame["path"].removeprefix("res://")).convert("RGBA")
                column = actor_column + phase
                width, height = (max(1, round(length * scale)) for length in image.size)
                x = round(column * CELL[0] + CELL[0] / 2 + frame["offset"][0] * scale)
                y = round((direction + 1) * CELL[1] - CELL[1] * .08 + frame["offset"][1] * scale)
                atlas_images[atlas_id].alpha_composite(image.resize((width, height), Image.Resampling.NEAREST), (x, y))
                parts.append({"id": len(parts), "actor": actor_id, "direction": direction, "phase": phase,
                              "atlas": atlas_id, "cell": [column, direction], "path": frame["path"],
                              "source_size": list(image.size), "source_offset": frame["offset"],
                              "atlas_rect": [x, y, width, height], "scale": scale,
                              "sequence": animation["sequence"]})
    for index, image in enumerate(atlas_images):
        image.save(OUT / f"atlas_{index}.png")
        review = Image.new("RGBA", SIZE, (211, 220, 191, 255))
        review.alpha_composite(image)
        draw = ImageDraw.Draw(review)
        for part in parts:
            if part["atlas"] != index:
                continue
            col, row = part["cell"]
            draw.rectangle((col*CELL[0], row*CELL[1], (col+1)*CELL[0]-1, (row+1)*CELL[1]-1), outline=(100, 120, 80))
            draw.text((col*CELL[0]+8, row*CELL[1]+8), f"actor {part['actor']} dir {part['direction']} phase {part['phase']}", fill=(20, 25, 15))
        review.convert("RGB").save(OUT / f"review_{index}.png")
    document = {"schema": 1, "columns": 9, "rows": 4, "cell_size": list(CELL), "atlas_size": list(SIZE),
                "actors": actors, "parts": parts,
                "contract": ["Three adjacent columns form three phases of one actor; rows are four original directions.",
                             "Per-actor scale and foot anchor are shared across all twelve frames.",
                             "Only walking poses are included. Sitting/ride/special poses keep original assets unless separately remastered.",
                             "Preserve direction, phase, full silhouette, ground contact and costume; true transparent alpha required."]}
    (OUT / "actors.json").write_text(json.dumps(document, ensure_ascii=False, indent=2) + "\n")
    print(f"ACTOR REFERENCES OK: {len(actors)} actors, {len(parts)} walking frames, 4 sheets")


if __name__ == "__main__":
    main()
