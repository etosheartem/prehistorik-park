#!/usr/bin/env python3
"""Recover provider-discarded colored pieces without repainting or another API call.

Only reviewed cells are touched. Their saved RGB still contains the entire art;
the provider alpha mistakenly removed small stones and water splashes. A chroma
mask separates these brown/blue subjects from the neutral baked RGB checkerboard.
Raw provider PNGs and their hashes stay immutable. Small highlight holes are
filled; large gaps between stones and inside splashes remain transparent.
"""
from collections import deque
import hashlib
import json
from pathlib import Path
import numpy as np
from PIL import Image, ImageFilter

ROOT = Path(__file__).resolve().parents[1]
CELLS = {2: [(0, 3)], 5: [(2, 0), (3, 0), (0, 1), (1, 1)]}


def fill_small_holes(mask, maximum=100):
    height, width = mask.shape
    visited = mask.copy()
    for y, x in zip(*np.where(~mask)):
        if visited[y, x]:
            continue
        queue = deque([(y, x)])
        visited[y, x] = True
        area, edge = [], False
        while queue:
            cy, cx = queue.popleft()
            area.append((cy, cx))
            edge |= cx == 0 or cy == 0 or cx == width - 1 or cy == height - 1
            for ny, nx in ((cy - 1, cx), (cy + 1, cx), (cy, cx - 1), (cy, cx + 1)):
                if 0 <= ny < height and 0 <= nx < width and not visited[ny, nx]:
                    visited[ny, nx] = True
                    queue.append((ny, nx))
        if not edge and len(area) <= maximum:
            for cy, cx in area:
                mask[cy, cx] = True
    return mask


def main():
    out = ROOT / 'art/corrected'
    out.mkdir(exist_ok=True)
    reports = []
    for atlas, cells in CELLS.items():
        source = ROOT / f'art/raw/ride_parts_{atlas}_2k_v1.png'
        image = Image.open(source).convert('RGBA')
        cw, ch = image.width // 4, image.height // 4
        touched = []
        for cx, cy in cells:
            box = (cx * cw, cy * ch, (cx + 1) * cw, (cy + 1) * ch)
            cell = np.asarray(image.crop(box)).copy()
            rgb = cell[:, :, :3].astype(np.int16)
            chroma = rgb.max(axis=2) - rgb.min(axis=2)
            # Brown stone and blue-water chroma are far above neutral background.
            alpha = np.clip((chroma - 4) * (255 / 9), 0, 255).astype(np.uint8)
            mask = fill_small_holes(alpha > 100)
            alpha[mask] = np.maximum(alpha[mask], 255)
            before = int((cell[:, :, 3] > 16).sum())
            cell[:, :, 3] = np.maximum(cell[:, :, 3], alpha)
            after = int((cell[:, :, 3] > 16).sum())
            image.paste(Image.fromarray(cell), box)
            touched.append({'cell': [cx, cy], 'alpha_pixels_before': before,
                            'alpha_pixels_after': after, 'method': 'chroma + small highlight holes'})
        destination = out / source.name
        image.save(destination)
        reports.append({'source': str(source.relative_to(ROOT)),
                        'source_sha256': hashlib.sha256(source.read_bytes()).hexdigest(),
                        'output': str(destination.relative_to(ROOT)),
                        'output_sha256': hashlib.sha256(destination.read_bytes()).hexdigest(),
                        'cells': touched, 'api_cost_usd': 0})
    (out / 'alpha_repairs.json').write_text(json.dumps(reports, indent=2) + '\n')
    print(json.dumps(reports, indent=2))


if __name__ == '__main__':
    main()
