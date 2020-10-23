/**
 * This file was generated from parser.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

(function() {
  'use strict';

  var extend = function(destination, source) {
    if (!destination || !source) return destination;
    for (var key in source) {
      if (destination[key] !== source[key])
        destination[key] = source[key];
    }
    return destination;
  };

  var formatError = function(input, offset, expected) {
    var lines = input.split(/\n/g),
        lineNo = 0,
        position = 0;

    while (position <= offset) {
      position += lines[lineNo].length + 1;
      lineNo += 1;
    }
    var message = 'Line ' + lineNo + ': expected ' + expected.join(', ') + '\n',
        line = lines[lineNo - 1];

    message += line + '\n';
    position -= line.length + 1;

    while (position < offset) {
      message += ' ';
      position += 1;
    }
    return message + '^';
  };

  var inherit = function(subclass, parent) {
    var chain = function() {};
    chain.prototype = parent.prototype;
    subclass.prototype = new chain();
    subclass.prototype.constructor = subclass;
  };

  var TreeNode = function(text, offset, elements) {
    this.text = text;
    this.offset = offset;
    this.elements = elements;
  };

  TreeNode.prototype.forEach = function(block, context) {
    for (var el = this.elements, i = 0, n = el.length; i < n; i++) {
      block.call(context, el[i], i, el);
    }
  };

  var TreeNode1 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['tag_pairs'] = elements[0];
    this['gcomment'] = elements[2];
    this['movetext'] = elements[3];
    this['score'] = elements[4];
  };
  inherit(TreeNode1, TreeNode);

  var TreeNode2 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['dlm'] = elements[9];
    this['key'] = elements[2];
    this['value'] = elements[5];
  };
  inherit(TreeNode2, TreeNode);

  var TreeNode3 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['move_number'] = elements[0];
    this['dlm'] = elements[19];
    this['white'] = elements[3];
    this['san'] = elements[3];
    this['wnags'] = elements[6];
    this['wcomment'] = elements[8];
    this['wvars'] = elements[10];
    this['black'] = elements[12];
    this['bnags'] = elements[14];
    this['bcomment'] = elements[16];
    this['bvars'] = elements[18];
    this['mcomment'] = elements[20];
  };
  inherit(TreeNode3, TreeNode);

  var TreeNode4 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[3];
    this['rank'] = elements[4];
    this['dlm'] = elements[2];
  };
  inherit(TreeNode4, TreeNode);

  var TreeNode5 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[7];
    this['rank'] = elements[8];
    this['dlm'] = elements[4];
  };
  inherit(TreeNode5, TreeNode);

  var TreeNode6 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[5];
    this['rank'] = elements[6];
    this['dlm'] = elements[2];
  };
  inherit(TreeNode6, TreeNode);

  var TreeNode7 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[6];
    this['file'] = elements[9];
    this['rank'] = elements[10];
    this['dlm'] = elements[5];
  };
  inherit(TreeNode7, TreeNode);

  var TreeNode8 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[0];
    this['file'] = elements[8];
    this['rank'] = elements[9];
    this['dlm'] = elements[5];
  };
  inherit(TreeNode8, TreeNode);

  var TreeNode9 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[8];
    this['rank'] = elements[9];
    this['dlm'] = elements[4];
    this['piece'] = elements[5];
  };
  inherit(TreeNode9, TreeNode);

  var TreeNode10 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[0];
    this['takes'] = elements[1];
    this['square'] = elements[2];
  };
  inherit(TreeNode10, TreeNode);

  var TreeNode11 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[0];
    this['square'] = elements[3];
  };
  inherit(TreeNode11, TreeNode);

  var TreeNode12 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[0];
    this['square'] = elements[2];
  };
  inherit(TreeNode12, TreeNode);

  var TreeNode13 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[0];
    this['file'] = elements[1];
    this['square'] = elements[3];
  };
  inherit(TreeNode13, TreeNode);

  var TreeNode14 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['piece'] = elements[0];
    this['rank'] = elements[1];
    this['square'] = elements[3];
  };
  inherit(TreeNode14, TreeNode);

  var TreeNode15 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['file'] = elements[0];
    this['rank'] = elements[1];
  };
  inherit(TreeNode15, TreeNode);

  var TreeNode16 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['dlm'] = elements[2];
  };
  inherit(TreeNode16, TreeNode);

  var TreeNode17 = function(text, offset, elements) {
    TreeNode.apply(this, arguments);
    this['dlm'] = elements[4];
    this['movetext'] = elements[2];
  };
  inherit(TreeNode17, TreeNode);

  var FAILURE = {};

  var Grammar = {
    _read_game: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._game = this._cache._game || {};
      var cached = this._cache._game[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(6);
      var address1 = FAILURE;
      address1 = this._read_tag_pairs();
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        var index2 = this._offset;
        var chunk0 = null, max0 = this._offset + 1;
        if (max0 <= this._inputSize) {
          chunk0 = this._input.substring(this._offset, max0);
        }
        if (chunk0 !== null && /^[\n]/.test(chunk0)) {
          address2 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address2 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('[\\n]');
          }
        }
        if (address2 === FAILURE) {
          address2 = new TreeNode(this._input.substring(index2, index2), index2, []);
          this._offset = index2;
        }
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address3 = FAILURE;
          var index3 = this._offset;
          address3 = this._read_comment();
          if (address3 === FAILURE) {
            address3 = new TreeNode(this._input.substring(index3, index3), index3, []);
            this._offset = index3;
          }
          if (address3 !== FAILURE) {
            elements0[2] = address3;
            var address4 = FAILURE;
            address4 = this._read_movetext();
            if (address4 !== FAILURE) {
              elements0[3] = address4;
              var address5 = FAILURE;
              var index4 = this._offset;
              address5 = this._read_score();
              if (address5 === FAILURE) {
                address5 = new TreeNode(this._input.substring(index4, index4), index4, []);
                this._offset = index4;
              }
              if (address5 !== FAILURE) {
                elements0[4] = address5;
                var address6 = FAILURE;
                var remaining0 = 0, index5 = this._offset, elements1 = [], address7 = true;
                while (address7 !== FAILURE) {
                  var chunk1 = null, max1 = this._offset + 1;
                  if (max1 <= this._inputSize) {
                    chunk1 = this._input.substring(this._offset, max1);
                  }
                  if (chunk1 !== null && /^[\s]/.test(chunk1)) {
                    address7 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
                    this._offset = this._offset + 1;
                  } else {
                    address7 = FAILURE;
                    if (this._offset > this._failure) {
                      this._failure = this._offset;
                      this._expected = [];
                    }
                    if (this._offset === this._failure) {
                      this._expected.push('[\\s]');
                    }
                  }
                  if (address7 !== FAILURE) {
                    elements1.push(address7);
                    --remaining0;
                  }
                }
                if (remaining0 <= 0) {
                  address6 = new TreeNode(this._input.substring(index5, this._offset), index5, elements1);
                  this._offset = this._offset;
                } else {
                  address6 = FAILURE;
                }
                if (address6 !== FAILURE) {
                  elements0[5] = address6;
                } else {
                  elements0 = null;
                  this._offset = index1;
                }
              } else {
                elements0 = null;
                this._offset = index1;
              }
            } else {
              elements0 = null;
              this._offset = index1;
            }
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = this._actions.make_game(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      }
      this._cache._game[index0] = [address0, this._offset];
      return address0;
    },

    _read_tag_pairs: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._tag_pairs = this._cache._tag_pairs || {};
      var cached = this._cache._tag_pairs[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 0, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        address1 = this._read_tag_pair();
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = this._actions.make_tag_pairs(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._tag_pairs[index0] = [address0, this._offset];
      return address0;
    },

    _read_tag_pair: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._tag_pair = this._cache._tag_pair || {};
      var cached = this._cache._tag_pair[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(10);
      var address1 = FAILURE;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '[') {
        address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address1 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"["');
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        address2 = this._read_dlm();
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address3 = FAILURE;
          address3 = this._read_key();
          if (address3 !== FAILURE) {
            elements0[2] = address3;
            var address4 = FAILURE;
            address4 = this._read_dlm();
            if (address4 !== FAILURE) {
              elements0[3] = address4;
              var address5 = FAILURE;
              var chunk1 = null, max1 = this._offset + 1;
              if (max1 <= this._inputSize) {
                chunk1 = this._input.substring(this._offset, max1);
              }
              if (chunk1 === '"') {
                address5 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
                this._offset = this._offset + 1;
              } else {
                address5 = FAILURE;
                if (this._offset > this._failure) {
                  this._failure = this._offset;
                  this._expected = [];
                }
                if (this._offset === this._failure) {
                  this._expected.push('"\\""');
                }
              }
              if (address5 !== FAILURE) {
                elements0[4] = address5;
                var address6 = FAILURE;
                address6 = this._read_value();
                if (address6 !== FAILURE) {
                  elements0[5] = address6;
                  var address7 = FAILURE;
                  var chunk2 = null, max2 = this._offset + 1;
                  if (max2 <= this._inputSize) {
                    chunk2 = this._input.substring(this._offset, max2);
                  }
                  if (chunk2 === '"') {
                    address7 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
                    this._offset = this._offset + 1;
                  } else {
                    address7 = FAILURE;
                    if (this._offset > this._failure) {
                      this._failure = this._offset;
                      this._expected = [];
                    }
                    if (this._offset === this._failure) {
                      this._expected.push('"\\""');
                    }
                  }
                  if (address7 !== FAILURE) {
                    elements0[6] = address7;
                    var address8 = FAILURE;
                    address8 = this._read_dlm();
                    if (address8 !== FAILURE) {
                      elements0[7] = address8;
                      var address9 = FAILURE;
                      var chunk3 = null, max3 = this._offset + 1;
                      if (max3 <= this._inputSize) {
                        chunk3 = this._input.substring(this._offset, max3);
                      }
                      if (chunk3 === ']') {
                        address9 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
                        this._offset = this._offset + 1;
                      } else {
                        address9 = FAILURE;
                        if (this._offset > this._failure) {
                          this._failure = this._offset;
                          this._expected = [];
                        }
                        if (this._offset === this._failure) {
                          this._expected.push('"]"');
                        }
                      }
                      if (address9 !== FAILURE) {
                        elements0[8] = address9;
                        var address10 = FAILURE;
                        address10 = this._read_dlm();
                        if (address10 !== FAILURE) {
                          elements0[9] = address10;
                        } else {
                          elements0 = null;
                          this._offset = index1;
                        }
                      } else {
                        elements0 = null;
                        this._offset = index1;
                      }
                    } else {
                      elements0 = null;
                      this._offset = index1;
                    }
                  } else {
                    elements0 = null;
                    this._offset = index1;
                  }
                } else {
                  elements0 = null;
                  this._offset = index1;
                }
              } else {
                elements0 = null;
                this._offset = index1;
              }
            } else {
              elements0 = null;
              this._offset = index1;
            }
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = this._actions.make_tag_pair(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      }
      this._cache._tag_pair[index0] = [address0, this._offset];
      return address0;
    },

    _read_key: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._key = this._cache._key || {};
      var cached = this._cache._key[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 1, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        var chunk0 = null, max0 = this._offset + 1;
        if (max0 <= this._inputSize) {
          chunk0 = this._input.substring(this._offset, max0);
        }
        if (chunk0 !== null && /^[A-Za-z0-9_]/.test(chunk0)) {
          address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address1 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('[A-Za-z0-9_]');
          }
        }
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._key[index0] = [address0, this._offset];
      return address0;
    },

    _read_value: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._value = this._cache._value || {};
      var cached = this._cache._value[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 0, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        var chunk0 = null, max0 = this._offset + 1;
        if (max0 <= this._inputSize) {
          chunk0 = this._input.substring(this._offset, max0);
        }
        if (chunk0 !== null && /^[^\"]/.test(chunk0)) {
          address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address1 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('[^\\"]');
          }
        }
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._value[index0] = [address0, this._offset];
      return address0;
    },

    _read_movetext: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._movetext = this._cache._movetext || {};
      var cached = this._cache._movetext[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 0, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        address1 = this._read_move();
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = this._actions.make_movetext(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._movetext[index0] = [address0, this._offset];
      return address0;
    },

    _read_move: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._move = this._cache._move || {};
      var cached = this._cache._move[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(21);
      var address1 = FAILURE;
      address1 = this._read_move_number();
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        address2 = this._read_dlm();
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address3 = FAILURE;
          address3 = this._read_dlm();
          if (address3 !== FAILURE) {
            elements0[2] = address3;
            var address4 = FAILURE;
            address4 = this._read_san();
            if (address4 !== FAILURE) {
              elements0[3] = address4;
              var address5 = FAILURE;
              address5 = this._read_dlm();
              if (address5 !== FAILURE) {
                elements0[4] = address5;
                var address6 = FAILURE;
                address6 = this._read_dlm();
                if (address6 !== FAILURE) {
                  elements0[5] = address6;
                  var address7 = FAILURE;
                  var index2 = this._offset;
                  address7 = this._read_nags();
                  if (address7 === FAILURE) {
                    address7 = new TreeNode(this._input.substring(index2, index2), index2, []);
                    this._offset = index2;
                  }
                  if (address7 !== FAILURE) {
                    elements0[6] = address7;
                    var address8 = FAILURE;
                    address8 = this._read_dlm();
                    if (address8 !== FAILURE) {
                      elements0[7] = address8;
                      var address9 = FAILURE;
                      var index3 = this._offset;
                      address9 = this._read_comment();
                      if (address9 === FAILURE) {
                        address9 = new TreeNode(this._input.substring(index3, index3), index3, []);
                        this._offset = index3;
                      }
                      if (address9 !== FAILURE) {
                        elements0[8] = address9;
                        var address10 = FAILURE;
                        address10 = this._read_dlm();
                        if (address10 !== FAILURE) {
                          elements0[9] = address10;
                          var address11 = FAILURE;
                          var index4 = this._offset;
                          address11 = this._read_variations();
                          if (address11 === FAILURE) {
                            address11 = new TreeNode(this._input.substring(index4, index4), index4, []);
                            this._offset = index4;
                          }
                          if (address11 !== FAILURE) {
                            elements0[10] = address11;
                            var address12 = FAILURE;
                            address12 = this._read_dlm();
                            if (address12 !== FAILURE) {
                              elements0[11] = address12;
                              var address13 = FAILURE;
                              var index5 = this._offset;
                              address13 = this._read_san();
                              if (address13 === FAILURE) {
                                address13 = new TreeNode(this._input.substring(index5, index5), index5, []);
                                this._offset = index5;
                              }
                              if (address13 !== FAILURE) {
                                elements0[12] = address13;
                                var address14 = FAILURE;
                                address14 = this._read_dlm();
                                if (address14 !== FAILURE) {
                                  elements0[13] = address14;
                                  var address15 = FAILURE;
                                  var index6 = this._offset;
                                  address15 = this._read_nags();
                                  if (address15 === FAILURE) {
                                    address15 = new TreeNode(this._input.substring(index6, index6), index6, []);
                                    this._offset = index6;
                                  }
                                  if (address15 !== FAILURE) {
                                    elements0[14] = address15;
                                    var address16 = FAILURE;
                                    address16 = this._read_dlm();
                                    if (address16 !== FAILURE) {
                                      elements0[15] = address16;
                                      var address17 = FAILURE;
                                      var index7 = this._offset;
                                      address17 = this._read_comment();
                                      if (address17 === FAILURE) {
                                        address17 = new TreeNode(this._input.substring(index7, index7), index7, []);
                                        this._offset = index7;
                                      }
                                      if (address17 !== FAILURE) {
                                        elements0[16] = address17;
                                        var address18 = FAILURE;
                                        address18 = this._read_dlm();
                                        if (address18 !== FAILURE) {
                                          elements0[17] = address18;
                                          var address19 = FAILURE;
                                          var index8 = this._offset;
                                          address19 = this._read_variations();
                                          if (address19 === FAILURE) {
                                            address19 = new TreeNode(this._input.substring(index8, index8), index8, []);
                                            this._offset = index8;
                                          }
                                          if (address19 !== FAILURE) {
                                            elements0[18] = address19;
                                            var address20 = FAILURE;
                                            address20 = this._read_dlm();
                                            if (address20 !== FAILURE) {
                                              elements0[19] = address20;
                                              var address21 = FAILURE;
                                              var index9 = this._offset;
                                              address21 = this._read_comment();
                                              if (address21 === FAILURE) {
                                                address21 = new TreeNode(this._input.substring(index9, index9), index9, []);
                                                this._offset = index9;
                                              }
                                              if (address21 !== FAILURE) {
                                                elements0[20] = address21;
                                              } else {
                                                elements0 = null;
                                                this._offset = index1;
                                              }
                                            } else {
                                              elements0 = null;
                                              this._offset = index1;
                                            }
                                          } else {
                                            elements0 = null;
                                            this._offset = index1;
                                          }
                                        } else {
                                          elements0 = null;
                                          this._offset = index1;
                                        }
                                      } else {
                                        elements0 = null;
                                        this._offset = index1;
                                      }
                                    } else {
                                      elements0 = null;
                                      this._offset = index1;
                                    }
                                  } else {
                                    elements0 = null;
                                    this._offset = index1;
                                  }
                                } else {
                                  elements0 = null;
                                  this._offset = index1;
                                }
                              } else {
                                elements0 = null;
                                this._offset = index1;
                              }
                            } else {
                              elements0 = null;
                              this._offset = index1;
                            }
                          } else {
                            elements0 = null;
                            this._offset = index1;
                          }
                        } else {
                          elements0 = null;
                          this._offset = index1;
                        }
                      } else {
                        elements0 = null;
                        this._offset = index1;
                      }
                    } else {
                      elements0 = null;
                      this._offset = index1;
                    }
                  } else {
                    elements0 = null;
                    this._offset = index1;
                  }
                } else {
                  elements0 = null;
                  this._offset = index1;
                }
              } else {
                elements0 = null;
                this._offset = index1;
              }
            } else {
              elements0 = null;
              this._offset = index1;
            }
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode3(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._move[index0] = [address0, this._offset];
      return address0;
    },

    _read_move_number: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._move_number = this._cache._move_number || {};
      var cached = this._cache._move_number[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(2);
      var address1 = FAILURE;
      var remaining0 = 1, index2 = this._offset, elements1 = [], address2 = true;
      while (address2 !== FAILURE) {
        var chunk0 = null, max0 = this._offset + 1;
        if (max0 <= this._inputSize) {
          chunk0 = this._input.substring(this._offset, max0);
        }
        if (chunk0 !== null && /^[0-9]/.test(chunk0)) {
          address2 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address2 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('[0-9]');
          }
        }
        if (address2 !== FAILURE) {
          elements1.push(address2);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address1 = new TreeNode(this._input.substring(index2, this._offset), index2, elements1);
        this._offset = this._offset;
      } else {
        address1 = FAILURE;
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address3 = FAILURE;
        var chunk1 = null, max1 = this._offset + 1;
        if (max1 <= this._inputSize) {
          chunk1 = this._input.substring(this._offset, max1);
        }
        if (chunk1 === '.') {
          address3 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address3 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('"."');
          }
        }
        if (address3 !== FAILURE) {
          elements0[1] = address3;
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._move_number[index0] = [address0, this._offset];
      return address0;
    },

    _read_san: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._san = this._cache._san || {};
      var cached = this._cache._san[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(3);
      var address1 = FAILURE;
      var index2 = this._offset;
      var index3 = this._offset, elements1 = new Array(5);
      var address2 = FAILURE;
      address2 = this._read_file();
      if (address2 !== FAILURE) {
        elements1[0] = address2;
        var address3 = FAILURE;
        address3 = this._read_rank();
        if (address3 !== FAILURE) {
          elements1[1] = address3;
          var address4 = FAILURE;
          address4 = this._read_dlm();
          if (address4 !== FAILURE) {
            elements1[2] = address4;
            var address5 = FAILURE;
            address5 = this._read_file();
            if (address5 !== FAILURE) {
              elements1[3] = address5;
              var address6 = FAILURE;
              address6 = this._read_rank();
              if (address6 !== FAILURE) {
                elements1[4] = address6;
              } else {
                elements1 = null;
                this._offset = index3;
              }
            } else {
              elements1 = null;
              this._offset = index3;
            }
          } else {
            elements1 = null;
            this._offset = index3;
          }
        } else {
          elements1 = null;
          this._offset = index3;
        }
      } else {
        elements1 = null;
        this._offset = index3;
      }
      if (elements1 === null) {
        address1 = FAILURE;
      } else {
        address1 = new TreeNode4(this._input.substring(index3, this._offset), index3, elements1);
        this._offset = this._offset;
      }
      if (address1 === FAILURE) {
        this._offset = index2;
        var index4 = this._offset, elements2 = new Array(9);
        var address7 = FAILURE;
        address7 = this._read_file();
        if (address7 !== FAILURE) {
          elements2[0] = address7;
          var address8 = FAILURE;
          address8 = this._read_rank();
          if (address8 !== FAILURE) {
            elements2[1] = address8;
            var address9 = FAILURE;
            address9 = this._read_file();
            if (address9 !== FAILURE) {
              elements2[2] = address9;
              var address10 = FAILURE;
              address10 = this._read_rank();
              if (address10 !== FAILURE) {
                elements2[3] = address10;
                var address11 = FAILURE;
                address11 = this._read_dlm();
                if (address11 !== FAILURE) {
                  elements2[4] = address11;
                  var address12 = FAILURE;
                  address12 = this._read_file();
                  if (address12 !== FAILURE) {
                    elements2[5] = address12;
                    var address13 = FAILURE;
                    address13 = this._read_rank();
                    if (address13 !== FAILURE) {
                      elements2[6] = address13;
                      var address14 = FAILURE;
                      address14 = this._read_file();
                      if (address14 !== FAILURE) {
                        elements2[7] = address14;
                        var address15 = FAILURE;
                        address15 = this._read_rank();
                        if (address15 !== FAILURE) {
                          elements2[8] = address15;
                        } else {
                          elements2 = null;
                          this._offset = index4;
                        }
                      } else {
                        elements2 = null;
                        this._offset = index4;
                      }
                    } else {
                      elements2 = null;
                      this._offset = index4;
                    }
                  } else {
                    elements2 = null;
                    this._offset = index4;
                  }
                } else {
                  elements2 = null;
                  this._offset = index4;
                }
              } else {
                elements2 = null;
                this._offset = index4;
              }
            } else {
              elements2 = null;
              this._offset = index4;
            }
          } else {
            elements2 = null;
            this._offset = index4;
          }
        } else {
          elements2 = null;
          this._offset = index4;
        }
        if (elements2 === null) {
          address1 = FAILURE;
        } else {
          address1 = new TreeNode5(this._input.substring(index4, this._offset), index4, elements2);
          this._offset = this._offset;
        }
        if (address1 === FAILURE) {
          this._offset = index2;
          var index5 = this._offset, elements3 = new Array(7);
          var address16 = FAILURE;
          address16 = this._read_file();
          if (address16 !== FAILURE) {
            elements3[0] = address16;
            var address17 = FAILURE;
            address17 = this._read_rank();
            if (address17 !== FAILURE) {
              elements3[1] = address17;
              var address18 = FAILURE;
              address18 = this._read_dlm();
              if (address18 !== FAILURE) {
                elements3[2] = address18;
                var address19 = FAILURE;
                address19 = this._read_file();
                if (address19 !== FAILURE) {
                  elements3[3] = address19;
                  var address20 = FAILURE;
                  address20 = this._read_rank();
                  if (address20 !== FAILURE) {
                    elements3[4] = address20;
                    var address21 = FAILURE;
                    address21 = this._read_file();
                    if (address21 !== FAILURE) {
                      elements3[5] = address21;
                      var address22 = FAILURE;
                      address22 = this._read_rank();
                      if (address22 !== FAILURE) {
                        elements3[6] = address22;
                      } else {
                        elements3 = null;
                        this._offset = index5;
                      }
                    } else {
                      elements3 = null;
                      this._offset = index5;
                    }
                  } else {
                    elements3 = null;
                    this._offset = index5;
                  }
                } else {
                  elements3 = null;
                  this._offset = index5;
                }
              } else {
                elements3 = null;
                this._offset = index5;
              }
            } else {
              elements3 = null;
              this._offset = index5;
            }
          } else {
            elements3 = null;
            this._offset = index5;
          }
          if (elements3 === null) {
            address1 = FAILURE;
          } else {
            address1 = new TreeNode6(this._input.substring(index5, this._offset), index5, elements3);
            this._offset = this._offset;
          }
          if (address1 === FAILURE) {
            this._offset = index2;
            var index6 = this._offset, elements4 = new Array(11);
            var address23 = FAILURE;
            address23 = this._read_piece();
            if (address23 !== FAILURE) {
              elements4[0] = address23;
              var address24 = FAILURE;
              address24 = this._read_file();
              if (address24 !== FAILURE) {
                elements4[1] = address24;
                var address25 = FAILURE;
                address25 = this._read_rank();
                if (address25 !== FAILURE) {
                  elements4[2] = address25;
                  var address26 = FAILURE;
                  address26 = this._read_file();
                  if (address26 !== FAILURE) {
                    elements4[3] = address26;
                    var address27 = FAILURE;
                    address27 = this._read_rank();
                    if (address27 !== FAILURE) {
                      elements4[4] = address27;
                      var address28 = FAILURE;
                      address28 = this._read_dlm();
                      if (address28 !== FAILURE) {
                        elements4[5] = address28;
                        var address29 = FAILURE;
                        address29 = this._read_piece();
                        if (address29 !== FAILURE) {
                          elements4[6] = address29;
                          var address30 = FAILURE;
                          address30 = this._read_file();
                          if (address30 !== FAILURE) {
                            elements4[7] = address30;
                            var address31 = FAILURE;
                            address31 = this._read_rank();
                            if (address31 !== FAILURE) {
                              elements4[8] = address31;
                              var address32 = FAILURE;
                              address32 = this._read_file();
                              if (address32 !== FAILURE) {
                                elements4[9] = address32;
                                var address33 = FAILURE;
                                address33 = this._read_rank();
                                if (address33 !== FAILURE) {
                                  elements4[10] = address33;
                                } else {
                                  elements4 = null;
                                  this._offset = index6;
                                }
                              } else {
                                elements4 = null;
                                this._offset = index6;
                              }
                            } else {
                              elements4 = null;
                              this._offset = index6;
                            }
                          } else {
                            elements4 = null;
                            this._offset = index6;
                          }
                        } else {
                          elements4 = null;
                          this._offset = index6;
                        }
                      } else {
                        elements4 = null;
                        this._offset = index6;
                      }
                    } else {
                      elements4 = null;
                      this._offset = index6;
                    }
                  } else {
                    elements4 = null;
                    this._offset = index6;
                  }
                } else {
                  elements4 = null;
                  this._offset = index6;
                }
              } else {
                elements4 = null;
                this._offset = index6;
              }
            } else {
              elements4 = null;
              this._offset = index6;
            }
            if (elements4 === null) {
              address1 = FAILURE;
            } else {
              address1 = new TreeNode7(this._input.substring(index6, this._offset), index6, elements4);
              this._offset = this._offset;
            }
            if (address1 === FAILURE) {
              this._offset = index2;
              var index7 = this._offset, elements5 = new Array(10);
              var address34 = FAILURE;
              address34 = this._read_piece();
              if (address34 !== FAILURE) {
                elements5[0] = address34;
                var address35 = FAILURE;
                address35 = this._read_file();
                if (address35 !== FAILURE) {
                  elements5[1] = address35;
                  var address36 = FAILURE;
                  address36 = this._read_rank();
                  if (address36 !== FAILURE) {
                    elements5[2] = address36;
                    var address37 = FAILURE;
                    address37 = this._read_file();
                    if (address37 !== FAILURE) {
                      elements5[3] = address37;
                      var address38 = FAILURE;
                      address38 = this._read_rank();
                      if (address38 !== FAILURE) {
                        elements5[4] = address38;
                        var address39 = FAILURE;
                        address39 = this._read_dlm();
                        if (address39 !== FAILURE) {
                          elements5[5] = address39;
                          var address40 = FAILURE;
                          address40 = this._read_file();
                          if (address40 !== FAILURE) {
                            elements5[6] = address40;
                            var address41 = FAILURE;
                            address41 = this._read_rank();
                            if (address41 !== FAILURE) {
                              elements5[7] = address41;
                              var address42 = FAILURE;
                              address42 = this._read_file();
                              if (address42 !== FAILURE) {
                                elements5[8] = address42;
                                var address43 = FAILURE;
                                address43 = this._read_rank();
                                if (address43 !== FAILURE) {
                                  elements5[9] = address43;
                                } else {
                                  elements5 = null;
                                  this._offset = index7;
                                }
                              } else {
                                elements5 = null;
                                this._offset = index7;
                              }
                            } else {
                              elements5 = null;
                              this._offset = index7;
                            }
                          } else {
                            elements5 = null;
                            this._offset = index7;
                          }
                        } else {
                          elements5 = null;
                          this._offset = index7;
                        }
                      } else {
                        elements5 = null;
                        this._offset = index7;
                      }
                    } else {
                      elements5 = null;
                      this._offset = index7;
                    }
                  } else {
                    elements5 = null;
                    this._offset = index7;
                  }
                } else {
                  elements5 = null;
                  this._offset = index7;
                }
              } else {
                elements5 = null;
                this._offset = index7;
              }
              if (elements5 === null) {
                address1 = FAILURE;
              } else {
                address1 = new TreeNode8(this._input.substring(index7, this._offset), index7, elements5);
                this._offset = this._offset;
              }
              if (address1 === FAILURE) {
                this._offset = index2;
                var index8 = this._offset, elements6 = new Array(10);
                var address44 = FAILURE;
                address44 = this._read_file();
                if (address44 !== FAILURE) {
                  elements6[0] = address44;
                  var address45 = FAILURE;
                  address45 = this._read_rank();
                  if (address45 !== FAILURE) {
                    elements6[1] = address45;
                    var address46 = FAILURE;
                    address46 = this._read_file();
                    if (address46 !== FAILURE) {
                      elements6[2] = address46;
                      var address47 = FAILURE;
                      address47 = this._read_rank();
                      if (address47 !== FAILURE) {
                        elements6[3] = address47;
                        var address48 = FAILURE;
                        address48 = this._read_dlm();
                        if (address48 !== FAILURE) {
                          elements6[4] = address48;
                          var address49 = FAILURE;
                          address49 = this._read_piece();
                          if (address49 !== FAILURE) {
                            elements6[5] = address49;
                            var address50 = FAILURE;
                            address50 = this._read_file();
                            if (address50 !== FAILURE) {
                              elements6[6] = address50;
                              var address51 = FAILURE;
                              address51 = this._read_rank();
                              if (address51 !== FAILURE) {
                                elements6[7] = address51;
                                var address52 = FAILURE;
                                address52 = this._read_file();
                                if (address52 !== FAILURE) {
                                  elements6[8] = address52;
                                  var address53 = FAILURE;
                                  address53 = this._read_rank();
                                  if (address53 !== FAILURE) {
                                    elements6[9] = address53;
                                  } else {
                                    elements6 = null;
                                    this._offset = index8;
                                  }
                                } else {
                                  elements6 = null;
                                  this._offset = index8;
                                }
                              } else {
                                elements6 = null;
                                this._offset = index8;
                              }
                            } else {
                              elements6 = null;
                              this._offset = index8;
                            }
                          } else {
                            elements6 = null;
                            this._offset = index8;
                          }
                        } else {
                          elements6 = null;
                          this._offset = index8;
                        }
                      } else {
                        elements6 = null;
                        this._offset = index8;
                      }
                    } else {
                      elements6 = null;
                      this._offset = index8;
                    }
                  } else {
                    elements6 = null;
                    this._offset = index8;
                  }
                } else {
                  elements6 = null;
                  this._offset = index8;
                }
                if (elements6 === null) {
                  address1 = FAILURE;
                } else {
                  address1 = new TreeNode9(this._input.substring(index8, this._offset), index8, elements6);
                  this._offset = this._offset;
                }
                if (address1 === FAILURE) {
                  this._offset = index2;
                  address1 = this._read_square();
                  if (address1 === FAILURE) {
                    this._offset = index2;
                    address1 = this._read_san_psq();
                    if (address1 === FAILURE) {
                      this._offset = index2;
                      var index9 = this._offset, elements7 = new Array(3);
                      var address54 = FAILURE;
                      address54 = this._read_file();
                      if (address54 !== FAILURE) {
                        elements7[0] = address54;
                        var address55 = FAILURE;
                        address55 = this._read_takes();
                        if (address55 !== FAILURE) {
                          elements7[1] = address55;
                          var address56 = FAILURE;
                          address56 = this._read_square();
                          if (address56 !== FAILURE) {
                            elements7[2] = address56;
                          } else {
                            elements7 = null;
                            this._offset = index9;
                          }
                        } else {
                          elements7 = null;
                          this._offset = index9;
                        }
                      } else {
                        elements7 = null;
                        this._offset = index9;
                      }
                      if (elements7 === null) {
                        address1 = FAILURE;
                      } else {
                        address1 = new TreeNode10(this._input.substring(index9, this._offset), index9, elements7);
                        this._offset = this._offset;
                      }
                      if (address1 === FAILURE) {
                        this._offset = index2;
                        address1 = this._read_castle();
                        if (address1 === FAILURE) {
                          this._offset = index2;
                          address1 = this._read_blacks_move();
                          if (address1 === FAILURE) {
                            this._offset = index2;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address57 = FAILURE;
        var index10 = this._offset;
        address57 = this._read_promotes();
        if (address57 === FAILURE) {
          address57 = new TreeNode(this._input.substring(index10, index10), index10, []);
          this._offset = index10;
        }
        if (address57 !== FAILURE) {
          elements0[1] = address57;
          var address58 = FAILURE;
          var index11 = this._offset;
          address58 = this._read_check();
          if (address58 === FAILURE) {
            address58 = new TreeNode(this._input.substring(index11, index11), index11, []);
            this._offset = index11;
          }
          if (address58 !== FAILURE) {
            elements0[2] = address58;
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._san[index0] = [address0, this._offset];
      return address0;
    },

    _read_san_psq: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._san_psq = this._cache._san_psq || {};
      var cached = this._cache._san_psq[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      var index2 = this._offset, elements0 = new Array(4);
      var address1 = FAILURE;
      address1 = this._read_piece();
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        address2 = this._read_square();
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address3 = FAILURE;
          var index3 = this._offset;
          address3 = this._read_takes();
          if (address3 === FAILURE) {
            address3 = new TreeNode(this._input.substring(index3, index3), index3, []);
            this._offset = index3;
          }
          if (address3 !== FAILURE) {
            elements0[2] = address3;
            var address4 = FAILURE;
            address4 = this._read_square();
            if (address4 !== FAILURE) {
              elements0[3] = address4;
            } else {
              elements0 = null;
              this._offset = index2;
            }
          } else {
            elements0 = null;
            this._offset = index2;
          }
        } else {
          elements0 = null;
          this._offset = index2;
        }
      } else {
        elements0 = null;
        this._offset = index2;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode11(this._input.substring(index2, this._offset), index2, elements0);
        this._offset = this._offset;
      }
      if (address0 === FAILURE) {
        this._offset = index1;
        var index4 = this._offset, elements1 = new Array(3);
        var address5 = FAILURE;
        address5 = this._read_piece();
        if (address5 !== FAILURE) {
          elements1[0] = address5;
          var address6 = FAILURE;
          var index5 = this._offset;
          address6 = this._read_takes();
          if (address6 === FAILURE) {
            address6 = new TreeNode(this._input.substring(index5, index5), index5, []);
            this._offset = index5;
          }
          if (address6 !== FAILURE) {
            elements1[1] = address6;
            var address7 = FAILURE;
            address7 = this._read_square();
            if (address7 !== FAILURE) {
              elements1[2] = address7;
            } else {
              elements1 = null;
              this._offset = index4;
            }
          } else {
            elements1 = null;
            this._offset = index4;
          }
        } else {
          elements1 = null;
          this._offset = index4;
        }
        if (elements1 === null) {
          address0 = FAILURE;
        } else {
          address0 = new TreeNode12(this._input.substring(index4, this._offset), index4, elements1);
          this._offset = this._offset;
        }
        if (address0 === FAILURE) {
          this._offset = index1;
          var index6 = this._offset, elements2 = new Array(4);
          var address8 = FAILURE;
          address8 = this._read_piece();
          if (address8 !== FAILURE) {
            elements2[0] = address8;
            var address9 = FAILURE;
            address9 = this._read_file();
            if (address9 !== FAILURE) {
              elements2[1] = address9;
              var address10 = FAILURE;
              var index7 = this._offset;
              address10 = this._read_takes();
              if (address10 === FAILURE) {
                address10 = new TreeNode(this._input.substring(index7, index7), index7, []);
                this._offset = index7;
              }
              if (address10 !== FAILURE) {
                elements2[2] = address10;
                var address11 = FAILURE;
                address11 = this._read_square();
                if (address11 !== FAILURE) {
                  elements2[3] = address11;
                } else {
                  elements2 = null;
                  this._offset = index6;
                }
              } else {
                elements2 = null;
                this._offset = index6;
              }
            } else {
              elements2 = null;
              this._offset = index6;
            }
          } else {
            elements2 = null;
            this._offset = index6;
          }
          if (elements2 === null) {
            address0 = FAILURE;
          } else {
            address0 = new TreeNode13(this._input.substring(index6, this._offset), index6, elements2);
            this._offset = this._offset;
          }
          if (address0 === FAILURE) {
            this._offset = index1;
            var index8 = this._offset, elements3 = new Array(4);
            var address12 = FAILURE;
            address12 = this._read_piece();
            if (address12 !== FAILURE) {
              elements3[0] = address12;
              var address13 = FAILURE;
              address13 = this._read_rank();
              if (address13 !== FAILURE) {
                elements3[1] = address13;
                var address14 = FAILURE;
                var index9 = this._offset;
                address14 = this._read_takes();
                if (address14 === FAILURE) {
                  address14 = new TreeNode(this._input.substring(index9, index9), index9, []);
                  this._offset = index9;
                }
                if (address14 !== FAILURE) {
                  elements3[2] = address14;
                  var address15 = FAILURE;
                  address15 = this._read_square();
                  if (address15 !== FAILURE) {
                    elements3[3] = address15;
                  } else {
                    elements3 = null;
                    this._offset = index8;
                  }
                } else {
                  elements3 = null;
                  this._offset = index8;
                }
              } else {
                elements3 = null;
                this._offset = index8;
              }
            } else {
              elements3 = null;
              this._offset = index8;
            }
            if (elements3 === null) {
              address0 = FAILURE;
            } else {
              address0 = new TreeNode14(this._input.substring(index8, this._offset), index8, elements3);
              this._offset = this._offset;
            }
            if (address0 === FAILURE) {
              this._offset = index1;
            }
          }
        }
      }
      this._cache._san_psq[index0] = [address0, this._offset];
      return address0;
    },

    _read_piece: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._piece = this._cache._piece || {};
      var cached = this._cache._piece[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 !== null && /^[KQRNBP]/.test(chunk0)) {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('[KQRNBP]');
        }
      }
      this._cache._piece[index0] = [address0, this._offset];
      return address0;
    },

    _read_disam: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._disam = this._cache._disam || {};
      var cached = this._cache._disam[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      address0 = this._read_square();
      if (address0 === FAILURE) {
        this._offset = index1;
        address0 = this._read_file();
        if (address0 === FAILURE) {
          this._offset = index1;
          address0 = this._read_rank();
          if (address0 === FAILURE) {
            this._offset = index1;
          }
        }
      }
      this._cache._disam[index0] = [address0, this._offset];
      return address0;
    },

    _read_odisam: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._odisam = this._cache._odisam || {};
      var cached = this._cache._odisam[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      address0 = this._read_square();
      if (address0 === FAILURE) {
        this._offset = index1;
        address0 = this._read_disam();
        if (address0 === FAILURE) {
          this._offset = index1;
        }
      }
      this._cache._odisam[index0] = [address0, this._offset];
      return address0;
    },

    _read_takes: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._takes = this._cache._takes || {};
      var cached = this._cache._takes[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === 'x') {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"x"');
        }
      }
      this._cache._takes[index0] = [address0, this._offset];
      return address0;
    },

    _read_square: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._square = this._cache._square || {};
      var cached = this._cache._square[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(2);
      var address1 = FAILURE;
      address1 = this._read_file();
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        address2 = this._read_rank();
        if (address2 !== FAILURE) {
          elements0[1] = address2;
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode15(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._square[index0] = [address0, this._offset];
      return address0;
    },

    _read_file: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._file = this._cache._file || {};
      var cached = this._cache._file[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 !== null && /^[a-h]/.test(chunk0)) {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('[a-h]');
        }
      }
      this._cache._file[index0] = [address0, this._offset];
      return address0;
    },

    _read_rank: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._rank = this._cache._rank || {};
      var cached = this._cache._rank[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 !== null && /^[1-8]/.test(chunk0)) {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('[1-8]');
        }
      }
      this._cache._rank[index0] = [address0, this._offset];
      return address0;
    },

    _read_promotes: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._promotes = this._cache._promotes || {};
      var cached = this._cache._promotes[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(2);
      var address1 = FAILURE;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '=') {
        address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address1 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"="');
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        var chunk1 = null, max1 = this._offset + 1;
        if (max1 <= this._inputSize) {
          chunk1 = this._input.substring(this._offset, max1);
        }
        if (chunk1 !== null && /^[KQRNB]/.test(chunk1)) {
          address2 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
          this._offset = this._offset + 1;
        } else {
          address2 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('[KQRNB]');
          }
        }
        if (address2 !== FAILURE) {
          elements0[1] = address2;
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._promotes[index0] = [address0, this._offset];
      return address0;
    },

    _read_check: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._check = this._cache._check || {};
      var cached = this._cache._check[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 !== null && /^[+#]/.test(chunk0)) {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('[+#]');
        }
      }
      this._cache._check[index0] = [address0, this._offset];
      return address0;
    },

    _read_castle: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._castle = this._cache._castle || {};
      var cached = this._cache._castle[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      var chunk0 = null, max0 = this._offset + 5;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === 'O-O-O') {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 5), this._offset, []);
        this._offset = this._offset + 5;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"O-O-O"');
        }
      }
      if (address0 === FAILURE) {
        this._offset = index1;
        var chunk1 = null, max1 = this._offset + 3;
        if (max1 <= this._inputSize) {
          chunk1 = this._input.substring(this._offset, max1);
        }
        if (chunk1 === 'O-O') {
          address0 = new TreeNode(this._input.substring(this._offset, this._offset + 3), this._offset, []);
          this._offset = this._offset + 3;
        } else {
          address0 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('"O-O"');
          }
        }
        if (address0 === FAILURE) {
          this._offset = index1;
          var chunk2 = null, max2 = this._offset + 4;
          if (max2 <= this._inputSize) {
            chunk2 = this._input.substring(this._offset, max2);
          }
          if (chunk2 === 'e1g1') {
            address0 = new TreeNode(this._input.substring(this._offset, this._offset + 4), this._offset, []);
            this._offset = this._offset + 4;
          } else {
            address0 = FAILURE;
            if (this._offset > this._failure) {
              this._failure = this._offset;
              this._expected = [];
            }
            if (this._offset === this._failure) {
              this._expected.push('"e1g1"');
            }
          }
          if (address0 === FAILURE) {
            this._offset = index1;
            var chunk3 = null, max3 = this._offset + 4;
            if (max3 <= this._inputSize) {
              chunk3 = this._input.substring(this._offset, max3);
            }
            if (chunk3 === 'e8g8') {
              address0 = new TreeNode(this._input.substring(this._offset, this._offset + 4), this._offset, []);
              this._offset = this._offset + 4;
            } else {
              address0 = FAILURE;
              if (this._offset > this._failure) {
                this._failure = this._offset;
                this._expected = [];
              }
              if (this._offset === this._failure) {
                this._expected.push('"e8g8"');
              }
            }
            if (address0 === FAILURE) {
              this._offset = index1;
              var chunk4 = null, max4 = this._offset + 4;
              if (max4 <= this._inputSize) {
                chunk4 = this._input.substring(this._offset, max4);
              }
              if (chunk4 === 'e1c1') {
                address0 = new TreeNode(this._input.substring(this._offset, this._offset + 4), this._offset, []);
                this._offset = this._offset + 4;
              } else {
                address0 = FAILURE;
                if (this._offset > this._failure) {
                  this._failure = this._offset;
                  this._expected = [];
                }
                if (this._offset === this._failure) {
                  this._expected.push('"e1c1"');
                }
              }
              if (address0 === FAILURE) {
                this._offset = index1;
                var chunk5 = null, max5 = this._offset + 4;
                if (max5 <= this._inputSize) {
                  chunk5 = this._input.substring(this._offset, max5);
                }
                if (chunk5 === 'e8c8') {
                  address0 = new TreeNode(this._input.substring(this._offset, this._offset + 4), this._offset, []);
                  this._offset = this._offset + 4;
                } else {
                  address0 = FAILURE;
                  if (this._offset > this._failure) {
                    this._failure = this._offset;
                    this._expected = [];
                  }
                  if (this._offset === this._failure) {
                    this._expected.push('"e8c8"');
                  }
                }
                if (address0 === FAILURE) {
                  this._offset = index1;
                }
              }
            }
          }
        }
      }
      this._cache._castle[index0] = [address0, this._offset];
      return address0;
    },

    _read_comment: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._comment = this._cache._comment || {};
      var cached = this._cache._comment[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(3);
      var address1 = FAILURE;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '{') {
        address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address1 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"{"');
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        var remaining0 = 0, index2 = this._offset, elements1 = [], address3 = true;
        while (address3 !== FAILURE) {
          var chunk1 = null, max1 = this._offset + 1;
          if (max1 <= this._inputSize) {
            chunk1 = this._input.substring(this._offset, max1);
          }
          if (chunk1 !== null && /^[^\}]/.test(chunk1)) {
            address3 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
            this._offset = this._offset + 1;
          } else {
            address3 = FAILURE;
            if (this._offset > this._failure) {
              this._failure = this._offset;
              this._expected = [];
            }
            if (this._offset === this._failure) {
              this._expected.push('[^\\}]');
            }
          }
          if (address3 !== FAILURE) {
            elements1.push(address3);
            --remaining0;
          }
        }
        if (remaining0 <= 0) {
          address2 = new TreeNode(this._input.substring(index2, this._offset), index2, elements1);
          this._offset = this._offset;
        } else {
          address2 = FAILURE;
        }
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address4 = FAILURE;
          var chunk2 = null, max2 = this._offset + 1;
          if (max2 <= this._inputSize) {
            chunk2 = this._input.substring(this._offset, max2);
          }
          if (chunk2 === '}') {
            address4 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
            this._offset = this._offset + 1;
          } else {
            address4 = FAILURE;
            if (this._offset > this._failure) {
              this._failure = this._offset;
              this._expected = [];
            }
            if (this._offset === this._failure) {
              this._expected.push('"}"');
            }
          }
          if (address4 !== FAILURE) {
            elements0[2] = address4;
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._comment[index0] = [address0, this._offset];
      return address0;
    },

    _read_blacks_move: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._blacks_move = this._cache._blacks_move || {};
      var cached = this._cache._blacks_move[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 2;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '..') {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 2), this._offset, []);
        this._offset = this._offset + 2;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('".."');
        }
      }
      this._cache._blacks_move[index0] = [address0, this._offset];
      return address0;
    },

    _read_cblacks_move: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._cblacks_move = this._cache._cblacks_move || {};
      var cached = this._cache._cblacks_move[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var chunk0 = null, max0 = this._offset + 3;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '...') {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 3), this._offset, []);
        this._offset = this._offset + 3;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"..."');
        }
      }
      this._cache._cblacks_move[index0] = [address0, this._offset];
      return address0;
    },

    _read_nags: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._nags = this._cache._nags || {};
      var cached = this._cache._nags[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 1, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        address1 = this._read_nag();
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = new TreeNode(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._nags[index0] = [address0, this._offset];
      return address0;
    },

    _read_nag: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._nag = this._cache._nag || {};
      var cached = this._cache._nag[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(3);
      var address1 = FAILURE;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '$') {
        address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address1 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"$"');
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        var remaining0 = 1, index2 = this._offset, elements1 = [], address3 = true;
        while (address3 !== FAILURE) {
          var chunk1 = null, max1 = this._offset + 1;
          if (max1 <= this._inputSize) {
            chunk1 = this._input.substring(this._offset, max1);
          }
          if (chunk1 !== null && /^[0-9]/.test(chunk1)) {
            address3 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
            this._offset = this._offset + 1;
          } else {
            address3 = FAILURE;
            if (this._offset > this._failure) {
              this._failure = this._offset;
              this._expected = [];
            }
            if (this._offset === this._failure) {
              this._expected.push('[0-9]');
            }
          }
          if (address3 !== FAILURE) {
            elements1.push(address3);
            --remaining0;
          }
        }
        if (remaining0 <= 0) {
          address2 = new TreeNode(this._input.substring(index2, this._offset), index2, elements1);
          this._offset = this._offset;
        } else {
          address2 = FAILURE;
        }
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address4 = FAILURE;
          address4 = this._read_dlm();
          if (address4 !== FAILURE) {
            elements0[2] = address4;
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = new TreeNode16(this._input.substring(index1, this._offset), index1, elements0);
        this._offset = this._offset;
      }
      this._cache._nag[index0] = [address0, this._offset];
      return address0;
    },

    _read_variations: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._variations = this._cache._variations || {};
      var cached = this._cache._variations[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var remaining0 = 1, index1 = this._offset, elements0 = [], address1 = true;
      while (address1 !== FAILURE) {
        address1 = this._read_variation();
        if (address1 !== FAILURE) {
          elements0.push(address1);
          --remaining0;
        }
      }
      if (remaining0 <= 0) {
        address0 = this._actions.make_variations(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      } else {
        address0 = FAILURE;
      }
      this._cache._variations[index0] = [address0, this._offset];
      return address0;
    },

    _read_variation: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._variation = this._cache._variation || {};
      var cached = this._cache._variation[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset, elements0 = new Array(5);
      var address1 = FAILURE;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '(') {
        address1 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address1 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"("');
        }
      }
      if (address1 !== FAILURE) {
        elements0[0] = address1;
        var address2 = FAILURE;
        address2 = this._read_dlm();
        if (address2 !== FAILURE) {
          elements0[1] = address2;
          var address3 = FAILURE;
          address3 = this._read_movetext();
          if (address3 !== FAILURE) {
            elements0[2] = address3;
            var address4 = FAILURE;
            var chunk1 = null, max1 = this._offset + 1;
            if (max1 <= this._inputSize) {
              chunk1 = this._input.substring(this._offset, max1);
            }
            if (chunk1 === ')') {
              address4 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
              this._offset = this._offset + 1;
            } else {
              address4 = FAILURE;
              if (this._offset > this._failure) {
                this._failure = this._offset;
                this._expected = [];
              }
              if (this._offset === this._failure) {
                this._expected.push('")"');
              }
            }
            if (address4 !== FAILURE) {
              elements0[3] = address4;
              var address5 = FAILURE;
              address5 = this._read_dlm();
              if (address5 !== FAILURE) {
                elements0[4] = address5;
              } else {
                elements0 = null;
                this._offset = index1;
              }
            } else {
              elements0 = null;
              this._offset = index1;
            }
          } else {
            elements0 = null;
            this._offset = index1;
          }
        } else {
          elements0 = null;
          this._offset = index1;
        }
      } else {
        elements0 = null;
        this._offset = index1;
      }
      if (elements0 === null) {
        address0 = FAILURE;
      } else {
        address0 = this._actions.make_variation(this._input, index1, this._offset, elements0);
        this._offset = this._offset;
      }
      this._cache._variation[index0] = [address0, this._offset];
      return address0;
    },

    _read_score: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._score = this._cache._score || {};
      var cached = this._cache._score[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      var chunk0 = null, max0 = this._offset + 3;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 === '1-0') {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 3), this._offset, []);
        this._offset = this._offset + 3;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('"1-0"');
        }
      }
      if (address0 === FAILURE) {
        this._offset = index1;
        var chunk1 = null, max1 = this._offset + 3;
        if (max1 <= this._inputSize) {
          chunk1 = this._input.substring(this._offset, max1);
        }
        if (chunk1 === '0-1') {
          address0 = new TreeNode(this._input.substring(this._offset, this._offset + 3), this._offset, []);
          this._offset = this._offset + 3;
        } else {
          address0 = FAILURE;
          if (this._offset > this._failure) {
            this._failure = this._offset;
            this._expected = [];
          }
          if (this._offset === this._failure) {
            this._expected.push('"0-1"');
          }
        }
        if (address0 === FAILURE) {
          this._offset = index1;
          var chunk2 = null, max2 = this._offset + 7;
          if (max2 <= this._inputSize) {
            chunk2 = this._input.substring(this._offset, max2);
          }
          if (chunk2 === '1/2-1/2') {
            address0 = new TreeNode(this._input.substring(this._offset, this._offset + 7), this._offset, []);
            this._offset = this._offset + 7;
          } else {
            address0 = FAILURE;
            if (this._offset > this._failure) {
              this._failure = this._offset;
              this._expected = [];
            }
            if (this._offset === this._failure) {
              this._expected.push('"1/2-1/2"');
            }
          }
          if (address0 === FAILURE) {
            this._offset = index1;
            var chunk3 = null, max3 = this._offset + 1;
            if (max3 <= this._inputSize) {
              chunk3 = this._input.substring(this._offset, max3);
            }
            if (chunk3 === '*') {
              address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
              this._offset = this._offset + 1;
            } else {
              address0 = FAILURE;
              if (this._offset > this._failure) {
                this._failure = this._offset;
                this._expected = [];
              }
              if (this._offset === this._failure) {
                this._expected.push('"*"');
              }
            }
            if (address0 === FAILURE) {
              this._offset = index1;
            }
          }
        }
      }
      this._cache._score[index0] = [address0, this._offset];
      return address0;
    },

    _read_dlm: function() {
      var address0 = FAILURE, index0 = this._offset;
      this._cache._dlm = this._cache._dlm || {};
      var cached = this._cache._dlm[index0];
      if (cached) {
        this._offset = cached[1];
        return cached[0];
      }
      var index1 = this._offset;
      var chunk0 = null, max0 = this._offset + 1;
      if (max0 <= this._inputSize) {
        chunk0 = this._input.substring(this._offset, max0);
      }
      if (chunk0 !== null && /^[\s+]/.test(chunk0)) {
        address0 = new TreeNode(this._input.substring(this._offset, this._offset + 1), this._offset, []);
        this._offset = this._offset + 1;
      } else {
        address0 = FAILURE;
        if (this._offset > this._failure) {
          this._failure = this._offset;
          this._expected = [];
        }
        if (this._offset === this._failure) {
          this._expected.push('[\\s+]');
        }
      }
      if (address0 === FAILURE) {
        address0 = new TreeNode(this._input.substring(index1, index1), index1, []);
        this._offset = index1;
      }
      this._cache._dlm[index0] = [address0, this._offset];
      return address0;
    }
  };

  var Parser = function(input, actions, types) {
    this._input = input;
    this._inputSize = input.length;
    this._actions = actions;
    this._types = types;
    this._offset = 0;
    this._cache = {};
    this._failure = 0;
    this._expected = [];
  };

  Parser.prototype.parse = function() {
    var tree = this._read_game();
    if (tree !== FAILURE && this._offset === this._inputSize) {
      return tree;
    }
    if (this._expected.length === 0) {
      this._failure = this._offset;
      this._expected.push('<EOF>');
    }
    this.constructor.lastError = {offset: this._offset, expected: this._expected};
    throw new SyntaxError(formatError(this._input, this._failure, this._expected));
  };

  var parse = function(input, options) {
    options = options || {};
    var parser = new Parser(input, options.actions, options.types);
    return parser.parse();
  };
  extend(Parser.prototype, Grammar);

  var exported = {Grammar: Grammar, Parser: Parser, parse: parse};

  if (typeof require === 'function' && typeof exports === 'object') {
    extend(exports, exported);
  } else {
    var namespace = typeof this !== 'undefined' ? this : window;
    namespace.PGN = exported;
  }
})();
