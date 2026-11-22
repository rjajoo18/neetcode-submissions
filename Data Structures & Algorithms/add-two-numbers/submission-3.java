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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode dummy = res;
        int carry = 0, curr = 0;
        while (l1 != null && l2 != null) {
            curr = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            dummy.next = new ListNode(curr);
            dummy = dummy.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            curr = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            dummy.next = new ListNode(curr);
            dummy = dummy.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            curr = (l2.val + carry) % 10;
            carry = (l2.val + carry) / 10;
            dummy.next = new ListNode(curr);
            dummy = dummy.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            dummy.next = new ListNode(carry);
        }
        return res.next;
    }
}
