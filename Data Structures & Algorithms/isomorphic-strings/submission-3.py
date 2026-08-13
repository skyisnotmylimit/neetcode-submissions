class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        s = s.lower()
        t = t.lower()
        mapArr = dict()
        mapSet = set()
        for i in range(len(s)):
            if not(mapArr.get(s[i])) and not(t[i] in mapSet):
                mapArr.update({s[i]:t[i]})
                mapSet.add(t[i])
            else:
                if mapArr.get(s[i]) != t[i]:
                    return False
        return True
        