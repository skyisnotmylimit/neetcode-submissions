class Solution {
    private char[][] map;
    private List<String> ans;
    private void solve(int indx,String digits,StringBuilder path) {
        if(indx >= digits.length()) {
            ans.add(path.toString());
            return;
        }
        for(char c : map[digits.charAt(indx) - '0']) {
            path.append(c);
            solve(indx+1,digits,path);
            path.deleteCharAt(path.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        map = new char[][]{{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        ans = new ArrayList<String>();
        if(digits.length() == 0) return ans;
        StringBuilder path = new StringBuilder();
        solve(0,digits,path);
        return ans;
    }
}
