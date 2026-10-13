#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
mkdir -p build/reports_0.3
apk="build/prehistorik_park_0.3.apk"
python art/upscale_original.py --check > build/reports_0.3/upscale.log 2>&1
tail -n 1 build/reports_0.3/upscale.log
for exporter in export_data export_text export_audio check_assets; do
    args=()
    if [ "$exporter" != check_assets ]; then args+=(--check); fi
    python "original/$exporter.py" "${args[@]}" > "build/reports_0.3/$exporter.log" 2>&1
    tail -n 1 "build/reports_0.3/$exporter.log"
done
timeout 300s godot --headless --path game --editor --import --quit > build/reports_0.3/import.log 2>&1
if rg -n 'SCRIPT ERROR|ERROR:' build/reports_0.3/import.log; then
    echo 'Import failed; see build/reports_0.3/import.log' >&2
    exit 1
fi
for suite in simulation layers_check interface_check redesign_check graphics_check audio_check simulation_perf; do
    args=()
    if [ "$suite" == graphics_check ]; then args+=(-- --require-upscale); fi
    timeout 180s godot --headless --path game --script "res://tests/$suite.gd" "${args[@]}" > "build/reports_0.3/$suite.log" 2>&1
    if rg -n 'SCRIPT ERROR|ERROR:|FAILED|FAIL:|FAIL ' "build/reports_0.3/$suite.log"; then
        echo "Check failed: $suite" >&2
        exit 1
    fi
    tail -n 1 "build/reports_0.3/$suite.log"
done
timeout 300s godot --headless --path game --export-debug Android "$(pwd)/$apk" > build/reports_0.3/export.log 2>&1
if rg -n 'SCRIPT ERROR|ERROR:' build/reports_0.3/export.log; then
    echo 'Export failed; see build/reports_0.3/export.log' >&2
    exit 1
fi
sdk_tools="${ANDROID_HOME:-/home/artem/Android/Sdk}/build-tools/35.0.0"
"$sdk_tools/apksigner" verify --verbose "$apk" > build/reports_0.3/signature.txt
"$sdk_tools/aapt2" dump badging "$apk" > build/reports_0.3/package.txt
"$sdk_tools/aapt2" dump xmltree "$apk" --file AndroidManifest.xml > build/reports_0.3/android_manifest.txt
python tools/check_apk.py "$apk" build/reports_0.3/android_manifest.txt
cp "$apk" build/prehistorik_park.apk
if [ -f "$apk.idsig" ]; then
    cp "$apk.idsig" build/prehistorik_park.apk.idsig
fi
sha256sum "$apk" > build/reports_0.3/sha256.txt
cat build/reports_0.3/sha256.txt
