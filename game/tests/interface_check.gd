extends SceneTree

var checks := 0
var failures := 0
var game
var viewport: SubViewport
var output := ""
var test_save := "user://interface_%d.json" % OS.get_process_id()
var taps := 0
var test_settings := "user://interface_settings_%d.json" % OS.get_process_id()

func _initialize() -> void:
	start.call_deferred()

func check(value: bool, message: String) -> void:
	checks += 1
	if not value:
		failures += 1
		printerr("FAIL interface: " + message)

func settle() -> void:
	for frame in 5: await process_frame

func capture(name: String) -> void:
	if output.is_empty(): return
	await settle()
	await RenderingServer.frame_post_draw
	var im := viewport.get_texture().get_image()
	check(im.save_png(output.path_join(name + ".png")) == OK, "save screenshot " + name)

func touch(id: int, at: Vector2, down: bool) -> void:
	var event := InputEventScreenTouch.new()
	event.index = id
	event.position = at
	event.pressed = down
	game.view._gui_input(event)

func drag_touch(id: int, at: Vector2) -> void:
	var event := InputEventScreenDrag.new()
	event.index = id
	event.position = at
	game.view._gui_input(event)

func start() -> void:
	for argument in OS.get_cmdline_user_args():
		if argument.begins_with("--screenshots="): output = argument.trim_prefix("--screenshots=")
	if not output.is_empty():
		check(DisplayServer.get_name() != "headless", "screenshots need renderer")
		DirAccess.make_dir_recursive_absolute(output)
	viewport = SubViewport.new()
	viewport.size = Vector2i(1080, 1920)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	game = load("res://main.tscn").instantiate()
	game.persistence_enabled = false
	game.save_path = test_save
	game.settings_path = test_settings
	viewport.add_child(game)
	game.set_process(false)
	await settle()
	check(game.page == "home" and game.modal.visible, "home displayed")
	for layout in [Vector2i(1080, 1920), Vector2i(1080, 2400), Vector2i(1080, 2520)]:
		var width: int = layout.y
		viewport.size = layout
		await settle()
		for page in ["home", "new", "setup", "settings", "help", "credits"]:
			game.show_page(page)
			await settle()
			check(Rect2(Vector2.ZERO, viewport.size).encloses(game.modal_panel.get_rect()), "modal fits " + page + str(width))
			check(game.modal_body.size.x <= game.modal_panel.size.x, "content width fits " + page)
			if page in ["home", "settings"]: await capture("%d_%s" % [width, page])
	viewport.size = Vector2i(1080, 1920)
	await settle()
	game.speed = 0
	game.new_game(0, 0, 2026)
	check(game.speed == 1, "new park does not inherit old pause speed")
	check(game.running and not game.modal.visible, "new game is playable")
	check(game.sim.state.money == 500, "new game has original starting funds")
	game._clear_selection()
	for cell in [Vector2i(0, 0), Vector2i(5, 5), Vector2i(11, 11), Vector2i(3, 9)]:
		check(game.view.screen_to_cell(game.view.cell_to_screen(Vector2(cell))) == cell, "isometric picking roundtrip")
	var pinned: Vector2 = game.view.cell_to_screen(Vector2(5, 5))
	game.view.change_zoom(1.2, pinned)
	check(game.view.cell_to_screen(Vector2(5, 5)).distance_to(pinned) < 0.01, "zoom retains point under pointer")
	game.view.cell_selected.connect(func(_cell): taps += 1)
	var touch_center := Vector2(600, 750)
	touch(0, touch_center, true)
	touch(0, touch_center, false)
	check(taps == 1, "native touch taps exactly once")
	var zoom_before: float = game.view.zoom
	touch(0, touch_center - Vector2(100, 0), true)
	touch(1, touch_center + Vector2(100, 0), true)
	drag_touch(1, touch_center + Vector2(160, 0))
	touch(1, touch_center + Vector2(160, 0), false)
	drag_touch(0, touch_center)
	touch(0, touch_center, false)
	check(game.view.zoom > zoom_before and taps == 1, "two fingers zoom without accidental build after release")
	var pan_before: Vector2 = game.view.pan
	touch(0, touch_center, true)
	drag_touch(0, touch_center + Vector2(50, 40))
	touch(0, touch_center + Vector2(50, 40), false)
	check(game.view.pan.distance_to(pan_before + Vector2(50,40)) < .01 and taps == 1, "single finger drag pans without tap")
	var routed_before := taps
	for down in [true,false]:
		var native := InputEventScreenTouch.new()
		native.index = 0
		native.position = touch_center
		native.pressed = down
		viewport.push_input(native, true)
	await settle()
	check(taps == routed_before + 1, "viewport routes native touch through the real GUI")
	var button_zoom: float = game.view.zoom
	var zoom_button: Button = game.zoom_controls.get_child(1)
	for down in [true,false]:
		var emulated := InputEventMouseButton.new()
		emulated.button_index = MOUSE_BUTTON_LEFT
		emulated.position = zoom_button.get_global_rect().get_center()
		emulated.pressed = down
		emulated.device = -1
		viewport.push_input(emulated, true)
	await settle()
	check(game.view.zoom > button_zoom, "emulated touch still activates native UI buttons")
	game.show_page("map")
	await settle()
	check(game.modal.visible and game.page == "map", "minimap opens")
	for child in game.modal_body.get_children():
		if child.has_method("cell_at"):
			var sample := Vector2(4, 6)
			check(child.cell_at(child.point(sample)).distance_to(sample) < .01, "minimap picking roundtrip")
			child.cell_chosen.emit(sample)
	check(not game.modal.visible, "minimap jumps back to game")
	game.show_catalog("rides")
	await settle()
	check(game.catalog_row.columns == 2 and game.catalog_row.get_child_count() == 24, "original attraction category in two-column portrait library")
	check(game.sheet_shade.visible and not game.view.input_enabled, "library blocks park gestures")
	check(game.catalog_scroll.horizontal_scroll_mode == ScrollContainer.SCROLL_MODE_DISABLED, "library scrolls vertically")
	# Godot 4.7 enables finger dragging only when a touchscreen is reported.
	# Enable its desktop touchscreen emulation for this routed gesture check.
	Input.emulate_touch_from_mouse = true
	var scroll_start: Vector2 = game.catalog_row.get_child(0).get_global_rect().get_center()
	var finger := InputEventScreenTouch.new()
	finger.index = 0
	finger.position = scroll_start
	finger.pressed = true
	viewport.push_input(finger, true)
	var press := InputEventMouseButton.new()
	press.button_index = MOUSE_BUTTON_LEFT
	press.position = scroll_start
	press.pressed = true
	press.device = -1
	viewport.push_input(press, true)
	for step in range(1, 9):
		var finger_motion := InputEventScreenDrag.new()
		finger_motion.index = 0
		finger_motion.position = scroll_start - Vector2(0, step * 28)
		finger_motion.relative = Vector2(0, -28)
		viewport.push_input(finger_motion, true)
		var motion := InputEventMouseMotion.new()
		motion.position = scroll_start - Vector2(0, step * 28)
		motion.relative = Vector2(0, -28)
		motion.button_mask = MOUSE_BUTTON_MASK_LEFT
		motion.device = -1
		viewport.push_input(motion, true)
		await process_frame
	finger = InputEventScreenTouch.new()
	finger.index = 0
	finger.position = scroll_start - Vector2(0, 8 * 28)
	viewport.push_input(finger, true)
	var release := InputEventMouseButton.new()
	release.button_index = MOUSE_BUTTON_LEFT
	release.position = scroll_start - Vector2(0, 8 * 28)
	release.device = -1
	viewport.push_input(release, true)
	await settle()
	check(game.catalog_panel.visible and game.tool_kind == "select", "dragging a card does not select or place it")
	check(game.catalog_scroll.scroll_vertical > 0, "finger drag scrolls attraction library")
	Input.emulate_touch_from_mouse = false
	var all_count: int = game.catalog_row.get_child_count()
	game.catalog_filter.button_pressed = true
	await settle()
	check(game.catalog_row.get_child_count() < all_count, "available filter hides locked objects")
	game.catalog_filter.button_pressed = false
	game.show_catalog("paths")
	await settle()
	var first_card: Button = game.catalog_row.get_child(0)
	var card_point := first_card.get_global_rect().get_center()
	for down in [true, false]:
		var mouse := InputEventMouseButton.new()
		mouse.button_index = MOUSE_BUTTON_LEFT
		mouse.position = card_point
		mouse.pressed = down
		mouse.device = -1
		viewport.push_input(mouse, true)
	await settle()
	check(game.tool_kind == "path" and game.tool_id == 0 and not game.catalog_panel.visible, "whole card touch chooses item and closes library")
	check(game.view.input_enabled and not game.sheet_shade.visible, "choosing item restores park input")
	var entrance := Vector2i(game.sim.state.entrance[0], game.sim.state.entrance[1])
	game._cell_selected(entrance + Vector2i(0, 1))
	check(game.sim.state.paths.has(game.sim._key(entrance + Vector2i(0, 1))), "UI path placement reaches simulation")
	game.show_catalog("services")
	check(game.catalog_row.get_child_count() == 7, "services group rotations and include cafe")
	game.show_catalog("decor")
	check(game.catalog_row.get_child_count() == 7, "decor groups variants and includes bench")
	game._choose_build("prop", 0)
	for expected_type in [1, 2, 3, 0]:
		game._rotate_build()
		check(game.tool_id == expected_type and game.view.preview_type == expected_type, "prop rotates original variant cycle")
	var preview_cash: int = game.sim.state.money
	var preview_count: int = game.sim.state.buildings.size()
	game._cell_selected(Vector2i(9,9))
	check(game.sim.state.money == preview_cash and game.sim.state.buildings.size() == preview_count, "object preview does not spend money")
	await settle()
	check(game.placement_panel.size.y < viewport.size.y * 0.25, "choosing a cell keeps placement compact: %s" % game.placement_panel.size)
	game._cell_selected(Vector2i(9,9), true)
	check(game.sim.state.buildings.size() == preview_count + 1, "confirm builds the previewed object")
	check(game.tool_kind == "prop" and game.build_cell.x < 0 and game.placement_panel.visible, "repeat build keeps item and resets placement")
	await settle()
	check(game.placement_panel.size.y < viewport.size.y * 0.25 and not game.bottom.visible, "placement leaves the park visible: %s nav %s" % [game.placement_panel.size, game.bottom.visible])
	await capture("placement")
	game._go_back()
	check(game.tool_kind == "select" and not game.catalog_panel.visible, "Back cancels tool before menu")
	game._go_back()
	check(game.page == "pause", "Back pauses park")
	var tick: int = game.sim.state.tick
	game._process(2.0)
	check(game.sim.state.tick == tick, "menu freezes simulation")
	game.resume_game()
	game._notification(Control.NOTIFICATION_APPLICATION_PAUSED)
	game._process(2.0)
	check(game.suspended and game.sim.state.tick == tick and game.sound.suspended, "suspension freezes simulation and audio")
	game._notification(Control.NOTIFICATION_APPLICATION_RESUMED)
	game._process(0.2)
	check(not game.suspended and game.sim.state.tick > tick, "resume advances game")
	game.settings.quality = "original"
	game._apply_settings()
	check(game.view.quality == "original" and viewport.msaa_2d == Viewport.MSAA_DISABLED, "original changes renderer")
	var before := JSON.stringify(game.sim.snapshot())
	game.settings.quality = "remake_maximum"
	game._apply_settings()
	var expected_msaa := Viewport.MSAA_DISABLED if RenderingServer.get_current_rendering_method() == "gl_compatibility" else Viewport.MSAA_4X
	check(viewport.msaa_2d == expected_msaa, "remake maximum uses supported antialiasing")
	check(before == JSON.stringify(game.sim.snapshot()), "quality preserves progress")
	# Drive a small park through the real construction API, then render all UI panels.
	for x in range(1, 7):
		game.sim.build("path", 0, Vector2i(x, 2))
	game.sim.build("path", 0, Vector2i(6, 1))
	check(game.sim.build("ride", 6, Vector2i(1, 3)), "starter swings built")
	game.sim.build("ride", 8, Vector2i(5, 3))
	game.sim.build("prop", 19, Vector2i(4, 1))
	game.sim.build("prop", 15, Vector2i(5, 1))
	game.sim.hire(3)
	game.sim.advance(10)
	game._refresh_hud()
	game.view.center_park()
	game.view.queue_redraw()
	await capture("park")
	for layout in [Vector2i(1080, 1920), Vector2i(1080, 2400), Vector2i(1080, 2520)]:
		var width: int = layout.y
		viewport.size = layout
		await settle()
		for category in ["paths", "rides", "services", "decor"]:
			game.show_catalog(category)
			await settle()
			check(Rect2(Vector2.ZERO, viewport.size).encloses(game.catalog_panel.get_rect()), "catalog fits " + category)
		for name in ["show_staff", "show_stats", "show_goals"]:
			game.call(name)
			await settle()
			check(Rect2(Vector2.ZERO, viewport.size).encloses(game.inspector.get_rect()), "management sheet fits viewport")
			check(game.inspector_tabs.visible == (name != "show_staff"), "management tabs follow panel")
		game.show_catalog("rides")
		await capture("%d_catalog" % width)
	for method in ["show_staff","show_stats","show_goals"]:
		game._toolbar("demolish")
		game.call(method)
		check(game.tool_kind == "select" and game.view.preview_kind.is_empty(), "panel cancels destructive tool: " + method)
	game._toolbar("demolish")
	game.show_catalog("rides")
	check(game.tool_kind == "select", "catalog cancels demolition before selection")
	for attempt in 100: game.sim._spawn_guest()
	check(not game.sim.state.visitors.is_empty(), "populated park for visitor UI")
	game._clear_selection()
	game._cell_selected(entrance)
	check(game.selected_guest >= 0 and game.inspector.visible, "tap on visitor opens their needs")
	if game.selected_guest >= 0:
		var guest: Dictionary = game.sim._visitor(game.selected_guest)
		guest.cash = maxi(0,int(guest.cash)-1)
		game._refresh_hud()
		check(game.guest_state_label.text.contains("%d монет" % guest.cash), "visitor card updates live values")
	viewport.size = Vector2i(1080, 1920)
	await settle()
	game.show_staff()
	await capture("staff")
	game.show_stats()
	await capture("statistics")
	game.show_goals()
	await capture("goals")
	await settle()
	check(Rect2(Vector2.ZERO, viewport.size).encloses(game.inspector.get_rect()), "goals sheet after content shrinks stays within viewport")
	game._clear_selection()
	# Real file roundtrip and recovery after truncated primary save.
	game.persistence_enabled = true
	check(game.save_game(), "write real test save")
	var saved_money: int = game.sim.state.money
	check(game.save_game(), "second save creates backup")
	var file := FileAccess.open(test_save, FileAccess.WRITE)
	file.store_string("{truncated")
	file.close()
	game.running = false
	game.load_game()
	check(game.running and game.sim.state.money == saved_money, "backup recovers truncated primary")
	check(game.save_game(), "save after backup recovery")
	var corrupt := FileAccess.open(test_save, FileAccess.WRITE)
	corrupt.store_string('{"format":"prehistorik-park","game":{"bad":true}}')
	corrupt.close()
	game.running = false
	game.load_game()
	check(game.running and game.sim.state.money == saved_money, "backup remains valid after recovery and another corrupt save")
	game.persistence_enabled = false
	var bad_settings := FileAccess.open(test_settings, FileAccess.WRITE)
	bad_settings.store_string('{"settings":[1,2,3]}')
	bad_settings.close()
	check(game.Store.settings(test_settings).quality == "original_upscaled", "invalid settings shape returns defaults")
	game.sound.shutdown()
	await create_timer(0.3).timeout
	game.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	for path in [test_save, test_save + ".bak", test_save + ".tmp", test_save + ".corrupt", test_settings, test_settings + ".bak"]:
		if FileAccess.file_exists(path): DirAccess.remove_absolute(path)
	print("INTERFACE OK: %d checks" % checks if failures == 0 else "INTERFACE FAILED: %d/%d" % [failures, checks])
	quit(1 if failures else 0)
