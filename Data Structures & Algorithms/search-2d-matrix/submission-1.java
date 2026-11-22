class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m * n];
        int idx = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[idx++] = matrix[i][j];
            }
        }
        return binarySearch(arr, target);
    }

    public boolean binarySearch(int[] arr, int target){
        int l = 0, r = arr.length;
        while(l != arr.length && l <= r){
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] > target) r = mid - 1;
            else{
                l = mid + 1;
            }
        }
        return false;
    }
}
