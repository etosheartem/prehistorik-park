# Original-asset audit for 0.2

The ticket booth drawings previously stored under `assets/original/scenery/14`
and `/22` are local replacements, not original art. The two ticket booth records
are dormant in the supplied JAR: neither is offered in its building catalog or
reachable by rotating an available object. No correct original booth picture
has been found in this JAR. Do not label those SVGs as original artwork.

## Evidence for the ticket records

The decoder matches the original loader: `e.java:1243–1264` reads three header
bytes and sixteen length-prefixed sections per prop. The complete `arrsi.dat`
and `arr.dat` are consumed exactly. `e.java:2930–2967` reads the source image
index from prop section6 and always indexes the pack1 image array. There is no
alternate booth bank. `e.java:572–598` loads the PNGs in order and has only one
alias, pack1[7] to pack0[10]. All packed PNGs were checked byte-for-byte against
the original archived JAR, not just against previously exported files.

| Prop | Source image | Rectangle | Sheet size | Actual result |
|---|---|---|---|---|
| 14 | gpack1[4] | x0 y38 w32 h30 | 108×87 | Cropped upper portion of the ice cream kiosk |
| 22 | gpack1[4] | x0 y68 w32 h30 | 108×87 | Bottom fragments; 11 rows outside the PNG |

The unstaffed markers are also invalid: `[102,80,7,13]` and `[102,93,7,13]`.
The exported PNGs preserve the visible source pixels and use transparent padding
outside the image. Padding is an exporter recovery convention, not how a valid
J2ME `drawRegion` call behaves. These records were already invalid in the JAR.

The stronger explanation is that these are unused records rather than missing
assets in the extractor:

- `e.bi()` at line3692 and `e.bk()` at line3761 select kind/id pairs from tables
  146–150 and151–155. Neither ticket prop appears in any catalog.
- Table162 controls prop rotation (`e.java:3591`). Ticket14 rotates to22 and22
  back to14; no available prop rotates into this isolated pair.
- Reachable props from all catalog entries and rotation are
  `0..13,15..21,23,25,26`. Prop24 is also absent from normal selection.
- Initial availability flags in table41 do include the tickets, but that does
  not make them selectable: the catalog above supplies the actual entries.

Recommendation: hide14/22 from all new purchases. For legacy remake saves,
keep the type IDs supported. Original modes can select each record's existing
`source_variants`; remakes may keep the explicitly identified replacement SVGs.
`original_metadata_override.json` contains the exact frames/variants and offsets
for this mode-specific choice. No existing PNG needs to change.

## Exact source inventory

`raw_inventory.json` lists every source path, size, SHA256 and packed byte offset.

- `original/jar/gpack0.dat`: eleven PNGs, actors0–10.
- `original/jar/gpack1.dat`: thirteen slots, twelve PNGs, plus the alias above.
  Ride, scenery and terrain components are here.
- `original/jar/gpack2.dat`: twelve PNGs, UI/font/terrain/cursors/awards.
- All35 nonempty PNG payloads exist byte-exact as
  `res://assets/original/packs/gpack{bank}_{index}.png`.
- `original/jar/icon.png` and `splash0.png`/`splash1.png`/`splash2.png` are direct
  JAR resources. Their `res://assets/original/ui/*.png` copies were re-encoded
  as RGBA, but dimensions and every decoded pixel match.
- `res://assets/original/fonts/original.png` is an adapter atlas, not an original
  JAR PNG: native glyphs were repacked at nearest-neighbor4×. `original.fnt` is
  generated BMFont metadata. `Ё/ё` is an explicit synthetic addition (native Е
  plus two code-drawn yellow dots); lower-case aliases native capital glyphs.
- The only SVG files beneath `assets/original` are the six synthetic ticket
  states. They must not be included in a raw-source upscale batch.
- Ride/scenery/actor/tile/UI crop PNGs are reconstructed from original pixels
  and tables. The raw35 payloads remain the primary evidence, and the full
  source geometry report remains `original/export/graphics.json`.

## Native menu and font sources

The loading art `splash2.png` is not the original menu background. `c.paint()`
loads splash images; the actual menu is composed by `e.y()/z()` from:

| Resource | Native size | Role |
|---|---:|---|
| `res://assets/original/packs/gpack2_4.png` | 36×42 | Repeating left/right stone border |
| `res://assets/original/packs/gpack2_5.png` | 148×160 | Overhanging leaves |
| `res://assets/original/packs/gpack2_8.png` | 63×25 | Header strips and decoration |
| `res://assets/original/packs/gpack2_3.png` | 156×116 | Stone controls, arrows and label pieces |
| `res://assets/original/packs/gpack2_2.png` | 105×56 | Touch controls |
| `res://assets/original/packs/gpack2_6.png` | 180×73 | Original glyphs and numeric counter font |
| `res://assets/original/packs/gpack2_7.png` | 124×53 | Status and other interface icons |

`menu_blank_native.png` reproduces the background at240×320 without labels or
controls; `menu_blank_nearest3x.png` is its lossless nearest preview. Exact
coordinates and colors are implemented in `original/audit_original.py` using
the constants in `b.java:119–125` and `d.java:79–92`.

## Reproduction and validation

```sh
python original/audit_original.py
python original/check_assets.py
```

The audit writes only its own report directory. Runtime images, metadata,
rendering scripts and gameplay code were left untouched. Validation passed:
35 byte-exact packed PNGs,4 pixel-exact direct PNGs,4369 extraction assertions,
822 unique exported images and stable1209 ride phases.
