extends SceneTree
## Compare actual drawing calls with the original mode, not just file counts.
const Layers = preload("res://scripts/park_layers.gd")
const Graphics = preload("res://scripts/park_graphics.gd")
const Sim = preload("res://scripts/park_sim.gd")

class LayerSpy:
	extends RefCounted
	var front_tints: Array[Color] = []
	func visual_phase(_view, _b) -> int: return 0
	func draw_ride_ground(_view, _b, _tint) -> void: pass
	func draw_ride_body(_view, _b, _tint) -> bool: return true
	func draw_ride_passengers(_view, _b) -> void: pass
	func draw_ride_fences_front(_view, _b, tint) -> void: front_tints.append(tint)

class GhostView:
	extends "res://scripts/park_view.gd"
	func origin() -> Vector2: return Vector2(100, 200)

class TraceView:
	extends RefCounted
	var sim
	var art: Dictionary
	var quality := "original"
	var part_overrides := {}
	var zoom := 1.0
	var elapsed := 0.0
	var calls: Array = []
	var cache := {}
	func origin() -> Vector2: return Vector2.ZERO
	func iso(cell: Vector2) -> Vector2: return Vector2((cell.x+cell.y)*20, (cell.x-cell.y)*10)
	func cell_to_screen(cell: Vector2) -> Vector2: return iso(cell)+Vector2(20,10)
	func footprint(cell: Vector2i) -> PackedVector2Array:
		var center := cell_to_screen(cell)
		return PackedVector2Array([center+Vector2(-20,0),center+Vector2(0,10),center+Vector2(20,0),center+Vector2(0,-10)])
	func _texture(path: String) -> Texture2D:
		if not cache.has(path):
			var texture := GradientTexture2D.new()
			texture.set_meta("path", path)
			cache[path] = texture
		return cache[path]
	func texture_for(path: String) -> Texture2D: return _texture(path)
	func draw_texture_rect_region(texture: Texture2D, target: Rect2, source: Rect2, tint: Color) -> void:
		calls.append([texture.get_meta("path"), source, target, tint])
	func draw_texture_rect(texture: Texture2D, target: Rect2, _tile: bool, tint: Color) -> void:
		calls.append([texture.get_meta("path"), target, tint])
	func _frame(frame: Dictionary, at: Vector2, tint := Color.WHITE) -> void:
		calls.append([frame.path, at, tint])
	func draw_colored_polygon(_polygon: PackedVector2Array, _color: Color) -> void:
		calls.append(["sand"])
	func draw_line(_a: Vector2, _b: Vector2, _color: Color, _width: float, _aa := false) -> void: pass
	func draw_circle(_at: Vector2, _radius: float, _color: Color, _filled := true, _width := -1.0, _aa := false) -> void: pass

var checks := 0
var failed := false
func check(ok: bool, message: String) -> void:
	checks += 1
	if not ok:
		failed = true
		printerr("COMPLETENESS FAIL: " + message)

func decorations(calls: Array) -> Array:
	return calls.filter(func(call): return call[0] != "sand" and call[0] != "res://assets/original/tiles/edges_0.png")

func _initialize() -> void:
	var view := TraceView.new()
	view.sim = Sim.new()
	view.sim.new_game(-1, 0, 123)
	view.art = Graphics._json("res://assets/original/graphics.json")
	var affected := 0
	var draw_calls := 0
	for id in 24:
		for rotation in 2:
			var b := {"kind":"ride", "type":id, "x":2, "y":3, "rotation":rotation, "water_exit":[7,9], "exit_rotation":1-rotation}
			view.quality = "original"
			view.calls.clear()
			if id == 22: Layers.draw_water_gates(view, b)
			else: Layers.draw_ride_ground(view, b)
			var expected := decorations(view.calls).duplicate(true)
			if not expected.is_empty(): affected += 1
			draw_calls += expected.size()
			for mode in ["original_upscaled", "remake_medium", "remake_maximum"]:
				# Keeping overrides empty exposes the exact source regions chosen
				# by each rendering branch; replacement coverage is checked below.
				view.quality = mode
				view.calls.clear()
				if id == 22: Layers.draw_water_gates(view, b)
				else: Layers.draw_ride_ground(view, b)
				check(decorations(view.calls) == expected, "%s retains every rear flower, wall and threshold: ride %d / rotation %d" % [mode,id,rotation])
				if mode.begins_with("remake") and id != 22:
					var seen_decoration := false
					var covered := false
					for call in view.calls:
						if call[0] == "sand": covered = covered or seen_decoration
						else: seen_decoration = true
					check(not covered, "sand never covers decorations")
			view.quality = "original"
			view.calls.clear()
			Layers.draw_ride_fences_front(view, b, Color(1,1,1,0.62))
			expected = view.calls.duplicate(true)
			view.quality = "remake_maximum"
			view.calls.clear()
			Layers.draw_ride_fences_front(view, b, Color(1,1,1,0.62))
			check(view.calls == expected, "front fences retain the same regions and placement opacity")
	check(affected == 48 and draw_calls > 500, "every ride orientation has source decoration coverage")
	var original := Graphics._json("res://assets/original/commands.json")
	var remake := Graphics._json("res://assets/hd/commands_repaired.json")
	var parts := Graphics.load_part_manifest("remake_maximum")
	var phases := 0
	for id in original.rides.size():
		check(original.rides[id].size() == remake.rides[id].size(), "same animation length")
		for phase in original.rides[id].size():
			var old: Array = original.rides[id][phase]
			var new: Array = remake.rides[id][phase]
			check(old.size() == new.size(), "no missing animation commands")
			for i in old.size():
				if old[i][0] != 0: continue
				check(old[i] == new[i], "sprite coordinates and source regions remain exact")
				var cmd: Array = new[i]
				var key := "%d:%d:%d:%d:%d:%d" % cmd.slice(1,7)
				check(parts.has(key) and ResourceLoader.exists(Graphics.replacement_path(parts[key])), "every animated ride part has a complete remake resource: " + key)
			phases += 1
	var scenery_phases := 0
	var source_overlays := ["1:7:76:16:5:4", "1:8:0:19:5:6", "1:8:0:12:6:7", "1:8:6:12:6:8", "1:8:5:20:7:5"]
	for id in original.scenery.size():
		for state in original.scenery[id]:
			for frame in original.scenery[id][state]:
				for cmd in frame:
					if cmd[0] != 0: continue
					var key := "%d:%d:%d:%d:%d:%d" % cmd.slice(1,7)
					# Tiny doctor/dinosaur limb overlays keep their source pixels.
					if not parts.has(key):
						check(key in source_overlays, "Only documented overlays use original pixels: " + key)
					else:
						check(ResourceLoader.exists(Graphics.replacement_path(parts[key])), "Scenery replacement exists: " + key)
				scenery_phases += 1
	var ghost := GhostView.new()
	ghost.size = Vector2(1024, 1024)
	ghost.art = view.art
	ghost.sim = view.sim
	var spy := LayerSpy.new()
	ghost.layers = spy
	for alpha in [1.0, 0.62]:
		ghost._draw_building({"kind":"ride", "type":0, "x":0, "y":0, "working":true}, Color(1,1,1,alpha))
	check(spy.front_tints == [Color.WHITE, Color(1,1,1,0.62)], "Actual placement preview calls front fences at ghost opacity")
	ghost.free()
	print("COMPLETENESS %s: %d checks; %d ride phases; %d scenery phases; %d rear decorations across 48 orientations" % ["OK" if not failed else "FAILED",checks,phases,scenery_phases,draw_calls])
	quit(1 if failed else 0)
