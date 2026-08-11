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
class Tuple {
    int height;
    boolean flag;
    Tuple(int height,boolean flag) {
        this.height = height;
        this.flag = flag;
    }
}
class Solution {
    private Tuple solve(TreeNode root) {
        if(root == null) {
            return new Tuple(0,true);
        }
        Tuple left = solve(root.left);
        Tuple right = solve(root.right);
        if(left.flag && right.flag && Math.abs(left.height-right.height) <= 1) {
            return new Tuple(Math.max(left.height,right.height)+1,true);
        }
        return new Tuple(-1,false);
    }
    public boolean isBalanced(TreeNode root) {
        Tuple ans = solve(root);
        return ans.flag;
    }
}
