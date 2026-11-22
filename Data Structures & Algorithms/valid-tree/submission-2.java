class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != (n - 1)) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            map.putIfAbsent(e[0], new ArrayList<>());
            map.putIfAbsent(e[1], new ArrayList<>());
            map.get(e[0]).add(e[1]);
            map.get(e[1]).add(e[0]);
        }

        int[] state = new int[n];
        if (!dfs(map, state, 0, -1)) return false;
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) return false;
        }
        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> map, int[] state, int curr, int parent) {
        state[curr] = 1;

        for (int nbr : map.getOrDefault(curr, new ArrayList<>())) {
            if (nbr != parent && state[nbr] == 1) return false;
            if (state[nbr] == 0) {
                if (!dfs(map, state, nbr, curr)) return false;
            }
        }

        state[curr] = 2;
        return true;
    }
}
