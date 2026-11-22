/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0, head);
        ListNode slow = res, fast = res;
        while (fast != null) {
            for (int i = 0; i < k; i++) {
                fast = fast.next;
                if (fast == null) {
                    return res.next;
                }
            }
            ListNode next = fast.next;
            fast.next = null;
            ListNode segment = slow.next;
            slow.next = reverse(segment);
            slow = segment;
            fast = slow;
            fast.next = next;
        }
        return res.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}