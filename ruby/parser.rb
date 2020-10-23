# This file was generated from parser.peg
# See http://canopy.jcoglan.com/ for documentation.

module PGN
  class TreeNode
    include Enumerable
    attr_reader :text, :offset, :elements

    def initialize(text, offset, elements)
      @text = text
      @offset = offset
      @elements = elements
    end

    def each(&block)
      @elements.each(&block)
    end
  end

  class TreeNode1 < TreeNode
    attr_reader :tag_pairs, :gcomment, :movetext, :score

    def initialize(text, offset, elements)
      super
      @tag_pairs = elements[0]
      @gcomment = elements[2]
      @movetext = elements[3]
      @score = elements[4]
    end
  end

  class TreeNode2 < TreeNode
    attr_reader :dlm, :key, :value

    def initialize(text, offset, elements)
      super
      @dlm = elements[9]
      @key = elements[2]
      @value = elements[5]
    end
  end

  class TreeNode3 < TreeNode
    attr_reader :move_number, :dlm, :white, :san, :wnags, :wcomment, :wvars, :black, :bnags, :bcomment, :bvars, :mcomment

    def initialize(text, offset, elements)
      super
      @move_number = elements[0]
      @dlm = elements[19]
      @white = elements[3]
      @san = elements[3]
      @wnags = elements[6]
      @wcomment = elements[8]
      @wvars = elements[10]
      @black = elements[12]
      @bnags = elements[14]
      @bcomment = elements[16]
      @bvars = elements[18]
      @mcomment = elements[20]
    end
  end

  class TreeNode4 < TreeNode
    attr_reader :file, :rank, :dlm

    def initialize(text, offset, elements)
      super
      @file = elements[3]
      @rank = elements[4]
      @dlm = elements[2]
    end
  end

  class TreeNode5 < TreeNode
    attr_reader :file, :rank, :dlm

    def initialize(text, offset, elements)
      super
      @file = elements[7]
      @rank = elements[8]
      @dlm = elements[4]
    end
  end

  class TreeNode6 < TreeNode
    attr_reader :file, :rank, :dlm

    def initialize(text, offset, elements)
      super
      @file = elements[5]
      @rank = elements[6]
      @dlm = elements[2]
    end
  end

  class TreeNode7 < TreeNode
    attr_reader :piece, :file, :rank, :dlm

    def initialize(text, offset, elements)
      super
      @piece = elements[6]
      @file = elements[9]
      @rank = elements[10]
      @dlm = elements[5]
    end
  end

  class TreeNode8 < TreeNode
    attr_reader :piece, :file, :rank, :dlm

    def initialize(text, offset, elements)
      super
      @piece = elements[0]
      @file = elements[8]
      @rank = elements[9]
      @dlm = elements[5]
    end
  end

  class TreeNode9 < TreeNode
    attr_reader :file, :rank, :dlm, :piece

    def initialize(text, offset, elements)
      super
      @file = elements[8]
      @rank = elements[9]
      @dlm = elements[4]
      @piece = elements[5]
    end
  end

  class TreeNode10 < TreeNode
    attr_reader :file, :takes, :square

    def initialize(text, offset, elements)
      super
      @file = elements[0]
      @takes = elements[1]
      @square = elements[2]
    end
  end

  class TreeNode11 < TreeNode
    attr_reader :piece, :square

    def initialize(text, offset, elements)
      super
      @piece = elements[0]
      @square = elements[3]
    end
  end

  class TreeNode12 < TreeNode
    attr_reader :piece, :square

    def initialize(text, offset, elements)
      super
      @piece = elements[0]
      @square = elements[2]
    end
  end

  class TreeNode13 < TreeNode
    attr_reader :piece, :file, :square

    def initialize(text, offset, elements)
      super
      @piece = elements[0]
      @file = elements[1]
      @square = elements[3]
    end
  end

  class TreeNode14 < TreeNode
    attr_reader :piece, :rank, :square

    def initialize(text, offset, elements)
      super
      @piece = elements[0]
      @rank = elements[1]
      @square = elements[3]
    end
  end

  class TreeNode15 < TreeNode
    attr_reader :file, :rank

    def initialize(text, offset, elements)
      super
      @file = elements[0]
      @rank = elements[1]
    end
  end

  class TreeNode16 < TreeNode
    attr_reader :dlm

    def initialize(text, offset, elements)
      super
      @dlm = elements[2]
    end
  end

  class TreeNode17 < TreeNode
    attr_reader :dlm, :movetext

    def initialize(text, offset, elements)
      super
      @dlm = elements[4]
      @movetext = elements[2]
    end
  end

  ParseError = Class.new(StandardError)

  FAILURE = Object.new

  module Grammar
    def _read_game
      address0, index0 = FAILURE, @offset
      cached = @cache[:game][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      address1 = _read_tag_pairs
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        index2 = @offset
        chunk0, max0 = nil, @offset + 1
        if max0 <= @input_size
          chunk0 = @input[@offset...max0]
        end
        if chunk0 =~ /\A[\n]/
          address2 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address2 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "[\\n]"
          end
        end
        if address2 == FAILURE
          address2 = TreeNode.new(@input[index2...index2], index2, [])
          @offset = index2
        end
        unless address2 == FAILURE
          elements0 << address2
          address3 = FAILURE
          index3 = @offset
          address3 = _read_comment
          if address3 == FAILURE
            address3 = TreeNode.new(@input[index3...index3], index3, [])
            @offset = index3
          end
          unless address3 == FAILURE
            elements0 << address3
            address4 = FAILURE
            address4 = _read_movetext
            unless address4 == FAILURE
              elements0 << address4
              address5 = FAILURE
              index4 = @offset
              address5 = _read_score
              if address5 == FAILURE
                address5 = TreeNode.new(@input[index4...index4], index4, [])
                @offset = index4
              end
              unless address5 == FAILURE
                elements0 << address5
                address6 = FAILURE
                remaining0, index5, elements1, address7 = 0, @offset, [], true
                until address7 == FAILURE
                  chunk1, max1 = nil, @offset + 1
                  if max1 <= @input_size
                    chunk1 = @input[@offset...max1]
                  end
                  if chunk1 =~ /\A[\s]/
                    address7 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
                    @offset = @offset + 1
                  else
                    address7 = FAILURE
                    if @offset > @failure
                      @failure = @offset
                      @expected = []
                    end
                    if @offset == @failure
                      @expected << "[\\s]"
                    end
                  end
                  unless address7 == FAILURE
                    elements1 << address7
                    remaining0 -= 1
                  end
                end
                if remaining0 <= 0
                  address6 = TreeNode.new(@input[index5...@offset], index5, elements1)
                  @offset = @offset
                else
                  address6 = FAILURE
                end
                unless address6 == FAILURE
                  elements0 << address6
                else
                  elements0 = nil
                  @offset = index1
                end
              else
                elements0 = nil
                @offset = index1
              end
            else
              elements0 = nil
              @offset = index1
            end
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = @actions.make_game(@input, index1, @offset, elements0)
        @offset = @offset
      end
      @cache[:game][index0] = [address0, @offset]
      return address0
    end

    def _read_tag_pairs
      address0, index0 = FAILURE, @offset
      cached = @cache[:tag_pairs][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 0, @offset, [], true
      until address1 == FAILURE
        address1 = _read_tag_pair
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = @actions.make_tag_pairs(@input, index1, @offset, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:tag_pairs][index0] = [address0, @offset]
      return address0
    end

    def _read_tag_pair
      address0, index0 = FAILURE, @offset
      cached = @cache[:tag_pair][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "["
        address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address1 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"[\""
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        address2 = _read_dlm
        unless address2 == FAILURE
          elements0 << address2
          address3 = FAILURE
          address3 = _read_key
          unless address3 == FAILURE
            elements0 << address3
            address4 = FAILURE
            address4 = _read_dlm
            unless address4 == FAILURE
              elements0 << address4
              address5 = FAILURE
              chunk1, max1 = nil, @offset + 1
              if max1 <= @input_size
                chunk1 = @input[@offset...max1]
              end
              if chunk1 == "\""
                address5 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
                @offset = @offset + 1
              else
                address5 = FAILURE
                if @offset > @failure
                  @failure = @offset
                  @expected = []
                end
                if @offset == @failure
                  @expected << "\"\\\"\""
                end
              end
              unless address5 == FAILURE
                elements0 << address5
                address6 = FAILURE
                address6 = _read_value
                unless address6 == FAILURE
                  elements0 << address6
                  address7 = FAILURE
                  chunk2, max2 = nil, @offset + 1
                  if max2 <= @input_size
                    chunk2 = @input[@offset...max2]
                  end
                  if chunk2 == "\""
                    address7 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
                    @offset = @offset + 1
                  else
                    address7 = FAILURE
                    if @offset > @failure
                      @failure = @offset
                      @expected = []
                    end
                    if @offset == @failure
                      @expected << "\"\\\"\""
                    end
                  end
                  unless address7 == FAILURE
                    elements0 << address7
                    address8 = FAILURE
                    address8 = _read_dlm
                    unless address8 == FAILURE
                      elements0 << address8
                      address9 = FAILURE
                      chunk3, max3 = nil, @offset + 1
                      if max3 <= @input_size
                        chunk3 = @input[@offset...max3]
                      end
                      if chunk3 == "]"
                        address9 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
                        @offset = @offset + 1
                      else
                        address9 = FAILURE
                        if @offset > @failure
                          @failure = @offset
                          @expected = []
                        end
                        if @offset == @failure
                          @expected << "\"]\""
                        end
                      end
                      unless address9 == FAILURE
                        elements0 << address9
                        address10 = FAILURE
                        address10 = _read_dlm
                        unless address10 == FAILURE
                          elements0 << address10
                        else
                          elements0 = nil
                          @offset = index1
                        end
                      else
                        elements0 = nil
                        @offset = index1
                      end
                    else
                      elements0 = nil
                      @offset = index1
                    end
                  else
                    elements0 = nil
                    @offset = index1
                  end
                else
                  elements0 = nil
                  @offset = index1
                end
              else
                elements0 = nil
                @offset = index1
              end
            else
              elements0 = nil
              @offset = index1
            end
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = @actions.make_tag_pair(@input, index1, @offset, elements0)
        @offset = @offset
      end
      @cache[:tag_pair][index0] = [address0, @offset]
      return address0
    end

    def _read_key
      address0, index0 = FAILURE, @offset
      cached = @cache[:key][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 1, @offset, [], true
      until address1 == FAILURE
        chunk0, max0 = nil, @offset + 1
        if max0 <= @input_size
          chunk0 = @input[@offset...max0]
        end
        if chunk0 =~ /\A[A-Za-z0-9_]/
          address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address1 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "[A-Za-z0-9_]"
          end
        end
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:key][index0] = [address0, @offset]
      return address0
    end

    def _read_value
      address0, index0 = FAILURE, @offset
      cached = @cache[:value][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 0, @offset, [], true
      until address1 == FAILURE
        chunk0, max0 = nil, @offset + 1
        if max0 <= @input_size
          chunk0 = @input[@offset...max0]
        end
        if chunk0 =~ /\A[^\"]/
          address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address1 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "[^\\\"]"
          end
        end
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:value][index0] = [address0, @offset]
      return address0
    end

    def _read_movetext
      address0, index0 = FAILURE, @offset
      cached = @cache[:movetext][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 0, @offset, [], true
      until address1 == FAILURE
        address1 = _read_move
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = @actions.make_movetext(@input, index1, @offset, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:movetext][index0] = [address0, @offset]
      return address0
    end

    def _read_move
      address0, index0 = FAILURE, @offset
      cached = @cache[:move][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      address1 = _read_move_number
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        address2 = _read_dlm
        unless address2 == FAILURE
          elements0 << address2
          address3 = FAILURE
          address3 = _read_dlm
          unless address3 == FAILURE
            elements0 << address3
            address4 = FAILURE
            address4 = _read_san
            unless address4 == FAILURE
              elements0 << address4
              address5 = FAILURE
              address5 = _read_dlm
              unless address5 == FAILURE
                elements0 << address5
                address6 = FAILURE
                address6 = _read_dlm
                unless address6 == FAILURE
                  elements0 << address6
                  address7 = FAILURE
                  index2 = @offset
                  address7 = _read_nags
                  if address7 == FAILURE
                    address7 = TreeNode.new(@input[index2...index2], index2, [])
                    @offset = index2
                  end
                  unless address7 == FAILURE
                    elements0 << address7
                    address8 = FAILURE
                    address8 = _read_dlm
                    unless address8 == FAILURE
                      elements0 << address8
                      address9 = FAILURE
                      index3 = @offset
                      address9 = _read_comment
                      if address9 == FAILURE
                        address9 = TreeNode.new(@input[index3...index3], index3, [])
                        @offset = index3
                      end
                      unless address9 == FAILURE
                        elements0 << address9
                        address10 = FAILURE
                        address10 = _read_dlm
                        unless address10 == FAILURE
                          elements0 << address10
                          address11 = FAILURE
                          index4 = @offset
                          address11 = _read_variations
                          if address11 == FAILURE
                            address11 = TreeNode.new(@input[index4...index4], index4, [])
                            @offset = index4
                          end
                          unless address11 == FAILURE
                            elements0 << address11
                            address12 = FAILURE
                            address12 = _read_dlm
                            unless address12 == FAILURE
                              elements0 << address12
                              address13 = FAILURE
                              index5 = @offset
                              address13 = _read_san
                              if address13 == FAILURE
                                address13 = TreeNode.new(@input[index5...index5], index5, [])
                                @offset = index5
                              end
                              unless address13 == FAILURE
                                elements0 << address13
                                address14 = FAILURE
                                address14 = _read_dlm
                                unless address14 == FAILURE
                                  elements0 << address14
                                  address15 = FAILURE
                                  index6 = @offset
                                  address15 = _read_nags
                                  if address15 == FAILURE
                                    address15 = TreeNode.new(@input[index6...index6], index6, [])
                                    @offset = index6
                                  end
                                  unless address15 == FAILURE
                                    elements0 << address15
                                    address16 = FAILURE
                                    address16 = _read_dlm
                                    unless address16 == FAILURE
                                      elements0 << address16
                                      address17 = FAILURE
                                      index7 = @offset
                                      address17 = _read_comment
                                      if address17 == FAILURE
                                        address17 = TreeNode.new(@input[index7...index7], index7, [])
                                        @offset = index7
                                      end
                                      unless address17 == FAILURE
                                        elements0 << address17
                                        address18 = FAILURE
                                        address18 = _read_dlm
                                        unless address18 == FAILURE
                                          elements0 << address18
                                          address19 = FAILURE
                                          index8 = @offset
                                          address19 = _read_variations
                                          if address19 == FAILURE
                                            address19 = TreeNode.new(@input[index8...index8], index8, [])
                                            @offset = index8
                                          end
                                          unless address19 == FAILURE
                                            elements0 << address19
                                            address20 = FAILURE
                                            address20 = _read_dlm
                                            unless address20 == FAILURE
                                              elements0 << address20
                                              address21 = FAILURE
                                              index9 = @offset
                                              address21 = _read_comment
                                              if address21 == FAILURE
                                                address21 = TreeNode.new(@input[index9...index9], index9, [])
                                                @offset = index9
                                              end
                                              unless address21 == FAILURE
                                                elements0 << address21
                                              else
                                                elements0 = nil
                                                @offset = index1
                                              end
                                            else
                                              elements0 = nil
                                              @offset = index1
                                            end
                                          else
                                            elements0 = nil
                                            @offset = index1
                                          end
                                        else
                                          elements0 = nil
                                          @offset = index1
                                        end
                                      else
                                        elements0 = nil
                                        @offset = index1
                                      end
                                    else
                                      elements0 = nil
                                      @offset = index1
                                    end
                                  else
                                    elements0 = nil
                                    @offset = index1
                                  end
                                else
                                  elements0 = nil
                                  @offset = index1
                                end
                              else
                                elements0 = nil
                                @offset = index1
                              end
                            else
                              elements0 = nil
                              @offset = index1
                            end
                          else
                            elements0 = nil
                            @offset = index1
                          end
                        else
                          elements0 = nil
                          @offset = index1
                        end
                      else
                        elements0 = nil
                        @offset = index1
                      end
                    else
                      elements0 = nil
                      @offset = index1
                    end
                  else
                    elements0 = nil
                    @offset = index1
                  end
                else
                  elements0 = nil
                  @offset = index1
                end
              else
                elements0 = nil
                @offset = index1
              end
            else
              elements0 = nil
              @offset = index1
            end
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode3.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:move][index0] = [address0, @offset]
      return address0
    end

    def _read_move_number
      address0, index0 = FAILURE, @offset
      cached = @cache[:move_number][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      remaining0, index2, elements1, address2 = 1, @offset, [], true
      until address2 == FAILURE
        chunk0, max0 = nil, @offset + 1
        if max0 <= @input_size
          chunk0 = @input[@offset...max0]
        end
        if chunk0 =~ /\A[0-9]/
          address2 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address2 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "[0-9]"
          end
        end
        unless address2 == FAILURE
          elements1 << address2
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address1 = TreeNode.new(@input[index2...@offset], index2, elements1)
        @offset = @offset
      else
        address1 = FAILURE
      end
      unless address1 == FAILURE
        elements0 << address1
        address3 = FAILURE
        chunk1, max1 = nil, @offset + 1
        if max1 <= @input_size
          chunk1 = @input[@offset...max1]
        end
        if chunk1 == "."
          address3 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address3 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "\".\""
          end
        end
        unless address3 == FAILURE
          elements0 << address3
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:move_number][index0] = [address0, @offset]
      return address0
    end

    def _read_san
      address0, index0 = FAILURE, @offset
      cached = @cache[:san][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      index2 = @offset
      index3, elements1 = @offset, []
      address2 = FAILURE
      address2 = _read_file
      unless address2 == FAILURE
        elements1 << address2
        address3 = FAILURE
        address3 = _read_rank
        unless address3 == FAILURE
          elements1 << address3
          address4 = FAILURE
          address4 = _read_dlm
          unless address4 == FAILURE
            elements1 << address4
            address5 = FAILURE
            address5 = _read_file
            unless address5 == FAILURE
              elements1 << address5
              address6 = FAILURE
              address6 = _read_rank
              unless address6 == FAILURE
                elements1 << address6
              else
                elements1 = nil
                @offset = index3
              end
            else
              elements1 = nil
              @offset = index3
            end
          else
            elements1 = nil
            @offset = index3
          end
        else
          elements1 = nil
          @offset = index3
        end
      else
        elements1 = nil
        @offset = index3
      end
      if elements1.nil?
        address1 = FAILURE
      else
        address1 = TreeNode4.new(@input[index3...@offset], index3, elements1)
        @offset = @offset
      end
      if address1 == FAILURE
        @offset = index2
        index4, elements2 = @offset, []
        address7 = FAILURE
        address7 = _read_file
        unless address7 == FAILURE
          elements2 << address7
          address8 = FAILURE
          address8 = _read_rank
          unless address8 == FAILURE
            elements2 << address8
            address9 = FAILURE
            address9 = _read_file
            unless address9 == FAILURE
              elements2 << address9
              address10 = FAILURE
              address10 = _read_rank
              unless address10 == FAILURE
                elements2 << address10
                address11 = FAILURE
                address11 = _read_dlm
                unless address11 == FAILURE
                  elements2 << address11
                  address12 = FAILURE
                  address12 = _read_file
                  unless address12 == FAILURE
                    elements2 << address12
                    address13 = FAILURE
                    address13 = _read_rank
                    unless address13 == FAILURE
                      elements2 << address13
                      address14 = FAILURE
                      address14 = _read_file
                      unless address14 == FAILURE
                        elements2 << address14
                        address15 = FAILURE
                        address15 = _read_rank
                        unless address15 == FAILURE
                          elements2 << address15
                        else
                          elements2 = nil
                          @offset = index4
                        end
                      else
                        elements2 = nil
                        @offset = index4
                      end
                    else
                      elements2 = nil
                      @offset = index4
                    end
                  else
                    elements2 = nil
                    @offset = index4
                  end
                else
                  elements2 = nil
                  @offset = index4
                end
              else
                elements2 = nil
                @offset = index4
              end
            else
              elements2 = nil
              @offset = index4
            end
          else
            elements2 = nil
            @offset = index4
          end
        else
          elements2 = nil
          @offset = index4
        end
        if elements2.nil?
          address1 = FAILURE
        else
          address1 = TreeNode5.new(@input[index4...@offset], index4, elements2)
          @offset = @offset
        end
        if address1 == FAILURE
          @offset = index2
          index5, elements3 = @offset, []
          address16 = FAILURE
          address16 = _read_file
          unless address16 == FAILURE
            elements3 << address16
            address17 = FAILURE
            address17 = _read_rank
            unless address17 == FAILURE
              elements3 << address17
              address18 = FAILURE
              address18 = _read_dlm
              unless address18 == FAILURE
                elements3 << address18
                address19 = FAILURE
                address19 = _read_file
                unless address19 == FAILURE
                  elements3 << address19
                  address20 = FAILURE
                  address20 = _read_rank
                  unless address20 == FAILURE
                    elements3 << address20
                    address21 = FAILURE
                    address21 = _read_file
                    unless address21 == FAILURE
                      elements3 << address21
                      address22 = FAILURE
                      address22 = _read_rank
                      unless address22 == FAILURE
                        elements3 << address22
                      else
                        elements3 = nil
                        @offset = index5
                      end
                    else
                      elements3 = nil
                      @offset = index5
                    end
                  else
                    elements3 = nil
                    @offset = index5
                  end
                else
                  elements3 = nil
                  @offset = index5
                end
              else
                elements3 = nil
                @offset = index5
              end
            else
              elements3 = nil
              @offset = index5
            end
          else
            elements3 = nil
            @offset = index5
          end
          if elements3.nil?
            address1 = FAILURE
          else
            address1 = TreeNode6.new(@input[index5...@offset], index5, elements3)
            @offset = @offset
          end
          if address1 == FAILURE
            @offset = index2
            index6, elements4 = @offset, []
            address23 = FAILURE
            address23 = _read_piece
            unless address23 == FAILURE
              elements4 << address23
              address24 = FAILURE
              address24 = _read_file
              unless address24 == FAILURE
                elements4 << address24
                address25 = FAILURE
                address25 = _read_rank
                unless address25 == FAILURE
                  elements4 << address25
                  address26 = FAILURE
                  address26 = _read_file
                  unless address26 == FAILURE
                    elements4 << address26
                    address27 = FAILURE
                    address27 = _read_rank
                    unless address27 == FAILURE
                      elements4 << address27
                      address28 = FAILURE
                      address28 = _read_dlm
                      unless address28 == FAILURE
                        elements4 << address28
                        address29 = FAILURE
                        address29 = _read_piece
                        unless address29 == FAILURE
                          elements4 << address29
                          address30 = FAILURE
                          address30 = _read_file
                          unless address30 == FAILURE
                            elements4 << address30
                            address31 = FAILURE
                            address31 = _read_rank
                            unless address31 == FAILURE
                              elements4 << address31
                              address32 = FAILURE
                              address32 = _read_file
                              unless address32 == FAILURE
                                elements4 << address32
                                address33 = FAILURE
                                address33 = _read_rank
                                unless address33 == FAILURE
                                  elements4 << address33
                                else
                                  elements4 = nil
                                  @offset = index6
                                end
                              else
                                elements4 = nil
                                @offset = index6
                              end
                            else
                              elements4 = nil
                              @offset = index6
                            end
                          else
                            elements4 = nil
                            @offset = index6
                          end
                        else
                          elements4 = nil
                          @offset = index6
                        end
                      else
                        elements4 = nil
                        @offset = index6
                      end
                    else
                      elements4 = nil
                      @offset = index6
                    end
                  else
                    elements4 = nil
                    @offset = index6
                  end
                else
                  elements4 = nil
                  @offset = index6
                end
              else
                elements4 = nil
                @offset = index6
              end
            else
              elements4 = nil
              @offset = index6
            end
            if elements4.nil?
              address1 = FAILURE
            else
              address1 = TreeNode7.new(@input[index6...@offset], index6, elements4)
              @offset = @offset
            end
            if address1 == FAILURE
              @offset = index2
              index7, elements5 = @offset, []
              address34 = FAILURE
              address34 = _read_piece
              unless address34 == FAILURE
                elements5 << address34
                address35 = FAILURE
                address35 = _read_file
                unless address35 == FAILURE
                  elements5 << address35
                  address36 = FAILURE
                  address36 = _read_rank
                  unless address36 == FAILURE
                    elements5 << address36
                    address37 = FAILURE
                    address37 = _read_file
                    unless address37 == FAILURE
                      elements5 << address37
                      address38 = FAILURE
                      address38 = _read_rank
                      unless address38 == FAILURE
                        elements5 << address38
                        address39 = FAILURE
                        address39 = _read_dlm
                        unless address39 == FAILURE
                          elements5 << address39
                          address40 = FAILURE
                          address40 = _read_file
                          unless address40 == FAILURE
                            elements5 << address40
                            address41 = FAILURE
                            address41 = _read_rank
                            unless address41 == FAILURE
                              elements5 << address41
                              address42 = FAILURE
                              address42 = _read_file
                              unless address42 == FAILURE
                                elements5 << address42
                                address43 = FAILURE
                                address43 = _read_rank
                                unless address43 == FAILURE
                                  elements5 << address43
                                else
                                  elements5 = nil
                                  @offset = index7
                                end
                              else
                                elements5 = nil
                                @offset = index7
                              end
                            else
                              elements5 = nil
                              @offset = index7
                            end
                          else
                            elements5 = nil
                            @offset = index7
                          end
                        else
                          elements5 = nil
                          @offset = index7
                        end
                      else
                        elements5 = nil
                        @offset = index7
                      end
                    else
                      elements5 = nil
                      @offset = index7
                    end
                  else
                    elements5 = nil
                    @offset = index7
                  end
                else
                  elements5 = nil
                  @offset = index7
                end
              else
                elements5 = nil
                @offset = index7
              end
              if elements5.nil?
                address1 = FAILURE
              else
                address1 = TreeNode8.new(@input[index7...@offset], index7, elements5)
                @offset = @offset
              end
              if address1 == FAILURE
                @offset = index2
                index8, elements6 = @offset, []
                address44 = FAILURE
                address44 = _read_file
                unless address44 == FAILURE
                  elements6 << address44
                  address45 = FAILURE
                  address45 = _read_rank
                  unless address45 == FAILURE
                    elements6 << address45
                    address46 = FAILURE
                    address46 = _read_file
                    unless address46 == FAILURE
                      elements6 << address46
                      address47 = FAILURE
                      address47 = _read_rank
                      unless address47 == FAILURE
                        elements6 << address47
                        address48 = FAILURE
                        address48 = _read_dlm
                        unless address48 == FAILURE
                          elements6 << address48
                          address49 = FAILURE
                          address49 = _read_piece
                          unless address49 == FAILURE
                            elements6 << address49
                            address50 = FAILURE
                            address50 = _read_file
                            unless address50 == FAILURE
                              elements6 << address50
                              address51 = FAILURE
                              address51 = _read_rank
                              unless address51 == FAILURE
                                elements6 << address51
                                address52 = FAILURE
                                address52 = _read_file
                                unless address52 == FAILURE
                                  elements6 << address52
                                  address53 = FAILURE
                                  address53 = _read_rank
                                  unless address53 == FAILURE
                                    elements6 << address53
                                  else
                                    elements6 = nil
                                    @offset = index8
                                  end
                                else
                                  elements6 = nil
                                  @offset = index8
                                end
                              else
                                elements6 = nil
                                @offset = index8
                              end
                            else
                              elements6 = nil
                              @offset = index8
                            end
                          else
                            elements6 = nil
                            @offset = index8
                          end
                        else
                          elements6 = nil
                          @offset = index8
                        end
                      else
                        elements6 = nil
                        @offset = index8
                      end
                    else
                      elements6 = nil
                      @offset = index8
                    end
                  else
                    elements6 = nil
                    @offset = index8
                  end
                else
                  elements6 = nil
                  @offset = index8
                end
                if elements6.nil?
                  address1 = FAILURE
                else
                  address1 = TreeNode9.new(@input[index8...@offset], index8, elements6)
                  @offset = @offset
                end
                if address1 == FAILURE
                  @offset = index2
                  address1 = _read_square
                  if address1 == FAILURE
                    @offset = index2
                    address1 = _read_san_psq
                    if address1 == FAILURE
                      @offset = index2
                      index9, elements7 = @offset, []
                      address54 = FAILURE
                      address54 = _read_file
                      unless address54 == FAILURE
                        elements7 << address54
                        address55 = FAILURE
                        address55 = _read_takes
                        unless address55 == FAILURE
                          elements7 << address55
                          address56 = FAILURE
                          address56 = _read_square
                          unless address56 == FAILURE
                            elements7 << address56
                          else
                            elements7 = nil
                            @offset = index9
                          end
                        else
                          elements7 = nil
                          @offset = index9
                        end
                      else
                        elements7 = nil
                        @offset = index9
                      end
                      if elements7.nil?
                        address1 = FAILURE
                      else
                        address1 = TreeNode10.new(@input[index9...@offset], index9, elements7)
                        @offset = @offset
                      end
                      if address1 == FAILURE
                        @offset = index2
                        address1 = _read_castle
                        if address1 == FAILURE
                          @offset = index2
                          address1 = _read_blacks_move
                          if address1 == FAILURE
                            @offset = index2
                          end
                        end
                      end
                    end
                  end
                end
              end
            end
          end
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address57 = FAILURE
        index10 = @offset
        address57 = _read_promotes
        if address57 == FAILURE
          address57 = TreeNode.new(@input[index10...index10], index10, [])
          @offset = index10
        end
        unless address57 == FAILURE
          elements0 << address57
          address58 = FAILURE
          index11 = @offset
          address58 = _read_check
          if address58 == FAILURE
            address58 = TreeNode.new(@input[index11...index11], index11, [])
            @offset = index11
          end
          unless address58 == FAILURE
            elements0 << address58
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:san][index0] = [address0, @offset]
      return address0
    end

    def _read_san_psq
      address0, index0 = FAILURE, @offset
      cached = @cache[:san_psq][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      index2, elements0 = @offset, []
      address1 = FAILURE
      address1 = _read_piece
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        address2 = _read_square
        unless address2 == FAILURE
          elements0 << address2
          address3 = FAILURE
          index3 = @offset
          address3 = _read_takes
          if address3 == FAILURE
            address3 = TreeNode.new(@input[index3...index3], index3, [])
            @offset = index3
          end
          unless address3 == FAILURE
            elements0 << address3
            address4 = FAILURE
            address4 = _read_square
            unless address4 == FAILURE
              elements0 << address4
            else
              elements0 = nil
              @offset = index2
            end
          else
            elements0 = nil
            @offset = index2
          end
        else
          elements0 = nil
          @offset = index2
        end
      else
        elements0 = nil
        @offset = index2
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode11.new(@input[index2...@offset], index2, elements0)
        @offset = @offset
      end
      if address0 == FAILURE
        @offset = index1
        index4, elements1 = @offset, []
        address5 = FAILURE
        address5 = _read_piece
        unless address5 == FAILURE
          elements1 << address5
          address6 = FAILURE
          index5 = @offset
          address6 = _read_takes
          if address6 == FAILURE
            address6 = TreeNode.new(@input[index5...index5], index5, [])
            @offset = index5
          end
          unless address6 == FAILURE
            elements1 << address6
            address7 = FAILURE
            address7 = _read_square
            unless address7 == FAILURE
              elements1 << address7
            else
              elements1 = nil
              @offset = index4
            end
          else
            elements1 = nil
            @offset = index4
          end
        else
          elements1 = nil
          @offset = index4
        end
        if elements1.nil?
          address0 = FAILURE
        else
          address0 = TreeNode12.new(@input[index4...@offset], index4, elements1)
          @offset = @offset
        end
        if address0 == FAILURE
          @offset = index1
          index6, elements2 = @offset, []
          address8 = FAILURE
          address8 = _read_piece
          unless address8 == FAILURE
            elements2 << address8
            address9 = FAILURE
            address9 = _read_file
            unless address9 == FAILURE
              elements2 << address9
              address10 = FAILURE
              index7 = @offset
              address10 = _read_takes
              if address10 == FAILURE
                address10 = TreeNode.new(@input[index7...index7], index7, [])
                @offset = index7
              end
              unless address10 == FAILURE
                elements2 << address10
                address11 = FAILURE
                address11 = _read_square
                unless address11 == FAILURE
                  elements2 << address11
                else
                  elements2 = nil
                  @offset = index6
                end
              else
                elements2 = nil
                @offset = index6
              end
            else
              elements2 = nil
              @offset = index6
            end
          else
            elements2 = nil
            @offset = index6
          end
          if elements2.nil?
            address0 = FAILURE
          else
            address0 = TreeNode13.new(@input[index6...@offset], index6, elements2)
            @offset = @offset
          end
          if address0 == FAILURE
            @offset = index1
            index8, elements3 = @offset, []
            address12 = FAILURE
            address12 = _read_piece
            unless address12 == FAILURE
              elements3 << address12
              address13 = FAILURE
              address13 = _read_rank
              unless address13 == FAILURE
                elements3 << address13
                address14 = FAILURE
                index9 = @offset
                address14 = _read_takes
                if address14 == FAILURE
                  address14 = TreeNode.new(@input[index9...index9], index9, [])
                  @offset = index9
                end
                unless address14 == FAILURE
                  elements3 << address14
                  address15 = FAILURE
                  address15 = _read_square
                  unless address15 == FAILURE
                    elements3 << address15
                  else
                    elements3 = nil
                    @offset = index8
                  end
                else
                  elements3 = nil
                  @offset = index8
                end
              else
                elements3 = nil
                @offset = index8
              end
            else
              elements3 = nil
              @offset = index8
            end
            if elements3.nil?
              address0 = FAILURE
            else
              address0 = TreeNode14.new(@input[index8...@offset], index8, elements3)
              @offset = @offset
            end
            if address0 == FAILURE
              @offset = index1
            end
          end
        end
      end
      @cache[:san_psq][index0] = [address0, @offset]
      return address0
    end

    def _read_piece
      address0, index0 = FAILURE, @offset
      cached = @cache[:piece][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 =~ /\A[KQRNBP]/
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "[KQRNBP]"
        end
      end
      @cache[:piece][index0] = [address0, @offset]
      return address0
    end

    def _read_disam
      address0, index0 = FAILURE, @offset
      cached = @cache[:disam][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      address0 = _read_square
      if address0 == FAILURE
        @offset = index1
        address0 = _read_file
        if address0 == FAILURE
          @offset = index1
          address0 = _read_rank
          if address0 == FAILURE
            @offset = index1
          end
        end
      end
      @cache[:disam][index0] = [address0, @offset]
      return address0
    end

    def _read_odisam
      address0, index0 = FAILURE, @offset
      cached = @cache[:odisam][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      address0 = _read_square
      if address0 == FAILURE
        @offset = index1
        address0 = _read_disam
        if address0 == FAILURE
          @offset = index1
        end
      end
      @cache[:odisam][index0] = [address0, @offset]
      return address0
    end

    def _read_takes
      address0, index0 = FAILURE, @offset
      cached = @cache[:takes][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "x"
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"x\""
        end
      end
      @cache[:takes][index0] = [address0, @offset]
      return address0
    end

    def _read_square
      address0, index0 = FAILURE, @offset
      cached = @cache[:square][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      address1 = _read_file
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        address2 = _read_rank
        unless address2 == FAILURE
          elements0 << address2
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode15.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:square][index0] = [address0, @offset]
      return address0
    end

    def _read_file
      address0, index0 = FAILURE, @offset
      cached = @cache[:file][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 =~ /\A[a-h]/
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "[a-h]"
        end
      end
      @cache[:file][index0] = [address0, @offset]
      return address0
    end

    def _read_rank
      address0, index0 = FAILURE, @offset
      cached = @cache[:rank][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 =~ /\A[1-8]/
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "[1-8]"
        end
      end
      @cache[:rank][index0] = [address0, @offset]
      return address0
    end

    def _read_promotes
      address0, index0 = FAILURE, @offset
      cached = @cache[:promotes][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "="
        address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address1 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"=\""
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        chunk1, max1 = nil, @offset + 1
        if max1 <= @input_size
          chunk1 = @input[@offset...max1]
        end
        if chunk1 =~ /\A[KQRNB]/
          address2 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
          @offset = @offset + 1
        else
          address2 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "[KQRNB]"
          end
        end
        unless address2 == FAILURE
          elements0 << address2
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:promotes][index0] = [address0, @offset]
      return address0
    end

    def _read_check
      address0, index0 = FAILURE, @offset
      cached = @cache[:check][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 =~ /\A[+#]/
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "[+#]"
        end
      end
      @cache[:check][index0] = [address0, @offset]
      return address0
    end

    def _read_castle
      address0, index0 = FAILURE, @offset
      cached = @cache[:castle][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      chunk0, max0 = nil, @offset + 5
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "O-O-O"
        address0 = TreeNode.new(@input[@offset...@offset + 5], @offset, [])
        @offset = @offset + 5
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"O-O-O\""
        end
      end
      if address0 == FAILURE
        @offset = index1
        chunk1, max1 = nil, @offset + 3
        if max1 <= @input_size
          chunk1 = @input[@offset...max1]
        end
        if chunk1 == "O-O"
          address0 = TreeNode.new(@input[@offset...@offset + 3], @offset, [])
          @offset = @offset + 3
        else
          address0 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "\"O-O\""
          end
        end
        if address0 == FAILURE
          @offset = index1
          chunk2, max2 = nil, @offset + 4
          if max2 <= @input_size
            chunk2 = @input[@offset...max2]
          end
          if chunk2 == "e1g1"
            address0 = TreeNode.new(@input[@offset...@offset + 4], @offset, [])
            @offset = @offset + 4
          else
            address0 = FAILURE
            if @offset > @failure
              @failure = @offset
              @expected = []
            end
            if @offset == @failure
              @expected << "\"e1g1\""
            end
          end
          if address0 == FAILURE
            @offset = index1
            chunk3, max3 = nil, @offset + 4
            if max3 <= @input_size
              chunk3 = @input[@offset...max3]
            end
            if chunk3 == "e8g8"
              address0 = TreeNode.new(@input[@offset...@offset + 4], @offset, [])
              @offset = @offset + 4
            else
              address0 = FAILURE
              if @offset > @failure
                @failure = @offset
                @expected = []
              end
              if @offset == @failure
                @expected << "\"e8g8\""
              end
            end
            if address0 == FAILURE
              @offset = index1
              chunk4, max4 = nil, @offset + 4
              if max4 <= @input_size
                chunk4 = @input[@offset...max4]
              end
              if chunk4 == "e1c1"
                address0 = TreeNode.new(@input[@offset...@offset + 4], @offset, [])
                @offset = @offset + 4
              else
                address0 = FAILURE
                if @offset > @failure
                  @failure = @offset
                  @expected = []
                end
                if @offset == @failure
                  @expected << "\"e1c1\""
                end
              end
              if address0 == FAILURE
                @offset = index1
                chunk5, max5 = nil, @offset + 4
                if max5 <= @input_size
                  chunk5 = @input[@offset...max5]
                end
                if chunk5 == "e8c8"
                  address0 = TreeNode.new(@input[@offset...@offset + 4], @offset, [])
                  @offset = @offset + 4
                else
                  address0 = FAILURE
                  if @offset > @failure
                    @failure = @offset
                    @expected = []
                  end
                  if @offset == @failure
                    @expected << "\"e8c8\""
                  end
                end
                if address0 == FAILURE
                  @offset = index1
                end
              end
            end
          end
        end
      end
      @cache[:castle][index0] = [address0, @offset]
      return address0
    end

    def _read_comment
      address0, index0 = FAILURE, @offset
      cached = @cache[:comment][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "{"
        address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address1 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"{\""
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        remaining0, index2, elements1, address3 = 0, @offset, [], true
        until address3 == FAILURE
          chunk1, max1 = nil, @offset + 1
          if max1 <= @input_size
            chunk1 = @input[@offset...max1]
          end
          if chunk1 =~ /\A[^\}]/
            address3 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
            @offset = @offset + 1
          else
            address3 = FAILURE
            if @offset > @failure
              @failure = @offset
              @expected = []
            end
            if @offset == @failure
              @expected << "[^\\}]"
            end
          end
          unless address3 == FAILURE
            elements1 << address3
            remaining0 -= 1
          end
        end
        if remaining0 <= 0
          address2 = TreeNode.new(@input[index2...@offset], index2, elements1)
          @offset = @offset
        else
          address2 = FAILURE
        end
        unless address2 == FAILURE
          elements0 << address2
          address4 = FAILURE
          chunk2, max2 = nil, @offset + 1
          if max2 <= @input_size
            chunk2 = @input[@offset...max2]
          end
          if chunk2 == "}"
            address4 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
            @offset = @offset + 1
          else
            address4 = FAILURE
            if @offset > @failure
              @failure = @offset
              @expected = []
            end
            if @offset == @failure
              @expected << "\"}\""
            end
          end
          unless address4 == FAILURE
            elements0 << address4
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:comment][index0] = [address0, @offset]
      return address0
    end

    def _read_blacks_move
      address0, index0 = FAILURE, @offset
      cached = @cache[:blacks_move][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 2
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == ".."
        address0 = TreeNode.new(@input[@offset...@offset + 2], @offset, [])
        @offset = @offset + 2
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"..\""
        end
      end
      @cache[:blacks_move][index0] = [address0, @offset]
      return address0
    end

    def _read_cblacks_move
      address0, index0 = FAILURE, @offset
      cached = @cache[:cblacks_move][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      chunk0, max0 = nil, @offset + 3
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "..."
        address0 = TreeNode.new(@input[@offset...@offset + 3], @offset, [])
        @offset = @offset + 3
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"...\""
        end
      end
      @cache[:cblacks_move][index0] = [address0, @offset]
      return address0
    end

    def _read_nags
      address0, index0 = FAILURE, @offset
      cached = @cache[:nags][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 1, @offset, [], true
      until address1 == FAILURE
        address1 = _read_nag
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = TreeNode.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:nags][index0] = [address0, @offset]
      return address0
    end

    def _read_nag
      address0, index0 = FAILURE, @offset
      cached = @cache[:nag][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "$"
        address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address1 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"$\""
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        remaining0, index2, elements1, address3 = 1, @offset, [], true
        until address3 == FAILURE
          chunk1, max1 = nil, @offset + 1
          if max1 <= @input_size
            chunk1 = @input[@offset...max1]
          end
          if chunk1 =~ /\A[0-9]/
            address3 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
            @offset = @offset + 1
          else
            address3 = FAILURE
            if @offset > @failure
              @failure = @offset
              @expected = []
            end
            if @offset == @failure
              @expected << "[0-9]"
            end
          end
          unless address3 == FAILURE
            elements1 << address3
            remaining0 -= 1
          end
        end
        if remaining0 <= 0
          address2 = TreeNode.new(@input[index2...@offset], index2, elements1)
          @offset = @offset
        else
          address2 = FAILURE
        end
        unless address2 == FAILURE
          elements0 << address2
          address4 = FAILURE
          address4 = _read_dlm
          unless address4 == FAILURE
            elements0 << address4
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = TreeNode16.new(@input[index1...@offset], index1, elements0)
        @offset = @offset
      end
      @cache[:nag][index0] = [address0, @offset]
      return address0
    end

    def _read_variations
      address0, index0 = FAILURE, @offset
      cached = @cache[:variations][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      remaining0, index1, elements0, address1 = 1, @offset, [], true
      until address1 == FAILURE
        address1 = _read_variation
        unless address1 == FAILURE
          elements0 << address1
          remaining0 -= 1
        end
      end
      if remaining0 <= 0
        address0 = @actions.make_variations(@input, index1, @offset, elements0)
        @offset = @offset
      else
        address0 = FAILURE
      end
      @cache[:variations][index0] = [address0, @offset]
      return address0
    end

    def _read_variation
      address0, index0 = FAILURE, @offset
      cached = @cache[:variation][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1, elements0 = @offset, []
      address1 = FAILURE
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "("
        address1 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address1 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"(\""
        end
      end
      unless address1 == FAILURE
        elements0 << address1
        address2 = FAILURE
        address2 = _read_dlm
        unless address2 == FAILURE
          elements0 << address2
          address3 = FAILURE
          address3 = _read_movetext
          unless address3 == FAILURE
            elements0 << address3
            address4 = FAILURE
            chunk1, max1 = nil, @offset + 1
            if max1 <= @input_size
              chunk1 = @input[@offset...max1]
            end
            if chunk1 == ")"
              address4 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
              @offset = @offset + 1
            else
              address4 = FAILURE
              if @offset > @failure
                @failure = @offset
                @expected = []
              end
              if @offset == @failure
                @expected << "\")\""
              end
            end
            unless address4 == FAILURE
              elements0 << address4
              address5 = FAILURE
              address5 = _read_dlm
              unless address5 == FAILURE
                elements0 << address5
              else
                elements0 = nil
                @offset = index1
              end
            else
              elements0 = nil
              @offset = index1
            end
          else
            elements0 = nil
            @offset = index1
          end
        else
          elements0 = nil
          @offset = index1
        end
      else
        elements0 = nil
        @offset = index1
      end
      if elements0.nil?
        address0 = FAILURE
      else
        address0 = @actions.make_variation(@input, index1, @offset, elements0)
        @offset = @offset
      end
      @cache[:variation][index0] = [address0, @offset]
      return address0
    end

    def _read_score
      address0, index0 = FAILURE, @offset
      cached = @cache[:score][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      chunk0, max0 = nil, @offset + 3
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 == "1-0"
        address0 = TreeNode.new(@input[@offset...@offset + 3], @offset, [])
        @offset = @offset + 3
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "\"1-0\""
        end
      end
      if address0 == FAILURE
        @offset = index1
        chunk1, max1 = nil, @offset + 3
        if max1 <= @input_size
          chunk1 = @input[@offset...max1]
        end
        if chunk1 == "0-1"
          address0 = TreeNode.new(@input[@offset...@offset + 3], @offset, [])
          @offset = @offset + 3
        else
          address0 = FAILURE
          if @offset > @failure
            @failure = @offset
            @expected = []
          end
          if @offset == @failure
            @expected << "\"0-1\""
          end
        end
        if address0 == FAILURE
          @offset = index1
          chunk2, max2 = nil, @offset + 7
          if max2 <= @input_size
            chunk2 = @input[@offset...max2]
          end
          if chunk2 == "1/2-1/2"
            address0 = TreeNode.new(@input[@offset...@offset + 7], @offset, [])
            @offset = @offset + 7
          else
            address0 = FAILURE
            if @offset > @failure
              @failure = @offset
              @expected = []
            end
            if @offset == @failure
              @expected << "\"1/2-1/2\""
            end
          end
          if address0 == FAILURE
            @offset = index1
            chunk3, max3 = nil, @offset + 1
            if max3 <= @input_size
              chunk3 = @input[@offset...max3]
            end
            if chunk3 == "*"
              address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
              @offset = @offset + 1
            else
              address0 = FAILURE
              if @offset > @failure
                @failure = @offset
                @expected = []
              end
              if @offset == @failure
                @expected << "\"*\""
              end
            end
            if address0 == FAILURE
              @offset = index1
            end
          end
        end
      end
      @cache[:score][index0] = [address0, @offset]
      return address0
    end

    def _read_dlm
      address0, index0 = FAILURE, @offset
      cached = @cache[:dlm][index0]
      if cached
        @offset = cached[1]
        return cached[0]
      end
      index1 = @offset
      chunk0, max0 = nil, @offset + 1
      if max0 <= @input_size
        chunk0 = @input[@offset...max0]
      end
      if chunk0 =~ /\A[\s+]/
        address0 = TreeNode.new(@input[@offset...@offset + 1], @offset, [])
        @offset = @offset + 1
      else
        address0 = FAILURE
        if @offset > @failure
          @failure = @offset
          @expected = []
        end
        if @offset == @failure
          @expected << "[\\s+]"
        end
      end
      if address0 == FAILURE
        address0 = TreeNode.new(@input[index1...index1], index1, [])
        @offset = index1
      end
      @cache[:dlm][index0] = [address0, @offset]
      return address0
    end
  end

  class Parser
    include Grammar

    def initialize(input, actions, types)
      @input = input
      @input_size = input.size
      @actions = actions
      @types = types
      @offset = 0
      @cache = Hash.new { |h,k| h[k] = {} }
      @failure = 0
      @expected = []
    end

    def parse
      tree = _read_game
      if tree != FAILURE and @offset == @input_size
        return tree
      end
      if @expected.empty?
        @failure = @offset
        @expected << "<EOF>"
      end
      raise ParseError, Parser.format_error(@input, @failure, @expected)
    end

    def self.format_error(input, offset, expected)
      lines, line_no, position = input.split(/\n/), 0, 0
      while position <= offset
        position += lines[line_no].size + 1
        line_no += 1
      end
      message, line = "Line #{line_no}: expected #{expected * ", "}\n", lines[line_no - 1]
      message += "#{line}\n"
      position -= line.size + 1
      message += " " * (offset - position)
      return message + "^"
    end
  end

  def self.parse(input, options = {})
    parser = Parser.new(input, options[:actions], options[:types])
    parser.parse
  end
end
