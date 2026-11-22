class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < res.length; i++) {
            while(!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                res[stack.peek()[0]] = i - stack.pop()[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return res;
    }
}
