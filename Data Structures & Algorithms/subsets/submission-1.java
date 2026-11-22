class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res, curr, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int i) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Include element
        curr.add(nums[i]);
        backtrack(res, curr, nums, i + 1);

        // Don't include element
        curr.remove(curr.size() - 1);
        backtrack(res, curr, nums, i + 1);
    }
}
