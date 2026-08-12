class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        s = s.strip()
        indx = s.rfind(" ")
        return len(s) if indx == -1 else len(s[indx+1:])