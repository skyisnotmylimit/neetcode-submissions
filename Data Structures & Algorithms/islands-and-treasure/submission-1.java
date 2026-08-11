class Pair {
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = Integer.MAX_VALUE;
        int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
        Queue<Pair> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 0) {
                    q.add(new Pair(i,j));
                }
            }
        }
        int lvl = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            lvl++;
            for(int k=0;k<size;k++) {
                Pair cur = q.remove();
                for(int p=0;p<4;p++) {
                    int r = cur.x + dir[p][0];
                    int c = cur.y + dir[p][1];
                    if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == INF) {
                        grid[r][c] = lvl;
                        q.add(new Pair(r,c));
                    }
                }
            }
        }
    }
}
