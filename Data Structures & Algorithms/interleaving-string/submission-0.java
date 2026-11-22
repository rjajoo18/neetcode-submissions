class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
        if ((len1 + len2) != len3) return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[len1][len2] = true;
        for (int i = 0; i < len1; i++) {
            dp[i][len2] = check(s1, s2, s3, i);
        }
        for (int j = 0; j < len2; j++) {
            dp[len1][j] = check(s2, s1, s3, j);
        }
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i + 1][j];
                    if (s2.charAt(j) == s3.charAt(i + j)) {
                        dp[i][j] = dp[i][j] || dp[i][j + 1];
                    }
                } else {
                    if (s2.charAt(j) == s3.charAt(i + j)) {
                        dp[i][j] = dp[i][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }

    private boolean check(String s1, String s2, String s3, int idx) {
        int len2 = s2.length();
        return s1.substring(idx).equals(s3.substring(idx + len2));
    }
}
