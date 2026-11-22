class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(houseRob(nums, 0, nums.length - 2), houseRob(nums, 1, nums.length - 1));
    }

    public int houseRob(int[] nums, int l, int r) {
        if (r - l == 0) return nums[r];
        int rob1 = 0, rob2 = 0;
        for (int i = l; i <= r; i++) {
            int temp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
