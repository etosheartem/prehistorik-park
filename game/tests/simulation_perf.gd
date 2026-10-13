extends SceneTree
## Deterministic before/after benchmark on an actual public-playthrough park.
## The reference overrides only the two memoized lookups with their original code.
const Sim = preload("res://scripts/park_sim.gd")

class UncachedSim extends "res://scripts/park_sim.gd":
	func _route(start: Vector2i, destination: Vector2i) -> Array:
		return _find_route(start, destination)

	func _connected_access(building: Dictionary, exit_port: bool = false) -> Array:
		var result: Array = []
		for cell in _access(building, exit_port):
			if _reachable.has(_key(cell)):
				result.append(cell)
		return result

var fixture: Dictionary

func _init() -> void:
	call_deferred("_run")

func _sample(sim) -> Dictionary:
	if not sim.restore(fixture):
		push_error("Performance fixture does not restore: " + sim.last_error)
		return {}
	# Explicit test mode lets the completed park continue without earning another win.
	sim.set_debug(true)
	sim.state.status = "playing"
	var timings: Array = []
	var start_tick := int(sim.state.tick)
	var started := Time.get_ticks_usec()
	for frame in range(3600):
		var previous_tick := int(sim.state.tick)
		var step_started := Time.get_ticks_usec()
		sim.advance(1.0 / 60.0)
		if int(sim.state.tick) != previous_tick:
			timings.append(Time.get_ticks_usec() - step_started)
	var elapsed := Time.get_ticks_usec() - started
	timings.sort()
	var packed_bytes := 0
	for path in sim._route_cache.values():
		packed_bytes += path.size() * 4
	return {
		"elapsed_us": elapsed, "frames": 3600, "ticks": timings.size(),
		"start_tick": start_tick, "end_tick": int(sim.state.tick),
		"frame_mean_us": float(elapsed) / 3600.0,
		"tick_p50_us": timings[int(timings.size() * 0.5)],
		"tick_p95_us": timings[int(timings.size() * 0.95)],
		"tick_max_us": timings.back(),
		"guests": sim.state.visitors.size(),
		"cached_routes": sim._route_cache.size(),
		"packed_route_bytes": packed_bytes,
		"snapshot": JSON.stringify(sim.snapshot()),
	}

func _run() -> void:
	var source := OS.get_environment("PARK_PERF_FIXTURE")
	if source.is_empty():
		source = "res://../art/review/acceptance_park.json"
	var parsed = JSON.parse_string(FileAccess.get_file_as_string(source))
	if not parsed is Dictionary:
		push_error("Missing or invalid performance fixture: " + source)
		quit(1)
		return
	fixture = parsed
	var before := _sample(UncachedSim.new())
	var after := _sample(Sim.new())
	if before.is_empty() or after.is_empty():
		quit(1)
		return
	var identical: bool = before.snapshot == after.snapshot
	var digest := HashingContext.new()
	digest.start(HashingContext.HASH_SHA256)
	digest.update(str(after.snapshot).to_utf8_buffer())
	var fingerprint := digest.finish().hex_encode()
	before.erase("snapshot")
	after.erase("snapshot")
	var report := {
		"fixture": source, "before": before, "after": after,
		"snapshots_byte_identical": identical, "final_snapshot_sha256": fingerprint,
		"speedup": float(before.elapsed_us) / float(after.elapsed_us),
		"note": "Desktop headless CPU benchmark, 60 game seconds. Not an Android FPS measurement.",
	}
	var destination := OS.get_environment("PARK_PERF_REPORT")
	if destination.is_empty():
		destination = "res://../art/review/simulation_performance.json"
	FileAccess.open(destination, FileAccess.WRITE).store_string(JSON.stringify(report, "  "))
	print("SIMULATION PERFORMANCE ", JSON.stringify(report))
	quit(0 if identical and int(after.ticks) == 600 else 1)
