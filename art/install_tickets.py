#!/usr/bin/env python3
"""Install lossless8x vector kiosk overrides without changing world dimensions."""
import json
from pathlib import Path
import re

ROOT = Path(__file__).resolve().parent.parent
HD = ROOT / 'game/assets/hd'
manifest_path = HD / 'manifest.json'
manifest = json.loads(manifest_path.read_text()) if manifest_path.exists() else {}
for kind in (14, 22):
    for state in ('working', 'closed', 'unstaffed'):
        original = ROOT / f'game/assets/original/scenery/{kind}/ticket_{state}.svg'
        svg = re.sub(r'width="38" height="44"', 'width="304" height="352"', original.read_text(), count=1)
        dest = HD / f'scenery/{kind}/ticket_{state}.svg'
        dest.parent.mkdir(parents=True, exist_ok=True)
        dest.write_text(svg)
        original_path = 'res://' + str(original.relative_to(ROOT / 'game'))
        manifest[original_path] = {'path': 'res://' + str(dest.relative_to(ROOT / 'game')), 'installer': 'ticket_vectors', 'scale': 8}
manifest_path.write_text(json.dumps(manifest, ensure_ascii=False, indent=2) + '\n')
print('HD TICKETS:6 crisp vector replacements; all other manifest entries preserved; $0')
