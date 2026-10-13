extends SceneTree
## Release journeys: settings isolation, persistent copies, import and camera recovery.
var game
var viewport: SubViewport
var checks := 0
var failures := 0
var prefix := "user://release_%d" % OS.get_process_id()

func _initialize() -> void: run.call_deferred()
func check(ok: bool, message: String) -> void:
	checks += 1
	if not ok:
		failures += 1
		printerr("RELEASE FAIL: " + message)
func settle() -> void:
	for i in 8: await process_frame

func run() -> void:
	viewport = SubViewport.new()
	viewport.size = Vector2i(1080, 1920)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	game = load("res://main.tscn").instantiate()
	game.persistence_enabled = false
	game.settings_path = prefix + "_settings.json"
	game.save_path = prefix + "_park.json"
	viewport.add_child(game)
	await settle()
	game.set_process(false)
	game.new_game(-1, 0, 32424)
	var state: String = JSON.stringify(game.sim.snapshot())
	for mode in game.Graphics.IDS:
		game.settings.quality = mode
		game._apply_settings()
		for tab in ["graphics", "audio", "controls", "saves"]:
			game.settings_tab = tab
			game.show_page("settings")
			await settle()
			check(state == JSON.stringify(game.sim.snapshot()), "settings / preview preserve park and RNG: " + mode + "/" + tab)
			check(Rect2(Vector2.ZERO, viewport.size).encloses(game.modal_panel.get_rect()), "settings panel fits: " + tab)
			check(game.modal_body.size.y <= game.modal_scroll.size.y + 2, "all actions visible: " + mode + "/" + tab)
	game.settings.merge({"fps":30,"shadows":false,"particles":false,"color_style":"warm","camera_speed":1.4,"reduced_motion":true,"build_grid":false}, true)
	game.persistence_enabled = true
	game._apply_settings()
	var loaded: Dictionary = game.Store.settings(game.settings_path)
	for key in ["fps", "shadows", "particles", "color_style", "camera_speed", "reduced_motion", "build_grid"]:
		check(loaded[key] == game.settings[key], "setting survives restart: " + key)
	check(Engine.max_fps == 30, "frame cap applied")
	check(not game.view.soft_shadows and game.view.camera_speed == 1.4, "render and camera options applied")
	game.view.burst(Vector2i(3,3))
	check(game.view.bursts.is_empty(), "reduced motion / disabled particles prevent bursts")
	game.settings_tab = "saves"
	game.make_manual_backup()
	var manual: Dictionary = game.Store.read_json(game.manual_save_path())
	check(manual.get("format") == "prehistorik-park", "manual backup created")
	game.sim.build("path", 0, Vector2i(1,1))
	game.save_game()
	check(game.Store.read_json(game.manual_save_path()) == manual, "autosave never overwrites personal copy")
	var changed: String = JSON.stringify(game.sim.snapshot())
	check(game.export_save_to(prefix + "_export.json"), "export writes a valid save")
	check(game.prepare_import(prefix + "_export.json"), "exported save can be imported")
	check(game.page == "import_confirm" and JSON.stringify(game.sim.snapshot()) == changed, "import requires confirmation and preserves current state")
	game._go_back()
	check(game.pending_import.is_empty() and JSON.stringify(game.sim.snapshot()) == changed, "Back discards pending import")
	game.Store.write_json(prefix + "_bad.json", {"format":"prehistorik-park","game":{"money":123}})
	check(not game.prepare_import(prefix + "_bad.json"), "malformed save rejected")
	check(JSON.stringify(game.sim.snapshot()) == changed, "malformed import leaves current park untouched")
	check(game.restore_manual_backup(), "personal copy restores")
	check(JSON.stringify(game.sim.snapshot()) == state, "restore includes deterministic random state")
	check(game.Store.read_json(game.save_path + ".before_restore.json").game.paths.size() > manual.game.paths.size(), "pre-restore safety copy retains the replaced park")
	game.view.pan = Vector2(100000, -100000)
	game.view.constrain_camera()
	check(game.view.pan.length() < 20000, "camera cannot lose the entire park")
	game.show_catalog("rides")
	var total: int = game.catalog_row.get_child_count()
	game.catalog_query = "качели"
	game.show_catalog("rides")
	check(game.catalog_row.get_child_count() == 1 and total > 1, "catalog search finds a specific ride")
	game.catalog_query = "несуществующий аттракцион"
	game.show_catalog("rides")
	check(game.catalog_count.text == "Найдено: 0", "empty search has clear feedback")
	await settle()
	check(game.catalog_row.get_child(0).size.x > 400, "empty search uses readable width")
	game.catalog_search.grab_focus()
	game.catalog_search.text = "кач"
	game.catalog_search.text_changed.emit("кач")
	await settle()
	check(game.catalog_search.has_focus(), "filtering preserves typing focus")
	check(game.catalog_row.get_child_count() == 1, "typing filters without closing the catalog")
	game.settings.quality = "remake_maximum"
	game._apply_settings()
	var key := "res://assets/hd/parts/rides/part_3.png"
	var full: Texture2D = game.view._texture(key)
	var full_width := full.get_width()
	game.settings.quality = "remake_medium"
	game._apply_settings()
	if DisplayServer.get_name() != "headless":
		check(game.view._texture(key).get_width() == full_width / 2, "balanced mode uses genuinely smaller textures")
	full = null
	game.sound.shutdown()
	await create_timer(0.3).timeout
	game.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	var dir := DirAccess.open("user://")
	for file in dir.get_files():
		if file.begins_with(prefix.trim_prefix("user://")): dir.remove(file)
	print("RELEASE OK: %d checks" % checks if failures == 0 else "RELEASE FAILED: %d/%d" % [failures, checks])
	quit(0 if failures == 0 else 1)
