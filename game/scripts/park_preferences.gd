extends RefCounted
## Settings are composed here; game rules and the player's park stay untouched.
const Graphics = preload("res://scripts/park_graphics.gd")
const ArtTheme = preload("res://scripts/park_theme.gd")

static func build(game) -> void:
	game._page_header("Настройки", func(): game.show_page("pause" if game.running else "home"))
	var tabs := HBoxContainer.new()
	tabs.add_theme_constant_override("separation", 8)
	game.modal_body.add_child(tabs)
	for spec in [["Оформление", "graphics"], ["Звук", "audio"], ["Управление", "controls"], ["Сохранения", "saves"]]:
		var id: String = spec[1]
		var button: Button = game._button(tabs, spec[0], func(): game.settings_tab = id; game.show_page("settings"))
		button.size_flags_horizontal = Control.SIZE_EXPAND_FILL
		button.add_theme_font_size_override("font_size", 23)
		ArtTheme.selected(button, game.settings_tab == id)
	match game.settings_tab:
		"graphics": graphics(game)
		"audio": audio(game)
		"controls": controls(game)
		"saves": saves(game)
	var note: Label = game._label(game.modal_body, "Изменения сохраняются автоматически", 22, true)
	note.add_theme_color_override("font_color", ArtTheme.MUTED)
	note.horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	game._button(game.modal_body, "Готово", func(): game.show_page("pause" if game.running else "home")).theme_type_variation = "PrimaryButton"

static func section(game, title: String) -> void:
	var label: Label = game._label(game.modal_body, title, 23, true)
	label.add_theme_color_override("font_color", ArtTheme.MUTED)

static func options(game, key: String, items: Array, refresh := true) -> void:
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 10)
	game.modal_body.add_child(row)
	for item in items:
		var value = item[1]
		var button: Button = game._button(row, item[0], func():
			game.settings[key] = value
			game._apply_settings()
			if refresh: game.show_page("settings"))
		button.size_flags_horizontal = Control.SIZE_EXPAND_FILL
		button.add_theme_font_size_override("font_size", 24)
		button.set_meta("setting", key)
		button.set_meta("value", value)
		ArtTheme.selected(button, game.settings.get(key) == value)
		if game.settings.get(key) == value: button.icon = ArtTheme.icon("check")

static func toggle(game, title: String, description: String, key: String) -> void:
	var panel := PanelContainer.new()
	panel.theme_type_variation = "PaperPanel"
	game.modal_body.add_child(panel)
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 16)
	panel.add_child(row)
	var text := VBoxContainer.new()
	text.size_flags_horizontal = Control.SIZE_EXPAND_FILL
	row.add_child(text)
	game._label(text, title, 28, true)
	game._label(text, description, 22, true).add_theme_color_override("font_color", ArtTheme.MUTED)
	var button: Button = game._button(row, "Вкл" if game.settings[key] else "Выкл", func():
		game.settings[key] = not bool(game.settings[key])
		game._apply_settings()
		game.show_page("settings"), 120)
	button.set_meta("setting", key)
	ArtTheme.selected(button, bool(game.settings[key]))

static func graphics(game) -> void:
	var remake := Graphics.is_remake(str(game.settings.quality))
	var preview := preload("res://scripts/park_preview.gd").new()
	preview.options = game.settings.duplicate(true)
	preview.custom_minimum_size.y = 280
	preview.clip_contents = true
	game.modal_body.add_child(preview)
	var mode: String = str(game.settings.quality)
	var caption: String = "Новая графика, прежний характер" if remake else "Исходные рисунки, аккуратный апскейл ×4" if mode == "original_upscaled" else "Каждый пиксель оригинальной игры"
	game._label(game.modal_body, caption, 26, true).horizontal_alignment = HORIZONTAL_ALIGNMENT_CENTER
	section(game, "СТИЛЬ ПАРКА")
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 10)
	game.modal_body.add_child(row)
	for item in [["Классика", "original"], ["Апскейл ×4", "original_upscaled"], ["Ремейк", "remake_maximum"]]:
		var id: String = item[1]
		var active: bool = remake if id == "remake_maximum" else game.settings.quality == id
		var button: Button = game._button(row, item[0], func():
			game.settings.quality = game.remake_quality if id == "remake_maximum" else id
			game._apply_settings(); game.show_page("settings"))
		button.size_flags_horizontal = Control.SIZE_EXPAND_FILL
		button.add_theme_font_size_override("font_size", 26)
		button.set_meta("graphics_style", id)
		ArtTheme.selected(button, active)
		if active: button.icon = ArtTheme.icon("check")
	if remake:
		section(game, "ДЕТАЛИЗАЦИЯ РЕМЕЙКА")
		options(game, "quality", [["Баланс", "remake_medium"], ["Все детали", "remake_maximum"]])
		game._label(game.modal_body, "Компактные текстуры · меньше памяти" if game.settings.quality == "remake_medium" else "Полные текстуры · для крупных экранов", 23, true).add_theme_color_override("font_color", ArtTheme.MUTED)
		section(game, "ЦВЕТ")
		options(game, "color_style", [["Естественный", "natural"], ["Сочный", "vivid"], ["Тёплый", "warm"]])
	section(game, "ПЛАВНОСТЬ")
	options(game, "fps", [["30 кадров · экономия", 30], ["60 кадров · плавно", 60]])
	if remake:
		var effects_row := HBoxContainer.new()
		effects_row.add_theme_constant_override("separation", 10)
		game.modal_body.add_child(effects_row)
		for item in [["Тени", "shadows"], ["Частицы", "particles"]]:
			var key: String = item[1]
			var button: Button = game._button(effects_row, item[0] + (": вкл" if game.settings[key] else ": выкл"), func():
				game.settings[key] = not bool(game.settings[key]); game._apply_settings(); game.show_page("settings"))
			button.size_flags_horizontal = Control.SIZE_EXPAND_FILL
			button.set_meta("setting", key)
			ArtTheme.selected(button, bool(game.settings[key]))

static func audio(game) -> void:
	game._label(game.modal_body, "Звуки большого маленького парка", 31, true)
	game._label(game.modal_body, "Музыка и эффекты настраиваются отдельно. При сворачивании игры звук останавливается.", 25, true)
	for spec in [["Музыка", "music"], ["Эффекты", "effects"]]:
		var key: String = spec[1]
		var value: Label = game._label(game.modal_body, "%s · %d%%" % [spec[0], roundi(float(game.settings[key]) * 100)], 29)
		var slider := HSlider.new()
		slider.max_value = 100
		slider.step = 1
		slider.value = float(game.settings[key]) * 100
		slider.custom_minimum_size.y = 88
		slider.set_meta("setting", key)
		game.modal_body.add_child(slider)
		slider.value_changed.connect(func(number):
			game.settings[key] = number / 100
			value.text = "%s · %d%%" % [spec[0], int(number)]
			game.sound.configure(game.settings))
		slider.drag_ended.connect(func(_changed):
			game._apply_settings()
			if key == "effects": game.sound.effect("build"))
	game._button(game.modal_body, "Проверить звук", func(): game.sound.effect("success"))
	game._button(game.modal_body, "Выключить весь звук", func():
		game.settings.music = 0.0; game.settings.effects = 0.0
		game._apply_settings(); game.show_page("settings"))

static func controls(game) -> void:
	section(game, "КАМЕРА")
	game._label(game.modal_body, "Один палец — движение. Два — масштаб. На компьютере работает колесо мыши.", 26, true)
	options(game, "camera_speed", [["Точно", 0.7], ["Обычно", 1.0], ["Быстро", 1.4]])
	toggle(game, "Сетка при строительстве", "Клетки видны только во время размещения", "build_grid")
	toggle(game, "Прозрачные кроны", "Деревья не закрывают гостей, аттракционы и место строительства", "transparent_trees")
	toggle(game, "Меньше движения", "Без фоновых частиц и вспышек строительства", "reduced_motion")
	game._label(game.modal_body, "Кнопка «К парку» возвращает камеру к постройкам. Назад закрывает текущую панель, затем открывает паузу.", 25, true)
	game._button(game.modal_body, "Сбросить настройки…", func(): game.show_page("reset_settings"))

static func saves(game) -> void:
	game._label(game.modal_body, "Твой парк — на этом устройстве", 31, true)
	game._label(game.modal_body, "Автосохранение каждые 15 секунд и при сворачивании. Последняя рабочая запись защищена резервной копией.", 25, true)
	var backup: Dictionary = game.Store.read_json(game.manual_save_path())
	var saved := str(backup.get("saved_at", ""))
	section(game, "ЛИЧНАЯ КОПИЯ")
	game._label(game.modal_body, "Ещё не создана" if saved.is_empty() else "Создана: " + saved.replace("T", " · "), 27, true)
	game._label(game.modal_body, "Личная копия хранится отдельно. Автосохранение её не заменяет — можно смело попробовать другую стратегию.", 25, true)
	var create: Button = game._button(game.modal_body, "Сохранить личную копию", func(): game.make_manual_backup())
	create.disabled = not game.running
	var restore: Button = game._button(game.modal_body, "Восстановить копию…", func(): game.show_page("restore_backup"))
	restore.disabled = backup.is_empty()
	if not game.running: game._label(game.modal_body, "Продолжи или создай парк, чтобы сделать копию.", 23, true)

	section(game, "ПЕРЕНОС НА ДРУГОЕ УСТРОЙСТВО")
	var row := HBoxContainer.new()
	row.add_theme_constant_override("separation", 10)
	game.modal_body.add_child(row)
	var export_button: Button = game._button(row, "Экспорт в файл", func(): game.choose_save_file(true))
	export_button.size_flags_horizontal = Control.SIZE_EXPAND_FILL
	export_button.disabled = not game.running and not FileAccess.file_exists(game.save_path)
	game._button(row, "Импорт из файла…", func(): game.choose_save_file(false)).size_flags_horizontal = Control.SIZE_EXPAND_FILL

	for item in [["До последнего восстановления…", ".before_restore.json"], ["Предыдущий парк…", ".previous_park.json"]]:
		var backup_path: String = game.save_path + item[1]
		if FileAccess.file_exists(backup_path):
			game._button(game.modal_body, item[0], func(): game.prepare_import(backup_path))
