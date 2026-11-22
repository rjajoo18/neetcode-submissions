class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] res = new int[n];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] p : prerequisites) {
            adjList.putIfAbsent(p[1], new ArrayList<>());
            adjList.get(p[1]).add(p[0]);
        }
        int[] state = new int[n];
        List<Integer> topSort = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (state[i] == 0) {
                if (!dfs(adjList, state, i, topSort)) return new int[]{};
            }
        }
        for (int i = 0; i < n; i++) {
            res[i] = topSort.removeFirst();
        }
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> adjList, int[] state, int curr, List<Integer> res) {
        state[curr] = 1;

        for (int nbr : adjList.getOrDefault(curr, new ArrayList<>())) {
            if (state[nbr] == 1) return false;
            else if (state[nbr] == 0) {
                if (!dfs(adjList, state, nbr, res)) return false;
            }
        }

        res.addFirst(curr);
        state[curr] = 2;

        return true;
    }
}
