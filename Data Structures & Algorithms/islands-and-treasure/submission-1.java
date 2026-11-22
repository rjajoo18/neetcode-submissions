class Solution {

    final int INF = Integer.MAX_VALUE;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] seen = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                if (grid[r][c] == INF) {
                    grid[r][c] = steps;
                }
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] != -1 && !seen[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        seen[nr][nc] = true;
                    } 
                }
            }
            steps++;
        }
    }

    public int bfs(int[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        boolean[][] seen = new boolean[rows][cols];
        q.offer(new int[]{r, c});
        seen[r][c] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int cRow = curr[0], cCol = curr[1];
                if (grid[cRow][cCol] == 0) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int nr = cRow + dir[0], nc = cCol + dir[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                       && grid[nr][nc] != -1 && !seen[nr][nc]) {
                        q.offer(new int[]{nr, nc});
                        seen[nr][nc] = true;
                       }
                }
            }
            steps++;
        }
        return INF;
    }
}
