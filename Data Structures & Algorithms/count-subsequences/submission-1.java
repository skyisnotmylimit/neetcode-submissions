class Solution {
    private Integer[][] dp;
    private int solve(int i,int j,String s,String t) {
        if(j >= t.length()) {
            return 1;
        }
        if(i >= s.length()) {
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(i+1,j+1,s,t) + solve(i+1,j,s,t);
        }
        else {
            return dp[i][j] = solve(i+1,j,s,t);
        }
    }
    public int numDistinct(String s, String t) {
        dp = new Integer[s.length()][t.length()];
        return solve(0,0,s,t);
    }
}
