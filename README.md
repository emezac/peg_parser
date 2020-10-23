This repository aims to generate an analyzer to read chess files in PGN format.
It supports one or more moves, ending with a score, such as "1. e4 e5 ... 0-1", but also long formats: "1. d2d4 Ng8f6", the classic castling "OO oo" but also "e1g1 e8g8" , supports parsing of headers and comments.

PGN is the de-facto standard for chess games, especially when it comes to interoperability. Unfortunately, PGN is somewhat misdesigned. Apparently, it’s not just me who thinks so. PGN is designed to make it easy for humans to read PGN files, and edit or write them manually with a text editor. At a cost, namely that it’s difficult to parse it with computers.

The odd thing here is that PGN files are rarely created manually, almost everyone uses a chess program to enter or edit moves, and then save the game afterwards. That’s the basic mis-design.

The main difficulty in parsing PGN files – aside from a lot of ambiguities – is SAN notation, i.e. the source-field of a move is missing. For a human it’s easy to spot the source-field, but for a computer it means that the program has to know the chess-rules to figure out which move is executed .

This parser was generated by using canopy a PEG (Parsing Expression Grammars) parser compiler.

Why did I decide to use a PEG parser?

Because it has several advantages:
1. I can generate the parser for Python, Ruby, Java and JS
2. I have to developed just 50% more of the parser
3. Surely my knowledge of PEG Parsers will should important for my next homework: a pattern language for chess.

Status:

Python Parser : 100%
Ruby Parser   : 95%
Java Parser   : 50%
Js Parser     : 50%

Any help is wellcome!

Canopy

Canopy is a parser compiler targeting Java, JavaScript, Python and Ruby. It takes a file describing a parsing expression grammar and compiles it into a parser module in the target language. The generated parsers have no runtime dependency on Canopy itself.

For usage documentation see canopy.jcoglan.com.
