class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxCount = 0
        curCount = 0
        n = len(nums)
        for i in range(n):
            if nums[i] == 1:
                curCount += 1
            else:
                maxCount = max(curCount,maxCount);
                curCount = 0
        return max(curCount,maxCount)
        