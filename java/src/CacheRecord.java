/**
 * This file was generated from parser.peg
 * See http://canopy.jcoglan.com/ for documentation.
 */

package parser;

class CacheRecord {
    TreeNode node;
    int tail;

    CacheRecord(TreeNode node, int tail) {
        this.node = node;
        this.tail = tail;
    }
}
