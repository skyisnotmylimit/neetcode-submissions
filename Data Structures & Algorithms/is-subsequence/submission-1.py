class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        k = 0
        for i in range(len(s)):
            flag = False
            for j in range(k,len(t)):
                if s[i] == t[j]:
                    flag = True
                    k = j + 1
                    break
            if flag == False:
                return False
        return True

