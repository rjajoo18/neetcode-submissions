class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int vertex = curr[0];
            int dist = curr[1];

            if (dist > distance[vertex]) continue;

            for (int[] nbr : graph.getOrDefault(vertex, new ArrayList<>())) {
                int next = nbr[0];
                int newDist = dist + nbr[1];

                if (newDist < distance[next]) {
                    distance[next] = newDist;
                    pq.offer(new int[]{next, newDist});
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(distance[i], res);
        }
        return res;
    }
}
