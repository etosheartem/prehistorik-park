#!/usr/bin/env python3
"""Local NVIDIA/Vulkan SR of original J2ME sheets, followed by exact atlas crops.

python art/upscale_original.py --run
python art/upscale_original.py --check

No API, no generative redraw, no resize-only fallback. Native PNGs stay read-only.
Only source sheets are inferred; all animation phases share those same results.
"""
from __future__ import annotations
import argparse, hashlib, json, os, re, shutil, subprocess, sys, time
from concurrent.futures import ThreadPoolExecutor
from collections import deque
from pathlib import Path
from PIL import Image, ImageDraw

ROOT = Path(__file__).resolve().parents[1]
SRC = ROOT / 'game/assets/original'
DEST = ROOT / 'game/assets/upscaled'
WORK = ROOT / 'art/upscale'
BIN = Path(os.environ.get('PARK_ESRGAN_BIN', shutil.which('realesrgan-ncnn-vulkan') or 'realesrgan-ncnn-vulkan'))
MODELS = Path(os.environ.get('PARK_ESRGAN_MODELS', str(BIN.parent / 'models')))
SCALE, PAD = 4, 16
PREPROCESS = 'nearest-opaque-rgb-bleed-v1'

def sha(path): return hashlib.sha256(Path(path).read_bytes()).hexdigest()
def read(path): return json.loads(Path(path).read_text())
def write(path, value):
    path.parent.mkdir(parents=True, exist_ok=True)
    tmp = path.with_suffix(path.suffix + '.tmp')
    tmp.write_text(json.dumps(value, ensure_ascii=False, indent=2) + '\n')
    tmp.replace(path)
def res(path): return 'res://' + str(path.relative_to(ROOT / 'game'))

def source_jobs():
    jobs = []
    for path in sorted((SRC / 'packs').glob('*.png')):
        jobs.append({'source':path,'relative':path.relative_to(SRC),'model':'realesr-animevideov3','native_adapter':1})
    for name in ['icon','splash0','splash1','splash2']:
        jobs.append({'source':SRC/'ui'/f'{name}.png','relative':Path('ui')/f'{name}.png','model':'realesrgan-x4plus-anime','native_adapter':1})
    # Exported BMFont is exact nearest-neighbour x4. Undo that adapter before SR,
    # so the neural model receives the actual J2ME glyph pixels, not pixel blocks.
    jobs.append({'source':SRC/'fonts/original.png','relative':Path('fonts/original.png'),'model':'realesr-animevideov3','native_adapter':4})
    return jobs

def model_hash(model):
    name = model + ('-x4' if model == 'realesr-animevideov3' else '')
    return {ext:sha(MODELS/(name+ext)) for ext in ['.bin','.param']}

def bleed_rgb(image):
    """Extend authored RGB into transparency before inference, keeping alpha separate.

    Otherwise the neural filter mixes invisible black into sprite edges; restoring
    the original mask afterwards makes dark seams around adjoining terrain tiles.
    A multi-source flood fills only invisible pixels, including the outer padding.
    """
    w, h = image.size
    pixels = list(image.get_flattened_data())
    known = bytearray(p[3] > 0 for p in pixels)
    rgb = [p[:3] for p in pixels]
    queue = deque()
    for i, valid in enumerate(known):
        if not valid: continue
        x, y = i % w, i // w
        if ((x > 0 and not known[i-1]) or (x+1 < w and not known[i+1]) or
                (y > 0 and not known[i-w]) or (y+1 < h and not known[i+w])):
            queue.append(i)
    while queue:
        i = queue.popleft()
        x, y = i % w, i // w
        for other in (i-1 if x else -1, i+1 if x+1 < w else -1,
                      i-w if y else -1, i+w if y+1 < h else -1):
            if other >= 0 and not known[other]:
                known[other] = 1
                rgb[other] = rgb[i]
                queue.append(other)
    result = Image.new('RGB', image.size)
    result.putdata(rgb)
    return result

def infer_group(model, jobs, run_dir):
    incoming, outgoing = run_dir/model/'input', run_dir/model/'output'
    incoming.mkdir(parents=True, exist_ok=True); outgoing.mkdir(parents=True, exist_ok=True)
    for job in jobs:
        im = Image.open(job['source']).convert('RGBA')
        if job['native_adapter'] != 1:
            im = im.resize((im.width//4,im.height//4),Image.Resampling.NEAREST)
        job['native_size'] = list(im.size)
        prepared = Image.new('RGBA',(im.width+2*PAD,im.height+2*PAD))
        prepared.alpha_composite(im,(PAD,PAD))
        job['input'] = incoming/str(job['relative']).replace('/','__')
        job['raw'] = outgoing/job['input'].name
        bleed_rgb(prepared).save(job['input'])
    log = run_dir/(model+'.log')
    command = [str(BIN),'-i',str(incoming),'-o',str(outgoing),'-m',str(MODELS),'-n',model,'-s','4','-t','192','-g','0','-j','1:2:2','-f','png']
    start = time.monotonic()
    print('GPU START',model,len(jobs),'sheets',flush=True)
    with log.open('w') as stream:
        subprocess.run(command, stdout=stream, stderr=subprocess.STDOUT, check=True, timeout=900)
    assert 'NVIDIA GeForce RTX 3070 Ti' in log.read_text(), 'NVIDIA Vulkan device was not used'
    results = {}
    for job in jobs:
        w,h = job['native_size']
        out = Image.open(job['raw']).convert('RGBA')
        assert out.size == ((w+2*PAD)*SCALE,(h+2*PAD)*SCALE), job['relative']
        out = out.crop((PAD*SCALE,PAD*SCALE,(PAD+w)*SCALE,(PAD+h)*SCALE))
        original = Image.open(job['source']).convert('RGBA')
        alpha = original.getchannel('A').resize(out.size,Image.Resampling.LANCZOS)
        out.putalpha(alpha) # Authored silhouette, no inferred alpha holes/extra parts.
        destination = DEST/job['relative']; destination.parent.mkdir(parents=True,exist_ok=True)
        out.save(destination)
        results[str(job['relative'])] = {
            'source':str(job['source'].relative_to(ROOT)), 'source_sha256':sha(job['source']),
            'source_size':list(original.size), 'native_size':[w,h],
            'model':model,'model_files':model_hash(model),'binary_sha256':sha(BIN),
            'preprocess':PREPROCESS,'input':str(job['input'].relative_to(ROOT)),'input_sha256':sha(job['input']),
            'raw_gpu_output':str(job['raw'].relative_to(ROOT)), 'raw_gpu_sha256':sha(job['raw']),
            'output':str(destination.relative_to(ROOT)), 'output_sha256':sha(destination),
            'output_size':list(out.size),'neural_scale':4,'native_adapter':job['native_adapter'],
            'alpha':'authored source alpha, Lanczos to output size',
            'gpu_log':str(log.relative_to(ROOT)),'batch_seconds':round(time.monotonic()-start,3)}
    print('GPU DONE',model,round(time.monotonic()-start,2),'seconds',flush=True)
    return results

def assemble(records):
    art = read(SRC/'graphics.json')
    extracted = read(ROOT/'original/export/graphics.json')
    commands = read(SRC/'commands.json')
    manifests, outputs = {}, {}
    packs = {(int(p.stem[5]),int(p.stem.split('_')[1])):Image.open(p).convert('RGBA') for p in (DEST/'packs').glob('*.png')}
    packs[1,7] = packs[0,10]
    native_packs = {(int(p.stem[5]),int(p.stem.split('_')[1])):Image.open(p).convert('RGBA') for p in (SRC/'packs').glob('*.png')}
    native_packs[1,7] = native_packs[0,10]
    def install(path, image, logical=None):
        original = ROOT/'game'/path.removeprefix('res://')
        relative = original.relative_to(SRC)
        target = DEST/relative.with_suffix('.png')
        target.parent.mkdir(parents=True,exist_ok=True)
        image.save(target)
        if logical is None: logical = list(Image.open(original).size)
        assert image.size == (logical[0]*SCALE,logical[1]*SCALE),(path,image.size,logical)
        manifests[path] = {'path':res(target),'logical_size':logical,'scale':SCALE}
        outputs[res(target)] = sha(target)
    def crop(pack,index,rect):
        x,y,w,h = map(int,rect)
        if w<=0 or h<=0: return Image.new('RGBA',(max(1,w)*SCALE,max(1,h)*SCALE))
        result = packs[pack,index].crop((x*SCALE,y*SCALE,(x+w)*SCALE,(y+h)*SCALE))
        # Sampling the mask of the entire sheet would leak adjacent sprites into
        # this rectangle. Resize the authored crop alone, with its own boundaries.
        alpha = native_packs[pack,index].crop((x,y,x+w,y+h)).getchannel('A')
        result.putalpha(alpha.resize(result.size, Image.Resampling.LANCZOS))
        return result
    # Direct source sheets, menu and font adapter already passed through GPU.
    for relative,record in records.items():
        path = SRC/relative; target = DEST/relative
        manifests[res(path)] = {'path':res(target),'logical_size':record['source_size'],'scale':SCALE/record['native_adapter']}
        outputs[res(target)] = sha(target)
    shutil.copyfile(SRC/'fonts/original.fnt',DEST/'fonts/original.fnt')
    for actor in art['actors']:
        for animation in actor['animations'].values():
            for frame in animation['frames']: install(frame['path'],crop(0,actor['id'],frame['rect']))
    for name,entry in art['tiles'].items():
        if isinstance(entry,list):
            for frame in entry: install(frame['path'],crop(1,2,frame['rect']))
        elif name.startswith(('grass_','cursor_')):
            install(entry['path'],crop(2,0 if name.startswith('grass') else 1,[0,int(name[-1])*20,38,20]))
        elif name.startswith('water_'): install(entry['path'],crop(1,5,[0,int(name[-1])*19,38,20]))
        else: install(entry['path'],crop(1,2,[0 if name=='path_dirt' else 38,104,38,20]))
    ui_packs={'icons':(2,7),'cursors':(2,9),'menu_glyphs':(2,7),'buttons':(2,3),'button_labels':(2,3),'touch_buttons':(2,2)}
    for name,(pack,index) in ui_packs.items():
        for frame in art['ui'][name]: install(frame['path'],crop(pack,index,frame['rect']))
    def compile_frame(frame, instructions):
        source = ROOT/'game'/frame['path'].removeprefix('res://')
        if source.suffix != '.png': return
        size = Image.open(source).size
        out = Image.new('RGBA',(size[0]*SCALE,size[1]*SCALE));left,top=frame['offset']
        for c in instructions:
            if int(c[0])==0:
                piece = crop(c[1],c[2],c[3:7])
                out.alpha_composite(piece,((c[7]-left)*SCALE,(c[8]-top)*SCALE))
            else:
                rgb = int(c[5]);color=(rgb>>16&255,rgb>>8&255,rgb&255,255)
                ImageDraw.Draw(out).line(((c[1]-left)*SCALE,(c[2]-top)*SCALE,(c[3]-left)*SCALE,(c[4]-top)*SCALE),fill=color,width=SCALE)
        install(frame['path'],out,list(size))
    for item in extracted['rides']:
        compile_frame(item['frames'][0],commands['rides'][item['id']][0])
    for item in extracted['scenery']:
        variants=item.get('source_variants',item['variants'])
        native_commands = commands['scenery'][item['id']]
        if not native_commands:
            # Dormant props14/22 are not sold in the original catalog. Old saves
            # still render their authored raw rectangles, never the remake SVG.
            sys.path.insert(0,str(ROOT/'original'))
            from scenery_geometry import commands_for
            prop=read(ROOT/'original/data/game_data.json')['props'][item['id']]
            native_commands={state:[[[0,c['pack'],c['index'],*c['rect'],*c['offset']] for c in phase] for phase in frames] for state,frames in commands_for(prop).items()}
        # Most animation bodies render directly from GPU atlases. Keep all small
        # service variants available for legacy objects and catalog previews.
        for state,frames in variants.items():
            for i,frame in enumerate(frames):
                instructions=native_commands.get(state,[])
                if instructions: compile_frame(frame,instructions[i%len(instructions)])
    # Isolate every live draw-command region before mipmaps are generated. GPU
    # inference is still shared across all phases, but neighbouring atlas sprites
    # can no longer bleed into transparent edges while zooming out.
    part_keys = set()
    def visit(value):
        if isinstance(value, dict):
            for child in value.values(): visit(child)
        elif isinstance(value, list):
            if len(value) == 9 and isinstance(value[0], (int,float)) and value[0] == 0:
                part_keys.add(tuple(map(int,value[1:7])))
            else:
                for child in value: visit(child)
    visit(commands)
    for frame in art['tiles']['edges']:
        part_keys.add((1,2,*map(int,frame['rect'])))
    tables = read(ROOT/'original/data/game_data.json')['tables']
    for actor in range(8):
        for pose in range(4):
            rect = tables[0][actor*24+pose*6:actor*24+pose*6+4]
            part_keys.add((0,actor,*rect))
    part_keys.add((1,*tables[75][:5]))
    part_keys.update([(1,1,40,0,12,9),(1,6,0,112,15,12),(1,2,90,83,15,20),(1,2,105,84,18,13)])
    # Cafe front tables/chairs from park_layers._draw_cafe_guests.
    part_keys.update([(1,2,0,28,27,20),(1,2,0,48,27,20),(1,2,27,29,21,17),(1,2,27,46,20,17)])
    parts = {}
    for key in sorted(part_keys):
        pack,index,x,y,w,h = key
        if w <= 0 or h <= 0: continue
        target = DEST/'parts'/('_'.join(map(str,key))+'.png')
        target.parent.mkdir(parents=True,exist_ok=True)
        crop(pack,index,[x,y,w,h]).save(target)
        parts[':'.join(map(str,key))] = {'path':res(target),'logical_size':[w,h],'scale':SCALE}
        outputs[res(target)] = sha(target)
    write(DEST/'manifest.json',manifests)
    write(DEST/'part_manifest.json',parts)
    report={'schema':1,'method':'NVIDIA Vulkan Real-ESRGAN, original atlas reuse','api_cost_usd':0,'neural_scale':4,
            'device':'NVIDIA GeForce RTX 3070 Ti 8GB','sources':records,'mapped_resources':len(manifests),'isolated_parts':len(parts),'outputs':outputs,
            'animation_geometry':'Original logical dimensions and offsets; shared source atlas for every phase',
            'font_adapter':'Original BMFont packing retained; 4x nearest expansion undone before GPU processing'}
    write(WORK/'report.json',report)
    print('INSTALLED',len(manifests),'mapped resources; original files untouched',flush=True)

def check():
    report=read(WORK/'report.json');mapping=read(DEST/'manifest.json');parts=read(DEST/'part_manifest.json')
    count=0
    for item in report['sources'].values():
        assert sha(ROOT/item['source'])==item['source_sha256'],'Original changed'
        assert sha(ROOT/item['raw_gpu_output'])==item['raw_gpu_sha256'],'GPU result changed'
        assert sha(ROOT/item['output'])==item['output_sha256'],'Installed source changed'
        assert item['neural_scale']==4 and 'NVIDIA' in (ROOT/item['gpu_log']).read_text()
        assert item['preprocess']==PREPROCESS and sha(ROOT/item['input'])==item['input_sha256']
        count+=5
    for key,value in list(mapping.items())+list(parts.items()):
        target=ROOT/'game'/value['path'].removeprefix('res://')
        assert value['path'].startswith('res://assets/upscaled/')
        assert sha(target)==report['outputs'][value['path']]
        image=Image.open(target); image.verify()
        assert image.size==tuple(round(v*value['scale']) for v in value['logical_size']),key
        count+=4
    # Regression for black RGB halos: grass has no authored black outline.
    grass = Image.open(DEST/'packs/gpack2_0.png').convert('RGBA')
    assert min(g for r,g,b,a in grass.get_flattened_data() if a > 240) >= 80, 'Dark SR halo on grass'
    count += 1
    print('UPSCALE OK:',count,'checks;',len(report['sources']),'GPU sources;',len(mapping),'mapped resources;',len(parts),'isolated parts; API $0')

def main():
    parser=argparse.ArgumentParser(description=__doc__)
    parser.add_argument('--run',action='store_true');parser.add_argument('--check',action='store_true');parser.add_argument('--assemble',action='store_true')
    args=parser.parse_args()
    if args.check: check(); return
    if args.assemble: assemble(read(WORK/'sources.json')); check(); return
    if not args.run: parser.error('Use --run, --assemble, or --check')
    jobs=source_jobs();existing=read(WORK/'sources.json') if (WORK/'sources.json').exists() else {}
    groups={};records={}
    for job in jobs:
        name=str(job['relative']);old=existing.get(name,{})
        if old.get('preprocess') == PREPROCESS and old.get('model_files') == model_hash(job['model']) and old.get('binary_sha256') == sha(BIN) and old.get('source_sha256')==sha(job['source']) and old.get('model')==job['model'] and (DEST/name).exists() and old.get('output_sha256')==sha(DEST/name):
            records[name]=old
        else: groups.setdefault(job['model'],[]).append(job)
    run_dir=WORK/'runs'/str(time.time_ns());run_dir.mkdir(parents=True,exist_ok=True)
    with ThreadPoolExecutor(max_workers=2) as pool:
        futures=[pool.submit(infer_group,model,items,run_dir) for model,items in groups.items()]
        for future in futures: records.update(future.result())
    write(WORK/'sources.json',records)
    assemble(records);check()

if __name__=='__main__': main()
