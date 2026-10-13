extends Control
## Gentle full-screen shading keeps title and controls readable over the key art.
func _ready() -> void:
	mouse_filter = MOUSE_FILTER_IGNORE
	resized.connect(queue_redraw)
func _draw() -> void:
	var top := Color(0.08, 0.19, 0.13, 0.18)
	var clear := Color(0.04, 0.12, 0.09, 0.0)
	var bottom := Color(0.04, 0.12, 0.09, 0.60)
	draw_polygon(PackedVector2Array([Vector2.ZERO, Vector2(size.x, 0), Vector2(size.x, size.y * 0.3), Vector2(0, size.y * 0.3)]), PackedColorArray([top, top, clear, clear]))
	draw_polygon(PackedVector2Array([Vector2(0, size.y * 0.5), Vector2(size.x, size.y * 0.5), size, Vector2(0, size.y)]), PackedColorArray([clear, clear, bottom, bottom]))
