class Solution {
    private Integer[] dp;
    private int solve(int[] nums,int n) {
        if(n < 0) return 0;
        if(n == 0) {
            return nums[n];
        }
        if(dp[n] != null) return dp[n];
        return dp[n] = Math.max(solve(nums,n-1),solve(nums,n-2) + nums[n]);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new Integer[n];
        return solve(nums,n-1);
    }
}
