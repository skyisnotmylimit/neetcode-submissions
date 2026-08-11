class Solution {
    List<List<Integer>> ans;
    private void solve(List<Integer> path,int nums[],int target,int indx) {
        if(indx >= nums.length){
            if(target == 0) {
                ans.add(new ArrayList<Integer>(path));
            }
            return;
        }
        if(target == 0) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        if(nums[indx] <= target) {
            path.add(nums[indx]);
            solve(path,nums,target-nums[indx],indx);
            path.remove(path.size()-1);
        }
        solve(path,nums,target,indx+1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        solve(path,nums,target,0);
        return ans;
    }
}
