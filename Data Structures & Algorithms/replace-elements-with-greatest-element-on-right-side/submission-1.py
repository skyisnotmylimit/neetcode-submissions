class Solution:
    def replaceElements(self, arr: List[int]) -> List[int]:
        n = len(arr)
        res = [-1]
        if n == 1:
            return res
        curMax = arr[n-1]
        i = n-2
        while i > 0:
            res.insert(0,curMax);
            curMax = max(curMax,arr[i])
            i -= 1
        res.insert(0,curMax)
        return res