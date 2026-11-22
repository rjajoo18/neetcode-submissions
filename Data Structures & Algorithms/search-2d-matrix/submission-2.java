class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int t = 0, b = m - 1, l = 0, r = n - 1;
        while(t <= b){
            int m1 = t + (b - t) / 2;
            if(matrix[m1][l] == target || matrix[m1][r] == target) return true;
            else if(matrix[m1][l] < target && matrix[m1][r] > target){
                while(l <= r){
                    int m2 = l + (r - l) / 2;
                    if(matrix[m1][m2] == target) return true;
                    else if(matrix[m1][m2] > target) r = m2 - 1;
                    else {
                        l = m2 + 1;
                    }
                }
                return false;
            }
            else if(matrix[m1][l] < target){
                t = m1 + 1;
            } else {
                b = m1 - 1;
            }
        }
        return false;
    }
}
