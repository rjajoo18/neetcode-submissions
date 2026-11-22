class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] seen = new boolean[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == word.charAt(0) && dfs(board, word, 0, r, c, rows, cols, seen)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int r, int c, int rows, int cols, boolean[][] seen) {
        if(i == word.length()){
            return true;
        } 

        if(r < 0 || c < 0 || r >= rows || c >= cols || word.charAt(i) != board[r][c] || seen[r][c]) {
            return false;
        }

        seen[r][c] = true;
        boolean res = dfs(board, word, i + 1, r + 1, c, rows, cols, seen) || dfs(board, word, i + 1, r - 1, c, rows, cols, seen) || dfs(board, word, i + 1, r, c + 1, rows, cols, seen) || dfs(board, word, i + 1, r, c - 1, rows, cols, seen);
        seen[r][c] = false;

        return res;
    }
}
