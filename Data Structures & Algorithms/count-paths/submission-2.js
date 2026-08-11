class Solution {
    /**
     * @param {number} m
     * @param {number} n
     * @return {number}
     */
    uniquePaths(m, n) {
        if(m == 1 || n == 1) return 1;
        let top = this.uniquePaths(m-1,n);
        let left = this.uniquePaths(m,n-1);
        return top+left;
    }
}
