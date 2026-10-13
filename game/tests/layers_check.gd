extends SceneTree

const Layers = preload("res://scripts/park_layers.gd")
const Simulation = preload("res://scripts/park_sim.gd")

class ViewStub:
	extends RefCounted
	var sim
	var art: Dictionary
	var elapsed := 0.0
	func iso(cell: Vector2) -> Vector2:
		return Vector2((cell.x + cell.y) * 20, (cell.x - cell.y) * 10)

var checks := 0

func check(value: bool, message: String) -> void:
	checks += 1
	if not value:
		push_error(message)
		quit(1)

func _initialize() -> void:
	var sim = Simulation.new()
	sim.new_game(-1, 0, 716)
	var view := ViewStub.new()
	view.sim = sim
	view.art = JSON.parse_string(FileAccess.get_file_as_string("res://assets/original/graphics.json"))
	for i in 12:
		sim.state.visitors.append({"uid": i + 1, "type": i % 8, "state": "riding"})
	for ride_id in 22:
		var ride: Dictionary = sim.ride_catalog[ride_id]
		var building := {"uid": 1, "kind": "ride", "type": ride_id, "x": 0, "y": 0,
			"rotation": 0, "phase": 3, "phase_t": 0.0, "occupants": [], "working": true}
		for i in int(ride.capacity):
			building.occupants.append(i + 1)
		for tick in maxi(1, int(ride.header["as"])):
			building.phase_t = tick * 0.1
			check(Layers.visual_phase(view, building) == tick, "Ride clock must follow original ticks")
			var poses := Layers.passenger_poses(view, building)
			if ride_id == 5:
				check(poses.is_empty(), "Haunted house must conceal its guests")
			else:
				check(poses.size() == int(ride.capacity), "Missing riders for ride%d phase%d" % [ride_id, tick])
			for pose in poses:
				check(pose.at.is_finite(), "Invalid passenger anchor")
				check(int(pose.actor) in range(8), "Wrong guest sprite set")
				check(ResourceLoader.exists(pose.frame.path), "Missing passenger pose")
				check(pose.hidden >= 0, "Invalid original rider crop")
		building.phase_t = 3.0
		building.phase = 0
		check(Layers.visual_phase(view, building) == 0, "Idle ride must not animate on its own")
	var wheel := {"kind": "ride", "type": 0, "x": 0, "y": 0, "rotation": 0,
		"phase": 3, "phase_t": 0.0, "occupants": [1, 2, 3, 4]}
	var poses := Layers.passenger_poses(view, wheel)
	var positions := {}
	for pose in poses:
		positions[pose.uid] = pose.at
	check(positions[1] == Vector2(62, -35), "Wheel first cabin original anchor")
	check(positions[2] == Vector2(62, 1), "Wheel second cabin original anchor")
	wheel.phase_t = 0.2
	poses = Layers.passenger_poses(view, wheel)
	for pose in poses:
		if int(pose.uid) == 1:
			check(pose.at == positions[2], "Wheel occupants rotate between cabins after two sprite phases")
	check(Layers._ride_cells(view, wheel).size() == 9, "Complete original ride footprint")
	print("LAYERS OK: %d checks across original rider cycles" % checks)
	quit(0)
