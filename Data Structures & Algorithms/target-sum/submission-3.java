class Solution {
    public int solve(int n,int nums[],int target,int curSum) {
        if(n == 0) {
            if(curSum + nums[n] == target && curSum - nums[n] == target)
            return 2;
            else if(curSum + nums[n] == target || curSum - nums[n] == target)
            return 1;
            else return 0;
        }
        int plus = solve(n-1,nums,target,curSum + nums[n]);
        int minus = solve(n-1,nums,target,curSum - nums[n]);
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(n-1,nums,target,0);
    }
}
