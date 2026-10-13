extends SubViewportContainer
## An isolated animated sample: settings can never tick or modify the real park.
const Sim = preload("res://scripts/park_sim.gd")
const ParkView = preload("res://scripts/park_view.gd")
var world
var options := {}
var preview_view: Control
var clock := 0.0

func _ready() -> void:
	mouse_filter = Control.MOUSE_FILTER_IGNORE
	stretch = true
	var viewport := SubViewport.new()
	viewport.size = Vector2i(1000, 310)
	viewport.render_target_update_mode = SubViewport.UPDATE_WHEN_PARENT_VISIBLE
	viewport.gui_disable_input = true
	add_child(viewport)
	world = Sim.new()
	world.new_game(-1, 0, 2026)
	world.set_debug(true)
	world.state.terrain.clear()
	world.state.buildings.clear()
	world.state.paths.clear()
	world.build("ride", 6, Vector2i(4, 5))
	world.build("ride", 11, Vector2i(7, 5))
	world.build("prop", 0, Vector2i(3, 4))
	world.build("prop", 8, Vector2i(7, 9))
	for x in range(4, 11): world.state.paths["%d,4" % x] = 0
	for b in world.state.buildings:
		b.working = true
		b.phase = 3
		b.phase_t = 0.0
	preview_view = ParkView.new()
	preview_view.sim = world
	viewport.add_child(preview_view)
	preview_view.set_anchors_and_offsets_preset(Control.PRESET_FULL_RECT)
	preview_view.input_enabled = false
	preview_view.configure(str(options.get("quality", "remake_maximum")))
	preview_view.configure_options(options)
	resized.connect(_frame_sample)
	_frame_sample.call_deferred()

func _frame_sample() -> void:
	if not is_instance_valid(preview_view) or size.y < 1: return
	var bounds := Rect2()
	var first := true
	for building in world.state.buildings:
		var item: Dictionary = preview_view.art.rides[int(building.type)] if building.kind == "ride" else preview_view.art.scenery[int(building.type)]
		var base: Vector2 = preview_view.iso(Vector2(building.x, building.y))
		for frame in item.frames:
			var rect := Rect2(base + Vector2(frame.offset[0], frame.offset[1]), Vector2(frame.size[0], frame.size[1]))
			bounds = rect if first else bounds.merge(rect)
			first = false
		for corner in [Vector2(-0.5, -0.5), Vector2(building.w - 0.5, -0.5), Vector2(building.w - 0.5, building.h - 0.5), Vector2(-0.5, building.h - 0.5)]:
			bounds = bounds.expand(preview_view.iso(Vector2(building.x, building.y) + corner) + Vector2(20, 10))
	preview_view.zoom = minf((size.x - 40) / bounds.size.x, (size.y - 32) / bounds.size.y)
	preview_view.pan = Vector2.ZERO
	preview_view.pan = size * 0.5 - preview_view.origin() - bounds.get_center() * preview_view.zoom
	preview_view.queue_redraw()

func _process(dt: float) -> void:
	if not is_instance_valid(preview_view) or not is_visible_in_tree(): return
	if not bool(options.get("reduced_motion", false)):
		clock += minf(dt, 0.1)
		for b in world.state.buildings: b.phase_t = clock
		preview_view.advance(dt)
