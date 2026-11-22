class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(res, board, new int[n][n], 0, n, 0);
        return res;
    }


    // we keep the row constant and try out each column, rather than trying out each point every time, increasing efficiency
    public void dfs(List<List<String>> res, char[][] board, int[][] points, int numQueens, int n, int r) {
        // if we have desired number of queens, add to our result 
        if (numQueens == n) {
            List<String> curr = new ArrayList<>();
            for (char[] boardRow : board) {
                String currRow = String.valueOf(boardRow);
                curr.add(currRow);
            }
            res.add(curr);
            return;
        }
        
        // fix the row, so the only thing that we are going to backtrack on is the column
        for (int c = 0; c < n; c++) {
            // validate whether the point is valid to be tried
            boolean isValid = true;
            for (int i = 0; i < numQueens; i++) {
                int row = points[i][0];
                int col = points[i][1];
                if (c == col || Math.abs(r - row) == Math.abs(c - col)) {
                    isValid = false;
                    break;
                }
            }
            // if valid, then set the point and dfs on the next row
            if (isValid) {
                points[numQueens] = new int[]{r, c};
                board[r][c] = 'Q';
                // strictly look at next row
                dfs(res, board, points, numQueens + 1, n, r + 1);
                // points[numQueens] will be overwritten anyway so don't need to put it back to default value
                board[r][c] = '.';
            }
        }
    }
}
