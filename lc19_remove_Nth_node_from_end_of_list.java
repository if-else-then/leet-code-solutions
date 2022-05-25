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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1,p2;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        p2 = dummy;
        p1 = dummy;
        int i = 0;
        while (i<=n)
        {
            ++i;
            p1 = p1.next;
        }
        while(p1 != null)
        {
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return dummy.next;
    }
}
