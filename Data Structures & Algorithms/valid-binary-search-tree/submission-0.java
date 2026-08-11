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
    private boolean traverse(TreeNode root,int min,int max) {
        if(root == null) {
            return true;
        }

        boolean left = traverse(root.left,min,root.val);
        boolean right = traverse(root.right,root.val,max);

        if(root.val > min && root.val < max && left && right) return true;
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return traverse(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
