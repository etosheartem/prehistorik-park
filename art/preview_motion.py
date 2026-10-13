#!/usr/bin/env python3
"""Create small review animations from HD frames already assembled outside game/."""
import argparse
import json
from pathlib import Path
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parent.parent


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('rides', nargs='*', type=int, default=[0, 3, 19])
    args = parser.parse_args()
    meta = json.loads((ROOT / 'original/export/graphics.json').read_text())
    review = ROOT / 'art/review/parts'
    for ride_id in args.rides:
        ride = meta['rides'][ride_id]
        stride = max(1, len(ride['frames']) // 32)
        frames = []
        for phase in range(0, len(ride['frames']), stride):
            filename = Path(ride['frames'][phase]['path']).name
            source = review / 'rides' / str(ride_id) / 'working' / filename
            sprite = Image.open(source).convert('RGBA')
            sprite.thumbnail((600, 600), Image.Resampling.LANCZOS)
            canvas = Image.new('RGB', (640, 650), (39, 52, 37))
            canvas.paste(sprite, ((640 - sprite.width) // 2, 35 + (600 - sprite.height) // 2), sprite)
            ImageDraw.Draw(canvas).text((12, 12), f'Ride {ride_id} / original phase {phase}', fill='white')
            frames.append(canvas)
        frames[0].save(review / f'ride_{ride_id}_complete.gif', save_all=True, append_images=frames[1:],
                       duration=100 * stride, loop=0, disposal=2)
        phases = [frames[int(i * (len(frames) - 1) / 3)] for i in range(4)]
        strip = Image.new('RGB', (1280, 1300))
        for i, frame in enumerate(phases): strip.paste(frame, (i % 2 * 640, i // 2 * 650))
        strip.save(review / f'ride_{ride_id}_phases.png')
        print(f'MOTION REVIEW: ride {ride_id}, {len(ride["frames"])} original phases, {len(frames)} GIF samples')


if __name__ == '__main__':
    main()
