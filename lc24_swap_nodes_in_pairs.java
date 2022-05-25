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
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        ListNode first = head;
        if (head.next == null) return head;
        ListNode second = head.next;
        
        first.next = swapPairs(second.next);
        second.next = first;
        return second;
    }
}
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Swap Nodes in Pairs.
Memory Usage: 40 MB, less than 84.81% of Java online submissions for Swap Nodes in Pairs.
*/
