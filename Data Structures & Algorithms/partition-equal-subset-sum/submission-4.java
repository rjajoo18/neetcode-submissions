class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i][target]) return true;
        }
        
        return false;
    }
}
