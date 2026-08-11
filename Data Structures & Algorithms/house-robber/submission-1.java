class Solution {
    private int solve(int nums[],int n,Integer dp[]) {
        if(n < 0) return 0;
        if(dp[n] != null) return dp[n];
        int pick = 0;
        int npick = solve(nums,n-1,dp);
        pick = solve(nums,n-2,dp) + nums[n];
        return dp[n] = Math.max(pick,npick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        Integer dp[] = new Integer[n];
        return solve(nums,n-1,dp);
    }
}
