/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);

        Node curr1 = head;
        while(curr1 != null) {
            Node copy = new Node(curr1.val);
            map.put(curr1, copy);
            curr1 = curr1.next;
        }

        Node curr2 = head;
        while(curr2 != null) {
            Node copy = map.get(curr2);
            copy.next = map.get(curr2.next);
            copy.random = map.get(curr2.random);
            curr2 = curr2.next;
        }

        return map.get(head);
    }
}
