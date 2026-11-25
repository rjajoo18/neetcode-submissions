class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] t : times) {
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(new int[]{t[1], t[2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );
        pq.offer(new int[]{k, k, 0});
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            int[] currEdge = pq.poll();
            int currV = currEdge[1], dist = currEdge[2];
            if (distance[currV] < dist) continue;
            max = Math.max(max, dist);
            for (int[] edge : graph.getOrDefault(currV, new ArrayList<>())) {
                if (dist + edge[1] < distance[edge[0]]) {
                    pq.offer(new int[]{currV, edge[0], dist + edge[1]});
                    distance[edge[0]] = dist + edge[1];
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }
        return max;
    }
}
