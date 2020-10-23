/**
 * This file was generated from parser.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

abstract class Grammar {
    static TreeNode FAILURE = new TreeNode();

    int inputSize, offset, failure;
    String input;
    List<String> expected;
    Map<Label, Map<Integer, CacheRecord>> cache;
    Actions actions;

    private static Pattern REGEX_1 = Pattern.compile("\\A[\\n]");
    private static Pattern REGEX_2 = Pattern.compile("\\A[\\s]");
    private static Pattern REGEX_3 = Pattern.compile("\\A[A-Za-z0-9_]");
    private static Pattern REGEX_4 = Pattern.compile("\\A[^\\\"]");
    private static Pattern REGEX_5 = Pattern.compile("\\A[0-9]");
    private static Pattern REGEX_6 = Pattern.compile("\\A[KQRNBP]");
    private static Pattern REGEX_7 = Pattern.compile("\\A[a-h]");
    private static Pattern REGEX_8 = Pattern.compile("\\A[1-8]");
    private static Pattern REGEX_9 = Pattern.compile("\\A[KQRNB]");
    private static Pattern REGEX_10 = Pattern.compile("\\A[+#]");
    private static Pattern REGEX_11 = Pattern.compile("\\A[^\\}]");
    private static Pattern REGEX_12 = Pattern.compile("\\A[0-9]");
    private static Pattern REGEX_13 = Pattern.compile("\\A[\\s+]");

    TreeNode _read_game() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.game);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.game, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(6);
            TreeNode address1 = FAILURE;
            address1 = _read_tag_pairs();
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                int index2 = offset;
                String chunk0 = null;
                int max0 = offset + 1;
                if (max0 <= inputSize) {
                    chunk0 = input.substring(offset, max0);
                }
                if (chunk0 != null && REGEX_1.matcher(chunk0).matches()) {
                    address2 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address2 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("[\\n]");
                    }
                }
                if (address2 == FAILURE) {
                    address2 = new TreeNode(input.substring(index2, index2), index2, new ArrayList<TreeNode>());
                    offset = index2;
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address3 = FAILURE;
                    int index3 = offset;
                    address3 = _read_comment();
                    if (address3 == FAILURE) {
                        address3 = new TreeNode(input.substring(index3, index3), index3, new ArrayList<TreeNode>());
                        offset = index3;
                    }
                    if (address3 != FAILURE) {
                        elements0.add(2, address3);
                        TreeNode address4 = FAILURE;
                        address4 = _read_movetext();
                        if (address4 != FAILURE) {
                            elements0.add(3, address4);
                            TreeNode address5 = FAILURE;
                            int index4 = offset;
                            address5 = _read_score();
                            if (address5 == FAILURE) {
                                address5 = new TreeNode(input.substring(index4, index4), index4, new ArrayList<TreeNode>());
                                offset = index4;
                            }
                            if (address5 != FAILURE) {
                                elements0.add(4, address5);
                                TreeNode address6 = FAILURE;
                                int remaining0 = 0;
                                int index5 = offset;
                                List<TreeNode> elements1 = new ArrayList<TreeNode>();
                                TreeNode address7 = new TreeNode("", -1, new ArrayList<TreeNode>());
                                while (address7 != FAILURE) {
                                    String chunk1 = null;
                                    int max1 = offset + 1;
                                    if (max1 <= inputSize) {
                                        chunk1 = input.substring(offset, max1);
                                    }
                                    if (chunk1 != null && REGEX_2.matcher(chunk1).matches()) {
                                        address7 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                                        offset = offset + 1;
                                    } else {
                                        address7 = FAILURE;
                                        if (offset > failure) {
                                            failure = offset;
                                            expected = new ArrayList<String>();
                                        }
                                        if (offset == failure) {
                                            expected.add("[\\s]");
                                        }
                                    }
                                    if (address7 != FAILURE) {
                                        elements1.add(address7);
                                        --remaining0;
                                    }
                                }
                                if (remaining0 <= 0) {
                                    address6 = new TreeNode(input.substring(index5, offset), index5, elements1);
                                    offset = offset;
                                } else {
                                    address6 = FAILURE;
                                }
                                if (address6 != FAILURE) {
                                    elements0.add(5, address6);
                                } else {
                                    elements0 = null;
                                    offset = index1;
                                }
                            } else {
                                elements0 = null;
                                offset = index1;
                            }
                        } else {
                            elements0 = null;
                            offset = index1;
                        }
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = actions.make_game(input, index1, offset, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_tag_pairs() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.tag_pairs);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.tag_pairs, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 0;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                address1 = _read_tag_pair();
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = actions.make_tag_pairs(input, index1, offset, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_tag_pair() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.tag_pair);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.tag_pair, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(10);
            TreeNode address1 = FAILURE;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("[")) {
                address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address1 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"[\"");
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                address2 = _read_dlm();
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address3 = FAILURE;
                    address3 = _read_key();
                    if (address3 != FAILURE) {
                        elements0.add(2, address3);
                        TreeNode address4 = FAILURE;
                        address4 = _read_dlm();
                        if (address4 != FAILURE) {
                            elements0.add(3, address4);
                            TreeNode address5 = FAILURE;
                            String chunk1 = null;
                            int max1 = offset + 1;
                            if (max1 <= inputSize) {
                                chunk1 = input.substring(offset, max1);
                            }
                            if (chunk1 != null && chunk1.equals("\"")) {
                                address5 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                                offset = offset + 1;
                            } else {
                                address5 = FAILURE;
                                if (offset > failure) {
                                    failure = offset;
                                    expected = new ArrayList<String>();
                                }
                                if (offset == failure) {
                                    expected.add("\"\\\"\"");
                                }
                            }
                            if (address5 != FAILURE) {
                                elements0.add(4, address5);
                                TreeNode address6 = FAILURE;
                                address6 = _read_value();
                                if (address6 != FAILURE) {
                                    elements0.add(5, address6);
                                    TreeNode address7 = FAILURE;
                                    String chunk2 = null;
                                    int max2 = offset + 1;
                                    if (max2 <= inputSize) {
                                        chunk2 = input.substring(offset, max2);
                                    }
                                    if (chunk2 != null && chunk2.equals("\"")) {
                                        address7 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                                        offset = offset + 1;
                                    } else {
                                        address7 = FAILURE;
                                        if (offset > failure) {
                                            failure = offset;
                                            expected = new ArrayList<String>();
                                        }
                                        if (offset == failure) {
                                            expected.add("\"\\\"\"");
                                        }
                                    }
                                    if (address7 != FAILURE) {
                                        elements0.add(6, address7);
                                        TreeNode address8 = FAILURE;
                                        address8 = _read_dlm();
                                        if (address8 != FAILURE) {
                                            elements0.add(7, address8);
                                            TreeNode address9 = FAILURE;
                                            String chunk3 = null;
                                            int max3 = offset + 1;
                                            if (max3 <= inputSize) {
                                                chunk3 = input.substring(offset, max3);
                                            }
                                            if (chunk3 != null && chunk3.equals("]")) {
                                                address9 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                                                offset = offset + 1;
                                            } else {
                                                address9 = FAILURE;
                                                if (offset > failure) {
                                                    failure = offset;
                                                    expected = new ArrayList<String>();
                                                }
                                                if (offset == failure) {
                                                    expected.add("\"]\"");
                                                }
                                            }
                                            if (address9 != FAILURE) {
                                                elements0.add(8, address9);
                                                TreeNode address10 = FAILURE;
                                                address10 = _read_dlm();
                                                if (address10 != FAILURE) {
                                                    elements0.add(9, address10);
                                                } else {
                                                    elements0 = null;
                                                    offset = index1;
                                                }
                                            } else {
                                                elements0 = null;
                                                offset = index1;
                                            }
                                        } else {
                                            elements0 = null;
                                            offset = index1;
                                        }
                                    } else {
                                        elements0 = null;
                                        offset = index1;
                                    }
                                } else {
                                    elements0 = null;
                                    offset = index1;
                                }
                            } else {
                                elements0 = null;
                                offset = index1;
                            }
                        } else {
                            elements0 = null;
                            offset = index1;
                        }
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = actions.make_tag_pair(input, index1, offset, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_key() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.key);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.key, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 1;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                String chunk0 = null;
                int max0 = offset + 1;
                if (max0 <= inputSize) {
                    chunk0 = input.substring(offset, max0);
                }
                if (chunk0 != null && REGEX_3.matcher(chunk0).matches()) {
                    address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address1 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("[A-Za-z0-9_]");
                    }
                }
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_value() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.value);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.value, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 0;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                String chunk0 = null;
                int max0 = offset + 1;
                if (max0 <= inputSize) {
                    chunk0 = input.substring(offset, max0);
                }
                if (chunk0 != null && REGEX_4.matcher(chunk0).matches()) {
                    address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address1 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("[^\\\"]");
                    }
                }
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_movetext() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.movetext);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.movetext, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 0;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                address1 = _read_move();
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = actions.make_movetext(input, index1, offset, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_move() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.move);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.move, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(21);
            TreeNode address1 = FAILURE;
            address1 = _read_move_number();
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                address2 = _read_dlm();
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address3 = FAILURE;
                    address3 = _read_dlm();
                    if (address3 != FAILURE) {
                        elements0.add(2, address3);
                        TreeNode address4 = FAILURE;
                        address4 = _read_san();
                        if (address4 != FAILURE) {
                            elements0.add(3, address4);
                            TreeNode address5 = FAILURE;
                            address5 = _read_dlm();
                            if (address5 != FAILURE) {
                                elements0.add(4, address5);
                                TreeNode address6 = FAILURE;
                                address6 = _read_dlm();
                                if (address6 != FAILURE) {
                                    elements0.add(5, address6);
                                    TreeNode address7 = FAILURE;
                                    int index2 = offset;
                                    address7 = _read_nags();
                                    if (address7 == FAILURE) {
                                        address7 = new TreeNode(input.substring(index2, index2), index2, new ArrayList<TreeNode>());
                                        offset = index2;
                                    }
                                    if (address7 != FAILURE) {
                                        elements0.add(6, address7);
                                        TreeNode address8 = FAILURE;
                                        address8 = _read_dlm();
                                        if (address8 != FAILURE) {
                                            elements0.add(7, address8);
                                            TreeNode address9 = FAILURE;
                                            int index3 = offset;
                                            address9 = _read_comment();
                                            if (address9 == FAILURE) {
                                                address9 = new TreeNode(input.substring(index3, index3), index3, new ArrayList<TreeNode>());
                                                offset = index3;
                                            }
                                            if (address9 != FAILURE) {
                                                elements0.add(8, address9);
                                                TreeNode address10 = FAILURE;
                                                address10 = _read_dlm();
                                                if (address10 != FAILURE) {
                                                    elements0.add(9, address10);
                                                    TreeNode address11 = FAILURE;
                                                    int index4 = offset;
                                                    address11 = _read_variations();
                                                    if (address11 == FAILURE) {
                                                        address11 = new TreeNode(input.substring(index4, index4), index4, new ArrayList<TreeNode>());
                                                        offset = index4;
                                                    }
                                                    if (address11 != FAILURE) {
                                                        elements0.add(10, address11);
                                                        TreeNode address12 = FAILURE;
                                                        address12 = _read_dlm();
                                                        if (address12 != FAILURE) {
                                                            elements0.add(11, address12);
                                                            TreeNode address13 = FAILURE;
                                                            int index5 = offset;
                                                            address13 = _read_san();
                                                            if (address13 == FAILURE) {
                                                                address13 = new TreeNode(input.substring(index5, index5), index5, new ArrayList<TreeNode>());
                                                                offset = index5;
                                                            }
                                                            if (address13 != FAILURE) {
                                                                elements0.add(12, address13);
                                                                TreeNode address14 = FAILURE;
                                                                address14 = _read_dlm();
                                                                if (address14 != FAILURE) {
                                                                    elements0.add(13, address14);
                                                                    TreeNode address15 = FAILURE;
                                                                    int index6 = offset;
                                                                    address15 = _read_nags();
                                                                    if (address15 == FAILURE) {
                                                                        address15 = new TreeNode(input.substring(index6, index6), index6, new ArrayList<TreeNode>());
                                                                        offset = index6;
                                                                    }
                                                                    if (address15 != FAILURE) {
                                                                        elements0.add(14, address15);
                                                                        TreeNode address16 = FAILURE;
                                                                        address16 = _read_dlm();
                                                                        if (address16 != FAILURE) {
                                                                            elements0.add(15, address16);
                                                                            TreeNode address17 = FAILURE;
                                                                            int index7 = offset;
                                                                            address17 = _read_comment();
                                                                            if (address17 == FAILURE) {
                                                                                address17 = new TreeNode(input.substring(index7, index7), index7, new ArrayList<TreeNode>());
                                                                                offset = index7;
                                                                            }
                                                                            if (address17 != FAILURE) {
                                                                                elements0.add(16, address17);
                                                                                TreeNode address18 = FAILURE;
                                                                                address18 = _read_dlm();
                                                                                if (address18 != FAILURE) {
                                                                                    elements0.add(17, address18);
                                                                                    TreeNode address19 = FAILURE;
                                                                                    int index8 = offset;
                                                                                    address19 = _read_variations();
                                                                                    if (address19 == FAILURE) {
                                                                                        address19 = new TreeNode(input.substring(index8, index8), index8, new ArrayList<TreeNode>());
                                                                                        offset = index8;
                                                                                    }
                                                                                    if (address19 != FAILURE) {
                                                                                        elements0.add(18, address19);
                                                                                        TreeNode address20 = FAILURE;
                                                                                        address20 = _read_dlm();
                                                                                        if (address20 != FAILURE) {
                                                                                            elements0.add(19, address20);
                                                                                            TreeNode address21 = FAILURE;
                                                                                            int index9 = offset;
                                                                                            address21 = _read_comment();
                                                                                            if (address21 == FAILURE) {
                                                                                                address21 = new TreeNode(input.substring(index9, index9), index9, new ArrayList<TreeNode>());
                                                                                                offset = index9;
                                                                                            }
                                                                                            if (address21 != FAILURE) {
                                                                                                elements0.add(20, address21);
                                                                                            } else {
                                                                                                elements0 = null;
                                                                                                offset = index1;
                                                                                            }
                                                                                        } else {
                                                                                            elements0 = null;
                                                                                            offset = index1;
                                                                                        }
                                                                                    } else {
                                                                                        elements0 = null;
                                                                                        offset = index1;
                                                                                    }
                                                                                } else {
                                                                                    elements0 = null;
                                                                                    offset = index1;
                                                                                }
                                                                            } else {
                                                                                elements0 = null;
                                                                                offset = index1;
                                                                            }
                                                                        } else {
                                                                            elements0 = null;
                                                                            offset = index1;
                                                                        }
                                                                    } else {
                                                                        elements0 = null;
                                                                        offset = index1;
                                                                    }
                                                                } else {
                                                                    elements0 = null;
                                                                    offset = index1;
                                                                }
                                                            } else {
                                                                elements0 = null;
                                                                offset = index1;
                                                            }
                                                        } else {
                                                            elements0 = null;
                                                            offset = index1;
                                                        }
                                                    } else {
                                                        elements0 = null;
                                                        offset = index1;
                                                    }
                                                } else {
                                                    elements0 = null;
                                                    offset = index1;
                                                }
                                            } else {
                                                elements0 = null;
                                                offset = index1;
                                            }
                                        } else {
                                            elements0 = null;
                                            offset = index1;
                                        }
                                    } else {
                                        elements0 = null;
                                        offset = index1;
                                    }
                                } else {
                                    elements0 = null;
                                    offset = index1;
                                }
                            } else {
                                elements0 = null;
                                offset = index1;
                            }
                        } else {
                            elements0 = null;
                            offset = index1;
                        }
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode3(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_move_number() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.move_number);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.move_number, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(2);
            TreeNode address1 = FAILURE;
            int remaining0 = 1;
            int index2 = offset;
            List<TreeNode> elements1 = new ArrayList<TreeNode>();
            TreeNode address2 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address2 != FAILURE) {
                String chunk0 = null;
                int max0 = offset + 1;
                if (max0 <= inputSize) {
                    chunk0 = input.substring(offset, max0);
                }
                if (chunk0 != null && REGEX_5.matcher(chunk0).matches()) {
                    address2 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address2 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("[0-9]");
                    }
                }
                if (address2 != FAILURE) {
                    elements1.add(address2);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address1 = new TreeNode(input.substring(index2, offset), index2, elements1);
                offset = offset;
            } else {
                address1 = FAILURE;
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address3 = FAILURE;
                String chunk1 = null;
                int max1 = offset + 1;
                if (max1 <= inputSize) {
                    chunk1 = input.substring(offset, max1);
                }
                if (chunk1 != null && chunk1.equals(".")) {
                    address3 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address3 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("\".\"");
                    }
                }
                if (address3 != FAILURE) {
                    elements0.add(1, address3);
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_san() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.san);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.san, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(3);
            TreeNode address1 = FAILURE;
            int index2 = offset;
            int index3 = offset;
            List<TreeNode> elements1 = new ArrayList<TreeNode>(5);
            TreeNode address2 = FAILURE;
            address2 = _read_file();
            if (address2 != FAILURE) {
                elements1.add(0, address2);
                TreeNode address3 = FAILURE;
                address3 = _read_rank();
                if (address3 != FAILURE) {
                    elements1.add(1, address3);
                    TreeNode address4 = FAILURE;
                    address4 = _read_dlm();
                    if (address4 != FAILURE) {
                        elements1.add(2, address4);
                        TreeNode address5 = FAILURE;
                        address5 = _read_file();
                        if (address5 != FAILURE) {
                            elements1.add(3, address5);
                            TreeNode address6 = FAILURE;
                            address6 = _read_rank();
                            if (address6 != FAILURE) {
                                elements1.add(4, address6);
                            } else {
                                elements1 = null;
                                offset = index3;
                            }
                        } else {
                            elements1 = null;
                            offset = index3;
                        }
                    } else {
                        elements1 = null;
                        offset = index3;
                    }
                } else {
                    elements1 = null;
                    offset = index3;
                }
            } else {
                elements1 = null;
                offset = index3;
            }
            if (elements1 == null) {
                address1 = FAILURE;
            } else {
                address1 = new TreeNode4(input.substring(index3, offset), index3, elements1);
                offset = offset;
            }
            if (address1 == FAILURE) {
                offset = index2;
                int index4 = offset;
                List<TreeNode> elements2 = new ArrayList<TreeNode>(9);
                TreeNode address7 = FAILURE;
                address7 = _read_file();
                if (address7 != FAILURE) {
                    elements2.add(0, address7);
                    TreeNode address8 = FAILURE;
                    address8 = _read_rank();
                    if (address8 != FAILURE) {
                        elements2.add(1, address8);
                        TreeNode address9 = FAILURE;
                        address9 = _read_file();
                        if (address9 != FAILURE) {
                            elements2.add(2, address9);
                            TreeNode address10 = FAILURE;
                            address10 = _read_rank();
                            if (address10 != FAILURE) {
                                elements2.add(3, address10);
                                TreeNode address11 = FAILURE;
                                address11 = _read_dlm();
                                if (address11 != FAILURE) {
                                    elements2.add(4, address11);
                                    TreeNode address12 = FAILURE;
                                    address12 = _read_file();
                                    if (address12 != FAILURE) {
                                        elements2.add(5, address12);
                                        TreeNode address13 = FAILURE;
                                        address13 = _read_rank();
                                        if (address13 != FAILURE) {
                                            elements2.add(6, address13);
                                            TreeNode address14 = FAILURE;
                                            address14 = _read_file();
                                            if (address14 != FAILURE) {
                                                elements2.add(7, address14);
                                                TreeNode address15 = FAILURE;
                                                address15 = _read_rank();
                                                if (address15 != FAILURE) {
                                                    elements2.add(8, address15);
                                                } else {
                                                    elements2 = null;
                                                    offset = index4;
                                                }
                                            } else {
                                                elements2 = null;
                                                offset = index4;
                                            }
                                        } else {
                                            elements2 = null;
                                            offset = index4;
                                        }
                                    } else {
                                        elements2 = null;
                                        offset = index4;
                                    }
                                } else {
                                    elements2 = null;
                                    offset = index4;
                                }
                            } else {
                                elements2 = null;
                                offset = index4;
                            }
                        } else {
                            elements2 = null;
                            offset = index4;
                        }
                    } else {
                        elements2 = null;
                        offset = index4;
                    }
                } else {
                    elements2 = null;
                    offset = index4;
                }
                if (elements2 == null) {
                    address1 = FAILURE;
                } else {
                    address1 = new TreeNode5(input.substring(index4, offset), index4, elements2);
                    offset = offset;
                }
                if (address1 == FAILURE) {
                    offset = index2;
                    int index5 = offset;
                    List<TreeNode> elements3 = new ArrayList<TreeNode>(7);
                    TreeNode address16 = FAILURE;
                    address16 = _read_file();
                    if (address16 != FAILURE) {
                        elements3.add(0, address16);
                        TreeNode address17 = FAILURE;
                        address17 = _read_rank();
                        if (address17 != FAILURE) {
                            elements3.add(1, address17);
                            TreeNode address18 = FAILURE;
                            address18 = _read_dlm();
                            if (address18 != FAILURE) {
                                elements3.add(2, address18);
                                TreeNode address19 = FAILURE;
                                address19 = _read_file();
                                if (address19 != FAILURE) {
                                    elements3.add(3, address19);
                                    TreeNode address20 = FAILURE;
                                    address20 = _read_rank();
                                    if (address20 != FAILURE) {
                                        elements3.add(4, address20);
                                        TreeNode address21 = FAILURE;
                                        address21 = _read_file();
                                        if (address21 != FAILURE) {
                                            elements3.add(5, address21);
                                            TreeNode address22 = FAILURE;
                                            address22 = _read_rank();
                                            if (address22 != FAILURE) {
                                                elements3.add(6, address22);
                                            } else {
                                                elements3 = null;
                                                offset = index5;
                                            }
                                        } else {
                                            elements3 = null;
                                            offset = index5;
                                        }
                                    } else {
                                        elements3 = null;
                                        offset = index5;
                                    }
                                } else {
                                    elements3 = null;
                                    offset = index5;
                                }
                            } else {
                                elements3 = null;
                                offset = index5;
                            }
                        } else {
                            elements3 = null;
                            offset = index5;
                        }
                    } else {
                        elements3 = null;
                        offset = index5;
                    }
                    if (elements3 == null) {
                        address1 = FAILURE;
                    } else {
                        address1 = new TreeNode6(input.substring(index5, offset), index5, elements3);
                        offset = offset;
                    }
                    if (address1 == FAILURE) {
                        offset = index2;
                        int index6 = offset;
                        List<TreeNode> elements4 = new ArrayList<TreeNode>(11);
                        TreeNode address23 = FAILURE;
                        address23 = _read_piece();
                        if (address23 != FAILURE) {
                            elements4.add(0, address23);
                            TreeNode address24 = FAILURE;
                            address24 = _read_file();
                            if (address24 != FAILURE) {
                                elements4.add(1, address24);
                                TreeNode address25 = FAILURE;
                                address25 = _read_rank();
                                if (address25 != FAILURE) {
                                    elements4.add(2, address25);
                                    TreeNode address26 = FAILURE;
                                    address26 = _read_file();
                                    if (address26 != FAILURE) {
                                        elements4.add(3, address26);
                                        TreeNode address27 = FAILURE;
                                        address27 = _read_rank();
                                        if (address27 != FAILURE) {
                                            elements4.add(4, address27);
                                            TreeNode address28 = FAILURE;
                                            address28 = _read_dlm();
                                            if (address28 != FAILURE) {
                                                elements4.add(5, address28);
                                                TreeNode address29 = FAILURE;
                                                address29 = _read_piece();
                                                if (address29 != FAILURE) {
                                                    elements4.add(6, address29);
                                                    TreeNode address30 = FAILURE;
                                                    address30 = _read_file();
                                                    if (address30 != FAILURE) {
                                                        elements4.add(7, address30);
                                                        TreeNode address31 = FAILURE;
                                                        address31 = _read_rank();
                                                        if (address31 != FAILURE) {
                                                            elements4.add(8, address31);
                                                            TreeNode address32 = FAILURE;
                                                            address32 = _read_file();
                                                            if (address32 != FAILURE) {
                                                                elements4.add(9, address32);
                                                                TreeNode address33 = FAILURE;
                                                                address33 = _read_rank();
                                                                if (address33 != FAILURE) {
                                                                    elements4.add(10, address33);
                                                                } else {
                                                                    elements4 = null;
                                                                    offset = index6;
                                                                }
                                                            } else {
                                                                elements4 = null;
                                                                offset = index6;
                                                            }
                                                        } else {
                                                            elements4 = null;
                                                            offset = index6;
                                                        }
                                                    } else {
                                                        elements4 = null;
                                                        offset = index6;
                                                    }
                                                } else {
                                                    elements4 = null;
                                                    offset = index6;
                                                }
                                            } else {
                                                elements4 = null;
                                                offset = index6;
                                            }
                                        } else {
                                            elements4 = null;
                                            offset = index6;
                                        }
                                    } else {
                                        elements4 = null;
                                        offset = index6;
                                    }
                                } else {
                                    elements4 = null;
                                    offset = index6;
                                }
                            } else {
                                elements4 = null;
                                offset = index6;
                            }
                        } else {
                            elements4 = null;
                            offset = index6;
                        }
                        if (elements4 == null) {
                            address1 = FAILURE;
                        } else {
                            address1 = new TreeNode7(input.substring(index6, offset), index6, elements4);
                            offset = offset;
                        }
                        if (address1 == FAILURE) {
                            offset = index2;
                            int index7 = offset;
                            List<TreeNode> elements5 = new ArrayList<TreeNode>(10);
                            TreeNode address34 = FAILURE;
                            address34 = _read_piece();
                            if (address34 != FAILURE) {
                                elements5.add(0, address34);
                                TreeNode address35 = FAILURE;
                                address35 = _read_file();
                                if (address35 != FAILURE) {
                                    elements5.add(1, address35);
                                    TreeNode address36 = FAILURE;
                                    address36 = _read_rank();
                                    if (address36 != FAILURE) {
                                        elements5.add(2, address36);
                                        TreeNode address37 = FAILURE;
                                        address37 = _read_file();
                                        if (address37 != FAILURE) {
                                            elements5.add(3, address37);
                                            TreeNode address38 = FAILURE;
                                            address38 = _read_rank();
                                            if (address38 != FAILURE) {
                                                elements5.add(4, address38);
                                                TreeNode address39 = FAILURE;
                                                address39 = _read_dlm();
                                                if (address39 != FAILURE) {
                                                    elements5.add(5, address39);
                                                    TreeNode address40 = FAILURE;
                                                    address40 = _read_file();
                                                    if (address40 != FAILURE) {
                                                        elements5.add(6, address40);
                                                        TreeNode address41 = FAILURE;
                                                        address41 = _read_rank();
                                                        if (address41 != FAILURE) {
                                                            elements5.add(7, address41);
                                                            TreeNode address42 = FAILURE;
                                                            address42 = _read_file();
                                                            if (address42 != FAILURE) {
                                                                elements5.add(8, address42);
                                                                TreeNode address43 = FAILURE;
                                                                address43 = _read_rank();
                                                                if (address43 != FAILURE) {
                                                                    elements5.add(9, address43);
                                                                } else {
                                                                    elements5 = null;
                                                                    offset = index7;
                                                                }
                                                            } else {
                                                                elements5 = null;
                                                                offset = index7;
                                                            }
                                                        } else {
                                                            elements5 = null;
                                                            offset = index7;
                                                        }
                                                    } else {
                                                        elements5 = null;
                                                        offset = index7;
                                                    }
                                                } else {
                                                    elements5 = null;
                                                    offset = index7;
                                                }
                                            } else {
                                                elements5 = null;
                                                offset = index7;
                                            }
                                        } else {
                                            elements5 = null;
                                            offset = index7;
                                        }
                                    } else {
                                        elements5 = null;
                                        offset = index7;
                                    }
                                } else {
                                    elements5 = null;
                                    offset = index7;
                                }
                            } else {
                                elements5 = null;
                                offset = index7;
                            }
                            if (elements5 == null) {
                                address1 = FAILURE;
                            } else {
                                address1 = new TreeNode8(input.substring(index7, offset), index7, elements5);
                                offset = offset;
                            }
                            if (address1 == FAILURE) {
                                offset = index2;
                                int index8 = offset;
                                List<TreeNode> elements6 = new ArrayList<TreeNode>(10);
                                TreeNode address44 = FAILURE;
                                address44 = _read_file();
                                if (address44 != FAILURE) {
                                    elements6.add(0, address44);
                                    TreeNode address45 = FAILURE;
                                    address45 = _read_rank();
                                    if (address45 != FAILURE) {
                                        elements6.add(1, address45);
                                        TreeNode address46 = FAILURE;
                                        address46 = _read_file();
                                        if (address46 != FAILURE) {
                                            elements6.add(2, address46);
                                            TreeNode address47 = FAILURE;
                                            address47 = _read_rank();
                                            if (address47 != FAILURE) {
                                                elements6.add(3, address47);
                                                TreeNode address48 = FAILURE;
                                                address48 = _read_dlm();
                                                if (address48 != FAILURE) {
                                                    elements6.add(4, address48);
                                                    TreeNode address49 = FAILURE;
                                                    address49 = _read_piece();
                                                    if (address49 != FAILURE) {
                                                        elements6.add(5, address49);
                                                        TreeNode address50 = FAILURE;
                                                        address50 = _read_file();
                                                        if (address50 != FAILURE) {
                                                            elements6.add(6, address50);
                                                            TreeNode address51 = FAILURE;
                                                            address51 = _read_rank();
                                                            if (address51 != FAILURE) {
                                                                elements6.add(7, address51);
                                                                TreeNode address52 = FAILURE;
                                                                address52 = _read_file();
                                                                if (address52 != FAILURE) {
                                                                    elements6.add(8, address52);
                                                                    TreeNode address53 = FAILURE;
                                                                    address53 = _read_rank();
                                                                    if (address53 != FAILURE) {
                                                                        elements6.add(9, address53);
                                                                    } else {
                                                                        elements6 = null;
                                                                        offset = index8;
                                                                    }
                                                                } else {
                                                                    elements6 = null;
                                                                    offset = index8;
                                                                }
                                                            } else {
                                                                elements6 = null;
                                                                offset = index8;
                                                            }
                                                        } else {
                                                            elements6 = null;
                                                            offset = index8;
                                                        }
                                                    } else {
                                                        elements6 = null;
                                                        offset = index8;
                                                    }
                                                } else {
                                                    elements6 = null;
                                                    offset = index8;
                                                }
                                            } else {
                                                elements6 = null;
                                                offset = index8;
                                            }
                                        } else {
                                            elements6 = null;
                                            offset = index8;
                                        }
                                    } else {
                                        elements6 = null;
                                        offset = index8;
                                    }
                                } else {
                                    elements6 = null;
                                    offset = index8;
                                }
                                if (elements6 == null) {
                                    address1 = FAILURE;
                                } else {
                                    address1 = new TreeNode9(input.substring(index8, offset), index8, elements6);
                                    offset = offset;
                                }
                                if (address1 == FAILURE) {
                                    offset = index2;
                                    address1 = _read_square();
                                    if (address1 == FAILURE) {
                                        offset = index2;
                                        address1 = _read_san_psq();
                                        if (address1 == FAILURE) {
                                            offset = index2;
                                            int index9 = offset;
                                            List<TreeNode> elements7 = new ArrayList<TreeNode>(3);
                                            TreeNode address54 = FAILURE;
                                            address54 = _read_file();
                                            if (address54 != FAILURE) {
                                                elements7.add(0, address54);
                                                TreeNode address55 = FAILURE;
                                                address55 = _read_takes();
                                                if (address55 != FAILURE) {
                                                    elements7.add(1, address55);
                                                    TreeNode address56 = FAILURE;
                                                    address56 = _read_square();
                                                    if (address56 != FAILURE) {
                                                        elements7.add(2, address56);
                                                    } else {
                                                        elements7 = null;
                                                        offset = index9;
                                                    }
                                                } else {
                                                    elements7 = null;
                                                    offset = index9;
                                                }
                                            } else {
                                                elements7 = null;
                                                offset = index9;
                                            }
                                            if (elements7 == null) {
                                                address1 = FAILURE;
                                            } else {
                                                address1 = new TreeNode10(input.substring(index9, offset), index9, elements7);
                                                offset = offset;
                                            }
                                            if (address1 == FAILURE) {
                                                offset = index2;
                                                address1 = _read_castle();
                                                if (address1 == FAILURE) {
                                                    offset = index2;
                                                    address1 = _read_blacks_move();
                                                    if (address1 == FAILURE) {
                                                        offset = index2;
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
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address57 = FAILURE;
                int index10 = offset;
                address57 = _read_promotes();
                if (address57 == FAILURE) {
                    address57 = new TreeNode(input.substring(index10, index10), index10, new ArrayList<TreeNode>());
                    offset = index10;
                }
                if (address57 != FAILURE) {
                    elements0.add(1, address57);
                    TreeNode address58 = FAILURE;
                    int index11 = offset;
                    address58 = _read_check();
                    if (address58 == FAILURE) {
                        address58 = new TreeNode(input.substring(index11, index11), index11, new ArrayList<TreeNode>());
                        offset = index11;
                    }
                    if (address58 != FAILURE) {
                        elements0.add(2, address58);
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_san_psq() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.san_psq);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.san_psq, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            int index2 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(4);
            TreeNode address1 = FAILURE;
            address1 = _read_piece();
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                address2 = _read_square();
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address3 = FAILURE;
                    int index3 = offset;
                    address3 = _read_takes();
                    if (address3 == FAILURE) {
                        address3 = new TreeNode(input.substring(index3, index3), index3, new ArrayList<TreeNode>());
                        offset = index3;
                    }
                    if (address3 != FAILURE) {
                        elements0.add(2, address3);
                        TreeNode address4 = FAILURE;
                        address4 = _read_square();
                        if (address4 != FAILURE) {
                            elements0.add(3, address4);
                        } else {
                            elements0 = null;
                            offset = index2;
                        }
                    } else {
                        elements0 = null;
                        offset = index2;
                    }
                } else {
                    elements0 = null;
                    offset = index2;
                }
            } else {
                elements0 = null;
                offset = index2;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode11(input.substring(index2, offset), index2, elements0);
                offset = offset;
            }
            if (address0 == FAILURE) {
                offset = index1;
                int index4 = offset;
                List<TreeNode> elements1 = new ArrayList<TreeNode>(3);
                TreeNode address5 = FAILURE;
                address5 = _read_piece();
                if (address5 != FAILURE) {
                    elements1.add(0, address5);
                    TreeNode address6 = FAILURE;
                    int index5 = offset;
                    address6 = _read_takes();
                    if (address6 == FAILURE) {
                        address6 = new TreeNode(input.substring(index5, index5), index5, new ArrayList<TreeNode>());
                        offset = index5;
                    }
                    if (address6 != FAILURE) {
                        elements1.add(1, address6);
                        TreeNode address7 = FAILURE;
                        address7 = _read_square();
                        if (address7 != FAILURE) {
                            elements1.add(2, address7);
                        } else {
                            elements1 = null;
                            offset = index4;
                        }
                    } else {
                        elements1 = null;
                        offset = index4;
                    }
                } else {
                    elements1 = null;
                    offset = index4;
                }
                if (elements1 == null) {
                    address0 = FAILURE;
                } else {
                    address0 = new TreeNode12(input.substring(index4, offset), index4, elements1);
                    offset = offset;
                }
                if (address0 == FAILURE) {
                    offset = index1;
                    int index6 = offset;
                    List<TreeNode> elements2 = new ArrayList<TreeNode>(4);
                    TreeNode address8 = FAILURE;
                    address8 = _read_piece();
                    if (address8 != FAILURE) {
                        elements2.add(0, address8);
                        TreeNode address9 = FAILURE;
                        address9 = _read_file();
                        if (address9 != FAILURE) {
                            elements2.add(1, address9);
                            TreeNode address10 = FAILURE;
                            int index7 = offset;
                            address10 = _read_takes();
                            if (address10 == FAILURE) {
                                address10 = new TreeNode(input.substring(index7, index7), index7, new ArrayList<TreeNode>());
                                offset = index7;
                            }
                            if (address10 != FAILURE) {
                                elements2.add(2, address10);
                                TreeNode address11 = FAILURE;
                                address11 = _read_square();
                                if (address11 != FAILURE) {
                                    elements2.add(3, address11);
                                } else {
                                    elements2 = null;
                                    offset = index6;
                                }
                            } else {
                                elements2 = null;
                                offset = index6;
                            }
                        } else {
                            elements2 = null;
                            offset = index6;
                        }
                    } else {
                        elements2 = null;
                        offset = index6;
                    }
                    if (elements2 == null) {
                        address0 = FAILURE;
                    } else {
                        address0 = new TreeNode13(input.substring(index6, offset), index6, elements2);
                        offset = offset;
                    }
                    if (address0 == FAILURE) {
                        offset = index1;
                        int index8 = offset;
                        List<TreeNode> elements3 = new ArrayList<TreeNode>(4);
                        TreeNode address12 = FAILURE;
                        address12 = _read_piece();
                        if (address12 != FAILURE) {
                            elements3.add(0, address12);
                            TreeNode address13 = FAILURE;
                            address13 = _read_rank();
                            if (address13 != FAILURE) {
                                elements3.add(1, address13);
                                TreeNode address14 = FAILURE;
                                int index9 = offset;
                                address14 = _read_takes();
                                if (address14 == FAILURE) {
                                    address14 = new TreeNode(input.substring(index9, index9), index9, new ArrayList<TreeNode>());
                                    offset = index9;
                                }
                                if (address14 != FAILURE) {
                                    elements3.add(2, address14);
                                    TreeNode address15 = FAILURE;
                                    address15 = _read_square();
                                    if (address15 != FAILURE) {
                                        elements3.add(3, address15);
                                    } else {
                                        elements3 = null;
                                        offset = index8;
                                    }
                                } else {
                                    elements3 = null;
                                    offset = index8;
                                }
                            } else {
                                elements3 = null;
                                offset = index8;
                            }
                        } else {
                            elements3 = null;
                            offset = index8;
                        }
                        if (elements3 == null) {
                            address0 = FAILURE;
                        } else {
                            address0 = new TreeNode14(input.substring(index8, offset), index8, elements3);
                            offset = offset;
                        }
                        if (address0 == FAILURE) {
                            offset = index1;
                        }
                    }
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_piece() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.piece);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.piece, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && REGEX_6.matcher(chunk0).matches()) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("[KQRNBP]");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_disam() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.disam);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.disam, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            address0 = _read_square();
            if (address0 == FAILURE) {
                offset = index1;
                address0 = _read_file();
                if (address0 == FAILURE) {
                    offset = index1;
                    address0 = _read_rank();
                    if (address0 == FAILURE) {
                        offset = index1;
                    }
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_odisam() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.odisam);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.odisam, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            address0 = _read_square();
            if (address0 == FAILURE) {
                offset = index1;
                address0 = _read_disam();
                if (address0 == FAILURE) {
                    offset = index1;
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_takes() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.takes);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.takes, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("x")) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"x\"");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_square() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.square);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.square, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(2);
            TreeNode address1 = FAILURE;
            address1 = _read_file();
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                address2 = _read_rank();
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode15(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_file() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.file);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.file, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && REGEX_7.matcher(chunk0).matches()) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("[a-h]");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_rank() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.rank);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.rank, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && REGEX_8.matcher(chunk0).matches()) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("[1-8]");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_promotes() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.promotes);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.promotes, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(2);
            TreeNode address1 = FAILURE;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("=")) {
                address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address1 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"=\"");
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                String chunk1 = null;
                int max1 = offset + 1;
                if (max1 <= inputSize) {
                    chunk1 = input.substring(offset, max1);
                }
                if (chunk1 != null && REGEX_9.matcher(chunk1).matches()) {
                    address2 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                    offset = offset + 1;
                } else {
                    address2 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("[KQRNB]");
                    }
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_check() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.check);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.check, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && REGEX_10.matcher(chunk0).matches()) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("[+#]");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_castle() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.castle);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.castle, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            String chunk0 = null;
            int max0 = offset + 5;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("O-O-O")) {
                address0 = new TreeNode(input.substring(offset, offset + 5), offset, new ArrayList<TreeNode>());
                offset = offset + 5;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"O-O-O\"");
                }
            }
            if (address0 == FAILURE) {
                offset = index1;
                String chunk1 = null;
                int max1 = offset + 3;
                if (max1 <= inputSize) {
                    chunk1 = input.substring(offset, max1);
                }
                if (chunk1 != null && chunk1.equals("O-O")) {
                    address0 = new TreeNode(input.substring(offset, offset + 3), offset, new ArrayList<TreeNode>());
                    offset = offset + 3;
                } else {
                    address0 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("\"O-O\"");
                    }
                }
                if (address0 == FAILURE) {
                    offset = index1;
                    String chunk2 = null;
                    int max2 = offset + 4;
                    if (max2 <= inputSize) {
                        chunk2 = input.substring(offset, max2);
                    }
                    if (chunk2 != null && chunk2.equals("e1g1")) {
                        address0 = new TreeNode(input.substring(offset, offset + 4), offset, new ArrayList<TreeNode>());
                        offset = offset + 4;
                    } else {
                        address0 = FAILURE;
                        if (offset > failure) {
                            failure = offset;
                            expected = new ArrayList<String>();
                        }
                        if (offset == failure) {
                            expected.add("\"e1g1\"");
                        }
                    }
                    if (address0 == FAILURE) {
                        offset = index1;
                        String chunk3 = null;
                        int max3 = offset + 4;
                        if (max3 <= inputSize) {
                            chunk3 = input.substring(offset, max3);
                        }
                        if (chunk3 != null && chunk3.equals("e8g8")) {
                            address0 = new TreeNode(input.substring(offset, offset + 4), offset, new ArrayList<TreeNode>());
                            offset = offset + 4;
                        } else {
                            address0 = FAILURE;
                            if (offset > failure) {
                                failure = offset;
                                expected = new ArrayList<String>();
                            }
                            if (offset == failure) {
                                expected.add("\"e8g8\"");
                            }
                        }
                        if (address0 == FAILURE) {
                            offset = index1;
                            String chunk4 = null;
                            int max4 = offset + 4;
                            if (max4 <= inputSize) {
                                chunk4 = input.substring(offset, max4);
                            }
                            if (chunk4 != null && chunk4.equals("e1c1")) {
                                address0 = new TreeNode(input.substring(offset, offset + 4), offset, new ArrayList<TreeNode>());
                                offset = offset + 4;
                            } else {
                                address0 = FAILURE;
                                if (offset > failure) {
                                    failure = offset;
                                    expected = new ArrayList<String>();
                                }
                                if (offset == failure) {
                                    expected.add("\"e1c1\"");
                                }
                            }
                            if (address0 == FAILURE) {
                                offset = index1;
                                String chunk5 = null;
                                int max5 = offset + 4;
                                if (max5 <= inputSize) {
                                    chunk5 = input.substring(offset, max5);
                                }
                                if (chunk5 != null && chunk5.equals("e8c8")) {
                                    address0 = new TreeNode(input.substring(offset, offset + 4), offset, new ArrayList<TreeNode>());
                                    offset = offset + 4;
                                } else {
                                    address0 = FAILURE;
                                    if (offset > failure) {
                                        failure = offset;
                                        expected = new ArrayList<String>();
                                    }
                                    if (offset == failure) {
                                        expected.add("\"e8c8\"");
                                    }
                                }
                                if (address0 == FAILURE) {
                                    offset = index1;
                                }
                            }
                        }
                    }
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_comment() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.comment);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.comment, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(3);
            TreeNode address1 = FAILURE;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("{")) {
                address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address1 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"{\"");
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                int remaining0 = 0;
                int index2 = offset;
                List<TreeNode> elements1 = new ArrayList<TreeNode>();
                TreeNode address3 = new TreeNode("", -1, new ArrayList<TreeNode>());
                while (address3 != FAILURE) {
                    String chunk1 = null;
                    int max1 = offset + 1;
                    if (max1 <= inputSize) {
                        chunk1 = input.substring(offset, max1);
                    }
                    if (chunk1 != null && REGEX_11.matcher(chunk1).matches()) {
                        address3 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                        offset = offset + 1;
                    } else {
                        address3 = FAILURE;
                        if (offset > failure) {
                            failure = offset;
                            expected = new ArrayList<String>();
                        }
                        if (offset == failure) {
                            expected.add("[^\\}]");
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3);
                        --remaining0;
                    }
                }
                if (remaining0 <= 0) {
                    address2 = new TreeNode(input.substring(index2, offset), index2, elements1);
                    offset = offset;
                } else {
                    address2 = FAILURE;
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address4 = FAILURE;
                    String chunk2 = null;
                    int max2 = offset + 1;
                    if (max2 <= inputSize) {
                        chunk2 = input.substring(offset, max2);
                    }
                    if (chunk2 != null && chunk2.equals("}")) {
                        address4 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                        offset = offset + 1;
                    } else {
                        address4 = FAILURE;
                        if (offset > failure) {
                            failure = offset;
                            expected = new ArrayList<String>();
                        }
                        if (offset == failure) {
                            expected.add("\"}\"");
                        }
                    }
                    if (address4 != FAILURE) {
                        elements0.add(2, address4);
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_blacks_move() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.blacks_move);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.blacks_move, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 2;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("..")) {
                address0 = new TreeNode(input.substring(offset, offset + 2), offset, new ArrayList<TreeNode>());
                offset = offset + 2;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"..\"");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_cblacks_move() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.cblacks_move);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.cblacks_move, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            String chunk0 = null;
            int max0 = offset + 3;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("...")) {
                address0 = new TreeNode(input.substring(offset, offset + 3), offset, new ArrayList<TreeNode>());
                offset = offset + 3;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"...\"");
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_nags() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.nags);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.nags, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 1;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                address1 = _read_nag();
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = new TreeNode(input.substring(index1, offset), index1, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_nag() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.nag);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.nag, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(3);
            TreeNode address1 = FAILURE;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("$")) {
                address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address1 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"$\"");
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                int remaining0 = 1;
                int index2 = offset;
                List<TreeNode> elements1 = new ArrayList<TreeNode>();
                TreeNode address3 = new TreeNode("", -1, new ArrayList<TreeNode>());
                while (address3 != FAILURE) {
                    String chunk1 = null;
                    int max1 = offset + 1;
                    if (max1 <= inputSize) {
                        chunk1 = input.substring(offset, max1);
                    }
                    if (chunk1 != null && REGEX_12.matcher(chunk1).matches()) {
                        address3 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                        offset = offset + 1;
                    } else {
                        address3 = FAILURE;
                        if (offset > failure) {
                            failure = offset;
                            expected = new ArrayList<String>();
                        }
                        if (offset == failure) {
                            expected.add("[0-9]");
                        }
                    }
                    if (address3 != FAILURE) {
                        elements1.add(address3);
                        --remaining0;
                    }
                }
                if (remaining0 <= 0) {
                    address2 = new TreeNode(input.substring(index2, offset), index2, elements1);
                    offset = offset;
                } else {
                    address2 = FAILURE;
                }
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address4 = FAILURE;
                    address4 = _read_dlm();
                    if (address4 != FAILURE) {
                        elements0.add(2, address4);
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = new TreeNode16(input.substring(index1, offset), index1, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_variations() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.variations);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.variations, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int remaining0 = 1;
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>();
            TreeNode address1 = new TreeNode("", -1, new ArrayList<TreeNode>());
            while (address1 != FAILURE) {
                address1 = _read_variation();
                if (address1 != FAILURE) {
                    elements0.add(address1);
                    --remaining0;
                }
            }
            if (remaining0 <= 0) {
                address0 = actions.make_variations(input, index1, offset, elements0);
                offset = offset;
            } else {
                address0 = FAILURE;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_variation() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.variation);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.variation, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            List<TreeNode> elements0 = new ArrayList<TreeNode>(5);
            TreeNode address1 = FAILURE;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("(")) {
                address1 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address1 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"(\"");
                }
            }
            if (address1 != FAILURE) {
                elements0.add(0, address1);
                TreeNode address2 = FAILURE;
                address2 = _read_dlm();
                if (address2 != FAILURE) {
                    elements0.add(1, address2);
                    TreeNode address3 = FAILURE;
                    address3 = _read_movetext();
                    if (address3 != FAILURE) {
                        elements0.add(2, address3);
                        TreeNode address4 = FAILURE;
                        String chunk1 = null;
                        int max1 = offset + 1;
                        if (max1 <= inputSize) {
                            chunk1 = input.substring(offset, max1);
                        }
                        if (chunk1 != null && chunk1.equals(")")) {
                            address4 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                            offset = offset + 1;
                        } else {
                            address4 = FAILURE;
                            if (offset > failure) {
                                failure = offset;
                                expected = new ArrayList<String>();
                            }
                            if (offset == failure) {
                                expected.add("\")\"");
                            }
                        }
                        if (address4 != FAILURE) {
                            elements0.add(3, address4);
                            TreeNode address5 = FAILURE;
                            address5 = _read_dlm();
                            if (address5 != FAILURE) {
                                elements0.add(4, address5);
                            } else {
                                elements0 = null;
                                offset = index1;
                            }
                        } else {
                            elements0 = null;
                            offset = index1;
                        }
                    } else {
                        elements0 = null;
                        offset = index1;
                    }
                } else {
                    elements0 = null;
                    offset = index1;
                }
            } else {
                elements0 = null;
                offset = index1;
            }
            if (elements0 == null) {
                address0 = FAILURE;
            } else {
                address0 = actions.make_variation(input, index1, offset, elements0);
                offset = offset;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_score() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.score);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.score, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            String chunk0 = null;
            int max0 = offset + 3;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && chunk0.equals("1-0")) {
                address0 = new TreeNode(input.substring(offset, offset + 3), offset, new ArrayList<TreeNode>());
                offset = offset + 3;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("\"1-0\"");
                }
            }
            if (address0 == FAILURE) {
                offset = index1;
                String chunk1 = null;
                int max1 = offset + 3;
                if (max1 <= inputSize) {
                    chunk1 = input.substring(offset, max1);
                }
                if (chunk1 != null && chunk1.equals("0-1")) {
                    address0 = new TreeNode(input.substring(offset, offset + 3), offset, new ArrayList<TreeNode>());
                    offset = offset + 3;
                } else {
                    address0 = FAILURE;
                    if (offset > failure) {
                        failure = offset;
                        expected = new ArrayList<String>();
                    }
                    if (offset == failure) {
                        expected.add("\"0-1\"");
                    }
                }
                if (address0 == FAILURE) {
                    offset = index1;
                    String chunk2 = null;
                    int max2 = offset + 7;
                    if (max2 <= inputSize) {
                        chunk2 = input.substring(offset, max2);
                    }
                    if (chunk2 != null && chunk2.equals("1/2-1/2")) {
                        address0 = new TreeNode(input.substring(offset, offset + 7), offset, new ArrayList<TreeNode>());
                        offset = offset + 7;
                    } else {
                        address0 = FAILURE;
                        if (offset > failure) {
                            failure = offset;
                            expected = new ArrayList<String>();
                        }
                        if (offset == failure) {
                            expected.add("\"1/2-1/2\"");
                        }
                    }
                    if (address0 == FAILURE) {
                        offset = index1;
                        String chunk3 = null;
                        int max3 = offset + 1;
                        if (max3 <= inputSize) {
                            chunk3 = input.substring(offset, max3);
                        }
                        if (chunk3 != null && chunk3.equals("*")) {
                            address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                            offset = offset + 1;
                        } else {
                            address0 = FAILURE;
                            if (offset > failure) {
                                failure = offset;
                                expected = new ArrayList<String>();
                            }
                            if (offset == failure) {
                                expected.add("\"*\"");
                            }
                        }
                        if (address0 == FAILURE) {
                            offset = index1;
                        }
                    }
                }
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }

    TreeNode _read_dlm() {
        TreeNode address0 = FAILURE;
        int index0 = offset;
        Map<Integer, CacheRecord> rule = cache.get(Label.dlm);
        if (rule == null) {
            rule = new HashMap<Integer, CacheRecord>();
            cache.put(Label.dlm, rule);
        }
        if (rule.containsKey(offset)) {
            address0 = rule.get(offset).node;
            offset = rule.get(offset).tail;
        } else {
            int index1 = offset;
            String chunk0 = null;
            int max0 = offset + 1;
            if (max0 <= inputSize) {
                chunk0 = input.substring(offset, max0);
            }
            if (chunk0 != null && REGEX_13.matcher(chunk0).matches()) {
                address0 = new TreeNode(input.substring(offset, offset + 1), offset, new ArrayList<TreeNode>());
                offset = offset + 1;
            } else {
                address0 = FAILURE;
                if (offset > failure) {
                    failure = offset;
                    expected = new ArrayList<String>();
                }
                if (offset == failure) {
                    expected.add("[\\s+]");
                }
            }
            if (address0 == FAILURE) {
                address0 = new TreeNode(input.substring(index1, index1), index1, new ArrayList<TreeNode>());
                offset = index1;
            }
            rule.put(index0, new CacheRecord(address0, offset));
        }
        return address0;
    }
}
