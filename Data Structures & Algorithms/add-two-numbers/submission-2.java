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
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int curr = 0, carry = 0;
        while(l1 != null && l2 != null) {
            curr = (l1.val + l2.val + carry) % 10;           
            res.next = new ListNode(curr);
            carry = (l1.val + l2.val + carry) / 10; 
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 == null && l2 != null) {
            while(l2 != null) {
                res.next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                res = res.next;
                l2 = l2.next;
            }
        } else if (l1 != null && l2 == null) {
                while(l1 != null) {
                    res.next = new ListNode((l1.val + carry) % 10);
                    carry = (l1.val + carry) / 10;
                    res = res.next;
                    l1 = l1.next;
                }
        }
        if (carry != 0) {
            res.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
