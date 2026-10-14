extends SceneTree
## Regression journeys from the player's first three attractions.
const Sim = preload("res://scripts/park_sim.gd")
const Layers = preload("res://scripts/park_layers.gd")
var checks := 0
var failures := 0
var output := ""
var viewport: SubViewport
var game

func _initialize() -> void: run.call_deferred()
func check(ok: bool, message: String) -> void:
	checks += 1
	if not ok:
		failures += 1
		printerr("FAIL gameplay: " + message)
func settle() -> void:
	for frame in 6: await process_frame
func capture(name: String) -> void:
	if output.is_empty(): return
	await settle()
	await RenderingServer.frame_post_draw
	check(viewport.get_texture().get_image().save_png(output.path_join(name + ".png")) == OK, "capture " + name)
func find_button(node: Node, label: String) -> Button:
	if node is Button and node.text == label: return node
	for child in node.get_children():
		var found := find_button(child, label)
		if found != null: return found
	return null
func road(sim, cell: Vector2i) -> void:
	if sim.state.paths.has(sim._key(cell)): return
	check(sim.build("path", 0, cell), "road " + str(cell))
func fixture(sim) -> void:
	sim.new_game(-1, 0, 55)
	for y in range(1,16): road(sim, Vector2i(15,y))
	for x in range(1,20): road(sim, Vector2i(x,2))
	check(sim.build("ride", 6, Vector2i(1,3)), "swings fixture")
func guest(sim, at: Vector2i) -> Dictionary:
	var count: int = sim.state.visitors.size()
	while sim.state.visitors.size() == count: sim._spawn_guest()
	var v: Dictionary = sim.state.visitors.back()
	v.x = float(at.x); v.y = float(at.y)
	v.needs = [90,0,0,0,0,90,0]
	v.speed = 2.0
	return v
func check_staff(sim) -> void:
	check(sim.build("prop", 15, Vector2i(14,1)), "snack stall")
	check(sim.build("prop", 17, Vector2i(14,3)), "ice cream stall")
	var food: Dictionary = sim.building_at(Vector2i(14,1))
	var ice: Dictionary = sim.building_at(Vector2i(14,3))
	var cash := int(sim.state.money)
	check(not sim.hire(2,Vector2i(14,1)) and "кафе" in sim.last_error, "cook explains correct workplace")
	check(sim.state.money == cash and sim.state.workers.is_empty(), "invalid job never charges or hires")
	check(sim.hire(3,Vector2i(14,1)), "seller placed at snack stall")
	var first := int(sim.state.workers.back().uid)
	check(sim.hire(3,Vector2i(14,3)), "seller placed at ice cream stall")
	var second := int(sim.state.workers.back().uid)
	check(food.working and ice.working and food.worker_uid == first and ice.worker_uid == second, "second hire preserves first; both stalls work")
	cash = int(sim.state.money)
	check(not sim.hire(3,Vector2i(14,3)) and "уже работает" in sim.last_error, "occupied workplace cannot swallow another worker")
	check(sim.state.money == cash and sim.state.workers.size() == 2, "duplicate hire is free and leaves team unchanged")
	check(sim.set_open(int(food.uid),false), "close first stall")
	sim._refresh_working()
	check(food.worker_uid == first and ice.worker_uid == second, "closing retains both individual assignments")
	check(sim.set_open(int(food.uid),true) and food.working, "reopening retains seller")
	check(sim.demolish(Vector2i(15,3)), "remove ice cream access")
	check(not ice.working and ice.staffed and "дорожку" in ice.reason, "seller stays; missing road is explained")
	road(sim,Vector2i(15,3))
	check(ice.working and ice.worker_uid == second, "restoring road opens ice cream with same seller")
	var customer := guest(sim,Vector2i(15,3))
	customer.needs[2] = 90
	customer.target_uid = ice.uid
	var income := int(ice.income)
	sim._arrive(customer)
	check(customer.state == "eating" and ice.income > income, "ice cream serves and earns money")
	sim._finish_service(customer)
	check(customer.needs[2] < 90 and ice.occupants.is_empty(), "ice cream reduces hunger and frees counter")
	check(sim.build("prop",15,Vector2i(14,5)), "new workplace")
	var next: Dictionary = sim.building_at(Vector2i(14,5))
	check(sim.assign_worker(first,Vector2i(14,5)), "manual reassignment")
	check(not food.staffed and next.worker_uid == first and ice.worker_uid == second, "only chosen worker moves")
	check(sim.hire(0,Vector2i(15,6)), "guard placed on chosen path")
	var guard := int(sim.state.workers.back().uid)
	check(sim.assign_worker(guard,Vector2i(15,9)) and sim.worker_by_id(guard).y == 9, "patrol can be moved")
	check(not sim.assign_worker(guard,Vector2i(0,29)), "guard cannot be stranded off paths")
	check(sim.build("ride",23,Vector2i(18,3)), "first cafe")
	for x in range(16,20): road(sim,Vector2i(x,7))
	check(sim.build("ride",23,Vector2i(18,8)), "second cafe")
	check(sim.hire(2,Vector2i(18,3)), "first cook")
	var cook := int(sim.state.workers.back().uid)
	check(sim.hire(2,Vector2i(18,8)), "second cook")
	check(sim.building_at(Vector2i(18,3)).worker_uid == cook and sim.state.staff[2] == 2, "second cook never replaces or removes first")
	check(sim.building_at(Vector2i(18,3)).working and sim.building_at(Vector2i(18,8)).working, "two cooks run two cafes")
	cash = int(sim.state.money)
	check(sim.rotate_service(next.uid) and not next.working and next.worker_uid == first, "turning stall preserves its worker")
	check(sim.rotate_service(next.uid) and next.working and sim.state.money == cash, "turning back restores service without demolition or cost")
	var restored = Sim.new()
	check(restored.restore(JSON.parse_string(JSON.stringify(sim.snapshot()))), "new assignments survive JSON save")
	check(restored.building_by_id(ice.uid).worker_uid == second and restored.building_by_id(next.uid).worker_uid == first, "save keeps exact employee identities")
	var legacy: Dictionary = sim.snapshot()
	for worker in legacy.workers: worker.erase("assignment_uid")
	check(restored.restore(legacy) and restored.building_by_id(ice.uid).worker_uid == second, "legacy save preserves previous target as workplace")
	var bad: Dictionary = sim.snapshot()
	bad.workers[0].assignment_uid = "broken"
	check(not restored.restore(bad), "malformed assignment rejected")
	check(sim.fire_worker(first) and sim.worker_by_id(first).is_empty(), "dismiss exact selected person")
	check(ice.worker_uid == second and ice.working and sim.state.staff[3] == 1, "dismissing colleague does not touch ice cream seller")

func check_queues(sim) -> void:
	fixture(sim)
	var ride: Dictionary = sim.state.buildings[0]
	var cells: Array = sim.queue_cells(ride)
	check(cells.size() == 10, "connected road provides ten queue slots")
	var used := {}
	for cell in cells:
		check(sim._reachable.has(sim._key(cell)) and not used.has(cell), "queue slots are distinct and connected")
		used[cell] = true
	for index in 7:
		var v := guest(sim,cells[index])
		v.target_uid = ride.uid
		sim._arrive(v)
		check(v.state == "queue", "guest joins at physical tail")
	check(ride.queue.size() == 7, "seven ordered waiting guests")
	var joiner := guest(sim,cells[0])
	joiner.target_uid = ride.uid
	sim._arrive(joiner)
	check(joiner.state == "walking" and not joiner.route.is_empty() and ride.queue.size() == 7, "late arrival walks to tail instead of piling up at entrance")
	var expected: Array = ride.queue.slice(0,int(sim.ride_catalog[6].capacity))
	sim._tick_rides()
	check(ride.occupants == expected, "boarding remains FIFO")
	for tick in 100:
		for uid in ride.queue.duplicate(): sim._tick_guest(sim._visitor(uid))
	for index in ride.queue.size():
		var v: Dictionary = sim._visitor(ride.queue[index])
		check(Vector2(v.x,v.y).distance_to(Vector2(cells[index])) < 0.001, "remaining queue walks forward into separate slots")
	var copy = Sim.new()
	check(copy.restore(JSON.parse_string(JSON.stringify(sim.snapshot()))), "occupied park with queue restores")
	for tick in 30:
		sim.advance(0.1); copy.advance(0.1)
	var left: String = JSON.stringify(sim._normalize_json_numbers(sim.snapshot()),"  ")
	var right: String = JSON.stringify(sim._normalize_json_numbers(copy.snapshot()),"  ")
	if left != right:
		FileAccess.open("/tmp/queue_before.json",FileAccess.WRITE).store_string(left)
		FileAccess.open("/tmp/queue_after.json",FileAccess.WRITE).store_string(right)
	check(left == right, "queue save/resume is deterministic")
	sim.set_open(ride.uid,false)
	for uid in ride.queue.duplicate(): sim._tick_guest(sim._visitor(uid))
	check(ride.queue.is_empty(), "closing attraction releases the whole line")

func check_adjacent_queues(sim) -> void:
	fixture(sim)
	check(sim.build("ride",14,Vector2i(5,3)), "adjacent seesaw")
	check(sim.build("ride",11,Vector2i(10,3)), "third attraction")
	var claimed := {}
	for b in sim.state.buildings:
		var line: Array = sim.queue_cells(b)
		check(line.size() >= 2, "each of three attractions has usable queue space")
		for cell in line:
			check(not claimed.has(cell), "adjacent attractions never share a queue position")
			claimed[cell] = b.uid

func check_benches(sim) -> void:
	fixture(sim)
	check(sim.build("path",2,Vector2i(10,2)), "place bench on road")
	var seated: Array = []
	for index in 3:
		var v := guest(sim,Vector2i(11+index,2))
		v.needs[1] = 75
		sim._choose_destination(v)
		if index < 2:
			check(v.has("bench_cell") and v.bench_slot == index, "reserve one of two seats before walking")
			seated.append(v)
		else: check(not v.has("bench_cell"), "third guest cannot share occupied bench")
	for tick in 17:
		for v in seated: sim._tick_guest(v)
	for v in seated: check(v.state == "resting", "walk to bench and sit down")
	check(seated[0].bench_slot != seated[1].bench_slot, "resting people use different seat anchors")
	var copy = Sim.new()
	check(copy.restore(sim.snapshot()), "two seated guests restore")
	for v in seated: sim._finish_service(v)
	for v in seated: check(v.needs[1] <= 27 and not v.has("bench_cell"), "rest removes fatigue and releases seat")
	for v in sim.state.visitors: v.x = 15.0; v.y = 2.0; v.route = []; v.target_uid = -1
	var walker: Dictionary = sim.state.visitors[0]
	walker.needs[1] = 75
	sim._choose_destination(walker)
	check(sim.demolish(Vector2i(10,2)), "unoccupied reserved bench can be removed")
	sim._tick_guest(walker)
	check(not walker.has("bench_cell") and walker.state != "resting", "removed destination cannot leave someone sitting in air")

func run() -> void:
	for arg in OS.get_cmdline_user_args():
		if arg.begins_with("--screenshots="): output = arg.trim_prefix("--screenshots=")
	if not output.is_empty(): DirAccess.make_dir_recursive_absolute(output)
	var sim = Sim.new()
	fixture(sim); check_staff(sim)
	check_queues(sim)
	check_adjacent_queues(sim)
	check_benches(sim)
	viewport = SubViewport.new()
	viewport.size = Vector2i(1080,1920)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	game = load("res://main.tscn").instantiate()
	game.persistence_enabled = false
	game.settings_path = "user://gameplay_test_%d.json" % OS.get_process_id()
	viewport.add_child(game)
	game.set_process(false)
	await settle()
	game.new_game(-1,0,55)
	fixture(game.sim)
	game.settings.quality = "remake_maximum"
	game._apply_settings()
	game._choose_build("prop",17)
	game._cell_selected(Vector2i(14,3))
	var before := JSON.stringify(game.sim.snapshot())
	game._nudge_build(Vector2i(0,1))
	check(game.build_cell == Vector2i(14,4), "arrow moves preview exactly one cell")
	game._nudge_build(Vector2i(0,-1))
	check(JSON.stringify(game.sim.snapshot()) == before, "moving preview spends nothing")
	await settle()
	check(Rect2(Vector2.ZERO,viewport.size).encloses(game.placement_panel.get_rect()), "placement panel with arrows fits screen")
	check(game.placement_panel.size.y < 480, "precision controls leave three quarters of park visible")
	# A distant preview must land between the settled controls and placement
	# panel. Rebuilding wrapped labels used to collapse this area to 100px.
	game.view.pan = Vector2(9999,-9999)
	game._nudge_build(Vector2i.ZERO)
	await settle()
	var aim: Vector2 = game.view.cell_to_screen(Vector2(game.build_cell))
	check(aim.y > game.zoom_controls.position.y + game.zoom_controls.size.y + 28 and aim.y < game.placement_panel.position.y - 36,"arrow keeps selected cell below HUD and above settled placement panel")
	var camera: Vector2 = game.view.pan
	game._nudge_build(Vector2i(0,1))
	await settle()
	check(game.view.pan == camera,"nearby arrow step never jumps an already visible camera")
	await capture("arrow_camera")
	game._nudge_build(Vector2i(0,-1))
	await settle()
	check(game.sim.placement_warning("ride",6,Vector2i(6,10)).contains("Вход и выход"),"disconnected ride explains both missing paths")
	check(game.sim.placement_warning("ride",6,Vector2i(1,3)).is_empty(),"connected entrance and exit have no false warning")
	check(game.sim.placement_warning("prop",0,Vector2i(6,10)).is_empty(),"decorative trees do not request roads")
	game._choose_build("ride",6)
	game._cell_selected(Vector2i(6,10))
	await settle()
	check(not find_button(game.placement_panel,"Построить").disabled,"missing roads warn without preventing construction")
	check(game.placement_body.get_child(2).text.contains("не соединены с дорожкой"),"placement hint displays the road warning")
	await capture("missing_access_warning")
	game._choose_build("prop",17)
	game._cell_selected(Vector2i(14,3))
	game.message_time = 0
	game._refresh_hud()
	game.view.focus_cell(Vector2(14,3),5.0)
	await capture("construction_arrows")
	game._cell_selected(game.build_cell,true)
	game._clear_selection()
	game._cell_selected(Vector2i(14,3))
	check(find_button(game.inspector,"Нанять сюда · 7 монет") != null, "stall offers correct profession directly")
	game._choose_staff(3,-1,Vector2i(14,3))
	check(game.sim.state.workers.is_empty(), "choosing hire waits for workplace confirmation")
	await capture("choose_workplace")
	game._clear_selection()
	check(game.sim.state.workers.is_empty(), "cancel hire adds no invisible staff")
	game._choose_staff(3,-1,Vector2i(14,3))
	game._cell_selected(Vector2i(14,3),true)
	check(game.sim.state.workers.size() == 1 and game.sim.building_at(Vector2i(14,3)).working, "confirm hire opens selected ice cream stall")
	await capture("ice_cream_working")
	game.show_staff()
	check(find_button(game.inspector,"Переназначить") != null, "individual employee can be reassigned")
	await capture("staff_workplaces")
	find_button(game.inspector,"Нанять сотрудника").pressed.emit()
	await settle()
	check(find_button(game.inspector,"Нанять") != null and find_button(game.inspector,"Переназначить") == null, "hire tab is reachable without scrolling through entire team")
	find_button(game.inspector,"Команда · 1 / 22").pressed.emit()
	await settle()
	check(find_button(game.inspector,"Переназначить") != null, "team tab returns individual assignments")
	for index in 10: game.sim.hire(0,Vector2i(15,6))
	game.show_staff()
	await settle()
	Input.emulate_touch_from_mouse = true
	var drag_start: Vector2 = game.inspector_body.get_child(1).get_global_rect().position+Vector2(160,55)
	var finger := InputEventScreenTouch.new()
	finger.index = 0; finger.position = drag_start; finger.pressed = true
	viewport.push_input(finger,true)
	var press := InputEventMouseButton.new()
	press.button_index = MOUSE_BUTTON_LEFT; press.position = drag_start; press.pressed = true; press.device = -1
	viewport.push_input(press,true)
	for step in range(1,9):
		var drag := InputEventScreenDrag.new()
		drag.index = 0; drag.position = drag_start-Vector2(0,step*28); drag.relative = Vector2(0,-28)
		viewport.push_input(drag,true)
		var motion := InputEventMouseMotion.new()
		motion.position = drag.position; motion.relative = drag.relative; motion.button_mask = MOUSE_BUTTON_MASK_LEFT; motion.device = -1
		viewport.push_input(motion,true)
		await process_frame
	finger = InputEventScreenTouch.new()
	finger.index = 0; finger.position = drag_start-Vector2(0,224)
	viewport.push_input(finger,true)
	var release := InputEventMouseButton.new()
	release.button_index = MOUSE_BUTTON_LEFT; release.position = finger.position; release.device = -1
	viewport.push_input(release,true)
	await settle()
	check(game.inspector_scroll.scroll_vertical > 0,"finger drag on employee card scrolls the team")
	check(game.sim.state.workers.size() == 11,"dragging an employee card never fires or moves its worker")
	Input.emulate_touch_from_mouse = false
	game.inspector_scroll.scroll_vertical = 1800
	await settle()
	var hire_tab := find_button(game.inspector,"Нанять сотрудника")
	check(game.inspector_scroll.scroll_vertical > 0 and hire_tab.get_global_rect().position.y < game.inspector_scroll.get_global_rect().position.y,"hire tab stays above a scrolled full roster")
	await capture("staff_scrolled")
	hire_tab.pressed.emit()
	await settle()
	check(game.inspector_scroll.scroll_vertical == 0,"switching staff tab starts at first profession")
	for worker in game.sim.state.workers.duplicate():
		if int(worker.type) == 0: game.sim.fire_worker(worker.uid)
	game._clear_selection()
	# Deterministic visual fixture: seven people in line, two riders, two resting.
	var ride: Dictionary = game.sim.state.buildings[0]
	var cells: Array = game.sim.queue_cells(ride)
	for index in 9:
		var v := guest(game.sim,cells[mini(index,9)])
		v.target_uid = ride.uid
		if index < 2:
			v.state = "riding"; ride.occupants.append(v.uid)
		else:
			v.x = cells[index-2].x; v.y = cells[index-2].y
			game.sim._arrive(v)
	ride.phase = 3; ride.phase_t = 0.0
	game.sim.build("path",2,Vector2i(11,2))
	for index in 2:
		var v := guest(game.sim,Vector2i(11,2))
		v.needs[1] = 75
		game.sim._choose_destination(v)
	game._refresh_hud()
	game.view.focus_cell(Vector2(6,3),4.2)
	await capture("queue_and_benches")
	check(game.sim.build("prop",4,Vector2i(8,1)), "palm next to queue")
	var palm: Dictionary = game.sim.building_at(Vector2i(8,1))
	var person: Dictionary = game.sim._visitor(7)
	game.view._prepare_canopy_targets([{"kind":"visitor","data":person,"depth":float(person.x-person.y)}])
	check(game.view.canopy_opacity(palm,7.0) < 0.5, "foreground palm reveals queue behind it")
	game.view.transparent_trees = false
	check(game.view.canopy_opacity(palm,7.0) == 1.0, "canopy option restores opaque artwork")
	await capture("trees_opaque")
	game.view.transparent_trees = true
	await capture("trees_transparent")
	game.view.focus_cell(Vector2(11,2),8.0)
	await capture("bench_seats")
	for mode in ["original","remake_maximum"]:
		game.settings.quality = mode; game._apply_settings()
		game.view.focus_cell(Vector2(2,4),8.0)
		for phase in int(game.sim.ride_catalog[6].header.at):
			ride.phase_t = phase * 0.1
			var poses: Array = Layers.passenger_poses(game.view,ride)
			# cO: type10 cell (1,1) + initial passenger offset (0,1).
			# Local base is therefore iso(1,2)=(60,-10), before per-seat offsets.
			for pose in poses:
				var seat: int = ride.occupants.find(pose.uid)
				var s: Array = game.sim.ride_catalog[6].sections
				var expected: Vector2 = game.view.iso(Vector2(ride.x,ride.y)) + Vector2(60,-10) + Vector2(s[21][phase*2+seat],s[22][phase*2+seat])
				check(pose.at == expected, "swings rider follows actual chair in phase %d" % phase)
			await capture("swings_%s_%02d" % [mode,phase])
	game.sound.shutdown()
	await create_timer(0.3).timeout
	game.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	print("GAMEPLAY %s: %d checks" % ["OK" if failures == 0 else "FAILED",checks])
	quit(0 if failures == 0 else 1)
