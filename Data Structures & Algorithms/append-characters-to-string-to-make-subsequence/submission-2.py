class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        k = 0
        for i in range(len(s)):
            if k == len(t):
                break
            if s[i] == t[k]:
                k += 1
        return len(t) - k