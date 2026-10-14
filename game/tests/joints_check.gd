extends SceneTree
## Sample the real rasterized seams, including fractional camera positions and
## mipmapped zoom levels. File/command presence alone cannot catch these gaps.
const Sim = preload("res://scripts/park_sim.gd")
const Graphics = preload("res://scripts/park_graphics.gd")
const JOINTS := [
	["water_top",7,"1:6:57:37:26:12","1:6:35:0:35:37",Vector2(36,-30),Vector2(56,-30)],
	["water_side",7,"1:6:35:0:35:37","1:6:70:13:11:22",Vector2(65,-14),Vector2(65,1)],
	["mountain_wall",9,"1:6:0:37:44:75","1:6:44:59:15:54",Vector2(74,-30),Vector2(74,10)],
	["mountain_foot",9,"1:6:44:59:15:54","1:6:44:37:13:22",Vector2(89,0),Vector2(89,12)],
	["haunted_front",5,"1:6:81:0:30:44","1:6:83:44:29:54",Vector2(49,-30),Vector2(49,4)],
	["haunted_side",5,"1:6:83:44:29:54","1:6:83:98:20:26",Vector2(78,-20),Vector2(78,0)],
]
class PairView:
	extends "res://scripts/park_view.gd"
	var commands: Array = []
	var base := Vector2.ZERO
	var tint := Color.WHITE
	func origin() -> Vector2: return base
	func _draw() -> void: layers._draw_commands(self,commands,base,tint)

var checks := 0
var failures := 0
var folder := ""
func check(ok: bool, message: String) -> void:
	checks += 1
	if not ok: failures += 1; printerr("JOINTS FAIL: "+message)
func _initialize() -> void: run.call_deferred()
func run() -> void:
	for arg in OS.get_cmdline_user_args():
		if arg.begins_with("--output="): folder = arg.trim_prefix("--output=")
	var manifest := Graphics.load_part_manifest("remake_maximum")
	var joined := 0
	for key in manifest:
		var entry: Dictionary = manifest[key]
		if not entry.has("joint_trim"): continue
		joined += 1
		check(not entry.get("flip_x",false),"joining cut has canonical orientation: "+key)
		check(entry.joint_trim.size() == 4 and entry.joint_overlap.size() == 4,"four joining edges: "+key)
		for value in entry.joint_trim + entry.joint_overlap:
			check(float(value) >= 0 and float(value) <= 1,"correction stays within one source pixel: "+key)
		for mode in ["original","original_upscaled"]:
			check(not Graphics.load_part_manifest(mode).get(key,{}).has("joint_trim"),"source styles never use remake joint corrections")
	check(joined == 10,"all ten painted rock pieces covered")
	if DisplayServer.get_name() != "headless": await check_pixels()
	print("JOINTS %s: %d checks" % ["OK" if failures == 0 else "FAILED",checks])
	quit(0 if failures == 0 else 1)
func check_pixels() -> void:
	Engine.max_fps = 0
	DisplayServer.window_set_vsync_mode(DisplayServer.VSYNC_DISABLED)
	var viewport := SubViewport.new()
	viewport.size = Vector2i(768,768)
	viewport.transparent_bg = true
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	var view := PairView.new()
	view.sim = Sim.new(); view.sim.new_game(-1,0,1)
	view.size = Vector2(768,768); viewport.add_child(view)
	var source: Dictionary = Graphics._json("res://assets/original/commands.json")
	var records: Array = []
	if not folder.is_empty(): DirAccess.make_dir_recursive_absolute(folder)
	for joint in JOINTS:
		view.commands = []
		for command in source.rides[joint[1]][0]:
			if command[0] != 0: continue
			var key := "%d:%d:%d:%d:%d:%d" % command.slice(1,7)
			if key in [joint[2],joint[3]]: view.commands.append(command)
		check(view.commands.size() == 2,"source pair exists: "+joint[0])
		# Control captures use the same renderer and painted assets as 1.1.0.
		# They must expose the actual reported gap, not just a metadata change.
		if joint[0] in ["water_top","mountain_wall"]:
			view.configure("remake_maximum")
			for entry in view.part_overrides.values():
				entry.erase("joint_trim"); entry.erase("joint_overlap")
			view.zoom = 5.0
			view.base = Vector2(384,384) - (joint[4]+joint[5])*0.5*view.zoom
			view.queue_redraw(); await process_frame; await RenderingServer.frame_post_draw
			var before := viewport.get_texture().get_image()
			var holes := 0
			for i in 100:
				var at: Vector2 = view.base+joint[4].lerp(joint[5],(i+0.5)/100.0)*view.zoom
				if before.get_pixelv(Vector2i(at)).a < 0.8: holes += 1
			check(holes > 20,"control reproduces old visible gap: "+joint[0])
			if not folder.is_empty(): before.save_png(folder.path_join(joint[0]+"_before.png"))
		for mode in ["remake_medium","remake_maximum"]:
			view.configure(mode)
			if RenderingServer.get_current_rendering_method() != "gl_compatibility": viewport.msaa_2d = Graphics.msaa(mode)
			for zoom in [0.75,1.0,2.75,5.0,7.0]:
				view.zoom = zoom
				for offset in [Vector2.ZERO,Vector2(0.37,0.61)]:
					view.base = Vector2(384,384) - (joint[4]+joint[5])*0.5*zoom + offset
					view.queue_redraw(); await process_frame; await RenderingServer.frame_post_draw
					var pixels := viewport.get_texture().get_image()
					var count := maxi(2,ceili(joint[4].distance_to(joint[5])*zoom))
					var solid := 0
					var lowest := 1.0
					for i in count:
						var at: Vector2 = view.base + joint[4].lerp(joint[5],(i+0.5)/count)*zoom
						var alpha := pixels.get_pixelv(Vector2i(at)).a
						lowest = minf(lowest,alpha)
						if alpha >= 0.9: solid += 1
					var coverage := float(solid)/count
					var label := "%s/%s/zoom%.2f/offset%s" % [joint[0],mode,zoom,offset]
					check(coverage >= 0.95,"opaque seam "+label+" coverage="+str(coverage)+" minimum="+str(lowest))
					records.append({"joint":joint[0],"mode":mode,"zoom":zoom,"camera":[offset.x,offset.y],"opaque_fraction":coverage,"min_alpha":lowest})
					if not folder.is_empty() and zoom == 5.0 and offset == Vector2.ZERO:
						pixels.save_png(folder.path_join(joint[0]+"_"+mode+".png"))
	if not folder.is_empty():
		FileAccess.open(folder.path_join("joints.json"),FileAccess.WRITE).store_string(JSON.stringify({"passed":failures==0,"samples":records},"\t"))
