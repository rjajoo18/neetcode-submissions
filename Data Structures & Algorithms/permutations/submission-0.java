class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();
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
            
            else if(!used[i]) {
                used[i] = true;
            }
            curr.add(nums[i]);
            backtrack(res, curr, used, nums);
            used[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
