#!/usr/bin/env python3
"""Losslessly decode original arrsi.dat / arr.dat (e.u(), e.v(), e.w())."""
from pathlib import Path
import argparse
import hashlib
import json
import struct

ROOT = Path(__file__).resolve().parent
RIDE_FIELDS = ('am', 'as', 'at', 'an', 'ap', 'ao', 'aq', 'au', 'ar', 'av', 'aw', 'ax', 'ay', 'az', 'aA', 'aB', 'aC')


class Reader:
    def __init__(self, data):
        self.data, self.pos = data, 0

    def take(self, size):
        start = self.pos
        self.pos += size
        result = self.data[start:self.pos]
        if len(result) != size:
            raise ValueError(f'Truncated data at {start}: expected {size}')
        return result

    def u16(self):
        return struct.unpack('<H', self.take(2))[0]

    def signed(self, size):
        return [b if b < 128 else b - 256 for b in self.take(size)]


def parse():
    metadata = Reader((ROOT / 'jar/arrsi.dat').read_bytes())
    payload = Reader((ROOT / 'jar/arr.dat').read_bytes())
    rides, props = [], []
    for index in range(24):
        header = dict(zip(RIDE_FIELDS, metadata.signed(17)))
        rides.append({'id': index, 'header': header, 'declared_size': metadata.u16()})
    for index in range(27):
        header = dict(zip(('aH', 'aF', 'aG'), metadata.signed(3)))
        props.append({'id': index, 'header': header, 'declared_size': metadata.u16()})
    common_size = metadata.u16()
    assert metadata.pos == len(metadata.data)

    for objects, count in ((rides, 42), (props, 16)):
        for obj in objects:
            obj['sections'] = [payload.signed(payload.u16()) for _ in range(count)]
            assert sum(map(len, obj['sections'])) == obj['declared_size'], obj['id']
    tables = [payload.signed(payload.u16()) for _ in range(177)]
    assert sum(map(len, tables)) == common_size
    assert payload.pos == len(payload.data)
    text = (ROOT / 'jar/text.da0').read_bytes().decode('cp1251').split('|')
    for ride in rides:
        h, section = ride['header'], ride['sections']
        ride.update(name=text[tables[135][ride['id']]], cost=h['az'] * 10,
                    rating=h['aA'] // 5, happiness=h['aA'], default_price=h['aA'] // 5 if ride['id'] != 23 else 9,
                    capacity=h['au'], size=section[0], requires_motor=bool(section[4][3]),
                    duration_ticks=h['am'] - 1, load_wait_ticks=h['aw'], wear_bound=h['ay'])
    for prop in props:
        index = prop['id']
        prop.update(name=text[tables[136][index]], cost=tables[58][index], size=[2, 2] if index == 26 else [1, 1],
                    effects=tables[29][index * 7:(index + 1) * 7], role=tables[56][index],
                    price_group=tables[57][index], threshold=tables[55][index], need=tables[54][index])
    targets = [[[100, 2, 5], [750, 5, 40], [1500, 6, 80], [3000, 7, 120], [6000, 8, 150], [10000, 9, 170]],
               [[100, 2, 5], [1500, 6, 60], [3000, 7, 100], [5000, 8, 150], [10000, 9, 180], [15000, 9, 190]]]
    cash = [[500, 400, 500, 600, 650, 700], [500, 300, 350, 400, 450, 500]]
    scenarios = []
    for index in range(6):
        events = [] if index == 0 else tables[155 + index]
        scenarios.append({'id': index, 'name': text[94 if index == 0 else 23 + index], 'size': tables[134][index],
                          'starting_money': [cash[0][index], cash[1][index]], 'targets': [targets[0][index], targets[1][index]],
                          'initial_rides': [i for i in range(24) if tables[40][index * 24 + i] == 1],
                          'initial_props': [i for i in range(27) if tables[41][index * 27 + i] == 1],
                          'unlocks': [{'month': events[i], 'kind': 'ride' if events[i + 1] == 0 else 'prop', 'id': events[i + 2]} for i in range(0, len(events), 3)]})
    return {'schema': 1, 'source_sha256': {name: hashlib.sha256((ROOT / 'jar' / name).read_bytes()).hexdigest() for name in ('arrsi.dat', 'arr.dat')},
            'rides': rides, 'props': props, 'tables': tables, 'common_declared_size': common_size,
            'scenarios': scenarios, 'staff': [{'id': i, 'name': text[tables[137][i]], 'salary': tables[131][i]} for i in range(6)]}


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--output', type=Path, default=ROOT / 'data/game_data.json')
    parser.add_argument('--check', action='store_true')
    parser.add_argument('--install', action='store_true', help='Also install the exact export in game/assets/data/original.json')
    args = parser.parse_args()
    data = parse()
    out = json.dumps(data, ensure_ascii=False, indent=2) + '\n'
    if args.check:
        assert args.output.read_text() == out, 'Export differs; run export_data.py'
    else:
        args.output.parent.mkdir(parents=True, exist_ok=True)
        args.output.write_text(out)
    if args.install:
        game_output = ROOT.parent / 'game/assets/data/original.json'
        game_output.parent.mkdir(parents=True, exist_ok=True)
        if args.check:
            assert game_output.read_text() == out, 'Installed game data differs'
        else:
            game_output.write_text(out)
    print(f'DATA OK: {len(data["rides"])} rides, {len(data["props"])} props, {len(data["tables"])} tables; both files consumed exactly')


if __name__ == '__main__':
    main()
