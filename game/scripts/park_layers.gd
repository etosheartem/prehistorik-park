extends RefCounted
## Extra original world layers. Geometry follows e.aC/aH/aQ/cM and arr.dat.
## Call ground before the assembled ride, passengers after it. Water gates
## replace the generic ride22 sprite; benches belong in the depth-sorted pass.

const Graphics = preload("res://scripts/park_graphics.gd")
static var _commands: Dictionary = {}
static var _commands_loaded := false
static var _remake_commands: Dictionary = {}


static func _load_commands() -> void:
	if _commands_loaded:
		return
	_commands_loaded = true
	if FileAccess.file_exists("res://assets/original/commands.json"):
		var parsed = JSON.parse_string(FileAccess.get_file_as_string("res://assets/original/commands.json"))
		if parsed is Dictionary:
			_commands = parsed
	_remake_commands = Graphics._json("res://assets/hd/commands_repaired.json")


static func _draw_commands(view, commands: Array, at: Vector2, tint: Color) -> void:
	for command in commands:
		if int(command[0]) == 0:
			_region(view, int(command[1]), int(command[2]), Rect2(command[3], command[4], command[5], command[6]), at + Vector2(command[7], command[8]) * view.zoom, tint)
		else:
			var rgb := int(command[5])
			var color := Color(float((rgb >> 16) & 255) / 255.0, float((rgb >> 8) & 255) / 255.0, float(rgb & 255) / 255.0) * tint
			var start: Vector2 = at + Vector2(command[1], command[2]) * view.zoom
			var end: Vector2 = at + Vector2(command[3], command[4]) * view.zoom
			if Graphics.is_remake(view.quality):
				view.draw_line(start, end, Color("493723") * tint, maxf(1.5, view.zoom * 1.05), true)
				view.draw_line(start, end, Color("c49a5a") * tint, maxf(0.8, view.zoom * 0.45), true)
				view.draw_circle(start, view.zoom * 0.7, Color("584028") * tint, true, -1, true)
				view.draw_circle(end, view.zoom * 0.7, Color("584028") * tint, true, -1, true)
			else:
				view.draw_line(start, end, color, maxf(1.0, view.zoom), true)


static func draw_ride_body(view, building: Dictionary, tint := Color.WHITE) -> bool:
	if view.quality == "original" or int(building.type) == 22:
		return false
	_load_commands()
	if not _commands.has("rides"):
		return false
	var source: Dictionary = _remake_commands if Graphics.is_remake(view.quality) and not _remake_commands.is_empty() else _commands
	var frames: Array = source.rides[int(building.type)]
	if frames.is_empty():
		return false
	_draw_commands(view, frames[posmod(visual_phase(view, building), frames.size())], _tile_origin(view, Vector2(building.x, building.y)), tint)
	return true


static func draw_prop_body(view, building: Dictionary, tint := Color.WHITE) -> bool:
	if view.quality == "original":
		return false
	_load_commands()
	if not _commands.has("scenery"):
		return false
	var variants: Dictionary = _commands.scenery[int(building.type)]
	if variants.is_empty():
		return false # Locally repaired ticket booths use their vector assets.
	var state := "closed" if not building.get("open", true) else "working" if building.get("working", true) else "unstaffed"
	var frames: Array = variants[state]
	_draw_commands(view, frames[posmod(visual_phase(view, building), frames.size())], _tile_origin(view, Vector2(building.x, building.y)), tint)
	return true


static func visual_phase(view, building: Dictionary) -> int:
	if building.get("kind", "") != "ride":
		return int(view.elapsed * 6.0) if building.get("working", true) else 0
	if int(building.type) == 23:
		return int(view.elapsed * 10.0) if building.get("working", true) else 0
	if int(building.get("phase", 0)) != 3:
		return 0
	var header: Dictionary = view.sim.ride_catalog[int(building.type)].header
	return posmod(int(floor(float(building.get("phase_t", 0.0)) / 0.1 + 0.0001)), maxi(1, int(header["as"])))


static func _tile_origin(view, cell: Vector2) -> Vector2:
	return view.origin() + view.iso(cell) * view.zoom


static func _region(view, pack: int, index: int, source: Rect2, at: Vector2, tint := Color.WHITE) -> void:
	if source.size.x <= 0 or source.size.y <= 0:
		return
	var key := "%d:%d:%d:%d:%d:%d" % [pack, index, int(source.position.x), int(source.position.y), int(source.size.x), int(source.size.y)]
	var target := Rect2(at, source.size * view.zoom)
	if view.part_overrides.has(key):
		var part = view.part_overrides[key]
		var replacement: Texture2D = view._texture(Graphics.replacement_path(part))
		if replacement:
			if part is Dictionary and part.get("flip_x", false):
				target.size.x = -target.size.x
			view.draw_texture_rect(replacement, target, false, tint)
			return
	if pack == 1 and index == 7:
		pack = 0
		index = 10
	var path := "res://assets/original/packs/gpack%d_%d.png" % [pack, index]
	var original: Texture2D = view._texture(path)
	if original:
		var texture: Texture2D = view.texture_for(path)
		# GPU upscales whole original atlases once; all poses and animation phases
		# sample the same scaled source rectangles, keeping their pixel anchors.
		var scale := texture.get_size() / original.get_size()
		view.draw_texture_rect_region(texture, target, Rect2(source.position * scale, source.size * scale), tint)


static func _edge(view, index: int, at: Vector2, tint := Color.WHITE) -> void:
	if index >= 0 and index < view.art.tiles.edges.size():
		var frame: Dictionary = view.art.tiles.edges[index]
		if index == 0:
			view._frame(frame, at, tint)
			return
		_region(view, 1, 2, Rect2(frame.rect[0], frame.rect[1], frame.rect[2], frame.rect[3]), at + Vector2(frame.offset[0], frame.offset[1]) * view.zoom, tint)


static func _ride_cells(view, b: Dictionary) -> Array:
	var ride: Dictionary = view.sim.ride_catalog[int(b.type)]
	var width := int(ride.sections[0][0])
	var height := int(ride.sections[0][1])
	var start := posmod(int(b.get("rotation", 0)), 2) * width * height
	var result: Array = []
	for x in width:
		for y in height:
			var index := start + x * height + y
			var mask := int(ride.sections[38][index]) & 255 if index < ride.sections[38].size() else 0
			result.append({"cell": Vector2(float(b.x) + x, float(b.y) + y), "type": int(ride.sections[37][index]), "mask": mask, "depth": x - y})
	result.sort_custom(func(a, c): return a.depth < c.depth)
	return result


static func draw_ride_ground(view, b: Dictionary, tint := Color.WHITE) -> void:
	if b.get("kind", "") != "ride" or int(b.type) == 22:
		return
	var cells := _ride_cells(view, b)
	if Graphics.is_remake(view.quality):
		# Lay every sand tile first: a later tile must not cover a previously
		# drawn flower bed, gate threshold or rear wall.
		for item in cells:
			if item.type < 4 or item.type > 12: continue
			var polygon: PackedVector2Array = view.footprint(Vector2i(item.cell))
			var center: Vector2 = view.cell_to_screen(item.cell)
			for i in polygon.size(): polygon[i] = center + (polygon[i] - center) * 1.002
			view.draw_colored_polygon(polygon, Color("e2c68d") * tint)
	for item in cells:
		if item.type < 4 or item.type > 12:
			continue
		var at := _tile_origin(view, item.cell)
		if not Graphics.is_remake(view.quality): _edge(view, 0, at, tint)
		var special: Dictionary = {5: 13, 6: 12, 7: 11, 8: 14}
		if special.has(item.type):
			_edge(view, int(special[item.type]), at, tint)
		for pair in [[64, 2], [4, 8], [128, 1], [8, 7]]:
			if int(item.mask) & int(pair[0]):
				_edge(view, int(pair[1]), at, tint)
		if (int(item.mask) & 74) == 74:
			_edge(view, 15, at, tint)
		if (int(item.mask) & 133) == 133:
			_edge(view, 16, at, tint)


static func draw_ride_fences_front(view, b: Dictionary, tint := Color.WHITE) -> void:
	if b.get("kind", "") != "ride" or int(b.type) == 22:
		return
	for item in _ride_cells(view, b):
		if item.type < 4 or item.type > 12:
			continue
		var at := _tile_origin(view, item.cell)
		for pair in [[16, 18], [1, 10], [32, 17], [2, 9]]:
			if int(item.mask) & int(pair[0]):
				_edge(view, int(pair[1]), at, tint)
		if item.type == 5:
			_edge(view, 3, at, tint)
		elif item.type == 6:
			_edge(view, 4, at, tint)


static func _actor_frame(view, actor: int, pose: int, frame: int) -> Dictionary:
	var animations: Dictionary = view.art.actors[clampi(actor, 0, 7)].animations
	var name: String = "walk_%d" % pose if pose < 4 else {4: "sit", 5: "ride", 6: "pose", 7: "special"}.get(pose, "walk_0")
	var frames: Array = animations[name].frames
	return frames[clampi(frame, 0, frames.size() - 1)]


static func passenger_poses(view, b: Dictionary) -> Array:
	var result: Array = []
	if b.get("kind", "") != "ride" or int(b.type) in [22, 23]:
		return result
	var ride: Dictionary = view.sim.ride_catalog[int(b.type)]
	var s: Array = ride.sections
	if int(s[4][0]) == 0:
		return result # Guests inside the haunted house are intentionally hidden.
	var cap := int(ride.header.au)
	var period := maxi(1, int(ride.header.at))
	var counter := visual_phase(view, b)
	var phase := posmod(counter, period)
	var rotation := posmod(int(b.get("rotation", 0)), 2)
	var entry: Array = view.art.rides[int(b.type)].entry_tiles[rotation]
	var local_cell := Vector2(entry[0], entry[1])
	if int(s[3][2]) == 0:
		# Section35 records cell changes; section36 records the separate sprite
		# layer's absolute cell. Accumulating deltas reproduces coaster passengers.
		for previous in range(phase + 1):
			if previous * 2 + 1 < s[35].size():
				local_cell += Vector2(s[35][previous * 2], s[35][previous * 2 + 1])
	var base: Vector2 = view.iso(Vector2(float(b.x), float(b.y)) + local_cell)
	var occupants: Array = b.get("occupants", [])
	for seat in mini(cap, occupants.size()):
		var visitor: Dictionary = view.sim._visitor(int(occupants[seat]))
		if visitor.is_empty():
			continue
		var rotating_seat := posmod(int(counter / period) + seat, cap)
		var x_index := phase * cap + rotating_seat if int(s[2][2]) else seat
		var y_index := phase * cap + rotating_seat if int(s[2][3]) else seat
		var pose_index := phase * cap + rotating_seat if int(s[2][4]) else seat
		var frame_index := phase * cap + seat if int(s[2][5]) else -1
		if x_index >= s[21].size() or y_index >= s[22].size() or pose_index >= s[23].size():
			continue
		var pose := int(s[23][pose_index])
		var frame := int(s[24][frame_index]) if frame_index >= 0 and frame_index < s[24].size() else 0
		var actor := clampi(int(visitor.type), 0, 7)
		var sprite := _actor_frame(view, actor, pose, frame)
		var at := base + Vector2(s[21][x_index], s[22][y_index])
		if int(b.type) == 14:
			at.y += int(view.sim.data.tables[20][actor * 4])
		var hidden := int(ride.header.ax) if phase >= int(s[39][0]) and phase <= int(s[39][1]) else 0
		result.append({"uid": int(visitor.uid), "actor": actor, "pose": pose, "frame": sprite,
			"at": at, "hidden": hidden, "phase": phase, "depth": at.y})
	result.sort_custom(func(a, c): return a.depth < c.depth)
	return result


static func _draw_cropped_frame(view, frame: Dictionary, at: Vector2, hidden: int) -> void:
	var texture: Texture2D = view._texture(str(frame.path))
	if not texture:
		return
	var native_size := texture.get_size()
	var logical := native_size
	logical.y = maxf(0.0, logical.y - hidden)
	if logical.y <= 0:
		return
	var offset := Vector2(frame.offset[0], frame.offset[1])
	texture = view.texture_for(str(frame.path))
	var source_size := texture.get_size() * logical / native_size
	view.draw_texture_rect_region(texture, Rect2(at + offset * view.zoom, logical * view.zoom), Rect2(Vector2.ZERO, source_size))


static func draw_ride_passengers(view, b: Dictionary) -> void:
	if int(b.type) == 23:
		_draw_cafe_guests(view, b)
	var tables: Array = view.sim.data.tables
	for rider in passenger_poses(view, b):
		var at: Vector2 = view.origin() + rider.at * view.zoom
		_draw_cropped_frame(view, rider.frame, at, rider.hidden)
		if int(b.type) == 0:
			var cabin: Array = tables[75]
			_region(view, 1, int(cabin[0]), Rect2(cabin[1], cabin[2], cabin[3], cabin[4]), at + Vector2(cabin[5], cabin[6]) * view.zoom)
		elif int(b.type) == 14 or (int(b.type) == 16 and int(rider.phase) >= int(tables[76][0]) and int(rider.phase) <= int(tables[76][1])):
			var index := int(rider.actor) * 24 + int(rider.pose) * 6
			if index + 5 < tables[0].size():
				var overlay: Array = tables[0].slice(index, index + 6)
				var sprite_offset := Vector2(rider.frame.offset[0], rider.frame.offset[1])
				_region(view, 0, rider.actor, Rect2(overlay[0], overlay[1], overlay[2], overlay[3]), at + (sprite_offset + Vector2(overlay[4], overlay[5])) * view.zoom)


static func draw_bench(view, cell: Vector2i) -> void:
	_edge(view, 19, _tile_origin(view, Vector2(cell)))


static func draw_resting_person(view, person: Dictionary) -> void:
	var frame := _actor_frame(view, clampi(int(person.type), 0, 7), 4, 0)
	var at: Vector2 = view.cell_to_screen(Vector2(person.x, person.y)) + Vector2(-8, -2) * view.zoom
	view._frame(frame, at)


static func draw_water_person(view, person: Dictionary) -> void:
	var at: Vector2 = view.cell_to_screen(Vector2(person.x, person.y))
	_region(view, 1, 1, Rect2(40, 0, 12, 9), at + Vector2(-6, -11) * view.zoom)
	var frame := _actor_frame(view, clampi(int(person.type), 0, 7), clampi(int(person.dir), 0, 3), 0)
	_draw_cropped_frame(view, frame, at, 7)


static func draw_water_gates(view, b: Dictionary, tint := Color.WHITE) -> void:
	var gate_cells: Array = []
	var sections: Array = view.sim.ride_catalog[22].sections
	var end: Array = b.get("water_exit", [])
	for side in 2:
		if side == 1 and end.size() != 2:
			continue
		var base := Vector2(float(b.x), float(b.y)) if side == 0 else Vector2(end[0], end[1])
		var rotation := posmod(int(b.get("rotation" if side == 0 else "exit_rotation", 0)), 2)
		for i in 2:
			var source_cell := Vector2i(side, i) if rotation == 0 else Vector2i(i, 1 - side)
			var index := rotation * 4 + source_cell.x * 2 + source_cell.y
			var cell := base + (Vector2(0, i) if rotation == 0 else Vector2(i, 0))
			gate_cells.append({"cell": cell, "type": int(sections[37][index]), "mask": int(sections[38][index]) & 255, "depth": cell.x - cell.y})
	gate_cells.sort_custom(func(a, c): return a.depth < c.depth)
	for item in gate_cells:
		var at := _tile_origin(view, item.cell)
		if int(item.type) == 13:
			view._frame(view.art.tiles["water_%d" % (int(view.elapsed * 3.0) % 3)], at, tint)
		else:
			_edge(view, 0, at, tint)
			var special: Dictionary = {5: 13, 6: 12, 7: 11, 8: 14}
			if special.has(item.type):
				_edge(view, special[item.type], at, tint)
		for pair in [[64, 2], [4, 8], [128, 1], [8, 7], [16, 18], [1, 10], [32, 17], [2, 9]]:
			if int(item.mask) & int(pair[0]):
				_edge(view, int(pair[1]), at, tint)
		if (int(item.mask) & 74) == 74:
			_edge(view, 15, at, tint)
		if (int(item.mask) & 133) == 133:
			_edge(view, 16, at, tint)
		if item.type in [5, 6]:
			_edge(view, 3 if int(item.type) == 5 else 4, at, tint)


static func draw_park_entrance(view) -> void:
	var entry: Array = view.sim.state.entrance
	var tables: Array = view.sim.data.tables
	for side in 2:
		var cell := Vector2(float(entry[0]) + (-1 if side == 0 else 1), -1)
		var at := _tile_origin(view, cell)
		for i in 3:
			var k := side * 3 + i
			_region(view, 1, 6, Rect2(0, 112, 15, 12), at + Vector2(tables[37][k], tables[38][k]) * view.zoom)
		if side == 1:
			_region(view, 1, 2, Rect2(90, 83, 15, 20), at + Vector2(-19, -44) * view.zoom)
			_region(view, 1, 2, Rect2(105, 84, 18, 13), at + Vector2(-4, -33) * view.zoom)


static func _draw_cafe_guests(view, b: Dictionary) -> void:
	var tables: Array = view.sim.data.tables
	var occupants: Array = b.get("occupants", [])
	# Three table cells provide four seats each. Tables27/28 have only two
	# coordinate groups because the two x=0 tables share the same local offsets.
	var cells: Array = [Vector2(0, 0), Vector2(0, 1), Vector2(1, 1)]
	for index in mini(12, occupants.size()):
		var visitor: Dictionary = view.sim._visitor(int(occupants[index]))
		if visitor.is_empty():
			continue
		var local: Vector2 = cells[int(index / 4)]
		var seat := index % 4
		var coordinate := int(local.x) * 4 + seat
		var at: Vector2 = _tile_origin(view, Vector2(b.x, b.y) + local) + Vector2(tables[27][coordinate], tables[28][coordinate]) * view.zoom
		if seat < 2:
			view._frame(_actor_frame(view, clampi(int(visitor.type), 0, 7), 4, 1), at)
		else:
			var frame := _actor_frame(view, clampi(int(visitor.type), 0, 7), clampi(int(visitor.get("dir", 3)), 0, 3), 0)
			_draw_cropped_frame(view, frame, at, 7)
