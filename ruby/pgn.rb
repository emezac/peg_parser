$LOAD_PATH << '.'

require 'parser.rb'

class Actions
  
  def make_tag_pair(input, start, end_, elements)
    tp = [elements[2].text, elements[5].text]
    return tp
  end

  def make_tag_pairs(input, start, end_, elements)
    # 
    tps = Array.new
    elements.each do |word| 
      tps << word
    end
    return tps
  end

  def make_comment(input, start, end_, elements)
    return elements[1].text.strip('{}')
  end

  def make_movetext(input, start, end_, elements)

    mt = Movetext.new
    for e in elements
      if e.wcomment.class == String
        wcomment = e.wcomment
      else
        wcomment = ""
      end
      mcomment = "" 
      if e.bcomment.class == String
        if is_bool(e.black.text)
          bcomment = e.bcomment
        else
          bcomment = "" 
          mcomment = e.bcomment
        end
      else
        bcomment = "" 
      end
      if [true, false].include? !mcomment 
        if e.mcomment.class == String
          mcomment = e.mcomment
        end
      end
      mt.push(Move.new(e.move_number.text, e.white.text, e.wnags.elements, wcomment, e.wvars, e.black.text, e.bnags.elements, bcomment, e.bvars, mcomment))
    end
    return mt
  end

  def make_variation(input, start, end_, elements)
    # 
    return elements[]
  end

  def make_variations(input, start, end_, elements)
    # 
    out = []
    for e in elements
      out.push(e)
    end
    return out
  end

  def make_game(input, start, end_, elements)
    e = elements
    e_ = "(1-0|0-1|1/2-1/2|\*)".match(e[4].text)
    if !e_[0].empty?
      s = Score.new(e[4].text)
    else
      s = Score.new("*")
    end
    g = Game.new(e[0], e[2], e[3], s)
    return g
  end
end

class PGNGameException < Exception
  # pass
end


class Ply
  attr_accessor :colour, :san, :nags, :comment, :variations

  # 
  def initialize(colour, san, nags=[], comment="" , variations=[])
    # 
    @colour = colour
    @san = san
    @nags = nodes_to_nags(nags)
    @comment = comment
    @variations = variations
  end

  def to_s()
    out = @san
    if @comment != ""
      out += " {" + @comment.gsub('\n', ' ') + "}"
    end

    if @nags.size > 0
      for n in @nags
        out += " "  + n
      end
    end
    for v in @variations
      out += "(" + v.to_s.strip(' ') +")" 
    end
    return out
  end

  def nodes_to_nags(nags)
    return [] if nags.empty?
    out = []
    for n in nags
      out.push(n.text.strip(" "))
    end
    return out
  end
end

class Move
  attr_accessor :move_number, :white, :black, :comment
  
  def initialize(move_number, white, wnags, wcomment, wvars, black, bnags, bcomment, bvars, mcomment)
    # 
    @move_number = move_no_to_i(move_number)
    (white == ".." ) ? white = " "  : white
    @white = Ply.new("w", white, wnags, wcomment, wvars)
    @black = Ply.new("b", black, bnags, bcomment, bvars)
    @comment = mcomment
  end

  def to_s()
    out = @move_number.to_s + "."
    if @white.san != 
      out += " " + @white.to_s
    else
      out +=  ".."
    end
    if @black.san != 
      out += " " + @black.to_s
    end
    if [true, false].include? @comment
      out += " {" + @comment + "}" 
    end
    return out
  end
  def __repr__()
    return __str__()
  end
  def move_no_to_i(move_number)
        no = /([0-9]+)\./.match(move_number)
    return no[1].to_i
  end

  def move_number
    @move_number
  end
end

class Movetext < Array
  def to_s()
    out =  ""
    for (i, m) in enumerate()
      if (i > 0) 
        out += " " + m.to_s 
      else
         m.to_s
      end
    end
    out +=  " "
    return out
  end

  def move(find)
    first = self.first.move_number
    last  = self.last.move_number
    fail = "Move number #{find} is not in this game. First is #{first}, last is #{last}"
    if first > find
      raise PGNGameException, fail
    end
    for m in self
      if find == m.move_number
        return m
      end
    end
    raise PGNGameException, fail
  end
end

class Score
  attr_accessor :white, :black, :result

  def initialize(score)
    if score == "*" 
      w,b = "*","*" 
    else
      w,b = score.split("-")
    end
    @white = w
    @black = b
    @result = score.to_s
  end

  def to_s()
    if @white ==  "*"
      return "*"
    else
      return "#{@white}-#{@black}"
    end
  end

end

class Game
  attr_accessor :tag_pairs, :comment, :movetext, :score
  
  def initialize(tag_pairs, gcomment, movetext, score)
    # 
    @tag_pairs = tag_pairs
    if gcomment.class == String
      @comment = gcomment
    else
      @comment = "" 
    end
    @movetext = movetext
    @score = score
  end

  def to_s()
    out = @tag_pairs.to_s
    if is_bool(@comment)
      out += "{" + @comment + "} " 
    end
    out += self.format_body()
    return out
  end

  def format_body()
    mt = deque(@movetext.to_s.split(' ') + [])
    out = mt.popleft()
    ll = out.size
    while true 
      if mt.size === 0 
        break
      end
      n = mt.popleft()
      if ((ll + n.size) + 1)  < 80 
        to_add = " " + n
        out +=  " "+ n
        ll += to_add.size
      else
        out += "\n" + n
        ll = n.size
      end
    end
    return out + @score.to_s
  end

  def move(find)
    # 
    return @movetext.move(find)
  end
end
