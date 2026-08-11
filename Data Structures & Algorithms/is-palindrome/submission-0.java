class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder st = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                st.append(ch);
            }
        }
        String original = st.toString();
        String reverse = st.reverse().toString();
        return reverse.equals(original);
    }
}
