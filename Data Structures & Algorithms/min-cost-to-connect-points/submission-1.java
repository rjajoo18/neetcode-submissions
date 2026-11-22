class Solution {

    private class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Edge {
        private Point p;
        private int distance;

        public Edge(Point p, int distance) {
            this.p = p;
            this.distance = distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<Point> graph = new ArrayList<>();
        for (int[] p : points) {
            graph.add(new Point(p[0], p[1]));
        }
        Set<Point> seen = new HashSet<>();
        int total = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distance, b.distance)
        );
        pq.add(new Edge(graph.get(0), 0));
        while (seen.size() < graph.size()) {
            Edge currEdge = pq.poll();
            Point currPoint = currEdge.p;
            if (!seen.contains(currPoint)) {
                seen.add(currPoint);
                int currDist = currEdge.distance;
                total += currDist;
                for (Point p : graph) {
                    if (!seen.contains(p)) {
                        pq.offer(new Edge(p, distance(p, currPoint)));
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
