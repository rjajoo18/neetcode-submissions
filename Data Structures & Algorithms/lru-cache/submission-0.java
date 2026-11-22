public class Node {
    private int key;
    private int val;
    private Node prev;
    private Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private Map<Integer, Node> map;
    private Node left;
    private Node right;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.left = new Node(0,0);
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            map.remove(key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        
        if (map.size() > capacity) {
            Node lru = this.left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
