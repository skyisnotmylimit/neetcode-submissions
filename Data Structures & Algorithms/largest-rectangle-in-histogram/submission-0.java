class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            rightMin[i] = (st.isEmpty()) ? n : st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            leftMin[i] = (st.isEmpty()) ? -1 : st.peek();
            st.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {
            int val = heights[i] * (rightMin[i] - leftMin[i] - 1);
            max = Math.max(max,val);
        }
        return max;
    }
}
