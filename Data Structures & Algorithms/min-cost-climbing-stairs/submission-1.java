class Solution {
    private int solve(int cost[],int n) {
        if(n < 0) return 0;
        int way1 = solve(cost,n-1);
        int way2 = solve(cost,n-2);
        return Math.min(way1,way2) + cost[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int min1 = solve(cost,cost.length-1);
        int min2 = solve(cost,cost.length-2);
        return Math.min(min1,min2);
    }
}
