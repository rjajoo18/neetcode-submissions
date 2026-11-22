class Solution {
    public int uniquePaths(int m, int n) {
        return combination(m + n - 2, Math.min(m - 1, n - 1));
    }

    public int combination(int n, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (n - (k - i)) / i;
        }
        return (int)res;
    }
}
