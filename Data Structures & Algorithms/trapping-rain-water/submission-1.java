class Solution {
    public int trap(int[] height) {
        int res = 0;
        if (height.length == 1) return res;
        int maxL = 0, l = 0, r = height.length - 1, maxR = 0;
        while (l < r) {
            int curr;
            if (height[l] <= height[r]) {
                curr = maxL - height[l];
                if (curr > 0) {
                    res += curr;
                }
                maxL = Math.max(maxL, height[l]);
                l++;
            } else {
                curr = maxR - height[r];
                if (curr > 0) {
                    res += curr;
                }
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }
        return res;
    }
}
