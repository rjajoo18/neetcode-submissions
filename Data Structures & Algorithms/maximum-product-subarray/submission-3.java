class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 1, min = 1, res = Integer.MIN_VALUE;

        for (int num : nums) {
            int tmp = max * num;
            max = Math.max(num, Math.max(num * max, num * min));
            min = Math.min(num, Math.min(num * min, tmp));
            res = Math.max(res, max);
        }

        return res;
    }
}
