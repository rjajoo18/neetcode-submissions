class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, maxL = height[l], maxR = height[r], count = 0;
        while(l < r) {
            if(maxL <= maxR) {
                l++;
                maxL = Math.max(maxL, height[l]);
                int amt = maxL - height[l];
                if(amt > 0) {
                    count += amt;
                }
            } else {
                r--;
                maxR = Math.max(maxR, height[r]);
                int amt = maxR - height[r];
                if(amt > 0) {
                    count += amt;
                }
            }
        }
        return count;
    }
}
