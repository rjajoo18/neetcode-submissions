class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < cars.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(cars[cars.length - 1]);
        for (int i = cars.length - 2; i >= 0; i--) {
            if (!stack.isEmpty() && (double)(target - stack.peek()[0]) / stack.peek()[1] < (double)(target - cars[i][0])/cars[i][1]) {
                stack.push(cars[i]);
            }
        }
        return stack.size();
    }
}
