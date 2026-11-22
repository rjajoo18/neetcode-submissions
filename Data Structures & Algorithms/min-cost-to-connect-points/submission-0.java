class Solution {

    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<Point> graph = new ArrayList<>();
        for (int[] p : points) {
            graph.add(new Point(p[0], p[1]));
        }
        Set<Point> seen = new HashSet<>();
        int total = 0;
        PriorityQueue<Object[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare((Integer) a[1], (Integer) b[1])
        );
        pq.add(new Object[]{graph.get(0), 0});
        while (seen.size() < graph.size()) {
            Object[] currObj = pq.poll();
            Point currPoint = (Point) currObj[0];
            if (!seen.contains(currPoint)) {
                seen.add(currPoint);
                int currDist = (Integer) currObj[1];
                total += currDist;
                for (Point p : graph) {
                    if (!seen.contains(p)) {
                        pq.offer(new Object[]{p, distance(p, currPoint)});
                    }
                }
            }
        }
        return total;
    }

    public int distance(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }
}
