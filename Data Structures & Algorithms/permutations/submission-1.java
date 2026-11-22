class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, curr, used, nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> curr, boolean[] used, int[] nums) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;

            curr.add(nums[i]);
            used[i] = true;

            backtrack(res, curr, used, nums);

            curr.remove(curr.size() - 1);
            used[i] = false;
            
        }
    }
}
