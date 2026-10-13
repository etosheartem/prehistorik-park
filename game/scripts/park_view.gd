extends Control
## Original isometric axes: X = (x+y)*20, Y = (x-y)*10.
signal cell_selected(cell: Vector2i)
signal hover_changed(cell: Vector2i)
const Graphics = preload("res://scripts/park_graphics.gd")
const Layers = preload("res://scripts/park_layers.gd")
var layers = Layers.new()

var sim
var art: Dictionary = {}
var source_art: Dictionary = {}
var textures := {}
var hd := {} # Active frame manifest, retained for shared layer rendering.
var part_overrides := {}
var zoom := 2.8
var pan := Vector2.ZERO
var elapsed := 0.0
var quality := Graphics.DEFAULT
var hovered := Vector2i(-1, -1)
var selected := Vector2i(-1, -1)
var preview_kind := ""
var preview_type := 0
var preview_rotation := 0
var pressed := false
var dragging := false
var press_at := Vector2.ZERO
var pan_start := Vector2.ZERO
var show_grid := false
var input_enabled := true
var touches := {}
var touch_multitouch := false
var bursts: Array = []
var soft_shadows := true
var particles_enabled := true
var camera_speed := 1.0
var reduced_motion := false
var color_style := "natural"

func configure_options(values: Dictionary) -> void:
	soft_shadows = bool(values.get("shadows", true))
	particles_enabled = bool(values.get("particles", true))
	reduced_motion = bool(values.get("reduced_motion", false))
	camera_speed = float(values.get("camera_speed", 1.0))
	color_style = str(values.get("color_style", "natural"))
	material = Graphics.color_material(color_style) if Graphics.is_remake(quality) else null
	queue_redraw()

func constrain_camera() -> void:
	if sim == null or sim.state.is_empty(): return
	var polygon := footprint(Vector2i.ZERO, Vector2i(sim.state.size, sim.state.size))
	var bounds := Rect2(polygon[0], Vector2.ZERO)
	for point in polygon: bounds = bounds.expand(point)
	var visible_margin := minf(size.x, size.y) * 0.22
	if bounds.end.x < visible_margin: pan.x += visible_margin - bounds.end.x
	if bounds.position.x > size.x - visible_margin: pan.x -= bounds.position.x - (size.x - visible_margin)
	if bounds.end.y < visible_margin: pan.y += visible_margin - bounds.end.y
	if bounds.position.y > size.y - visible_margin: pan.y -= bounds.position.y - (size.y - visible_margin)


func _ready() -> void:
	mouse_filter = MOUSE_FILTER_STOP
	source_art = JSON.parse_string(FileAccess.get_file_as_string("res://assets/original/graphics.json"))
	configure(quality)
	resized.connect(queue_redraw)

func configure(value: String) -> void:
	quality = Graphics.normalize(value)
	art = Graphics.art_for(quality, source_art)
	# Reload dictionaries too: they may have been installed after startup during
	# development. No textures from the previous style survive in this view.
	textures.clear()
	hd = Graphics.load_manifest(quality)
	part_overrides = Graphics.load_part_manifest(quality)
	bursts.clear()
	texture_filter = Graphics.texture_filter(quality)
	queue_redraw()

func advance(dt: float) -> void:
	elapsed += dt
	bursts = bursts.filter(func(item): return elapsed - float(item.born) < 0.85)
	queue_redraw()

func burst(cell: Vector2i, demolition := false) -> void:
	if Graphics.effects_level(quality) == 0 or not particles_enabled or reduced_motion: return
	bursts.append({"cell": cell, "born": elapsed, "demolition": demolition})
	if bursts.size() > 12: bursts.pop_front()
	queue_redraw()

func iso(cell: Vector2) -> Vector2:
	return Vector2((cell.x + cell.y) * 20, (cell.x - cell.y) * 10)

func origin() -> Vector2:
	var side := 12.0 if sim == null else float(sim.state.get("size", 12))
	return size * Vector2(0.5 if size.y > size.x else 0.45, 0.46) - Vector2(side * 20, 10) * zoom + pan

func cell_to_screen(cell: Vector2) -> Vector2:
	return origin() + (iso(cell) + Vector2(20, 10)) * zoom

func screen_to_cell(point: Vector2) -> Vector2i:
	var p := (point - origin()) / zoom - Vector2(20, 10)
	return Vector2i(roundi(p.x / 40.0 + p.y / 20.0), roundi(p.x / 40.0 - p.y / 20.0))

func center_park() -> void:
	pan = Vector2.ZERO
	var side := 12.0 if sim == null else float(sim.state.get("size", 12))
	zoom = clampf(minf(size.x * 0.96 / (side * 40), size.y * 0.74 / (side * 20)), 0.75, 4.0)
	queue_redraw()

func focus_cell(cell: Vector2, scale_value := 4.0) -> void:
	zoom = clampf(scale_value, 0.75, 7.0)
	pan = Vector2.ZERO
	pan = size * Vector2(0.5, 0.43) - cell_to_screen(cell)
	queue_redraw()

func change_zoom(factor: float, at := Vector2(-1, -1)) -> void:
	if at.x < 0: at = size * 0.5
	var previous := origin()
	var old_zoom := zoom
	zoom = clampf(zoom * factor, 0.75, 7.0)
	pan += at - (origin() + (at - previous) * zoom / old_zoom)
	queue_redraw()

func cancel_input() -> void:
	touches.clear()
	touch_multitouch = false
	pressed = false
	dragging = false

func _gui_input(event: InputEvent) -> void:
	if not input_enabled: return
	# GUI buttons keep Godot touch-to-mouse emulation; the map handles native fingers.
	if event is InputEventMouse and event.device == -1: return
	if event is InputEventScreenTouch:
		if event.pressed:
			touches[event.index] = event.position
			if touches.size() == 1:
				press_at = event.position
				pan_start = pan
				dragging = false
				touch_multitouch = false
			else:
				touch_multitouch = true
				dragging = true
		else:
			if touches.has(event.index) and touches.size() == 1 and not touch_multitouch and not dragging and not event.canceled:
				cell_selected.emit(screen_to_cell(event.position))
			touches.erase(event.index)
			if touches.is_empty(): cancel_input()
	elif event is InputEventScreenDrag:
		if not touches.has(event.index): return
		if touches.size() >= 2:
			var ids: Array = touches.keys()
			var old_center: Vector2 = (touches[ids[0]] + touches[ids[1]]) * 0.5
			var old_distance: float = touches[ids[0]].distance_to(touches[ids[1]])
			touches[event.index] = event.position
			var new_center: Vector2 = (touches[ids[0]] + touches[ids[1]]) * 0.5
			var new_distance: float = touches[ids[0]].distance_to(touches[ids[1]])
			if old_distance > 8 and new_distance > 8: change_zoom(new_distance / old_distance, old_center)
			pan += new_center - old_center
		else:
			touches[event.index] = event.position
			if not touch_multitouch:
				if event.position.distance_to(press_at) > 14: dragging = true
				if dragging: pan = pan_start + (event.position - press_at) * camera_speed
		hovered = screen_to_cell(event.position)
		hover_changed.emit(hovered)
	elif event is InputEventMouseButton:
		if event.button_index == MOUSE_BUTTON_WHEEL_UP and event.pressed: change_zoom(1.12, event.position)
		elif event.button_index == MOUSE_BUTTON_WHEEL_DOWN and event.pressed: change_zoom(1.0 / 1.12, event.position)
		elif event.button_index in [MOUSE_BUTTON_LEFT, MOUSE_BUTTON_MIDDLE, MOUSE_BUTTON_RIGHT]:
			if event.pressed:
				pressed = true
				dragging = event.button_index != MOUSE_BUTTON_LEFT
				press_at = event.position
				pan_start = pan
			else:
				if pressed and not dragging:
					cell_selected.emit(screen_to_cell(event.position))
				pressed = false
				dragging = false
	elif event is InputEventMouseMotion:
		if pressed:
			if event.position.distance_to(press_at) > 14: dragging = true
			if dragging: pan = pan_start + (event.position - press_at) * camera_speed
		var cell := screen_to_cell(event.position)
		if cell != hovered:
			hovered = cell
			hover_changed.emit(cell)
	elif event is InputEventMagnifyGesture:
		change_zoom(event.factor, event.position)
	constrain_camera()
	queue_redraw()

func _texture(path: String) -> Texture2D:
	if not textures.has(path):
		var texture: Texture2D = load(path) if ResourceLoader.exists(path) else null
		if texture and quality == "remake_medium" and path.begins_with("res://assets/hd/") and path.ends_with(".png") and maxf(texture.get_width(), texture.get_height()) > 48 and DisplayServer.get_name() != "headless":
			var compact := texture.get_image()
			if compact:
				compact.resize(maxi(1, compact.get_width() / 2), maxi(1, compact.get_height() / 2), Image.INTERPOLATE_LANCZOS)
				compact.generate_mipmaps()
				texture = ImageTexture.create_from_image(compact)
		textures[path] = texture
	return textures[path]

func texture_for(path: String) -> Texture2D:
	if hd.has(path):
		var replacement = hd[path]
		var candidate := _texture(Graphics.replacement_path(replacement))
		if candidate: return candidate
	return _texture(path)

func _frame(frame: Dictionary, at: Vector2, tint := Color.WHITE, mirror := false) -> void:
	var path: String = frame.get("path", "")
	if path.is_empty(): return
	var original := _texture(path)
	if original == null: return
	var texture := original
	var logical_size := original.get_size()
	var offset := Vector2(frame.get("offset", [0, 0])[0], frame.get("offset", [0, 0])[1])
	if hd.has(path):
		var replacement = hd[path]
		var hd_path: String = Graphics.replacement_path(replacement)
		var candidate := _texture(hd_path)
		if candidate:
			texture = candidate
			if replacement is Dictionary and replacement.has("logical_size"):
				logical_size = Vector2(replacement.logical_size[0],replacement.logical_size[1])
	var rect := Rect2(at + offset * zoom, logical_size * zoom)
	if mirror:
		rect.position.x = at.x - (offset.x + logical_size.x) * zoom + 40 * zoom
		rect.size.x *= -1
	draw_texture_rect(texture, rect, false, tint)

func footprint(cell: Vector2i, extent := Vector2i.ONE) -> PackedVector2Array:
	var points := PackedVector2Array()
	for offset in [Vector2(-0.5, -0.5), Vector2(extent.x - 0.5, -0.5), Vector2(extent.x - 0.5, extent.y - 0.5), Vector2(-0.5, extent.y - 0.5)]:
		points.append(cell_to_screen(Vector2(cell) + offset))
	return points

func _outline(cell: Vector2i, extent: Vector2i, color: Color) -> void:
	var polygon := footprint(cell, extent)
	draw_colored_polygon(polygon, Color(color, 0.18))
	polygon.append(polygon[0])
	draw_polyline(polygon, color, maxf(1.5, zoom * 0.7), true)

func _draw() -> void:
	draw_rect(Rect2(Vector2.ZERO, size), Color("3b5341"))
	if sim == null or sim.state.is_empty() or art.is_empty(): return
	var side: int = sim.state.size
	var origin_at := origin()
	# Dark earth sides make the park read as a raised diorama.
	var border := footprint(Vector2i.ZERO, Vector2i(side, side))
	var below := PackedVector2Array()
	for v in border: below.append(v + Vector2(0, 16 * zoom))
	draw_colored_polygon(below, Color("283728"))
	draw_colored_polygon(border, Color("78ad43") if Graphics.is_remake(quality) else Color("50ae18"))
	# Coplanar tiles do not overlap: group them by material to avoid one GPU
	# texture switch per square on a full-park overview.
	var batches := {}
	var visible_cells: Array[Vector2i] = []
	var visible_area := Rect2(-100, -100, size.x + 200, size.y + 200)
	for x in side:
		for y in side:
			var cell := Vector2i(x, y)
			var at := origin_at + iso(Vector2(cell)) * zoom
			if not visible_area.has_point(at): continue
			var key := "%d,%d" % [x,y]
			var terrain: int = int(sim.state.terrain.get(key, 1))
			var name := "grass_%d" % maxi(0, terrain - 1)
			if sim.state.paths.has(key):
				var type: int = int(sim.state.paths[key])
				name = "water_%d" % (int(elapsed * 3) % 3) if type == 13 else "path_stone" if type in [4,6] else "path_dirt"
			if Graphics.is_remake(quality) and name.begins_with("grass"):
				# A continuous meadow has no tile alpha edges, seams or sawteeth.
				var mark := cell_to_screen(Vector2(cell)) + Vector2((x * 7 + y * 3) % 17 - 8, (x * 3 + y * 7) % 7 - 3) * zoom
				if (x * 11 + y * 7) % 4 == 0:
					draw_line(mark, mark + Vector2(0.7, -1.2) * zoom, Color(0.27, 0.45, 0.18, 0.18), maxf(0.6, zoom * 0.18), true)
			else:
				if not batches.has(name): batches[name] = []
				batches[name].append(at)
			if show_grid: visible_cells.append(cell)
	for name in batches:
		if art.tiles.has(name):
			for at in batches[name]: _frame(art.tiles[name], at)
	for cell in visible_cells: _outline(cell, Vector2i.ONE, Color(0.85, 0.95, 0.7, 0.2))
	var renderables: Array = []
	for key in sim.state.terrain:
		var natural: int = int(sim.state.terrain[key])
		if natural >= 0: continue
		var coords: PackedStringArray = str(key).split(",")
		var x := int(coords[0])
		var y := int(coords[1])
		renderables.append({"depth": float(x - y), "kind": "building", "data": {"kind": "prop", "type": -natural - 1, "x": x, "y": y, "working": true}})
	for key in sim.state.paths:
		if int(sim.state.paths[key]) not in [2, 6]: continue
		var coords: PackedStringArray = str(key).split(",")
		var cell := Vector2i(int(coords[0]), int(coords[1]))
		renderables.append({"depth": float(cell.x - cell.y), "kind": "bench", "data": {"cell": cell}})
	for b in sim.state.buildings:
		renderables.append({"depth": float(b.x - b.y) + float(b.get("w", 1) - 1) * 0.5, "kind": "building", "data": b})
	for v in sim.state.visitors:
		var target: Dictionary = sim.building_by_id(int(v.get("target_uid", -1)))
		if v.get("state", "") == "riding" and int(target.get("type", -1)) != 22: continue
		if v.get("state", "") == "eating" and target.get("kind", "") == "ride" and int(target.get("type", -1)) == 23: continue
		renderables.append({"depth": float(v.x) - float(v.y), "kind": "visitor", "data": v})
	for w in sim.state.get("workers", []):
		renderables.append({"depth": float(w.x) - float(w.y), "kind": "worker", "data": w})
	renderables.sort_custom(func(a, b): return a.depth < b.depth)
	for entry in renderables:
		if entry.kind == "building": _draw_building(entry.data)
		elif entry.kind == "bench": layers.draw_bench(self, entry.data.cell)
		else: _draw_person(entry.data, entry.kind == "worker")
	layers.draw_park_entrance(self)
	if selected.x >= 0: _outline(selected, Vector2i.ONE, Color("ffe1a1"))
	if hovered.x >= 0 and hovered.y >= 0 and hovered.x < side and hovered.y < side and not preview_kind.is_empty():
		var extent := Vector2i.ONE
		if preview_kind in ["ride", "prop"]:
			var catalog: Array = sim.ride_catalog if preview_kind == "ride" else sim.scenery_catalog
			var raw = catalog[preview_type].get("size", [1, 1])
			extent = Vector2i(raw[0], raw[1])
			if preview_kind == "ride" and preview_type == 22: extent = Vector2i(1, 2) if preview_rotation == 0 else Vector2i(2, 1)
		if preview_kind == "prop" and preview_type == 26:
			_outline(hovered - Vector2i(4, 4), Vector2i(10, 10), Color(0.59, 0.85, 0.94, 0.45))
		var valid: bool = sim.can_build(preview_kind, preview_type, hovered, preview_rotation).is_empty()
		_outline(hovered, extent, Color("d6ef7f") if valid else Color("f49373"))
		if preview_kind in ["ride", "prop"]:
			_draw_building({"kind": preview_kind, "type": preview_type, "x": hovered.x, "y": hovered.y,
				"rotation": preview_rotation, "phase": 0, "working": true, "open": true}, Color(1, 1, 1, 0.62))
	if Graphics.effects_level(quality) > 0 and particles_enabled and not reduced_motion:
		for event in bursts:
			var age := elapsed - float(event.born)
			var base := cell_to_screen(event.cell)
			for i in 9:
				var angle := i * 2.4
				var offset := Vector2(cos(angle) * (5 + i) * age, -age * 26 + age * age * 24 + sin(angle) * 4 * age) * zoom
				var color := Color("c0a16a") if event.demolition else Color("e9cb81")
				color.a = (1.0 - age / 0.85) * 0.75
				draw_circle(base + offset, (0.5 + i % 3 * 0.25) * zoom, color, true, -1, true)

func _draw_path(cell: Vector2i, type: int) -> void:
	var names := {0: "path_dirt", 2: "path_dirt", 4: "path_stone", 6: "path_stone", 13: "water_%d" % (int(elapsed * 3) % 3)}
	var name: String = names.get(type, "path_dirt")
	var at := origin() + iso(Vector2(cell)) * zoom
	if art.tiles.has(name):
		_frame(art.tiles[name], at)
	else:
		var color := Color("bfa56c") if type == 0 else Color("aaaa8b") if type == 4 else Color("599faf")
		draw_colored_polygon(footprint(cell), color)
		if type == 4: draw_line(cell_to_screen(Vector2(cell)) + Vector2(-12, 0) * zoom, cell_to_screen(Vector2(cell)) + Vector2(12, 0) * zoom, color.darkened(0.12), zoom)

func _draw_building(b: Dictionary, tint := Color.WHITE) -> void:
	if b.kind == "ride" and int(b.type) == 22:
		layers.draw_water_gates(self, b, tint)
		return
	var frames: Array
	var set: Dictionary = art.rides[int(b.type)] if b.kind == "ride" else art.scenery[int(b.type)]
	frames = set.frames
	if b.kind == "prop" and set.has("variants"):
		frames = set.variants.get("closed" if not b.get("open", true) else "working" if b.get("working", true) else "unstaffed", frames)
	if frames.is_empty(): return
	var frame_index := 0
	if b.get("working", true): frame_index = posmod(layers.visual_phase(self, b), frames.size())
	var at := origin() + iso(Vector2(b.x, b.y)) * zoom
	var frame: Dictionary = frames[frame_index]
	var frame_size := Vector2(frame.get("size", [0, 0])[0], frame.get("size", [0, 0])[1])
	if frame_size == Vector2.ZERO:
		var original: Texture2D = _texture(str(frame.path))
		if original: frame_size = original.get_size()
	if frame_size != Vector2.ZERO:
		var offset: Array = frame.get("offset", [0,0])
		var bounds := Rect2(at + Vector2(offset[0],offset[1]) * zoom, frame_size * zoom)
		for point in footprint(Vector2i(b.x,b.y), Vector2i(b.get("w",1),b.get("h",1))): bounds = bounds.expand(point)
		if not bounds.grow(45*zoom).intersects(Rect2(Vector2.ZERO,size)): return
	if Graphics.effects_level(quality) > 0 and soft_shadows and b.kind == "prop":
		var base := cell_to_screen(Vector2(b.x, b.y))
		draw_set_transform(base, 0, Vector2(zoom * 1.5, zoom * 0.6))
		for ring in range(4, 0, -1):
			draw_circle(Vector2.ZERO, 2.0 + ring * 1.6, Color(0.12, 0.2, 0.06, 0.025 * tint.a))
		draw_set_transform(Vector2.ZERO)
	if b.kind == "ride": layers.draw_ride_ground(self, b, tint)
	var drawn: bool = layers.draw_ride_body(self, b, tint) if b.kind == "ride" else layers.draw_prop_body(self, b, tint)
	if not drawn: _frame(frames[frame_index], at, tint)
	if b.kind == "ride" and tint.a > 0.9: layers.draw_ride_passengers(self, b)
	if b.kind == "ride": layers.draw_ride_fences_front(self, b, tint)
	if tint.a > 0.9 and b.kind == "ride" and not b.get("working", true):
		var badge := at + Vector2(20, -18) * zoom
		draw_circle(badge, 4.2 * zoom, Color("b95739"))
		draw_line(badge + Vector2(0, -2) * zoom, badge + Vector2(0, 0.5) * zoom, Color("fff0c7"), maxf(1.5, zoom))

func _draw_person(person: Dictionary, worker: bool) -> void:
	var position := cell_to_screen(Vector2(float(person.x),float(person.y)))
	if not Rect2(Vector2.ZERO,size).grow(36*zoom).has_point(position): return
	if not worker and person.get("state", "") == "riding":
		layers.draw_water_person(self, person)
		return
	if not worker and person.get("state", "") == "resting":
		layers.draw_resting_person(self, person)
		return
	var id := (8 if int(person.get("type", 0)) == 0 else 9) if worker else posmod(int(person.get("type", 0)), 8)
	if worker and int(person.get("type", 0)) not in [0, 1]: return
	var animations: Dictionary = art.actors[id].animations
	var direction := clampi(int(person.get("dir", 0)), 0, 3)
	var animation: Dictionary = animations["walk_%d" % direction]
	var seq: Array = animation.sequence
	var phase := int(person.get("anim", elapsed * 6))
	var frame: Dictionary = animation.frames[int(seq[posmod(phase, seq.size())])]
	var at := cell_to_screen(Vector2(float(person.x), float(person.y)))
	if Graphics.effects_level(quality) > 0 and soft_shadows:
		draw_set_transform(at, 0, Vector2(zoom * 1.4, zoom * 0.55))
		draw_circle(Vector2.ZERO, 2.4, Color(0.07, 0.12, 0.06, 0.17))
		draw_set_transform(Vector2.ZERO)
	_frame(frame, at)

func focus_activity() -> void:
	if sim == null or sim.state.is_empty(): return
	var cells := Rect2(Vector2(sim.state.entrance[0], sim.state.entrance[1]), Vector2.ONE)
	for b in sim.state.buildings:
		cells = cells.expand(Vector2(b.x, b.y)).expand(Vector2(b.x + b.w, b.y + b.h))
	var span := (cells.size.x + cells.size.y + 2.0) * 20.0
	var scale_value := clampf(size.x * 0.92 / maxf(span, 120), 1.5, 5.0)
	focus_cell(cells.get_center(), scale_value)
