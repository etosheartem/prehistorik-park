extends RefCounted
## Shared touch geometry; local vector stone, timber and amber surfaces.
const CREAM := Color("493623")
const MUTED := Color("786044")
const GOLD := Color("9a591e")
const GREEN := Color("ead3a1")
const DEEP := Color("f7e9c5")
const EDGE := Color("b59863")
const ACCENT := Color("f4c56b")
const INK := Color("493623")
const LIGHT := Color("fff1cd")
const ROOT := "res://assets/ui/crafted/"

static func box(fill := GREEN, edge := EDGE, margin := 20) -> StyleBoxFlat:
	var style := StyleBoxFlat.new()
	style.bg_color = fill
	style.border_color = edge
	style.set_border_width_all(2)
	style.set_corner_radius_all(8)
	style.set_content_margin_all(margin)
	return style

static func surface(name: String, margin := 24) -> StyleBoxTexture:
	var style := StyleBoxTexture.new()
	style.texture = load(ROOT + name + ".svg")
	for side in [SIDE_LEFT, SIDE_TOP, SIDE_RIGHT, SIDE_BOTTOM]:
		style.set_texture_margin(side, 30)
		style.set_content_margin(side, margin)
	return style

static func icon(name: String) -> Texture2D:
	return load(ROOT + name + ".svg")

static func selected(button: Button, active: bool) -> void:
	button.theme_type_variation = "PrimaryButton" if active else "Button"
	button.set_meta("active", active)

static func make(mode := "original_upscaled") -> Theme:
	var result := Theme.new()
	result.default_font = load("res://assets/ui/fonts/NotoSans-Regular.ttf")
	result.default_font_size = 28
	result.set_color("font_color", "Label", INK)
	result.set_constant("line_spacing", "Label", 4)
	result.set_type_variation("Heading", "Label")
	result.set_font("font", "Heading", load("res://assets/ui/fonts/NotoSerif-Bold.ttf") if mode.begins_with("remake") else load("res://assets/ui/fonts/NotoSans-Bold.ttf"))
	for type in ["Button", "PrimaryButton", "DangerButton", "CatalogCard", "QuietButton"]:
		if type != "Button": result.set_type_variation(type, "Button")
		var paper: bool = type in ["CatalogCard", "QuietButton"]
		var primary: bool = type == "PrimaryButton"
		var normal := "paper" if paper else "amber" if primary else "danger" if type == "DangerButton" else "wood"
		for state in ["normal", "hover", "pressed", "disabled"]:
			var skin := normal
			if state == "disabled": skin = "disabled"
			elif state == "pressed": skin = "amber_down"
			elif state == "hover": skin = "amber" if paper or primary else "wood_hover"
			result.set_stylebox(state, type, surface(skin, 18))
			result.set_color("font_color" if state == "normal" else "font_" + state + "_color", type, MUTED if state == "disabled" else INK if paper or primary or state == "pressed" else LIGHT)
		result.set_font("font", type, load("res://assets/ui/fonts/NotoSans-Bold.ttf"))
		result.set_constant("h_separation", type, 16)
		result.set_constant("icon_max_width", type, 42)
		var focus := box(Color.TRANSPARENT, Color("b57527"), 0)
		focus.set_border_width_all(4)
		result.set_stylebox("focus", type, focus)
	result.set_stylebox("panel", "PanelContainer", surface("stone", 28))
	result.set_type_variation("PaperPanel", "PanelContainer")
	result.set_stylebox("panel", "PaperPanel", surface("paper", 22))
	result.set_type_variation("WoodPanel", "PanelContainer")
	result.set_stylebox("panel", "WoodPanel", surface("wood", 20))
	result.set_stylebox("background", "ProgressBar", box(Color("d0bc8c"), EDGE, 0))
	result.set_stylebox("fill", "ProgressBar", box(Color("6d9145"), Color("597f35"), 0))
	var track := box(Color("bca678"), Color("9c8257"), 0)
	track.content_margin_top = 7
	track.content_margin_bottom = 7
	result.set_stylebox("slider", "HSlider", track)
	result.set_stylebox("grabber_area", "HSlider", box(Color("dca448"), Color("a67531"), 0))
	result.set_stylebox("grabber_area_highlight", "HSlider", box(ACCENT, GOLD, 0))
	result.set_icon("grabber", "HSlider", icon("knob"))
	result.set_icon("grabber_highlight", "HSlider", icon("knob"))
	result.set_constant("grabber_offset", "HSlider", 0)
	for type in ["VScrollBar", "HScrollBar"]:
		result.set_stylebox("scroll", type, box(Color("d7c398"), Color.TRANSPARENT, 4))
		for state in ["grabber", "grabber_highlight", "grabber_pressed"]:
			result.set_stylebox(state, type, box(Color("9e794c"), Color.TRANSPARENT, 5))
	result.set_color("font_color", "CheckButton", INK)
	result.set_stylebox("normal", "CheckButton", surface("paper", 14))
	result.set_stylebox("hover", "CheckButton", surface("paper", 14))
	result.set_stylebox("pressed", "CheckButton", surface("amber", 14))
	result.set_constant("h_separation", "CheckButton", 16)
	result.set_stylebox("normal", "LineEdit", surface("paper", 20))
	result.set_stylebox("read_only", "LineEdit", surface("disabled", 20))
	result.set_stylebox("focus", "LineEdit", box(Color.TRANSPARENT, GOLD, 0))
	result.set_color("font_color", "LineEdit", INK)
	result.set_color("font_placeholder_color", "LineEdit", MUTED)
	result.set_color("caret_color", "LineEdit", INK)
	result.set_color("selection_color", "LineEdit", ACCENT)
	result.set_color("font_selected_color", "LineEdit", INK)
	result.set_color("clear_button_color", "LineEdit", MUTED)
	return result
