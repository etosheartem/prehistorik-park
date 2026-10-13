extends Control
signal cell_chosen(cell: Vector2)
var sim
var view
var pressed_at := Vector2.ZERO
var pointer_down := false
var pointer_dragged := false

func _ready() -> void:
	mouse_filter = MOUSE_FILTER_STOP
	resized.connect(queue_redraw)

func scale_factor() -> float:
	return minf((size.x - 36) / 2.0, size.y - 36) / maxf(1, int(sim.state.size))

func point(cell: Vector2) -> Vector2:
	var side: float = sim.state.size
	return size * 0.5 + Vector2(cell.x + cell.y - side + 1, (cell.x - cell.y) * 0.5) * scale_factor()

func cell_at(at: Vector2) -> Vector2:
	var p := (at - size * 0.5) / scale_factor()
	var side: float = sim.state.size
	return Vector2((p.x + side - 1) * 0.5 + p.y, (p.x + side - 1) * 0.5 - p.y)

func _draw() -> void:
	if sim == null or sim.state.is_empty(): return
	var side: int = sim.state.size
	var tile := scale_factor()
	for x in side:
		for y in side:
			var cell := Vector2(x, y)
			var poly := PackedVector2Array([point(cell + Vector2(-.5,-.5)),point(cell + Vector2(.5,-.5)),point(cell + Vector2(.5,.5)),point(cell + Vector2(-.5,.5))])
			var key := "%d,%d" % [x,y]
			var color := Color("668d46") if int(sim.state.terrain.get(key,1)) >= 0 else Color("355d37")
			if sim.state.paths.has(key): color = Color("65bbc0") if int(sim.state.paths[key]) == 13 else Color("d0b47a")
			draw_colored_polygon(poly, color)
	for b in sim.state.buildings:
		var color := Color("e6ac61") if b.kind == "ride" else Color("b8c6b4")
		if not b.working: color = Color("bb7962")
		var corners := PackedVector2Array([point(Vector2(b.x-.5,b.y-.5)),point(Vector2(b.x+b.w-.5,b.y-.5)),point(Vector2(b.x+b.w-.5,b.y+b.h-.5)),point(Vector2(b.x-.5,b.y+b.h-.5))])
		draw_colored_polygon(corners, color)
	for v in sim.state.visitors:
		draw_circle(point(Vector2(v.x,v.y)), maxf(1.4,tile*.1), Color("f9edc5"))
	var entrance: Array = sim.state.entrance
	draw_circle(point(Vector2(entrance[0],entrance[1])), 6, Color("f8de8c"))
	if view:
		var center: Vector2 = view.screen_to_cell(view.size * .5)
		draw_arc(point(center), 12, 0, TAU, 24, Color.WHITE, 2, true)

func _activate(at: Vector2) -> void:
	var cell := cell_at(at)
	var side: int = sim.state.size
	if cell.x >= 0 and cell.y >= 0 and cell.x < side and cell.y < side:
		cell_chosen.emit(cell)

func _gui_input(event: InputEvent) -> void:
	if event is InputEventScreenTouch or (event is InputEventMouseButton and event.button_index == MOUSE_BUTTON_LEFT and event.device != -1):
		if event.pressed:
			pressed_at = event.position
			pointer_down = true
			pointer_dragged = false
		else:
			if pointer_down and not pointer_dragged and pressed_at.distance_to(event.position) < 20: _activate(event.position)
			pointer_down = false
	elif event is InputEventScreenDrag or event is InputEventMouseMotion:
		if pointer_down and pressed_at.distance_to(event.position) >= 20: pointer_dragged = true
