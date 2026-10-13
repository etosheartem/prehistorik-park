#!/usr/bin/env python3
"""Inspect the exported archive rather than just trusting a successful exporter exit."""
import configparser, hashlib, json, re, sys, zipfile
from pathlib import Path
apk=Path(sys.argv[1])
with zipfile.ZipFile(apk) as z:
    names=z.namelist()
    assert z.testzip() is None, 'ZIP CRC failed'
    assert 'lib/arm64-v8a/libgodot_android.so' in names, 'Missing arm64 engine'
    assert not any(n.startswith('lib/armeabi-v7a/') for n in names), 'Unexpected ABI'
    forbidden=[n for n in names if '/tests/' in n or n.endswith('.env') or '/art/raw/' in n or '/original/src/' in n]
    assert not forbidden, f'Unwanted source files included: {forbidden[:4]}'
    assets=[n for n in names if n.startswith('assets/')]
    assert 'assets/assets/data/original.json' in assets, 'Original rules not bundled'
    assert 'assets/assets/hd/commands.json' in assets, 'HD animation commands not bundled'
    assert 'assets/assets/hd/part_manifest.json' in assets, 'HD parts not bundled'
    hd=json.loads(z.read('assets/assets/hd/manifest.json'))
    actor_frames=sum('/actors/' in key for key in hd)
    assert actor_frames == 224, f'Incomplete HD actors: {actor_frames}/224'
    texture_paths=set()
    for index in ('manifest.json','part_manifest.json','terrain/manifest.json'):
        mapping=json.loads(z.read('assets/assets/hd/'+index))
        texture_paths.update(value['path'] if isinstance(value,dict) else value for value in mapping.values())
    hd_textures=len(texture_paths)
    upscaled=json.loads(z.read('assets/assets/upscaled/manifest.json'))
    upscale_parts=json.loads(z.read('assets/assets/upscaled/part_manifest.json'))
    assert len(upscaled)>=518, 'Incomplete original upscale'
    assert len(upscale_parts)>=192, 'Missing isolated original upscale regions'
    assert 'assets/assets/original/commands.json' in names, 'Missing source animation commands'
    for value in list(upscaled.values()) + list(upscale_parts.values()):
        assert value['path'].startswith('res://assets/upscaled/'), 'Upscale resolves to remake'
        texture_paths.add(value['path'])
    for path in texture_paths:
        resource='assets/'+path.removeprefix('res://')
        assert resource+'.import' in names, f'Missing texture import: {path}'
        metadata=z.read(resource+'.import').decode()
        remap=re.search(r'^path="res://([^"\n]+)"', metadata, re.M)
        assert remap and 'assets/'+remap[1] in names, f'Missing exported texture: {path}'
    for name in names:
        if name.startswith('lib/') or z.getinfo(name).file_size>30_000_000: continue
        assert b'sk-or-v1-' not in z.read(name), f'API credential marker in {name}'
report={'apk':apk.name,'bytes':apk.stat().st_size,'sha256':hashlib.sha256(apk.read_bytes()).hexdigest(),'files':len(names),'asset_files':len(assets),'abi':'arm64-v8a','crc':'passed','api_key_scan':'passed','excluded_test_sources':'passed'}
report.update(hd_actor_frames=actor_frames,hd_exported_textures_verified=hd_textures,upscaled_resources_verified=len(upscaled),upscaled_parts_verified=len(upscale_parts),exported_textures_verified=len(texture_paths))
if len(sys.argv)>2:
    manifest=Path(sys.argv[2]).read_text()
    assert 'package="ru.artem.prehistorikpark"' in manifest, 'Wrong Android package'
    config = configparser.ConfigParser(interpolation=None)
    config.read('game/export_presets.cfg')
    version_code = config.getint('preset.0.options', 'version/code')
    version_name = config.get('preset.0.options', 'version/name').strip(chr(34))
    assert re.search(r':versionCode\([^)]*\)=' + str(version_code) + r'\s', manifest), 'Wrong upgrade version code'
    assert 'assets/assets/ui/fonts/LICENSE.txt' in names, 'Font license not bundled'
    assert sum('/ui/catalog/' in n and n.endswith('.png.import') for n in names) == 153, 'Missing catalog previews'
    report.update(version_code=version_code, version_name=version_name, catalog_previews=153, font_license='included')
    assert re.search(r':screenOrientation\([^)]*\)=1\s', manifest), 'Portrait orientation missing'
    assert 'android.permission.INTERNET' not in manifest, 'Offline game requests Internet permission'
    # Godot writes the themed template to icon.xml and intentionally skips its
    # original filename; the unused resources.arsc entry triggers an aapt warning.
    assert 'res/mipmap-anydpi-v26/icon.xml' in names, 'Missing adaptive icon'
    for layer in ('foreground','background','monochrome'):
        assert 'res/mipmap/icon_'+layer+'.webp' in names, f'Missing adaptive icon layer: {layer}'
    report.update(orientation='portrait',internet_permission=False,adaptive_icon='passed')
    report['exporter_note']='Godot retains an unused themed_icon.xml resource-table entry; the active icon.xml includes all three adaptive layers.'
Path('build/reports_0.3/apk.json').write_text(json.dumps(report,ensure_ascii=False,indent=2)+'\n')
print(json.dumps(report,ensure_ascii=False))
