#!/usr/bin/env python3
"""Deterministic vector terrain for the HD renderer; no paid generation or raster upscaling."""
import json, random
from pathlib import Path
ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / 'game/assets/hd/terrain'
OUT.mkdir(parents=True, exist_ok=True)
manifest = {}
for name in ['grass_0','grass_1','grass_2','path_dirt','path_stone','water_0','water_1','water_2']:
    rng = random.Random(name)
    water = name.startswith('water')
    height = 21 if water else 20
    colors = {'grass_0':('#7db34b','#7db34b'), 'grass_1':('#7db34b','#7db34b'), 'grass_2':('#7db34b','#7db34b'), 'path_dirt':('#e2c68d','#e2c68d'), 'path_stone':('#a8aaa0','#848e84')}
    top, bottom = colors.get(name, ('#6dbabe','#458e9f'))
    shape = 'M0 10 20 0 40 10 20 20Z'
    body = [f'<svg xmlns="http://www.w3.org/2000/svg" width="320" height="{height*8}" viewBox="0 0 40 {height}"><defs><linearGradient id="g" x2="0.7" y2="1"><stop stop-color="{top}"/><stop offset="1" stop-color="{bottom}"/></linearGradient><clipPath id="c"><path d="{shape}"/></clipPath></defs><path d="{shape}" fill="url(#g)"/><g clip-path="url(#c)">']
    if name.startswith('grass'):
        for i in range(22):
            x,y=rng.uniform(1,39),rng.uniform(1,19)
            body.append(f'<path d="M{x:.2f} {y:.2f}q.6 -1.4 1.1 -1.1m-1.1 1.1q-.6 -1.1 -1.1 -.8" fill="none" stroke="{rng.choice(["#9dc664","#50833e"])}" stroke-opacity=".22" stroke-width=".16" stroke-linecap="round"/>')
    elif name == 'path_dirt':
        for i in range(38):
            x,y=rng.uniform(0,40),rng.uniform(0,20)
            body.append(f'<ellipse cx="{x:.2f}" cy="{y:.2f}" rx="{rng.uniform(.13,.45):.2f}" ry=".13" fill="{rng.choice(["#ead29a","#957a50"])}" opacity=".32"/>')
    elif name == 'path_stone':
        for u in range(-1,5):
            for v in range(-1,5):
                x,y=20+(u-v)*5,(u+v)*2.5
                body.append(f'<path d="M{x:.1f} {y+.2:.1f}l4.6 2.3 -4.6 2.3 -4.6 -2.3Z" fill="{rng.choice(["#9ca499","#aeb1a3","#8f9b91"])}" stroke="#758578" stroke-width=".18"/>')
    else:
        phase=int(name[-1])
        for i in range(10):
            x,y=rng.uniform(1,37),rng.uniform(2,18)
            body.append(f'<path d="M{x:.2f} {y:.2f}q1.3 -.3 {2+phase*.15:.2f} 0" fill="none" stroke="#b6e3d7" stroke-opacity=".42" stroke-width=".18" stroke-linecap="round"/>')
    body.append('</g></svg>')
    (OUT/f'{name}.svg').write_text(''.join(body))
    manifest[f'res://assets/original/tiles/{name}.png']={'path':f'res://assets/hd/terrain/{name}.svg','logical_size':[40,height]}
manifest['res://assets/original/tiles/edges_0.png'] = {'path':'res://assets/hd/terrain/path_dirt.svg','logical_size':[40,20]}
(OUT/'manifest.json').write_text(json.dumps(manifest,indent=2)+'\n')
print('8 vector terrain tiles written, $0')
