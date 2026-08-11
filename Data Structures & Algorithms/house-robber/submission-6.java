class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length;
        Integer[] dp = new Integer[n];
        int prev = nums[0];
        int cur = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++) {
            int temp = cur;
            cur = Math.max(prev + nums[i],cur);
            prev = temp;
        }
        return cur;
    }
}
