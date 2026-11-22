class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0], r = 1, max = nums[0];
        while(r < nums.length) {
            if(nums[r] > nums[r] + sum) {
                sum = nums[r];
            } else {
                sum += nums[r];
            }
            r++;
            max = Math.max(sum, max);
        }
        return max;
    }
}
