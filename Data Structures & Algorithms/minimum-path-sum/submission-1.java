class Solution {
    private int solve(int[][] grid,int m,int n) {
        if(m == 0 && n == 0) {
            return grid[m][n];
        }
        if(m == 0) {
            return grid[m][n] + solve(grid,m,n-1);
        }
        if(n == 0) {
            return grid[m][n] + solve(grid,m-1,n);
        }
        int way1 = solve(grid,m-1,n);
        int way2 = solve(grid,m,n-1);
        return Math.min(way1,way2) + grid[m][n];
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];
        dp[0][0] = grid[0][0];
        for(int i=1;i<n;i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1;i<m;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        } 
        return dp[m-1][n-1];
    }
}