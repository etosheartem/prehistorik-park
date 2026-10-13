#!/usr/bin/env python3
"""Render the original MIDI with the installed JDK and synthesize tiny local SFX."""
from __future__ import annotations

import argparse
import hashlib
import json
import math
from pathlib import Path
import random
import shutil
import struct
import subprocess
import tempfile
import wave

ROOT = Path(__file__).resolve().parents[1]
OUTPUT = ROOT / "game/assets/audio"
RATE = 44100


def sha(path: Path) -> str:
    return hashlib.sha256(path.read_bytes()).hexdigest()


def tone(samples: list[float], start: float, duration: float, hz: float, level: float, kind: str) -> None:
    rng = random.Random(int(hz * 100 + start * 1000))
    noise_previous = 0.0
    for frame in range(round(duration * RATE)):
        index = round(start * RATE) + frame
        if index >= len(samples):
            break
        t = frame / RATE
        attack = min(1, t / 0.003)
        decay = math.exp(-t / (duration * 0.22))
        tail = min(1, (duration - t) / 0.012)
        wave_value = math.sin(2 * math.pi * hz * t)
        if kind == "wood":
            wave_value += 0.4 * math.sin(2 * math.pi * hz * 2.76 * t) + 0.15 * rng.uniform(-1, 1)
        elif kind == "bell":
            wave_value += 0.3 * math.sin(2 * math.pi * hz * 2 * t) + 0.12 * math.sin(2 * math.pi * hz * 4.13 * t)
        elif kind == "rubble":
            noise_previous = noise_previous * 0.7 + rng.uniform(-1, 1) * 0.3
            wave_value = noise_previous * 1.9 + wave_value * 0.15
        samples[index] += wave_value * level * attack * decay * tail


def effect(name: str, duration: float, notes: list[tuple]) -> dict:
    samples = [0.0] * round(duration * RATE)
    for note in notes:
        tone(samples, *note)
    peak = max(abs(value) for value in samples)
    assert 0.005 < peak < 0.92, (name, peak)
    path = OUTPUT / f"{name}.wav"
    with wave.open(str(path), "wb") as handle:
        handle.setnchannels(1)
        handle.setsampwidth(2)
        handle.setframerate(RATE)
        handle.writeframes(b"".join(struct.pack("<h", round(max(-1, min(1, value)) * 32767)) for value in samples))
    return {"file": path.name, "seconds": duration, "peak_dbfs": round(20 * math.log10(peak), 2), "sha256": sha(path)}


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="Validate existing output hashes and source provenance")
    args = parser.parse_args()
    manifest_path = OUTPUT / "manifest.json"
    if args.check:
        manifest = json.loads(manifest_path.read_text())
        assert manifest["music"]["source_sha256"] == sha(ROOT / manifest["music"]["source"])
        for entry in [manifest["music"], *manifest["effects"].values()]:
            assert sha(OUTPUT / entry["file"]) == entry["sha256"], entry["file"]
        print("AUDIO ASSETS OK: original MIDI + 7 local effects; no paid API")
        return
    OUTPUT.mkdir(parents=True, exist_ok=True)
    wav = ROOT / "original/exports/audio/entry.wav"
    wav.parent.mkdir(parents=True, exist_ok=True)
    source = ROOT / "original/jar/sound/entry.mid"
    with tempfile.TemporaryDirectory(prefix="park-midi-") as temp:
        java_args = ["--add-exports", "java.desktop/com.sun.media.sound=ALL-UNNAMED"]
        subprocess.run(["javac", *java_args, "-d", temp, str(ROOT / "original/RenderMidi.java")], check=True)
        subprocess.run(["java", *java_args, "-cp", temp, "RenderMidi", str(source), str(wav)], check=True)
    duration = float(subprocess.check_output(["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "default=noprint_wrappers=1:nokey=1", str(wav)]))
    subprocess.run([
        "ffmpeg", "-hide_banner", "-loglevel", "warning", "-y", "-i", str(wav),
        "-af", f"loudnorm=I=-20:TP=-2:LRA=9,afade=t=in:d=0.025,afade=t=out:st={duration - 0.8:.6f}:d=0.8",
        "-ar", str(RATE), "-c:a", "libvorbis", "-q:a", "5", str(OUTPUT / "entry.ogg"),
    ], check=True)
    effects = {
        "click": effect("click", 0.12, [(0, .11, 340, .28, "wood")]),
        "build": effect("build", 0.40, [(0, .19, 170, .38, "wood"), (.12, .20, 255, .32, "wood"), (.24, .15, 380, .25, "wood")]),
        "demolish": effect("demolish", 0.42, [(0, .38, 105, .5, "rubble"), (.10, .25, 160, .23, "wood")]),
        "coin": effect("coin", .36, [(0, .28, 880, .20, "bell"), (.08, .27, 1320, .17, "bell")]),
        "error": effect("error", .28, [(0, .12, 190, .18, "wood"), (.13, .14, 150, .20, "wood")]),
        "notification": effect("notification", .63, [(0, .35, 523.25, .18, "bell"), (.18, .44, 783.99, .20, "bell")]),
        "success": effect("success", .85, [(0, .32, 523.25, .18, "bell"), (.15, .34, 659.25, .18, "bell"), (.30, .54, 783.99, .20, "bell")]),
    }
    manifest = {
        "format_version": 1, "api_calls": 0, "cost_usd": 0,
        "music": {"file": "entry.ogg", "source": str(source.relative_to(ROOT)), "source_sha256": sha(source),
                  "sha256": sha(OUTPUT / "entry.ogg"), "seconds": duration,
                  "renderer": "Installed OpenJDK Gervill Emergency GM sound set (local procedural soundbank)",
                  "description": "Original notes, tempo and instruments preserved; rendered timbre differs from phone MIDI synths.",
                  "target_lufs": -20, "sample_rate": RATE, "channels": 2},
        "effects": effects,
        "notes": "SFX are local deterministic synthesis, not samples from original game. No voices were present in the JAR.",
    }
    manifest_path.write_text(json.dumps(manifest, ensure_ascii=False, indent=2) + "\n")
    print(f"AUDIO EXPORTED: {duration:.2f}s original music, {len(effects)} local effects, $0 API")


if __name__ == "__main__":
    main()
