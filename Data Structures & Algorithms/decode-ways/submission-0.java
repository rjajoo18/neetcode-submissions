class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return dfs(s, 0);
    }

    public int dfs(String s, int curr) {
        if (curr >= s.length()){
            return 1;
        }

        if (dp[curr] != null) return dp[curr];

        char c = s.charAt(curr);

        if (c == '0') return 0;

        if (curr < s.length() - 1) {
            if (c == '1') {
                return dfs(s, curr + 1) + dfs(s, curr + 2);
            } else if (c == '2') {
                if (s.charAt(curr + 1) <= '6') {
                    return dfs(s, curr + 1) + dfs(s, curr + 2);
                }
            }
        }

        return dfs(s, curr + 1);
    }
}
