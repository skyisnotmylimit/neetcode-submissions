class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number}
     */
    subarraySum(nums, k) {
        let map = new Map();
        map.set(0,1);
        let res = 0;
        let curSum = 0;
        for(let i=0;i<nums.length;i++) {
            curSum = curSum + nums[i];
            let diff = curSum - k;
            res += map.get(diff) || 0;
            map.set(curSum,(map.get(curSum) || 0)+1);
        }
        return res;
    }
}
