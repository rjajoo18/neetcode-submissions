class Solution {

    private record Point(int x, int y) { }

    private record Edge(Point p1, Point p2, int dist) implements Comparable<Edge> {
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    private class DSU {
        private Map<Point, Point> roots;
        private Map<Point, Integer> size;

        public DSU (List<Point> points) {
            roots = new HashMap<>();
            size = new HashMap<>();
            for (Point p : points) {
                roots.put(p, p);
                size.put(p, 1);
            }
        }

        public Point find(Point p) {
            if (roots.get(p).equals(p)) {
                return p;
            }
            roots.put(p, find(roots.get(p)));
            return roots.get(p);
        }

        public boolean union(Point p1, Point p2) {
            Point r1 = find(p1);
            Point r2 = find(p2);

            if (r1.equals(r2)) return false;

            if (size.get(r1) <= size.get(r2)) {
                size.put(r2, size.get(r1) + size.get(r2));
                size.put(r1, 0);
                roots.put(r1, r2);
            } else {
                size.put(r1, size.get(r1) + size.get(r2));
                size.put(r2, 0);
                roots.put(r2, r1);
            }

            return true;
        }
    }


    public int minCostConnectPoints(int[][] points) {
        List<Point> pts = new ArrayList<>();
        for (int[] p : points) {
            pts.add(new Point(p[0], p[1]));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < pts.size() - 1; i++) {
            for (int j = i + 1; j < pts.size(); j++) {
                Point p1 = pts.get(i), p2 = pts.get(j);
                int dist = Math.abs(p1.x() - p2.x()) + Math.abs(p1.y() - p2.y());
                pq.offer(new Edge(p1, p2, dist));
            }
        }

        Set<Edge> mst = new HashSet<>();
        DSU dsu = new DSU(pts);
        int cost = 0;
        while (mst.size() < pts.size() - 1) {
            Edge curr = pq.poll();
            if (dsu.union(curr.p1(), curr.p2())) {
                mst.add(curr);
                cost += curr.dist();
            }
        }
        return cost;

    }
}
