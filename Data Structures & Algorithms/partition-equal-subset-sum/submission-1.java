class Solution {
    public boolean solve(int n,int nums[],int targetSum,Boolean dp[][]) {
        if(n == 0) {
            if(nums[n] == targetSum) return true;
            else return false;
        }
        if(targetSum == 0) return true;
        if(dp[n][targetSum] != null) return dp[n][targetSum];
        boolean pick = false;
        if(nums[n] <= targetSum) {
            pick = solve(n-1,nums,targetSum - nums[n],dp);
        }
        boolean npick = solve(n-1,nums,targetSum,dp);
        return dp[n][targetSum] = pick | npick;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            sum = sum + nums[i];
        }
        if(sum % 2 != 0) return false;
        int targetSum = sum / 2;
        Boolean dp[][] = new Boolean[n][targetSum+1];
        return solve(n-1,nums,targetSum,dp);
    }
}
