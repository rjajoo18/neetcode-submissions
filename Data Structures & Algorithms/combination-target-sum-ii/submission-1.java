class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, curr, candidates, target, 0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int remain, int start) {
        if(remain < 0) return;
        if(remain == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) continue;

            curr.add(nums[i]);
            dfs(res, curr, nums, remain - nums[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
