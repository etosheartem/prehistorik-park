extends Control
## Original J2ME menu ornaments and colours, arranged for a tall touch screen.
const Graphics = preload("res://scripts/park_graphics.gd")
var quality := Graphics.DEFAULT
var resources := {}
var manifest := {}
var fragments := {}
var configured := false

func _ready() -> void:
	mouse_filter = MOUSE_FILTER_IGNORE

func configure(mode: String) -> void:
	if configured and quality == mode: return
	configured = true
	quality = mode
	manifest = Graphics.load_manifest(mode)
	resources.clear()
	fragments.clear()
	texture_filter = Graphics.texture_filter(mode)
	queue_redraw()

func texture(path: String) -> Texture2D:
	if not resources.has(path):
		var entry = manifest.get(path, {})
		var actual: String = entry.get("path", path) if entry is Dictionary else str(entry)
		resources[path] = load(actual if ResourceLoader.exists(actual) else path)
	return resources[path]

func fragment(path: String, source: Rect2, target: Rect2, flip_vertical := false) -> void:
	# Isolate each atlas fragment before mipmapping. A UV rectangle on the whole
	# leaf sheet samples the next row of leaves at its transparent lower edge.
	var key := path + str(source) + str(flip_vertical)
	if not fragments.has(key):
		var tex := texture(path)
		var original: Texture2D = load(path)
		var ratio := tex.get_size() / original.get_size()
		var pixels := tex.get_image().get_region(Rect2i(source.position * ratio, source.size * ratio))
		pixels.clear_mipmaps()
		if quality != "original":
			# The upscaled atlas alpha was filtered across neighbouring sprites.
			# Rebuild alpha from this isolated native crop to remove those fringes.
			var mask := original.get_image().get_region(Rect2i(source))
			mask.clear_mipmaps()
			mask.resize(pixels.get_width(), pixels.get_height(), Image.INTERPOLATE_LANCZOS)
			mask.convert(Image.FORMAT_RGBA8)
			pixels.convert(Image.FORMAT_RGBA8)
			var color_bytes := pixels.get_data()
			var mask_bytes := mask.get_data()
			for byte_index in range(3, color_bytes.size(), 4): color_bytes[byte_index] = mask_bytes[byte_index]
			pixels = Image.create_from_data(pixels.get_width(), pixels.get_height(), false, Image.FORMAT_RGBA8, color_bytes)
		if flip_vertical: pixels.flip_y()
		if quality != "original": pixels.generate_mipmaps()
		fragments[key] = ImageTexture.create_from_image(pixels)
	draw_texture_rect(fragments[key], target, false)

func _draw() -> void:
	if Graphics.is_remake(quality):
		_draw_remake_backdrop()
		return
	var scale_value := size.x / 240.0
	var top_color := Color8(105, 168, 255)
	var ground_color := Color8(16, 94, 0)
	for band in 80:
		var y := size.y * band / 80.0
		var blend := clampf((float(band) / 80 - 0.4) / 0.3, 0, 1)
		draw_rect(Rect2(0, y, size.x, size.y / 80 + 1), top_color.lerp(ground_color, blend))
	var stone := "res://assets/original/packs/gpack2_4.png"
	var leaves := "res://assets/original/packs/gpack2_5.png"
	for index in ceili(size.y / (42 * scale_value)):
		var y := (38 + index * 42) * scale_value
		# A straight mirrored repeat joins identical edge rows, without ledges.
		fragment(stone, Rect2(14, 0, 22, 42), Rect2(0, y, 22 * scale_value, 42 * scale_value), index % 2 == 1)
		fragment(stone, Rect2(0, 0, 22, 42), Rect2(size.x - 22 * scale_value, y, 22 * scale_value, 42 * scale_value), index % 2 == 1)
	fragment(leaves, Rect2(0, 0, 74, 100), Rect2(0, -15 * scale_value, 74 * scale_value, 100 * scale_value))
	fragment(leaves, Rect2(0, 100, 60, 60), Rect2(74 * scale_value, -15 * scale_value, 60 * scale_value, 60 * scale_value))
	fragment(leaves, Rect2(72, 0, 74, 100), Rect2(size.x - 74 * scale_value, -15 * scale_value, 74 * scale_value, 100 * scale_value))
	fragment(leaves, Rect2(86, 100, 60, 60), Rect2(size.x - 134 * scale_value, -15 * scale_value, 60 * scale_value, 60 * scale_value))

func _draw_remake_backdrop() -> void:
	# A quiet locally drawn landscape frames the existing painted illustration.
	# No source-style pixel ornaments are mixed into the remake menu.
	for band in 64:
		var t := float(band) / 63.0
		var color := Color("3b7253").lerp(Color("203c31"), t)
		draw_rect(Rect2(0, size.y * t, size.x, size.y / 63.0 + 1), color)
	for side in [-1, 1]:
		var corner := Vector2(0 if side == -1 else size.x, 0)
		for index in 5:
			var direction := Vector2(-side * (100 + index * 38), 70 + index * 42)
			var poly := PackedVector2Array([corner, corner + direction * Vector2(0.8, 0.5), corner + direction, corner + direction * Vector2(0.28, 0.85)])
			draw_colored_polygon(poly, Color("29583e") if index % 2 == 0 else Color("306649"))
	for index in 4:
		var y := size.y - 90 + index * 25
		var poly := PackedVector2Array([Vector2(0,y), Vector2(size.x*0.32,y-35), Vector2(size.x*0.7,y+15), Vector2(size.x,y-45), Vector2(size.x,size.y), Vector2(0,size.y)])
		draw_colored_polygon(poly, Color("294b35").darkened(index * 0.05))
