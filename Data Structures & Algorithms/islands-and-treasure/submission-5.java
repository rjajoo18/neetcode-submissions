class Solution {

    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int INF = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[ROWS][COLS];
        
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                if (grid[r][c] == INF) grid[r][c] = dist;
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < ROWS &&
                        nc >= 0 && nc < COLS &&
                        !visited[nr][nc] && grid[nr][nc] == INF) {
                            q.offer(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                }
            }
            dist++;
        }
    }

}
