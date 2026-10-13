extends SceneTree
## Graphics modes must switch only presentation, never the saved park. This runs
## headless too; --screenshots=DIR additionally proves real renderer isolation.
const Graphics = preload("res://scripts/park_graphics.gd")
const Store = preload("res://scripts/park_store.gd")
const Sim = preload("res://scripts/park_sim.gd")
const ParkView = preload("res://scripts/park_view.gd")
const MenuFx = preload("res://scripts/park_menu_fx.gd")

var checks := 0
var failures: Array[String] = []
var screenshots := ""
var require_upscale := false

func check(value: bool, message: String) -> void:
	checks += 1
	if not value:
		failures.append(message)
		printerr("GRAPHICS FAIL: " + message)

func _initialize() -> void:
	for arg in OS.get_cmdline_user_args():
		if arg.begins_with("--screenshots="): screenshots = arg.trim_prefix("--screenshots=")
		if arg == "--require-upscale": require_upscale = true
	run.call_deferred()

func run() -> void:
	check(Graphics.IDS.size() == 4 and Graphics.LABELS.size() == 4, "four explicit graphics modes")
	check(Graphics.normalize(null) == "original_upscaled", "default uses original upscale")
	check(Graphics.normalize("economy") == "original", "legacy economy keeps original art")
	for old in ["high", "maximum", "bogus"]:
		check(Graphics.normalize(old) == "original_upscaled", "legacy or invalid mode starts with original upscale: " + old)
	var settings_path := "user://graphics_test_%d.json" % OS.get_process_id()
	for mode in Graphics.IDS + ["economy", "high", "maximum"]:
		check(Store.save_settings(settings_path, {"quality": mode, "music": 0.17, "effects": 0.83, "debug": false}), "save graphics setting " + mode)
		var settings := Store.settings(settings_path)
		check(settings.quality == Graphics.normalize(mode), "migrate / roundtrip graphics mode " + mode)
		check(is_equal_approx(settings.music, 0.17) and is_equal_approx(settings.effects, 0.83), "migration retains both volumes " + mode)
	for ending in ["", ".bak", ".tmp"]: DirAccess.remove_absolute(settings_path + ending)
	check(Store.settings(settings_path).quality == Graphics.DEFAULT, "first launch default")
	var bad := {"res://assets/original/tiles/test.png": {"path": "res://assets/hd/terrain/grass.png"},
		"res://assets/original/tiles/test2.png": {"path": "res://assets/upscaled/../hd/terrain/grass.png"}}
	check(Graphics._filtered("original_upscaled", bad).is_empty(), "upscaled manifest rejects remake and traversal")
	check(Graphics._filtered("original_upscaled", {"1:0:0:0:4:4": bad.values()[0]}, true).is_empty(), "upscaled parts reject remake")
	check(Graphics.load_manifest("original").is_empty() and Graphics.load_part_manifest("original").is_empty(), "original has no replacement manifests")
	check(Graphics.menu_path("original") == "res://assets/original/ui/splash2.png", "original menu image")
	check(not Graphics.menu_path("original_upscaled").contains("/hd/"), "upscaled menu cannot use remake")
	check(Graphics.menu_path("remake_medium").ends_with("menu_portrait_hd.png"), "medium menu source is HD")
	check(Graphics.menu_path("remake_maximum").ends_with("menu_portrait.png"), "maximum menu source is 4K")
	check(Graphics.effects_level("original") == 0 and Graphics.effects_level("original_upscaled") == 0, "source styles exclude remake effects")
	check(Graphics.effects_level("remake_medium") == 1 and Graphics.effects_level("remake_maximum") == 2, "remake effects have distinct settings")
	check(Graphics.texture_filter("original") == CanvasItem.TEXTURE_FILTER_NEAREST, "original uses crisp pixel filtering")
	check(Graphics.msaa("remake_medium") == Viewport.MSAA_2X and Graphics.msaa("remake_maximum") == Viewport.MSAA_4X, "remake antialiasing levels differ")
	check(Graphics.font_path("original") == "res://assets/original/fonts/original.fnt", "original retains bitmap source font")
	check(not Graphics.font_path("original_upscaled").contains("/hd/"), "upscaled font excludes remake resources")
	var viewport := SubViewport.new()
	viewport.size = Vector2i(1080, 1920)
	viewport.render_target_update_mode = SubViewport.UPDATE_ALWAYS
	root.add_child(viewport)
	var sim := Sim.new()
	var fixture := "../art/review/acceptance_park.json"
	if FileAccess.file_exists(fixture):
		check(sim.restore(Store.read_json(fixture)), "render fixture restores")
	else:
		sim.new_game(-1, 0, 1234)
	var snapshot := JSON.stringify(sim.snapshot())
	var view := ParkView.new()
	view.sim = sim
	view.size = Vector2(1080, 1920)
	viewport.add_child(view)
	var fx := MenuFx.new()
	viewport.add_child(fx)
	await process_frame
	view.center_park()
	var modes := ["remake_maximum", "original", "original_upscaled", "remake_medium", "original"]
	for mode in modes:
		view.textures["test://previous-style"] = null
		view.bursts.append({"cell": Vector2i.ZERO, "born": 0.0, "demolition": false})
		view.configure(mode)
		fx.configure(mode)
		check(view.quality == mode, "view adopts " + mode)
		check(view.textures.is_empty() and view.bursts.is_empty(), "switch releases all cached textures and particles: " + mode)
		check(fx.quality == mode, "menu effect switches " + mode)
		check(snapshot == JSON.stringify(sim.snapshot()), "switch preserves entire park including RNG: " + mode)
		for id in [14, 22]:
			var item: Dictionary = view.art.scenery[id]
			if Graphics.is_remake(mode):
				check(str(item.frames[0].path).ends_with(".svg"), "remake retains its repaired dormant booth " + str(id))
			else:
				check(item.frames == item.source_variants.working, "source mode restores original dormant object frame " + str(id))
				check(item.variants == item.source_variants, "source mode restores all original dormant object states " + str(id))
				check(not item.has("local_repair"), "source mode has no local SVG repair metadata " + str(id))
				for frames in item.variants.values():
					for frame in frames:
						check(str(frame.path).ends_with(".png"), "source dormant state excludes invented SVG")
		check(str(view.source_art.scenery[14].frames[0].path).ends_with(".svg"), "source metadata stays immutable across switches")
		var atlas_path := "res://assets/original/packs/gpack1_2.png"
		var atlas: Texture2D = view.texture_for(atlas_path)
		check(atlas != null, "atlas resolves " + mode)
		for path in view.hd:
			var entry = view.hd[path]
			var replacement := Graphics.replacement_path(entry)
			check(replacement.begins_with(Graphics.asset_root(mode)), "frame source belongs to mode: " + replacement)
			check(ResourceLoader.exists(replacement), "replacement texture exists: " + replacement)
		for key in view.part_overrides:
			var path := Graphics.replacement_path(view.part_overrides[key])
			check(path.begins_with(Graphics.asset_root(mode)) and ResourceLoader.exists(path), "part source belongs to mode and exists: " + path)
		if mode == "original_upscaled" and require_upscale:
			check(Graphics.font_path(mode).begins_with(Graphics.UPSCALED_ROOT), "GPU-upscaled source font was installed")
			check(not view.hd.is_empty(), "GPU-upscaled manifest was installed")
			check(view.hd.has(atlas_path), "upscaled atlas is available for gates / fences / cropped heads")
			check(atlas.get_size().x > view._texture(atlas_path).get_size().x, "upscaled atlas has more source pixels")
			for path in _frame_paths(view.art):
				# Ride/scenery animation bodies use atlas command lists, not 1209
				# independently upscaled pictures. First frames also serve the catalog.
				check(view.hd.has(path), "upscaled standalone frame or catalog preview exists: " + path)
			for key in _required_part_keys(view):
				check(view.part_overrides.has(key), "independent GPU texture covers every live crop: " + key)
				if not view.part_overrides.has(key): continue
				var path := Graphics.replacement_path(view.part_overrides[key])
				check(path.begins_with("res://assets/upscaled/parts/"), "live crop has no adjacent atlas sprites in its mipmaps: " + key)
				var texture: Texture2D = view._texture(path)
				var dimensions := str(key).split(":")
				check(texture != null and texture.get_size() == Vector2(float(dimensions[4]), float(dimensions[5])) * 4, "isolated crop retains source rectangle dimensions: " + key)
		# The explicit atlas lookup above is a contract check, not a rendering
		# requirement. Remove it so the following audit catches any actual world
		# renderer falling back to a neighbouring sprite's atlas mipmaps.
		view.textures.clear()
		view.queue_redraw()
		await process_frame
		await process_frame
		if DisplayServer.get_name() != "headless":
			await RenderingServer.frame_post_draw
			for cached in view.textures:
				if not Graphics.is_remake(mode):
					check(not str(cached).contains("/hd/"), "actual render loads no remake texture: " + str(cached))
				if mode == "original_upscaled" and require_upscale:
					check(not str(cached).contains("/packs/"), "actual upscaled world uses isolated textures: " + str(cached))
			if not screenshots.is_empty():
				DirAccess.make_dir_recursive_absolute(screenshots)
				check(viewport.get_texture().get_image().save_png(screenshots.path_join(mode + ".png")) == OK, "capture " + mode)
	view.queue_free()
	fx.queue_free()
	await process_frame
	viewport.queue_free()
	await process_frame
	if failures.is_empty(): print("GRAPHICS OK: %d checks across four isolated modes" % checks)
	else: printerr("GRAPHICS: %d failed of %d checks" % [failures.size(), checks])
	quit(0 if failures.is_empty() else 1)

func _frame_paths(art: Dictionary) -> Array[String]:
	var unique := {}
	for actor in art.actors:
		for animation in actor.animations.values():
			for frame in animation.frames: unique[str(frame.path)] = true
	for tile in art.tiles.values():
		if tile is Dictionary and tile.has("path"): unique[str(tile.path)] = true
	for group in [art.rides, art.scenery]:
		for item in group:
			if not item.frames.is_empty(): unique[str(item.frames[0].path)] = true
	unique["res://assets/original/ui/splash2.png"] = true
	var result: Array[String] = []
	for path in unique: result.append(path)
	return result

func _required_part_keys(view) -> Array[String]:
	var required := {}
	var commands: Dictionary = Store.read_json("res://assets/original/commands.json")
	for frames in commands.rides:
		for frame in frames:
			for command in frame:
				if int(command[0]) == 0: _remember_part(required, command.slice(1, 7))
	for variants in commands.scenery:
		for frames in variants.values():
			for frame in frames:
				for command in frame:
					if int(command[0]) == 0: _remember_part(required, command.slice(1, 7))
	for edge in view.art.tiles.edges:
		_remember_part(required, [1, 2] + edge.rect)
	var tables: Array = view.sim.data.tables
	for actor in 8:
		for pose in 4:
			var offset := actor * 24 + pose * 6
			_remember_part(required, [0, actor] + tables[0].slice(offset, offset + 4))
	_remember_part(required, [1] + tables[75].slice(0, 5))
	for extra in [[1, 1, 40, 0, 12, 9], [1, 6, 0, 112, 15, 12], [1, 2, 90, 83, 15, 20], [1, 2, 105, 84, 18, 13]]:
		_remember_part(required, extra)
	var result: Array[String] = []
	for key in required: result.append(key)
	return result

func _remember_part(required: Dictionary, rectangle: Array) -> void:
	if int(rectangle[4]) <= 0 or int(rectangle[5]) <= 0: return
	required["%d:%d:%d:%d:%d:%d" % rectangle] = true
