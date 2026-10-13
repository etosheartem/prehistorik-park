#!/usr/bin/env python3
"""Crop generated fixed-cell art, install reusable HD parts, reconstruct QA frames.

Entirely local, no API calls. Runtime stores reusable parts and draw commands;
only one catalog preview per object is assembled into game/. Full animations
stay in art/review/parts. Missing generated sheets use original parts.
"""
from __future__ import annotations
import argparse
import hashlib
import json
from pathlib import Path
import re
import shutil
import subprocess
import sys
import numpy as np
from PIL import Image, ImageChops, ImageDraw, ImageFilter

ROOT = Path(__file__).resolve().parent.parent
REVIEW = ROOT / 'art/review/parts'
HD = ROOT / 'game/assets/hd'
sys.path.insert(0, str(ROOT / 'original'))
from scenery_geometry import commands_for as scenery_commands


def write_json(path, value, compact=False):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(value, ensure_ascii=False, indent=None if compact else 2,
                              separators=(',', ':') if compact else None) + '\n')


def path_for(pack, index):
    if (pack, index) == (1, 7):
        pack, index = 0, 10
    return ROOT / 'game/assets/original/packs' / f'gpack{pack}_{index}.png'


def key_for(part):
    return (part['source_pack'], part['source_index'], *part['source_rect'])


def key_text(key):
    return ':'.join(map(str, key))


def source_part(key):
    pack, index, x, y, width, height = key
    return Image.open(path_for(pack, index)).convert('RGBA').crop((x, y, x + width, y + height))


def fit_part(cell, original, scale):
    """Align each part once, preserving original alpha padding and all anchors."""
    new_bounds = cell.getchannel('A').point(lambda a: 255 if a > 16 else 0).getbbox()
    old_bounds = original.getchannel('A').getbbox()
    if not new_bounds or not old_bounds:
        raise ValueError('Missing sprite in generated cell')
    crop = cell.crop(new_bounds)
    x1, y1, x2, y2 = old_bounds
    target = Image.new('RGBA', (original.width * scale, original.height * scale))
    crop = crop.resize(((x2 - x1) * scale, (y2 - y1) * scale), Image.Resampling.LANCZOS)
    target.alpha_composite(crop, (x1 * scale, y1 * scale))
    source_mask = original.getchannel('A').resize(target.size, Image.Resampling.NEAREST)
    generated_mask = target.getchannel('A')
    a, b = np.asarray(source_mask) > 32, np.asarray(generated_mask) > 32
    iou = float(np.logical_and(a, b).sum() / max(1, np.logical_or(a, b).sum()))
    coverage = float(np.logical_and(a, b).sum() / max(1, a.sum()))
    envelope = original.getchannel('A').filter(ImageFilter.MaxFilter(3)).resize(target.size, Image.Resampling.LANCZOS)
    extra = float(np.logical_and(b, np.asarray(envelope) < 32).sum() / max(1, b.sum()))
    target.putalpha(ImageChops.darker(generated_mask, envelope))
    padding = min(new_bounds[0], new_bounds[1], cell.width - new_bounds[2], cell.height - new_bounds[3])
    report = {'source_alpha_bbox': old_bounds, 'generated_alpha_bbox': new_bounds,
              'silhouette_iou': round(iou, 4), 'original_coverage': round(coverage, 4),
              'clipped_outside_envelope': round(extra, 4), 'cell_padding': padding,
              'aligned_size': list(target.size)}
    if padding < 2:
        report['warning'] = 'Generated part touches cell boundary; inspect contamination.'
    if iou < 0.25 or coverage < 0.3:
        report['warning'] = 'Large silhouette difference; manual review required.'
    return target, report


def discover(group, explicit):
    result = {}
    for spec in explicit:
        number, filename = spec.split(':', 1)
        path = Path(filename)
        result[int(number)] = path if path.is_absolute() else ROOT / path
    if not explicit:
        prefix = {'rides': 'ride', 'scenery': 'scenery', 'extras': 'extras'}[group]
        for path in sorted((ROOT / 'art/raw').glob(f'{prefix}_parts_*_2k_v1.png')):
            corrected = ROOT / 'art/corrected' / path.name
            result[int(re.search(r'parts_(\d+)_', path.name).group(1))] = corrected if corrected.exists() else path
    return result


def pack_command(cmd):
    if cmd['kind'] == 'sprite':
        return [0, cmd['pack'], cmd['index'], *cmd['rect'], *cmd['offset']]
    return [1, *cmd['points'], cmd['color']]


def geometry(graphics, data):
    rides = [[list(map(pack_command, sorted(commands, key=lambda c: c['depth'])))
              for commands in ride['commands']] for ride in graphics['rides']]
    scenery = []
    for prop in data['props']:
        scenery.append({} if prop['id'] in (14, 22) else
                       {state: [list(map(pack_command, frame)) for frame in frames]
                        for state, frames in scenery_commands(prop).items()})
    return {'schema': 1, 'sprite_command': '[0,pack,index,x,y,w,h,dx,dy]',
            'line_command': '[1,x1,y1,x2,y2,rgb]', 'rides': rides, 'scenery': scenery}


def assemble(frame, commands, cache, scale):
    width, height = frame['size']
    ox, oy = frame['offset']
    canvas = Image.new('RGBA', (width * scale, height * scale))
    for cmd in commands:
        if cmd[0] == 0:
            key = tuple(cmd[1:7])
            if key not in cache:
                old = source_part(key)
                cache[key] = old.resize((old.width * scale, old.height * scale), Image.Resampling.LANCZOS)
            canvas.alpha_composite(cache[key], ((cmd[7] - ox) * scale, (cmd[8] - oy) * scale))
        else:
            color = cmd[5]
            points = [(cmd[i + 1] - (ox if i % 2 == 0 else oy)) * scale for i in range(4)]
            ImageDraw.Draw(canvas).line(points, fill=(color >> 16 & 255, color >> 8 & 255, color & 255, 255), width=scale)
    return canvas


def contact_sheets(previews, group):
    ids = sorted(previews)
    for start in range(0, len(ids), 16):
        page = Image.new('RGB', (1024, 1024), (36, 44, 35))
        draw = ImageDraw.Draw(page)
        for slot, part_id in enumerate(ids[start:start + 16]):
            original, aligned = previews[part_id]
            x, y = slot % 4 * 256, slot // 4 * 256
            draw.text((x + 8, y + 8), f'{group} part {part_id}: original / HD', fill='white')
            fit = min(110 / original.width, 225 / original.height)
            size = (max(1, round(original.width * fit)), max(1, round(original.height * fit)))
            first, second = original.resize(size, Image.Resampling.NEAREST), aligned.resize(size, Image.Resampling.LANCZOS)
            page.paste(first, (x + 7, y + 27), first)
            page.paste(second, (x + 135, y + 27), second)
        page.save(REVIEW / f'{group}_parts_{start // 16}.png')


def local_smoke(scale):
    """Code-authored vector smoke repairs a provider's rock/smoke confusion."""
    result = []
    for index, rect in enumerate([[35, 79, 6, 4], [62, 65, 8, 5], [52, 65, 10, 6]]):
        width, height = rect[2:]
        opacity = [0.68, 0.49, 0.33][index]
        svg = f'''<svg xmlns="http://www.w3.org/2000/svg" width="{width*scale}" height="{height*scale}" viewBox="0 0 100 60">
<defs><linearGradient id="tone" x2="0" y2="1"><stop stop-color="#fbf9ee"/><stop offset="1" stop-color="#b8b5ac"/></linearGradient>
<filter id="soft" x="-20%" y="-30%" width="140%" height="160%"><feGaussianBlur stdDeviation="1.5"/></filter></defs>
<g fill="url(#tone)" opacity="{opacity}" filter="url(#soft)">
<path d="M10 43C4 34 11 24 24 26C20 15 31 8 43 14C46 4 64 6 68 20C79 14 92 22 87 33C103 43 89 53 76 49C66 58 54 52 48 50C31 57 24 48 10 43Z"/>
</g></svg>'''
        vector = ROOT / 'art/reference/local' / f'cafe_smoke_{index}.svg'
        vector.parent.mkdir(parents=True, exist_ok=True); vector.write_text(svg + '\n')
        png = REVIEW / 'crops/local' / f'cafe_smoke_{index}.png'
        png.parent.mkdir(parents=True, exist_ok=True)
        subprocess.run(['rsvg-convert', str(vector), '-o', str(png)], check=True)
        result.append(((1, 2, *rect), png, Image.open(png).convert('RGBA')))
    return result


def local_micro_parts(scale):
    """Smooth code-authored wood/rope for the four remaining tiny ride pieces.

    Viewboxes use ten drawing units per source pixel. Canvas dimensions and
    source keys stay exact, so animation commands and attachment points do not
    change. The other two keep-local ride pieces are covered by local_smoke.
    """
    definitions = '''<defs>
<linearGradient id="wood"><stop stop-color="#584026"/><stop offset=".25" stop-color="#ac8850"/><stop offset=".48" stop-color="#b6955e"/><stop offset=".7" stop-color="#80613b"/><stop offset="1" stop-color="#493520"/></linearGradient>
<linearGradient id="rope" x1="0" y1="0" x2=".35" y2="1"><stop stop-color="#e2c780"/><stop offset=".45" stop-color="#b79752"/><stop offset="1" stop-color="#70532b"/></linearGradient>
</defs>'''
    diagonal = '''<path d="M1 67L1 40Q20 33 36 21Q53 8 79 1L79 22Q64 28 51 35L28 52L1 67Z" fill="url(#rope)" stroke="#554327" stroke-width="1.2" stroke-linejoin="round"/>
<path d="M3 51Q23 40 42 27Q58 16 77 11" fill="none" stroke="#ebd496" stroke-width="1.8"/>
<g fill="none" stroke="#766034" stroke-width="1.15"><path d="M6 38Q14 40 16 55M19 32Q27 34 29 48M32 24Q40 27 43 40M46 16Q52 20 55 32M60 8Q68 12 69 26"/></g>
<g fill="none" stroke="#d4b570" stroke-width="1"><path d="M9 38Q17 41 19 54M22 31Q30 34 32 46M35 23Q43 27 46 38M49 15Q55 19 58 31M63 8Q71 12 72 24"/></g>'''
    small = '''<path d="M1 1Q9 0 11 8L19 15L18 25L11 31L10 39L1 38Z" fill="url(#rope)" stroke="#574328" stroke-width="1.1"/>
<path d="M3 9L15 17M3 17L15 24M3 25L10 30" stroke="#e2c584" stroke-width="1.3" fill="none"/>
<path d="M3 11L13 18M3 20L13 26" stroke="#70552b" stroke-width="1" fill="none"/>'''
    stem = '''<path d="M11 6L38 5L39 77Q26 80 11 77Z" fill="url(#wood)" stroke="#493822" stroke-width="1.2"/>
<g fill="none" stroke-linecap="round"><path d="M16 13Q21 29 17 46T18 76M30 12Q27 29 31 43T31 76" stroke="#d2b278" stroke-width="1"/>
<path d="M21 8Q17 21 23 39T22 75M35 13Q33 34 35 55L34 77" stroke="#5e4428" stroke-width="1"/>
<path d="M25 48Q29 51 26 57Q22 54 25 48Z" stroke="#705331" stroke-width=".8"/></g>'''
    collar = '''<path d="M1 23Q25 29 49 23L49 28Q25 34 1 28Z" fill="url(#rope)" stroke="#624b2a" stroke-width="1.1"/>
<path d="M3 25Q25 31 47 25" fill="none" stroke="#dfc588" stroke-width="1"/>
<path d="M5 24L8 29M13 26L16 31M23 27L26 32M33 26L36 30M43 25L46 29" stroke="#876739" stroke-width="1"/>'''
    first = stem + '''<path d="M1 1L48 1L49 7Q25 13 1 7Z" fill="url(#rope)" stroke="#64502c" stroke-width="1.1"/>
<path d="M3 4Q25 9 47 4" fill="none" stroke="#e1ca8e" stroke-width="1.2"/>''' + collar
    # Both source caps are asymmetrical. The rear cap sits one pixel higher;
    # translate the shared lashing rather than scaling the complete post.
    second = stem + '''<ellipse cx="25" cy="4" rx="14" ry="3.2" fill="#b18c54" stroke="#564025" stroke-width="1.1"/>
<path d="M16 3Q24 1 34 4M19 5Q26 3 30 5" fill="none" stroke="#7c5b33" stroke-width=".8"/>''' + '<g transform="translate(0 -10)">' + collar + '</g>'
    result = []
    for name, key, body in [
        ('ride_rope_diagonal', (1, 0, 7, 42, 8, 7), diagonal),
        ('ride_rope_knot', (1, 0, 23, 37, 2, 4), small),
        ('trampoline_post_front', (1, 4, 61, 74, 5, 8), first),
        ('trampoline_post_rear', (1, 4, 66, 74, 5, 8), second),
    ]:
        width, height = key[-2:]
        svg = f'<svg xmlns="http://www.w3.org/2000/svg" width="{width*scale}" height="{height*scale}" viewBox="0 0 {width*10} {height*10}">{definitions}{body}</svg>\n'
        vector = ROOT / 'art/reference/local' / f'{name}.svg'
        vector.parent.mkdir(parents=True, exist_ok=True); vector.write_text(svg)
        png = REVIEW / 'crops/local' / f'{name}.png'
        png.parent.mkdir(parents=True, exist_ok=True)
        subprocess.run(['rsvg-convert', str(vector), '-o', str(png)], check=True)
        result.append((key, png, Image.open(png).convert('RGBA')))
    return result


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--atlas', action='append', default=[], metavar='NUMBER:PATH', help='Override ride sheets')
    parser.add_argument('--scenery-atlas', action='append', default=[], metavar='NUMBER:PATH')
    parser.add_argument('--extras-atlas', action='append', default=[], metavar='NUMBER:PATH')
    parser.add_argument('--scale', type=int, default=8)
    parser.add_argument('--install', action='store_true')
    parser.add_argument('--allow-warnings', action='store_true', help='Only after reviewing report warnings')
    parser.add_argument('--ride', action='append', type=int, help='Limit ride QA to these IDs')
    parser.add_argument('--no-gifs', action='store_true')
    parser.add_argument('--all-frames', action='store_true', help='Rebuild every phase for QA outside game/')
    args = parser.parse_args()
    assert 2 <= args.scale <= 16
    graphics = json.loads((ROOT / 'original/export/graphics.json').read_text())
    data = json.loads((ROOT / 'original/data/game_data.json').read_text())
    commands = geometry(graphics, data)
    report = {'schema': 2, 'scale': args.scale, 'atlases': [], 'parts': [], 'rides': [], 'scenery': [], 'installed': args.install}
    parts, crops, aliases = {}, {}, []
    REVIEW.mkdir(parents=True, exist_ok=True)
    for group, prefix, explicit in [('rides', 'ride', args.atlas), ('scenery', 'scenery', args.scenery_atlas), ('extras', 'extras', args.extras_atlas)]:
        contract_path = ROOT / f'art/reference/{prefix}_parts_normalized/parts.json'
        if not contract_path.exists():
            continue
        contract = json.loads(contract_path.read_text())
        previews = {}
        for number, path in discover(group, explicit).items():
            sheet = Image.open(path).convert('RGBA')
            zero = float((np.asarray(sheet.getchannel('A')) == 0).mean())
            if zero < 0.05:
                raise ValueError(f'{group} atlas {number} lacks transparent background ({zero:.1%})')
            report['atlases'].append({'group': group, 'id': number, 'path': str(path.relative_to(ROOT)),
                                     'size': list(sheet.size), 'alpha_zero_fraction': round(zero, 4),
                                     'sha256': hashlib.sha256(path.read_bytes()).hexdigest()})
            cw, ch = sheet.width / contract['columns'], sheet.height / contract['rows']
            for part in (p for p in contract['parts'] if p['atlas'] == number):
                cx, cy = part['cell']
                box = [round(cx * cw), round(cy * ch), round((cx + 1) * cw), round((cy + 1) * ch)]
                correction = ''
                if group == 'rides' and part['id'] == 57:
                    box[3] -= round(ch * 16 / 624)
                    correction = 'Trim the two-pixel palm tip from the following cell.'
                if group == 'rides' and part['id'] == 61:
                    box[1] -= round(ch * 16 / 624)
                    correction = 'Include the palm crown extending two pixels above its cell.'
                if group == 'scenery' and part['id'] in (26, 27):
                    box[3] -= round(ch * 16 / 624)
                    correction = 'Exclude the 4-8px stone tip from the following cell; preserve complete water strip.'
                if group == 'scenery' and part['id'] in (30, 31):
                    box[1] -= round(ch * 16 / 624)
                    correction = 'Include the stone tip extending 4-8px above its cell.'
                if group == 'scenery' and number == 2:
                    # Provider shifted its three occupied rows, but left clear
                    # horizontal bands at y700/y1400. Recrop whole parts there;
                    # don't flatten adjacent sprites into one alpha bounding box.
                    row_bounds = [0, 700, 1400, 2000, 2496]
                    box[1] = round(row_bounds[cy] * sheet.height / 2496)
                    box[3] = round(row_bounds[cy + 1] * sheet.height / 2496)
                    correction = 'Recover shifted occupied rows at verified empty horizontal bands y700/y1400.'
                cell = sheet.crop(box)
                if group == 'rides' and part['id'] == 56:
                    # Exact mirror pair in source RGBA; generated56 was a spear.
                    donor = contract['parts'][53]
                    dx, dy = donor['cell']
                    cell = sheet.crop([round(dx * cw), round(dy * ch), round((dx + 1) * cw), round((dy + 1) * ch)]).transpose(Image.Transpose.FLIP_LEFT_RIGHT)
                    correction = 'Mirror generated53: original53 and56 are exact RGBA mirror pairs.'
                key = key_for(part)
                original = source_part(key)
                try:
                    aligned, metrics = fit_part(cell, original, args.scale)
                except ValueError as error:
                    report['parts'].append({'group': group, 'id': part['id'], 'atlas': number,
                                            'source_key': list(key), 'warning': str(error), 'fallback': 'original'})
                    continue
                if correction:
                    metrics['local_correction'] = correction
                dest = REVIEW / 'crops' / group / f'part_{part["id"]}.png'
                dest.parent.mkdir(parents=True, exist_ok=True)
                aligned.save(dest)
                parts[key], crops[key] = aligned, dest
                metrics['aligned_sha256'] = hashlib.sha256(dest.read_bytes()).hexdigest()
                report['parts'].append({'group': group, 'id': part['id'], 'atlas': number, 'source_key': list(key), **metrics})
                previews[part['id']] = (original, aligned)
        aliases.extend(contract.get('aliases', []))
        contact_sheets(previews, group)
    report['local_overrides'] = []
    for key, path, image in local_smoke(args.scale):
        parts[key], crops[key] = image, path
        report['local_overrides'].append({'source_key': list(key), 'path': str(path.relative_to(ROOT)),
                                        'reason': 'Cafe smoke: replace generated stone interpretation and two tiny original pixel clouds with local translucent vector puffs.'})
    micro_previews = {}
    for index, (key, path, image) in enumerate(local_micro_parts(args.scale)):
        parts[key], crops[key] = image, path
        report['local_overrides'].append({'source_key': list(key), 'path': str(path.relative_to(ROOT)),
                                        'reason': 'Local wood/rope vector replaces the remaining tiny pixel ride segment without changing source bounds or anchors.'})
        micro_previews[index] = (source_part(key), image)
    contact_sheets(micro_previews, 'micro_local')
    for alias in aliases:
        source, canonical = key_for(alias), tuple(alias['canonical_source_key'])
        if canonical in parts:
            parts[source] = parts[canonical].transpose(Image.Transpose.FLIP_LEFT_RIGHT) if alias['flip_x'] else parts[canonical]
    reviewed_path = REVIEW / 'accepted_qa.json'
    reviewed = json.loads(reviewed_path.read_text()) if reviewed_path.exists() else {}
    for part in report['parts']:
        decision = reviewed.get(part['group'], {}).get(str(part['id']), {})
        if 'warning' in part and decision.get('aligned_sha256') == part.get('aligned_sha256') and part.get('aligned_sha256'):
            part['accepted_warning'] = part.pop('warning')
            part['review_reason'] = decision['reason']
    warnings = [p for p in report['parts'] if 'warning' in p]
    report.update(warnings=warnings, generated_parts=sum('aligned_sha256' in p for p in report['parts']),
                  unique_textures=len(crops), local_parts=len(report['local_overrides']), mirrored_aliases=len(parts) - len(crops))
    if not parts:
        parser.error('No generated atlas found')
    # Compact runtime geometry avoids hundreds of large preassembled textures.
    runtime_parts = {}
    for key, path in crops.items():
        relative = Path('parts') / path.parent.name / path.name
        runtime_parts[key_text(key)] = {'path': 'res://assets/hd/' + str(relative), 'logical_size': list(key[-2:]), 'scale': args.scale}
    for alias in aliases:
        key = key_text(key_for(alias))
        canonical = key_text(alias['canonical_source_key'])
        if canonical in runtime_parts:
            runtime_parts[key] = {**runtime_parts[canonical], 'flip_x': alias['flip_x']}
    cache = dict(parts)
    built, cards = {}, {}
    groups = [('rides', graphics['rides']), ('scenery', graphics['scenery'])]
    for group, objects in groups:
        for obj in objects:
            oid = obj['id']
            if group == 'rides' and args.ride and oid not in args.ride:
                continue
            if group == 'scenery' and oid in (14, 22):
                continue
            variants = {'working': obj['frames']} if group == 'rides' else obj['variants']
            gif_frames, used, seen = [], set(), set()
            for state, frames in variants.items():
                phase_commands = commands[group][oid] if group == 'rides' else commands[group][oid][state]
                for phase, (frame, cmds) in enumerate(zip(frames, phase_commands)):
                    for cmd in cmds:
                        if cmd[0] == 0:
                            used.add(tuple(cmd[1:7]))
                    if not args.all_frames and phase != 0:
                        continue
                    original_path = frame['path']
                    if original_path not in built:
                        canvas = assemble(frame, cmds, cache, args.scale)
                        dest = REVIEW / group / str(oid) / state / Path(original_path).name
                        dest.parent.mkdir(parents=True, exist_ok=True)
                        canvas.save(dest)
                        built[original_path] = dest
                    seen.add(original_path)
                    if phase == 0 and state == 'working':
                        cards[original_path] = built[original_path]
                    if not args.no_gifs and state == 'working' and phase % max(1, len(frames) // 30) == 0:
                        canvas = Image.open(built[original_path]).convert('RGBA')
                        canvas.thumbnail((640, 640), Image.Resampling.LANCZOS)
                        bg = Image.new('RGB', canvas.size, (47, 63, 43)); bg.paste(canvas, (0, 0), canvas)
                        gif_frames.append(bg)
            if gif_frames:
                gif_frames[0].save(REVIEW / f'{group}_{oid}.gif', save_all=True, append_images=gif_frames[1:],
                                   duration=100 * max(1, obj['period'] // 30), loop=0)
            report[group].append({'id': oid, 'unique_frames': len(seen), 'generated_parts': len(used.intersection(parts)), 'total_parts': len(used)})
    report['assembled_unique_frames'] = len(built)
    report['runtime_decoded_part_bytes'] = sum(im.width * im.height * 4 for key, im in parts.items() if key in crops)
    for group, objects in groups:
        page = Image.new('RGB', (1800, ((len(objects) + 3) // 4) * 300), (39, 52, 37))
        draw = ImageDraw.Draw(page)
        for obj in objects:
            oid = obj['id']
            path = built.get(obj['frames'][0]['path'])
            if not path:
                continue
            im = Image.open(path).convert('RGBA')
            im.thumbnail((420, 250), Image.Resampling.LANCZOS)
            x, y = oid % 4 * 450, oid // 4 * 300
            draw.text((x + 12, y + 8), str(oid), fill='white')
            page.paste(im, (x + (450 - im.width) // 2, y + 35 + (250 - im.height) // 2), im)
        page.save(REVIEW / f'all_{group}_hd.png')
    write_json(REVIEW / 'report.json', report)
    if args.install:
        if warnings and not args.allow_warnings:
            raise SystemExit(f'{len(warnings)} part warnings need review; files remain in {REVIEW}')
        for key, path in crops.items():
            dest = ROOT / 'game' / runtime_parts[key_text(key)]['path'][6:]
            dest.parent.mkdir(parents=True, exist_ok=True); shutil.copy2(path, dest)
        write_json(HD / 'part_manifest.json', runtime_parts)
        write_json(HD / 'commands.json', commands, compact=True)
        used_paths = {ROOT / 'game' / entry['path'][6:] for entry in runtime_parts.values()}
        for old_path in (HD / 'parts').glob('*/*.png'):
            if old_path not in used_paths and (old_path.name.startswith('part_') or old_path.name.startswith('cafe_smoke_')):
                old_path.unlink()
                Path(str(old_path) + '.import').unlink(missing_ok=True)
        manifest_path = HD / 'manifest.json'
        manifest = json.loads(manifest_path.read_text()) if manifest_path.exists() else {}
        manifest = {key: value for key, value in manifest.items() if value.get('installer') not in ('parts', 'part_cards')}
        for original_path, path in cards.items():
            relative = Path('catalog') / path.relative_to(REVIEW)
            dest = HD / relative
            dest.parent.mkdir(parents=True, exist_ok=True); shutil.copy2(path, dest)
            manifest[original_path] = {'path': 'res://assets/hd/' + str(relative), 'installer': 'part_cards', 'scale': args.scale}
        write_json(manifest_path, manifest)
    print(f'HD PARTS {"INSTALLED" if args.install else "REVIEW"}: {len(crops)} textures + {len(parts)-len(crops)} mirrors; {len(built)} QA frames; {len(warnings)} warnings; parts {report["runtime_decoded_part_bytes"]/1048576:.1f} MiB RGBA')


if __name__ == '__main__':
    main()
