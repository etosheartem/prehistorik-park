extends Control

const Sim = preload("res://scripts/park_sim.gd")
const ParkView = preload("res://scripts/park_view.gd")
const ParkAudio = preload("res://scripts/park_audio.gd")
const OriginalMenu = preload("res://scripts/park_original_menu.gd")
const HomeBlend = preload("res://scripts/park_home_blend.gd")
const MenuFx = preload("res://scripts/park_menu_fx.gd")
const MiniMap = preload("res://scripts/park_minimap.gd")
const Store = preload("res://scripts/park_store.gd")
const Graphics = preload("res://scripts/park_graphics.gd")
const Preferences = preload("res://scripts/park_preferences.gd")
const ArtTheme = preload("res://scripts/park_theme.gd")

var sim = Sim.new()
var view: Control
var sound: Node
var settings := {}
var settings_tab := "graphics"
var remake_quality := "remake_maximum"
var catalog_query := ""
var catalog_search: LineEdit
var keyboard_pixels := 0
var save_status: Label
var last_save_ok := true
var pending_import := {}
var data_notice := ""
var save_path := "user://park.json"
var settings_path := "user://settings.json"
var persistence_enabled := true
var running := false
var suspended := false
var speed := 1
var page := "home"
var modal: Control
var modal_shade: ColorRect
var home_title: Label
var home_subtitle: Label
var modal_panel: PanelContainer
var modal_body: VBoxContainer
var original_menu: Control
var home_background: TextureRect
var home_blend: Control
var menu_fx: Control
var hud: Control
var top: PanelContainer
var bottom: PanelContainer
var toolbar_grid: GridContainer
var zoom_controls: HBoxContainer
var catalog_panel: PanelContainer
var catalog_row: GridContainer
var catalog_scroll: ScrollContainer
var catalog_tabs: HBoxContainer
var catalog_heading: Label
var catalog_filter: CheckButton
var catalog_count: Label
var catalog_notice: Label
var catalog_available := false
var sheet_shade: ColorRect
var inspector_title: Label
var inspector_tabs: HBoxContainer
var inspector_scroll: ScrollContainer
var panel_mode := ""
var placement_panel: PanelContainer
var placement_body: VBoxContainer
var nav_buttons: Dictionary = {}
var inspector: PanelContainer
var inspector_body: VBoxContainer
var message_label: Label
var stats_label: Label
var building_status_label: Label
var building_details_label: Label
var selected_guest := -1
var guest_state_label: Label
var guest_needs_labels: Array[Label] = []
var tutorial_label: Label
var speed_button: Button
var save_timer := 0.0
var hud_timer := 0.0
var message_time := 0.0
var last_messages := 0
var last_message_text := ""
var tool_kind := "select"
var tool_id := 0
var moving_worker_uid := -1
var staff_tab := "team"
const STAFF_JOBS := ["Выбери дорожку для начала патруля", "Выбери дорожку: дальше сам ходит к поломкам", "Кафе · один повар на каждое кафе", "Закусочные, мороженое и шарики · один продавец на лавку", "Медпункт · один шаман на палатку", "Диномотор · один погонщик на мотор"]
var build_rotation := 0
var build_cell := Vector2i(-1, -1)
var selected_uid := -1
var chosen_scenario := 0
var chosen_difficulty := 0
var text_data: Dictionary
var result_shown := false
var catalog_category := ""
var catalog_positions := {}
var applied_quality := ""
var modal_scroll: ScrollContainer
var home_footer: Label
var title_board: PanelContainer
var pending_demolition := Vector2i(-1, -1)
var demolition_return := ""
var toast_panel: PanelContainer
var home_has_save := false
var _layout_queued := false

func _ready() -> void:
	settings = Store.settings(settings_path)
	theme = ArtTheme.make(str(settings.quality))
	text_data = JSON.parse_string(FileAccess.get_file_as_string("res://assets/data/texts.json"))
	sound = ParkAudio.new()
	add_child(sound)
	sound.configure(settings)
	view = ParkView.new()
	add_child(view)
	view.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	view.sim = sim
	view.cell_selected.connect(_cell_selected)
	view.hover_changed.connect(_hover)
	original_menu = OriginalMenu.new()
	add_child(original_menu)
	original_menu.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	home_background = TextureRect.new()
	home_background.expand_mode = TextureRect.EXPAND_IGNORE_SIZE
	home_background.stretch_mode = TextureRect.STRETCH_KEEP_ASPECT_COVERED
	home_background.mouse_filter = MOUSE_FILTER_IGNORE
	home_background.texture_filter = CanvasItem.TEXTURE_FILTER_LINEAR_WITH_MIPMAPS
	add_child(home_background)
	home_background.set_anchors_and_offsets_preset(PRESET_TOP_LEFT)
	home_blend = HomeBlend.new()
	home_background.add_child(home_blend)
	home_blend.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	menu_fx = MenuFx.new()
	add_child(menu_fx)
	menu_fx.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	_build_hud()
	_build_modal()
	resized.connect(_layout)
	get_tree().auto_accept_quit = false
	get_tree().quit_on_go_back = false
	_apply_settings()
	show_page("home")
	_layout()

func _label(parent: Node, text: String, font_size := 28, wrap := false) -> Label:
	var label := Label.new()
	label.text = text
	if font_size >= 34: label.theme_type_variation = "Heading"
	label.add_theme_font_size_override("font_size", font_size)
	if wrap: label.autowrap_mode = TextServer.AUTOWRAP_WORD_SMART
	parent.add_child(label)
	return label

func _button(parent: Node, text: String, callback: Callable, width := 0.0) -> Button:
	var button := Button.new()
	button.mouse_filter = MOUSE_FILTER_PASS
	button.text = text
	button.custom_minimum_size = Vector2(width, 88)
	button.pressed.connect(func(): sound.effect("click"); callback.call())
	parent.add_child(button)
	return button

func _spacer(parent: Node, height := 12) -> void:
	var space := Control.new()
	space.custom_minimum_size.y = height
	parent.add_child(space)

func _clear(parent: Node) -> void:
	for child in parent.get_children():
		parent.remove_child(child)
		child.queue_free()

func _build_hud() -> void:
	hud = Control.new()
	hud.mouse_filter = MOUSE_FILTER_IGNORE
	add_child(hud)
	hud.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	top = PanelContainer.new()
	top.theme_type_variation = "WoodPanel"
	hud.add_child(top)
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 18)
	top.add_child(row)
	_button(row, "Ⅱ", func(): show_page("pause"), 88).tooltip_text = "Пауза и меню"
	stats_label = _label(row, "", 27)
	stats_label.add_theme_color_override("font_color", ArtTheme.LIGHT)
	stats_label.vertical_alignment = VERTICAL_ALIGNMENT_CENTER
	stats_label.size_flags_horizontal = SIZE_EXPAND_FILL
	speed_button = _button(row, "▶ 1×", _cycle_speed, 116)
	zoom_controls = HBoxContainer.new()
	zoom_controls.add_theme_constant_override("separation", 8)
	hud.add_child(zoom_controls)
	_button(zoom_controls, "−", func(): view.change_zoom(0.82), 72)
	_button(zoom_controls, "+", func(): view.change_zoom(1.22), 72)
	_button(zoom_controls, "К парку", func(): view.focus_activity(), 176)
	_button(zoom_controls, "Карта", func(): show_page("map"), 150)
	toast_panel = PanelContainer.new()
	toast_panel.theme_type_variation = "WoodPanel"
	toast_panel.mouse_filter = MOUSE_FILTER_IGNORE
	hud.add_child(toast_panel)
	message_label = _label(toast_panel, "", 26, true)
	message_label.add_theme_color_override("font_color", ArtTheme.LIGHT)
	message_label.add_theme_color_override("font_shadow_color", Color.BLACK)
	message_label.add_theme_constant_override("shadow_offset_x", 2)
	message_label.add_theme_constant_override("shadow_offset_y", 2)
	message_label.mouse_filter = MOUSE_FILTER_IGNORE
	tutorial_label = _label(hud, "", 25, true)
	tutorial_label.add_theme_color_override("font_color", ArtTheme.LIGHT)
	tutorial_label.mouse_filter = MOUSE_FILTER_IGNORE
	tutorial_label.add_theme_color_override("font_shadow_color", Color.BLACK)
	tutorial_label.add_theme_constant_override("shadow_offset_x", 2)
	tutorial_label.add_theme_constant_override("shadow_offset_y", 2)
	sheet_shade = ColorRect.new()
	sheet_shade.color = Color(0.13, 0.12, 0.07, 0.24)
	sheet_shade.gui_input.connect(func(event):
		if event is InputEventScreenTouch and event.pressed: _clear_selection()
		elif event is InputEventMouseButton and event.pressed: _clear_selection())
	hud.add_child(sheet_shade)
	sheet_shade.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	sheet_shade.hide()
	bottom = PanelContainer.new()
	hud.add_child(bottom)
	toolbar_grid = GridContainer.new()
	toolbar_grid.columns = 3
	toolbar_grid.add_theme_constant_override("h_separation", 10)
	bottom.add_child(toolbar_grid)
	for spec in [["Строить", "rides"], ["Персонал", "staff"], ["Парк", "stats"]]:
		var id: String = spec[1]
		var button := _button(toolbar_grid, spec[0], func(): _toolbar(id))
		button.size_flags_horizontal = SIZE_EXPAND_FILL
		button.custom_minimum_size.y = 88
		button.icon = ArtTheme.icon({"rides": "build", "staff": "staff", "stats": "park"}[id])
		button.expand_icon = true
		button.add_theme_font_size_override("font_size", 27)
		nav_buttons[id] = button
	catalog_panel = PanelContainer.new()
	hud.add_child(catalog_panel)
	var library := VBoxContainer.new()
	library.add_theme_constant_override("separation", 18)
	catalog_panel.add_child(library)
	var heading := HBoxContainer.new()
	library.add_child(heading)
	catalog_heading = _label(heading, "Постройки", 39)
	catalog_heading.size_flags_horizontal = SIZE_EXPAND_FILL
	_button(heading, "×", _clear_selection, 88).tooltip_text = "Закрыть каталог"
	catalog_tabs = HBoxContainer.new()
	catalog_tabs.add_theme_constant_override("separation", 10)
	library.add_child(catalog_tabs)
	for spec in [["Аттракционы", "rides"], ["Службы", "services"], ["Декор", "decor"], ["Дорожки", "paths"]]:
		var category: String = spec[1]
		var tab := _button(catalog_tabs, spec[0], func(): show_catalog(category))
		tab.size_flags_horizontal = SIZE_EXPAND_FILL
		tab.add_theme_font_size_override("font_size", 24)
		tab.set_meta("category", category)
	catalog_search = LineEdit.new()
	catalog_search.placeholder_text = "Найти постройку…"
	catalog_search.clear_button_enabled = true
	catalog_search.custom_minimum_size.y = 76
	catalog_search.add_theme_font_size_override("font_size", 27)
	library.add_child(catalog_search)
	catalog_search.text_changed.connect(func(value): catalog_query = value.strip_edges(); show_catalog(catalog_category, true))
	var filter_row := HBoxContainer.new()
	library.add_child(filter_row)
	catalog_count = _label(filter_row, "", 23)
	catalog_count.size_flags_horizontal = SIZE_EXPAND_FILL
	catalog_count.add_theme_color_override("font_color", ArtTheme.MUTED)
	catalog_filter = CheckButton.new()
	catalog_filter.custom_minimum_size.y = 64
	catalog_filter.text = "Только открытые"
	catalog_filter.add_theme_font_size_override("font_size", 23)
	catalog_filter.toggled.connect(func(value): catalog_available = value; show_catalog(catalog_category))
	filter_row.add_child(catalog_filter)
	catalog_notice = _label(library, "", 25, true)
	catalog_notice.add_theme_color_override("font_color", ArtTheme.GOLD)
	catalog_notice.hide()
	catalog_scroll = ScrollContainer.new()
	catalog_scroll.horizontal_scroll_mode = ScrollContainer.SCROLL_MODE_DISABLED
	catalog_scroll.size_flags_vertical = SIZE_EXPAND_FILL
	library.add_child(catalog_scroll)
	catalog_row = GridContainer.new()
	catalog_row.columns = 2
	catalog_row.size_flags_horizontal = SIZE_EXPAND_FILL
	catalog_row.add_theme_constant_override("h_separation", 16)
	catalog_row.add_theme_constant_override("v_separation", 16)
	catalog_scroll.add_child(catalog_row)
	catalog_panel.hide()
	inspector = PanelContainer.new()
	inspector.grow_vertical = GROW_DIRECTION_BEGIN
	hud.add_child(inspector)
	var details := VBoxContainer.new()
	details.add_theme_constant_override("separation", 18)
	inspector.add_child(details)
	var details_heading := HBoxContainer.new()
	details.add_child(details_heading)
	inspector_title = _label(details_heading, "", 36, true)
	inspector_title.size_flags_horizontal = SIZE_EXPAND_FILL
	_button(details_heading, "×", _clear_selection, 88).tooltip_text = "Закрыть панель"
	inspector_tabs = HBoxContainer.new()
	inspector_tabs.add_theme_constant_override("separation", 12)
	details.add_child(inspector_tabs)
	for spec in [["Показатели", "stats"], ["Цели и открытия", "goals"]]:
		var name: String = spec[1]
		var tab := _button(inspector_tabs, spec[0], func(): show_stats() if name == "stats" else show_goals())
		tab.size_flags_horizontal = SIZE_EXPAND_FILL
		tab.set_meta("page", name)
	inspector_scroll = ScrollContainer.new()
	inspector_scroll.horizontal_scroll_mode = ScrollContainer.SCROLL_MODE_DISABLED
	inspector_scroll.size_flags_vertical = SIZE_EXPAND_FILL
	details.add_child(inspector_scroll)
	inspector_body = VBoxContainer.new()
	inspector_body.size_flags_horizontal = SIZE_EXPAND_FILL
	inspector_body.add_theme_constant_override("separation", 18)
	inspector_scroll.add_child(inspector_body)
	inspector.hide()
	placement_panel = PanelContainer.new()
	placement_panel.grow_vertical = GROW_DIRECTION_BEGIN
	hud.add_child(placement_panel)
	placement_body = VBoxContainer.new()
	placement_body.add_theme_constant_override("separation", 12)
	placement_panel.add_child(placement_body)
	placement_panel.hide()
	placement_panel.minimum_size_changed.connect(func(): _layout.call_deferred())
	inspector_body.minimum_size_changed.connect(func(): _layout.call_deferred())

func _build_modal() -> void:
	modal = Control.new()
	add_child(modal)
	modal.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	modal_shade = ColorRect.new()
	modal_shade.color = Color(0.11, 0.10, 0.07, 0.62)
	modal.add_child(modal_shade)
	modal_shade.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	title_board = PanelContainer.new()
	title_board.theme_type_variation = "WoodPanel"
	title_board.mouse_filter = MOUSE_FILTER_IGNORE
	modal.add_child(title_board)
	home_title = _label(title_board, "ПЕРВОБЫТНЫЙ\nПАРК", 84, true)
	home_title.add_theme_font_override("font", preload("res://assets/original/fonts/original.fnt"))
	home_title.add_theme_color_override("font_color", Color.WHITE)
	home_title.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	home_title.vertical_alignment = VERTICAL_ALIGNMENT_CENTER
	home_title.mouse_filter = MOUSE_FILTER_IGNORE
	home_subtitle = _label(modal, "Большие идеи каменного века", 28)
	home_subtitle.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	home_subtitle.add_theme_color_override("font_color", ArtTheme.LIGHT)
	home_subtitle.mouse_filter = MOUSE_FILTER_IGNORE
	modal_panel = PanelContainer.new()
	modal.add_child(modal_panel)
	modal_scroll = ScrollContainer.new()
	modal_scroll.horizontal_scroll_mode = ScrollContainer.SCROLL_MODE_DISABLED
	modal_panel.add_child(modal_scroll)
	modal_body = VBoxContainer.new()
	modal_body.size_flags_horizontal = SIZE_EXPAND_FILL
	modal_body.add_theme_constant_override("separation", 18)
	modal_scroll.add_child(modal_body)
	modal_body.minimum_size_changed.connect(_schedule_layout)
	home_footer = _label(modal, "Офлайн · версия " + str(ProjectSettings.get_setting("application/config/version")), 21, true)
	home_footer.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	home_footer.add_theme_color_override("font_color", ArtTheme.LIGHT)
	home_footer.mouse_filter = MOUSE_FILTER_IGNORE

func _schedule_layout() -> void:
	if _layout_queued: return
	_layout_queued = true
	_layout.call_deferred()

func _layout() -> void:
	_layout_queued = false
	if not is_instance_valid(top) or not is_instance_valid(modal_panel): return
	var portrait := size.y > size.x
	var inset_top := 0.0
	var inset_bottom := 0.0
	if OS.has_feature("android"):
		var safe := DisplayServer.get_display_safe_area()
		var physical := DisplayServer.window_get_size()
		if safe.size.y > 0 and physical.y > 0:
			var ratio := size.y / float(physical.y)
			inset_top = maxf(0, safe.position.y) * ratio
			inset_bottom = maxf(0, physical.y - safe.end.y) * ratio
			inset_bottom = maxf(inset_bottom, keyboard_pixels * ratio)
	var usable := size.y - inset_top - inset_bottom
	top.position = Vector2(18, 18 + inset_top)
	top.size = Vector2(size.x - 36, 124)
	bottom.position = Vector2(18, size.y - 142 - inset_bottom)
	bottom.size = Vector2(size.x - 36, 124)
	bottom.visible = not placement_panel.visible
	var sheet_height := minf(usable - 300, 1330)
	catalog_panel.reset_size()
	catalog_panel.size = Vector2(size.x - 36, sheet_height)
	catalog_panel.position = Vector2(18, size.y - inset_bottom - 158 - catalog_panel.size.y)
	catalog_row.columns = 2 if portrait else 3
	var details_limit := minf(sheet_height, 1140 if panel_mode in ["staff", "stats", "goals"] else 930)
	var content_height := inspector_body.get_combined_minimum_size().y + 160 + (104 if inspector_tabs.visible else 0)
	var details_height := clampf(content_height, 380, details_limit)
	inspector.reset_size()
	inspector.size = Vector2(size.x - 36, details_height)
	inspector.position = Vector2(18, size.y - inset_bottom - 158 - inspector.size.y)
	if not portrait:
		inspector.size.x = minf(760, size.x * 0.52)
		inspector.position.x = size.x - inspector.size.x - 18
	var placing_height := 430.0 if tool_kind in ["ride", "prop", "staff"] else 340.0 if tool_kind == "path" else 244.0
	placement_panel.reset_size()
	placement_panel.size = Vector2(size.x - 36, placing_height)
	placement_panel.position = Vector2(18, size.y - inset_bottom - placement_panel.size.y - 18)
	# Management is a non-modal sheet: the visible park remains draggable.
	sheet_shade.visible = catalog_panel.visible
	view.input_enabled = not modal.visible and not sheet_shade.visible
	view.show_grid = bool(settings.get("build_grid", true)) and tool_kind in ["ride", "prop", "path", "staff"]
	for id in nav_buttons:
		var active: bool = (id == "rides" and catalog_panel.visible) or (id == "staff" and inspector.visible and panel_mode == "staff") or (id == "stats" and inspector.visible and panel_mode in ["stats", "goals"])
		ArtTheme.selected(nav_buttons[id], active)
	zoom_controls.position = Vector2(22, 218 + inset_top)
	zoom_controls.visible = not catalog_panel.visible
	toast_panel.visible = message_time > 0 and not catalog_panel.visible
	tutorial_label.position = Vector2(32, 152 + inset_top)
	tutorial_label.size = Vector2(size.x - 64, 64)
	toast_panel.reset_size()
	toast_panel.size = Vector2(size.x - 64, 102)
	toast_panel.position = Vector2(32, 320 + inset_top)
	var width := minf(980, size.x - 72)
	modal_panel.reset_size()
	modal_panel.size.x = width
	var remake := Graphics.is_remake(str(settings.quality))
	if page == "home":
		var menu_height := clampf(modal_body.get_combined_minimum_size().y + 64, 420, 730)
		var hero_height := minf(1020, usable - menu_height - 145)
		var home_height := hero_height + menu_height + 65
		var start := inset_top + (usable - home_height) * 0.5
		modal_panel.size = Vector2(minf(900, size.x - 120), menu_height)
		modal_panel.position = Vector2((size.x - modal_panel.size.x) * 0.5, start + hero_height)
		if remake:
			modal_panel.position.y = size.y - inset_bottom - menu_height - 92
			home_background.position = Vector2.ZERO
			home_background.size = size
			home_background.stretch_mode = TextureRect.STRETCH_KEEP_ASPECT_COVERED
		else:
			home_background.position = Vector2(64, start)
			home_background.size = Vector2(size.x - 128, hero_height - 14)
			home_background.stretch_mode = TextureRect.STRETCH_KEEP_ASPECT_CENTERED
		title_board.position = Vector2(size.x * 0.12, inset_top + usable * 0.07 if remake else start + 16)
		title_board.size = Vector2(size.x * 0.76, 218)
		home_blend.queue_redraw()
		home_subtitle.position = Vector2(30, modal_panel.position.y - 55)
		home_subtitle.size = Vector2(size.x - 60, 44)
		home_footer.position = Vector2(40, modal_panel.position.y + menu_height + 16)
		home_footer.size = Vector2(size.x - 80, 56)
	else:
		var desired := modal_body.get_combined_minimum_size().y + 64
		var limit := usable - 100
		modal_panel.size.y = minf(maxf(desired, 240), limit)
		modal_panel.position = Vector2((size.x - width) * 0.5, inset_top + (usable - modal_panel.size.y) * 0.5)
		if page == "map":
			modal_panel.size.y = minf(usable - 100, desired)
			modal_panel.position.y = inset_top + (usable - modal_panel.size.y) * 0.5
	title_board.visible = page == "home" and remake
	home_title.visible = title_board.visible
	home_subtitle.visible = page == "home" and remake
	home_footer.visible = page == "home"

func _apply_settings() -> void:
	settings.quality = Graphics.normalize(settings.quality)
	sound.configure(settings)
	if applied_quality != str(settings.quality):
		applied_quality = str(settings.quality)
		theme = ArtTheme.make(applied_quality)
		original_menu.configure(applied_quality)
		menu_fx.configure(applied_quality)
		home_title.add_theme_font_override("font", preload("res://assets/ui/fonts/NotoSerif-Bold.ttf") if Graphics.is_remake(applied_quality) else load(Graphics.font_path(applied_quality)))
		home_title.add_theme_font_size_override("font_size", 68)
		home_title.add_theme_color_override("font_color", ArtTheme.LIGHT)
		home_blend.visible = Graphics.is_remake(applied_quality)
		view.configure(applied_quality)
		var msaa := Graphics.msaa(applied_quality)
		if RenderingServer.get_current_rendering_method() == "gl_compatibility": msaa = Viewport.MSAA_DISABLED
		get_viewport().msaa_2d = msaa

		if page == "home": _load_menu_art()
		else: home_background.texture = null
		if catalog_panel.visible: show_catalog(catalog_category)
	if Graphics.is_remake(applied_quality): remake_quality = applied_quality
	Engine.max_fps = int(settings.get("fps", 60))
	view.configure_options(settings)
	menu_fx.motion_enabled = not bool(settings.get("reduced_motion", false))
	if running and bool(sim.state.debug) != bool(settings.debug): sim.set_debug(bool(settings.debug))
	if persistence_enabled: Store.save_settings(settings_path, settings)
	_layout()

func show_page(next_page: String) -> void:
	if page == "settings" and persistence_enabled: Store.save_settings(settings_path, settings)
	page = next_page
	view.input_enabled = false
	view.cancel_input()
	modal.show()
	modal_shade.color.a = 0.0 if next_page == "home" else 0.62
	hud.visible = running and next_page != "home"
	home_background.visible = next_page == "home"
	if next_page == "home": _load_menu_art()
	original_menu.visible = next_page == "home" or not running
	menu_fx.visible = next_page == "home"
	_clear(modal_body)
	modal_scroll.scroll_vertical = 0
	if next_page == "home":
		_home_page()
	elif next_page == "pause":
		_page_header("Парк на паузе", resume_game)
		_label(modal_body, "Можно выдохнуть. Время в парке остановлено.", 26, true)
		_button(modal_body, "Вернуться в парк", resume_game).theme_type_variation = "PrimaryButton"
		_button(modal_body, "Сохранить", func(): _toast("Парк сохранён" if save_game() else "Не удалось сохранить парк"); resume_game())
		_button(modal_body, "Настройки", func(): show_page("settings"))
		_button(modal_body, "Как играть", func(): show_page("help"))
		_button(modal_body, "Главное меню", func(): save_game(); show_page("home"))
	elif next_page == "new":
		_page_header("Новый парк", func(): show_page("home"))
		_label(modal_body, "С чего начнётся твоя история?", 27, true)
		_choice(modal_body, "Обучение", "Первый парк · освоить строительство и заботу о гостях", func(): chosen_scenario = 0; show_page("setup"))
		_choice(modal_body, "Свободный парк", "Строй в своём темпе, без ограничения времени", func(): chosen_scenario = -1; show_page("setup"))
		_choice(modal_body, "Сценарии", "Пять испытаний для настоящего хозяина парка", func(): show_page("scenarios"))
		_choice(modal_body, "Соревнование", "Стань лучшим и удерживай первенство три года", func(): chosen_scenario = -2; show_page("setup"))
	elif next_page == "scenarios":
		_page_header("Сценарии", func(): show_page("new"))
		_label(modal_body, "Выбери задачу. Сложность настроим следующим шагом.", 26, true)
		for scenario in sim.scenarios:
			var id := int(scenario.id)
			if id == 0: continue
			var targets: Array = scenario.targets[0]
			_choice(modal_body, str(scenario.name).capitalize(), "%d гостей · настроение %d/10 · %d монет" % [targets[2], targets[1], targets[0]], func(): chosen_scenario = id; show_page("setup"))
	elif next_page == "setup":
		_page_header(_scenario_name(chosen_scenario), func(): show_page("scenarios" if chosen_scenario > 0 else "new"))
		_label(modal_body, "Свободное строительство без ограничения времени." if chosen_scenario == -1 else "Занимай первое место три года подряд." if chosen_scenario == -2 else "Пошагово построй первый парк: дорожки, аттракционы, службы и персонал." if chosen_scenario == 0 else "Выполни цели сценария: баланс, настроение и число посетителей.", 29, true)
		_spacer(modal_body)
		var row := HBoxContainer.new()
		row.add_theme_constant_override("separation", 16)
		modal_body.add_child(row)
		for difficulty in 2:
			var id := difficulty
			var b := _button(row, ["Обычная", "Сложная"][id], func(): chosen_difficulty = id; show_page("setup"), 400)
			b.size_flags_horizontal = SIZE_EXPAND_FILL
			ArtTheme.selected(b, chosen_difficulty == id)
		if chosen_scenario >= 0:
			var scenario: Dictionary = sim.scenarios[chosen_scenario]
			var goals: Array = scenario.targets[chosen_difficulty]
			_label(modal_body, "Начальный капитал: %d монет\nЦели: %d монет · настроение %d · гостей %d" % [scenario.starting_money[chosen_difficulty], goals[0], goals[1], goals[2]], 30, true)
		_label(modal_body, "Новый парк заменит текущее сохранение. Предыдущая запись останется в резервной копии.", 24, true)
		_button(modal_body, "Создать парк", func(): new_game(chosen_scenario, chosen_difficulty)).theme_type_variation = "PrimaryButton"
		_button(modal_body, "Назад", func(): show_page("new"))
	elif next_page == "map":
		_page_header("Карта парка", resume_game)
		_label(modal_body, "Нажми на место, к которому хочешь перейти.", 28, true)
		var map := MiniMap.new()
		map.sim = sim
		map.view = view
		map.custom_minimum_size.y = minf(size.y * 0.34, (size.x - 150) * 0.62)
		modal_body.add_child(map)
		map.cell_chosen.connect(func(cell): view.focus_cell(cell); resume_game())
		_label(modal_body, "Золотой — аттракцион · серый — служба
Красный — нужна помощь · точки — гости", 25, true)
		var map_actions := HBoxContainer.new()
		map_actions.add_theme_constant_override("separation", 16)
		modal_body.add_child(map_actions)
		_button(map_actions, "Ко входу", func(): view.focus_cell(Vector2(sim.state.entrance[0] - 1, sim.state.entrance[1] + 2)); resume_game()).size_flags_horizontal = SIZE_EXPAND_FILL
		_button(map_actions, "Весь парк", func(): view.center_park(); resume_game()).size_flags_horizontal = SIZE_EXPAND_FILL
	elif next_page == "demolish_confirm":
		_demolition_page()
	elif next_page == "settings":
		_settings_page()
	elif next_page == "data_notice":
		_page_header("Сохранения", func(): show_page("settings"))
		_label(modal_body, data_notice, 28, true)
		_button(modal_body, "Понятно", func(): show_page("settings")).theme_type_variation = "PrimaryButton"
	elif next_page == "import_confirm":
		_page_header("Открыть парк из файла?", func(): pending_import = {}; show_page("settings"))
		var imported: Dictionary = pending_import.get("game", {})
		_label(modal_body, "%s · %d монет · %d построек\nТекущий парк будет отдельно сохранён перед импортом." % [_scenario_name(int(imported.get("scenario", -1))), int(imported.get("money", 0)), imported.get("buildings", []).size()], 28, true)
		_button(modal_body, "Открыть этот парк", func(): restore_save_data(pending_import); pending_import = {}).theme_type_variation = "PrimaryButton"
		_button(modal_body, "Отмена", func(): pending_import = {}; show_page("settings"))
	elif next_page == "reset_settings":
		_page_header("Вернуть настройки?", func(): show_page("settings"))
		_label(modal_body, "Графика, звук и управление вернутся к начальным значениям. Твой парк и его копии останутся на месте.", 28, true)
		_button(modal_body, "Вернуть начальные настройки", func(): settings = Store.defaults(); _apply_settings(); show_page("settings")).theme_type_variation = "PrimaryButton"
		_button(modal_body, "Оставить как есть", func(): show_page("settings"))
	elif next_page == "restore_backup":
		_page_header("Восстановить личную копию?", func(): show_page("settings"))
		_label(modal_body, "Игра вернётся к моменту создания копии. Текущий парк будет отдельно сохранён перед восстановлением.", 28, true)
		_button(modal_body, "Восстановить", restore_manual_backup).theme_type_variation = "PrimaryButton"
		_button(modal_body, "Отмена", func(): show_page("settings"))
	elif next_page == "help":
		_help_page()
	elif next_page == "guide":
		_page_header("Правила игры", func(): show_page("help"))
		for paragraph in text_data.get("help", []):
			var cleaned := _readable(str(paragraph))
			if not cleaned.strip_edges().is_empty(): _label(modal_body, cleaned, 26, true)
		_button(modal_body, "Назад", func(): show_page("help"))
	elif next_page == "credits":
		_label(modal_body, "Первобытный парк", 46)
		_label(modal_body, "Оригинальная игра: Gear Games, 2007\nВерсия J2ME: 1.09\n\nAndroid-порт: правила и ресурсы восстановлены из оригинала. Новый интерфейс для касаний, плавная камера, высокое разрешение, сохранение и локальный звук.\n\nМузыкальная композиция из оригинала; синтез и эффекты выполняются локально. Игра работает без интернета.\n\nШрифты интерфейса: Noto, Apache License 2.0.", 30, true)
		_back_button()
	elif next_page == "result":
		_label(modal_body, "Отличный парк!" if sim.state.status == "won" else "Парк разорился", 48)
		_label(modal_body, "Все условия выполнены." if sim.state.status == "won" else "Долги не удалось погасить вовремя. Попробуй меньше строить в кредит и внимательно следи за расходами.", 30, true)
		_button(modal_body, "Посмотреть парк", resume_game)
		_button(modal_body, "Новый сценарий", func(): show_page("new"))
		_button(modal_body, "Главное меню", func(): show_page("home"))
	_layout()
	_schedule_layout()

func _back_button() -> void:
	_button(modal_body, "Назад", func(): show_page("pause" if running else "home"))

func _settings_page() -> void:
	Preferences.build(self)

func manual_save_path() -> String:
	return save_path + ".manual.json"

func make_manual_backup() -> void:
	if not running: return
	var data := _save_data()
	if Store.write_json(manual_save_path(), data):
		show_page("settings")
		_toast("Личная копия сохранена")
	else:
		_toast("Не удалось записать копию. Проверь свободное место.")

func restore_manual_backup() -> bool:
	return restore_save_data(Store.read_json(manual_save_path()))

func restore_save_data(data: Dictionary) -> bool:
	var candidate := Sim.new()
	if data.get("format") != "prehistorik-park" or not data.get("game") is Dictionary or not candidate.restore(data.game):
		data_notice = "Копия повреждена. Текущий парк остался на месте."
		show_page("data_notice")
		return false
	if persistence_enabled:
		if running and not Store.write_json(save_path + ".before_restore.json", _save_data()):
			data_notice = "Не удалось защитить текущий парк. Освободи место на устройстве и попробуй снова."
			show_page("data_notice")
			return false
		if not Store.write_json(save_path, data):
			data_notice = "Не удалось записать копию. Текущий парк не изменён."
			show_page("data_notice")
			return false
	sim.restore(data.game)
	running = true
	result_shown = sim.state.status != "playing"
	last_messages = sim.state.messages.size()
	_clear_selection()
	view.focus_activity()
	resume_game()
	_toast("Парк восстановлен")
	return true

func choose_save_file(exporting: bool) -> void:
	var picker := FileDialog.new()
	picker.use_native_dialog = true
	picker.access = FileDialog.ACCESS_FILESYSTEM
	picker.file_mode = FileDialog.FILE_MODE_SAVE_FILE if exporting else FileDialog.FILE_MODE_OPEN_FILE
	picker.title = "Экспорт парка" if exporting else "Импорт парка"
	picker.filters = PackedStringArray(["*.json ; Парк"])
	if exporting: picker.current_file = "prehistorik-park.json"
	add_child(picker)
	picker.canceled.connect(picker.queue_free)
	picker.file_selected.connect(func(path):
		if exporting: export_save_to(path)
		else: prepare_import(path)
		picker.queue_free())
	picker.popup_centered_ratio(0.85)

func export_save_to(path: String) -> bool:
	var data := _save_data() if running else Store.read_json(save_path)
	if data.is_empty(): return false
	# Android SAF returns content:// URIs, which cannot be atomically renamed.
	var file := FileAccess.open(path, FileAccess.WRITE)
	var ok := file != null
	if file:
		file.store_string(JSON.stringify(data))
		file.flush()
		ok = file.get_error() == OK
		file.close()
	data_notice = "Файл парка сохранён. Его можно перенести на другое устройство и открыть через «Импорт»." if ok else "Не удалось сохранить файл. Выбери другую папку или освободи место."
	show_page("data_notice")
	return ok

func prepare_import(path: String) -> bool:
	pending_import = {}
	var file := FileAccess.open(path, FileAccess.READ)
	if file and file.get_length() <= 8 * 1024 * 1024:
		var value = JSON.parse_string(file.get_as_text())
		file.close()
		if value is Dictionary and value.get("format") == "prehistorik-park" and value.get("game") is Dictionary:
			var candidate := Sim.new()
			if candidate.restore(value.game): pending_import = value
	if pending_import.is_empty():
		data_notice = "Этот файл не похож на сохранение парка или повреждён. Текущая игра не изменена."
		show_page("data_notice")
		return false
	show_page("import_confirm")
	return true

func _save_data() -> Dictionary:
	return {"format": "prehistorik-park", "version": 1, "saved_at": Time.get_datetime_string_from_system(),
		"game": sim.snapshot(), "camera": {"zoom": view.zoom, "pan": [view.pan.x, view.pan.y]}}

func _help_page() -> void:
	_page_header("Как играть", func(): show_page("pause" if running else "home"))
	for item in [
		["Строй и пробуй", "Открой «Строить», выбери объект и место в парке. Поверни вход к подсвеченной дорожке. Стрелки сдвигают объект на одну клетку; «Построить» подтверждает место. Дорожки ставятся касанием. «Отмена» завершает строительство."],
		["Исследуй парк", "Перетаскивай парк одним пальцем, приближай двумя. «К парку» вернёт камеру к постройкам. На карте можно перейти в любое место или увидеть весь парк."],
		["Заботься о гостях", "Нажми на гостя или постройку, чтобы узнать, чего им не хватает. В карточке лавки можно нанять сотрудника прямо сюда. В «Персонале» — выбрать место и переназначить любого работника. Продавец обслуживает лавки, повар — кафе. Скамейки из раздела «Дорожки» дают два места отдыха."],
		["Сохраняй своё дело", "Парк сохраняется автоматически и при сворачивании. Пауза останавливает время. Снос объекта требует подтверждения; инструмент для дорожек находится в разделе «Парк»."]
	]:
		var card := PanelContainer.new()
		card.theme_type_variation = "PaperPanel"
		modal_body.add_child(card)
		var body := VBoxContainer.new()
		body.add_theme_constant_override("separation", 8)
		card.add_child(body)
		_label(body, item[0], 30)
		_label(body, item[1], 25, true)
	_button(modal_body, "Правила оригинальной игры", func(): show_page("guide"))

func _readable(text: String) -> String:
	var result := text
	for icon in text_data.get("icons", []):
		result = result.replace("[icon:%d]" % int(icon.id), str(icon.label))
	return result

func _scenario_name(id: int) -> String:
	return "Свободный парк" if id == -1 else "Соревнование" if id == -2 else str(sim.scenarios[id].name).capitalize() if id >= 0 and id < sim.scenarios.size() else "Парк"

func new_game(scenario := 0, difficulty := 0, seed_value := -1) -> void:
	if running and persistence_enabled and not Store.write_json(save_path + ".previous_park.json", _save_data()):
		data_notice = "Не удалось защитить предыдущий парк. Освободи место и попробуй снова."
		show_page("data_notice")
		return
	sim.new_game(scenario, difficulty, randi() if seed_value < 0 else seed_value)
	speed = 1
	speed_button.text = "▶ 1×"
	running = true
	result_shown = false
	last_messages = 0
	last_message_text = ""
	sim.set_debug(bool(settings.debug))
	_clear_selection()
	view.focus_cell(Vector2(sim.state.entrance[0] - 1, sim.state.entrance[1] + 2))
	resume_game()
	save_game()
	_toast("Начни с дорожки у входа в парк")

func resume_game() -> void:
	if not running: return
	page = ""
	modal.hide()
	_clear(modal_body)
	home_background.hide()
	home_background.texture = null
	original_menu.hide()
	original_menu.resources.clear()
	original_menu.fragments.clear()
	menu_fx.hide()
	hud.show()
	view.input_enabled = not sheet_shade.visible
	sound.suspend(suspended)
	_refresh_hud()

func save_game() -> bool:
	if not persistence_enabled or not running: return false
	save_timer = 0
	last_save_ok = Store.write_json(save_path, _save_data())
	if is_instance_valid(save_status):
		save_status.text = "Сохранено" if last_save_ok else "Ошибка сохранения"
	if not last_save_ok: _toast("Не удалось сохранить парк. Проверь свободное место.")
	return last_save_ok

func load_game() -> void:
	if running:
		resume_game()
		return
	for path in [save_path, save_path + ".bak"]:
		var data := Store.read_json(path)
		if data.get("format") != "prehistorik-park" or not data.get("game") is Dictionary: continue
		if sim.restore(data.game):
			if path.ends_with(".bak") and FileAccess.file_exists(save_path):
				DirAccess.rename_absolute(save_path, save_path + ".corrupt")
			running = true
			result_shown = sim.state.status != "playing"
			last_messages = sim.state.messages.size()
			_clear_selection()
			view.center_park()
			var camera = data.get("camera", {})
			if camera is Dictionary:
				var raw_zoom = camera.get("zoom", view.zoom)
				var scale_value: float = float(raw_zoom) if raw_zoom is int or raw_zoom is float else view.zoom
				if is_finite(scale_value): view.zoom = clampf(scale_value, 0.75, 7)
				var location = camera.get("pan", [])
				if location is Array and location.size() == 2 and (location[0] is int or location[0] is float) and (location[1] is int or location[1] is float) and is_finite(float(location[0])) and is_finite(float(location[1])):
					view.pan = Vector2(clampf(float(location[0]), -10000, 10000), clampf(float(location[1]), -10000, 10000))
			resume_game()
			_toast("Загружена резервная копия" if path.ends_with(".bak") else "Парк загружен")
			return
	_label(modal_body, "Сохранение не удалось загрузить. Можно начать новый парк.", 25, true)

func _clear_selection() -> void:
	if catalog_panel.visible: catalog_positions[catalog_category] = catalog_scroll.scroll_vertical
	selected_guest = -1
	build_cell = Vector2i(-1, -1)
	tool_kind = "select"
	moving_worker_uid = -1
	view.preview_worker_uid = -1
	selected_uid = -1
	view.selected = Vector2i(-1, -1)
	view.preview_kind = ""
	catalog_panel.hide()
	inspector.hide()
	placement_panel.hide()
	panel_mode = ""
	view.cancel_input()
	_layout()

func _toolbar(id: String) -> void:
	if id == "select":
		_clear_selection()
	elif id == "demolish":
		_clear_selection()
		tool_kind = "demolish"
		_build_info()
		_toast("Нажми на объект, чтобы убрать его")
	elif id == "rides":
		if catalog_panel.visible: _clear_selection()
		else: show_catalog(catalog_category if not catalog_category.is_empty() else "rides")
	elif id == "staff":
		if inspector.visible and panel_mode == "staff": _clear_selection()
		else: show_staff()
	elif id == "stats":
		if inspector.visible and panel_mode in ["stats", "goals"]: _clear_selection()
		else: show_stats()
	elif id == "goals": show_goals()
	else: show_catalog(id)

func show_catalog(category: String, filtering := false) -> void:
	if catalog_panel.visible:
		catalog_positions[catalog_category] = 0 if filtering else catalog_scroll.scroll_vertical
	else:
		_clear_selection()
	catalog_category = category
	message_time = 0
	message_label.hide()
	catalog_panel.show()
	catalog_notice.hide()
	_clear(catalog_row)
	for tab in catalog_tabs.get_children():
		ArtTheme.selected(tab, tab.get_meta("category") == category)
	var entries: Array = []
	var definitions := {
		"paths": [["path", 0], ["path", 4], ["path", 2], ["path", 13]],
		"rides": [],
		"services": [["prop", 15], ["prop", 17], ["prop", 19], ["prop", 23], ["prop", 25], ["ride", 23], ["prop", 20]],
		"decor": [["prop", 0], ["prop", 4], ["prop", 8], ["prop", 10], ["prop", 12], ["prop", 13], ["path", 2]]
	}
	for id in [6, 14, 11, 8, 10, 5, 7, 22, 16, 12, 1, 9, 17, 4, 13, 15, 0, 2, 21, 3, 18, 20, 19]: definitions.rides.append(["ride", id])
	definitions.rides.append(["prop", 26])
	for spec in definitions.get(category, definitions.rides):
		entries.append({"kind": spec[0], "id": spec[1], "item": sim._catalog(spec[0], spec[1])})
	entries = entries.filter(func(entry): return sim.availability(entry.kind, entry.id)) + entries.filter(func(entry): return not sim.availability(entry.kind, entry.id))
	var shown := 0
	var available_count := 0
	for entry in entries:
		var kind: String = entry.kind
		var id: int = entry.id
		var item: Dictionary = entry.item
		var available: bool = sim.availability(kind, id)
		if available: available_count += 1
		if catalog_available and not available: continue
		if not catalog_query.is_empty() and not str(item.name).to_lower().contains(catalog_query.to_lower()): continue
		shown += 1
		var card := Button.new()
		card.mouse_filter = MOUSE_FILTER_PASS
		card.theme_type_variation = "CatalogCard"
		card.custom_minimum_size = Vector2(0, 364)
		card.size_flags_horizontal = SIZE_EXPAND_FILL
		card.clip_contents = true
		card.pressed.connect(func(): sound.effect("click"); _choose_build(kind, id))
		card.tooltip_text = str(item.name).capitalize()
		catalog_row.add_child(card)
		var margin := MarginContainer.new()
		margin.mouse_filter = MOUSE_FILTER_IGNORE
		for side in ["left", "right", "top", "bottom"]: margin.add_theme_constant_override("margin_" + side, 16)
		card.add_child(margin)
		margin.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
		var body := VBoxContainer.new()
		body.mouse_filter = MOUSE_FILTER_IGNORE
		body.add_theme_constant_override("separation", 6)
		margin.add_child(body)
		var visual := HBoxContainer.new()
		visual.mouse_filter = MOUSE_FILTER_IGNORE
		body.add_child(visual)
		var icon := TextureRect.new()
		icon.expand_mode = TextureRect.EXPAND_IGNORE_SIZE
		icon.stretch_mode = TextureRect.STRETCH_KEEP_ASPECT_CENTERED
		icon.custom_minimum_size = Vector2(0, 174)
		icon.size_flags_horizontal = SIZE_EXPAND_FILL
		icon.mouse_filter = MOUSE_FILTER_IGNORE
		icon.texture_filter = Graphics.texture_filter(str(settings.quality))
		visual.add_child(icon)
		var preview_mode: String = "remake_maximum" if Graphics.is_remake(str(settings.quality)) else str(settings.quality)
		var preview_path := "res://assets/ui/catalog/%s/%s_%d.png" % [preview_mode, kind, id]
		if kind != "path" and ResourceLoader.exists(preview_path): icon.texture = load(preview_path)
		elif kind == "ride": icon.texture = view.texture_for(view.art.rides[id].frames[0].path)
		elif kind == "prop": icon.texture = view.texture_for(view.art.scenery[id].frames[0].path)
		elif id == 2:
			var bench: Dictionary = view.art.tiles.edges[19]
			var key := "1:2:%d:%d:%d:%d" % [bench.rect[0],bench.rect[1],bench.rect[2],bench.rect[3]]
			icon.texture = view._texture(Graphics.replacement_path(view.part_overrides[key])) if view.part_overrides.has(key) else view.texture_for(bench.path)
		else: icon.texture = view.texture_for(view.art.tiles["path_stone" if id == 4 else "water_0" if id == 13 else "path_dirt"].path)
		if not available: icon.modulate = Color(0.75, 0.78, 0.71, 0.7)
		var name_label := _label(body, str(item.name).capitalize(), 29, true)
		name_label.custom_minimum_size.y = 68
		name_label.max_lines_visible = 2
		name_label.text_overrun_behavior = TextServer.OVERRUN_TRIM_ELLIPSIS
		name_label.mouse_filter = MOUSE_FILTER_IGNORE
		var price := _label(body, "%d монет    ·    %d × %d" % [item.cost, item.size[0], item.size[1]], 26)
		price.mouse_filter = MOUSE_FILTER_IGNORE
		price.add_theme_color_override("font_color", ArtTheme.GOLD if available else ArtTheme.MUTED)
		var status := _label(body, ("2 места · поставить на дорожку" if kind == "path" and id == 2 else "Можно строить") if available else "Закрыто · как открыть?", 22)
		status.mouse_filter = MOUSE_FILTER_IGNORE
		status.add_theme_color_override("font_color", ArtTheme.MUTED)
	catalog_count.text = "%d объектов · открыто %d" % [entries.size(), available_count] if catalog_query.is_empty() else "Найдено: %d" % shown
	if shown == 0:
		var empty := _label(catalog_row, "Ничего не найдено. Измени запрос." if not catalog_query.is_empty() else "Здесь пока нет открытых построек", 26, true)
		empty.size_flags_horizontal = SIZE_EXPAND_FILL
	catalog_scroll.set_deferred("scroll_vertical", int(catalog_positions.get(category, 0)))
	_layout()

func _choose_build(kind: String, id: int) -> void:
	if catalog_panel.visible: catalog_positions[catalog_category] = catalog_scroll.scroll_vertical
	if not sim.availability(kind, id):
		sim.start_research(id, kind)
		catalog_notice.text = sim.last_error
		catalog_notice.show()
		_toast(sim.last_error)
		return
	build_cell = Vector2i(-1, -1)
	tool_kind = kind
	tool_id = id
	build_rotation = 0
	view.preview_kind = kind
	view.preview_type = id
	view.preview_rotation = 0
	selected_uid = -1
	catalog_panel.hide()
	inspector.hide()
	_build_info()

func _build_info() -> void:
	_clear(placement_body)
	placement_panel.show()
	inspector.hide()
	catalog_panel.hide()
	var heading := HBoxContainer.new()
	placement_body.add_child(heading)
	var item: Dictionary = {} if tool_kind in ["demolish", "staff"] else sim._catalog(tool_kind, tool_id)
	var name := "Снос объектов" if item.is_empty() else str(item.name).capitalize()
	if tool_kind == "staff": name = ("Назначить: " if moving_worker_uid > 0 else "Нанять: ") + str(sim.staff_catalog[tool_id].name)
	var title := _label(heading, name, 32, true)
	title.size_flags_horizontal = SIZE_EXPAND_FILL
	_button(heading, "Отмена", _clear_selection, 174)
	var detail := "Нажми на объект, который хочешь убрать" if item.is_empty() else "%d монет  ·  %d × %d клеток" % [item.cost, item.size[0], item.size[1]]
	if tool_kind == "ride" and tool_id != 22:
		detail += " · %d мест" % item.capacity
		if item.requires_motor: detail += " · нужен диномотор"
	if tool_kind == "ride" and tool_id == 22:
		detail = "Выход · 35 монет" if int(sim.state.water_build) > 0 else "Вход · 35 монет. Затем поставь выход и соедини водой."
	if tool_kind == "staff": detail = STAFF_JOBS[tool_id]
	if tool_kind == "path" and tool_id == 2: detail = "Два места для отдыха · поставь скамейку на готовую дорожку"
	var info := _label(placement_body, detail, 25, true)
	info.add_theme_color_override("font_color", ArtTheme.MUTED)
	var reason := ""
	if tool_kind in ["ride", "prop", "staff"]:
		reason = "Выбери место в парке" if build_cell.x < 0 else (sim.staff_placement_error(tool_id, build_cell, moving_worker_uid) if tool_kind == "staff" else sim.can_build(tool_kind, tool_id, build_cell, build_rotation))
		var ready := "Место подходит. Стрелки двигают на одну клетку."
		if tool_kind == "staff" and reason.is_empty():
			var workplace: Dictionary = sim.building_at(build_cell)
			ready = "Начало патруля · %d, %d" % [build_cell.x, build_cell.y] if workplace.is_empty() else "Рабочее место: %s №%d" % [sim._catalog(workplace.kind, workplace.type).name, workplace.uid]
		var hint := _label(placement_body, reason if not reason.is_empty() else ready, 24, true)
		hint.add_theme_color_override("font_color", ArtTheme.CREAM if build_cell.x < 0 or reason.is_empty() else Color("a53f2c"))
	if tool_kind in ["ride", "prop", "path", "staff"]:
		var arrows := HBoxContainer.new()
		arrows.add_theme_constant_override("separation", 12)
		placement_body.add_child(arrows)
		for spec in [["↖", Vector2i(-1,0)], ["↗", Vector2i(0,1)], ["↙", Vector2i(0,-1)], ["↘", Vector2i(1,0)]]:
			var delta: Vector2i = spec[1]
			var arrow := _button(arrows, spec[0], func(): _nudge_build(delta), 92)
			arrow.tooltip_text = "На одну клетку " + str(spec[0])
		var coords := _label(arrows, "Точная установка" if build_cell.x < 0 else "Клетка %d, %d" % [build_cell.x, build_cell.y], 24, true)
		coords.size_flags_horizontal = SIZE_EXPAND_FILL
		coords.vertical_alignment = VERTICAL_ALIGNMENT_CENTER
	var actions := HBoxContainer.new()
	actions.add_theme_constant_override("separation", 12)
	placement_body.add_child(actions)
	if tool_kind == "staff":
		_button(actions, "Персонал", show_staff, 190)
		var confirm := _button(actions, "Назначить" if moving_worker_uid > 0 else "Нанять · %d монет" % sim.staff_catalog[tool_id].salary, func(): _cell_selected(build_cell, true))
		confirm.size_flags_horizontal = SIZE_EXPAND_FILL
		confirm.disabled = not reason.is_empty()
		confirm.theme_type_variation = "PrimaryButton"
	elif tool_kind != "demolish":
		_button(actions, "Каталог", func(): show_catalog(catalog_category if not catalog_category.is_empty() else "rides"), 174)
	if tool_kind == "ride" or (tool_kind == "prop" and _prop_next(tool_id) != tool_id):
		_button(actions, "Повернуть", _rotate_build, 220)
	if tool_kind in ["ride", "prop"]:
		var confirm := _button(actions, "Построить", func(): _cell_selected(build_cell, true))
		confirm.size_flags_horizontal = SIZE_EXPAND_FILL
		confirm.disabled = not reason.is_empty()
		confirm.theme_type_variation = "PrimaryButton"
	elif tool_kind == "path":
		if build_cell.x >= 0:
			var confirm := _button(actions, "Построить", func(): _cell_selected(build_cell, true))
			confirm.size_flags_horizontal = SIZE_EXPAND_FILL
			confirm.disabled = not sim.can_build("path", tool_id, build_cell).is_empty()
			confirm.theme_type_variation = "PrimaryButton"
		else:
			var hint := _label(actions, "Тап — построить · стрелки — прицелиться", 25, true)
			hint.size_flags_horizontal = SIZE_EXPAND_FILL
	_layout()
	_layout.call_deferred()  # again after the container has given new labels their width

func _nudge_build(delta: Vector2i) -> void:
	var cell := build_cell
	if cell.x < 0:
		cell = view.screen_to_cell(Vector2(size.x * 0.5, (top.position.y + top.size.y + placement_panel.position.y) * 0.5))
	build_cell = Vector2i(clampi(cell.x + delta.x, 0, int(sim.state.size) - 1), clampi(cell.y + delta.y, 0, int(sim.state.size) - 1))
	view.selected = build_cell
	view.hovered = build_cell
	_build_info()
	var visible_park := Rect2(36, top.position.y + top.size.y + 70, size.x - 72, maxf(100, placement_panel.position.y - top.position.y - top.size.y - 110))
	var point: Vector2 = view.cell_to_screen(Vector2(build_cell))
	if not visible_park.has_point(point): view.pan += visible_park.get_center() - point
	view.queue_redraw()

func _choose_staff(role: int, worker_uid := -1, cell := Vector2i(-1, -1)) -> void:
	if worker_uid < 0 and not sim.can_hire(role).is_empty():
		_toast(sim.can_hire(role))
		return
	_clear_selection()
	tool_kind = "staff"
	tool_id = role
	moving_worker_uid = worker_uid
	build_cell = cell
	view.preview_kind = "staff"
	view.preview_type = role
	view.preview_worker_uid = worker_uid
	view.selected = cell
	view.hovered = cell
	_build_info()
	if cell.x >= 0: view.focus_cell(Vector2(cell))

func _cell_selected(cell: Vector2i, confirmed := false) -> void:
	if not running or modal.visible or cell.x < 0 or cell.y < 0 or cell.x >= int(sim.state.size) or cell.y >= int(sim.state.size): return
	view.selected = cell
	if tool_kind in ["ride", "prop", "staff"] and not confirmed:
		build_cell = cell
		view.hovered = cell
		_build_info()
		view.queue_redraw()
		return
	if tool_kind == "staff":
		var ok: bool = sim.assign_worker(moving_worker_uid, cell) if moving_worker_uid > 0 else sim.hire(tool_id, cell)
		if ok:
			sound.effect("hire")
			save_game()
			var workplace: Dictionary = sim.building_at(cell)
			_clear_selection()
			if not workplace.is_empty():
				selected_uid = int(workplace.uid)
				view.selected = cell
				_inspect_building()
			else: show_staff()
			_toast("Сотрудник назначен. Рабочее место сохранено.")
		else:
			sound.effect("error")
			_toast(sim.last_error)
			_build_info()
	elif tool_kind in ["ride", "prop", "path"]:
		if sim.build(tool_kind, tool_id, cell, build_rotation):
			sound.effect("build")
			view.burst(cell)
			_toast("Построено: " + str(sim._catalog(tool_kind, tool_id).name))
			if tool_kind == "ride" and tool_id == 22:
				if int(sim.state.water_build) == -1:
					_choose_build("path", 13)
					_toast("Соедините ворота водой, затем подведите дорожки снаружи.")
				else: _build_info()
			if tool_kind in ["ride", "prop"]:
				build_cell = Vector2i(-1, -1)
				view.selected = Vector2i(-1, -1)
				view.hovered = Vector2i(-1, -1)
				_build_info()
			save_game()
		else:
			sound.effect("error")
			_toast(sim.last_error)
	elif tool_kind == "demolish":
		_request_demolition(cell)
	else:
		var building: Dictionary = sim.building_at(cell)
		if not building.is_empty():
			selected_uid = int(building.uid)
			_inspect_building()
		else:
			selected_uid = -1
			selected_guest = -1
			var nearest := 0.85
			for guest in sim.state.visitors:
				var distance: float = Vector2(guest.x,guest.y).distance_to(Vector2(cell))
				if distance < nearest:
					nearest = distance
					selected_guest = int(guest.uid)
			if selected_guest >= 0: _inspect_guest()
			else: inspector.hide()
	_refresh_hud()
	view.queue_redraw()

func _hover(_cell: Vector2i) -> void:
	if tool_kind in ["ride", "prop", "staff", "path"] and build_cell.x >= 0: view.hovered = build_cell

func _guest_state(guest: Dictionary) -> String:
	var states := {"walking":"Гуляет", "queue":"Ждёт в очереди", "riding":"Катается", "eating":"Ест", "drinking":"Пьёт", "resting":"Отдыхает", "toilet":"В туалете", "shopping":"Покупает сувенир", "healing":"Лечится", "leaving":"Уходит из парка", "lost":"Ищет выход", "fighting":"Дерётся", "watching":"Наблюдает"}
	return "%s · %d монет" % [states.get(guest.state,"Гуляет"),guest.cash]

func _inspect_guest() -> void:
	var guest: Dictionary = sim._visitor(selected_guest)
	if guest.is_empty(): return
	_clear(inspector_body)
	inspector.show()
	panel_mode = "guest"
	inspector_title.text = "Посетитель %d" % selected_guest
	inspector_tabs.hide()
	guest_state_label = _label(inspector_body, _guest_state(guest), 26, true)
	guest_needs_labels.clear()
	for i in 7:
		guest_needs_labels.append(_label(inspector_body, "%s: %d / 100" % [["Настроение","Усталость","Голод","Туалет","Жажда","Здоровье","Агрессия"][i],guest.needs[i]], 25))
	_button(inspector_body, "Показать в парке", func():
		var current: Dictionary = sim._visitor(selected_guest)
		if not current.is_empty(): view.focus_cell(Vector2(current.x,current.y)))

	_layout()

func _building_summary(b: Dictionary, item: Dictionary) -> String:
	var occupancy := "%d в канале" % b.occupants.size() if int(b.type) == 22 else "%d / %d" % [b.occupants.size(), item.capacity]
	return "Состояние: %d%%\nПосетителей: %s\nОчередь: %d\nДоход: %d" % [b.condition, occupancy, b.queue.size(), b.income]

func _inspect_building() -> void:
	selected_guest = -1
	var b: Dictionary = sim.building_by_id(selected_uid)
	if b.is_empty():
		inspector.hide()
		return
	_clear(inspector_body)
	inspector.show()
	var item: Dictionary = sim._catalog(b.kind, int(b.type))
	panel_mode = "building"
	inspector_title.text = str(item.name).capitalize()
	inspector_tabs.hide()
	building_status_label = _label(inspector_body, "Работает" if b.working else str(b.reason), 24, true)
	building_details_label = null
	var role: int = sim._role(b)
	if role >= 0:
		var worker: Dictionary = sim.assigned_worker(int(b.uid))
		if worker.is_empty():
			_label(inspector_body, "Рабочее место свободно · нужен %s" % sim.staff_catalog[role].name, 25, true)
			_button(inspector_body, "Нанять сюда · %d монет" % sim.staff_catalog[role].salary, func(): _choose_staff(role, -1, Vector2i(b.x,b.y))).theme_type_variation = "PrimaryButton"
			for candidate in sim.state.workers:
				if int(candidate.type) == role and int(candidate.get("assignment_uid", 0)) <= 0:
					var uid := int(candidate.uid)
					_button(inspector_body, "Назначить свободного сотрудника №%d" % uid, func(): _choose_staff(role, uid, Vector2i(b.x,b.y)))
		else:
			_label(inspector_body, "Работает: %s №%d" % [sim.staff_catalog[role].name, worker.uid], 25, true)
			_button(inspector_body, "Переназначить сотрудника", func(): _choose_staff(role, int(worker.uid)))
	if not bool(b.connected):
		_label(inspector_body, "Подсвеченные клетки у входа должны соединяться дорожкой со входом в парк.", 24, true)
	if b.kind == "ride":
		building_details_label = _label(inspector_body, _building_summary(b, item), 25, true)
	if b.kind == "ride" or int(item.get("price_group", -1)) >= 0:
		var price_label := _label(inspector_body, "Цена: %d монет" % b.price, 26)
		var prices := HBoxContainer.new()
		prices.add_theme_constant_override("separation", 12)
		inspector_body.add_child(prices)
		for amount in [-1, 1]:
			var delta: int = amount
			_button(prices, "−" if amount < 0 else "+", func():
				if sim.set_price(int(b.uid), int(b.price) + delta): price_label.text = "Цена: %d монет" % b.price; save_game()
				else: _toast(sim.last_error), 160)
	_button(inspector_body, "Закрыть объект" if b.open else "Открыть объект", func(): sim.set_open(int(b.uid), not bool(b.open)); _inspect_building(); save_game())
	if b.kind == "ride" and bool(item.get("requires_motor", false)) and not bool(b.get("powered", true)):
		_label(inspector_body, "Поставь диномотор рядом, подведи дорожку и найми погонщика.", 24, true)
		_button(inspector_body, "Построить диномотор", _build_motor).theme_type_variation = "PrimaryButton"
	if b.kind == "prop" and int(b.type) in [15,16,17,18,20,21]:
		_button(inspector_body, "Повернуть вход", func():
			if sim.rotate_service(int(b.uid)): sound.effect("build"); _inspect_building(); view.queue_redraw(); save_game()
			else: _toast(sim.last_error))
	_button(inspector_body, "Снести объект…", func(): _request_demolition(Vector2i(b.x, b.y))).theme_type_variation = "DangerButton"

	_layout()

func show_staff() -> void:
	var scroll_before := inspector_scroll.scroll_vertical if panel_mode == "staff" else 0
	_clear_selection()
	_clear(inspector_body)
	panel_mode = "staff"
	message_time = 0
	message_label.hide()
	inspector.show()
	inspector_tabs.hide()
	inspector_title.text = "Персонал"
	_label(inspector_body, "Сначала выбери сотрудника, затем его место в парке. Оплата при найме и в начале каждой луны.", 25, true)
	var show_team: bool = staff_tab == "team" and not sim.state.workers.is_empty()
	var tabs := HBoxContainer.new()
	tabs.add_theme_constant_override("separation", 12)
	inspector_body.add_child(tabs)
	for spec in [["Команда · %d / 22" % sim.state.workers.size(), "team"], ["Нанять сотрудника", "hire"]]:
		var tab: String = spec[1]
		var button := _button(tabs, spec[0], func(): staff_tab = tab; show_staff())
		button.size_flags_horizontal = SIZE_EXPAND_FILL
		button.disabled = tab == "team" and sim.state.workers.is_empty()
		ArtTheme.selected(button, (tab == "team") == show_team)
	for worker in (sim.state.workers if show_team else []):
		var uid := int(worker.uid)
		var id := int(worker.type)
		var card := PanelContainer.new()
		card.add_theme_stylebox_override("panel", ArtTheme.box(ArtTheme.DEEP, ArtTheme.EDGE, 18))
		inspector_body.add_child(card)
		var body := VBoxContainer.new()
		card.add_child(body)
		_label(body, "%s №%d" % [str(sim.staff_catalog[id].name).capitalize(), uid], 29)
		var workplace: Dictionary = sim.building_by_id(int(worker.get("assignment_uid", -1)))
		var detail := "Без рабочего места · назначь на свободный объект" if id >= 2 else "Патрулирует парк · клетка %d, %d" % [roundi(worker.x), roundi(worker.y)]
		if not workplace.is_empty(): detail = "%s №%d · %s" % [str(sim._catalog(workplace.kind, workplace.type).name).capitalize(), workplace.uid, "работает" if workplace.working else workplace.reason]
		_label(body, detail, 24, true)
		var actions := HBoxContainer.new()
		actions.add_theme_constant_override("separation", 12)
		body.add_child(actions)
		_button(actions, "Показать", func():
			var current: Dictionary = sim.worker_by_id(uid)
			if not current.is_empty():
				_clear_selection()
				view.focus_cell(Vector2(current.x,current.y))
				view.selected = Vector2i(roundi(current.x),roundi(current.y))
				var job: Dictionary = sim.building_by_id(int(current.get("assignment_uid", -1)))
				if not job.is_empty(): selected_uid = int(job.uid); _inspect_building(), 170)
		_button(actions, "Переназначить", func(): _choose_staff(id, uid)).size_flags_horizontal = SIZE_EXPAND_FILL
		_button(actions, "Уволить", func():
			if sim.fire_worker(uid): sound.effect("hire"); show_staff(); save_game()
			else: _toast(sim.last_error), 162).theme_type_variation = "DangerButton"
	for role in ([] if show_team else sim.staff_catalog):
		var id := int(role.id)
		var card := PanelContainer.new()
		card.mouse_filter = MOUSE_FILTER_PASS
		card.add_theme_stylebox_override("panel", ArtTheme.box(ArtTheme.DEEP, ArtTheme.EDGE, 18))
		inspector_body.add_child(card)
		var row := HBoxContainer.new()
		row.add_theme_constant_override("separation", 18)
		card.add_child(row)
		var description := VBoxContainer.new()
		description.size_flags_horizontal = SIZE_EXPAND_FILL
		row.add_child(description)
		_label(description, str(role.name).capitalize(), 29, true)
		_label(description, STAFF_JOBS[id], 23, true)
		_label(description, "%d монет / луну · в парке %d" % [role.salary,sim.state.staff[id]], 23).add_theme_color_override("font_color", ArtTheme.MUTED)
		_button(row, "Нанять", func(): _choose_staff(id), 170)

	_layout()
	inspector_scroll.set_deferred("scroll_vertical", scroll_before)

func show_stats() -> void:
	_clear_selection()
	catalog_panel.hide()
	_clear(inspector_body)
	selected_uid = -1
	inspector.show()
	panel_mode = "stats"
	message_time = 0
	message_label.hide()
	inspector_title.text = "Мой парк"
	inspector_tabs.show()
	_update_inspector_tabs()
	var metrics := GridContainer.new()
	metrics.columns = 2
	metrics.size_flags_horizontal = SIZE_EXPAND_FILL
	metrics.add_theme_constant_override("h_separation", 14)
	metrics.add_theme_constant_override("v_separation", 14)
	inspector_body.add_child(metrics)
	for spec in [["Монеты", str(sim.state.money)], ["Настроение парка", "%d / 10" % sim.state.rating], ["Доходы", str(sim.state.income)], ["Расходы", str(sim.state.expenses)], ["Пришло гостей", str(sim.state.arrivals)], ["Постройки / дорожки", "%d / %d" % [sim.state.buildings.size(), sim.state.paths.size()]]]:
		var card := PanelContainer.new()
		card.mouse_filter = MOUSE_FILTER_PASS
		card.size_flags_horizontal = SIZE_EXPAND_FILL
		card.add_theme_stylebox_override("panel", ArtTheme.box(ArtTheme.DEEP, ArtTheme.EDGE, 16))
		metrics.add_child(card)
		var body := VBoxContainer.new()
		card.add_child(body)
		_label(body, spec[0], 23).add_theme_color_override("font_color", ArtTheme.MUTED)
		_label(body, spec[1], 36).add_theme_color_override("font_color", ArtTheme.GOLD)
	if not sim.state.visitors.is_empty():
		_label(inspector_body, "Самочувствие гостей · в среднем", 27)
		var needs := [0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0]
		for guest in sim.state.visitors:
			for index in 7: needs[index] += float(guest.needs[index]) / sim.state.visitors.size()
		for index in 7:
			var row := HBoxContainer.new()
			row.add_theme_constant_override("separation", 18)
			inspector_body.add_child(row)
			_label(row, ["Настроение", "Усталость", "Голод", "Туалет", "Жажда", "Здоровье", "Агрессия"][index], 24).custom_minimum_size.x = 240
			var bar := ProgressBar.new()
			bar.size_flags_horizontal = SIZE_EXPAND_FILL
			bar.size_flags_vertical = SIZE_SHRINK_CENTER
			bar.custom_minimum_size.y = 14
			bar.value = needs[index]
			bar.show_percentage = false
			var stress: float = 100 - needs[index] if index in [0, 5] else needs[index]
			bar.add_theme_stylebox_override("fill", ArtTheme.box(Color("d78664") if stress > 70 else ArtTheme.GOLD if stress > 45 else Color("a7bf62"), Color.TRANSPARENT, 0))
			row.add_child(bar)
			var number := _label(row, "%d / 100" % roundi(needs[index]), 24)
			number.custom_minimum_size.x = 130
			number.horizontal_alignment = HORIZONTAL_ALIGNMENT_RIGHT
	if int(sim.state.scenario) == -2:
		_label(inspector_body, "Лидерство: %d / 3 года\nКонкуренты: %s" % [sim.state.competition_streak, str(sim.state.competitors)], 25, true)
	_button(inspector_body, "Убрать дорожки и объекты…", func(): _toolbar("demolish")).theme_type_variation = "QuietButton"
	_button(inspector_body, "Обновить", show_stats)
	_layout()

func show_goals() -> void:
	_clear_selection()
	catalog_panel.hide()
	_clear(inspector_body)
	selected_uid = -1
	inspector.show()
	panel_mode = "goals"
	message_time = 0
	message_label.hide()
	inspector_title.text = "Мой парк"
	inspector_tabs.show()
	_update_inspector_tabs()
	_label(inspector_body, _scenario_name(int(sim.state.scenario)), 32, true)
	var goals: Dictionary = sim.goals()
	if int(sim.state.scenario) == 0:
		var tutorial: Dictionary = sim.tutorial_progress()
		_label(inspector_body, "Шаг %d из %d\n%s" % [mini(tutorial.step + 1, tutorial.total), tutorial.total, tutorial.label], 28, true)
	elif int(sim.state.scenario) >= 0:
		for id in ["money", "rating", "visitors"]:
			var goal: Dictionary = goals[id]
			_label(inspector_body, "%s: %d / %d" % [goal.label, goal.current, goal.target], 27, true)
			var bar := ProgressBar.new()
			bar.max_value = maxf(float(goal.target), 1)
			bar.value = goal.current
			bar.show_percentage = false
			bar.custom_minimum_size.y = 18
			inspector_body.add_child(bar)
	else:
		_label(inspector_body, "Создай парк, в который хочется вернуться." if int(sim.state.scenario) == -1 else "Занимай первое место три года подряд.\nТекущая серия: %d / 3" % sim.state.competition_streak, 28, true)
	var upcoming := false
	if int(sim.state.scenario) >= 0:
		for unlock in sim.scenarios[int(sim.state.scenario)].unlocks:
			if int(unlock.month) >= int(sim.state.month):
				if not upcoming: _label(inspector_body, "Новые изобретения", 29)
				upcoming = true
				_label(inspector_body, "Луна %d · %s" % [unlock.month, sim._catalog(unlock.kind, int(unlock.id)).name], 24, true)
	_button(inspector_body, "Обновить", show_goals)
	_layout()

func _cycle_speed() -> void:
	speed = {0: 1, 1: 2, 2: 4, 4: 0}[speed]
	speed_button.text = "Ⅱ" if speed == 0 else "▶ %d×" % speed

func _refresh_hud() -> void:
	if not running: return
	if selected_uid >= 0 and inspector.visible and is_instance_valid(building_status_label):
		var selected: Dictionary = sim.building_by_id(selected_uid)
		if not selected.is_empty():
			building_status_label.text = "Работает" if selected.working else str(selected.reason)
			if is_instance_valid(building_details_label): building_details_label.text = _building_summary(selected, sim._catalog(selected.kind, int(selected.type)))
	if selected_guest >= 0 and inspector.visible and is_instance_valid(guest_state_label):
		var guest: Dictionary = sim._visitor(selected_guest)
		if guest.is_empty():
			guest_state_label.text = "Посетитель покинул парк"
		else:
			guest_state_label.text = _guest_state(guest)
			view.selected = Vector2i(roundi(guest.x),roundi(guest.y))
			for i in mini(7,guest_needs_labels.size()):
				if is_instance_valid(guest_needs_labels[i]): guest_needs_labels[i].text = "%s: %d / 100" % [["Настроение","Усталость","Голод","Туалет","Жажда","Здоровье","Агрессия"][i],guest.needs[i]]
	stats_label.add_theme_font_size_override("font_size", 25 if size.y > size.x else 29)
	stats_label.text = "%d монет  ·  Гостей %d\nНастроение %d/10  ·  %d год, %d луна" % [sim.state.money, sim.state.visitors.size(), sim.state.rating, sim.state.year, int(sim.state.month) % 12 + 1] if size.y > size.x else "%d монет    ·    Гостей %d    ·    Настроение %d/10    ·    %d год, %d луна" % [sim.state.money, sim.state.visitors.size(), sim.state.rating, sim.state.year, int(sim.state.month) % 12 + 1]
	if int(sim.state.scenario) == 0:
		var tutorial: Dictionary = sim.tutorial_progress()
		tutorial_label.text = "Обучение %d/%d · %s" % [mini(tutorial.step + 1, tutorial.total), tutorial.total, tutorial.label]
	else:
		tutorial_label.text = "ТЕСТОВЫЙ ПАРК" if bool(sim.state.get("debug_used", sim.state.debug)) else ""
	if not sim.state.messages.is_empty() and (sim.state.messages.size() > last_messages or str(sim.state.messages[-1]) != last_message_text):
		last_message_text = str(sim.state.messages[-1])
		_toast(last_message_text)
		sound.effect("notification")
		last_messages = sim.state.messages.size()

func _toast(text: String) -> void:
	message_label.text = text
	message_label.show()
	toast_panel.show()
	message_time = 7.0

func _process(dt: float) -> void:
	if OS.has_feature("android"):
		var height := DisplayServer.virtual_keyboard_get_height()
		if height != keyboard_pixels:
			keyboard_pixels = height
			_layout()
	if suspended: return
	if running and not modal.visible:
		sim.advance(minf(dt, 0.25) * speed)
		view.advance(dt * speed)
		save_timer += dt
		hud_timer += dt
		if hud_timer >= 0.5:
			hud_timer = 0
			_refresh_hud()
		if save_timer >= 15: save_game()
		if sim.state.status != "playing" and not result_shown:
			result_shown = true
			save_game()
			sound.effect("success" if sim.state.status == "won" else "error")
			show_page("result")
	message_time = maxf(0, message_time - dt)
	toast_panel.visible = message_time > 0 and not catalog_panel.visible
	message_label.visible = message_time > 0

func _notification(what: int) -> void:
	if not is_instance_valid(sound): return
	if what in [NOTIFICATION_APPLICATION_PAUSED, NOTIFICATION_APPLICATION_FOCUS_OUT]:
		save_game()
		suspended = true
		view.cancel_input()
		sound.suspend(true)
	elif what in [NOTIFICATION_APPLICATION_RESUMED, NOTIFICATION_APPLICATION_FOCUS_IN]:
		suspended = false
		sound.suspend(false)
	elif what == NOTIFICATION_WM_GO_BACK_REQUEST:
		_go_back()
	elif what == NOTIFICATION_WM_CLOSE_REQUEST:
		_quit_game()

func _unhandled_key_input(event: InputEvent) -> void:
	if event.is_action_pressed("ui_cancel"):
		_go_back()
		get_viewport().set_input_as_handled()

func _go_back() -> void:
	if not modal.visible:
		if tool_kind != "select" or catalog_panel.visible or inspector.visible: _clear_selection()
		else: save_game(); show_page("pause")
	elif page == "pause": resume_game()
	elif page == "demolish_confirm": _cancel_demolition()
	elif page == "setup": show_page("scenarios" if chosen_scenario > 0 else "new")
	elif page == "scenarios": show_page("new")
	elif page in ["reset_settings", "restore_backup", "data_notice", "import_confirm"]: pending_import = {}; show_page("settings")
	elif page == "guide": show_page("help")
	elif page == "home": _quit_game()
	else: show_page("pause" if running else "home")

func _quit_game() -> void:
	save_game()
	sound.shutdown()
	get_tree().quit()

func _exit_tree() -> void:
	if is_instance_valid(sound): sound.shutdown()

func _update_inspector_tabs() -> void:
	for tab in inspector_tabs.get_children():
		ArtTheme.selected(tab, tab.get_meta("page") == panel_mode)

func _prop_next(id: int) -> int:
	return {0: 1, 1: 2, 2: 3, 3: 0, 4: 5, 5: 6, 6: 7, 7: 4, 8: 9, 9: 8, 10: 11, 11: 10, 15: 16, 16: 15, 17: 18, 18: 17, 20: 21, 21: 20}.get(id, id)

func _rotate_build() -> void:
	if tool_kind == "prop":
		tool_id = _prop_next(tool_id)
		view.preview_type = tool_id
	else:
		build_rotation = 1 - build_rotation
		view.preview_rotation = build_rotation
	view.queue_redraw()
	_build_info()

func _page_header(title: String, close: Callable) -> void:
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 16)
	modal_body.add_child(row)
	var heading := _label(row, title, 40, true)
	heading.size_flags_horizontal = SIZE_EXPAND_FILL
	heading.vertical_alignment = VERTICAL_ALIGNMENT_CENTER
	_button(row, "×", close, 88).tooltip_text = "Закрыть"

func _home_page() -> void:
	var saved: Dictionary = sim.state if running else {}
	if not running:
		for path in [save_path, save_path + ".bak"]:
			var data := Store.read_json(path)
			if data.get("format") != "prehistorik-park" or not data.get("game") is Dictionary: continue
			var candidate: Dictionary = data.game
			if not candidate.get("money") is float and not candidate.get("money") is int: continue
			if not candidate.get("scenario") is float and not candidate.get("scenario") is int: continue
			saved = candidate
			break
	home_has_save = not saved.is_empty()
	var greeting := _label(modal_body, "ТВОЙ ПАРК ЖДЁТ" if home_has_save else "ПОСТРОИМ ЧТО-НИБУДЬ ВЕЛИКОЕ?", 25, true)
	greeting.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	greeting.add_theme_color_override("font_color", ArtTheme.MUTED)
	if home_has_save:
		var details := _label(modal_body, "%s · %d монет\n%d год · %d луна" % [_scenario_name(int(saved.get("scenario", 0))), int(saved.get("money", 0)), int(saved.get("year", 1)), int(saved.get("month", 0)) % 12 + 1], 24, true)
		details.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	var play := _button(modal_body, "Продолжить парк" if home_has_save else "Начать игру", load_game if home_has_save else func(): show_page("new"))
	play.theme_type_variation = "PrimaryButton"
	play.custom_minimum_size.y = 122
	play.add_theme_font_size_override("font_size", 34)
	if home_has_save: _button(modal_body, "Новый парк", func(): show_page("new"))
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 16)
	modal_body.add_child(row)
	for spec in [["Настройки", "settings"], ["Как играть", "help"]]:
		var next: String = spec[1]
		var button := _button(row, str(spec[0]), func(): show_page(next))
		button.size_flags_horizontal = SIZE_EXPAND_FILL
		button.icon = ArtTheme.icon(next)
		button.expand_icon = true
	var about := _button(modal_body, "Об игре", func(): show_page("credits"))
	about.theme_type_variation = "QuietButton"
	about.custom_minimum_size.y = 72

func _request_demolition(cell: Vector2i) -> void:
	var building: Dictionary = sim.building_at(cell)
	if building.is_empty() and not sim.state.paths.has(sim._key(cell)) and int(sim.state.terrain.get(sim._key(cell), 1)) >= 0:
		_toast("Здесь нечего сносить")
		return
	pending_demolition = cell
	demolition_return = tool_kind
	show_page("demolish_confirm")

func _demolition_page() -> void:
	var b: Dictionary = sim.building_at(pending_demolition)
	var title := "дорожку" if b.is_empty() else str(sim._catalog(b.kind, int(b.type)).name)
	_page_header("Снести объект?", _cancel_demolition)
	_label(modal_body, "Убрать %s из парка?" % title, 30, true)
	_label(modal_body, "Действие нельзя отменить. Объект придётся строить заново.", 26, true)
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 18)
	modal_body.add_child(row)
	_button(row, "Оставить", _cancel_demolition).size_flags_horizontal = SIZE_EXPAND_FILL
	var confirm := _button(row, "Снести", _confirm_demolition)
	confirm.size_flags_horizontal = SIZE_EXPAND_FILL
	confirm.theme_type_variation = "DangerButton"

func _cancel_demolition() -> void:
	pending_demolition = Vector2i(-1, -1)
	resume_game()
	_layout()

func _confirm_demolition() -> void:
	var cell := pending_demolition
	var b: Dictionary = sim.building_at(cell)
	var name := "дорожка" if b.is_empty() else str(sim._catalog(b.kind, int(b.type)).name)
	if sim.demolish(cell):
		sound.effect("demolish")
		view.burst(cell, true)
		if demolition_return != "demolish": _clear_selection()
		save_game()
		resume_game()
		_toast("Снесено: " + name)
	else:
		resume_game()
		_toast(sim.last_error)
	pending_demolition = Vector2i(-1, -1)
	_refresh_hud()
	_layout()

func _choice(parent: Node, title: String, description: String, callback: Callable) -> Button:
	var button := _button(parent, "", callback)
	button.theme_type_variation = "CatalogCard"
	button.custom_minimum_size.y = 158
	var margin := MarginContainer.new()
	margin.mouse_filter = MOUSE_FILTER_IGNORE
	for side in ["left", "right", "top", "bottom"]: margin.add_theme_constant_override("margin_" + side, 24)
	button.add_child(margin)
	margin.set_anchors_and_offsets_preset(PRESET_FULL_RECT)
	var body := VBoxContainer.new()
	body.mouse_filter = MOUSE_FILTER_IGNORE
	body.add_theme_constant_override("separation", 8)
	margin.add_child(body)
	var heading := _label(body, title + "  ›", 31, true)
	heading.mouse_filter = MOUSE_FILTER_IGNORE
	heading.add_theme_font_override("font", preload("res://assets/ui/fonts/NotoSans-Bold.ttf"))
	var detail := _label(body, description, 24, true)
	detail.mouse_filter = MOUSE_FILTER_IGNORE
	detail.add_theme_color_override("font_color", ArtTheme.MUTED)
	return button

func _load_menu_art() -> void:
	if home_background.texture != null and home_background.get_meta("mode", "") == applied_quality: return
	var path := Graphics.menu_path(applied_quality, true)
	if not ResourceLoader.exists(path): return
	var source: Texture2D = load(path)
	home_background.texture = source
	home_background.set_meta("mode", applied_quality)
	home_background.texture_filter = Graphics.texture_filter(applied_quality)

func _build_motor() -> void:
	if not sim.availability("prop", 26): show_catalog("rides")
	else:
		_clear_selection()
		catalog_category = "rides"
	_choose_build("prop", 26)
