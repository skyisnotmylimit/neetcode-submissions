class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int front = 0;
        int back = 0;
        int max = 0;
        int maxF = 0;
        while(front < s.length()) {
            char c = s.charAt(front);
            map[c - 'A']++;
            maxF = Math.max(maxF,map[c - 'A']);
            while((front - back + 1) - maxF > k) {
                char temp = s.charAt(back);
                map[temp - 'A']--;
                back++;
            }
            max = Math.max(front - back + 1,max);
            front++;
        }
        return max;
    }
}
