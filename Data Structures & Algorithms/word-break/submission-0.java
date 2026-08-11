class Solution {
    Boolean[] dp;
    private boolean solve(int indx,String s,HashSet<String> set) {
        if(indx >= s.length()) {
            return true;
        }
        if(dp[indx] != null) return dp[indx];
        StringBuilder st = new StringBuilder();
        for(int i=indx;i<s.length();i++) {
            st.append(s.charAt(i));
            if(set.contains(st.toString())) {
                if(solve(i+1,s,set)) return dp[indx] = true;
            }
        }
        return dp[indx] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        dp = new Boolean[s.length()];
        for(String word : wordDict) {
            set.add(word);
        }
        return solve(0,s,set);
    }
}
