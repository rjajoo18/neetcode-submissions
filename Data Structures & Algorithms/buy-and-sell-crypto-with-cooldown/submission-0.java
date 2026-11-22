class Solution {
    private Integer[][] memo;
    public int maxProfit(int[] prices) {
        memo = new Integer[prices.length][2];
        dfs(prices, 0, true);
        return memo[0][1];
    }

    private int dfs(int[] prices, int i, boolean canBuy) {
        if (i >= prices.length) {
            return 0;
        }

        int buy = (canBuy) ? 1 : 0;

        if (memo[i][buy] != null) {
            return memo[i][buy];
        }

        if (buy == 1) {
            memo[i][buy] = Math.max(dfs(prices, i + 1, false) - prices[i], dfs(prices, i + 1, true));
        }

        else {
            memo[i][buy] = Math.max(dfs(prices, i + 2, true) + prices[i], dfs(prices, i + 1, false));
        }

        return memo[i][buy];
    }
}
