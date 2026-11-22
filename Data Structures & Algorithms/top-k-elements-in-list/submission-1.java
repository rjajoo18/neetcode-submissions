class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int val : nums){
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        List<List<Integer>> res = new ArrayList<>(nums.length + 1);
        for(int i = 0; i < nums.length + 1; i++) {
            res.add(new ArrayList<Integer>());
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            res.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];
        int idx = 0;
        for(int i = res.size() - 1; i >= 0 && idx < k; i--) {
            for(int val : res.get(i)) {
                ans[idx++] = val;
                if(idx == k) break;
            }
        }

        return ans;
    }
}
