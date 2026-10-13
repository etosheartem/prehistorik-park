extends SceneTree

const Layers = preload("res://scripts/park_layers.gd")
const Simulation = preload("res://scripts/park_sim.gd")

class DrawView:
	extends Node2D
	var sim
	var art: Dictionary
	var hd: Dictionary
	var quality := "maximum"
	var zoom := 3.0
	var elapsed := 0.5
	var base := Vector2.ZERO
	var cache: Dictionary = {}
	var part_overrides: Dictionary = {}
	var ride_ids: Array = [0, 3, 17, 19]
	func origin() -> Vector2: return base
	func iso(cell: Vector2) -> Vector2: return Vector2((cell.x + cell.y) * 20, (cell.x - cell.y) * 10)
	func cell_to_screen(cell: Vector2) -> Vector2: return origin() + (iso(cell) + Vector2(20, 10)) * zoom
	func _texture(path: String) -> Texture2D:
		if not cache.has(path):
			# Filesystem loading is test-only so fresh PNGs need no editor import.
			var image := Image.load_from_file(ProjectSettings.globalize_path(path))
			cache[path] = ImageTexture.create_from_image(image) if image else null
		return cache[path]
	func texture_for(path: String) -> Texture2D: return _texture(path)
	func _frame(frame: Dictionary, at: Vector2, tint := Color.WHITE) -> void:
		var texture := _texture(frame.path)
		if not texture: return
		var size := texture.get_size()
		if quality != "economy" and hd.has(str(frame.path)):
			texture = _texture(hd[str(frame.path)].path)
		draw_texture_rect(texture, Rect2(at + Vector2(frame.offset[0], frame.offset[1]) * zoom, size * zoom), false, tint)
	func _draw() -> void:
		draw_rect(Rect2(0, 0, 1600, 1000), Color("304a31"))
		for slot in 4:
			var id: int = ride_ids[slot]
			var frame: Dictionary = art.rides[id].frames[0]
			var footprint: Array = art.rides[id].footprint
			var low := Vector2(minf(0, frame.offset[0]), minf(-float(footprint[1]) * 10, frame.offset[1]))
			var high := Vector2(maxf(float(footprint[0] + footprint[1]) * 20, float(frame.offset[0]) + frame.size[0]), maxf(float(footprint[0]) * 10 + 20, float(frame.offset[1]) + frame.size[1]))
			zoom = minf(350.0 / (high.x - low.x), 450.0 / (high.y - low.y))
			base = Vector2(25 + slot * 400, 55) - low * zoom
			var b := {"kind": "ride", "type": id, "x": 0, "y": 0, "phase": 3, "phase_t": 0.6, "rotation": 0, "occupants": [1, 2, 3, 4], "working": true}
			Layers.draw_ride_ground(self, b)
			Layers.draw_ride_body(self, b)
			Layers.draw_ride_passengers(self, b)
			Layers.draw_ride_fences_front(self, b)
		zoom = 3.0
		base = Vector2(40, 700)
		Layers.draw_water_gates(self, {"type": 22, "x": 0, "y": 0, "rotation": 0, "water_exit": [3, 0], "exit_rotation": 1})
		Layers.draw_bench(self, Vector2i(2, 2))
		base = Vector2(580, 730)
		var cafe := {"kind": "ride", "type": 23, "x": 0, "y": 0, "rotation": 0, "working": true, "occupants": [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4]}
		Layers.draw_ride_ground(self, cafe)
		Layers.draw_ride_body(self, cafe)
		Layers.draw_ride_passengers(self, cafe)
		Layers.draw_ride_fences_front(self, cafe)
		for id in 6:
			base = Vector2(1030 + (id % 3) * 180, 720 + int(id / 3) * 200)
			Layers.draw_prop_body(self, {"kind": "prop", "type": [0, 1, 2, 8, 10, 13][id], "x": 0, "y": 0, "working": true})
		# Six asymmetric pixels prove negative width mirrors within the same bounds.
		zoom = 1.0
		Layers._region(self, 99, 0, Rect2(0, 0, 3, 2), Vector2(20, 20))
		Layers._region(self, 99, 1, Rect2(0, 0, 3, 2), Vector2(40, 20))
		zoom = 3.0

func _initialize() -> void:
	start.call_deferred()

func start() -> void:
	var viewport := SubViewport.new()
	viewport.size = Vector2i(1600, 1000)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	var view := DrawView.new()
	var micro := "--micro" in OS.get_cmdline_user_args()
	if micro: view.ride_ids = [1, 8, 11, 23]
	view.texture_filter = CanvasItem.TEXTURE_FILTER_NEAREST
	view.sim = Simulation.new()
	view.sim.new_game(-1, 0, 123)
	view.art = JSON.parse_string(FileAccess.get_file_as_string("res://assets/original/graphics.json"))
	view.hd = JSON.parse_string(FileAccess.get_file_as_string("res://assets/hd/manifest.json"))
	view.hd.merge(JSON.parse_string(FileAccess.get_file_as_string("res://assets/hd/terrain/manifest.json")), true)
	for i in 4:
		view.sim.state.visitors.append({"uid": i + 1, "type": i, "state": "riding"})
	var mirror_source := Image.create(3, 2, false, Image.FORMAT_RGBA8)
	var colors := [Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA]
	for i in 6: mirror_source.set_pixel(i % 3, int(i / 3), colors[i])
	view.cache["mirror_fixture"] = ImageTexture.create_from_image(mirror_source)
	# Initialize the actual manifest first, then add two temporary test entries.
	view.part_overrides = JSON.parse_string(FileAccess.get_file_as_string("res://assets/hd/part_manifest.json"))
	view.part_overrides["99:0:0:0:3:2"] = {"path": "mirror_fixture"}
	view.part_overrides["99:1:0:0:3:2"] = {"path": "mirror_fixture", "flip_x": true}
	viewport.add_child(view)
	await process_frame
	await RenderingServer.frame_post_draw
	var screenshot := viewport.get_texture().get_image()
	for y in 2:
		for x in 3:
			if screenshot.get_pixel(20 + x, 20 + y) != screenshot.get_pixel(42 - x, 20 + y):
				push_error("HD mirror changes bounds or does not reverse pixels")
				quit(1)
				return
	var output := ProjectSettings.globalize_path("res://../art/review/parts/micro_runtime_render.png" if micro else "res://../art/review/parts/runtime_render.png")
	screenshot.save_png(output)
	print("PART RENDER OK: live commands, riders, water gate rotations, bench and exact mirror bounds")
	quit(0)
