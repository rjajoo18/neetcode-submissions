class Solution {

    private int ROWS, COLS;
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        boolean[][] vPac = new boolean[ROWS][COLS];
        boolean[][] vAtl = new boolean[ROWS][COLS];
        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, vPac);
            dfs(heights, ROWS - 1, c, vAtl);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, vPac);
            dfs(heights, r, COLS - 1, vAtl);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (vPac[r][c] && vAtl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visit) {
        visit[r][c] = true;
        for (int[] dir : directions) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr == ROWS || nc < 0 || nc == COLS || visit[nr][nc] || heights[nr][nc] < heights[r][c]) continue;
            dfs(heights, nr, nc, visit);
        }
    }
}
