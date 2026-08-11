class Solution {
    public int solve(String word1, String word2, int m, int n) {
        if(m == 0) return n;
        if(n == 0) return m;
        if(word1.charAt(m-1) == word2.charAt(n-1)) {
            return solve(word1, word2, m-1, n-1);
        }
        else {
            int way1 = 1 + solve(word1, word2, m-1, n-1);
            int way2 = 1 + solve(word1, word2, m-1, n);
            int way3 = 1 + solve(word1, word2, m, n-1);
            return Math.min(way1, Math.min(way2, way3));
        }
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        return solve(word1, word2, m, n);
    }
}
