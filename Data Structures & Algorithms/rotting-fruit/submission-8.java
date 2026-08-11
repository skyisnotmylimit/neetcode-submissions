class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        // Initialize the queue with all rotten oranges and count fresh ones
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges initially, return 0
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];

                for(int k = 0; k < 4; k++) {
                    int newR = r + dir[k][0];
                    int newC = c + dir[k][1];

                    // Check boundaries and if the adjacent orange is fresh
                    if(newR >= 0 && newC >= 0 && newR < m && newC < n && grid[newR][newC] == 1) {
                        grid[newR][newC] = 2; // Rot the fresh orange
                        q.add(new int[]{newR, newC});
                        freshOranges--; // Decrement the count of fresh oranges
                    }
                }
            }
            minutes++;
        }

        // Check if all fresh oranges have rotted
        return freshOranges == 0 ? minutes : -1;
    }
}