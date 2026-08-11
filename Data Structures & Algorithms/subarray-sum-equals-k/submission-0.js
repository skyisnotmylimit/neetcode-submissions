class Solution {
    /**
     * @param {number[]} nums
     * @param {number} k
     * @return {number}
     */
    subarraySum(nums, k) {
        let count = 0;
        let n = nums.length;
        for(let i=0;i<n;i++) {
            let windowSum = 0;
            for(let j=i;j<n;j++) {
                windowSum = windowSum + nums[j];
                if(windowSum === k) {
                    count++;
                }
            }
        }
        return count;
    }
}
