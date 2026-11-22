class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<Double> times = new Stack<>();
        for (int i = 0; i < position.length; i++) {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];
            times.push(time);
        }
        int count = 0;
        while (!times.isEmpty()) {
            double time = times.pop();
            while (!times.isEmpty() && times.peek() <= time) {
                times.pop();
            }
            count++;
        }
        return count;
    }
}
