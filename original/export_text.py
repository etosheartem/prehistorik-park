#!/usr/bin/env python3
"""Decode the original CP1251 text banks without changing their indexed IDs."""
from __future__ import annotations

import argparse
import hashlib
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
BANKS = {"ui": "text.da0", "help": "helptext.da0", "warnings": "warntext.da0"}
ICON_LABELS = [
    "Счастливый", "Грустный", "Уставший", "Голодный", "Нужен туалет",
    "Хочет пить", "Болеет", "Уходит из парка", "Хочет кататься", "Кончились деньги",
]
CONTROLS = [
    {"input": "Джойстик / 2, 8, 4, 6", "action": "Перемещение курсора по карте и пунктам меню"},
    {"input": "Центр джойстика / 5", "action": "Установить объект, выбрать объект или человека под курсором"},
    {"input": "Левая клавиша выбора / *", "action": "Меню строительства, поворот строящегося объекта, подтверждение"},
    {"input": "Правая клавиша выбора / #", "action": "Отмена, назад, игровое меню"},
    {"input": "0", "action": "Контекстная справка или миникарта"},
]


def decode_text(value: str) -> str:
    """Keep source spelling; expose embedded icon bytes as named tokens."""
    value = value.replace("&", "\n")
    for number in range(10):
        value = value.replace(chr(number), f"[icon:{number}]")
    return value


def export() -> dict:
    result: dict = {
        "format_version": 1,
        "language": "ru",
        "source_encoding": "windows-1251",
        "source_title": "Первобытный парк",
        "source_version": "1.09",
        "source_credit": "~ Гиар Геймз, 2007",
        "notes": [
            "Нумерация записей с нуля сохранена; конечный разделитель не создаёт пустую запись.",
            "В основных массивах & заменён на перенос строки; байты 0–9 заменены на [icon:N].",
            "В raw сохранены исходные символы, включая & и управляющие байты; опечатки не исправлены.",
        ],
        "icons": [{"id": i, "label": name} for i, name in enumerate(ICON_LABELS)],
        "controls": CONTROLS,
        "sources": {},
        "raw": {},
    }
    for group, name in BANKS.items():
        path = ROOT / "original" / "jar" / name
        data = path.read_bytes()
        assert data.endswith(b"|"), f"Missing final record delimiter: {path}"
        entries = data.decode("cp1251").split("|")[:-1]
        assert ("|".join(entries) + "|").encode("cp1251") == data
        result["sources"][group] = {
            "path": str(path.relative_to(ROOT)), "sha256": hashlib.sha256(data).hexdigest(),
            "bytes": len(data), "count": len(entries),
        }
        result["raw"][group] = entries
        result[group] = [decode_text(entry) for entry in entries]
    result["tutorial"] = [
        {"warning_id": i, "text": result["warnings"][i]} for i in range(30, 38)
    ]
    return result


def guide(data: dict) -> str:
    lines = [
        "# Первобытный парк: исходная игра", "",
        "Документ извлечён из ресурсов JAR и декомпилированного обработчика ввода. "
        "Тексты сохранены с исходными опечатками; здесь описывается оригинал, а не уже реализованные возможности новой версии.", "",
        "## Игра и интерфейс", "",
        "Изометрический экономический симулятор парка развлечений. Игрок строит дорожки, "
        "аттракционы, сервисы и декорации, нанимает работников и следит за деньгами, "
        "настроением и потребностями посетителей. Лунный цикл равен месяцу; в новолуние выплачивается зарплата.", "",
        "Оригинальная справка указывает свободную игру, кампанию, обучение и соревнование. "
        "В соревновании парк «Кутуку» должен удерживать первое место три года. "
        "В кампании используются показатели денег, настроения и посещаемости; точные условия "
        "конкретных уровней находятся в бинарных таблицах, а не в текстовых файлах.", "",
        "Аттракционам нужны примыкающие к дорожке вход и выход; отдельным аттракционам "
        "также нужен диномотор с погонщиком. Для сервисов предусмотрены продавец, повар или шаман. "
        "Посетители передвигаются только по дорожкам. Водная дорожка строится в несколько этапов: вход, выход, маршрут.", "",
        "При переносе необходимы: выбор клетки и объекта, предпросмотр размещения и поворот, "
        "читаемые карточки цены/состояния/найма, категории строительства, статистика, "
        "контекстная справка и миникарта. Всплывающие панели должны оставлять достаточно места самой карте.", "",
        "## Исходное управление", "",
        "| Клавиша | Действие |", "| --- | --- |",
    ]
    for control in CONTROLS:
        lines.append(f"| {control['input']} | {control['action']} |")
    lines += ["", "Источник: `original/src/e.java`, методы `keyPressed`, `keyReleased`; "
              "описание действий — `helptext.da0[0]`. Код дополнительно обрабатывает клавишу 7 "
              "как переключение внутреннего булева флага; публичная справка её не описывает, "
              "поэтому пользовательское действие здесь не приписано.", "",
              "## Формат и локализация", "",
              "В архиве присутствуют только русские банки `*.da0`: 109 коротких строк, 35 разделов "
              "справки, 39 предупреждений и учебных реплик. Код читает байты CP1251. "
              "`|` разделяет записи; `&` задаёт перевод строки; байты 0–9 обозначают иконки потребностей. "
              "Оригинальный рендерер переводит кириллицу в верхний регистр. "
              "JSON сохраняет регистр исходников и отдельные массивы `raw` для точного восстановления.", "",
              "Титры из `helptext.da0[32]`: «Первобытный парк», «версия 1.09», «~ Гиар Геймз, 2007». "
              "Знак `~` — исходный код специального глифа; текстовый экспорт не подменяет его предположением.", "",
              "## Иконки потребностей", ""]
    lines += [f"- `[icon:{item['id']}]` — {item['label']}." for item in data["icons"]]
    lines += ["", "## Обучение", ""]
    for item in data["tutorial"]:
        lines += [f"### warnings[{item['warning_id']}]", "", item["text"], ""]
    lines += ["## Полные тексты и воспроизведение", "",
              "Полные индексированные тексты: [texts.md](../original/exports/texts.md). "
              "Машинный формат: `original/exports/texts.json` и `game/assets/data/texts.json`.", "",
              "Экспорт: `python original/export_text.py`; проверка: `python original/export_text.py --check`.", "",
              "Отличия новой версии следует сверять с `TODO.md`: извлечение всех строк само по себе "
              "не означает реализацию всех исходных режимов. Озвученных диалогов в исходном JAR нет; "
              "единственный звуковой ресурс — `sound/entry.mid`.", ""]
    return "\n".join(lines)


def appendix(data: dict) -> str:
    lines = ["# Полные тексты оригинала", ""]
    for group, title in [("ui", "Короткие строки"), ("help", "Справка"), ("warnings", "Предупреждения и сообщения")]:
        lines += [f"## {title}", ""]
        for index, value in enumerate(data[group]):
            lines += [f"### {group}[{index}]", "", value, ""]
    return "\n".join(lines)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--check", action="store_true", help="Check reproducibility without rewriting outputs")
    args = parser.parse_args()
    data = export()
    # Godot JSON parsing rejects embedded NUL, even escaped as \u0000. Keep the
    # lossless raw bank solely in the archival export; runtime uses icon tokens.
    runtime = {key: value for key, value in data.items() if key != "raw"}
    runtime["notes"] = [
        "Нумерация записей с нуля сохранена; & заменён на перенос строки; иконки записаны как [icon:N].",
        "Исходные управляющие байты и raw-банки находятся только в original/exports/texts.json.",
    ]
    outputs = {
        ROOT / "original/exports/texts.json": json.dumps(data, ensure_ascii=False, indent=2) + "\n",
        ROOT / "game/assets/data/texts.json": json.dumps(runtime, ensure_ascii=False, indent=2) + "\n",
        ROOT / "docs/original-guide.md": guide(data),
        ROOT / "original/exports/texts.md": appendix(data),
    }
    for path, content in outputs.items():
        if args.check:
            assert path.read_text() == content, f"Out of date: {path}"
        else:
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(content)
    print("TEXT OK: 109 UI, 35 help, 39 warning records; CP1251 round-trip verified")


if __name__ == "__main__":
    main()
