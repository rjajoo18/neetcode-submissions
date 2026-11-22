class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = Math.min(heights[l], heights[r]) * (r - l);

        while(l < r){
            if(heights[l] >= heights[r]){
                r--;
            } else {
                l++;
            }
            int area = Math.min(heights[l], heights[r]) * (r - l);
            if(area > maxArea) maxArea = area;
        }

        return maxArea;
    }
}
