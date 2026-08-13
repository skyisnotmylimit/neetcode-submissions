class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        m = len(pref)
        total = 0
        for word in words:
            if word.startswith(pref):
                total += 1
        return total