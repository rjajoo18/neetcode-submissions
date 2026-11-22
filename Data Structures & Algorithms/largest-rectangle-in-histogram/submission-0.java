class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0, length = heights.length;
        
        for (int i = 0; i < length; i++) {
            int oldIdx = i;

            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int area = (i - stack.peek()[0]) * stack.peek()[1];
                maxArea = Math.max(maxArea, area);
                oldIdx = stack.pop()[0];
            }

            stack.push(new int[]{oldIdx, heights[i]});
        }

        while (!stack.isEmpty()) {
            int area = (length - stack.peek()[0]) * stack.pop()[1];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;        
    }
}
