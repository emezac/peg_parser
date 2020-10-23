/**
 * This file was generated from parser.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package parser;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TreeNode implements Iterable<TreeNode> {
    public String text;
    public int offset;
    public List<TreeNode> elements;

    Map<Label, TreeNode> labelled;

    public TreeNode() {
        this("", -1, new ArrayList<TreeNode>(0));
    }

    public TreeNode(String text, int offset, List<TreeNode> elements) {
        this.text = text;
        this.offset = offset;
        this.elements = elements;
        this.labelled = new EnumMap<Label, TreeNode>(Label.class);
    }

    public TreeNode get(Label key) {
        return labelled.get(key);
    }

    public Iterator<TreeNode> iterator() {
        return elements.iterator();
    }
}

class TreeNode1 extends TreeNode {
    TreeNode1(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.tag_pairs, elements.get(0));
        labelled.put(Label.gcomment, elements.get(2));
        labelled.put(Label.movetext, elements.get(3));
        labelled.put(Label.score, elements.get(4));
    }
}

class TreeNode2 extends TreeNode {
    TreeNode2(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.dlm, elements.get(9));
        labelled.put(Label.key, elements.get(2));
        labelled.put(Label.value, elements.get(5));
    }
}

class TreeNode3 extends TreeNode {
    TreeNode3(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.move_number, elements.get(0));
        labelled.put(Label.dlm, elements.get(19));
        labelled.put(Label.white, elements.get(3));
        labelled.put(Label.san, elements.get(3));
        labelled.put(Label.wnags, elements.get(6));
        labelled.put(Label.wcomment, elements.get(8));
        labelled.put(Label.wvars, elements.get(10));
        labelled.put(Label.black, elements.get(12));
        labelled.put(Label.bnags, elements.get(14));
        labelled.put(Label.bcomment, elements.get(16));
        labelled.put(Label.bvars, elements.get(18));
        labelled.put(Label.mcomment, elements.get(20));
    }
}

class TreeNode4 extends TreeNode {
    TreeNode4(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(3));
        labelled.put(Label.rank, elements.get(4));
        labelled.put(Label.dlm, elements.get(2));
    }
}

class TreeNode5 extends TreeNode {
    TreeNode5(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(7));
        labelled.put(Label.rank, elements.get(8));
        labelled.put(Label.dlm, elements.get(4));
    }
}

class TreeNode6 extends TreeNode {
    TreeNode6(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(5));
        labelled.put(Label.rank, elements.get(6));
        labelled.put(Label.dlm, elements.get(2));
    }
}

class TreeNode7 extends TreeNode {
    TreeNode7(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(6));
        labelled.put(Label.file, elements.get(9));
        labelled.put(Label.rank, elements.get(10));
        labelled.put(Label.dlm, elements.get(5));
    }
}

class TreeNode8 extends TreeNode {
    TreeNode8(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(0));
        labelled.put(Label.file, elements.get(8));
        labelled.put(Label.rank, elements.get(9));
        labelled.put(Label.dlm, elements.get(5));
    }
}

class TreeNode9 extends TreeNode {
    TreeNode9(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(8));
        labelled.put(Label.rank, elements.get(9));
        labelled.put(Label.dlm, elements.get(4));
        labelled.put(Label.piece, elements.get(5));
    }
}

class TreeNode10 extends TreeNode {
    TreeNode10(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(0));
        labelled.put(Label.takes, elements.get(1));
        labelled.put(Label.square, elements.get(2));
    }
}

class TreeNode11 extends TreeNode {
    TreeNode11(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(0));
        labelled.put(Label.square, elements.get(3));
    }
}

class TreeNode12 extends TreeNode {
    TreeNode12(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(0));
        labelled.put(Label.square, elements.get(2));
    }
}

class TreeNode13 extends TreeNode {
    TreeNode13(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(0));
        labelled.put(Label.file, elements.get(1));
        labelled.put(Label.square, elements.get(3));
    }
}

class TreeNode14 extends TreeNode {
    TreeNode14(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.piece, elements.get(0));
        labelled.put(Label.rank, elements.get(1));
        labelled.put(Label.square, elements.get(3));
    }
}

class TreeNode15 extends TreeNode {
    TreeNode15(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.file, elements.get(0));
        labelled.put(Label.rank, elements.get(1));
    }
}

class TreeNode16 extends TreeNode {
    TreeNode16(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.dlm, elements.get(2));
    }
}

class TreeNode17 extends TreeNode {
    TreeNode17(String text, int offset, List<TreeNode> elements) {
        super(text, offset, elements);
        labelled.put(Label.dlm, elements.get(4));
        labelled.put(Label.movetext, elements.get(2));
    }
}
