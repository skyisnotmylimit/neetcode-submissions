class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        words.sort(key=len)
        print(words)
        result = []
        n = len(words)
        for i in range(n):
            for j in range(i+1,n):
                if words[i] in words[j]:
                    result.append(words[i])
                    break
        return result
        