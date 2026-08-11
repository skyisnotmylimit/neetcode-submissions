class Solution {
    private int solve(int i,int j,String s,String t) {
        if(j >= t.length()) {
            return 1;
        }
        if(i >= s.length()) {
            return 0;
        }
        if(s.charAt(i) == t.charAt(j)) {
            return solve(i+1,j+1,s,t) + solve(i+1,j,s,t);
        }
        else {
            return solve(i+1,j,s,t);
        }
    }
    public int numDistinct(String s, String t) {
        return solve(0,0,s,t);
    }
}
