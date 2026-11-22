class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] seq = new int[n];
        int[] state = new int[n + 1];
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[] cycle = dfs(graph, seq, state, 1, 0);
        List<int[]> candidates = new ArrayList<>();
        int end = cycle[1], start = cycle[0];
        candidates.add(new int[]{Math.min(start, end), Math.max(start, end)});
        while (seq[end] != start) {
            int u = seq[end];
            int small = Math.min(u, end), big = Math.max(u, end);
            candidates.add(new int[]{small, big});
            end = u;
        }
        int[] best = new int[]{};
        int bestIdx = -1;
        for (int[] c : candidates) {
            boolean found = false;
            for (int i = n - 2; i >= 0; i--) {
                if (Arrays.equals(c, edges[i])) {
                    if (i > bestIdx) {
                        bestIdx = i;
                        best = c;
                        found = true;
                    }
                }
                if (found || i <= bestIdx) break;
            }
        }
        return best;
    }

    public int[] dfs(Map<Integer, List<Integer>> graph, int[] seq, int[] state, int curr, int parent) {
        state[curr] = 1;
        seq[curr] = parent;
        for (int nbr : graph.get(curr)) {
            if (nbr == parent) continue;
            if (state[nbr] == 1) {
                return new int[]{nbr, curr};
            } else if (state[nbr] == 0) {
                int[] run = dfs(graph, seq, state, nbr, curr);
                if (run.length > 0) return run;
            }
        }
        state[curr] = 2;
        return new int[]{};
    }
}
