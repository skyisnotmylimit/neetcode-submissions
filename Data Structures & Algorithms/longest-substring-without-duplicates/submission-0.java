class Solution {
    public int lengthOfLongestSubstring(String s) {
        int back = 0;
        int front = 0;
        int max = 0;
        int[] map = new int[128];
        while (front < s.length()) {
            char c = s.charAt(front);
            map[c]++;
            while (map[c] > 1) {
                char a = s.charAt(back);
                map[a]--;
                back++;
            }
            max = Math.max(max, front - back + 1);
            front++;
        }
        return max;
    }
}
