class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        let map = {};
        for(let i=0;i<strs.length;i++) {
            let key = strs[i].split('').sort().join('');
            if(!map[key]) {
                map[key] = [];
            }
            map[key] = [...map[key],strs[i]];
        }
        return Object.values(map);
    }
}
