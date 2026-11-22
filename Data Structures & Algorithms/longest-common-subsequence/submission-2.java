class Solution {

    private Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new Integer[m + 1][n + 1];

        Arrays.fill(memo[0], 0);
        for (int i = 1; i < m + 1; i++) {
            memo[i][0] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(text1, text2, i, j);
            }
        }

        return memo[m][n];
    }

    public int dfs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i + 1][j + 1] != null) {
            return memo[i + 1][j + 1];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i + 1][j + 1] = dfs(text1, text2, i - 1, j - 1) + 1;
        } else {
            memo[i + 1][j + 1] = Math.max(dfs(text1, text2, i - 1, j), 
                                  dfs(text1, text2, i, j - 1));
        }
        return memo[i + 1][j + 1];
    }
}
