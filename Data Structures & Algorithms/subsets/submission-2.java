class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res, curr, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int i) {
        res.add(new ArrayList<>(curr));
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(res, curr, nums, j + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
