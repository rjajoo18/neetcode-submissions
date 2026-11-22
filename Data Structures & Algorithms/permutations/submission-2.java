class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, curr, used, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // include element at this index
            used[i] = true;
            curr.add(nums[i]);

            backtrack(res, curr, used, nums);

            // don't include now and continue looping
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
