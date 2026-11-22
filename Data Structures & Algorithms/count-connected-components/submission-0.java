class Solution {

    public int countComponents(int n, int[][] edges) {
        int total = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                total++;
                dfs(map, visited, i);
            }
        }
        return total;
    }

    public void dfs(Map<Integer, List<Integer>> map, Set<Integer> visited, int curr) {
        for (int nbr : map.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(nbr)) {
                visited.add(nbr);
                dfs(map, visited, nbr);
            }
        }
    }
}
