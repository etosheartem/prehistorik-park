extends SceneTree
## User-facing regression journeys added for the 0.3 interface.
var game
var viewport: SubViewport
var checks := 0
var failures := 0
var output := ""
var test_settings := "user://redesign_settings_%d.json" % OS.get_process_id()
var test_save := "user://redesign_save_%d.json" % OS.get_process_id()

func _initialize() -> void: run.call_deferred()
func check(value: bool, message: String) -> void:
	checks += 1
	if not value:
		failures += 1
		printerr("FAIL redesign: " + message)
func settle() -> void:
	for frame in 8: await process_frame
func capture(name: String) -> void:
	if output.is_empty(): return
	await settle()
	await RenderingServer.frame_post_draw
	check(viewport.get_texture().get_image().save_png(output.path_join(name + ".png")) == OK, "capture " + name)
func buttons(node: Node) -> Array[Button]:
	var result: Array[Button] = []
	if node is Button: result.append(node)
	for child in node.get_children(): result.append_array(buttons(child))
	return result
func tap(button: Button) -> void:
	for down in [true, false]:
		var event := InputEventMouseButton.new()
		event.button_index = MOUSE_BUTTON_LEFT
		event.pressed = down
		event.device = -1
		event.position = button.get_global_rect().get_center()
		viewport.push_input(event, true)
	await settle()
func find_button(node: Node, text: String) -> Button:
	for button in buttons(node):
		if button.text == text: return button
	return null

func run() -> void:
	for arg in OS.get_cmdline_user_args():
		if arg.begins_with("--screenshots="): output = arg.trim_prefix("--screenshots=")
	if not output.is_empty(): DirAccess.make_dir_recursive_absolute(output)
	viewport = SubViewport.new()
	viewport.size = Vector2i(1080, 1920)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	game = load("res://main.tscn").instantiate()
	game.persistence_enabled = false
	game.settings_path = test_settings
	game.save_path = test_save
	viewport.add_child(game)
	game.set_process(false)
	await settle()
	check(find_button(game.modal_body, "Начать игру") != null, "first launch leads to start, no disabled continue")
	check(game.nav_buttons.size() == 3 and not game.nav_buttons.has("demolish"), "three safe primary navigation actions")
	for mode in game.Graphics.IDS:
		game.settings.quality = mode
		game._apply_settings()
		for height in [1920, 2400, 2520]:
			viewport.size = Vector2i(1080, height)
			await settle()
			game.show_page("home")
			await settle()
			check(Rect2(Vector2.ZERO, viewport.size).encloses(game.modal_panel.get_rect()), "home fits " + mode + str(height))
			check(game.modal_body.size.y <= game.modal_scroll.size.y + 2, "home actions need no scrolling " + mode + str(height))
			if height == 1920 or mode == "remake_maximum": await capture("%s_%d_home" % [mode, height])
			game.show_page("settings")
			await settle()
			check(game.modal_panel.size.y < height * 0.96, "settings height follows content " + str(height))
			check(game.modal_body.size.y <= game.modal_scroll.size.y + 2, "settings have no unnecessary scrolling")
			var selected := 0
			for button in buttons(game.modal_body):
				check(not button.text.begins_with("Тест:"), "player settings contain no developer toggle")
				if button.has_meta("graphics_style") and button.get_meta("active", false): selected += 1
			check(selected == 1, "one visibly checked graphics choice")
			if height == 1920 and mode == "remake_maximum": await capture("settings")
	viewport.size = Vector2i(1080, 1920)
	game.show_page("new")
	await capture("new_park")
	game.show_page("scenarios")
	await capture("scenarios")
	game.chosen_scenario = 1
	game.show_page("setup")
	await capture("scenario_setup")
	game._go_back()
	check(game.page == "scenarios", "Back restores the scenario list")
	game._go_back()
	check(game.page == "new", "Back restores mode selection")
	game.new_game(0, 0, 2026)
	await settle()
	check(game.home_background.texture == null, "entering park releases menu artwork")
	game.show_catalog("rides")
	await settle()
	game.catalog_scroll.scroll_vertical = 500
	await settle()
	var scroll_before: int = game.catalog_scroll.scroll_vertical
	game._choose_build("prop", 0)
	game.show_catalog("rides")
	await settle()
	check(game.catalog_scroll.scroll_vertical == scroll_before, "placement round trip retains catalog position")
	game.show_catalog("services")
	await settle()
	game.show_catalog("rides")
	await settle()
	check(game.catalog_scroll.scroll_vertical == scroll_before, "category round trip retains catalog position")
	game.catalog_scroll.scroll_vertical = 0
	await capture("catalog")
	game._clear_selection()
	check(game.sim.build("ride", 6, Vector2i(1, 3)), "build attraction for demolition journey")
	game._cell_selected(Vector2i(1, 3))
	await settle()
	var before := JSON.stringify(game.sim.snapshot())
	var remove := find_button(game.inspector, "Снести объект…")
	check(remove != null, "demolition belongs to selected attraction")
	if remove: await tap(remove)
	check(game.page == "demolish_confirm" and game.modal.visible, "tap opens confirmation")
	check(before == JSON.stringify(game.sim.snapshot()), "requesting demolition changes no park state")
	await capture("demolition")
	game._go_back()
	check(not game.modal.visible and before == JSON.stringify(game.sim.snapshot()), "Back cancels demolition without loss")
	game._request_demolition(Vector2i(1, 3))
	await settle()
	await tap(find_button(game.modal_body, "Снести"))
	check(game.sim.building_at(Vector2i(1, 3)).is_empty(), "confirmed demolition removes exactly the selected object")
	check(game.message_label.text.begins_with("Снесено:") and game.toast_panel.visible, "successful demolition shows feedback")
	check(game.tool_kind == "select" and not game.inspector.visible, "single-object demolition exits cleanly")
	# Occupied rides must keep their original safeguard through the new dialog.
	check(game.sim.build("ride", 6, Vector2i(1, 3)), "rebuild occupied ride fixture")
	var occupied: Dictionary = game.sim.building_at(Vector2i(1, 3))
	occupied.occupants.append(999)
	game._request_demolition(Vector2i(1, 3))
	game._confirm_demolition()
	check(not game.sim.building_at(Vector2i(1, 3)).is_empty() and game.message_label.text.contains("есть люди"), "occupied ride cannot be destroyed")
	occupied.occupants.clear()
	# Sound-only changes must not discard/recreate GPU textures.
	var texture_key := "test://sound-keeps-cache"
	game.view.textures[texture_key] = null
	var snapshot := JSON.stringify(game.sim.snapshot())
	game.settings.music = 0.23
	game._apply_settings()
	check(game.view.textures.has(texture_key), "volume change retains world texture cache")
	check(snapshot == JSON.stringify(game.sim.snapshot()), "volume change preserves simulation")
	game.view.textures.erase(texture_key)
	game.persistence_enabled = true
	game.settings_tab = "audio"
	game.show_page("settings")
	for child in game.modal_body.get_children():
		if child is HSlider:
			child.value = 31
			break
	game._go_back()
	check(is_equal_approx(game.Store.settings(test_settings).music, 0.31), "Back persists slider value without requiring Done")
	game.persistence_enabled = false
	game.show_page("pause")
	await settle()
	check(game.modal_panel.size.y < viewport.size.y * 0.6, "pause is a compact dialog")
	await capture("pause")
	game.show_page("map")
	await settle()
	check(game.modal_body.size.y <= game.modal_scroll.size.y + 2, "map actions fit without scrolling")
	await capture("map")
	var map: Control
	for child in game.modal_body.get_children():
		if child.has_method("cell_at"): map = child
	check(map != null, "map control is present")
	if map:
		var sample := Vector2(4, 6)
		var at: Vector2 = map.global_position + map.point(sample)
		for down in [true, false]:
			var finger := InputEventScreenTouch.new()
			finger.index = 0
			finger.position = at
			finger.pressed = down
			viewport.push_input(finger, true)
		await settle()
		check(not game.modal.visible, "native touch chooses map position")
		check(game.view.cell_to_screen(sample).distance_to(game.view.size * Vector2(0.5, 0.43)) < 5, "native map touch focuses requested cell")
	game.resume_game()
	for method in ["show_staff", "show_stats", "show_goals"]:
		game.call(method)
		await settle()
		check(not game.sheet_shade.visible and game.view.input_enabled, "management sheet leaves park interactive: " + method)
		await capture(method)
	game.show_page("help")
	await capture("help")
	game.show_page("home")
	await settle()
	check(game.home_background.texture != null, "returning to home restores menu artwork")
	check(find_button(game.modal_body, "Продолжить парк") != null, "existing park gets the primary continue action")
	check(game.modal_body.size.y <= game.modal_scroll.size.y + 2, "saved park home needs no scrolling")
	await capture("home_saved")
	game.sound.shutdown()
	await create_timer(0.3).timeout
	game.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	for file in [test_settings, test_settings + ".bak", test_save, test_save + ".bak"]:
		if FileAccess.file_exists(file): DirAccess.remove_absolute(file)
	print("REDESIGN OK: %d checks" % checks if failures == 0 else "REDESIGN FAILED: %d/%d" % [failures, checks])
	quit(0 if failures == 0 else 1)
