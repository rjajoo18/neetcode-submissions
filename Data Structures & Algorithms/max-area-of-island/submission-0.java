class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0, rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    int area = 1;
                    while (!q.isEmpty()) {
                        int[] curr = q.poll();
                        int r = curr[0], c = curr[1];
                        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
                        for (int[] dir : dirs) {
                            int nr = r + dir[0], nc = c + dir[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                                && grid[nr][nc] == 1) {
                                    area += 1;
                                    q.offer(new int[]{nr, nc});
                                    grid[nr][nc] = 0;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
