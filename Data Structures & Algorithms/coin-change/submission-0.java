class Solution {
    public int solve(int coins[],int i,int total) {
        if(i == coins.length-1) {
            if(total % coins[i] == 0) {
                return total/coins[i];
            }
            else {
                return Integer.MAX_VALUE;
            }
        }
        if(total == 0) {
            return 0;
        }
        int npick = solve(coins,i+1,total);
        int pick = Integer.MAX_VALUE;
        if(coins[i] <= total) {
            pick = solve(coins,i,total - coins[i]);
        }
        if(pick != Integer.MAX_VALUE) {
            pick = 1 + pick;
        }
        return Math.min(pick,npick);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int ans = solve(coins,0,amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
