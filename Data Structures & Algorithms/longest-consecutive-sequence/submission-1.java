class Solution {
    public int longestConsecutive(int[] nums) {
        int maxCount = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) set.add(val);
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i] - 1)){
                int count = 1;
                int k = 1;
                while(set.contains(nums[i] + k)){
                    count++;
                    k++;
                }
                if(count > maxCount) maxCount = count;
            }
        }
        return maxCount;
    }
}
