/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return bft (root1, root2);
    }
    private TreeNode bft ( TreeNode r1, TreeNode r2) {
        if (r1==null && r2 == null) return null;
        
        TreeNode d = new TreeNode();
        d.val = getVal(r1) + getVal(r2);
        d.left = bft(getLeft(r1), getLeft(r2));
        d.right = bft(getRight(r1), getRight(r2));
        return d;
    }
    
    private TreeNode getRight(TreeNode t) {
        if (t != null) return t.right;
        return null;
    }
    private TreeNode getLeft(TreeNode t) {
        if (t != null) return t.left;
        return null;
    }
    private int getVal(TreeNode t) {
        if (t != null) return t.val;
        return 0;
    }
}
