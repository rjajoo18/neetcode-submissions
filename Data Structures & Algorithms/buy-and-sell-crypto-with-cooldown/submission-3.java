class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp1Buy = 0, dp1Sell = 0, dp2Buy = 0;

        for (int i = n - 1; i >= 0; i--) {
            int dpBuy = Math.max(dp1Sell - prices[i], dp1Buy);
            int dpSell = Math.max(dp2Buy + prices[i], dp1Sell);
            dp2Buy = dp1Buy;
            dp1Sell = dpSell;
            dp1Buy = dpBuy;
        }

        return dp1Buy;
    }
}
