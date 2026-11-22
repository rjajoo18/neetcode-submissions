class Solution {
    private int[][] memo;
    private int offset;

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        offset = sum;
        memo = new int[nums.length][2 * sum + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, target, 0);        
    }

    public int dfs(int[] nums, int rem, int i) {
        if (rem > offset || rem < -1 * offset) {
            return 0;
        }

        if (i == nums.length) {
            if (rem == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int idx = rem + offset;

        if (memo[i][idx] != -1) {
            return memo[i][idx];
        }

        memo[i][idx] = dfs(nums, rem - nums[i], i + 1) + dfs(nums, rem + nums[i], i + 1);
        return memo[i][idx];
    }
}
