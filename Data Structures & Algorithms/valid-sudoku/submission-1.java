class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            boolean[] seen = new boolean[9];
            for(char c : board[i]){
                if(c != '.'){
                    int val = c - '1';
                    if(seen[val]) return false;
                    seen[val] = true;
                }
            }
        }

        for(int i = 0; i < board[0].length; i++){
            boolean[] seen = new boolean[9];
            for(int j = 0; j < board.length; j++){
                char c = board[j][i];
                if(c != '.') {
                    int val = c - '1';
                    if(seen[val]) return false;
                    seen[val] = true;
                }
            }
        }

        int r = 0;
        int s = 0;
        while(r < 3){
            while(s < 3){
                boolean[] seen = new boolean[9];
                for(int i = 3 * r; i < 3 * r + 3; i++){
                    for(int j = 3 * s; j < 3 * s + 3; j++){
                        char c = board[i][j];
                        if(c != '.'){
                            int val = c - '1';
                            if(seen[val]) return false;
                            seen[val] = true;
                        }
                    }
                }
                s++;
            }
            r++;
            s = 0;
        }
        return true;
    }
}
