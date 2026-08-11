class Solution {
    private int solve(int[] prices,int indx,int state) {
        if(indx >= prices.length) return 0;

        if(state == 0) {
            int buy = -prices[indx] + solve(prices,indx+1,1);
            int skip = 0 + solve(prices,indx+1,0);
            return Math.max(buy,skip);
        }
        else {
            int sell = prices[indx] + solve(prices,indx+2,0);
            int skip = 0 + solve(prices,indx+1,1);
            return Math.max(sell,skip);
        }
    }
    public int maxProfit(int[] prices) {
        return solve(prices,0,0);
    }
}
