class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int area = r - l;
            if (heights[l] > heights[r]) {
                area *= heights[r];
                r--;
            } else {
                area *= heights[l];
                l++;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
