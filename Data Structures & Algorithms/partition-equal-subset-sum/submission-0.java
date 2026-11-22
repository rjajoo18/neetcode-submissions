class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        return dfs(nums, 0, sum / 2, 0);
    }

    private boolean dfs (int[] nums, int i, int target, int curr) {
        if (i >= nums.length) {
            return false;
        }

        if (curr == target) {
            return true;
        }

        boolean res = dfs(nums, i + 1, target, curr);

        if (curr + nums[i] <= target) {
            return res || dfs(nums, i + 1, target, curr + nums[i]);
        }

        return res;
    }
}
