class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            HashSet<Integer> set = new HashSet<>();
            for(char c : board[i]){
                if(c != '.'){
                    int val = c - '0';
                    if(set.contains(val)) return false;
                    set.add(val);
                }
            }
        }

        for(int i = 0; i < board[0].length; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = 0; j < board.length; j++){
                char c = board[j][i];
                if(c != '.') {
                    int val = c - '0';
                    if(set.contains(val)) return false;
                    set.add(val);
                }
            }
        }

        int r = 0;
        int s = 0;
        while(r < 3){
            while(s < 3){
                HashSet<Integer> set = new HashSet<>();
                for(int i = 3 * r; i < 3 * r + 3; i++){
                    for(int j = 3 * s; j < 3 * s + 3; j++){
                        char c = board[i][j];
                        if(c != '.'){
                            int val = c - '0';
                            if(set.contains(val)) return false;
                            set.add(val);
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
