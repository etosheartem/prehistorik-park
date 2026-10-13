#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
report="${PARK_REPORT_DIR:-build/reports_1.0}"
engine="${GODOT_BIN:-godot}"
mkdir -p "$report"
python art/upscale_original.py --check > "${report}/upscale.log" 2>&1
tail -n 1 "${report}/upscale.log"
for exporter in export_data export_text export_audio check_assets; do
    args=()
    if [ "$exporter" != check_assets ]; then args+=(--check); fi
    python "original/$exporter.py" "${args[@]}" > "${report}/$exporter.log" 2>&1
    tail -n 1 "${report}/$exporter.log"
done
timeout 300s "$engine" --headless --path game --editor --import --quit > "${report}/import.log" 2>&1
if rg -n 'SCRIPT ERROR|ERROR:' "${report}/import.log"; then
    echo "Import failed; see ${report}/import.log" >&2
    exit 1
fi
for suite in simulation layers_check interface_check redesign_check graphics_check audio_check simulation_perf release_check; do
    args=()
    if [ "$suite" == graphics_check ]; then args+=(-- --require-upscale); fi
    timeout 180s "$engine" --headless --path game --script "res://tests/$suite.gd" "${args[@]}" > "${report}/$suite.log" 2>&1
    if rg -n 'SCRIPT ERROR|ERROR:|FAILED|FAIL:|FAIL ' "${report}/$suite.log"; then
        echo "Check failed: $suite" >&2
        exit 1
    fi
    tail -n 1 "${report}/$suite.log"
done
