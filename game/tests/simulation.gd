extends SceneTree

const Sim = preload("res://scripts/park_sim.gd")
var checks := 0
var failures: Array[String] = []


func _init() -> void:
	call_deferred("_run")


func expect(condition: bool, message: String) -> void:
	checks += 1
	if not condition:
		failures.append(message)
		push_error(message)


func road(sim, cell: Vector2i, type: int = 0) -> void:
	if int(sim.state.paths.get(sim._key(cell), -1)) != type:
		expect(sim.build("path", type, cell), "Road %s: %s" % [cell, sim.last_error])


func starter(sim) -> int:
	# Original rotation0 ride entrance=(x+w-1,y-1), exit=(x,y-1).
	for x in range(1, int(sim.state.size) / 2 + 1):
		road(sim, Vector2i(x, 2))
	for y in range(1, 3):
		road(sim, Vector2i(int(sim.state.size) / 2, y))
	expect(sim.build("ride", 6, Vector2i(1, 3)), "Build swings")
	return int(sim.state.buildings.back().uid)


func _run() -> void:
	var sim = Sim.new()
	expect(sim.ride_catalog.size() == 24, "24 exact ride records")
	expect(sim.scenery_catalog.size() == 27, "27 exact prop records")
	expect(sim.scenarios.size() == 6, "6 exact scenarios")
	expect(sim.ride_catalog[6].cost == 30, "Swings cost is header az*10")
	expect(sim.ride_catalog[19].name == "мегагорки", "Original unusual ride order")
	expect(sim.staff_catalog.map(func(role): return int(role.salary)) == [10, 10, 12, 7, 12, 9], "Exact six salaries")
	for scenario in range(6):
		for difficulty in range(2):
			sim.new_game(scenario, difficulty, 100 + scenario)
			expect(sim.state.size == sim.scenarios[scenario].size, "Scenario size")
			expect(sim.state.money == sim.scenarios[scenario].starting_money[difficulty], "Scenario starting cash")
			for id in range(24):
				expect(sim.availability("ride", id) == (id in sim.scenarios[scenario].initial_rides), "Scenario ride availability")
			expect(sim.goals().money.target == sim.scenarios[scenario].targets[difficulty][0], "Scenario goal")
	sim.new_game(2, 0, 100)
	expect(not sim.start_research(17, "prop") and "5" in sim.last_error, "Research hint identifies scheduled prop month")
	expect(not sim.start_research(17, "ride") and "не открывается" in sim.last_error, "Research hint never borrows month from same-ID other category")
	sim.new_game(-1, 0, 44)
	expect(sim.state.money == 700 and sim.state.size == 30, "Sandbox original defaults")
	expect(not sim.demolish(sim._entrance()), "Entrance cannot be demolished")
	expect(not sim.build("ride", 6, Vector2i(-1, 0)), "Negative footprint rejected")
	expect(not sim.build("ride", 19, Vector2i(28, 29)), "Outside footprint rejected")
	var cash_before := int(sim.state.money)
	expect(not sim.build("ride", 999, Vector2i(0, 0)), "Unknown catalog rejected")
	expect(sim.state.money == cash_before, "Failed build does not charge")
	var uid := starter(sim)
	var ride: Dictionary = sim.building_by_id(uid)
	expect(ride.working, "Both original ports connected to entrance graph")
	expect(not sim.build("prop", 19, Vector2i(2, 4)), "Occupied ride cell protected")
	expect(not sim.build("path", 0, Vector2i(2, 4)), "Road cannot cross attraction")
	expect(sim.can_build("prop", 0, Vector2i(2, 3)).is_empty(), "Original footprint hole remains buildable")
	expect(sim.set_price(uid, 4), "Change ride price")
	expect(not sim.set_price(uid, -1) and not sim.set_price(uid, 11), "Price range validated")
	expect(sim.set_price(uid, 1), "Reset original fair price")
	expect(sim.set_open(uid, false) and not ride.working, "Closing immediately stops new service")
	expect(sim.set_open(uid, true) and ride.working, "Reopen connected ride")
	# Broken connection suppresses operation; rebuilding restores it.
	expect(sim.demolish(Vector2i(1, 2)), "Remove unused exit road")
	expect(not ride.working, "Missing exit road blocks operation")
	road(sim, Vector2i(1, 2))
	expect(ride.working, "Restored exit road enables ride")
	# Rotation1 preserves footprint dimensions and uses east-facing ports.
	expect(sim.build("ride", 6, Vector2i(19, 3), 1), "Rotated attraction")
	var rotated: Dictionary = sim.state.buildings.back()
	for x in range(15, 23):
		road(sim, Vector2i(x, 2))
	for y in range(3, 6):
		road(sim, Vector2i(22, y))
	expect(rotated.working, "Rotated exact entry and exit ports")
	# Staffing is finite and monthly payroll is charged exactly once.
	expect(sim.build("prop", 15, Vector2i(14, 1)), "Food service next to path")
	var shop: Dictionary = sim.state.buildings.back()
	expect(not shop.working and not shop.staffed, "Unstaffed food service unavailable")
	var before_hire := int(sim.state.money)
	expect(sim.hire(3), "Hire seller")
	expect(sim.state.money == before_hire - 7 and shop.working, "Hiring costs first wage and activates service")
	expect(sim.build("prop", 15, Vector2i(14, 0)), "Second shop")
	expect(not sim.state.buildings.back().staffed, "One worker cannot serve two shops")
	var before_month := int(sim.state.money)
	sim._monthly()
	expect(sim.state.money == before_month - 7 and sim.state.month == 1, "Monthly wage")
	expect(sim.fire(3) and not shop.working, "Firing stops service")
	# Motor requirements and their coverage; mechanic repairs a broken ride.
	expect(sim.build("ride", 1, Vector2i(5, 3)), "Build powered tower")
	var tower: Dictionary = sim.state.buildings.back()
	expect(not tower.working and not tower.powered, "Tower needs dinosaur motor")
	expect(sim.build("prop", 26, Vector2i(6, 0)), "Motor covering tower")
	road(sim, Vector2i(8, 0))
	road(sim, Vector2i(8, 1))
	expect(sim.hire(5), "Hire dinosaur driver")
	expect(tower.powered and tower.working, "Staffed and connected motor powers covered attraction")
	tower.condition = 0
	sim._refresh_working()
	expect(not tower.working, "Critical wear blocks attraction")
	expect(sim.hire(1), "Hire repairman")
	sim.advance(40.0)
	expect(tower.condition >= 10, "Repairman reaches and repairs broken attraction")
	# Visitor AI must produce a reachable queue, ride, and actual revenue.
	sim.new_game(-1, 0, 8675309)
	uid = starter(sim)
	for index in range(80):
		sim._spawn_guest()
	expect(sim.state.visitors.size() > 0, "Guest spawning")
	for visitor in sim.state.visitors:
		visitor.x = 3.0
		visitor.y = 2.0
		visitor.route = []
		visitor.target_uid = uid
		visitor.needs = [90, 0, 0, 0, 0, 100, 0]
		visitor.cash = 79
	var visited := false
	for index in range(300):
		sim.advance(0.1)
		for visitor in sim.state.visitors:
			visited = visited or int(visitor.rides) > 0
	expect(visited and int(sim.state.income) > 0, "Full visitor pay/queue/ride/exit lifecycle")
	for visitor in sim.state.visitors:
		expect(int(visitor.cash) >= 0, "Visitor cannot spend below zero")
		expect(float(visitor.x) >= 0 and float(visitor.y) >= 0 and float(visitor.x) < sim.state.size and float(visitor.y) < sim.state.size, "Visitor within park bounds")
	# A tired guest must actually choose a bench while reachable rides are still open.
	var resting_sim = Sim.new()
	resting_sim.new_game(-1, 0, 823)
	starter(resting_sim)
	expect(resting_sim.build("path", 2, Vector2i(3, 2)), "Bench near available ride")
	for index in range(100):
		resting_sim._spawn_guest()
	var tired: Dictionary = resting_sim.state.visitors[0]
	tired.x = 3.0
	tired.y = 2.0
	tired.needs = [90, 75, 0, 0, 0, 100, 0]
	tired.target_uid = -1
	tired.route = []
	tired.need_ticks = 49
	resting_sim._choose_destination(tired)
	expect(tired.need_ticks == 0, "Starting a bench action resets original need clock")
	expect(tired.state == "resting", "Fatigue response takes precedence over another ride")
	resting_sim.advance(5.0)
	expect(int(tired.needs[1]) <= 30, "Bench removes fifty fatigue after original five seconds")
	# Original cU uses an action clock, resets on boarding, and freezes only seated rides.
	tired.age = 349
	tired.need_ticks = 0
	tired.needs = [90, 0, 0, 0, 0, 100, 0]
	tired.state = "walking"
	tired.cooldown = 100
	tired.route = []
	resting_sim._tick_guest(tired)
	expect(tired.need_ticks == 1 and tired.needs[5] == 100, "Health follows action clock rather than lifetime")
	tired.state = "riding"
	tired.target_uid = int(resting_sim.state.buildings[0].uid)
	resting_sim._tick_guest(tired)
	expect(tired.need_ticks == 1, "Seated ride freezes needs clock")
	tired.state = "eating"
	tired.timer = 50
	tired.need_ticks = 19
	resting_sim._tick_guest(tired)
	expect(tired.need_ticks == 20 and tired.needs[1] == 1, "Food action still advances original needs")
	tired.visited = []
	for type in [6, 11, 6, 10]:
		resting_sim._remember_ride(tired, type)
	expect(tired.visited == [10, 6], "Only two recent attraction types affect repeat preference")
	var beauty_sim = Sim.new()
	beauty_sim.new_game(-1, 0, 711)
	var beauty_cell := Vector2i(1, 1)
	var beauty_before: int = beauty_sim._beauty(beauty_cell)
	expect(beauty_sim.build("prop", 8, beauty_cell), "Plant a tree through public construction")
	var beauty_after: int = beauty_sim._beauty(beauty_cell)
	expect(beauty_after >= beauty_before and beauty_after == beauty_sim._beauty(beauty_cell), "Cached beauty agrees on repeated reads")
	expect(beauty_sim.demolish(beauty_cell), "Demolish tree for beauty invalidation")
	expect(beauty_sim._beauty(beauty_cell) < beauty_after, "Construction and demolition invalidate beauty cache")
	# Route caches cannot alias mutable visitor routes or survive map edits.
	var route_sim = Sim.new()
	route_sim.new_game(-1, 0, 192)
	expect(route_sim.build("path", 0, Vector2i(15, 1)) and route_sim.build("path", 0, Vector2i(15, 2)), "Prepare route cache fixture")
	var path: Array = route_sim._route(Vector2i(15, 0), Vector2i(15, 2))
	var expected_path: Array = path.duplicate(true)
	path[0][0] = 99
	path.pop_front()
	expect(route_sim._route(Vector2i(15, 0), Vector2i(15, 2)) == expected_path, "Cached routes are isolated from nested mutations")
	expect(route_sim.demolish(Vector2i(15, 1)), "Remove cached route's middle cell")
	expect(route_sim._route(Vector2i(15, 0), Vector2i(15, 2)).is_empty(), "Demolition invalidates successful route cache")
	expect(route_sim.build("path", 0, Vector2i(15, 1)), "Rebuild road after cached miss")
	expect(route_sim._route(Vector2i(15, 0), Vector2i(15, 2)) == expected_path, "Construction invalidates failed route cache")
	for index in range(Sim.ROUTE_CACHE_LIMIT + 2):
		route_sim._route(Vector2i(index + 40, -1), Vector2i(-1, -1))
	expect(route_sim._route_cache.size() == Sim.ROUTE_CACHE_LIMIT and route_sim._route_cache_order.size() == Sim.ROUTE_CACHE_LIMIT, "Route cache stays within fixed mobile memory bound")
	route_sim.new_game(-1, 0, 192)
	expect(route_sim._route_cache.is_empty() and route_sim._access_cache.is_empty(), "A new park cannot reuse old routing caches")
	# Deterministic restore and time-step partition invariance, including RNG.
	var encoded := JSON.stringify(sim.snapshot())
	var restored = Sim.new()
	expect(restored.restore(JSON.parse_string(encoded)), "JSON save roundtrip")
	sim.advance(15.0)
	for index in range(150):
		restored.advance(0.1)
	expect(JSON.parse_string(JSON.stringify(sim.state)) == JSON.parse_string(JSON.stringify(restored.state)), "Save/load preserves deterministic simulation")
	var before_reject := JSON.stringify(restored.snapshot())
	expect(not restored.restore({"version": 999}), "Reject unsupported save")
	expect(not restored.restore({"version": []}), "Malformed version rejected before migration")
	expect(JSON.stringify(restored.snapshot()) == before_reject, "Failed restore is atomic")
	var corrupt: Dictionary = JSON.parse_string(encoded)
	corrupt.visitors[0].erase("needs")
	expect(not restored.restore(corrupt), "Reject malformed guest")
	# Data-driven inventions and exact debt grace period.
	sim.new_game(1, 0, 10)
	expect(not sim.availability("ride", 5), "Research initially locked")
	sim._monthly()
	expect(not sim.availability("ride", 5), "Research remains locked before scheduled month")
	sim._monthly()
	expect(sim.availability("ride", 5), "Research unlocked exactly at original month2")
	expect(not sim.start_research(5), "Original automatic research cannot be purchased")
	sim.new_game(-1, 0, 10)
	sim.state.money = -51
	sim.advance(47.0 * 4.0)
	expect(sim.state.status == "playing", "47 debt days survive")
	sim.advance(4.0)
	expect(sim.state.status == "lost", "48 debt days bankrupt")
	sim.new_game(-1, 0, 10)
	sim.state.money = -51
	sim.advance(80.0)
	sim.state.money = 1
	sim.advance(4.0)
	expect(sim.state.debt_days == -1 and sim.state.status == "playing", "Positive cash clears bankruptcy countdown")
	# The original water ride is built in two gates and an editable, unbranched channel.
	sim.new_game(-1, 0, 55)
	for y in range(1, 5):
		road(sim, Vector2i(15, y))
	for x in range(5, 15):
		road(sim, Vector2i(x, 4))
	var water_cash := int(sim.state.money)
	expect(sim.build("ride", 22, Vector2i(5, 5)), "Water entrance gate")
	var water: Dictionary = sim.state.buildings.back()
	expect(int(sim.state.money) == water_cash - 35 and int(sim.state.water_build) == int(water.uid), "Water entrance charges half original price")
	expect(not water.working, "Incomplete water ride closed")
	var water_snapshot: Dictionary = JSON.parse_string(JSON.stringify(sim.snapshot()))
	expect(restored.restore(water_snapshot), "Pending water entrance survives JSON save")
	expect(sim.build("ride", 22, Vector2i(10, 5)), "Separate water exit gate")
	expect(int(sim.state.money) == water_cash - 70 and int(sim.state.water_build) == -1, "Both water gates charge exact total70")
	expect(not water.working, "Water ride needs continuous channel")
	for x in range(6, 10):
		road(sim, Vector2i(x, 6), 13)
	expect(water.working and water.water_route.size() == 6, "Continuous six-cell channel works")
	expect(not sim.build("path", 13, Vector2i(7, 7)), "Branching water channel prohibited")
	expect(sim.building_at(Vector2i(10, 5)).uid == water.uid, "Exit gate selects same water ride")
	for index in range(100):
		sim._spawn_guest()
	expect(not sim.state.visitors.is_empty(), "Water guest available")
	var rider: Dictionary = sim.state.visitors[0]
	rider.x = 5.0
	rider.y = 4.0
	rider.needs = [90, 0, 0, 0, 0, 100, 0]
	rider.target_uid = int(water.uid)
	rider.route = []
	sim._arrive(rider)
	expect(rider.state == "riding" and water.occupants.size() == 1, "Water ride boards guest immediately")
	expect(not sim.demolish(Vector2i(7, 6)), "Occupied water channel cannot be removed")
	sim.set_open(int(water.uid), false)
	sim.advance(35.0)
	expect(int(rider.rides) > 0 and water.occupants.is_empty(), "Water rider finishes safely after closing entrance")
	expect(sim.demolish(Vector2i(7, 6)), "Empty water channel can be reshaped")
	sim.set_open(int(water.uid), true)
	expect(not water.working, "Broken channel stops service")
	road(sim, Vector2i(7, 6), 13)
	expect(water.working, "Repaired channel restores service")
	expect(restored.restore(JSON.parse_string(JSON.stringify(sim.snapshot()))), "Complete water simulation save roundtrip")
	# Reject malformed payloads at every trusted boundary, without partial mutation.
	expect(sim.hire(0), "Worker for save validation")
	var valid: Dictionary = JSON.parse_string(JSON.stringify(sim.snapshot()))
	for key in ["month", "year", "day", "tick", "money", "prices", "workers", "messages", "paused", "research", "terrain", "rng_state", "remainder"]:
		var bad := valid.duplicate(true)
		bad.erase(key)
		expect(not restored.restore(bad), "Missing state field safely rejected: " + key)
	for key in ["uid", "type", "dir", "target_uid", "route", "anim", "state", "x", "y"]:
		var bad := valid.duplicate(true)
		bad.workers[0][key] = {"invalid": true}
		expect(not restored.restore(bad), "Malformed worker field safely rejected: " + key)
	for payload in [[[0]], [[-1, 2]], [["x", 2]], [null]]:
		var bad := valid.duplicate(true)
		bad.visitors[0].route = payload
		expect(not restored.restore(bad), "Malformed route safely rejected")
	var bad := valid.duplicate(true)
	bad.staff[0] = 22
	expect(not restored.restore(bad), "Staff counts must match worker records")
	expect(restored.restore(valid), "Valid staff save restored after failed payloads")
	# A rotated food card places prop16, but must satisfy the same tutorial
	# objective as prop15. Exercise public builds, including a rejected one.
	for snack_id in [15, 16]:
		sim.new_game(0, 0, 123)
		for index in range(13):
			sim.state.tutorial_flags[index] = 1
		sim._check_tutorial()
		expect(sim.tutorial_progress().step == 2, "Service tutorial starts after roads and rides")
		expect(sim.build("prop", 20, Vector2i(1, 1)), "Build unrelated toilet during food objective")
		expect(sim.state.tutorial_flags[13] == 0, "Other service does not count as food")
		expect(sim.build("prop", 19, Vector2i(2, 1)), "Build tutorial spring")
		expect(not sim.build("prop", snack_id, Vector2i(2, 1)), "Rejected food placement on occupied spring")
		expect(sim.state.tutorial_flags[13] == 0 and sim.tutorial_progress().step == 2, "Failed food build cannot advance tutorial")
		expect(sim.build("prop", snack_id, Vector2i(3, 1)), "Build tutorial food orientation %d" % snack_id)
		expect(sim.state.buildings.back().type == snack_id, "Tutorial credit preserves placed food orientation")
		expect(sim.state.tutorial_flags[13] == 1 and sim.tutorial_progress().step == 3, "Either food orientation completes service objective")
	# Campaign tutorial records original build actions instead of arbitrary visitor goals.
	sim.new_game(0, 0, 123)
	for index in range(10):
		sim._tutorial_action("path", 0)
	sim._check_tutorial()
	expect(sim.tutorial_progress().step == 1, "Tutorial ten dirt roads")
	for index in range(3):
		sim._tutorial_action("ride", 6)
	sim._check_tutorial()
	expect(sim.tutorial_progress().step == 2, "Tutorial three attractions")
	sim._tutorial_action("prop", 15)
	sim._tutorial_action("prop", 19)
	sim._tutorial_action("staff", 3)
	sim._tutorial_action("path", 2)
	sim._tutorial_action("path", 2)
	sim._tutorial_action("staff", 0)
	sim._check_tutorial()
	expect(sim.tutorial_progress().step == 6, "Tutorial original service, staff and bench tasks")
	sim.advance(31.9)
	expect(sim.state.status == "playing", "Tutorial observation delay")
	sim.advance(64.0)
	expect(sim.snapshot().remainder == 0.0, "Winning inside a large advance discards unused elapsed time")
	expect(restored.restore(JSON.parse_string(JSON.stringify(sim.snapshot()))), "Finished scenario snapshot restores")
	var old_terminal: Dictionary = sim.snapshot()
	old_terminal.remainder = 28.0
	expect(restored.restore(old_terminal) and restored.snapshot().remainder == 0.0, "Legacy terminal remainder is discarded safely")
	expect(sim.state.status == "won", "Tutorial wins after all nineteen original actions and observation")
	# Competition is a three-year streak, and uses last ten months as in original.
	sim.new_game(-2, 0, 7)
	for year in range(3):
		sim.state.month = year * 12 + 11
		sim.state.annual_ratings = []
		for month in range(10):
			sim.state.annual_ratings.append([10000, 0, 0, 0, 0])
		sim._monthly()
		expect(sim.state.competition_streak == year + 1, "Competition consecutive annual first places")
		expect(sim.state.annual_ratings.size() == 10, "Competition rolling ten-month average")
	expect(sim.state.status == "won", "Competition wins after three consecutive first years")
	# Debug is explicit and cannot earn victory.
	sim.new_game(5, 1, 1)
	sim.set_debug(true)
	expect(sim.availability("ride", 19) and sim.state.money == 100000, "Explicit debug unlocks")
	sim.state.rating = 10
	sim._check_victory()
	expect(sim.state.status == "playing", "Debug does not claim a scenario win")
	sim.new_game(0, 0, 1)
	sim.set_debug(true)
	sim.set_debug(false)
	sim.state.tutorial_step = 8
	sim._check_victory()
	expect(sim.state.status == "playing" and sim.state.debug_used, "Disabling debug cannot make gifted money eligible")
	expect(restored.restore(JSON.parse_string(JSON.stringify(sim.snapshot()))) and restored.state.debug_used, "Debug eligibility persists through save/load")
	restored._check_victory()
	expect(restored.state.status == "playing", "Restored former debug park cannot claim a win")
	var legacy: Dictionary = sim.snapshot()
	legacy.erase("debug_used")
	expect(restored.restore(legacy) and restored.state.debug_used, "Early development save loads conservatively as ineligible")
	sim.new_game(0, 0, 1)
	expect(not sim.state.debug_used, "Fresh park resets debug eligibility")
	if failures.is_empty():
		print("SIMULATION OK: %d checks" % checks)
		quit(0)
	else:
		print("SIMULATION FAILED: %d / %d" % [failures.size(), checks])
		quit(1)
