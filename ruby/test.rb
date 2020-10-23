$LOAD_PATH << '.'

require 'parser'
require_relative 'pgn'

include PGN

options = { actions: Actions.new, types: nil  }
file_data = File.open("kasparov.pgn", :encoding => 'ISO-8859-1').read
game = PGN::parse(file_data, options )
#game = PGN::parse("1. c2c4 { Comments by/Kommentare von: GM Gerald Hertneck } 1... c7c6 2.  d2d4 d7d5", options )
puts game.move(1)
puts game.move(1).black.san
puts game.comment
puts game.movetext
puts game.tag_pairs
puts game.score
