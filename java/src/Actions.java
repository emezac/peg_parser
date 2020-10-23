/**
 * This file was generated from parser.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package parser;

import java.util.List;

public interface Actions {
    public TreeNode make_game(String input, int start, int end, List<TreeNode> elements);
    public TreeNode make_movetext(String input, int start, int end, List<TreeNode> elements);
    public TreeNode make_tag_pair(String input, int start, int end, List<TreeNode> elements);
    public TreeNode make_tag_pairs(String input, int start, int end, List<TreeNode> elements);
    public TreeNode make_variation(String input, int start, int end, List<TreeNode> elements);
    public TreeNode make_variations(String input, int start, int end, List<TreeNode> elements);
}
