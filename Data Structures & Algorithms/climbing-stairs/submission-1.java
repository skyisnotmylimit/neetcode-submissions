class Solution {
    private int solve(int n,Integer dp[]) {
        if(n == 0 || n == 1)
        return 1;
        if(dp[n] != null) return dp[n]; 
        return dp[n] = solve(n-1,dp) + solve(n-2,dp);
    }
    public int climbStairs(int n) {
        Integer dp[] = new Integer[n+1];
        return solve(n,dp);
    }
}
