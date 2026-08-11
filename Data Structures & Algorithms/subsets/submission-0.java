class Solution {
    public void solve(int indx,int nums[],List<Integer> path,List<List<Integer>> result) {
        if(indx >= nums.length) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        path.add(nums[indx]);
        solve(indx+1,nums,path,result);
        path.remove(path.size()-1);
        solve(indx+1,nums,path,result);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solve(0,nums,path,result);
        return result;
    }
}
