#!/usr/bin/env python3
"""Catch missing resources and the specific layout regressions found in 1.0.0."""
import json

import numpy as np
from PIL import Image

from audit_remake import HD, GAME, image, local, metrics, source_part


def read(path):
    return json.loads(path.read_text())


def main():
    parts = read(HD / 'part_manifest.json')
    parts.update(read(HD / 'structural_manifest.json'))
    source_keys = read(GAME / 'assets/upscaled/part_manifest.json')
    assert len(source_keys) == 192
    assert not (parts.keys() - source_keys.keys()), 'Unknown source rectangle'
    for key in source_keys:
        old = source_part(key)
        assert old.getchannel('A').getbbox(), f'Empty source part: {key}'
        if key not in parts:
            continue  # Deliberate source-pixel overlays remain complete.
        entry = parts[key]
        new = image(local(entry['path']))
        assert list(old.size) == entry['logical_size'], f'Changed logical bounds: {key}'
        assert new.size == tuple(v * entry['scale'] for v in old.size), f'Incorrect canvas: {key}'
        assert new.getchannel('A').getbbox(), f'Empty remake part: {key}'
    mappings = read(HD / 'manifest.json')
    mappings.update(read(HD / 'terrain/manifest.json'))
    for source, entry in mappings.items():
        assert local(source).is_file(), f'Missing original: {source}'
        assert image(local(entry['path'])).getchannel('A').getbbox(), f'Empty replacement: {source}'
    actors = [key for key in mappings if '/actors/' in key]
    assert len(actors) == 224
    for actor in (2, 3):
        for phase in (0, 1):
            key = f'res://assets/original/actors/{actor}/sit_{phase}.png'
            old, new = image(local(key)), image(local(mappings[key]['path']))
            score = metrics(old, new)['source_coverage']
            reversed_score = metrics(old, new.transpose(Image.Transpose.FLIP_LEFT_RIGHT))['source_coverage']
            assert score > .88 and score > reversed_score + .08, f'Visitor sitting backwards: {key}'
    for actor in (1, 2, 3, 5, 6, 7):
        keys = [f'res://assets/original/actors/{actor}/special_{phase}.png' for phase in (5, 6)]
        assert image(local(keys[0])).tobytes() == image(local(keys[1])).tobytes()
        frames = [image(local(mappings[key]['path'])) for key in keys]
        assert frames[0].size == frames[1].size and frames[0].tobytes() == frames[1].tobytes(), f'Head changes direction in identical source frames: {actor}'
    key = '1:2:39:83:28:21'
    score = metrics(source_part(key), image(local(parts[key]['path'])))
    assert score['source_coverage'] > .95 and not score['possibly_missing_components'], 'Burst lost stone fragments'
    # The previous balloon contained no lettering. Test the interior, excluding
    # its dark outline, with four separate letter positions at logical scale.
    bubble = image(local(parts['1:2:100:60:24:13']['path'])).resize((192, 104))
    pixels = np.asarray(bubble)
    for left, right in ((4,7), (8,12), (13,17), (17,20)):
        interior = pixels[35:68, left*8:right*8]
        assert ((interior[:,:,:3].mean(axis=2) < 100) & (interior[:,:,3] > 128)).sum() > 35, 'Speech balloon lost a letter'
    print(f'REMAKE ASSETS OK: {len(source_keys)} atlas regions, {len(mappings)} mapped images; sitting directions, identical heads, stone fragments and GRR! lettering preserved')


if __name__ == '__main__':
    main()
