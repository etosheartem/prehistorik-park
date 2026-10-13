extends SceneTree
## Autonomous gameplay acceptance: only public build/hire/advance calls change park.
const Sim = preload("res://scripts/park_sim.gd")
var reports: Array = []
var failed := false

func _init() -> void:
	call_deferred("_run")

func _road(sim, cell: Vector2i, type: int = 0) -> bool:
	if sim.state.paths.has(sim._key(cell)):
		return true
	return sim.build("path", type, cell)

func _setup(sim) -> void:
	var size := int(sim.state.size)
	for y in range(1, 3):
		_road(sim, Vector2i(size / 2, y))
	for x in range(size):
		_road(sim, Vector2i(x, 2))
	for y in range(1, 8):
		_road(sim, Vector2i(size - 1, y))
	for pair in [[11, 0], [6, 3], [11, 6]]:
		sim.build("ride", pair[0], Vector2i(pair[1], 3))
	for pair in [[15, 1], [19, 3], [20, 5]]:
		sim.build("prop", pair[0], Vector2i(size - 2, pair[1]))
	sim.hire(3)
	sim.build("path", 2, Vector2i(size - 1, 4))
	sim.build("path", 2, Vector2i(size - 1, 6))
	for x in range(2, size - 2, 5):
		sim.build("path", 2, Vector2i(x, 2))
	if int(sim.state.scenario) == 0:
		sim.hire(0)

func _beautify(sim) -> void:
	# The last hard scenarios require a landscaped park, not only profitable rides.
	# Spend earned cash on original scenery and stone paths through public commands.
	var planted := 0
	var size := int(sim.state.size)
	for key in sim.state.paths.keys():
		if int(sim.state.paths[key]) in [0, 2]:
			sim.build("path", 4, sim._cell(key))
	for y in range(size):
		for x in range(size):
			var cell := Vector2i(x, y)
			if sim.can_build("prop", 8, cell).is_empty() and sim.build("prop", 8, cell):
				planted += 1
				if planted >= 20:
					return

func _expand(sim) -> void:
	if sim.state.status != "playing":
		return
	var cash := int(sim.state.money)
	var cash_target := int(sim.scenarios[int(sim.state.scenario)].targets[int(sim.state.difficulty)][0])
	# Once profitable, reinvest in guest mood through legitimate lower prices.
	if cash > cash_target + 500:
		for building in sim.state.buildings:
			if building.kind == "ride":
				sim.set_price(int(building.uid), maxi(0, int(sim.ride_catalog[int(building.type)].default_price) - 1))
			elif int(sim.scenery_catalog[int(building.type)].price_group) >= 0:
				var group := int(sim.scenery_catalog[int(building.type)].price_group)
				sim.set_price(int(building.uid), maxi(0, int(Sim.PRICE_DEFAULTS[group]) - 1))
	if cash > cash_target + 500 and sim._count("ride") >= 20:
		_beautify(sim)
	if cash < 100:
		return
	if int(sim.state.staff[1]) < maxi(1, ceili(float(sim._count("ride")) / 5.0)):
		sim.hire(1)
		return
	if int(sim.state.staff[0]) < sim.state.visitors.size() / 25 and cash > 200:
		sim.hire(0)
		return
	var size := int(sim.state.size)
	if sim._count("prop", 25) == 0 and sim.availability("prop", 25) and cash > 170:
		sim.build("prop", 25, Vector2i(size - 2, 7))
		sim.hire(4)
		return
	if sim._count("prop", 23) == 0 and sim.availability("prop", 23) and cash > 220:
		for y in range(8, 10):
			_road(sim, Vector2i(size - 1, y))
		sim.build("prop", 23, Vector2i(size - 2, 9))
		sim.hire(3)
		return
	# Add affordable nonpowered variety, then repeat the higher-capacity fear rooms.
	var types := [8, 10, 14, 7, 16, 5, 11]
	for id in types:
		var catalog: Dictionary = sim.ride_catalog[id]
		if not sim.availability("ride", id) or (id != 5 and sim._count("ride", id) > 0) or cash < int(catalog.cost) + 150:
			continue
		for row in range(3, size - 3, 5):
			for x in range(size - 3 - int(catalog.size[0]) + 1):
				var cell := Vector2i(x, row)
				if not sim.can_build("ride", id, cell).is_empty():
					continue
				for road_x in range(x, size):
					_road(sim, Vector2i(road_x, row - 1))
					if road_x % 5 == 2:
						sim.build("path", 2, Vector2i(road_x, row - 1))
				for road_y in range(2, row):
					_road(sim, Vector2i(size - 1, road_y))
				if sim.build("ride", id, cell):
					return

func _run() -> void:
	var max_months := 60
	var requested := OS.get_environment("PARK_ACCEPTANCE_MONTHS")
	if requested.is_valid_int():
		max_months = int(requested)
	var selected: Array = [0, 1, 2, 3, 4, 5]
	if not OS.get_environment("PARK_ACCEPTANCE_SCENARIOS").is_empty():
		selected = []
		for id in OS.get_environment("PARK_ACCEPTANCE_SCENARIOS").split(","):
			selected.append(int(id))
	var difficulty := int(OS.get_environment("PARK_ACCEPTANCE_DIFFICULTY"))
	for scenario in selected:
		var sim = Sim.new()
		sim.new_game(scenario, difficulty, 919 + scenario)
		_setup(sim)
		var peak_guests := 0
		var peak_mood := 0
		for month in range(max_months):
			if sim.state.status != "playing":
				break
			sim.advance(64.0)
			_expand(sim)
			peak_guests = maxi(peak_guests, sim.state.visitors.size())
			peak_mood = maxi(peak_mood, int(sim.state.rating))
			if month % 6 == 0:
				print("ACCEPTANCE scenario=%d month=%d cash=%d guests=%d mood=%d income=%d rides=%d status=%s" % [scenario, sim.state.month, sim.state.money, sim.state.visitors.size(), sim.state.rating, sim.state.income, sim._count("ride"), sim.state.status])
		var roundtrip = Sim.new()
		var restored_ok: bool = roundtrip.restore(JSON.parse_string(JSON.stringify(sim.snapshot())))
		if not restored_ok:
			failed = true
			push_error("Acceptance park failed save/load: scenario %d difficulty %d" % [scenario, difficulty])
		if scenario == 5 and sim.state.visitors.size() >= 150:
			DirAccess.make_dir_recursive_absolute("res://../art/review")
			FileAccess.open("res://../art/review/acceptance_park.json", FileAccess.WRITE).store_string(JSON.stringify(sim.snapshot(), "  "))
		var report := {"scenario": scenario, "difficulty": difficulty, "save_roundtrip": restored_ok, "status": sim.state.status, "months": sim.state.month, "cash": sim.state.money, "income": sim.state.income, "expenses": sim.state.expenses, "guests": sim.state.visitors.size(), "peak_guests": peak_guests, "mood": sim.state.rating, "peak_mood": peak_mood, "rides": sim._count("ride"), "working": sim.state.buildings.filter(func(b): return b.kind == "ride" and b.working).size()}
		reports.append(report)
		if sim.state.status != "won" or (scenario > 0 and (sim.state.income < 30 or peak_guests < 4 or peak_mood < 4)):
			failed = true
		print("ACCEPTANCE RESULT ", JSON.stringify(report))
	var destination := OS.get_environment("PARK_ACCEPTANCE_REPORT")
	if destination.is_empty():
		destination = "/tmp/prehistorik_economy_acceptance.json"
	FileAccess.open(destination, FileAccess.WRITE).store_string(JSON.stringify(reports, "  "))
	print("ECONOMY ACCEPTANCE %s: %d original scenarios, public gameplay commands only" % ["FAILED" if failed else "OK", selected.size()])
	quit(1 if failed else 0)
