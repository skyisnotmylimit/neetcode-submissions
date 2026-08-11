class Solution {
    private int reverseString(String n) {
        StringBuilder st = new StringBuilder(n);
        int res = 0;
        try {
            res = Integer.parseInt(st.reverse().toString());
        }
        catch(NumberFormatException e) {
            return 0;
        }
        return res;
    }
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        return sign * reverseString(Integer.toString(Math.abs(x)));
    }
}
