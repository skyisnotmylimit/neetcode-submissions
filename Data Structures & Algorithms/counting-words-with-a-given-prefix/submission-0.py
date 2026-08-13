class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        m = len(pref)
        total = 0
        for word in words:
            if word[:m] == pref:
                total += 1
        return total