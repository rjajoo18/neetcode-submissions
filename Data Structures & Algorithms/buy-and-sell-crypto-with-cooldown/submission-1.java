class Solution {
    private int[][] memo;
    public int maxProfit(int[] prices) {
        memo = new int[prices.length][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(prices, 0, true);
    }

    private int dfs(int[] prices, int i, boolean canBuy) {
        if (i >= prices.length) {
            return 0;
        }

        int buy = (canBuy) ? 1 : 0;

        if (memo[i][buy] != -1) {
            return memo[i][buy];
        }

        if (buy == 1) {
            memo[i][buy] = Math.max(dfs(prices, i + 1, false) - prices[i], dfs(prices, i + 1, true));
        } else {
            memo[i][buy] = Math.max(dfs(prices, i + 2, true) + prices[i], dfs(prices, i + 1, false));
        }

        return memo[i][buy];
    }
}
