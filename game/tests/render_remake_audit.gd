extends SceneTree
## Exercise the actual world renderer, every animation phase and both entrances.
## Save representative phases with a shared camera for manual source comparison.
const Sim = preload("res://scripts/park_sim.gd")
class Preview:
	extends "res://scripts/park_view.gd"
	var building := {}
	var base := Vector2.ZERO
	var tint := Color.WHITE
	func origin() -> Vector2: return base
	func _draw() -> void:
		if not building.is_empty(): _draw_building(building, tint)

var viewport: SubViewport
var view: Preview
var count := 0
var failed := false
var records: Array = []
var folder := ProjectSettings.globalize_path("res://../art/review/remake_audit/rendered")

func _initialize() -> void: run.call_deferred()

func capture(label: String, save: bool) -> void:
	view.queue_redraw()
	await process_frame
	await RenderingServer.frame_post_draw
	var pixels := viewport.get_texture().get_image()
	var bounds := pixels.get_used_rect()
	if bounds.size == Vector2i.ZERO or not Rect2i(4,4,504,504).encloses(bounds):
		failed = true
		printerr("RENDER AUDIT FAIL: empty or clipped frame: ", label, " ", bounds)
		save = true
	if save:
		if pixels.save_png(folder.path_join(label + ".png")) != OK: failed = true
		records.append({"frame":label, "bounds":[bounds.position.x,bounds.position.y,bounds.size.x,bounds.size.y]})
	count += 1

func run() -> void:
	if DisplayServer.get_name() == "headless":
		printerr("Render audit requires a GPU display"); quit(1); return
	Engine.max_fps = 0
	DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_DISABLED)
	DirAccess.make_dir_recursive_absolute(folder)
	viewport = SubViewport.new()
	viewport.size = Vector2i(512, 512)
	viewport.transparent_bg = true
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	view = Preview.new()
	view.sim = Sim.new()
	view.sim.new_game(-1, 0, 123)
	view.size = Vector2(512,512)
	viewport.add_child(view)
	var geometry: Dictionary = view.Graphics._json("res://assets/original/commands.json")
	for kind in ["ride", "prop"]:
		var items: Array = view.source_art.rides if kind == "ride" else view.source_art.scenery
		for id in items.size():
			var item: Dictionary = items[id]
			var catalog: Dictionary = view.sim._catalog(kind, id)
			var low := Vector2(0, -float(catalog.size[1]) * 10)
			var high := Vector2(float(catalog.size[0] + catalog.size[1])*20, float(catalog.size[0])*10+20)
			var variants: Dictionary = {"working":item.frames} if kind == "ride" else item.variants
			for frames in variants.values():
				for frame in frames:
					low = low.min(Vector2(frame.offset[0], frame.offset[1]))
					high = high.max(Vector2(frame.offset[0]+frame.size[0],frame.offset[1]+frame.size[1]))
			if kind == "ride" and id == 22:
				low = low.min(Vector2(0,-80)); high = high.max(Vector2(140,60))
			low -= Vector2(24,24)
			high += Vector2(24,24)
			view.zoom = minf(480.0/(high.x-low.x),480.0/(high.y-low.y))
			view.base = (Vector2(512,512)-(high-low)*view.zoom)/2-low*view.zoom
			for rotation in (2 if kind == "ride" else 1):
				view.building = {"kind":kind,"type":id,"x":0,"y":0,"w":catalog.size[0],"h":catalog.size[1],"phase":3,"phase_t":0.0,"rotation":rotation,"occupants":[],"working":true,"open":true,"water_exit":[4,0],"exit_rotation":1-rotation}
				for mode in ["original", "remake_medium", "remake_maximum"]:
					view.configure(mode)
					for state in variants:
						view.building.open = state != "closed"
						view.building.working = state != "unstaffed"
						var total: int = variants[state].size()
						var selected := [0, total/4, total/2, total*3/4, total-1]
						if kind == "ride":
							for phase in total:
								for cmd in geometry.rides[id][phase]:
									if cmd[0] == 0 and cmd.slice(1,7) == [1,2,100,60,24,13]:
										selected.append(phase); break
						for phase in total:
							view.building.phase_t = phase * 0.1
							view.elapsed = phase / (10.0 if kind == "ride" else 6.0) + 0.000001
							await capture("%s_%02d_r%d_%s_p%03d_%s" % [kind,id,rotation,state,phase,mode], phase in selected)
					if kind == "ride":
						view.tint = Color(1,1,1,0.62)
						view.building.phase_t = 0.0
						view.elapsed = 0.0
						await capture("%s_%02d_r%d_ghost_%s" % [kind,id,rotation,mode], true)
						view.tint = Color.WHITE
			print("RENDER AUDIT: ", kind, " ", id, " complete; ", count, " frames")
	var report := {"rendered_frames":count,"saved_frames":records.size(),"passed":not failed,"renderer":RenderingServer.get_current_rendering_method(),"records":records}
	FileAccess.open(folder.path_join("report.json"),FileAccess.WRITE).store_string(JSON.stringify(report,"\t"))
	print("RENDER AUDIT %s: %d frames / %d saved comparisons" % ["OK" if not failed else "FAILED",count,records.size()])
	quit(1 if failed else 0)
