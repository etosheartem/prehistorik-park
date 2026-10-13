extends Control
const Graphics = preload("res://scripts/park_graphics.gd")
## Tiny leaves and warm motes; kept separate from the painted menu and UI.
var elapsed := 0.0
var motion_enabled := true
var quality := Graphics.DEFAULT:
	set(value):
		quality = Graphics.normalize(value)
		queue_redraw()

func configure(mode: String) -> void:
	quality = mode

func _ready() -> void:
	mouse_filter = MOUSE_FILTER_IGNORE

func _process(dt: float) -> void:
	if not visible or not motion_enabled or Graphics.effects_level(quality) == 0: return
	elapsed += dt
	queue_redraw()

func _draw() -> void:
	if not motion_enabled or Graphics.effects_level(quality) == 0: return
	for i in 15 if Graphics.effects_level(quality) == 2 else 6:
		var t := elapsed * (0.12 + i * 0.002) + i * 2.67
		var at := Vector2(fposmod(i * 191.0 + elapsed * 8 + sin(t) * 35, size.x + 40) - 20, size.y * (0.47 + fposmod(i * 0.073, 0.22)) + sin(t * 0.7) * 28)
		var strength := 0.22 + 0.14 * sin(t * 2)
		draw_circle(at, 7, Color(1, 0.86, 0.39, strength * 0.15), true, -1, true)
		draw_circle(at, 2.2, Color(1, 0.92, 0.57, strength), true, -1, true)
