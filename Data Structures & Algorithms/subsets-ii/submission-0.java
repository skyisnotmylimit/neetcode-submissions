class Solution {
    private List<List<Integer>> result;
    private void solve(int indx,int[] nums,List<Integer> path) {
        if(indx >= nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[indx]);
        solve(indx+1,nums,path);
        path.remove(path.size()-1);

        while(indx+1 < nums.length && nums[indx] == nums[indx+1]) {
            indx++;
        }
        solve(indx+1,nums,path);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> path = new ArrayList<Integer>();
        result = new ArrayList<>();
        solve(0,nums,path);
        return result;
    }
}
