"""Original scenery draw commands shared by extraction and HD reconstruction."""


def commands_for(prop):
    s, h, index = prop["sections"], prop["header"], prop["id"]
    variants = {}

    def sprite(source_index, rect, offset):
        return {"kind": "sprite", "pack": 1, "index": source_index,
                "rect": rect, "offset": offset, "depth": 0}

    for state in ["working", "closed", "unstaffed"]:
        frames = []
        for phase in range(max(1, h["aH"])):
            commands = []
            for i in range(h["aF"]):
                visible = index < 14 or h["aH"] == 0 or state == "unstaffed" or s[14][phase * h["aF"] + i] == 1
                if visible:
                    commands.append(sprite(s[6][i], [s[k][i] for k in range(4)], [s[4][i], s[5][i]]))
            if state != "working" and index >= 14:
                i = h["aF"] + (1 if state == "unstaffed" else 0)
                if s[2][i] > 0:
                    commands.append(sprite(s[6][i], [s[k][i] for k in range(4)], [s[4][i], s[5][i]]))
            if state == "working":
                for i in range(h["aG"]):
                    if s[15][phase * h["aG"] + i] == 1:
                        commands.append(sprite(s[11][i], [s[7 + k][i] for k in range(4)],
                            [s[12][phase * h["aG"] + i], s[13][phase * h["aG"] + i]]))
            frames.append(commands)
        variants[state] = frames
    return variants
