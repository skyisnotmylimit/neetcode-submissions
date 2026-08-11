class Solution {
    public int findDuplicate(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // Use absolute value to find the index
            if (nums[index] < 0) { // If already marked as visited
                ans = Math.abs(nums[i]); // Found the duplicate
                break;
            }
            nums[index] = -nums[index]; // Mark as visited by negating the value
        }
        return ans;
    }
}
