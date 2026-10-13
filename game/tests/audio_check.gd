extends SceneTree

const ParkAudio = preload("res://scripts/park_audio.gd")
var checks := 0

func _initialize() -> void:
	call_deferred("run")

func expect(value: bool, message: String) -> void:
	checks += 1
	if not value:
		push_error(message)
		quit(1)

func run() -> void:
	var audio := ParkAudio.new()
	audio.configure({"music": 0.4, "effects": 0.8})
	root.add_child(audio)
	await process_frame
	expect(audio.music.playing, "Music begins after entering the tree")
	expect(audio.music.stream.loop, "Original theme loops")
	expect(audio.voices.size() == 6, "Bounded effect pool")
	expect(is_equal_approx(audio.music.volume_db, linear_to_db(0.4)), "Independent music volume")
	expect(is_equal_approx(audio.voices[0].volume_db, linear_to_db(0.8) - 4.0), "Independent effect volume")
	audio.effect("click")
	expect(audio.next_voice == 1, "Effect plays through pool")
	audio.effect("select")
	expect(audio.next_voice == 1, "Aliases share spam suppression")
	audio.effect("missing")
	expect(audio.next_voice == 1, "Unknown effect does not consume a voice")
	audio.effect("build")
	expect(audio.next_voice == 2, "Independent sound can overlap")
	audio.suspend(true)
	expect(audio.music.stream_paused, "Suspension pauses music without rewinding")
	for player in audio.voices:
		expect(not player.playing, "Suspension clears effect tails")
	audio.effect("coin")
	expect(audio.next_voice == 2, "Suspended effects remain silent")
	audio.configure({"music": 1.5, "effects": -1.0})
	expect(audio.music_volume == 1.0 and audio.effects_volume == 0.0, "Volume values are clamped")
	expect(audio.music.stream_paused, "Settings update respects suspension")
	audio.configure({"music": NAN, "effects": "invalid"})
	expect(audio.music_volume == 1.0 and audio.effects_volume == 0.0, "Malformed settings preserve last valid values")
	audio.suspend(false)
	expect(not audio.music.stream_paused and audio.music.playing, "Resuming restores music")
	audio.effect("coin")
	expect(audio.next_voice == 2, "Zero effects volume is silent")
	audio.configure({"music_volume": 0.0, "effects_volume": 0.5})
	expect(audio.music.stream_paused, "Music can be muted separately")
	audio.effect("hire")
	expect(audio.next_voice == 3, "Effects remain enabled when music is muted")
	audio.configure({"music": 0.35})
	expect(not audio.music.stream_paused and audio.music.playing, "Music continues after unmuting")
	var manifest: Dictionary = JSON.parse_string(FileAccess.get_file_as_string("res://assets/audio/manifest.json"))
	expect(manifest.api_calls == 0 and manifest.cost_usd == 0, "No audio API expenses")
	expect(manifest.effects.size() == 7, "Seven local effects")
	for name in manifest.effects:
		var entry: Dictionary = manifest.effects[name]
		expect(ResourceLoader.exists("res://assets/audio/" + entry.file), "Effect resource exists: " + name)
		expect(float(entry.peak_dbfs) < -1.0, "Effect retains headroom: " + name)
	audio.shutdown()
	expect(not audio.music.playing, "Shutdown stops music")
	audio.suspend(false)
	audio.configure({"music": 1.0, "effects": 1.0})
	audio.effect("success")
	expect(not audio.music.playing and audio.next_voice == 3, "Shutdown is final")
	audio.queue_free()
	# Let the audio thread release stopped playbacks before the headless process exits.
	await create_timer(0.15).timeout
	print("AUDIO OK: %d checks" % checks)
	quit()
