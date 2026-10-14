# Разработка и сборка

Проверенная среда: Linux, Godot 4.7.2, Python 3.14 / Pillow 12.3,
Android SDK Platform 35, Build-Tools 35.0.0, OpenJDK 27.
Для экспорта нужны Android export templates **той же версии, что и Godot**.

## Быстрый запуск

```sh
python -m venv .venv
. .venv/bin/activate
pip install -r requirements-dev.txt
godot --headless --path game --editor --import --quit
godot --path game
```

Игра запускается без Python, ComfyUI, моделей и сетевых сервисов.
Python нужен только для проверок и подготовки ресурсов. `ripgrep`, `timeout`,
`rsvg-convert` (librsvg) и Bash нужны для `tools/check.sh`.

## Проверки

```sh
bash tools/check.sh
godot --path game --script res://tests/release_check.gd
godot --path game --script res://tests/joints_check.gd -- --output=/tmp/park-joints
godot --path game --script res://tests/redesign_check.gd -- \
  --screenshots=/tmp/park-ui
```

`check.sh` проверяет оригинальные данные, происхождение апскейла, симуляцию,
композицию слоёв, полноту ремейка, интерфейс, четыре режима графики, звук, настройки и сохранения.
Логи: `build/reports_1.1.1/`. Можно переопределить `GODOT_BIN` и `PARK_REPORT_DIR`.
Графические проверки запускай с доступным Vulkan/OpenGL; headless не измеряет FPS.

Полное прохождение сценариев:

```sh
godot --headless --path game --script res://tests/economy_acceptance.gd
PARK_ACCEPTANCE_DIFFICULTY=1 godot --headless --path game \
  --script res://tests/economy_acceptance.gd
```

Эти проверки обновляют `art/review/acceptance_park.json` результатом шестого сценария.
Для сравнительных замеров используй одну и ту же копию fixture.

## Android APK

В Godot Editor Settings укажи Java SDK Path и Android SDK Path.
[Официальная инструкция Godot](https://docs.godotengine.org/en/stable/tutorials/export/exporting_for_android.html).
Секреты подписи передаются переменными окружения, не записываются в репозиторий:

```sh
export ANDROID_HOME="$HOME/Android/Sdk"
export GODOT_ANDROID_KEYSTORE_RELEASE_PATH=/private/path/park.keystore
export GODOT_ANDROID_KEYSTORE_RELEASE_USER=your-key-alias
read -rs GODOT_ANDROID_KEYSTORE_RELEASE_PASSWORD
export GODOT_ANDROID_KEYSTORE_RELEASE_PASSWORD
bash tools/build_apk.sh
```

Результат: `build/prehistorik_park_1.1.1.apk` и `build/prehistorik_park.apk`.
Скрипт выполняет проверки, **export-release**, проверку подписи, AndroidManifest,
CRC, наличие текстур и отсутствие тестов/ключей в архиве. Никаких запросов генерации.
Для другой версии Build-Tools задай `ANDROID_BUILD_TOOLS`.

Релиз 1.1.1 сохраняет сертификат предыдущих APK для совместимого обновления.
Это существующий локальный development-сертификат; сам бинарник собран без debug.
Подпись для публикации в Google Play и AAB в этот релиз не входят.
Репозиторий публичный. В GitHub Releases публикуются только APK и описание
исправлений; отчёты, скриншоты и галереи не прикладываются к релизам.

На машине автора настройки подписи находятся вне проекта в
`~/.config/prehistorik-park/signing.env` (права 0600); резервируй ключ отдельно.

## Эмулятор

Установлен Android Emulator 37.2.12, Google APIs API 35 x86_64,
AVD `PrehistorikPark_API35`, Pixel 7, 1080×2400, 3 ГиБ RAM, KVM.
Google APIs образ поддерживает ARM-трансляцию для поставляемой ARM64 APK.

```sh
tools/run_android_emulator.sh
```

Лаунчер ставит текущую сборку и открывает игру. Использует пользовательский systemd-unit
`prehistorik-android-emulator` и ADB `emulator-5580`. На новом компьютере нужно
сначала установить SDK/образ и создать AVD с таким именем.

На NVIDIA этого компьютера Vulkan эмулятора даёт чёрный экран, поэтому указан
`-feature -Vulkan`: Godot автоматически переходит на аппаратный OpenGL ES 3.1.
На устройстве игра сохраняет обычный выбор Vulkan с запасным OpenGL.

Для проверки сенсорной клавиатуры AVD настроен с `hw.keyboard = no`.
Эмулятор всё равно создаёт AT PS/2 keyboard; Godot считает его физической клавиатурой
и не открывает экранную. В этой сессии отключён только этот виртуальный PS/2-драйвер
через `adb root` и `echo -n serio0 > /sys/bus/serio/drivers/atkbd/unbind`
внутри эмулятора. Перезапуск эмулятора восстанавливает драйвер. Это не требуется
на обычном телефоне без подключённой клавиатуры.

## Ресурсы

Все готовые ресурсы входят в Git, скачивание моделей для сборки не требуется.
Каталог проверок апскейла содержит исходные GPU-выходы и журналы для сверки хэшей.

```sh
python art/repair_geometry.py
godot --path game --script res://tests/export_catalog.gd
godot --headless --path game --editor --import --quit
```

Эта последовательность пересобирает стыки ремейка, 153 каталожных превью и импорты.
Генерация заставки через локальный ComfyUI описана в [art/README.md](../art/README.md).

Полная сверка текстур и кадров:

```sh
python art/check_parts.py
python art/audit_remake.py --out art/review/remake_audit/after
godot --path game --rendering-method gl_compatibility \
  --script res://tests/render_remake_audit.gd
python art/package_remake_audit.py
```

Команда Godot требует GPU и сохраняет 1191 сравнительный кадр вне `game/`.
Все 7821 отрисовки проверяются на пустоту и выход за границы камеры;
визуальную полноту проверяй по контактным листам и отчёту, а не только по альфа-покрытию.
