class Solution {
    private int solve1(int nums[],int n,Integer dp[]) {
        if(n < 1) return 0;
        if(dp[n] != null) return dp[n];
        int npick = solve1(nums,n-1,dp);
        int pick = nums[n] + solve1(nums,n-2,dp);
        return dp[n] = Math.max(pick,npick);
    }
    private int solve2(int nums[],int n,Integer dp[]) {
        if(n < 0) return 0;
        if(dp[n] != null) return dp[n];
        int npick = solve2(nums,n-1,dp);
        int pick = nums[n] + solve2(nums,n-2,dp);
        return dp[n] = Math.max(pick,npick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        Integer dp1[] = new Integer[n];
        Integer dp2[] = new Integer[n];
        int max1 = solve1(nums,n-1,dp1);
        int max2 = solve2(nums,n-2,dp2);
        return Math.max(max1,max2);
    }
}
