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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode rev = reverse(second);
        ListNode first = head;
        

        while(rev != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = rev.next;
            first.next = rev;
            rev.next = firstNext;
            first = firstNext;
            rev = secondNext;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
