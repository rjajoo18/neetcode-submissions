class Solution {
    int m, n;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res = Math.max(res, dfs(matrix, dp, r, c));
            }
        }

        return res;
    }

    private int dfs(int[][] matrix, int[][] dp, int r, int c) {
        if (dp[r][c] != -1) return dp[r][c];

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || matrix[nr][nc] <= matrix[r][c]) continue;
            dp[r][c] = Math.max(dp[r][c], 1 + dfs(matrix, dp, nr, nc));
        }

        dp[r][c] = Math.max(dp[r][c], 1);
        return dp[r][c];
    }
}
