class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0], c = curr[1];
                        if (r + 1 < rows) {
                            if (grid[r + 1][c] == '1') {
                                q.offer(new int[]{r + 1, c});
                                grid[r + 1][c] = '0';
                            }
                        }
                        if (r - 1 >= 0) {
                            if (grid[r - 1][c] == '1') {
                                q.offer(new int[]{r - 1, c});
                                grid[r - 1][c] = '0';
                            }
                        }
                        if (c + 1 < cols) {
                            if (grid[r][c + 1] == '1') {
                                q.offer(new int[]{r, c + 1});
                                grid[r][c + 1] = '0';
                            }
                        }
                        if (c - 1 >= 0) {
                            if (grid[r][c - 1] == '1') {
                                q.offer(new int[]{r, c - 1});
                                grid[r][c - 1] = '0';
                            }
                        }
                    }
                    islands++;
                }
            }
        }

        return islands;
    }
}
