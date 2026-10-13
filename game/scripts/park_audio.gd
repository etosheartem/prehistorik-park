extends Node
## Local original MIDI music and short synthesized effects; independent volume controls.

const MUSIC_STREAM = preload("res://assets/audio/entry.ogg")
const SOUNDS := {
	"click": preload("res://assets/audio/click.wav"),
	"build": preload("res://assets/audio/build.wav"),
	"demolish": preload("res://assets/audio/demolish.wav"),
	"coin": preload("res://assets/audio/coin.wav"),
	"error": preload("res://assets/audio/error.wav"),
	"notification": preload("res://assets/audio/notification.wav"),
	"success": preload("res://assets/audio/success.wav"),
}
const ALIASES := {"select": "click", "confirm": "click", "cancel": "click", "rotate": "click", "hire": "coin", "delete": "demolish", "remove": "demolish", "place": "build", "warning": "notification", "win": "success"}
const VOICES := 6

var music: AudioStreamPlayer
var voices: Array[AudioStreamPlayer] = []
var music_volume := 0.35
var effects_volume := 0.65
var suspended := false
var closed := false
var next_voice := 0
var last_effect_ms: Dictionary = {}

func _ready() -> void:
	process_mode = Node.PROCESS_MODE_ALWAYS
	_initialize()
	_apply_volumes()

func _initialize() -> void:
	if is_instance_valid(music) or closed:
		return
	music = AudioStreamPlayer.new()
	music.name = "OriginalMusic"
	music.stream = MUSIC_STREAM.duplicate()
	(music.stream as AudioStreamOggVorbis).loop = true
	add_child(music)
	for index in VOICES:
		var player := AudioStreamPlayer.new()
		player.name = "Effect%d" % index
		add_child(player)
		voices.append(player)

func configure(values: Dictionary) -> void:
	music_volume = _volume(values.get("music", values.get("music_volume", music_volume)), music_volume)
	effects_volume = _volume(values.get("effects", values.get("effects_volume", effects_volume)), effects_volume)
	if is_inside_tree():
		_initialize()
		_apply_volumes()

func _volume(value: Variant, fallback: float) -> float:
	if not (value is float or value is int):
		return fallback
	var number := float(value)
	return clampf(number, 0.0, 1.0) if is_finite(number) else fallback

func _apply_volumes() -> void:
	if closed or not is_instance_valid(music):
		return
	music.volume_db = linear_to_db(maxf(music_volume, 0.0001))
	music.stream_paused = suspended or music_volume <= 0.0
	if not music.playing and not suspended and music_volume > 0.0:
		music.play()
	for player in voices:
		player.volume_db = linear_to_db(maxf(effects_volume, 0.0001)) - 4.0
		if effects_volume <= 0.0:
			player.stop()

func effect(effect_name: String) -> void:
	if closed or suspended or effects_volume <= 0.0 or not is_inside_tree():
		return
	_initialize()
	var resolved: String = ALIASES.get(effect_name, effect_name)
	if not SOUNDS.has(resolved):
		return
	var now := Time.get_ticks_msec()
	# Dragging paths must not turn a burst of building events into a loud stack.
	if now - int(last_effect_ms.get(resolved, -1000)) < 65:
		return
	last_effect_ms[resolved] = now
	var player := voices[next_voice]
	next_voice = (next_voice + 1) % voices.size()
	player.stop()
	player.stream = SOUNDS[resolved]
	player.volume_db = linear_to_db(maxf(effects_volume, 0.0001)) - 4.0
	player.play()

func suspend(value: bool) -> void:
	suspended = value
	if closed:
		return
	if value:
		for player in voices:
			player.stop()
	_apply_volumes()

func shutdown() -> void:
	closed = true
	if is_instance_valid(music):
		music.stop()
	for player in voices:
		player.stop()

func _notification(what: int) -> void:
	if what == NOTIFICATION_APPLICATION_PAUSED:
		suspend(true)
	elif what == NOTIFICATION_APPLICATION_RESUMED:
		suspend(false)

func _exit_tree() -> void:
	shutdown()
