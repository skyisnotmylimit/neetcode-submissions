class Solution:

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        freq = [0] * 26
        for char_s, char_t in zip(s, t):
            freq[ord(char_s) - 97] += 1
            freq[ord(char_t) - 97] -= 1
        return all(v == 0 for v in freq)