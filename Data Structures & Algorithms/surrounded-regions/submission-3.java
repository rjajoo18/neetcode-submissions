class Solution {

    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;

    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                dfs(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                dfs(board, ROWS - 1, c);
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'U') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    public void dfs(char[][] board, int r, int c) {
        board[r][c] = 'U';
        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && board[nr][nc] == 'O') {
                dfs(board, nr, nc);
            }
        }
    }
}
