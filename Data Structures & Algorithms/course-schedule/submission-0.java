class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] p : prerequisites) {
            adjList.putIfAbsent(p[0], new ArrayList<>());
            adjList.get(p[0]).add(p[1]);
        }

        boolean[] path = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjList, i, path, visited)) return false;
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adjList, int n, boolean[] path, boolean[] visited) {
        if (path[n]) return false;
        if (visited[n]) return true;

        path[n] = true;

        for (int nbr : adjList.getOrDefault(n, new ArrayList<>())) {
            if (!dfs(adjList, nbr, path, visited)) {
                return false;
            }
        }

        visited[n] = true;
        path[n] = false;

        return true;
    }
}
