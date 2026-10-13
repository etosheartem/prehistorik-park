extends Control
## Feather the existing illustration into the locally drawn menu backdrop.
func _ready() -> void:
	mouse_filter = MOUSE_FILTER_IGNORE
	resized.connect(queue_redraw)
func color_at(y: float) -> Color:
	return Color("3b7253").lerp(Color("203c31"), clampf((global_position.y + y) / get_viewport_rect().size.y, 0, 1))
func _draw() -> void:
	var upper := color_at(0)
	var lower := color_at(size.y)
	var a := color_at(90)
	var b := color_at(size.y - 130)
	a.a = 0
	b.a = 0
	draw_polygon(PackedVector2Array([Vector2.ZERO, Vector2(size.x, 0), Vector2(size.x, 90), Vector2(0, 90)]), PackedColorArray([upper, upper, a, a]))
	draw_polygon(PackedVector2Array([Vector2(0, size.y - 130), Vector2(size.x, size.y - 130), size, Vector2(0, size.y)]), PackedColorArray([b, b, lower, lower]))
