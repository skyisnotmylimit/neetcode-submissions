class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    int z;
    Tuple(int x,int y,int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public int compareTo(Tuple other) {
        return this.z - other.z;
    }
}
class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        int m = grid.length;
        int n = grid[0].length;
        int dir[][] = {{0,1},{-1,0},{1,0},{0,-1}};
        boolean vis[][] = new boolean[m][n];
        vis[0][0] = true;
        pq.add(new Tuple(0,0,grid[0][0]));
        while(!pq.isEmpty()) {
            Tuple cur = pq.remove();
            if(cur.x == m-1 && cur.y == n-1){
                return cur.z;
            }
            for(int k=0;k<4;k++) {
                int r = cur.x + dir[k][0];
                int c = cur.y + dir[k][1];
                if(r >= 0 && c >= 0 && r < m && c < n && !vis[r][c]) {
                    vis[r][c] = true;
                    int newValue = Math.max(cur.z,grid[r][c]);
                    pq.add(new Tuple(r,c,newValue));
                }
            }
        }
        return 0;
    }
}
