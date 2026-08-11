class Solution {
    private int solve(int cost[],int n,Integer dp[]) {
        if(n < 0) return 0;
        if(dp[n] != null) return dp[n];
        int way1 = solve(cost,n-1,dp);
        int way2 = solve(cost,n-2,dp);
        return dp[n] = Math.min(way1,way2) + cost[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer dp1[] = new Integer[n+1];
        Integer dp2[] = new Integer[n+2];
        int min1 = solve(cost,n-1,dp1);
        int min2 = solve(cost,n-2,dp2);
        return Math.min(min1,min2);
    }
}
