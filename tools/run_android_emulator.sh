#!/usr/bin/env bash
# Start the installed Pixel emulator and open the current Android build.
set -euo pipefail
cd "$(dirname "$0")/.."
park_sdk="${ANDROID_SDK_ROOT:-${ANDROID_HOME:-$HOME/Android/Sdk}}"
park_avd="PrehistorikPark_API35"
park_serial="emulator-5580"
park_apk="${1:-build/prehistorik_park.apk}"
park_logs="build/reports_0.3/android_emulator"
park_adb="$park_sdk/platform-tools/adb"
mkdir -p "$park_logs"
exec 9>"$park_logs/launcher.lock"
flock -n 9 || exit 0

if [[ ! -x "$park_sdk/emulator/emulator" || ! -f "$park_apk" ]]; then
    echo "Android Emulator or APK is missing: $park_sdk / $park_apk" >&2
    exit 1
fi
if "$park_adb" -s "$park_serial" get-state >/dev/null 2>&1; then
    if ! "$park_adb" -s "$park_serial" emu avd name | tr -d '\r' | grep -Fxq "$park_avd"; then
        echo "Port 5580 belongs to a different emulator." >&2
        exit 1
    fi
else
    # A user service keeps the emulator alive after the launcher/terminal exits.
    # Vulkan presentation fails on this host; the APK falls back to GLES 3.
    systemd-run --user --collect --unit=prehistorik-android-emulator \
        --setenv=QT_QPA_PLATFORM=xcb --setenv="DISPLAY=${DISPLAY:-:0}" \
        --property="StandardOutput=append:$PWD/$park_logs/emulator.log" \
        --property=StandardError=inherit \
        "$park_sdk/emulator/emulator" \
        -avd "$park_avd" -port 5580 -gpu host -memory 3072 -cores 4 \
        -feature -Vulkan -no-snapshot -no-boot-anim -no-metrics
fi

timeout 180 "$park_adb" -s "$park_serial" wait-for-device
park_deadline=$((SECONDS + 180))
until [[ "$("$park_adb" -s "$park_serial" shell getprop sys.boot_completed 2>/dev/null | tr -d '\r')" == 1 ]]; do
    if (( SECONDS >= park_deadline )); then
        echo "Android did not finish booting; see $park_logs/emulator.log" >&2
        exit 1
    fi
    sleep 2
done
"$park_adb" -s "$park_serial" shell input keyevent KEYCODE_WAKEUP
"$park_adb" -s "$park_serial" shell wm dismiss-keyguard
"$park_adb" -s "$park_serial" install -r "$park_apk"
"$park_adb" -s "$park_serial" shell am start -W \
    -n ru.artem.prehistorikpark/com.godot.game.GodotAppLauncher
