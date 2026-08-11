class Solution {
    private int solve(String s,int indx,Integer dp[]) {
        if(indx >= s.length()) return 1;
        if(dp[indx] != null) return dp[indx];
        char a = s.charAt(indx);
        if(a == '0') return dp[indx] = 0;
        int x = solve(s,indx+1,dp);
        int y = 0;
        if(indx+1 < s.length()) {
            char b = s.charAt(indx+1);
            String t = "" + a + b;
            int temp = Integer.parseInt(t);
            if(temp <= 26 && temp != 0) {
                y = solve(s,indx+2,dp);
            }
        }
        return dp[indx] = x + y;
    }
    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()];
        return solve(s,0,dp);
    }
}
