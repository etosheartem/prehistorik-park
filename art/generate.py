#!/usr/bin/env python3
"""One explicitly requested OpenRouter image job, with durable cost reservation.

No automatic retries: a timeout or lost response keeps its reservation until reviewed.
The key is read at request time, never copied into source, jobs, logs or output metadata.
"""
from __future__ import annotations

import argparse
import base64
from contextlib import contextmanager
from datetime import datetime, timezone
import fcntl
import hashlib
import json
import os
from pathlib import Path
import re
import time
import urllib.error
import urllib.request
from PIL import Image

ROOT = Path(__file__).resolve().parents[1]
ART = ROOT / "art"
LEDGER = ART / "costs.json"
PRICING = {
    "bytedance-seed/seedream-5-0-lite": {"2K": .035, "4K": .035},
    "sourceful/riverflow-v2.5-pro": {"2K": .15, "4K": .17},
}
# Riverflow's advertised prices are starting prices; its internal editing passes
# made the 2K pilot cost $0.390302. These are cautious reservations, NOT a server cap.
RESERVATIONS = {
    "bytedance-seed/seedream-5-0-lite": {"2K": .05, "4K": .05},
    "sourceful/riverflow-v2.5-pro": {"2K": .80, "4K": 1.50},
}
DEFAULT_BUDGET = {"project_limit_usd": 8.0, "scope_limits_usd": {"pilot": 1.50}, "jobs": []}


def stamp() -> str:
    return datetime.now(timezone.utc).isoformat()


def sha(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest()


@contextmanager
def locked_ledger():
    ART.mkdir(exist_ok=True)
    with (ART / "costs.lock").open("a+") as lock:
        fcntl.flock(lock, fcntl.LOCK_EX)
        data = json.loads(LEDGER.read_text()) if LEDGER.exists() else json.loads(json.dumps(DEFAULT_BUDGET))
        yield data
        temp = LEDGER.with_suffix(".tmp")
        temp.write_text(json.dumps(data, ensure_ascii=False, indent=2) + "\n")
        temp.replace(LEDGER)


def charged(entry: dict) -> float:
    # Unknown outcomes retain their reservation and cannot be silently repeated.
    return entry.get("cost_usd", entry["reserved_usd"])


def read_key() -> str:
    key = os.environ.get("OPENROUTER_KEY", "").strip()
    if not key:
        raise RuntimeError("OPENROUTER_KEY is not set; archived paid generation is optional")
    if not key.startswith("sk-or-"):
        raise RuntimeError("Invalid local key format")
    return key


def remaining_credit(key: str) -> float:
    request = urllib.request.Request("https://openrouter.ai/api/v1/credits", headers={"Authorization": "Bearer " + key})
    with urllib.request.urlopen(request, timeout=20) as response:
        data = json.load(response)["data"]
    return float(data["total_credits"]) - float(data["total_usage"])


def run(job_path: Path, execute: bool) -> None:
    job_bytes = job_path.read_bytes()
    job = json.loads(job_bytes)
    model, resolution = job["model"], job["resolution"]
    expected = PRICING[model][resolution]
    reserve = max(0.80, RESERVATIONS[model][resolution])
    output = ROOT / job["output"]
    if output.exists():
        raise RuntimeError("Output already exists; inspect it instead of paying for a repeat")
    references = []
    input_references = []
    for filename in job.get("references", []):
        path = ROOT / filename
        image_bytes = path.read_bytes()
        with Image.open(path) as image:
            image.verify()
        references.append({"path": filename, "sha256": sha(image_bytes)})
        input_references.append({"type": "image_url", "image_url": {"url": "data:image/png;base64," + base64.b64encode(image_bytes).decode()}})
    body = {"model": model, "prompt": job["prompt"], "resolution": resolution,
            "aspect_ratio": job["aspect_ratio"], "input_references": input_references, "n": 1}
    if job.get("background"):
        if model != "sourceful/riverflow-v2.5-pro":
            raise ValueError("Selected endpoint does not advertise background control")
        body["background"] = job["background"]
        body["output_format"] = "png"
    summary = {"id": job["id"], "scope": job.get("scope", "pilot"), "model": model,
               "resolution": resolution, "expected_usd": expected, "reserved_usd": reserve,
               "output": job["output"], "references": references}
    print(json.dumps(summary, ensure_ascii=False))
    if not execute:
        print("DRY RUN: no network request and no reservation")
        return
    key = read_key()
    balance = remaining_credit(key)
    if balance < reserve:
        raise RuntimeError("Available account balance is below the conservative reservation; no image request sent")
    summary["account_balance_before_usd"] = round(balance, 6)
    with locked_ledger() as ledger:
        if ledger.get("release_paid_generation_complete"):
            raise RuntimeError("Paid generation for this release is closed; no image request sent")
        if any(entry.get("status") in {"reserved", "response_received", "needs_review"}
               and "cost_usd" not in entry for entry in ledger["jobs"]):
            raise RuntimeError("One request is still unresolved; review it before making another request")
        if any(entry["id"] == job["id"] for entry in ledger["jobs"]):
            raise RuntimeError("Job ID already reserved/submitted; review its outcome instead of retrying")
        scope_limit = ledger["scope_limits_usd"].get(summary["scope"])
        if scope_limit is None:
            raise RuntimeError("Scope has no authorized limit")
        total = sum(charged(entry) for entry in ledger["jobs"])
        scoped = sum(charged(entry) for entry in ledger["jobs"] if entry["scope"] == summary["scope"])
        if total + reserve > ledger["project_limit_usd"] or scoped + reserve > scope_limit:
            raise RuntimeError("Cost reservation would exceed authorized budget")
        ledger["jobs"].append(summary | {"status": "reserved", "created_utc": stamp(), "job_sha256": sha(job_bytes)})
    started = time.monotonic()
    try:
        request = urllib.request.Request(
            "https://openrouter.ai/api/v1/images", json.dumps(body).encode(),
            {"Authorization": "Bearer " + key, "Content-Type": "application/json"}, method="POST")
        with urllib.request.urlopen(request, timeout=300) as response:
            result = json.load(response)
        usage = result.get("usage", {})
        update = {"status": "response_received", "response_id": result.get("id"), "usage": usage,
                  "response_model": result.get("model"), "response_created": result.get("created"),
                  "elapsed_seconds": round(time.monotonic() - started, 2), "completed_utc": stamp()}
        if isinstance(usage.get("cost"), (int, float)):
            update["cost_usd"] = float(usage["cost"])
            update["cost_exceeded_reservation"] = update["cost_usd"] > reserve
        with locked_ledger() as ledger:
            next(entry for entry in ledger["jobs"] if entry["id"] == job["id"]).update(update)
        if not result.get("data") or not result["data"][0].get("b64_json"):
            raise RuntimeError("Response has no inline image; inspect response metadata without retrying")
        image_bytes = base64.b64decode(result["data"][0]["b64_json"], validate=True)
        output.parent.mkdir(parents=True, exist_ok=True)
        output.write_bytes(image_bytes)
        with Image.open(output) as image:
            provider_format = image.format
            # Some endpoints return JPEG regardless of the requested file name.
            # Keep the untouched provider bytes, but install a genuine PNG for Godot.
            if provider_format != "PNG":
                extension = {"JPEG": ".jpg", "WEBP": ".webp"}.get(provider_format, ".bin")
                output.with_suffix(".provider" + extension).write_bytes(image_bytes)
                image.load()
                image.save(output, format="PNG")
            width, height = image.size
            alpha = image.getchannel("A").getextrema() if image.mode == "RGBA" else (255, 255)
            size_ok = max(width, height) >= (3800 if resolution == "4K" else 2000)
            transparency_ok = job.get("background") != "transparent" or alpha[0] == 0
            update |= {"width": width, "height": height, "alpha_range": list(alpha),
                       "provider_format": provider_format, "provider_sha256": sha(image_bytes),
                       "sha256": sha(output.read_bytes()), "status": "generated" if size_ok and transparency_ok else "needs_review",
                       "native_size_ok": size_ok, "transparency_ok": transparency_ok}
        output.with_suffix(".json").write_text(json.dumps(summary | update | {"prompt": job["prompt"]}, ensure_ascii=False, indent=2) + "\n")
        with locked_ledger() as ledger:
            next(entry for entry in ledger["jobs"] if entry["id"] == job["id"]).update(update)
        print(json.dumps({key: value for key, value in update.items() if key != "usage"}, ensure_ascii=False))
    except Exception as error:
        # Do not print raw remote bodies or credential-bearing request objects.
        with locked_ledger() as ledger:
            entry = next(entry for entry in ledger["jobs"] if entry["id"] == job["id"])
            entry.update(status="needs_review", error_type=type(error).__name__, completed_utc=stamp())
            if isinstance(error, urllib.error.HTTPError):
                entry["http_status"] = error.code
                # Store only bounded API error text, which never contains request headers.
                details = error.read(4096).decode("utf-8", errors="replace").replace(key, "[REDACTED]")
                entry["response_error"] = details
        raise RuntimeError(f"Image job requires review ({type(error).__name__}); reservation retained, no retry") from None


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("job", type=Path)
    parser.add_argument("--run", action="store_true", help="Send one paid image request (default is dry run)")
    args = parser.parse_args()
    run(args.job, args.run)


if __name__ == "__main__":
    main()
