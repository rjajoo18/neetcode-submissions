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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        ListNode merged = mergeLists(lists[0], lists[1]);
        for(int i = 2; i < lists.length; i++) {
            merged = mergeLists(merged, lists[i]);
        }
        return merged;
    }

    public ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode merge = dummy;
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null) {
            if(curr1.val <= curr2.val) {
                merge.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                merge.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            merge = merge.next;
        }
        if(curr1 != null) {
            merge.next = curr1;
        }
        else if(curr2 != null) {
            merge.next = curr2;
        }
        return dummy.next;
    }
}
