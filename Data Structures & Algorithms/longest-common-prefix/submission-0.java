class Solution {
    private String prefix(String a,String b) {
        int i = 0;
        while(i < a.length() && i < b.length()) {
            if(a.charAt(i) != b.charAt(i)) {
                break;
            }
            else {
                i++;
            }
        }
        return a.substring(0,i);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String result = prefix(strs[0],strs[1]);
        for(int i=2;i<strs.length;i++) {
            result = prefix(result,strs[i]);
        }
        return result;
    }
}