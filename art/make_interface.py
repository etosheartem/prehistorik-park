#!/usr/bin/env python3
"""Hand-drawn, repeatable UI vectors. No network or image-generation service."""
from pathlib import Path
import shutil

ROOT = Path(__file__).resolve().parents[1]
OUT = ROOT / "game/assets/ui/crafted"
OUT.mkdir(parents=True, exist_ok=True)

def save(name, body, width=192, height=144):
    (OUT / f"{name}.svg").write_text(f'<svg xmlns="http://www.w3.org/2000/svg" width="{width}" height="{height}" viewBox="0 0 {width} {height}">{body}</svg>\n')

# The corners stay intact when Godot stretches the centre with nine-patches.
for name, light, dark, rim in [
    ("stone", "#f3dfad", "#e2c58d", "#8f673e"),
    ("paper", "#fff2cf", "#f5e4bc", "#c2a46d"),
    ("wood", "#865935", "#62412b", "#382b21"),
    ("wood_hover", "#9b6d43", "#795032", "#3d2c20"),
    ("amber", "#ffda7b", "#e6ab43", "#8e5528"),
    ("amber_down", "#e2ae4c", "#d59535", "#845326"),
    ("disabled", "#e2d5b8", "#cfc0a1", "#aa9776"),
    ("danger", "#bd6749", "#9c4935", "#673628"),
]:
    body = f'''<defs><linearGradient id="g" x2="0" y2="1"><stop stop-color="{light}"/><stop offset="1" stop-color="{dark}"/></linearGradient></defs>
    <path d="M18 7 L174 7 L187 20 L185 123 L174 138 L17 137 L5 125 L5 22 Z" fill="#30291c" opacity=".22"/>
    <path d="M18 3 L174 3 L187 16 L185 119 L174 134 L17 133 L5 121 L5 18 Z" fill="url(#g)" stroke="{rim}" stroke-width="4"/>
    <path d="M21 10 L171 10 L179 20 M13 23 L13 111 M20 124 L171 125 L178 115" fill="none" stroke="{light}" stroke-width="3" opacity=".8"/>
    <path d="M21 129 L170 130 L181 119 L182 25" fill="none" stroke="{rim}" stroke-width="2" opacity=".55"/>'''
    if name.startswith("wood"):
        body += '<path d="M31 20 Q55 13 76 20 M120 18 Q143 24 164 18 M32 116 Q56 122 83 116 M114 120 Q136 112 163 117" fill="none" stroke="#c59159" stroke-width="2" opacity=".4"/>'
    for x, y in [(21, 22), (171, 22), (21, 115), (171, 115)]:
        body += f'<path d="M{x-3} {y-1} l3 -3 l3 2 l-1 4 l-4 0 Z" fill="{rim}" opacity=".45"/>'
    save(name, body)

icons = {
    "build": '<path d="M10 33 L27 15 L34 22 L17 40 Z" fill="#efbc58"/><path d="M27 10 L35 6 L50 20 L45 29 L36 28 L24 17 Z" fill="#eee0b8"/><path d="M13 46 L37 46"/>',
    "staff": '<circle cx="22" cy="17" r="8" fill="#efbc58"/><circle cx="42" cy="21" r="6" fill="#eee0b8"/><path d="M8 46 Q8 29 22 29 Q37 29 37 46 Z" fill="#efbc58"/><path d="M39 33 Q51 29 52 46 H43" fill="#eee0b8"/>',
    "park": '<path d="M10 45 L10 25 L28 11 L48 25 V45 Z" fill="#efbc58"/><path d="M21 45 V30 H36 V45" fill="#876543"/><path d="M30 10 V4 L47 9 L30 14" fill="#8eb25a"/>',
    "map": '<path d="M5 13 L21 7 L37 13 L53 7 V44 L37 50 L21 44 L5 50 Z" fill="#ead9ab"/><path d="M21 8 V44 M37 13 V49"/><path d="M11 35 Q26 18 44 30" stroke="#7f9950" stroke-dasharray="4 5"/>',
    "settings": '<path d="M9 15 H49 M9 29 H49 M9 43 H49"/><circle cx="22" cy="15" r="6" fill="#efbc58"/><circle cx="39" cy="29" r="6" fill="#eee0b8"/><circle cx="19" cy="43" r="6" fill="#efbc58"/>',
    "help": '<path d="M18 17 Q18 5 31 6 Q46 8 42 22 Q40 27 30 31 V36" stroke="#efbc58" stroke-width="6"/><circle cx="30" cy="46" r="3" fill="#efbc58"/>',
    "play": '<path d="M18 9 L47 29 L18 49 Z" fill="#fff0c8"/>',
    "close": '<path d="M15 15 L43 43 M43 15 L15 43" stroke="#f7e8be" stroke-width="6"/>',
    "check": '<path d="M10 30 L23 42 L48 15" stroke="#624222" stroke-width="6"/>',
    "lock": '<rect x="13" y="25" width="33" height="25" rx="4" fill="#c0ad87"/><path d="M20 25 V18 Q20 4 30 6 Q41 5 40 25"/><path d="M30 34 V41"/>',
    "coin": '<circle cx="29" cy="29" r="22" fill="#f4c261"/><circle cx="29" cy="29" r="15" stroke="#c48a35"/><path d="M31 17 L23 30 H35 L27 42" stroke="#8f572b"/>',
    "sun": '<circle cx="29" cy="29" r="15" fill="#f4c261"/><path d="M29 3 V8 M29 50 V55 M3 29 H8 M50 29 H55 M10 10 L14 14 M44 44 L48 48 M10 48 L14 44 M44 14 L48 10"/>',
}
for name, shape in icons.items():
    save(name, f'<g fill="none" stroke="#513b29" stroke-width="3" stroke-linejoin="round" stroke-linecap="round">{shape}</g>', 58, 58)
save("knob", '<circle cx="24" cy="25" r="20" fill="#68432d"/><circle cx="24" cy="22" r="18" fill="#ffda7c" stroke="#a36d31" stroke-width="3"/><path d="M20 15 V29 M28 15 V29" stroke="#ae7c3b" stroke-width="3"/>', 48, 48)

fonts = ROOT / "game/assets/ui/fonts"
fonts.mkdir(exist_ok=True)
for name in ["NotoSans-Regular", "NotoSans-Bold", "NotoSerif-Bold"]:
    target = fonts / f"{name}.ttf"
    source = Path(f"/usr/share/fonts/noto/{name}.ttf")
    if not target.exists() and source.exists():
        shutil.copyfile(source, target)
license_file = fonts / "LICENSE.txt"
if not license_file.exists():
    shutil.copyfile("/usr/share/licenses/noto-fonts/LICENSE", license_file)
print(f"Interface: {len(list(OUT.glob('*.svg')))} local SVG assets")
