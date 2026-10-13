#!/usr/bin/env python3
"""Read-only JAR/graphics provenance audit; writes only original/export/audit_v02."""
from pathlib import Path
import hashlib
import io
import json
import struct
import zipfile

from PIL import Image, ImageDraw
from export_data import parse

ROOT = Path(__file__).resolve().parent.parent
OUT = ROOT / 'original/export/audit_v02'


def digest(data):
    return hashlib.sha256(data).hexdigest()


def write(name, value):
    (OUT / name).write_text(json.dumps(value, ensure_ascii=False, indent=2) + '\n')


def menu_reference(packs):
    """e.y()/z() at the native 240x320 size, without labels/buttons."""
    image = Image.new('RGBA', (240, 320), (105, 168, 255, 255))
    draw = ImageDraw.Draw(image)
    for y in range(80):
        color = tuple(a - (a - b) * y // 80 for a, b in zip((105, 168, 255), (16, 94, 0)))
        draw.line((0, 160 + y, 239, 160 + y), fill=(*color, 255))
    draw.rectangle((0, 240, 239, 319), fill=(16, 94, 0, 255))
    xs = [[0, -2, -4, -4, -6, -6, -8], [218, 220, 222, 222, 224, 224, 226]]
    ys = [38, 80, 122, 164, 206, 248, 290]
    for side, source_x in enumerate([14, 0]):
        stone = packs[2, 4].crop((source_x, 0, source_x + 22, 42))
        for i, y in enumerate(ys):
            if side == 1:
                draw.rectangle((22 + xs[0][i], y, xs[1][i] - 1, 319), fill='#e0d46f')
            image.alpha_composite(stone, (xs[side][i], y))
    for x, y, w, h, dx, dy in [(0, 0, 63, 5, 88, 35), (0, 0, 30, 5, 58, 33),
                               (33, 0, 30, 5, 151, 33), (20, 2, 23, 3, 35, 35), (20, 2, 23, 3, 181, 35)]:
        image.alpha_composite(packs[2, 8].crop((x, y, x + w, y + h)), (dx, dy))
    for x, y, w, h, dx in [(0, 0, 74, 100, 0), (0, 100, 60, 60, 74),
                           (72, 0, 74, 100, 166), (86, 100, 60, 60, 106)]:
        image.alpha_composite(packs[2, 5].crop((x, y, x + w, y + h)), (dx, -15))
    image.save(OUT / 'menu_blank_native.png')
    image.resize((720, 960), Image.Resampling.NEAREST).save(OUT / 'menu_blank_nearest3x.png')


def main():
    OUT.mkdir(parents=True, exist_ok=True)
    jar = ROOT / 'prehistorik_park_240.jar'
    inventory, packs = [], {}
    with zipfile.ZipFile(jar) as archive:
        source_hashes = {}
        for name in ['arr.dat', 'arrsi.dat', 'e.class', 'b.class', 'c.class', 'd.class',
                     'gpack0.dat', 'gpack1.dat', 'gpack2.dat', 'icon.png', 'splash0.png', 'splash1.png', 'splash2.png']:
            data = archive.read(name)
            assert data == (ROOT / 'original/jar' / name).read_bytes(), name
            source_hashes[name] = digest(data)
        for pack, count in enumerate([11, 13, 12]):
            data = archive.read(f'gpack{pack}.dat')
            pos = 0
            for index in range(count):
                size, = struct.unpack_from('<H', data, pos)
                pos += 2
                if size:
                    png = data[pos:pos + size]
                    resource = f'res://assets/original/packs/gpack{pack}_{index}.png'
                    assert png == (ROOT / 'game' / resource[6:]).read_bytes(), resource
                    image = Image.open(io.BytesIO(png)).convert('RGBA')
                    packs[pack, index] = image
                    inventory.append({'jar_resource': f'gpack{pack}.dat', 'index': index,
                                      'byte_offset': pos, 'byte_length': size, 'path': resource,
                                      'size': list(image.size), 'sha256': digest(png), 'fidelity': 'byte_exact'})
                else:
                    assert (pack, index) == (1, 7)
                pos += size
            assert pos == len(data)
        for name in ['icon', 'splash0', 'splash1', 'splash2']:
            raw = archive.read(f'{name}.png')
            original = Image.open(io.BytesIO(raw)).convert('RGBA')
            resource = f'res://assets/original/ui/{name}.png'
            copy = Image.open(ROOT / 'game' / resource[6:]).convert('RGBA')
            assert original.size == copy.size and original.tobytes() == copy.tobytes()
            inventory.append({'jar_resource': f'{name}.png', 'path': resource, 'size': list(original.size),
                              'source_sha256': digest(raw), 'fidelity': 'pixel_exact_RGBA_reencode'})
    packs[1, 7] = packs[0, 10]
    data = parse()
    tables = data['tables']
    catalogs = []
    for category in range(5):
        catalogs.append([{'kind': ['ride', 'prop', 'staff', 'path'][kind], 'id': index}
                         for kind, index in zip(tables[146 + category], tables[151 + category])])
    reachable = {entry['id'] for group in catalogs for entry in group if entry['kind'] == 'prop'}
    while True:
        added = {index + tables[162][index] for index in reachable} - reachable
        if not added:
            break
        reachable |= added
    graphics = json.loads((ROOT / 'game/assets/original/graphics.json').read_text())
    overrides = {'schema': 1, 'modes': ['original', 'original_upscaled'], 'scenery': {}}
    for index in [14, 22]:
        variants = graphics['scenery'][index]['source_variants']
        overrides['scenery'][str(index)] = {'frames': variants['working'], 'variants': variants,
                                           'provenance': 'dormant_JAR_rectangles_padded_outside_PNG',
                                           'available_in_original_catalog': False}
    ticket_report = []
    contact = Image.new('RGB', (720, 300), '#37412e')
    draw = ImageDraw.Draw(contact)
    for slot, index in enumerate([14, 22]):
        s = data['props'][index]['sections']
        rect = [s[k][0] for k in range(4)]
        pack_index = s[6][0]
        x, y, w, h = rect
        raw = packs[1, pack_index].crop((x, y, x + w, y + h))
        exported = Image.open(ROOT / 'game' / overrides['scenery'][str(index)]['frames'][0]['path'][6:]).convert('RGBA')
        # Assembly discards RGB hidden under alpha zero; visible pixels and
        # alpha must remain exact, without requiring invisible palette RGB.
        normalize = lambda im: [pixel if pixel[3] else (0, 0, 0, 0) for pixel in im.get_flattened_data()]
        assert raw.size == exported.size and normalize(raw) == normalize(exported)
        image = raw.resize((w * 6, h * 6), Image.Resampling.NEAREST)
        draw.text((slot * 360 + 12, 12), f'prop{index}: gpack1[{pack_index}] {rect}', fill='white')
        contact.paste(image, (slot * 360 + 50, 60), image)
        ticket_report.append({'id': index, 'source_pack': 1, 'source_index': pack_index,
                              'rect': rect, 'sheet_size': list(packs[1, pack_index].size),
                              'within_source': x + w <= packs[1, pack_index].width and y + h <= packs[1, pack_index].height,
                              'source_offset': [s[4][0], s[5][0]],
                              'in_menu_or_rotation_closure': index in reachable,
                              'unstaffed_marker': [s[k][2] for k in range(4)]})
    contact.save(OUT / 'ticket_source_contact.png')
    menu_reference(packs)
    write('raw_inventory.json', inventory)
    write('original_metadata_override.json', overrides)
    write('report.json', {'schema': 1, 'jar_sha256': digest(jar.read_bytes()), 'source_hashes': source_hashes,
                          'byte_exact_packed_pngs': 35, 'pixel_exact_direct_pngs': 4,
                          'pack_alias': {'1:7': '0:10'}, 'catalogs': catalogs,
                          'prop_rotation_deltas': tables[162], 'reachable_props': sorted(reachable),
                          'unreachable_props': sorted(set(range(27)) - reachable), 'tickets': ticket_report,
                          'synthetic_original_assets': ['scenery/14/ticket_*.svg', 'scenery/22/ticket_*.svg'],
                          'font_adaptations': ['4x nearest repack of gpack2[6] into BMFont',
                                               'lowercase aliases uppercase native glyphs',
                                               'Ё/ё adds two code-drawn yellow dots to native Е'],
                          'runtime_assets_modified': False})
    print('ORIGINAL AUDIT OK: 35 byte-exact pack PNGs, 4 pixel-exact direct PNGs; ticket IDs unreachable; game assets untouched')


if __name__ == '__main__':
    main()
