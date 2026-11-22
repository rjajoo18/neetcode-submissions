class Solution {
    Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new Integer[text1.length()][text2.length()];
        dfs(text1, text2, 0, 0);
        return memo[0][0];
    }

    private int dfs(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = dfs(text1, text2, i + 1, j + 1) + 1;
        } else {
            memo[i][j] = Math.max(dfs(text1, text2, i + 1, j),
                            dfs(text1, text2, i, j + 1));
        }
        return memo[i][j];
    }
}
