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

// in general, when doing something big, you should split it recursively into groups of 2 (like the power problem)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    public ListNode divide(ListNode[] lists, int l, int r) {
        if(l > r) return null;
        if(l == r) return lists[l];

        int mid = l + (r - l) / 2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid + 1, r);

        return conquer(left, right);
    }

    public ListNode conquer(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                merge.next = l1;
                l1 = l1.next;
            } else {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }
        if(l1 != null) {
            merge.next = l1;
        }
        else if(l2 != null) {
            merge.next = l2;
        }
        return dummy.next;
    }
}
