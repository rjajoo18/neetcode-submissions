class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.putIfAbsent(f[0], new ArrayList<>());
            graph.get(f[0]).add(new int[]{f[1], f[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        q.offer(new int[]{src, 0});
        dist[src] = 0;
        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] nbr : graph.getOrDefault(curr[0], new ArrayList<>())) {
                    int v = nbr[0], newDist = curr[1] + nbr[1];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                        q.offer(new int[]{v, newDist});
                    }
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
