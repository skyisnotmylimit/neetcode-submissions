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
    private boolean isSame(TreeNode p,TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if(p == null || q == null) {
            return false;
        }
        if(p.val != q.val) {
            return false;
        }
        boolean left = isSame(p.left,q.left);
        boolean right = isSame(p.right,q.right);
        return left && right;
    }
    public boolean traverse(TreeNode root,TreeNode subRoot) {
        if(root == null) {
            return false;
        }
        boolean left = traverse(root.left,subRoot);
        boolean right = traverse(root.right,subRoot);
        if(left || right) return true;
        return isSame(root,subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        return traverse(root,subRoot);
    }
}
