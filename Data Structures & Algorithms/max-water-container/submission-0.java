class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int n = heights.length;
        int left = 0;
        int right = n-1;
        while(left < right) {
            int a = Math.min(heights[left],heights[right]);
            int b = right - left;
            max = Math.max(a * b , max);
            if(heights[left] < heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return max;
    }
}
