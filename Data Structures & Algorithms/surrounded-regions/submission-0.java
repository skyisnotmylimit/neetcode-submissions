class Pair{
    int x;
    int y;
    Pair(int x,int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++) {
            if(board[i][0] == 'O') {
                vis[i][0] = true;
                q.add(new Pair(i,0));
            }
            if(board[i][n-1] == 'O') {
                vis[i][n-1] = true;
                q.add(new Pair(i,n-1));
            }
        }
        for(int i=0;i<n;i++) {
            if(board[0][i] == 'O') {
                vis[0][i] = true;
                q.add(new Pair(0,i));
            }
            if(board[m-1][i] == 'O') {
                vis[m-1][i] = true;
                q.add(new Pair(m-1,i));
            }
        }
        while(!q.isEmpty()) {
            Pair cur = q.remove();
            for(int k=0;k<4;k++) {
                int r = cur.x + dir[k][0];
                int c = cur.y + dir[k][1];
                if(r >= 0 && c >= 0 && r < m && c < n && board[r][c] == 'O' && !vis[r][c]){
                    vis[r][c] = true;
                    q.add(new Pair(r,c));
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
