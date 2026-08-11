class Solution {
    private Integer[][] dp;
    private int solve(int[] prices,int indx,int state) {
        if(indx >= prices.length) return 0;
        if(dp[indx][state] != null) return dp[indx][state];
        if(state == 0) {
            int buy = -prices[indx] + solve(prices,indx+1,1);
            int skip = 0 + solve(prices,indx+1,0);
            return dp[indx][state] = Math.max(buy,skip);
        }
        else {
            int sell = prices[indx] + solve(prices,indx+2,0);
            int skip = 0 + solve(prices,indx+1,1);
            return dp[indx][state] = Math.max(sell,skip);
        }
    }
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return solve(prices,0,0);
    }
}
