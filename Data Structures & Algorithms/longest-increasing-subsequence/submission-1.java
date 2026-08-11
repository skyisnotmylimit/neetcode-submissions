class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<nums.length;i++) {
            int x = list.get(list.size() - 1);
            if(nums[i] > x) {
                list.add(nums[i]);
            }
            else if(nums[i] < x) {
                int indx = Collections.binarySearch(list,nums[i]);
                if(indx < 0)
                indx = -1*(indx + 1);
                list.set(indx,nums[i]);
            }
        }
        return list.size();
    }
}
