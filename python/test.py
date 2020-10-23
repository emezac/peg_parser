import parser as parser
import pgn as pgn

def get_groups(seq, group_by):
    data = []
    for line in seq:
        # Here the `startswith()` logic can be replaced with other
        # condition(s) depending on the requirement.
        if line.startswith(group_by):
            if data:
                yield data
                data = []
        data.append(line)

    if data:
        yield data

with open("one.pgn", encoding = "ISO-8859-1") as f:
    for i, group in enumerate(get_groups(f, "[Event "), start=1):
        print ("Group #{}".format(i))
        #print (group)
        datapgn = "".join(group)
        print(datapgn)
        game = parser.parse(datapgn, actions=pgn.Actions())
        print("Move 1:")
        print(game.move(1))
        print("Move Black.san:")
        print(game.move(1).black.san)
        print("Move 5:")
        print(game.move(5))
        print("Move Text:")
        print(game.movetext)
        print("Tag Pairs:")
        print(game.tag_pairs)
        print("Score:")
        print(game.score)


