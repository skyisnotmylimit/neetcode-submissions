class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    private int bfs(int[][] grid,boolean[][] vis,int i,int j) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true;
        int count = 0;
        q.add(new Pair(i,j));
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            count++;
            for(int k=0;k<4;k++) {
                int r = cur.x + dir[k][0];
                int c = cur.y + dir[k][1];
                if(r >= 0 && c >= 0 && r < m && c < n && !vis[r][c] && grid[r][c] == 1) {
                    vis[r][c] = true;
                    q.add(new Pair(r,c));
                }
            }
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[m][n];
        int maxArea = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1 && !vis[i][j]) {
                    maxArea = Math.max(maxArea,bfs(grid,vis,i,j));
                }
            }
        }
        return maxArea;
    }
}
