extends SceneTree
## Render the actual assembled object, then trim transparent margins for UI cards.
const Sim = preload("res://scripts/park_sim.gd")
class Preview:
	extends "res://scripts/park_view.gd"
	var building := {}
	var base := Vector2.ZERO
	func origin() -> Vector2: return base
	func _draw() -> void:
		if not building.is_empty(): _draw_building(building)

func _initialize() -> void: run.call_deferred()

func run() -> void:
	var viewport := SubViewport.new()
	viewport.size = Vector2i(1024, 1024)
	viewport.transparent_bg = true
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	var view := Preview.new()
	view.sim = Sim.new()
	view.sim.new_game(-1, 0, 123)
	view.size = Vector2(1024, 1024)
	viewport.add_child(view)
	var count := 0
	for mode in ["original", "original_upscaled", "remake_maximum"]:
		view.configure(mode)
		var folder := ProjectSettings.globalize_path("res://assets/ui/catalog/" + mode)
		DirAccess.make_dir_recursive_absolute(folder)
		for kind in ["ride", "prop"]:
			var items: Array = view.art.rides if kind == "ride" else view.art.scenery
			for id in items.size():
				var item: Dictionary = items[id]
				var frame: Dictionary = item.frames[0]
				var catalog: Dictionary = view.sim._catalog(kind, id)
				var low := Vector2(minf(0, frame.offset[0]), minf(-float(catalog.size[1]) * 10, frame.offset[1]))
				var high := Vector2(maxf(float(catalog.size[0] + catalog.size[1]) * 20, float(frame.offset[0]) + frame.size[0]), maxf(float(catalog.size[0]) * 10 + 20, float(frame.offset[1]) + frame.size[1]))
				view.zoom = minf(880.0 / (high.x - low.x), 880.0 / (high.y - low.y))
				view.base = Vector2(72, 72) - low * view.zoom
				view.building = {"kind":kind, "type":id, "x":0, "y":0, "w":catalog.size[0], "h":catalog.size[1], "phase":0, "rotation":0, "occupants":[], "working":true, "open":true, "water_exit":[], "exit_rotation":0}
				view.queue_redraw()
				await process_frame
				await RenderingServer.frame_post_draw
				var pixels := viewport.get_texture().get_image()
				var bounds := pixels.get_used_rect()
				if bounds.size.x <= 0 or bounds.size.y <= 0:
					push_error("Empty catalog icon: " + mode + kind + str(id))
					quit(1)
					return
				var cropped := pixels.get_region(bounds.grow(3).intersection(Rect2i(0, 0, 1024, 1024)))
				var ratio := minf(420.0 / cropped.get_width(), 230.0 / cropped.get_height())
				cropped.resize(maxi(1, roundi(cropped.get_width() * ratio)), maxi(1, roundi(cropped.get_height() * ratio)), Image.INTERPOLATE_NEAREST if mode == "original" else Image.INTERPOLATE_LANCZOS)
				var error := cropped.save_png(folder.path_join("%s_%d.png" % [kind, id]))
				if error != OK: quit(1); return
				count += 1
	print("CATALOG: %d tightly framed previews from actual object layers" % count)
	quit()
