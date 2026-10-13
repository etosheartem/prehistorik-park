"""Deterministic sprite-atlas layout repairs used by the existing installer."""
from collections import deque
from pathlib import Path
import subprocess

import numpy as np
from PIL import Image


def components(mask):
    visited = ~mask.copy()
    result = []
    for y, x in zip(*np.where(mask)):
        if visited[y, x]:
            continue
        queue = deque([(y, x)])
        visited[y, x] = True
        points = []
        while queue:
            py, px = queue.popleft()
            points.append((py, px))
            for dy in (-1, 0, 1):
                for dx in (-1, 0, 1):
                    ny, nx = py+dy, px+dx
                    if 0 <= ny < mask.shape[0] and 0 <= nx < mask.shape[1] and not visited[ny, nx]:
                        visited[ny, nx] = True
                        queue.append((ny, nx))
        result.append(points)
    return result


def box(points):
    ys, xs = np.array(points).T
    return tuple(map(int, (xs.min(), ys.min(), xs.max()+1, ys.max()+1)))


def align_scattered(cell, original, scale):
    """Fit separated stones independently, retaining every source stone/shard.

    A single bounding box let a near-transparent provider artifact determine the
    height of the entire burst, moving bottom stones above their source anchors.
    """
    old_parts = sorted(components(np.asarray(original.getchannel('A')) > 32), key=len, reverse=True)
    new_parts = sorted(components(np.asarray(cell.getchannel('A')) > 100), key=len, reverse=True)
    if not old_parts or not new_parts:
        raise ValueError('Scattered-stone source or replacement is empty')
    new_parts = [p for p in new_parts if len(p) >= max(4, len(new_parts[0])*.002)]
    bounds = cell.getchannel('A').point(lambda a: 255 if a > 100 else 0).getbbox()
    bx, by, ex, ey = bounds
    available = list(range(len(new_parts)))
    target = Image.new('RGBA', (original.width*scale, original.height*scale))
    placements = []
    for points in old_parts:
        x1, y1, x2, y2 = box(points)
        center = np.array([(x1+x2)/2/original.width, (y1+y2)/2/original.height])
        # Match the large stones first, then their small fragments.
        choices = available[:max(1, min(8, len(available)))] if len(points) > 8 else available
        if not choices:
            choices = list(range(len(new_parts)))
        def distance(index):
            nx, ny, ne, nb = box(new_parts[index])
            return float(np.square(center - [(nx+ne-2*bx)/2/(ex-bx), (ny+nb-2*by)/2/(ey-by)]).sum())
        chosen = min(choices, key=distance)
        if chosen in available:
            available.remove(chosen)
        donor_box = box(new_parts[chosen])
        crop = cell.crop(donor_box).resize(((x2-x1)*scale, (y2-y1)*scale), Image.Resampling.LANCZOS)
        target.alpha_composite(crop, (x1*scale, y1*scale))
        placements.append({'source_box': [x1,y1,x2,y2], 'donor_box': list(donor_box), 'source_pixels': len(points)})
    return target, placements


def growl_bubble(root: Path, scale: int):
    """A vector speech balloon with outlined lettering, matching the 24×13 slot."""
    # Letter outlines make the shipped SVG independent of installed fonts.
    letters = '''<path d="M6.6 4.9C6.2 4.1 4.7 4.05 4.15 4.9C3.65 5.8 3.65 7.7 4.2 8.5C4.8 9.25 6.15 9.15 6.65 8.4V6.6H5.25V7.55H5.65V8.15C5.15 8.5 4.65 8.15 4.65 6.6C4.65 5.25 5.1 4.85 5.85 5.4Z"/>
<path d="M7.7 4.25H9.35C11.5 4.25 11.5 7.05 10.25 7.35L11.55 9H10.3L9.05 7.5H8.8V9H7.7ZM8.8 5.25V6.55H9.25C10.15 6.55 10.15 5.25 9.25 5.25Z" fill-rule="evenodd"/>
<path d="M12.25 4.25H13.9C16.05 4.25 16.05 7.05 14.8 7.35L16.1 9H14.85L13.6 7.5H13.35V9H12.25ZM13.35 5.25V6.55H13.8C14.7 6.55 14.7 5.25 13.8 5.25Z" fill-rule="evenodd"/>
<path d="M17.1 4.15H18.4L18.15 7.45H17.35ZM17.25 8H18.25V9H17.25Z"/>'''
    svg = f'''<svg xmlns="http://www.w3.org/2000/svg" width="{24*scale}" height="{13*scale}" viewBox="0 0 24 13">
<defs><linearGradient id="paper" x2="0" y2="1"><stop stop-color="#fff5d7"/><stop offset="1" stop-color="#dec795"/></linearGradient></defs>
<path d="M3.1 9.8L.6 11.3L1.9 8.5C.65 4.2 3.9 1.3 8.1 1.45Q11.5 .15 15.4 1.5C20.6 .6 23.4 3.8 22.8 7.1C23.55 10.8 19.8 11.9 16.2 11.45Q10.6 12.65 6.2 11.25Z" fill="url(#paper)" stroke="#715839" stroke-width=".45" stroke-linejoin="round"/>
<path d="M3.45 3.75Q4.8 2.5 7.7 2.65M18.1 2.55Q21.2 2.6 21.7 4.6" fill="none" stroke="#fff9e9" stroke-width=".35" stroke-linecap="round"/>
<g fill="#392d22" transform="translate(.5 -.15)">{letters}</g></svg>\n'''
    path = root / 'art/reference/local/growl_bubble.svg'
    path.write_text(svg)
    dest = root / 'art/review/parts/crops/local/growl_bubble.png'
    dest.parent.mkdir(parents=True, exist_ok=True)
    subprocess.run(['rsvg-convert', str(path), '-o', str(dest)], check=True)
    return (1, 2, 100, 60, 24, 13), dest, Image.open(dest).convert('RGBA')
