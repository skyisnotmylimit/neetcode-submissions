class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        maxCount = curCount = 0
        for num in nums:
            curCount = curCount + 1 if num else 0
            maxCount = max(curCount,maxCount)
        return maxCount
        