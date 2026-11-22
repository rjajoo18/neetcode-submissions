class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxPf = 0;
        for(int i = 1; i < prices.length; i++){
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int pf = prices[i] - min;
                if (pf > maxPf) {
                    maxPf = pf;
                }
            }
        }
        return maxPf;
    }
}
