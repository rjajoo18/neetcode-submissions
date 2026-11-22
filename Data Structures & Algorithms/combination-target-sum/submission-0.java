class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, target, res, curr, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> curr, int sum, int i) {
        if(sum > target){
            return;
        }
        
        if(sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i >= nums.length) return;

        // Choose element again
        curr.add(nums[i]);
        dfs(nums, target, res, curr, sum + nums[i], i);

        // Don't choose element again
        curr.remove(curr.size() - 1);
        dfs(nums, target, res, curr, sum, i + 1);

    }
}
