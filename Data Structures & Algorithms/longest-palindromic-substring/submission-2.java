class Solution {
    private String solve(int r,int l,String s) {
        String res = "";
        while(r < s.length() && l >= 0 && s.charAt(r) == s.charAt(l)) {
            res = s.substring(l,r+1);
            r++;
            l--;
        }
        return res;
    }
    public String longestPalindrome(String s) {
        String res = "";
        for(int i=0;i<s.length();i++) {
            String a1 = solve(i,i,s);
            String a2 = i+1 < s.length() ? solve(i,i+1,s) : "";
            if(a1.length() >= res.length()) {
                res = a1;
            }
            if(a2.length() >= res.length()) {
                res = a2;
            }
        }
        return res;
    }
}
