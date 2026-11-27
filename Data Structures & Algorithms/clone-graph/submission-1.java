/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        dfs(map, visited, node);
        return map.get(node);
    }

    private Node dfs(Map<Node, Node> map, Set<Integer> visited, Node curr) {
        if (curr == null) return null;
        if (visited.contains(curr.val)) return map.get(curr);
        visited.add(curr.val);
        ArrayList<Node> neighbors = new ArrayList<>();
        Node node = new Node(curr.val, neighbors);
        map.put(curr, node);
        for (Node nbr : curr.neighbors) {
            neighbors.add(dfs(map, visited, nbr));
        }
        return node;
    }
}