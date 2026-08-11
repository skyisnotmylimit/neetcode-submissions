class Solution {
    private final int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    private boolean solve(char board[][],boolean vis[][],int i,int j,int ptr,String word) {
        if(ptr >= word.length()){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = true;
        for(int k=0;k<4;k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if(r >= 0 && r < m && c >= 0 
            && c < n && board[r][c] == word.charAt(ptr) && !vis[r][c]) {
                if(solve(board,vis,r,c,ptr+1,word))
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean vis[][] = new boolean[m][n];
        char src = word.charAt(0);
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == src) {
                    if(solve(board,vis,i,j,1,word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
