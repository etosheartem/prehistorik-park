#!/usr/bin/env python3
"""Check compact command fidelity against original assembled frames and HD assets."""
import json
from pathlib import Path
from PIL import Image, ImageChops
from install_parts import ROOT, HD, geometry, assemble


def main():
    graphics = json.loads((ROOT / 'original/export/graphics.json').read_text())
    data = json.loads((ROOT / 'original/data/game_data.json').read_text())
    commands = geometry(graphics, data)
    cache, count, sources = {}, 0, set()
    for group in ('rides', 'scenery'):
        for obj in graphics[group]:
            oid = obj['id']
            if group == 'scenery' and oid in (14, 22):
                continue
            variants = {'working': obj['frames']} if group == 'rides' else obj['variants']
            for state, frames in variants.items():
                sequence = commands[group][oid] if group == 'rides' else commands[group][oid][state]
                assert len(sequence) == len(frames)
                for frame, cmds in zip(frames, sequence):
                    original = Image.open(ROOT / 'game' / frame['path'][6:]).convert('RGBA')
                    reconstructed = assemble(frame, cmds, cache, 1)
                    assert original.size == reconstructed.size, (group, oid, 'bounds')
                    # RGB under fully transparent pixels has no visual meaning.
                    a = Image.new('RGBA', original.size); a.alpha_composite(original)
                    b = Image.new('RGBA', original.size); b.alpha_composite(reconstructed)
                    assert ImageChops.difference(a, b).getbbox(alpha_only=False) is None, (group, oid, state, frame['path'])
                    count += 1
                    sources.update(tuple(cmd[1:7]) for cmd in cmds if cmd[0] == 0)
    manifest_path = HD / 'part_manifest.json'
    if manifest_path.exists():
        manifest = json.loads(manifest_path.read_text())
        for key, entry in manifest.items():
            size = tuple(map(int, key.split(':')[-2:]))
            image = Image.open(ROOT / 'game' / entry['path'][6:])
            assert image.size == tuple(n * entry['scale'] for n in size), key
            assert image.mode == 'RGBA' and image.getchannel('A').getbbox(), key
        runtime = json.loads((HD / 'commands.json').read_text())
        assert runtime == commands, 'Installed commands are stale'
    print(f'PARTS OK: {count} phases match original pixel output; {len(sources)} source rectangles; runtime geometry and alpha validated')


if __name__ == '__main__':
    main()
