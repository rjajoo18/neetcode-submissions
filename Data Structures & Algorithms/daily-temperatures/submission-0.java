class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> temps = new Stack<>();
        Stack<Integer> idx = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            while(!temps.isEmpty() && temperatures[i] > temps.peek()){
                res[idx.peek()] = i - idx.pop();
                temps.pop();
            }
            temps.add(temperatures[i]);
            idx.add(i);
        }
        return res;
    }
}
