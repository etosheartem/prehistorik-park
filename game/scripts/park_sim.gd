extends RefCounted
## Original data and economy; modern deterministic pathfinding. See docs/rules.md.

const DATA_PATH := "res://assets/data/original.json"
const SAVE_VERSION := 1
const STEP := 0.1
const MONTH_TICKS := 640
const ROUTE_CACHE_LIMIT := 2048
const DIRECTIONS := [Vector2i(0, -1), Vector2i(1, 0), Vector2i(-1, 0), Vector2i(0, 1)]
const NEED_PERIODS := [[20, 20, 25, 25, 20, 350, 50], [12, 12, 16, 16, 12, 150, 25]]
const NEED_INCREASE := [false, true, true, true, true, false, true]
const PRICE_DEFAULTS := [3, 5, 4, 4, 8, 9]
const TUTORIAL_LABELS := ["Проложите 10 клеток дорожки от входа", "Постройте 3 аттракциона у дорожки", "Постройте закусочную и источник", "Наймите продавца для закусочной", "Поставьте 2 скамейки на дорожках", "Наймите охранника", "Понаблюдайте за желаниями посетителей", "Обучение пройдено — вы готовы строить свой парк"]
const COMPETITOR_BANDS := [[40, 100, 250, 150, 300, 200, 350], [50, 200, 400, 250, 500, 300, 600]]

var data: Dictionary = {}
var ride_catalog: Array = []
var scenery_catalog: Array = []
var scenarios: Array = []
var staff_catalog: Array = []
var state: Dictionary = {}
var last_error := ""
var _rng := RandomNumberGenerator.new()
var _remainder := 0.0
var _occupancy: Dictionary = {}
var _reachable: Dictionary = {}
var _by_uid: Dictionary = {}
var _topology_dirty := true
var _beauty_cache: Dictionary = {}
var _route_cache: Dictionary = {}
var _route_cache_order: Array[Vector4i] = []
var _access_cache: Dictionary = {}


func _init() -> void:
	var parsed = JSON.parse_string(FileAccess.get_file_as_string(DATA_PATH))
	if parsed is Dictionary:
		data = _normalize_json_numbers(parsed)
		ride_catalog = data.rides
		scenery_catalog = data.props
		scenarios = data.scenarios
		staff_catalog = data.staff


func _normalize_json_numbers(value: Variant) -> Variant:
	# Godot JSON numbers are floats; Array.has distinguishes float and int.
	if value is Dictionary:
		var result: Dictionary = {}
		for key in value:
			result[key] = _normalize_json_numbers(value[key])
		return result
	if value is Array:
		var result: Array = []
		for item in value:
			result.append(_normalize_json_numbers(item))
		return result
	if value is float and is_finite(value) and value == floor(value):
		return int(value)
	return value


func new_game(scenario: int = -1, difficulty: int = 0, seed_value: int = 1) -> void:
	difficulty = clampi(difficulty, 0, 1)
	scenario = clampi(scenario, -2, 5) # -2 competition, -1 sandbox
	_rng.seed = seed_value
	var size := 30 if scenario < 0 else int(scenarios[scenario].size)
	var cash := (700 if difficulty == 0 else 600) if scenario < 0 else int(scenarios[scenario].starting_money[difficulty])
	state = {
		"version": SAVE_VERSION, "scenario": scenario, "difficulty": difficulty, "seed": seed_value,
		"size": size, "money": cash, "month": 0, "year": 1, "day": 1, "tick": 0,
		"rating": 0, "admission": 0, "status": "playing", "paused": false, "debug": false, "debug_used": false,
		"buildings": [], "visitors": [], "workers": [], "paths": {}, "terrain": {},
		"staff": [0, 0, 0, 0, 0, 0], "research": {"rides": [], "props": []},
		"messages": [], "next_uid": 1, "next_visitor": 1, "income": 0, "expenses": 0,
		"arrivals": 0, "debt_days": -1, "tutorial_step": 0, "history": [],
		"competition_streak": 0, "competitors": [0, 0, 0, 0], "annual_ratings": [],
		"competitor_trends": [0, 0, 0, 0], "competitor_bands": [0, 1, 1, 2],
		"tutorial_flags": [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0], "tutorial_wait": 0,
		"water_build": -1,
		"prices": PRICE_DEFAULTS.duplicate(), "entrance": [size / 2, 0],
	}
	for x in range(size):
		for y in range(size):
			state.terrain[_key(Vector2i(x, y))] = -(1 + _rng.randi_range(0, 11)) if _rng.randi_range(0, 19) == 0 else _rng.randi_range(1, 3)
	state.paths[_key(_entrance())] = 0
	state.terrain[_key(_entrance())] = 1
	for kind in ["ride", "prop"]:
		var collection: Array = ride_catalog if kind == "ride" else scenery_catalog
		var available: Array = []
		for item in collection:
			if scenario < 0 or int(item.id) in scenarios[scenario]["initial_rides" if kind == "ride" else "initial_props"]:
				available.append(int(item.id))
		state.research["rides" if kind == "ride" else "props"] = available
	_remainder = 0.0
	_topology_dirty = true
	_refresh_topology()
	_message("Постройте дорожки от входа, аттракционы и службы для посетителей.")


func _key(cell: Vector2i) -> String:
	return "%d,%d" % [cell.x, cell.y]


func _cell(key: String) -> Vector2i:
	var parts := key.split(",")
	return Vector2i(int(parts[0]), int(parts[1]))


func _entrance() -> Vector2i:
	return Vector2i(int(state.entrance[0]), int(state.entrance[1]))


func _inside(cell: Vector2i) -> bool:
	return cell.x >= 0 and cell.y >= 0 and cell.x < int(state.size) and cell.y < int(state.size)


func availability(kind: String, id: int) -> bool:
	if state.is_empty():
		return false
	if kind == "path":
		return id in [0, 2, 4, 13]
	var catalog := ride_catalog if kind == "ride" else scenery_catalog
	if kind not in ["ride", "prop"] or id < 0 or id >= catalog.size():
		return false
	return bool(state.debug) or id in state.research["rides" if kind == "ride" else "props"]


func _catalog(kind: String, id: int) -> Dictionary:
	if kind == "ride" and id >= 0 and id < ride_catalog.size():
		return ride_catalog[id]
	if kind == "prop" and id >= 0 and id < scenery_catalog.size():
		return scenery_catalog[id]
	if kind == "path" and id in [0, 2, 4, 13]:
		return {"name": {0: "Грунтовая дорога", 2: "Скамейка", 4: "Каменная дорога", 13: "Водная дорожка"}[id], "size": [1, 1], "cost": int(data.tables[133][id])}
	return {}


func _footprint(kind: String, id: int, cell: Vector2i, rotation: int) -> Array:
	var item := _catalog(kind, id)
	var result: Array = []
	if item.is_empty():
		return result
	if kind == "ride" and id == 22:
		return [cell, cell + (Vector2i(0, 1) if rotation == 0 else Vector2i(1, 0))]
	var width := int(item.size[0])
	var height := int(item.size[1])
	for x in range(width):
		for y in range(height):
			if kind == "ride" and int(item.sections[37][(rotation * width + x) * height + y]) == 1:
				continue
			result.append(cell + Vector2i(x, y))
	return result


func can_build(kind: String, id: int, cell: Vector2i, rotation: int = 0) -> String:
	if state.is_empty() or state.status != "playing":
		return "Игра завершена"
	var item := _catalog(kind, id)
	if item.is_empty():
		return "Неизвестный объект"
	if rotation not in [0, 1]:
		return "Недопустимый поворот"
	if not availability(kind, id):
		return "Изобретение пока недоступно"
	var cost := int(item.cost) / 2 if kind == "ride" and id == 22 else int(item.cost)
	if int(state.money) - cost < -500 and not bool(state.debug):
		return "Не хватает денег: предел долга — 500"
	if kind == "ride" and _count("ride") >= 42 and not (id == 22 and int(state.water_build) > 0):
		return "Построен максимум аттракционов (42)"
	if kind == "prop" and id >= 14 and _count("service") >= 90:
		return "Построен максимум сервисов (90)"
	if kind == "prop" and id in [13, 26] and _count("prop", id) >= (30 if id == 13 else 15):
		return "Построен максимум объектов этого типа"
	if _topology_dirty:
		_refresh_topology()
	for occupied in _footprint(kind, id, cell, rotation):
		if not _inside(occupied):
			return "Объект выходит за границу парка"
		var key := _key(occupied)
		if _occupancy.has(key):
			return "Здесь уже есть объект"
		if kind != "path" and state.paths.has(key):
			return "Здесь проходит дорожка"
		if kind == "path":
			if id == 2 and (not state.paths.has(key) or int(state.paths[key]) == 13):
				return "Скамейку ставят на обычную дорожку"
			if state.paths.has(key) and int(state.paths[key]) == id:
				return "Такая дорожка уже построена"
			if state.paths.has(key) and id != 13:
				var existing := int(state.paths[key])
				if (id == 2 and existing in [2, 6]) or (id == 4 and existing in [4, 6]) or id == 0:
					return "Такая дорожка или улучшение уже построены"
			if state.paths.has(key) and (id == 13 or int(state.paths[key]) == 13):
				return "Сначала уберите прежнюю дорожку"
			if id == 13:
				var wet_neighbors := 0
				for direction in DIRECTIONS:
					var adjacent: Vector2i = occupied + direction
					if int(state.paths.get(_key(adjacent), -1)) == 13:
						wet_neighbors += 1
						var branch_count := 1
						for other_direction in DIRECTIONS:
							if int(state.paths.get(_key(adjacent + other_direction), -1)) == 13:
								branch_count += 1
						if branch_count > 2:
							return "Водная дорожка не должна разветвляться"
				if wet_neighbors > 2:
					return "Водная дорожка не должна разветвляться"
	return ""


func build(kind: String, id: int, cell: Vector2i, rotation: int = 0) -> bool:
	last_error = can_build(kind, id, cell, rotation)
	if not last_error.is_empty():
		return false
	var item := _catalog(kind, id)
	_spend(int(item.cost) / 2 if kind == "ride" and id == 22 else int(item.cost))
	if kind == "ride" and id == 22 and int(state.water_build) > 0:
		var water: Dictionary = _by_uid.get(int(state.water_build), {})
		if not water.is_empty():
			water.water_exit = [cell.x, cell.y]
			water.exit_rotation = rotation
			state.paths[_key(cell + (Vector2i(0, 1) if rotation == 0 else Vector2i.ZERO))] = 13
			state.water_build = -1
			_message("Соедините вход и выход клетками воды. Нужны обычные дорожки снаружи обоих ворот.")
			_topology_dirty = true
			_refresh_topology()
			return true
	if kind == "path":
		var existing := int(state.paths.get(_key(cell), 0))
		state.paths[_key(cell)] = 6 if (id == 2 and existing == 4) or (id == 4 and existing == 2) else id
		state.terrain[_key(cell)] = 1
	else:
		var price := int(item.get("default_price", 0))
		if kind == "prop" and int(item.price_group) >= 0:
			price = int(state.prices[int(item.price_group)])
		state.buildings.append({"uid": int(state.next_uid), "kind": kind, "type": id,
			"x": cell.x, "y": cell.y, "w": int(item.size[0]), "h": int(item.size[1]),
			"rotation": rotation, "working": false, "condition": 100, "open": true, "price": price,
			"phase": 0, "phase_t": 0.0, "occupants": [], "queue": [], "wait_ticks": 0,
			"repair_ticks": 0, "staffed": false, "powered": false, "connected": false, "reason": "", "income": 0})
		state.next_uid = int(state.next_uid) + 1
		if kind == "ride" and id == 22:
			var water: Dictionary = state.buildings.back()
			water.w = 1 if rotation == 0 else 2
			water.h = 2 if rotation == 0 else 1
			water.water_exit = []
			water.exit_rotation = rotation
			water.water_route = []
			state.water_build = int(water.uid)
			state.paths[_key(cell + (Vector2i(0, 1) if rotation == 0 else Vector2i.ZERO))] = 13
			_message("Вход водной дорожки установлен. Теперь укажите место для выхода.")
		for occupied in _footprint(kind, id, cell, rotation):
			state.terrain[_key(occupied)] = 1
	_topology_dirty = true
	_refresh_topology()
	_tutorial_action(kind, id)
	_check_tutorial()
	return true


func building_at(cell: Vector2i) -> Dictionary:
	if _topology_dirty:
		_refresh_topology()
	return _by_uid.get(_occupancy.get(_key(cell), -1), {})


func building_by_id(uid: int) -> Dictionary:
	if _topology_dirty:
		_refresh_topology()
	return _by_uid.get(uid, {})


func demolish(cell: Vector2i) -> bool:
	last_error = ""
	if state.status != "playing":
		last_error = "Игра завершена"
		return false
	if cell == _entrance():
		last_error = "Нельзя удалить вход в парк"
		return false
	var building := building_at(cell)
	if not building.is_empty():
		if not building.occupants.is_empty() or not building.queue.is_empty():
			last_error = "На объекте пока есть люди. Закройте его и подождите."
			return false
		state.buildings.erase(building)
		if building.kind == "ride" and int(building.type) == 22:
			state.paths.erase(_key(_water_cell(building, false)))
			if not building.water_exit.is_empty():
				state.paths.erase(_key(_water_cell(building, true)))
			if int(state.water_build) == int(building.uid):
				state.water_build = -1
	elif state.paths.has(_key(cell)):
		if int(state.paths[_key(cell)]) == 13:
			for ride in state.buildings:
				if ride.kind == "ride" and int(ride.type) == 22 and not ride.occupants.is_empty():
					last_error = "На водной дорожке есть люди. Закройте вход и подождите."
					return false
		for visitor in state.visitors:
			if Vector2i(roundi(visitor.x), roundi(visitor.y)) == cell:
				last_error = "На дорожке находится посетитель"
				return false
		state.paths.erase(_key(cell))
	elif int(state.terrain.get(_key(cell), 1)) < 0:
		state.terrain[_key(cell)] = 1
	else:
		last_error = "Здесь нечего сносить"
		return false
	# Original demolition does not refund construction costs.
	_topology_dirty = true
	_refresh_topology()
	return true


func set_price(uid: int, price: int) -> bool:
	if state.is_empty() or state.status != "playing":
		last_error = "Игра завершена"
		return false
	var b := building_by_id(uid)
	if b.is_empty() or price < 0 or price > 10:
		last_error = "Цена должна быть от 0 до 10"
		return false
	if b.kind == "ride":
		for other in state.buildings:
			if other.kind == "ride" and int(other.type) == int(b.type):
				other.price = price
	else:
		var group := int(scenery_catalog[int(b.type)].price_group)
		if group < 0:
			last_error = "У этого объекта нет платной услуги"
			return false
		state.prices[group] = price
		for other in state.buildings:
			if other.kind == "prop" and int(scenery_catalog[int(other.type)].price_group) == group:
				other.price = price
	return true


func set_open(uid: int, opened: bool) -> bool:
	if state.is_empty() or state.status != "playing":
		last_error = "Игра завершена"
		return false
	var b := building_by_id(uid)
	if b.is_empty():
		return false
	b.open = opened
	if not opened:
		for visitor in state.visitors:
			if int(visitor.target_uid) == uid and visitor.state in ["queue", "walking"]:
				visitor.state = "walking"
				visitor.target_uid = -1
				visitor.route = []
		b.queue.clear()
	_refresh_working()
	return true


func set_admission(price: int) -> bool:
	last_error = "В оригинале вход в парк бесплатный" if price != 0 else ""
	return price == 0


func hire(role: int) -> bool:
	last_error = ""
	if state.is_empty() or state.status != "playing":
		last_error = "Игра завершена"
		return false
	if role < 0 or role >= 6:
		last_error = "Неизвестная профессия"
	elif _staff_count() >= 22:
		last_error = "Нанят максимум работников (22)"
	elif int(state.money) - int(staff_catalog[role].salary) < -500:
		last_error = "Не хватает денег"
	if not last_error.is_empty():
		return false
	_spend(int(staff_catalog[role].salary))
	state.staff[role] = int(state.staff[role]) + 1
	var start := _entrance()
	state.workers.append({"uid": int(state.next_uid), "type": role, "x": float(start.x), "y": float(start.y), "dir": 3, "state": "walking", "target_uid": -1, "route": [], "anim": 0.0})
	state.next_uid = int(state.next_uid) + 1
	_refresh_working()
	_tutorial_action("staff", role)
	_check_tutorial()
	return true


func fire(role: int) -> bool:
	if state.is_empty() or state.status != "playing":
		last_error = "Игра завершена"
		return false
	if role < 0 or role >= 6 or int(state.staff[role]) <= 0:
		last_error = "Такой работник не нанят"
		return false
	for worker in state.workers:
		if int(worker.type) == role:
			state.workers.erase(worker)
			break
	state.staff[role] = int(state.staff[role]) - 1
	_refresh_working()
	return true


func start_research(id: int, kind: String = "") -> bool:
	last_error = "Изобретения открываются автоматически с течением месяцев"
	if int(state.scenario) >= 0:
		for event in scenarios[int(state.scenario)].unlocks:
			if int(event.id) == id and (kind.is_empty() or event.kind == kind):
				last_error = "Изобретение появится в месяце %d" % int(event.month)
				return false
		if not kind.is_empty():
			last_error = "Этот объект не открывается в текущем сценарии"
	return false


func set_debug(enabled: bool) -> void:
	state.debug = enabled
	if enabled:
		state.debug_used = true
		state.money = maxi(int(state.money), 100000)
		_message("Тестовый режим: деньги и все постройки доступны. Результаты не засчитываются.")
	_refresh_working()


func goals() -> Dictionary:
	var target: Array = [0, 0, 0]
	if int(state.scenario) >= 0:
		target = scenarios[int(state.scenario)].targets[int(state.difficulty)]
	return {"money": {"label": "Баланс", "current": int(state.money), "target": int(target[0])},
		"rating": {"label": "Настроение", "current": int(state.rating), "target": int(target[1])},
		"visitors": {"label": "Посетители", "current": state.visitors.size(), "target": int(target[2])},
		"competition_years": int(state.competition_streak), "scenario": int(state.scenario)}


func tutorial_progress() -> Dictionary:
	var step := int(state.get("tutorial_step", 0))
	return {"step": step, "total": TUTORIAL_LABELS.size(), "complete": step >= TUTORIAL_LABELS.size(), "label": TUTORIAL_LABELS[mini(step, TUTORIAL_LABELS.size() - 1)]}


func advance(delta: float) -> void:
	if state.is_empty() or state.status != "playing" or bool(state.paused) or not is_finite(delta) or delta <= 0.0:
		return
	_remainder += delta
	while _remainder + 0.0000001 >= STEP and state.status == "playing":
		_remainder -= STEP
		_tick()
	if state.status != "playing":
		_remainder = 0.0


func _tick() -> void:
	state.tick = int(state.tick) + 1
	if _topology_dirty:
		_refresh_topology()
	if int(state.tick) % 8 == 1:
		_spawn_guest()
	_tick_rides()
	_tick_workers()
	for visitor in state.visitors.duplicate():
		_tick_guest(visitor)
	if int(state.tick) % 10 == 0:
		_refresh_working()
	if int(state.tick) % 40 == 0:
		_daily()
	if int(state.tick) % MONTH_TICKS == 0:
		_monthly()


func _count(kind: String, id: int = -1) -> int:
	var total := 0
	for b in state.buildings:
		if (b.kind == kind or (kind == "service" and b.kind == "prop" and int(b.type) >= 14)) and (id < 0 or int(b.type) == id):
			total += 1
	return total


func _staff_count() -> int:
	var count := 0
	for value in state.staff:
		count += int(value)
	return count


func _spend(amount: int) -> void:
	state.money = int(state.money) - amount
	state.expenses = int(state.expenses) + amount


func _message(message: String) -> void:
	state.messages.append(message)
	if state.messages.size() > 40:
		state.messages.pop_front()


func _refresh_topology() -> void:
	_beauty_cache.clear()
	_route_cache.clear()
	_route_cache_order.clear()
	_access_cache.clear()
	_occupancy.clear()
	_by_uid.clear()
	for b in state.buildings:
		_by_uid[int(b.uid)] = b
		for cell in _footprint(b.kind, int(b.type), Vector2i(int(b.x), int(b.y)), int(b.rotation)):
			_occupancy[_key(cell)] = int(b.uid)
		if b.kind == "ride" and int(b.type) == 22 and not b.water_exit.is_empty():
			for cell in _footprint("ride", 22, Vector2i(int(b.water_exit[0]), int(b.water_exit[1])), int(b.exit_rotation)):
				_occupancy[_key(cell)] = int(b.uid)
	_reachable.clear()
	var pending: Array = [_entrance()]
	_reachable[_key(_entrance())] = true
	var index := 0
	while index < pending.size():
		var cell: Vector2i = pending[index]
		index += 1
		for direction in DIRECTIONS:
			var next: Vector2i = cell + direction
			var key := _key(next)
			if not _reachable.has(key) and state.paths.has(key) and int(state.paths[key]) != 13:
				_reachable[key] = true
				pending.append(next)
	_topology_dirty = false
	_refresh_working()


func _access(b: Dictionary, exit_port: bool = false) -> Array:
	var result: Array = []
	var origin := Vector2i(int(b.x), int(b.y))
	if b.kind == "ride":
		if int(b.type) == 22:
			if exit_port and b.water_exit.is_empty():
				return []
			var pos := Vector2i(int(b.water_exit[0]), int(b.water_exit[1])) if exit_port else origin
			var rot := int(b.exit_rotation) if exit_port else int(b.rotation)
			return [pos + (Vector2i(0, -1) if rot == 0 else Vector2i(2, 0))]
		var item: Dictionary = ride_catalog[int(b.type)]
		var wanted := (8 if int(b.rotation) == 0 else 7) if exit_port else (6 if int(b.rotation) == 0 else 5)
		if int(b.type) == 23:
			wanted = 6 if int(b.rotation) == 0 else 5
		for x in range(int(b.w)):
			for y in range(int(b.h)):
				if int(item.sections[37][(int(b.rotation) * int(b.w) + x) * int(b.h) + y]) == wanted:
					result.append(origin + Vector2i(x, y) + (Vector2i(0, -1) if int(b.rotation) == 0 else Vector2i(1, 0)))
	else:
		var type := int(b.type)
		if type == 26:
			for x in range(2):
				result.append(origin + Vector2i(x, -1))
			for y in range(2):
				result.append(origin + Vector2i(2, y))
		else:
			if int(data.tables[163][type]) == 1:
				result.append(origin + Vector2i(1, 0))
			if int(data.tables[164][type]) == 1:
				result.append(origin + Vector2i(0, -1))
			if result.is_empty():
				for direction in DIRECTIONS:
					result.append(origin + direction)
	return result


func _connected_access(b: Dictionary, exit_port: bool = false) -> Array:
	var cache_key := int(b.uid) * 2 + (1 if exit_port else 0)
	if _access_cache.has(cache_key):
		return _access_cache[cache_key].duplicate()
	var result: Array = []
	for cell in _access(b, exit_port):
		if _reachable.has(_key(cell)):
			result.append(cell)
	_access_cache[cache_key] = result.duplicate()
	return result


func _role(b: Dictionary) -> int:
	if b.kind == "ride":
		return 2 if int(b.type) == 23 else -1
	return int(scenery_catalog[int(b.type)].role)


func _refresh_working() -> void:
	var remaining: Array = state.staff.duplicate()
	for worker in state.workers:
		if int(worker.type) >= 2:
			worker.target_uid = -1
	var motors: Array = []
	for b in state.buildings:
		if b.kind == "ride" and int(b.type) == 22:
			b.water_route = _water_route(b)
		b.connected = not _connected_access(b).is_empty() and not _connected_access(b, true).is_empty()
		var role := _role(b)
		b.staffed = role < 0
		if role >= 0 and int(remaining[role]) > 0 and bool(b.open) and bool(b.connected):
			b.staffed = true
			remaining[role] = int(remaining[role]) - 1
			for worker in state.workers:
				if int(worker.type) == role and int(worker.target_uid) == -1:
					worker.target_uid = int(b.uid)
					worker.x = float(b.x)
					worker.y = float(b.y)
					worker.state = "working"
					break
		if b.kind == "prop" and int(b.type) == 26 and bool(b.open) and bool(b.staffed) and bool(b.connected):
			motors.append(b)
	for b in state.buildings:
		b.powered = true
		if b.kind == "ride" and bool(ride_catalog[int(b.type)].requires_motor):
			b.powered = false
			for motor in motors:
				if int(motor.x) - 4 < int(b.x) + int(b.w) and int(motor.x) + 5 >= int(b.x) and int(motor.y) - 4 < int(b.y) + int(b.h) and int(motor.y) + 5 >= int(b.y):
					b.powered = true
		b.reason = ""
		if not bool(b.open):
			b.reason = "Закрыто"
		elif not bool(b.connected):
			b.reason = "Нужны дорожки к входу и выходу"
		elif not bool(b.staffed):
			b.reason = "Нужен работник: " + str(staff_catalog[_role(b)].name)
		elif not bool(b.powered):
			b.reason = "Нужен работающий диномотор"
		elif b.kind == "ride" and int(b.type) == 22 and b.water_route.is_empty():
			b.reason = "Соедините вход и выход водной дорожкой"
		elif int(b.condition) < 10:
			b.reason = "Нужен ремонтник"
		b.working = b.reason.is_empty()


func _route(start: Vector2i, destination: Vector2i) -> Array:
	if start == destination:
		return []
	var cache_key := Vector4i(start.x, start.y, destination.x, destination.y)
	if _route_cache.has(cache_key):
		# Packed cell IDs bound persistent memory; callers receive fresh mutable routes.
		var decoded: Array = []
		var side := int(state.size)
		for cell_id in _route_cache[cache_key]:
			decoded.append([int(cell_id) / side, int(cell_id) % side])
		return decoded
	var result := _find_route(start, destination)
	if _route_cache_order.size() >= ROUTE_CACHE_LIMIT:
		_route_cache.erase(_route_cache_order.pop_front())
	_route_cache_order.append(cache_key)
	var encoded := PackedInt32Array()
	for cell in result:
		encoded.append(int(cell[0]) * int(state.size) + int(cell[1]))
	_route_cache[cache_key] = encoded
	return result


func _find_route(start: Vector2i, destination: Vector2i) -> Array:
	if start == destination:
		return []
	var queue: Array = [start]
	var previous: Dictionary = {_key(start): ""}
	var index := 0
	while index < queue.size():
		var cell: Vector2i = queue[index]
		index += 1
		for direction in DIRECTIONS:
			var next: Vector2i = cell + direction
			var key := _key(next)
			if previous.has(key) or not state.paths.has(key) or int(state.paths[key]) == 13:
				continue
			previous[key] = _key(cell)
			if next == destination:
				var result: Array = []
				while key != _key(start):
					var step := _cell(key)
					result.push_front([step.x, step.y])
					key = previous[key]
				return result
			queue.append(next)
	return []


func _water_cell(b: Dictionary, exiting: bool) -> Vector2i:
	var origin := Vector2i(int(b.water_exit[0]), int(b.water_exit[1])) if exiting else Vector2i(int(b.x), int(b.y))
	var rotation := int(b.exit_rotation) if exiting else int(b.rotation)
	return origin + (Vector2i(0, 1) if rotation == 0 else Vector2i.ZERO)


func _water_route(b: Dictionary) -> Array:
	if b.water_exit.is_empty():
		return []
	var start := _water_cell(b, false)
	var destination := _water_cell(b, true)
	var route: Array = [[start.x, start.y]]
	var seen := {_key(start): true}
	var current := start
	for step in range(int(state.size) * int(state.size)):
		var choices: Array = []
		for direction in DIRECTIONS:
			var next: Vector2i = current + direction
			if int(state.paths.get(_key(next), -1)) == 13 and not seen.has(_key(next)):
				choices.append(next)
		if choices.size() != 1:
			return []
		current = choices[0]
		route.append([current.x, current.y])
		seen[_key(current)] = true
		if current == destination:
			return route
	return []


func _move(person: Dictionary, speed: float) -> bool:
	if person.route.is_empty():
		return true
	var goal := Vector2(float(person.route[0][0]), float(person.route[0][1]))
	var cell := Vector2i(int(goal.x), int(goal.y))
	if not state.paths.has(_key(cell)) or int(state.paths[_key(cell)]) == 13:
		person.route.clear()
		person.target_uid = -1
		return true
	var pos := Vector2(float(person.x), float(person.y))
	var vector := goal - pos
	if absf(vector.x) > absf(vector.y):
		person.dir = 1 if vector.x > 0 else 2
	else:
		person.dir = 3 if vector.y > 0 else 0
	pos = pos.move_toward(goal, speed * STEP)
	person.x = pos.x
	person.y = pos.y
	person.anim = snappedf(fmod(float(person.get("anim", 0.0)) + speed * STEP * 3.0, 4.0), 0.0001)
	if pos.distance_squared_to(goal) < 0.00001:
		person.route.pop_front()
		if person.has("needs"):
			_contact_guests(person)
	return person.route.is_empty()


func _spawn_guest() -> void:
	var limit := mini(200, 200 - (30 - int(state.size) - 5) * 10)
	if state.visitors.size() >= limit or _reachable.size() < 2:
		return
	var variety := _variety()
	var difficulty := int(state.difficulty)
	var probability := 5 + (int(state.rating) - 6 - difficulty) * (int(state.month) * (2 + difficulty) / 3) + variety * 15 / 114
	var rides := _count("ride")
	if rides > 0 and state.visitors.size() > rides * 5:
		probability = int(probability / maxi(1, state.visitors.size() / (rides * 5)))
	probability = clampi(probability, 3, 80)
	if _rng.randi_range(0, 99) >= probability:
		return
	var entry := _entrance()
	state.visitors.append({"uid": int(state.next_visitor), "type": _rng.randi_range(0, 7),
		"x": float(entry.x), "y": float(entry.y), "dir": 3, "state": "walking", "target_uid": -1,
		"needs": [_rng.randi_range(81, 100), _rng.randi_range(0, 59), _rng.randi_range(0, 59), _rng.randi_range(0, 19), _rng.randi_range(0, 59), _rng.randi_range(81, 100), _rng.randi_range(0, 19)],
		"cash": _rng.randi_range(40, 79), "age": 0, "need_ticks": 0, "speed": float(_rng.randi_range(1, 4)) / 2.0,
		"route": [], "timer": 0, "visited": [], "anim": 0.0, "cooldown": 0, "rides": 0})
	state.next_visitor = int(state.next_visitor) + 1
	state.arrivals = int(state.arrivals) + 1


func _tick_guest(v: Dictionary) -> void:
	v.age = int(v.age) + 1
	v.cooldown = maxi(0, int(v.cooldown) - 1)
	# Original cU advances the action clock; only seated rides (W=13) freeze it.
	var riding_building: Dictionary = _by_uid.get(int(v.target_uid), {})
	var seated_ride: bool = v.state == "riding" and (riding_building.is_empty() or int(riding_building.type) != 22)
	if not seated_ride:
		v.need_ticks = int(v.need_ticks) + 1
	if not seated_ride and v.state != "leaving":
		for need in range(7):
			var period := int(NEED_PERIODS[int(state.difficulty)][need])
			if need == 0:
				period += _beauty(Vector2i(roundi(v.x), roundi(v.y)))
			if int(v.need_ticks) % period == 0:
				v.needs[need] = clampi(int(v.needs[need]) + (1 if NEED_INCREASE[need] else -1), 0, 100)
	if v.state == "queue":
		var b: Dictionary = _by_uid.get(int(v.target_uid), {})
		if b.is_empty() or not bool(b.working):
			if not b.is_empty():
				b.queue.erase(int(v.uid))
			v.state = "walking"
			v.target_uid = -1
			v.cooldown = 20
			v.needs[0] = maxi(0, int(v.needs[0]) - 10)
		else:
			v.timer = int(v.timer) + 1
		return
	if v.state == "riding":
		var water: Dictionary = _by_uid.get(int(v.target_uid), {})
		if not water.is_empty() and int(water.type) == 22:
			if not v.route.is_empty():
				var goal := Vector2(float(v.route[0][0]), float(v.route[0][1]))
				var pos := Vector2(float(v.x), float(v.y)).move_toward(goal, float(v.speed) * STEP)
				v.x = pos.x
				v.y = pos.y
				if pos.distance_squared_to(goal) < 0.00001:
					v.route.pop_front()
			else:
				v.needs[0] = clampi(int(v.needs[0]) + mini(20, water.water_route.size()) + 5, 0, 100)
				v.rides = int(v.rides) + 1
				var ports := _connected_access(water, true)
				if not ports.is_empty():
					v.x = float(ports[0].x)
					v.y = float(ports[0].y)
				water.occupants.erase(int(v.uid))
				v.need_ticks = 0
				v.state = "walking"
				v.target_uid = -1
				v.cooldown = 10
		return
	if v.state in ["eating", "drinking", "resting", "toilet", "shopping", "healing", "fighting", "watching"]:
		v.timer = int(v.timer) - 1
		if int(v.timer) <= 0:
			_finish_service(v)
		return
	if not v.route.is_empty():
		_move(v, float(v.speed))
		return
	if v.state == "leaving":
		if Vector2i(roundi(v.x), roundi(v.y)) == _entrance():
			state.visitors.erase(v)
		else:
			v.route = _route(Vector2i(roundi(v.x), roundi(v.y)), _entrance())
			if v.route.is_empty():
				v.state = "lost"
		return
	if int(v.target_uid) > 0:
		_arrive(v)
		return
	if int(v.cooldown) == 0:
		_choose_destination(v)


func _contact_guests(v: Dictionary) -> void:
	if v.state != "walking":
		return
	var cell := Vector2i(roundi(v.x), roundi(v.y))
	for other in state.visitors:
		if int(other.uid) == int(v.uid) or Vector2i(roundi(other.x), roundi(other.y)) != cell:
			continue
		if other.state == "fighting":
			v.state = "watching"
			v.timer = int(other.timer)
			return
		if other.state == "walking" and int(v.needs[6]) >= 20 and int(other.needs[6]) >= 20 and _rng.randi_range(0, 1999) < int(v.needs[6]) + int(other.needs[6]):
			for fighter in [v, other]:
				fighter.state = "fighting"
				fighter.timer = 30
				fighter.need_ticks = 0
			return


func _choose_destination(v: Dictionary) -> void:
	var choices: Array = []
	var origin := Vector2i(roundi(v.x), roundi(v.y))
	# Benches are a need response, not merely a fallback when every ride is unavailable.
	if int(v.needs[1]) >= 50:
		var shortest: Array = []
		for key in _reachable:
			if int(state.paths[key]) not in [2, 6]:
				continue
			var seat := _cell(key)
			if origin == seat:
				v.state = "resting"
				v.timer = int(data.tables[34][5])
				v.need_ticks = 0
				v.target_uid = -1
				return
			var route := _route(origin, seat)
			if not route.is_empty() and (shortest.is_empty() or route.size() < shortest.size()):
				shortest = route
		if not shortest.is_empty():
			v.route = shortest
			v.target_uid = -1
			v.state = "walking"
			return
	for b in state.buildings:
		if not bool(b.working) or int(b.price) > int(v.cash):
			continue
		var access := _connected_access(b)
		if access.is_empty():
			continue
		var weight := 0.0
		if b.kind == "ride" and int(b.type) != 23:
			var cat: Dictionary = ride_catalog[int(b.type)]
			weight = 100.0 - (float(v.needs[1]) + float(v.needs[2])) / 2.0
			var difference := int(cat.rating) - int(b.price)
			weight -= float(difference * (10 if difference > 0 else 25)) * 2.0
			if v.visited.size() > 0 and int(v.visited[0]) == int(b.type):
				weight -= 80.0
			if v.visited.size() > 1 and int(v.visited[1]) == int(b.type):
				weight -= 40.0
			weight -= b.queue.size() * 5.0
		elif b.kind == "ride":
			weight = maxf(float(v.needs[1]), maxf(float(v.needs[2]), float(v.needs[4]))) - 35.0
		elif int(b.type) >= 15 and int(b.type) != 22 and int(b.type) != 26:
			var cat: Dictionary = scenery_catalog[int(b.type)]
			var need := int(cat.need)
			if need >= 0:
				weight = float(v.needs[need]) - float(cat.threshold) + 80.0 if NEED_INCREASE[need] else float(cat.threshold) - float(v.needs[need]) + 80.0
				if (NEED_INCREASE[need] and int(v.needs[need]) < int(cat.threshold)) or (not NEED_INCREASE[need] and int(v.needs[need]) > int(cat.threshold)):
					weight = 0.0
		if weight > 0.0:
			var route := _route(origin, access[0])
			if not route.is_empty() or origin == access[0]:
				choices.append({"uid": int(b.uid), "weight": weight / (1.0 + route.size() * 0.08) + _rng.randf_range(0.0, 10.0), "route": route})
	if not choices.is_empty():
		choices.sort_custom(func(a, b): return a.weight > b.weight)
		v.target_uid = choices[0].uid
		v.route = choices[0].route
		v.state = "walking"
		return
	if int(v.needs[1]) > 45:
		for key in _reachable:
			if int(state.paths[key]) in [2, 6]:
				var seat := _cell(key)
				var route := _route(origin, seat)
				if origin == seat:
					v.state = "resting"
					v.timer = 50
					v.need_ticks = 0
					return
				if not route.is_empty():
					v.route = route
					v.cooldown = 20
					return
	var keys := _reachable.keys()
	if keys.size() > 1:
		v.route = _route(origin, _cell(keys[_rng.randi_range(0, keys.size() - 1)]))
	v.cooldown = 20
	v.state = "walking" if _reachable.has(_key(origin)) else "lost"


func _arrive(v: Dictionary) -> void:
	var b: Dictionary = _by_uid.get(int(v.target_uid), {})
	if b.is_empty() or not bool(b.working) or int(v.cash) < int(b.price):
		v.target_uid = -1
		v.cooldown = 10
		return
	if b.kind == "ride" and int(b.type) != 23:
		if int(b.type) == 22:
			_remember_ride(v, int(b.type))
			v.need_ticks = 0
			_pay(v, b)
			v.state = "riding"
			v.route = b.water_route.duplicate(true)
			b.occupants.append(int(v.uid))
			return
		if b.queue.size() >= 10:
			v.target_uid = -1
			v.cooldown = 30
			return
		_remember_ride(v, int(b.type))
		b.queue.append(int(v.uid))
		v.state = "queue"
		v.timer = 0
	else:
		if b.kind == "ride" and b.occupants.size() >= int(ride_catalog[23].capacity):
			v.target_uid = -1
			v.cooldown = 20
			return
		if b.kind == "ride":
			_remember_ride(v, int(b.type))
		v.need_ticks = 0
		_pay(v, b)
		b.occupants.append(int(v.uid))
		v.timer = 100 if b.kind == "ride" else int(data.tables[34][int(data.tables[53][int(b.type)]) * 4 + 1])
		v.state = "eating" if b.kind == "ride" else ({15: "eating", 16: "eating", 17: "eating", 18: "eating", 19: "drinking", 20: "toilet", 21: "toilet", 23: "shopping", 24: "shopping", 25: "healing"}.get(int(b.type), "shopping"))


func _remember_ride(v: Dictionary, type: int) -> void:
	v.visited.push_front(type)
	if v.visited.size() > 2:
		v.visited.resize(2)


func _pay(v: Dictionary, b: Dictionary) -> void:
	var amount := int(b.price)
	v.cash = int(v.cash) - amount
	state.money = int(state.money) + amount
	state.income = int(state.income) + amount
	b.income = int(b.income) + amount
	var fair := 9 if b.kind == "ride" and int(b.type) == 23 else (int(ride_catalog[int(b.type)].rating) if b.kind == "ride" else int(scenery_catalog[int(b.type)].effects.slice(0, 6).reduce(func(acc, value): return acc + int(value) / 5, 0)))
	var diff := fair - amount
	v.needs[0] = clampi(int(v.needs[0]) + diff * (10 if diff > 0 else 25), 0, 100)


func _finish_service(v: Dictionary) -> void:
	var b: Dictionary = _by_uid.get(int(v.target_uid), {})
	if v.state == "resting":
		v.needs[1] = maxi(0, int(v.needs[1]) - 50)
	elif v.state in ["fighting", "watching"]:
		var row := 0 if v.state == "fighting" else 1
		if row == 0:
			v.needs[6] = 0
		for need in range(7):
			v.needs[need] = clampi(int(v.needs[need]) + int(data.tables[33][row * 7 + need]) * (1 if NEED_INCREASE[need] else -1), 0, 100)
	elif not b.is_empty():
		if b.kind == "ride":
			v.needs[1] = maxi(0, int(v.needs[1]) - 50)
			for need in [2, 4]:
				v.needs[need] = maxi(0, int(v.needs[need]) - 60)
		else:
			var effects: Array = scenery_catalog[int(b.type)].effects
			for need in range(6):
				v.needs[need] = clampi(int(v.needs[need]) + int(effects[need]) * (-1 if NEED_INCREASE[need] else 1), 0, 100)
		b.occupants.erase(int(v.uid))
	v.state = "walking"
	v.target_uid = -1
	v.cooldown = 10


func _visitor(uid: int) -> Dictionary:
	for v in state.visitors:
		if int(v.uid) == uid:
			return v
	return {}


func _tick_rides() -> void:
	for b in state.buildings:
		if b.kind != "ride" or int(b.type) in [22, 23]:
			continue
		var cat: Dictionary = ride_catalog[int(b.type)]
		if int(b.phase) == 3:
			b.phase_t = snappedf(float(b.phase_t) + STEP, STEP)
			var duration := float(cat.duration_ticks) * STEP if int(b.type) != 22 else 6.0
			if float(b.phase_t) >= duration:
				_finish_ride(b)
		elif bool(b.working):
			b.wait_ticks = int(b.wait_ticks) + 1
			var capacity := maxi(1, int(cat.capacity))
			if int(b.type) == 22:
				capacity = 4
			if not b.queue.is_empty() and (b.queue.size() >= capacity or int(b.wait_ticks) >= int(cat.load_wait_ticks)):
				if int(b.type) == 14 and b.queue.size() < 2:
					continue
				for index in range(mini(capacity, b.queue.size())):
					var v := _visitor(int(b.queue.pop_front()))
					if v.is_empty():
						continue
					_pay(v, b)
					v.state = "riding"
					v.need_ticks = 0
					b.occupants.append(int(v.uid))
				b.phase = 3
				b.phase_t = 0.0
				b.wait_ticks = 0


func _finish_ride(b: Dictionary) -> void:
	var cat: Dictionary = ride_catalog[int(b.type)]
	var exit_cells := _connected_access(b, true)
	for uid in b.occupants:
		var v := _visitor(int(uid))
		if v.is_empty():
			continue
		v.needs[0] = clampi(int(v.needs[0]) + int(cat.happiness), 0, 100)
		v.rides = int(v.rides) + 1
		if not exit_cells.is_empty():
			v.x = float(exit_cells[0].x)
			v.y = float(exit_cells[0].y)
		v.state = "walking"
		v.target_uid = -1
		v.cooldown = 10
		if int(cat.wear_bound) > 0:
			b.condition = maxi(0, int(b.condition) - _rng.randi_range(0, int(cat.wear_bound) - 1) / (20 - 7 * int(state.difficulty)))
	b.occupants.clear()
	b.phase = 0
	b.phase_t = 0.0
	if int(b.condition) < 10:
		_message("Аттракцион сломался: " + str(cat.name))
	_refresh_working()


func _tick_workers() -> void:
	for worker in state.workers:
		worker.anim = snappedf(fmod(float(worker.anim) + STEP * 2.0, 4.0), 0.0001)
		if int(worker.type) == 1:
			var target: Dictionary = _by_uid.get(int(worker.target_uid), {})
			if not target.is_empty():
				if not worker.route.is_empty():
					_move(worker, 1.5)
				else:
					worker.state = "repairing"
					target.repair_ticks = int(target.repair_ticks) + 1
					if int(target.repair_ticks) >= 100 and target.occupants.is_empty():
						target.condition = 100
						target.repair_ticks = 0
						worker.target_uid = -1
						worker.state = "walking"
						_refresh_working()
			elif int(state.tick) % 10 == 0:
				for b in state.buildings:
					if b.kind == "ride" and int(b.condition) <= 50 and bool(b.connected):
						var claimed := false
						for other in state.workers:
							if int(other.target_uid) == int(b.uid):
								claimed = true
						if not claimed:
							worker.target_uid = int(b.uid)
							worker.route = _route(Vector2i(roundi(worker.x), roundi(worker.y)), _connected_access(b)[0])
							break
		elif int(worker.type) == 0:
			_move(worker, 1.5)
			if worker.route.is_empty() and int(state.tick) % 10 == 0:
				var keys := _reachable.keys()
				worker.route = _route(Vector2i(roundi(worker.x), roundi(worker.y)), _cell(keys[_rng.randi_range(0, keys.size() - 1)]))
			for v in state.visitors:
				if Vector2i(roundi(v.x), roundi(v.y)) == Vector2i(roundi(worker.x), roundi(worker.y)):
					v.needs[6] = 0
					if v.state == "fighting":
						v.timer = 1
		else:
			worker.state = "working"


func _beauty(cell: Vector2i) -> int:
	var score := 0
	var block := Vector2i(cell.x / 5, cell.y / 5)
	if _beauty_cache.has(block):
		return int(_beauty_cache[block])
	for x in range(block.x * 5, mini((block.x + 1) * 5, int(state.size))):
		for y in range(block.y * 5, mini((block.y + 1) * 5, int(state.size))):
			var key := _key(Vector2i(x, y))
			var terrain := int(state.terrain.get(key, 1))
			if terrain < 0 and terrain >= -14:
				score += int(data.tables[90][-1 - terrain])
			if state.paths.has(key):
				var path_type := int(state.paths[key])
				score += (1 if path_type in [4, 6] else 0) + (2 if path_type in [2, 6] else 0)
	for b in state.buildings:
		if b.kind == "prop" and int(b.type) < 13 and Vector2i(int(b.x) / 5, int(b.y) / 5) == block:
			score += int(data.tables[90][int(b.type)])
	_beauty_cache[block] = score / 3
	return int(_beauty_cache[block])


func _variety() -> int:
	var types: Dictionary = {}
	for b in state.buildings:
		if b.kind == "ride" and int(b.type) != 23:
			types[int(b.type)] = int(ride_catalog[int(b.type)].rating)
	var total := 0
	for amount in types.values():
		total += int(amount)
	return total


func _daily() -> void:
	state.day = (int(state.tick) / 40) % 16 + 1
	var happiness := 0
	for visitor in state.visitors:
		happiness += int(visitor.needs[0])
	state.rating = int(float(happiness) / state.visitors.size() / 10.0) if not state.visitors.is_empty() else 0
	# e.de(): departure evaluation on the first four lunar days, every40ticks.
	if ((int(state.tick) / 40) % 16) < 4:
		for v in state.visitors:
			if v.state != "walking":
				continue
			var departure_roll := _rng.randi_range(0, maxi(1, int(state.rating) * 40) - 1) if int(v.needs[0]) < 50 else 1000
			if int(v.cash) < 4 or int(v.needs[1]) >= 96 or int(v.needs[2]) >= 100 or 60 + 10 * int(state.difficulty) - int(v.needs[0]) > departure_roll:
				v.state = "leaving"
				v.target_uid = -1
				v.route = _route(Vector2i(roundi(v.x), roundi(v.y)), _entrance())
	if int(state.money) > 0:
		state.debt_days = -1
	if int(state.money) < -50 and int(state.debt_days) == -1:
		state.debt_days = 0
		_message("Парк в долгах. Верните положительный баланс за три месяца.")
	if int(state.money) < 0 and int(state.debt_days) >= 0:
		state.debt_days = int(state.debt_days) + 1
		if int(state.debt_days) >= 48 and not bool(state.debug):
			state.status = "lost"
			_message("Парк обанкротился")
	_check_tutorial()
	_check_victory()


func _monthly() -> void:
	state.month = int(state.month) + 1
	state.year = int(state.month) / 12 + 1
	var wages := 0
	for role in range(6):
		wages += int(state.staff[role]) * int(staff_catalog[role].salary)
	_spend(wages)
	if wages > 0:
		_message("Новолуние: зарплата работникам — %d" % wages)
	if int(state.scenario) >= 0:
		for event in scenarios[int(state.scenario)].unlocks:
			if int(event.month) == int(state.month):
				state.research["rides" if event.kind == "ride" else "props"].append(int(event.id))
				_message("Изобретение: " + str(_catalog(event.kind, int(event.id)).name))
	var park_score := _park_score()
	state.history.append({"month": int(state.month), "money": int(state.money), "rating": int(state.rating), "visitors": state.visitors.size(), "score": park_score})
	if state.history.size() > 120:
		state.history.pop_front()
	var bands: Array = COMPETITOR_BANDS[int(state.difficulty)]
	for index in range(4):
		var band := int(state.competitor_bands[index])
		var previous := int(state.competitors[index])
		if int(state.month) % 3 == 0:
			state.competitor_trends[index] = _rng.randi_range(0, 3) if previous < int(bands[band * 2 + 1]) else (_rng.randi_range(4, 7) if previous > int(bands[band * 2 + 2]) else _rng.randi_range(0, 7))
		if _rng.randi_range(0, 4) == 0:
			state.competitor_bands[index] = _rng.randi_range(0, 2)
		var change := int(data.tables[176][int(state.competitor_trends[index]) * 3 + int(state.month) % 3])
		state.competitors[index] = maxi(0, previous + change + _rng.randi_range(0, int(bands[0]) - 1) - int(bands[0]) / 2)
	state.annual_ratings.append([park_score] + state.competitors.duplicate())
	if state.annual_ratings.size() > 10:
		state.annual_ratings.pop_front()
	if int(state.month) % 12 == 0:
		var sums := [0, 0, 0, 0, 0]
		for row in state.annual_ratings:
			for index in range(5):
				sums[index] += int(row[index])
		var first := true
		for index in range(1, 5):
			if sums[index] > sums[0]:
				first = false
		state.competition_streak = int(state.competition_streak) + 1 if first else 0
		if int(state.scenario) == -2 and int(state.competition_streak) >= 3 and not bool(state.debug_used):
			state.status = "won"
			_message("Ваш парк занимает первое место три года подряд!")


func _park_score() -> int:
	var beauty := 0
	for x in range(0, (int(state.size) / 5) * 5, 5):
		for y in range(0, (int(state.size) / 5) * 5, 5):
			beauty += _beauty(Vector2i(x, y))
	return (beauty / 10 + _variety() + _count("ride") * 2 + _count("service") + state.visitors.size()) * int(state.rating) / 9


func _check_tutorial() -> void:
	if int(state.scenario) != 0:
		return
	while int(state.tutorial_step) < 6:
		var step := int(state.tutorial_step) + 1
		for index in range(int(data.tables[142][step]), int(data.tables[142][step + 1])):
			if int(state.tutorial_flags[index]) == 0:
				return
		state.tutorial_step = int(state.tutorial_step) + 1
		if int(state.tutorial_step) == 6:
			state.tutorial_wait = int(state.tick) + 320
	if int(state.tutorial_step) == 6 and int(state.tick) >= int(state.tutorial_wait):
		state.tutorial_step = 8


func _tutorial_action(kind: String, id: int) -> void:
	if int(state.scenario) != 0:
		return
	var category: int = {"ride": 0, "prop": 1, "staff": 2, "path": 3}.get(kind, -1)
	var type := id % 4 if kind == "path" else id
	# J2ME ck() credits the selected catalog item15, while rotation changes
	# only the placed prop to16. Preserve that behavior for the food task.
	if kind == "prop" and type == 16:
		type = 15
	for index in range(19):
		if int(state.tutorial_flags[index]) == 0 and int(data.tables[140][index]) == category and (int(data.tables[141][index]) == type or int(data.tables[141][index]) == -1):
			state.tutorial_flags[index] = 1
			return


func _check_victory() -> void:
	if bool(state.debug_used) or state.status != "playing" or int(state.scenario) < 0:
		return
	var won := int(state.tutorial_step) >= 8 if int(state.scenario) == 0 else false
	if int(state.scenario) > 0:
		var target: Array = scenarios[int(state.scenario)].targets[int(state.difficulty)]
		won = int(state.money) >= int(target[0]) and int(state.rating) >= int(target[1]) and state.visitors.size() >= int(target[2])
	if won:
		state.status = "won"
		_message("Поздравляем! Условия сценария выполнены.")


func snapshot() -> Dictionary:
	var result := state.duplicate(true)
	result.rng_state = str(_rng.state)
	result.remainder = _remainder
	return result


func _integer(value: Variant, low: int = -1000000000000, high: int = 1000000000000) -> bool:
	return (value is int or value is float) and is_finite(float(value)) and float(value) == floor(float(value)) and value >= low and value <= high


func _int_array(value: Variant, count: int, low: int, high: int) -> bool:
	if not value is Array or (count >= 0 and value.size() != count):
		return false
	for number in value:
		if not _integer(number, low, high):
			return false
	return true


func _valid_position(value: Dictionary, size: int) -> bool:
	for coordinate in ["x", "y"]:
		if not value.has(coordinate) or not (value[coordinate] is int or value[coordinate] is float):
			return false
		if not is_finite(float(value[coordinate])) or value[coordinate] < 0 or value[coordinate] >= size:
			return false
	return true


func _valid_route(route: Variant, size: int) -> bool:
	if not route is Array or route.size() > size * size:
		return false
	for cell in route:
		if not _int_array(cell, 2, 0, size - 1):
			return false
	return true


func _valid_save(saved: Dictionary) -> bool:
	for key in ["version", "scenario", "difficulty", "seed", "size", "money", "month", "year", "day", "tick", "rating", "admission", "next_uid", "next_visitor", "income", "expenses", "arrivals", "debt_days", "tutorial_step", "competition_streak", "tutorial_wait", "water_build"]:
		if not saved.has(key) or not _integer(saved[key]):
			return false
	if int(saved.version) != SAVE_VERSION or int(saved.size) < 12 or int(saved.size) > 30 or int(saved.scenario) < -2 or int(saved.scenario) > 5 or int(saved.difficulty) not in [0, 1]:
		return false
	if int(saved.tick) < 0 or int(saved.month) < 0 or int(saved.year) < 1 or int(saved.day) < 1 or int(saved.day) > 16 or int(saved.rating) < 0 or int(saved.rating) > 10 or int(saved.admission) != 0 or int(saved.tutorial_step) < 0 or int(saved.tutorial_step) > 8:
		return false
	for key in ["paused", "debug", "debug_used"]:
		if not saved.get(key) is bool:
			return false
	if saved.get("status") not in ["playing", "won", "lost"]:
		return false
	for key in ["buildings", "visitors", "workers", "messages", "history", "annual_ratings"]:
		if not saved.get(key) is Array:
			return false
	for key in ["paths", "terrain", "research"]:
		if not saved.get(key) is Dictionary:
			return false
	var size := int(saved.size)
	if not _int_array(saved.get("staff"), 6, 0, 22) or not _int_array(saved.get("prices"), 6, 0, 10) or not _int_array(saved.get("competitors"), 4, 0, 1000000000) or not _int_array(saved.get("competitor_trends"), 4, 0, 7) or not _int_array(saved.get("competitor_bands"), 4, 0, 2) or not _int_array(saved.get("tutorial_flags"), 19, 0, 1) or not _int_array(saved.get("entrance"), 2, 0, size - 1):
		return false
	if not _int_array(saved.research.get("rides"), -1, 0, 23) or not _int_array(saved.research.get("props"), -1, 0, 26):
		return false
	if saved.buildings.size() > size * size or saved.visitors.size() > 200 or saved.workers.size() > 22 or saved.messages.size() > 40 or saved.history.size() > 120 or saved.annual_ratings.size() > 10:
		return false
	for message in saved.messages:
		if not message is String:
			return false
	for row in saved.history:
		if not row is Dictionary:
			return false
		for key in ["month", "money", "rating", "visitors", "score"]:
			if not row.has(key) or not _integer(row[key]):
				return false
	for row in saved.annual_ratings:
		if not _int_array(row, 5, 0, 1000000000):
			return false
	var ids: Dictionary = {}
	var occupancy: Dictionary = {}
	var rides := 0
	var services := 0
	for b in saved.buildings:
		if not b is Dictionary:
			return false
		for key in ["uid", "type", "x", "y", "w", "h", "rotation", "condition", "price", "phase", "wait_ticks", "repair_ticks", "income"]:
			if not b.has(key) or not _integer(b[key]):
				return false
		if not b.get("open") is bool or not _valid_position(b, size) or b.get("kind") not in ["ride", "prop"] or int(b.rotation) not in [0, 1] or int(b.uid) < 1 or int(b.uid) >= int(saved.next_uid) or ids.has(int(b.uid)):
			return false
		var catalog := _catalog(b.kind, int(b.type))
		if catalog.is_empty() or int(b.condition) < 0 or int(b.condition) > 100 or int(b.price) < 0 or int(b.price) > 10 or int(b.phase) not in [0, 3]:
			return false
		if not _int_array(b.get("occupants"), -1, 1, int(saved.next_visitor) - 1) or not _int_array(b.get("queue"), -1, 1, int(saved.next_visitor) - 1):
			return false
		if not (b.get("phase_t") is int or b.get("phase_t") is float) or not is_finite(float(b.phase_t)) or float(b.phase_t) < 0.0:
			return false
		var cells := _footprint(b.kind, int(b.type), Vector2i(int(b.x), int(b.y)), int(b.rotation))
		if b.kind == "ride":
			rides += 1
			if int(b.type) == 22:
				if not b.get("water_exit") is Array or not _integer(b.get("exit_rotation"), 0, 1) or not _valid_route(b.get("water_route"), size):
					return false
				if not b.water_exit.is_empty():
					if not _int_array(b.water_exit, 2, 0, size - 1):
						return false
					cells.append_array(_footprint("ride", 22, Vector2i(int(b.water_exit[0]), int(b.water_exit[1])), int(b.exit_rotation)))
			elif int(b.w) != int(catalog.size[0]) or int(b.h) != int(catalog.size[1]):
				return false
		elif int(b.w) != int(catalog.size[0]) or int(b.h) != int(catalog.size[1]):
			return false
		elif int(b.type) >= 14:
			services += 1
		for cell in cells:
			var key := _key(cell)
			if cell.x < 0 or cell.y < 0 or cell.x >= size or cell.y >= size or occupancy.has(key):
				return false
			occupancy[key] = int(b.uid)
		ids[int(b.uid)] = b
	if rides > 42 or services > 90:
		return false
	if int(saved.water_build) != -1:
		var unfinished: Dictionary = ids.get(int(saved.water_build), {})
		if unfinished.is_empty() or unfinished.kind != "ride" or int(unfinished.type) != 22 or not unfinished.water_exit.is_empty():
			return false
	var guest_ids: Dictionary = {}
	for v in saved.visitors:
		if not v is Dictionary or not _valid_position(v, size):
			return false
		for key in ["uid", "type", "dir", "target_uid", "cash", "age", "need_ticks", "timer", "cooldown", "rides"]:
			if not v.has(key) or not _integer(v[key]):
				return false
		if not _int_array(v.get("needs"), 7, 0, 100) or not _int_array(v.get("visited"), -1, 0, 23) or not _valid_route(v.get("route"), size) or int(v.uid) < 1 or int(v.uid) >= int(saved.next_visitor) or guest_ids.has(int(v.uid)) or int(v.type) < 0 or int(v.type) > 7 or int(v.dir) < 0 or int(v.dir) > 3 or int(v.cash) < 0 or int(v.need_ticks) < 0:
			return false
		if v.get("state") not in ["walking", "queue", "riding", "eating", "drinking", "resting", "toilet", "shopping", "healing", "leaving", "lost", "fighting", "watching"]:
			return false
		for key in ["speed", "anim"]:
			if not (v.get(key) is int or v.get(key) is float) or not is_finite(float(v[key])):
				return false
		if float(v.speed) < 0.1 or float(v.speed) > 10.0:
			return false
		guest_ids[int(v.uid)] = true
	for b in saved.buildings:
		for uid in b.occupants + b.queue:
			if not guest_ids.has(int(uid)):
				return false
	var actual_staff := [0, 0, 0, 0, 0, 0]
	for worker in saved.workers:
		if not worker is Dictionary or not _valid_position(worker, size):
			return false
		for key in ["uid", "type", "dir", "target_uid"]:
			if not worker.has(key) or not _integer(worker[key]):
				return false
		if int(worker.type) < 0 or int(worker.type) > 5 or int(worker.dir) < 0 or int(worker.dir) > 3 or int(worker.uid) < 1 or int(worker.uid) >= int(saved.next_uid) or ids.has(int(worker.uid)):
			return false
		if not _valid_route(worker.get("route"), size) or worker.get("state") not in ["walking", "working", "repairing"] or not (worker.get("anim") is int or worker.get("anim") is float) or not is_finite(float(worker.anim)):
			return false
		ids[int(worker.uid)] = true
		actual_staff[int(worker.type)] += 1
	if actual_staff != saved.staff:
		return false
	for grid in [saved.paths, saved.terrain]:
		if grid.size() > size * size:
			return false
		for key in grid:
			if not key is String or key.split(",").size() != 2 or not _integer(grid[key]):
				return false
			var parts: PackedStringArray = key.split(",")
			if not parts[0].is_valid_int() or not parts[1].is_valid_int():
				return false
			var cell := _cell(key)
			if cell.x < 0 or cell.y < 0 or cell.x >= size or cell.y >= size:
				return false
	for key in saved.paths:
		if int(saved.paths[key]) not in [0, 2, 4, 6, 13]:
			return false
	for key in saved.terrain:
		if int(saved.terrain[key]) < -12 or int(saved.terrain[key]) > 3:
			return false
	var entrance_key := _key(Vector2i(int(saved.entrance[0]), int(saved.entrance[1])))
	if int(saved.paths.get(entrance_key, -1)) not in [0, 2, 4, 6] or saved.terrain.size() != size * size:
		return false
	if not saved.get("rng_state") is String or not saved.rng_state.is_valid_int() or str(int(saved.rng_state)) != saved.rng_state:
		return false
	if not (saved.get("remainder") is int or saved.get("remainder") is float) or not is_finite(float(saved.remainder)) or float(saved.remainder) < -0.000001 or (saved.status == "playing" and float(saved.remainder) >= STEP + 0.000001):
		return false
	return true


func restore(saved: Dictionary) -> bool:
	last_error = "Повреждённое или несовместимое сохранение"
	saved = _normalize_json_numbers(saved)
	# Early 0.1 development saves predate sticky eligibility; load them as test parks.
	if _integer(saved.get("version")) and int(saved.version) == SAVE_VERSION and not saved.has("debug_used"):
		saved.debug_used = true
	if saved.get("visitors") is Array:
		for visitor in saved.visitors:
			if visitor is Dictionary and not visitor.has("need_ticks"):
				visitor.need_ticks = 0
	if not _valid_save(saved):
		return false
	state = saved.duplicate(true)
	_rng.seed = int(state.seed)
	_rng.state = int(state.rng_state)
	_remainder = clampf(float(state.remainder), 0.0, STEP) if state.status == "playing" else 0.0
	state.erase("rng_state")
	state.erase("remainder")
	_topology_dirty = true
	_refresh_topology()
	last_error = ""
	return true
