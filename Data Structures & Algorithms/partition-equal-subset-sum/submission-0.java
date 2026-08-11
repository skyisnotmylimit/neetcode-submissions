class Solution {
    public boolean solve(int n,int nums[],int targetSum) {
        if(n == 0) {
            if(nums[n] == targetSum) return true;
            else return false;
        }
        if(targetSum == 0) return true;
        boolean pick = false;
        if(nums[n] <= targetSum) {
            pick = solve(n-1,nums,targetSum - nums[n]);
        }
        boolean npick = solve(n-1,nums,targetSum);
        return pick | npick;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            sum = sum + nums[i];
        }
        if(sum % 2 != 0) return false;
        int targetSum = sum / 2;
        return solve(n-1,nums,targetSum);
    }
}
