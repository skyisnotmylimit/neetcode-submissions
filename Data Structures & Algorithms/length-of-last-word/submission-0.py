class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        indx = s.rfind(" ")
        if indx == -1:
            return len(s)
        else:
            return len(s[indx+1:])