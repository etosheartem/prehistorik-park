#!/usr/bin/env python3
"""Crop reviewed HD actor sheets at original bounds/anchors, with local QA.

No network calls. Native generated atlas files are kept untouched in art/raw.
Only the reviewed frames are installed; other manifest owners are preserved.
"""
from __future__ import annotations
import argparse
import hashlib
import json
from pathlib import Path
import re
import numpy as np
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parents[1]
REVIEW = ROOT / 'art/review/actors'
HD = ROOT / 'game/assets/hd'


def load(path):
    return json.loads(path.read_text())


def write(path, value):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=2) + '\n')


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--install', action='store_true')
    parser.add_argument('--allow-warnings', action='store_true')
    parser.add_argument('--scale', type=int, default=8)
    args = parser.parse_args()
    assert 2 <= args.scale <= 16
    contract = load(ROOT / 'art/reference/actors_full/actors.json')
    sheets = {a['id']: a for a in contract['atlases']}
    selections_path = ROOT / 'art/actor_selections.json'
    selections = load(selections_path) if selections_path.exists() else {}
    REVIEW.mkdir(parents=True, exist_ok=True)
    report = {'schema': 1, 'scale': args.scale, 'atlases': [], 'frames': [], 'installed': False}
    frames, originals, entries = {}, {}, {}
    for path in sorted((ROOT / 'art/raw').glob('actors_full_*_2k_v1.png')):
        atlas_id = int(re.search(r'full_(\d+)_', path.name).group(1))
        selection = selections.get(str(atlas_id), {})
        if selection.get('status') == 'rejected':
            report.setdefault('excluded_atlases', []).append({'id': atlas_id, **selection})
            continue
        if selection.get('path'):
            path = ROOT / selection['path']
        if selection.get('sha256') and hashlib.sha256(path.read_bytes()).hexdigest() != selection['sha256']:
            raise ValueError(f'Accepted atlas {atlas_id} changed since visual QA')
        definition = sheets[atlas_id]
        image = Image.open(path).convert('RGBA')
        zero = float((np.asarray(image.getchannel('A')) == 0).mean())
        if zero < .05:
            raise ValueError(f'Atlas {atlas_id} lacks real transparency')
        report['atlases'].append({'id': atlas_id, 'size': list(image.size),
                                 'source': str(path.relative_to(ROOT)), 'alpha_zero_fraction': zero,
                                 'sha256': hashlib.sha256(path.read_bytes()).hexdigest()})
        cw, ch = image.width / definition['columns'], image.height / definition['rows']
        for part in (p for p in contract['parts'] if p['atlas'] == atlas_id):
            cx, cy = part['cell']
            box = (round(cx*cw), round(cy*ch), round((cx+1)*cw), round((cy+1)*ch))
            if atlas_id == 3:
                # The accepted style pass shifted complete rows, leaving wide
                # transparent separators. Cut there rather than through feet.
                row_edges = [0, 480, 910, 1310, 1710, 2048]
                box = (box[0], row_edges[cy], box[2], row_edges[cy+1])
                if part['actor'] == 6 and part['animation'] == 'ride' and part['phase'] in (1, 2):
                    box = (0, box[1], 225, box[3]) if part['phase'] == 1 else (225, box[1], box[2], box[3])
            # Guest2's leaning pose extends two pixels into the neighboring cell.
            # Keep the whole component and exclude its sliver from the upright pose.
            if part['actor'] == 2 and part['animation'] == 'ride' and part['phase'] in (1, 2):
                box = (0, box[1], 220, box[3]) if part['phase'] == 1 else (225, box[1], box[2], box[3])
            if part['actor'] == 4 and part['animation'] == 'walk_1' and part['phase'] == 0:
                box = (box[0], box[1], box[2], box[3]+20)
            if part['actor'] == 8 and part['animation'] == 'walk_2':
                box = (box[0], box[1], box[2], 1456)
            if part['actor'] == 8 and part['animation'] == 'walk_3':
                box = (box[0], 1456, box[2], box[3])
            cell = image.crop(box)
            bounds = cell.getchannel('A').point(lambda a: 255 if a > 16 else 0).getbbox()
            old = Image.open(ROOT / 'game' / part['path'].removeprefix('res://')).convert('RGBA')
            old_bounds = old.getchannel('A').getbbox()
            info = {k: part[k] for k in ('id', 'actor', 'animation', 'phase', 'atlas', 'cell', 'path', 'part_kind')}
            info.update(source_size=part['source_size'], source_offset=part['source_offset'],
                        source_alpha_bbox=old_bounds, generated_alpha_bbox=bounds)
            if not bounds:
                info['warning'] = 'Empty generated alpha: original retained'
                report['frames'].append(info)
                continue
            x1, y1, x2, y2 = old_bounds
            crop = cell.crop(bounds)
            target = Image.new('RGBA', (old.width*args.scale, old.height*args.scale))
            crop = crop.resize(((x2-x1)*args.scale, (y2-y1)*args.scale), Image.Resampling.LANCZOS)
            target.alpha_composite(crop, (x1*args.scale, y1*args.scale))
            mask = np.asarray(old.getchannel('A').resize(target.size, Image.Resampling.NEAREST)) > 32
            generated = np.asarray(target.getchannel('A')) > 32
            coverage = float((mask & generated).sum() / max(1, mask.sum()))
            iou = float((mask & generated).sum() / max(1, (mask | generated).sum()))
            info.update(aligned_size=list(target.size), original_coverage=round(coverage, 4),
                        silhouette_iou=round(iou, 4),
                        cell_padding=min(bounds[0], bounds[1], cell.width-bounds[2], cell.height-bounds[3]))
            if info['cell_padding'] < 2:
                info['warning'] = 'Cell boundary touched: review adjacent sprite contamination'
            if coverage < .45 or iou < .3:
                info['warning'] = 'Large pose/silhouette difference: review required'
            relative = Path('actors') / str(part['actor']) / f"{part['animation']}_{part['phase']}.png"
            destination = REVIEW / 'crops' / relative
            destination.parent.mkdir(parents=True, exist_ok=True)
            target.save(destination)
            info['output'] = 'res://assets/hd/' + str(relative)
            frames[part['path']], originals[part['path']], entries[part['path']] = target, old, part
            report['frames'].append(info)
    # Reviewed pilot errors: the model turned two rear-view phases toward camera.
    # Reuse the matching good opposite view rather than paying for another sheet.
    # The original per-frame dimensions and attachment offsets are still retained.
    repairs = [(actor, 'walk_3', phase, 'walk_2', phase, True)
               for actor in (0, 1) for phase in (1, 2)]
    repairs += [(0, 'walk_1', 2, 'walk_0', 2, True),
                (1, 'special', 2, 'special', 5, False),
                (1, 'special', 3, 'special', 5, True)]
    for actor in (2, 3):
        repairs.append((actor, 'walk_1', 2, 'walk_0', 2, False))
        repairs.extend((actor, 'walk_0', phase, 'walk_1', phase, True) for phase in range(3))
        repairs.extend((actor, 'walk_3', phase, 'walk_2', phase, True) for phase in range(3))
        # The source sitting directions are opposite to the earlier repair.
        # Keep the right-facing pose for sit_0, mirror it only for sit_1.
        repairs.extend([(actor, 'sit', 0, 'pose', 0, False), (actor, 'sit', 1, 'pose', 0, True)])
    repairs.extend((5, 'walk_2', phase, 'walk_2', phase, True) for phase in range(3))
    for actor in (4, 5):
        repairs.append((actor, 'walk_1', 2, 'walk_0', 2, True))
        repairs.extend((actor, 'walk_3', phase, 'walk_2', phase, True) for phase in range(3))
    repairs.extend([(9, 'walk_1', 0, 'walk_0', 0, True),
                    (9, 'walk_2', 1, 'walk_2', 0, False)])
    repairs.extend((9, 'walk_3', phase, 'walk_2', phase, True) for phase in range(3))
    repairs.append((6, 'walk_1', 2, 'walk_0', 2, True))
    for actor in (6, 7):
        repairs.extend((actor, 'walk_3', phase, 'walk_2', phase, True) for phase in range(3))
    repairs.extend([(7, 'special', 2, 'special', 5, False),
                    (7, 'special', 3, 'special', 5, True)])
    for actor, animation, phase, other_animation, other_phase, flip in repairs:
        target_path = f'res://assets/original/actors/{actor}/{animation}_{phase}.png'
        source_path = f'res://assets/original/actors/{actor}/{other_animation}_{other_phase}.png'
        if target_path not in frames or source_path not in frames:
            continue
        source = frames[source_path]
        source = source.crop(source.getchannel('A').getbbox())
        if flip:
            source = source.transpose(Image.Transpose.FLIP_LEFT_RIGHT)
        bounds = originals[target_path].getchannel('A').getbbox()
        x1, y1, x2, y2 = bounds
        target = Image.new('RGBA', frames[target_path].size)
        source = source.resize(((x2-x1)*args.scale, (y2-y1)*args.scale), Image.Resampling.LANCZOS)
        target.alpha_composite(source, (x1*args.scale, y1*args.scale))
        frames[target_path] = target
        info = next(r for r in report['frames'] if r['path'] == target_path)
        info['local_repair'] = {'source': source_path, 'flip_x': flip,
                                'reason': 'Restore reviewed facing/pose from a correct same-character frame'}
        original_mask = np.asarray(originals[target_path].getchannel('A').resize(target.size, Image.Resampling.NEAREST)) > 32
        generated_mask = np.asarray(target.getchannel('A')) > 32
        info['original_coverage'] = round(float((original_mask & generated_mask).sum()/max(1, original_mask.sum())), 4)
        info['silhouette_iou'] = round(float((original_mask & generated_mask).sum()/max(1, (original_mask | generated_mask).sum())), 4)
        info['metrics_after_repair'] = True
        target.save(REVIEW / 'crops' / 'actors' / str(actor) / f'{animation}_{phase}.png')
    # Style-reference identity leaked a beard into guest6's isolated heads and
    # tilted body. Derive these pieces from his own accepted clean-shaven body.
    def replace_piece(actor, animation, phase, source, metadata):
        path = f'res://assets/original/actors/{actor}/{animation}_{phase}.png'
        old = originals[path]
        x1, y1, x2, y2 = old.getchannel('A').getbbox()
        source = source.crop(source.getchannel('A').getbbox())
        source = source.resize(((x2-x1)*args.scale, (y2-y1)*args.scale), Image.Resampling.LANCZOS)
        target = Image.new('RGBA', frames[path].size)
        target.alpha_composite(source, (x1*args.scale, y1*args.scale))
        frames[path] = target
        info = next(r for r in report['frames'] if r['path'] == path)
        info['local_repair'] = metadata
        original_mask = np.asarray(old.getchannel('A').resize(target.size, Image.Resampling.NEAREST)) > 32
        generated_mask = np.asarray(target.getchannel('A')) > 32
        info['original_coverage'] = round(float((original_mask & generated_mask).sum()/max(1, original_mask.sum())), 4)
        info['silhouette_iou'] = round(float((original_mask & generated_mask).sum()/max(1, (original_mask | generated_mask).sum())), 4)
        info['metrics_after_repair'] = True
        target.save(REVIEW / 'crops' / 'actors' / str(actor) / f'{animation}_{phase}.png')

    if 'res://assets/original/actors/6/walk_0_0.png' in frames:
        for phase, direction, rotation in [(0, 0, 0), (1, 1, 0), (2, 2, 0), (3, 3, 0),
                                           (4, 0, 90), (5, 2, 90), (6, 3, -90)]:
            source_path = f'res://assets/original/actors/6/walk_{direction}_0.png'
            body = frames[source_path]
            bounds = body.getchannel('A').getbbox()
            head = body.crop((bounds[0], bounds[1], bounds[2], bounds[1]+round((bounds[3]-bounds[1])*.43)))
            if rotation:
                head = head.rotate(rotation, Image.Resampling.BICUBIC, expand=True)
            replace_piece(6, 'special', phase, head,
                          {'source': source_path, 'head_fraction': .43, 'rotation_degrees': rotation,
                           'reason': 'Keep guest6 clean-shaven identity in every head pose'})
        source_path = 'res://assets/original/actors/6/walk_0_0.png'
        body = frames[source_path].rotate(-135, Image.Resampling.BICUBIC, expand=True)
        replace_piece(6, 'ride', 1, body,
                      {'source': source_path, 'rotation_degrees': -135,
                       'reason': 'Replace foreign bearded face with guest6 own body/face in matching tilted direction'})
    # These six source heads are byte-identical in phases 5 and 6. Independent
    # generated cells introduced a front-facing head in a rear-facing sequence.
    for actor in (1, 2, 3, 5, 6, 7):
        source_path = f'res://assets/original/actors/{actor}/special_5.png'
        target_path = f'res://assets/original/actors/{actor}/special_6.png'
        assert originals[source_path].size == originals[target_path].size
        assert originals[source_path].tobytes() == originals[target_path].tobytes()
        frames[target_path] = frames[source_path].copy()
        info = next(r for r in report['frames'] if r['path'] == target_path)
        info['local_repair'] = {'source': source_path, 'reason': 'Source phases are byte-identical; retain the same complete rear head'}
        frames[target_path].save(REVIEW / 'crops' / 'actors' / str(actor) / 'special_6.png')
    # Contact pages and anchored animation loops expose pose errors and foot jitter.
    for actor in sorted({p['actor'] for p in entries.values()}):
        actor_parts = [p for p in entries.values() if p['actor'] == actor]
        page = Image.new('RGB', (1000, 5*230), (42, 58, 44))
        draw = ImageDraw.Draw(page)
        for index, part in enumerate(actor_parts):
            x, y = index%5*200, index//5*230
            draw.text((x+6, y+6), f"{part['animation']} {part['phase']}", fill='white')
            for column, source in enumerate((originals[part['path']], frames[part['path']])):
                factor = min(88/source.width, 180/source.height)
                size = (max(1, round(source.width*factor)), max(1, round(source.height*factor)))
                view = source.resize(size, Image.Resampling.NEAREST if column == 0 else Image.Resampling.LANCZOS)
                page.paste(view, (x+column*100+(100-view.width)//2, y+32+(180-view.height)), view)
        page.save(REVIEW / f'actor_{actor}.png')
        for animation in ('walk_0', 'walk_1', 'walk_2', 'walk_3', 'sit', 'ride', 'special'):
            pieces = sorted((p for p in actor_parts if p['animation'] == animation), key=lambda p:p['phase'])
            if not pieces:
                continue
            loop = []
            for part in pieces:
                canvas = Image.new('RGB', (320, 320), (42, 58, 44))
                sprite = frames[part['path']]
                ox, oy = part['source_offset']
                canvas.paste(sprite, (160+ox*args.scale, 270+oy*args.scale), sprite)
                loop.append(canvas)
            if len(loop) > 1:
                loop[0].save(REVIEW / f'actor_{actor}_{animation}.gif', save_all=True,
                             append_images=loop[1:], duration=160, loop=0, disposal=2)
    warnings = [f for f in report['frames'] if 'warning' in f]
    report.update(frame_count=len(frames), warnings=warnings)
    write(REVIEW / 'report.json', report)
    if args.install:
        if warnings and not args.allow_warnings:
            raise SystemExit('Review warnings first; no files installed')
        # Caller coordinates with other manifest writers; read only at commit time.
        manifest_path = HD / 'manifest.json'
        manifest = load(manifest_path) if manifest_path.exists() else {}
        for source, target in frames.items():
            part = entries[source]
            relative = Path('actors') / str(part['actor']) / f"{part['animation']}_{part['phase']}.png"
            destination = HD / relative
            destination.parent.mkdir(parents=True, exist_ok=True)
            target.save(destination)
            manifest[source] = {'path': 'res://assets/hd/'+str(relative), 'installer': 'actors',
                                'logical_size': part['source_size'], 'original_offset': part['source_offset'],
                                'scale': args.scale}
        temporary = manifest_path.with_suffix('.actors.tmp')
        write(temporary, manifest)
        temporary.replace(manifest_path)
        report['installed'] = True
        write(REVIEW / 'report.json', report)
    print(json.dumps({'frames': len(frames), 'warnings': len(warnings), 'installed': report['installed']}))


if __name__ == '__main__':
    main()
