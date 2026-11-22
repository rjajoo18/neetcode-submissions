class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int val : nums){
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for(int i = 0; i <= nums.length; i++){
            buckets.add(new ArrayList<Integer>());
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] ans = new int[k];
        int curr = 0;

        for(int i = buckets.size() - 1; i >= 0 && curr < k; i--){
            for(int x : buckets.get(i)){
                ans[curr++] = x;
                if(curr == k) break;
            }
        }

        return ans;
    }
}
