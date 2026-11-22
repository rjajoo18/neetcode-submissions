class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            int count = 1;
            int curr = num;
            while (set.contains(curr - 1)) {
                curr--;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
