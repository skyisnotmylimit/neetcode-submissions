class Solution {
    public int solve(int m,int n) {
        if(m-1 == 0 && n-1 == 0) {
            return 1;
        }
        int way1 = 0;
        int way2 = 0;
        if(m-1 >= 0) {
            way1 = solve(m-1,n);
        }
        if(n-1 >= 0) {
            way2 = solve(m,n-1);
        }
        return way1+way2;
    }
    public int uniquePaths(int m, int n) {
        return solve(m,n);
    }
}
