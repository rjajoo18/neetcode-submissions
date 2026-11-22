class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = amount;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for(int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return (dp[n] == (amount + 1) ? -1 : dp[n]);
    }
}
