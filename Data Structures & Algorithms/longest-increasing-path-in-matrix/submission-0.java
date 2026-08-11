class Solution {
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private int solve(int[][] matrix,boolean[][] vis,int i,int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        vis[i][j] = true;
        int cost = 1;
        for(int k=0;k<4;k++) {
            int r = dir[k][0] + i;
            int c = dir[k][1] + j;
            if(r >= 0 && r < m && c >= 0 && c < n && !vis[r][c] && matrix[r][c] > matrix[i][j]){
                cost = Math.max(cost,1+solve(matrix,vis,r,c));
            }
        }
        vis[i][j] = false;
        return cost;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int max = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                max = Math.max(max,solve(matrix,vis,i,j));
            }
        }
        return max;
    }
}
