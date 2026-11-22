class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int islands = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0], c = curr[1];
                        if (r + 1 < rows) {
                            if (grid[r + 1][c] == '1' && !visited[r + 1][c]) {
                                q.offer(new int[]{r + 1, c});
                                visited[r + 1][c] = true;
                            }
                        }
                        if (r - 1 >= 0) {
                            if (grid[r - 1][c] == '1' && !visited[r - 1][c]) {
                                q.offer(new int[]{r - 1, c});
                                visited[r - 1][c] = true;
                            }
                        }
                        if (c + 1 < cols) {
                            if (grid[r][c + 1] == '1' && !visited[r][c + 1]) {
                                q.offer(new int[]{r, c + 1});
                                visited[r][c + 1] = true;
                            }
                        }
                        if (c - 1 >= 0) {
                            if (grid[r][c - 1] == '1' && !visited[r][c - 1]) {
                                q.offer(new int[]{r, c - 1});
                                visited[r][c - 1] = true;
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
