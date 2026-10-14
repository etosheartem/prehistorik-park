extends RefCounted
const Graphics = preload("res://scripts/park_graphics.gd")
## Files are replaced only after a complete JSON write; a validated previous save is retained.

static func read_json(path: String) -> Dictionary:
	if not FileAccess.file_exists(path): return {}
	var parser := JSON.new()
	if parser.parse(FileAccess.get_file_as_string(path)) != OK: return {}
	return parser.data if parser.data is Dictionary else {}

static func write_json(path: String, data: Dictionary) -> bool:
	var temporary := path + ".tmp"
	var output := FileAccess.open(temporary, FileAccess.WRITE)
	if output == null: return false
	output.store_string(JSON.stringify(data))
	output.flush()
	var ok := output.get_error() == OK
	output.close()
	if not ok:
		DirAccess.remove_absolute(temporary)
		return false
	if FileAccess.file_exists(path) and not read_json(path).is_empty():
		var copied := DirAccess.copy_absolute(path, path + ".bak")
		if copied != OK:
			DirAccess.remove_absolute(temporary)
			return false
	return DirAccess.rename_absolute(temporary, path) == OK

static func save_settings(path: String, values: Dictionary) -> bool:
	return write_json(path, {"version": 3, "settings": values})

static func defaults() -> Dictionary:
	return {"music": 0.45, "effects": 0.65, "quality": Graphics.DEFAULT, "debug": false,
		"fps": 60, "shadows": true, "particles": true, "color_style": "natural",
		"transparent_trees": true, "reduced_motion": false, "build_grid": true, "camera_speed": 1.0}

static func settings(path: String) -> Dictionary:
	var defaults := defaults()
	var raw = read_json(path).get("settings", {})
	var saved: Dictionary = raw if raw is Dictionary else {}
	for key in ["music", "effects"]:
		if saved.get(key) is float or saved.get(key) is int:
			var number := float(saved[key])
			if is_finite(number): defaults[key] = clampf(number, 0, 1)
	for key in ["shadows", "particles", "reduced_motion", "build_grid", "transparent_trees"]:
		if saved.get(key) is bool: defaults[key] = saved[key]
	if (saved.get("fps") is int or saved.get("fps") is float) and saved.fps in [30.0, 60.0]: defaults.fps = int(saved.fps)
	if saved.get("color_style") in ["natural", "vivid", "warm"]: defaults.color_style = saved.color_style
	if saved.get("camera_speed") is float or saved.get("camera_speed") is int:
		var number := float(saved.camera_speed)
		if is_finite(number): defaults.camera_speed = clampf(number, 0.6, 1.6)
	defaults.quality = Graphics.normalize(saved.get("quality"))
	if saved.get("debug") is bool and "--allow-test-tools" in OS.get_cmdline_user_args(): defaults.debug = saved.debug
	return defaults
