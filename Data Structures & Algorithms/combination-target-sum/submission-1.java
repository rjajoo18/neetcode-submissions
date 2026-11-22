class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, target, res, curr, 0);
        return res;
    }

    public void dfs(int[] nums, int remain, List<List<Integer>> res, List<Integer> curr, int i) {
        if (i >= nums.length || remain < 0) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // include element
        curr.add(nums[i]);
        dfs(nums, remain - nums[i], res, curr, i);
        // exclude element
        curr.remove(curr.size() - 1);
        dfs(nums, remain, res, curr, i + 1);
    }
}
