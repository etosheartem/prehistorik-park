#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
: "${GODOT_ANDROID_KEYSTORE_RELEASE_PATH:?Set the release keystore path}"
: "${GODOT_ANDROID_KEYSTORE_RELEASE_USER:?Set the signing key alias}"
: "${GODOT_ANDROID_KEYSTORE_RELEASE_PASSWORD:?Set the signing password}"
report="${PARK_REPORT_DIR:-build/reports_1.1.0}"
engine="${GODOT_BIN:-godot}"
apk="build/prehistorik_park_1.1.0.apk"
sdk_tools="${ANDROID_HOME:-${ANDROID_SDK_ROOT:-$HOME/Android/Sdk}}/build-tools/${ANDROID_BUILD_TOOLS:-35.0.0}"
bash tools/check.sh
timeout 300s "$engine" --headless --path game --export-release Android "$(pwd)/$apk" > "$report/export.log" 2>&1
if rg -n 'SCRIPT ERROR|ERROR:' "$report/export.log"; then exit 1; fi
"$sdk_tools/apksigner" verify --verbose --print-certs "$apk" > "$report/signature.txt"
"$sdk_tools/aapt2" dump badging "$apk" > "$report/package.txt"
"$sdk_tools/aapt2" dump xmltree "$apk" --file AndroidManifest.xml > "$report/android_manifest.txt"
python tools/check_apk.py "$apk" "$report/android_manifest.txt"
cp "$apk" build/prehistorik_park.apk
if [ -f "$apk.idsig" ]; then cp "$apk.idsig" build/prehistorik_park.apk.idsig; fi
sha256sum "$apk" > "$report/sha256.txt"
cat "$report/sha256.txt"
