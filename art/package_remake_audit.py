#!/usr/bin/env python3
"""Package the resource contact sheets and GPU captures as an offline gallery."""
import argparse
from html import escape
import json
from pathlib import Path
import zipfile

ROOT = Path(__file__).resolve().parents[1]


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--input', type=Path, default=ROOT/'art/review/remake_audit')
    parser.add_argument('--output', type=Path, default=ROOT/'build/remake-audit-1.0.1.zip')
    args = parser.parse_args()
    folder = args.input
    inventory = json.loads((folder/'after/inventory.json').read_text())
    render = json.loads((folder/'rendered/report.json').read_text())
    assert render['passed'], 'Render audit failed; inspect its output before packaging'
    data = json.loads((ROOT/'game/assets/data/original.json').read_text())
    page = '''<!doctype html><html lang="ru"><meta charset="utf-8"><meta name="viewport" content="width=device-width,initial-scale=1">
<title>Первобытный парк — сверка ремейка 1.0.1</title><style>
body{max-width:1440px;margin:32px auto;padding:0 24px;background:#203329;color:#f5e8c8;font:18px/1.6 system-ui}
a{color:#f6c65f}img{max-width:100%;height:auto}details{border-bottom:1px solid #536449;margin:20px 0;padding:12px}
summary{cursor:pointer;font-weight:700}.frames{display:grid;grid-template-columns:repeat(3,1fr);gap:8px}
.frames figure{margin:0;text-align:center}.frames img{width:100%;background:#304235}.phase{grid-column:1/-1;margin:20px 0 0}h2{margin-top:48px}
</style><h1>Сверка ремейка · 1.0.1</h1>'''
    page += f'<p>{inventory["comparisons"]} сравнений ресурсов; {render["rendered_frames"]} отрисовка оригинала и обоих профилей ремейка.</p>'
    page += '''<p>В контактных листах оригинал слева, ремейк справа. Coverage показывает совпадение непрозрачной области, а не качество рисунка. Дым, трава и новая поза могут отличаться по силуэту. Пять неиспользуемых кадров врача пусты уже в оригинале. Исходные пиксели сохранены без изменений.</p>
<p><a href="after/inventory.json">Реестр, альфа-покрытие и SHA-256</a> · <a href="rendered/report.json">Отчёт рендера</a></p><h2>Отдельные ресурсы и каталог</h2>'''
    for group in ['parts','actors','cards','terrain_and_vectors','source_passthrough','catalog']:
        page += f'<details><summary>{group}</summary>'
        for path in sorted((folder/'after').glob(group+'_*.jpg')):
            page += f'<a href="after/{path.name}"><img loading="lazy" src="after/{path.name}" alt="{path.stem}"></a>'
        page += '</details>'
    page += '<h2>Анимация, поворот входа и строительство</h2><p>Одинаковая камера. Нажми на кадр для полного размера.</p>'
    for kind, count in [('ride',24),('prop',27)]:
        for index in range(count):
            name = escape(data['rides' if kind == 'ride' else 'props'][index]['name'])
            page += f'<details><summary>{kind} {index} · {name}</summary><div class="frames">'
            originals = sorted((folder/'rendered').glob(f'{kind}_{index:02d}_*_original.png'))
            assert originals, f'Missing captures: {kind} {index}'
            for path in originals:
                stem = path.stem.removesuffix('_original')
                page += f'<p class="phase">{stem}</p>'
                for mode, label in [('original','Оригинал'),('remake_medium','Баланс'),('remake_maximum','Все детали')]:
                    name = f'{stem}_{mode}.png'
                    assert (folder/'rendered'/name).is_file(), name
                    page += f'<figure><a href="rendered/{name}"><img loading="lazy" src="rendered/{name}" alt="{label}"></a><figcaption>{label}</figcaption></figure>'
            page += '</div></details>'
    page += '</html>'
    (folder/'index.html').write_text(page)
    args.output.parent.mkdir(parents=True, exist_ok=True)
    files = [folder/'index.html'] + sorted((folder/'after').glob('*')) + sorted((folder/'rendered').glob('*'))
    with zipfile.ZipFile(args.output, 'w', zipfile.ZIP_DEFLATED, compresslevel=6) as archive:
        for path in files:
            if path.is_file(): archive.write(path, path.relative_to(folder))
    print(f'AUDIT GALLERY: {len(files)} files, {args.output.stat().st_size} bytes: {args.output}')


if __name__ == '__main__':
    main()
