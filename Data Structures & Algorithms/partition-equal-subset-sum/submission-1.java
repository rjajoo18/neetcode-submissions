class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        memo = new Boolean[nums.length][target + 1];
        return dfs(nums, 0, sum / 2, 0);
    }

    private boolean dfs (int[] nums, int i, int target, int curr) {
        if (i >= nums.length) {
            return false;
        }

        if (curr == target) {
            return true;
        }

        if (memo[i][curr] != null) return memo[i][curr];

        boolean res = dfs(nums, i + 1, target, curr);
        // if skipping works then checking this branch is pointless
        if (!res && curr + nums[i] <= target) {
            res = dfs(nums, i + 1, target, curr + nums[i]);
        }

        memo[i][curr] = res;
        return res;
    }
}
