class Solution {
    private int[] max;
    
    private int solve(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));
        max[0] = Math.max(max[0], left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        max = new int[1];
        max[0] = Integer.MIN_VALUE;
        solve(root);
        return max[0];
    }
}
