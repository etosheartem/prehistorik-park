#!/usr/bin/env python3
"""Submit one reproducible, local-only ComfyUI illustration. No paid APIs."""
import json
import urllib.request
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PROMPT = """A lavish hand-painted illustration for a cheerful prehistoric theme-park
management game. Vertical book-cover composition, polished Franco-Belgian comic art,
crisp ink outlines, expressive shapes, richly painted surfaces, warm afternoon sunlight.
A charismatic friendly scruffy caveman park keeper in a simple orange spotted animal-skin
tunic, barefoot, happy open smile, a little green dinosaur perched on his shoulder. He
stands on the right side of the middle third of the image, inviting us into his park.
Behind him a magnificent working wooden Ferris wheel with four hanging wicker gondolas,
a curving timber roller coaster, a giant stone dinosaur-mouth entrance, rope bridges,
rounded tropical palms, colorful bunting made of leaves. Tiny caveman families visit.
The park is built entirely from timber, stone, rope and bones. Emerald jungle valley,
turquoise river, distant soft hazy mountains. Rich green foliage, golden sand paths,
warm amber highlights and deep teal shadows. Charming handcrafted toy-like detail.
Clear composition: the top quarter is airy pale turquoise sky framed by curved palms,
for a game title to be placed later; all the main attractions and the hero occupy the
middle half. The lower quarter is a calm dark green grassy foreground suitable for
buttons. Beautiful professional game key art, visually readable and cohesive.
No lettering, no words, no logos, no watermark, no UI, no modern objects, no extra limbs.
"""

def workflow():
    return {
        "1": {"class_type": "UnetLoaderGGUF", "inputs": {"unet_name": "krea2_turbo-Q4_0.gguf"}},
        "2": {"class_type": "CLIPLoader", "inputs": {"clip_name": "qwen3vl_4b_fp8_scaled.safetensors", "type": "krea2", "device": "default"}},
        "3": {"class_type": "VAELoader", "inputs": {"vae_name": "qwen_image_vae.safetensors"}},
        "4": {"class_type": "CLIPTextEncode", "inputs": {"text": PROMPT, "clip": ["2", 0]}},
        "5": {"class_type": "ConditioningZeroOut", "inputs": {"conditioning": ["4", 0]}},
        "6": {"class_type": "EmptyLatentImage", "inputs": {"width": 1024, "height": 1536, "batch_size": 1}},
        "7": {"class_type": "KSampler", "inputs": {"model": ["1", 0], "positive": ["4", 0], "negative": ["5", 0], "latent_image": ["6", 0], "seed": 2026101301, "steps": 10, "cfg": 1, "sampler_name": "euler", "scheduler": "simple", "denoise": 1}},
        "8": {"class_type": "VAEDecode", "inputs": {"samples": ["7", 0], "vae": ["3", 0]}},
        "9": {"class_type": "SaveImage", "inputs": {"images": ["8", 0], "filename_prefix": "prehistorik_park/menu_1_0"}},
    }

if __name__ == "__main__":
    graph = workflow()
    out = ROOT / "art/local"
    out.mkdir(exist_ok=True)
    (out / "menu_workflow.json").write_text(json.dumps(graph, indent=2) + "\n")
    request = urllib.request.Request("http://127.0.0.1:8188/prompt", data=json.dumps({"prompt": graph}).encode(), headers={"Content-Type": "application/json"})
    with urllib.request.urlopen(request, timeout=30) as response:
        result = json.load(response)
    (out / "menu_job.json").write_text(json.dumps(result, indent=2) + "\n")
    print(result)
