class Solution {
    public int solve(int n,int nums[],int target,int curSum) {
        if(n == nums.length) {
            return (curSum == target) ? 1 : 0;
        }
        int plus = solve(n+1,nums,target,curSum + nums[n]);
        int minus = solve(n+1,nums,target,curSum - nums[n]);
        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(0,nums,target,0);
    }
}
