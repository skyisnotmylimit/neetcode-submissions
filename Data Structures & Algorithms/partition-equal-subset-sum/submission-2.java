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
        for(int i=0;i<targetSum+1;i++) {
            if(nums[0] == targetSum) dp[0][i] = true;
            else dp[0][i] = false;
        }
        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=targetSum;j++) {
                boolean pick = false;
                if(nums[i] <= j) {
                    pick = dp[i-1][j - nums[i]];
                }
                boolean npick = dp[i-1][j];
                dp[i][j] = pick | npick;
            }
        }
        return dp[n-1][targetSum];
        // return solve(n-1,nums,targetSum,dp);
    }
}
