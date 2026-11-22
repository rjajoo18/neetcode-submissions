class Solution {
    public int orangesRotting(int[][] grid) {
        int freshFruit = 0;
        int rows = grid.length, cols = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } 
                if (grid[i][j] == 1) {
                    freshFruit++;
                }
            }
        }
        int mins = 0;
        if (freshFruit == 0) return mins;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < rows && 
                        nc >= 0 && nc < cols &&
                        grid[nr][nc] == 1) {
                            grid[nr][nc] = 2;
                            q.offer(new int[]{nr, nc});
                            freshFruit--;
                        }
                }
            }
            mins++;
            if (freshFruit == 0) return mins;
            
        }
        return (freshFruit == 0) ? mins : -1;
    }
}
