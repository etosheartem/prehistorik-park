#!/usr/bin/env python3
"""All 25 guest body/head pieces plus walking guard/repair references; no unused cook."""
from __future__ import annotations

import json
from pathlib import Path
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "art/reference/actors_full"
LAYOUTS = {"guest": {"columns": 10, "rows": 5, "cell": (256, 512)},
           "workers": {"columns": 6, "rows": 4, "cell": (384, 576)}}


def main() -> None:
    graphics = json.loads((ROOT / "game/assets/original/graphics.json").read_text())
    OUT.mkdir(parents=True, exist_ok=True)
    sheets = []
    entries = []
    for atlas_id in range(5):
        is_worker = atlas_id == 4
        layout = LAYOUTS["workers" if is_worker else "guest"]
        cols, rows = layout["columns"], layout["rows"]
        cell_w, cell_h = layout["cell"]
        sheet = Image.new("RGBA", (cols * cell_w, rows * cell_h))
        actor_ids = [8, 9] if is_worker else [atlas_id * 2, atlas_id * 2 + 1]
        for block, actor_id in enumerate(actor_ids):
            actor = graphics["actors"][actor_id]
            frames = [(name, phase, frame) for name, animation in actor["animations"].items()
                      for phase, frame in enumerate(animation["frames"])
                      if not is_worker or name.startswith("walk_")]
            max_width = max(frame["rect"][2] for _, _, frame in frames)
            max_height = max(frame["rect"][3] for _, _, frame in frames)
            scale = min(cell_w * .80 / max_width, cell_h * .82 / max_height)
            for index, (name, phase, frame) in enumerate(frames):
                if is_worker:
                    col, row = block * 3 + index % 3, index // 3
                else:
                    col, row = block * 5 + index % 5, index // 5
                source = Image.open(ROOT / "game" / frame["path"].removeprefix("res://")).convert("RGBA")
                assert source.getchannel("A").getbbox(), f"Empty requested actor source: {frame['path']}"
                width, height = (max(1, round(n * scale)) for n in source.size)
                x = round(col * cell_w + (cell_w - width) / 2)
                y = round((row + 1) * cell_h - cell_h * .08 - height)
                sheet.alpha_composite(source.resize((width, height), Image.Resampling.NEAREST), (x, y))
                entries.append({"id": len(entries), "actor": actor_id, "animation": name, "phase": phase,
                                "atlas": atlas_id, "cell": [col, row], "path": frame["path"],
                                "source_size": list(source.size), "source_offset": frame["offset"],
                                "atlas_rect": [x, y, width, height], "scale": scale,
                                "part_kind": "head" if name == "special" else "body"})
        filename = f"atlas_{atlas_id}.png"
        sheet.save(OUT / filename)
        review = Image.new("RGBA", sheet.size, (215, 220, 196, 255))
        review.alpha_composite(sheet)
        draw = ImageDraw.Draw(review)
        for entry in [entry for entry in entries if entry["atlas"] == atlas_id]:
            col, row = entry["cell"]
            draw.rectangle((col*cell_w,row*cell_h,(col+1)*cell_w-1,(row+1)*cell_h-1), outline=(105, 120, 80))
            draw.text((col*cell_w+5,row*cell_h+5), f"{entry['actor']}: {entry['animation']} {entry['phase']}", fill=(20, 30, 10))
        review.convert("RGB").save(OUT / f"review_{atlas_id}.png")
        sheets.append({"id": atlas_id, "file": filename, "size": list(sheet.size), "columns": cols,
                       "rows": rows, "cell_size": list(layout["cell"]), "actors": actor_ids,
                       "entries": sum(1 for entry in entries if entry["atlas"] == atlas_id)})
    data = {"schema": 1, "atlases": sheets, "parts": entries,
            "contract": ["Guests: each five-column half belongs to one character; 25 pieces each.",
                         "First 18 pieces of each guest are body poses; final seven are isolated head pieces, never add bodies to those.",
                         "Workers: three adjacent columns per actor, rows are the four original directions.",
                         "All pieces of an actor share scale. Keep every pose, side, orientation, silhouette and alpha hole.",
                         "Restore source_size and source_offset at runtime; atlas placement is for generation only.",
                         "Actor10 cook is intentionally excluded: its unused walking table contains five empty pieces."]}
    (OUT / "actors.json").write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n")
    print(f"FULL ACTOR REFERENCES OK: {len(entries)} pieces, 8 guests + guard/repair, 5 sheets")


if __name__ == "__main__":
    main()
