extends SceneTree
## Real rendered park from public-playthrough save; benchmark overrides only the
## finished status through the explicit debug switch so that simulation can run.
const Sim = preload("res://scripts/park_sim.gd")
const Graphics = preload("res://scripts/park_graphics.gd")
var output := "/tmp/park_render"
var fixture := "../art/review/acceptance_park.json"
var viewport: SubViewport
var game
var samples: Array = []

func _initialize() -> void:
	start.call_deferred()

func start() -> void:
	for arg in OS.get_cmdline_user_args():
		if arg.begins_with("--fixture="): fixture = arg.trim_prefix("--fixture=")
		if arg.begins_with("--output="): output = arg.trim_prefix("--output=")
	if not FileAccess.file_exists(fixture):
		printerr("Missing acceptance fixture: " + fixture)
		quit(1)
		return
	DirAccess.make_dir_recursive_absolute(output)
	viewport = SubViewport.new()
	viewport.size = Vector2i(1440,2560)
	viewport.size_2d_override = Vector2i(1080,1920)
	viewport.size_2d_override_stretch = true
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	game = load("res://main.tscn").instantiate()
	game.persistence_enabled = false
	game.settings_path = "user://unused_render_settings.json"
	viewport.add_child(game)
	await process_frame
	game.set_process(false)
	var data = JSON.parse_string(FileAccess.get_file_as_string(fixture))
	if not game.sim.restore(data):
		printerr("Fixture does not restore: " + game.sim.last_error)
		quit(1)
		return
	game.running = true
	game.settings.quality = Graphics.DEFAULT
	game._apply_settings()
	game.result_shown = true
	game.resume_game()
	var public_cash: int = game.sim.state.money
	var public_status: String = game.sim.state.status
	game.sim.set_debug(true)
	game.sim.state.status = "playing"
	game.sound.configure({"music":0,"effects":0})
	game.view.center_park()
	await capture("qhd_overview")
	game.view.focus_cell(Vector2(9,7), 5.5)
	await capture("qhd_detail")
	for frame in 240:
		var start_time := Time.get_ticks_usec()
		game.sim.advance(1.0/60.0)
		game.view.advance(1.0/60.0)
		if frame >= 20: samples.append((Time.get_ticks_usec()-start_time)/1000.0)
		await process_frame
	await capture("qhd_running")
	game.show_page("map")
	await capture("qhd_map")
	game.resume_game()
	game._choose_build("ride", 0)
	game._cell_selected(Vector2i(17,17))
	await capture("qhd_build_preview")
	game._clear_selection()
	game.view.center_park()
	var modes := {}
	for mode in Graphics.IDS:
		game.settings.quality = mode
		game._apply_settings()
		game.view.center_park()
		await capture("qhd_" + mode + "_overview")
		game.view.focus_cell(Vector2(9,7), 5.5)
		await capture("qhd_" + mode + "_detail")
		modes[mode] = {"draw_calls":Performance.get_monitor(Performance.RENDER_TOTAL_DRAW_CALLS_IN_FRAME),"texture_memory_bytes":Performance.get_monitor(Performance.RENDER_TEXTURE_MEM_USED)}
	game.settings.quality = Graphics.DEFAULT
	game._apply_settings()
	game.show_catalog("rides")
	await capture("qhd_catalog")
	game.resume_game()
	samples.sort()
	var total:=0.0
	for v in samples: total += float(v)
	var report: Dictionary = {"viewport":[1440,2560],"guests":game.sim.state.visitors.size(),"buildings":game.sim.state.buildings.size(),"source_public_status":public_status,"source_public_cash":public_cash,"simulation_ms_mean":total/samples.size(),"simulation_ms_p95":samples[int(samples.size()*.95)],"simulation_ms_max":samples.back(),"renderer":RenderingServer.get_video_adapter_name(),"render_draw_calls":Performance.get_monitor(Performance.RENDER_TOTAL_DRAW_CALLS_IN_FRAME),"video_memory_bytes":Performance.get_monitor(Performance.RENDER_VIDEO_MEM_USED),"texture_memory_bytes":Performance.get_monitor(Performance.RENDER_TEXTURE_MEM_USED),"note":"Desktop QHD render; not a phone benchmark. Debug switch is used after restoring the completed acceptance park."}
	report["modes"] = modes
	FileAccess.open(output.path_join("report.json"),FileAccess.WRITE).store_string(JSON.stringify(report,"  "))
	print("RENDER PARK OK ", JSON.stringify(report))
	game.sound.shutdown()
	await create_timer(.3).timeout
	game.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	quit(0)

func capture(name: String) -> void:
	await process_frame
	await process_frame
	await RenderingServer.frame_post_draw
	var image := viewport.get_texture().get_image()
	if image.save_png(output.path_join(name+".png")) != OK:
		printerr("Screenshot failed: "+name)
		quit(1)
