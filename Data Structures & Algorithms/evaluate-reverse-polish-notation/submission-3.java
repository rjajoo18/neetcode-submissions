class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first + second);
            } else if (t.equals("-")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            } else if (t.equals("*")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first * second);
            } else if (t.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}
