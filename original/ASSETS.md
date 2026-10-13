# Graphics extraction and runtime contract

Run from the project root:

```sh
python original/export_data.py
python original/export_assets.py
python original/export_part_atlases.py
python original/check_assets.py
```

These commands are local, require Python and Pillow, and make no API requests.
The atlas exporter prepares optional HD reference sheets; it does not replace game art.

## Sources and losslessness

`original/jar/gpack{0,1,2}.dat` contain 11, 13 and 12 slots. Every slot is a
little-endian unsigned 16-bit PNG length followed by that many bytes. Pack1 slot7
has length0 and aliases pack0 slot10 (`e.b()`). The 35 PNG payloads are copied
byte for byte into `game/assets/original/packs/`. Their source offsets, SHA256,
palette and transparency are recorded in `original/export/graphics.json`.

`original/export_data.py` owns the binary table parser. Graphic rectangles,
isometric depth, motion phases and offsets come from its signed `arr.dat` arrays,
not guessed connected components or rectangles detected in screenshots.

## Runtime JSON

`game/assets/original/graphics.json` contains paths starting with `res://`:

* `tiles`: grass0–2, dirt/stone roads, three water frames, selection markers,
  25 edge pieces and decorative details. The tile names use underscores,
  e.g. `grass_0`, `path_dirt`, `water_0`.
* `actors[id].animations.walk_0` through `walk_3`: three authored poses with
  the original walking sequence `[0,1,0,2]`. All11 sprite sheets have walk data;
  only the first8 have additional sitting, ride and special poses.
* `rides[id].frames`: one record for every original phase. Repeated pixel-identical
  frames reuse their PNG. All frames within a ride share the same bounds and
  offset, preventing texture-centering jitter. These are unoccupied rides;
  passenger sprites, entrance fences and paths remain world layers.
* `rides[id].layouts`: both original tile maps, plus `footprint`, `entry_tile`
  and `entry_tiles`. The two layout variants change entrance connections and
  do not imply arbitrary rotation of the whole image.
* `scenery[id].frames`: working/open phase sequence. `variants.closed` and
  `variants.unstaffed` preserve the status-overlay branches from `e.aG/aH`.
* `ui`: original splash images and cropped icon/cursor/button collections.
* `font.path`: original bitmap font in BMFont format. It maps lowercase Russian
  to the same capital glyphs as the J2ME game. Ё/ё are locally composed from Е
  and two dots. The source glyph atlas is unchanged in packs/gpack2_6.png.

Every frame's `offset` is its image top-left position in original world pixels.
For actors the anchor is the ground contact point. For scenery it is the tile
image origin. For rides it is the origin of the first tile in the footprint.
Isometric projection is `x=(tile_x+tile_y)*20`, `y=(tile_x-tile_y)*10`.
Add the offset before applying the viewport/world zoom; do not center frames
by their PNG dimensions. Pixels retain straight RGBA alpha and are lossless.

## Faithful motions and intentionally separate layers

The ride renderer follows `e.aD/aE/aF`: tile-assigned static parts, phased moving
parts, static/dynamic line segments and independently active interval segments.
`original/export/graphics.json` additionally stores every sprite/line command
with source rectangles, world offsets and depth. Runtime JSON omits these large
command lists; high-quality rendering reads a separate compact HD commands file,
while economy quality retains the assembled original frames.

Paths, entrance decorations, visitors sitting in rides, water passengers and
neighbor-dependent fences are separate layers in the original. The exported
ride image does not invent or bake those occupants. Cafeteria auxiliary tables
and connectable water-course tiles have explicit handling. Future full original
depth reconstruction can consume the recorded commands and raw data tables.

## Dormant source records: ticket kiosks

The source tables for prop14 (касса) select the ice cream art at pack1 slot4
rectangle `[0,38,32,30]`. Prop22 selects `[0,68,32,30]`, which extends beyond the
108×87 PNG. Their unstaffed markers also reference `[102,80,7,13]` and
`[102,93,7,13]`. The renderer's `e.aG/aH` uses exactly this pack without another
texture branch, and `e.b()` assigns no replacement to slot4.

The extraction report preserves these authored rectangles, transparent padding,
and `source_variants`. The playable assets use newly drawn repo-native SVG
wood/bone kiosks for both orientations, with the same1×1 footprint. These small
vector corrections cost no API calls and are identified by `local_repair` in JSON.
The exact source contact sheet intentionally still shows the broken original;
`original/export/ticket_repair_preview.png` shows the replacement.

Audit for version0.2 established why these records are invalid: neither prop14
nor22 is offered by the original construction catalog (tables146–155), and
their14↔22 rotation cycle is unreachable from available props. The replacement
SVGs are remake artwork and must not be used by an `original` graphics mode.
Use `source_variants` only for legacy-save compatibility and omit the dormant
records from new purchases. See `export/audit_v02/REPORT.md` and run
`python original/audit_original.py` for the reproducible provenance audit.

## Optional HD reconstruction from reusable parts

`art/reference/ride_parts/parts.json` maps106 unique sprite rectangles to seven
transparent sheets with16 fixed cells each. They account for22400 sprite draw
calls across1209 phases of24 rides. Native cells are64×96, enlarged8× to512×768;
each reference sheet is2048×3072. The last sheet has unused transparent cells.
`atlas_*.png` are references without labels; `review_*.png` are review-only grids.

Keep every cell, crop rectangle, rail endpoint and anchor in place. Cropping an
HD part from its atlas and drawing it at its original world rectangle preserves
all original animation commands. Full packed gpack redraws are risky because
many neighboring sprites have no padding. Generated images must pass alpha,
seam, anchor and motion review before installation. API use is a separate,
budget-controlled step; this exporter never starts generation.

`python original/export_part_atlases.py --normalized` creates a separate
`ride_parts_normalized` reference set. It enlarges each part independently to
fit its cell, records the exact `part_scale_xy`, and leaves six tiny peg/line
rectangles in `keep_local`. Its100 meaningful parts use the same seven sheets.
The assembly must restore each crop to its original `source_rect` world size;
the common atlas scale alone is insufficient for this normalized variant.

## HD installation and compact runtime

```sh
python original/export_part_atlases.py --normalized
python original/export_part_atlases.py --scenery --normalized
python art/install_parts.py --no-gifs --install
# Full-motion QA stays outside the game package:
python art/install_parts.py --all-frames --ride 0 --ride 3 --ride 19
```

The scenery contract adds 44 unique parts on three sheets, six exact horizontal
mirror aliases, seven tiny local details and reuse of six existing ride parts.
The installer automatically finds generated ride/scenery sheets and prefers a
matching `art/corrected/` file when a provider alpha defect has been repaired.
Missing sheets keep their original source crops. No step calls an API.

`game/assets/hd/part_manifest.json` maps `pack:index:x:y:w:h` to an HD PNG,
its logical source size and an optional `flip_x`. `commands.json` contains
compact, depth-sorted commands for every ride phase and each scenery state:
`[0,pack,index,x,y,w,h,dx,dy]` draws a part and
`[1,x1,y1,x2,y2,rgb]` draws an original line. Offsets remain original world
pixels; only texture sampling gains detail. `ParkLayers` renders these commands
for high/max quality; economy can retain assembled original sprites.

Only one assembled working frame per object is installed for catalog previews.
Those replacements share the ordinary `manifest.json` with character assets.
Full assembled animations remain in `art/review/parts`, avoiding approximately
1.55 GiB of decoded duplicated ride textures at eight-times scale. Runtime
part memory, alpha coverage, source silhouette similarity and local corrections
are recorded in `art/review/parts/report.json`.

Known local corrections: ride part56 is an exact mirror of part53 in the source;
its generated version resembled a spear, so the installer uses the mirrored
chain instead. Part57 excludes two pixels of the neighboring palm crown and
part61 includes those pixels. These changes preserve original anchors without
requiring another generated image. All raw provider images remain unchanged.

Actor10 is an original service cook sheet, also referenced by pack1 slot7.
Its zero-width/height walk rectangles are intentional source data, not valid
walking animation for a free-moving worker. Actors8/9 are the complete guard
and repair-worker sets. Runtime must not select actor10 for generic staff.

`python art/install_tickets.py` installs8x versions of the two locally repaired
vector ticket kiosks (six state/orientation assets). Godot rasterizes SVGs on
import, so keeping only a38x44 SVG would blur at large zoom. The HD override is
304x352, while the original frame still fixes its38x44 world size. Closed and
unstaffed kiosks correctly hide the cashier. These assets cost no API calls.

`python original/export_part_atlases.py --extras --normalized` prepares one
5x4 sheet of20 additional world parts plus two exact mirror aliases. Its native
cell is72x120 and its2880x3840 reference canvas has a provider-compatible3:4
ratio. The fixed grid covers benches, entry arches, flower borders and original
corner/entrance details. The installer supports its actual returned dimensions,
independent of reference resolution, and finds `extras_parts_0_2k_v1.png`.

Additional local checks:

```sh
python art/check_parts.py
python art/preview_motion.py 0 3 19
godot --headless --path game --script res://tests/layers_check.gd
# Requires a desktop display; writes art/review/parts/runtime_render.png:
godot --path game --script res://tests/part_render_check.gd
```

The compact renderer is checked against all1344 original ride/scenery phases.
The live renderer test verifies exact mirror bounds in addition to ride parts,
passengers, split water gates, a bench and the cafe's twelve original seats.
Review sheets `all_rides_hd.png` and `all_scenery_hd.png` are rebuilt by the
installer. Accepted silhouette differences are bound to the SHA256 of the
reviewed aligned crop in `accepted_qa.json`; new changes still require review.

The cafe smoke is a deliberate local vector correction: the provider interpreted
part48 as a stone pile. The installer rasterizes three translucent SVG puffs
with `rsvg-convert` in the exact original6x4/8x5/10x6 rectangles, preserving
the original rising-smoke commands. Scenery sheet2 occupied rows are recropped
at verified empty bands y700/y1400 because the provider shifted the layout.
Raw generation files remain untouched, and all corrections are in the report.

The four remaining tiny ride pieces are now local vectors too: two rope
segments (8x7 and 2x4 logical pixels) and two trampoline/launcher supports
(5x8 each). `local_micro_parts()` in the installer writes the SVG sources to
`art/reference/local/` and rasterizes them at 8x with the same source keys,
bounds and animation anchors. Together with the two smoke pieces above, this
covers every `keep_local` ride part. No API calls are needed. The before/after
sheet is `art/review/parts/micro_local_parts_0.png`; to inspect the actual
renderer with these rides, append `-- --micro` to the live render test command.
