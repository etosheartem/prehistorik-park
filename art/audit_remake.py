#!/usr/bin/env python3
"""Inventory and compare every source part and replacement without changing art.

Contact sheets always put the original on the left and the installed remake on
the right, at identical logical dimensions. Coverage is a review aid, not a
substitute for inspecting the drawing or its assembled animation.
"""
import argparse
from collections import Counter
import hashlib
import io
import json
from pathlib import Path
import subprocess

import numpy as np
from PIL import Image, ImageDraw, ImageFont
from repair_parts import components

ROOT = Path(__file__).resolve().parents[1]
GAME = ROOT / 'game'
HD = GAME / 'assets/hd'
FONT = ImageFont.truetype(str(GAME / 'assets/ui/fonts/NotoSans-Regular.ttf'), 16)


def read(path):
    return json.loads(path.read_text())


def local(path):
    return GAME / path.removeprefix('res://')


def image(path):
    path = Path(path)
    if path.suffix == '.svg':
        return Image.open(io.BytesIO(subprocess.check_output(['rsvg-convert', str(path)]))).convert('RGBA')
    return Image.open(path).convert('RGBA')


def source_part(key):
    pack, index, x, y, w, h = map(int, key.split(':'))
    if (pack, index) == (1, 7):
        pack, index = 0, 10
    return image(GAME / f'assets/original/packs/gpack{pack}_{index}.png').crop((x, y, x+w, y+h))


def metrics(original, remake):
    a = np.asarray(original.getchannel('A')) > 64
    b = np.asarray(remake.getchannel('A').resize(original.size, Image.Resampling.BOX)) > 64
    coverage = float((a & b).sum() / max(1, a.sum()))
    missing = []
    for points in components(a):
        if len(points) < 3:
            continue
        ys, xs = np.array(points).T
        matched = float(b[ys, xs].mean())
        if matched < 0.3:
            missing.append({'pixels': len(points), 'bbox': [int(xs.min()), int(ys.min()), int(xs.max()+1), int(ys.max()+1)], 'coverage': round(matched, 3)})
    return {'source_coverage': round(coverage, 3), 'source_components': len(components(a)), 'possibly_missing_components': missing}


def sheets(records, output, group):
    output.mkdir(parents=True, exist_ok=True)
    for start in range(0, len(records), 16):
        page = Image.new('RGB', (1600, 1240), '#273629')
        draw = ImageDraw.Draw(page)
        draw.text((12, 8), f'{group}: ORIGINAL / REMAKE — {start+1}–{min(start+16, len(records))}', font=FONT, fill='white')
        for slot, (record, old, new) in enumerate(records[start:start+16]):
            x, y = (slot % 4)*400, 40+(slot//4)*300
            draw.text((x+8, y+4), record['label'][:40], font=FONT, fill='white')
            detail = f"coverage {record['source_coverage']:.0%} · " if record.get('source_coverage') is not None else ''
            draw.text((x+8, y+25), detail + record['status'], font=FONT, fill='#c5cbb7')
            ratio = min(182/old.width, 237/old.height)
            size = (max(1, round(old.width*ratio)), max(1, round(old.height*ratio)))
            for side, im in enumerate((old, new)):
                im = im.resize(size, Image.Resampling.NEAREST if side == 0 else Image.Resampling.LANCZOS)
                page.paste(im, (x+side*200+(200-im.width)//2, y+55+(240-im.height)//2), im)
            draw.line((x+199, y+55, x+199, y+295), fill='#61735d')
        page.save(output / f'{group}_{start//16:02d}.jpg', quality=94)


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--out', default='art/review/remake_audit')
    args = parser.parse_args()
    out = ROOT / args.out
    out.mkdir(parents=True, exist_ok=True)
    parts = read(HD/'part_manifest.json')
    parts.update(read(HD/'structural_manifest.json'))
    inventory = []
    grouped = {}
    all_keys = sorted(read(GAME/'assets/upscaled/part_manifest.json'), key=lambda k: tuple(map(int, k.split(':'))))
    for index, key in enumerate(all_keys):
        old = source_part(key)
        entry = parts.get(key)
        new = image(local(entry['path'])) if entry else old
        if entry and entry.get('flip_x'):
            new = new.transpose(Image.Transpose.FLIP_LEFT_RIGHT)
        group = Path(entry['path']).parent.name if entry else 'fallback'
        record = {'key': key, 'label': f'{index:03d} {group} {Path(entry["path"]).stem if entry else key}', 'kind': 'part', 'status': 'remake' if entry else 'original fallback', 'replacement': entry, **metrics(old, new)}
        inventory.append(record)
        grouped.setdefault('parts', []).append((record, old, new))
    mappings = read(HD/'manifest.json')
    mappings.update(read(HD/'terrain/manifest.json'))
    for key, entry in sorted(mappings.items()):
        old, new = image(local(key)), image(local(entry['path']))
        group = 'actors' if '/actors/' in key else 'cards' if entry.get('installer') == 'part_cards' else 'terrain_and_vectors'
        record = {'key': key, 'label': key.removeprefix('res://assets/original/'), 'kind': group, 'status': 'remake', 'replacement': entry, **metrics(old, new)}
        inventory.append(record)
        grouped.setdefault(group, []).append((record, old, new))
    # Source frames without a remake are still part of the inventory. Edge
    # frames are already covered by the 192 atlas rectangles above; assembled
    # rides/scenery are covered by commands and the real-renderer audit.
    graphics = read(GAME/'assets/original/graphics.json')
    refs = set()
    def collect(value):
        if isinstance(value, dict):
            if isinstance(value.get('path'), str): refs.add(value['path'])
            for child in value.values(): collect(child)
        elif isinstance(value, list):
            for child in value: collect(child)
    collect(graphics['actors'])
    collect({key:value for key,value in graphics['tiles'].items() if key != 'edges'})
    for key in sorted(refs - mappings.keys()):
        old = image(local(key))
        status = 'unchanged source' if old.getchannel('A').getbbox() else 'empty in source and remake'
        record = {'key':key, 'label':key.removeprefix('res://assets/original/'), 'kind':'source_passthrough', 'status':status, 'replacement':None, **metrics(old, old)}
        inventory.append(record)
        grouped.setdefault('source_passthrough', []).append((record, old, old))
    for group, records in grouped.items():
        sheets(records, out, group)
    for record in inventory:
        entry = record.get('replacement')
        if entry:
            record['replacement_sha256'] = hashlib.sha256(local(entry['path']).read_bytes()).hexdigest()
    report = {'groups': dict(Counter(r['kind'] for r in inventory)), 'comparisons': len(inventory), 'records': inventory}
    (out/'inventory.json').write_text(json.dumps(report, ensure_ascii=False, indent=2)+'\n')
    print(json.dumps({k:v for k,v in report.items() if k != 'records'}, ensure_ascii=False))
    candidates = sorted(inventory, key=lambda r: r['source_coverage'])
    for record in candidates[:30]:
        print(f"{record['source_coverage']:.0%} {record['label']} components={record['possibly_missing_components']}")


if __name__ == '__main__':
    main()
