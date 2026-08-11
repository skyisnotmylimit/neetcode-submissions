class Solution {
    private int solve(String s,int indx) {
        if(indx >= s.length()) return 1;
        char a = s.charAt(indx);
        if(a == '0') return 0;
        int x = solve(s,indx+1);
        char b = ' ';
        int y = 0;
        if(indx+1 < s.length()) {
            b = s.charAt(indx+1);
            String t = "" + a + b;
            int temp = Integer.parseInt(t);
            if(temp <= 26 && temp != 0) {
                y = solve(s,indx+2);
            }
        }
        return x + y;
    }
    public int numDecodings(String s) {
        return solve(s,0);
    }
}
