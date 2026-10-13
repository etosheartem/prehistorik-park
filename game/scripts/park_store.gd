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
	return write_json(path, {"version": 2, "settings": values})

static func settings(path: String) -> Dictionary:
	var defaults := {"music": 0.45, "effects": 0.65, "quality": Graphics.DEFAULT, "debug": false}
	var raw = read_json(path).get("settings", {})
	var saved: Dictionary = raw if raw is Dictionary else {}
	for key in ["music", "effects"]:
		if saved.get(key) is float or saved.get(key) is int:
			var number := float(saved[key])
			if is_finite(number): defaults[key] = clampf(number, 0, 1)
	defaults.quality = Graphics.normalize(saved.get("quality"))
	if saved.get("debug") is bool and "--allow-test-tools" in OS.get_cmdline_user_args(): defaults.debug = saved.debug
	return defaults
