extends RefCounted
## One resource contract for every graphics mode. A source-style mode can never
## resolve a remake image, including secondary atlas crops and menu textures.

const IDS := ["original", "original_upscaled", "remake_medium", "remake_maximum"]
const LABELS := ["Оригинальные", "Оригинальные · апскейл", "Ремейк · среднее (beta)", "Ремейк · макс (beta)"]
const DEFAULT := "original_upscaled"
const ORIGINAL_ROOT := "res://assets/original/"
const UPSCALED_ROOT := "res://assets/upscaled/"
const REMAKE_ROOT := "res://assets/hd/"

static func normalize(value) -> String:
	if value is String and value in IDS: return value
	if value == "economy": return "original"
	# Old settings selected the rejected remake automatically. Updating keeps the
	# player's audio and save while starting with the original art instead.
	return DEFAULT

static func is_remake(mode: String) -> bool:
	return normalize(mode) in ["remake_medium", "remake_maximum"]

static func effects_level(mode: String) -> int:
	match normalize(mode):
		"remake_medium": return 1
		"remake_maximum": return 2
	return 0

static func texture_filter(mode: String) -> int:
	return CanvasItem.TEXTURE_FILTER_NEAREST if normalize(mode) == "original" else CanvasItem.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS

static func msaa(mode: String) -> int:
	match effects_level(mode):
		1: return Viewport.MSAA_2X
		2: return Viewport.MSAA_4X
	return Viewport.MSAA_DISABLED

static func fps(_mode: String) -> int:
	return 60

static func asset_root(mode: String) -> String:
	match normalize(mode):
		"original_upscaled": return UPSCALED_ROOT
		"remake_medium", "remake_maximum": return REMAKE_ROOT
	return ORIGINAL_ROOT

static func _json(path: String) -> Dictionary:
	if not FileAccess.file_exists(path): return {}
	var parser := JSON.new()
	if parser.parse(FileAccess.get_file_as_string(path)) != OK: return {}
	return parser.data if parser.data is Dictionary else {}

static func replacement_path(entry) -> String:
	if entry is String: return entry
	if entry is Dictionary: return str(entry.get("path", ""))
	return ""

static func _filtered(mode: String, raw: Dictionary, parts := false) -> Dictionary:
	var result := {}
	var prefix := asset_root(mode)
	for key in raw:
		if not parts and not str(key).begins_with(ORIGINAL_ROOT): continue
		var path := replacement_path(raw[key])
		# Prefix allowlists deliberately forbid a malformed upscale manifest from
		# falling through to an HD remake, including ../ traversal.
		if path.begins_with(prefix) and not "/../" in path:
			result[key] = raw[key]
	return result

static func load_manifest(mode: String) -> Dictionary:
	if normalize(mode) == "original": return {}
	var result := _filtered(mode, _json(asset_root(mode) + "manifest.json"))
	if is_remake(mode):
		result.merge(_filtered(mode, _json(REMAKE_ROOT + "terrain/manifest.json")), true)
	return result

static func load_part_manifest(mode: String) -> Dictionary:
	if normalize(mode) == "original": return {}
	return _filtered(mode, _json(asset_root(mode) + "part_manifest.json"), true)

static func menu_path(mode: String, portrait := true) -> String:
	if not is_remake(mode):
		var path := ORIGINAL_ROOT + "ui/splash2.png"
		var replacement := replacement_path(load_manifest(mode).get(path, ""))
		return replacement if not replacement.is_empty() and ResourceLoader.exists(replacement) else path
	var name := "menu_portrait" if portrait else "menu_background"
	if normalize(mode) == "remake_medium": name += "_hd"
	return REMAKE_ROOT + "ui/" + name + ".png"

static func font_path(mode: String) -> String:
	if normalize(mode) == "original_upscaled":
		var path := UPSCALED_ROOT + "fonts/original.fnt"
		if ResourceLoader.exists(path): return path
	return ORIGINAL_ROOT + "fonts/original.fnt"

static func art_for(mode: String, source: Dictionary) -> Dictionary:
	var result: Dictionary = source.duplicate(true)
	if not is_remake(mode):
		for item in result.get("scenery", []):
			# v0.1 repaired two dormant records with invented SVG ticket booths.
			# Keep those only in the remake. Old saves still resolve their exact JAR
			# rectangles in source modes, even though these aren't purchasable.
			if item.has("source_variants"):
				item.variants = item.source_variants
				item.frames = item.source_variants.working
				item.erase("local_repair")
	return result
