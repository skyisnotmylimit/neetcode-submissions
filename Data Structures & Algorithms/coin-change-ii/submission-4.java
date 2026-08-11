class Solution {
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Fill the dp table
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1; // There is 1 way to make amount 0 (by not picking any coins)
        }

        for (int i = 0; i < n; i++) {
            for (int a = 1; a <= amount; a++) {
                int notPick = (i > 0) ? dp[i - 1][a] : 0;
                int pick = (coins[i] <= a) ? dp[i][a - coins[i]] : 0;
                dp[i][a] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }
}
