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
        ListNode head = new ListNode();
        ListNode ptr = head;
        int nullCounter = lists.length;
        while (true)
        {
            int minMarker = 0;
            for(int i = 0; i< lists.length ; i++)
            {
                if (lists[i] == null){
                    nullCounter --;
                    if(lists[minMarker] == null)
                    {
                       minMarker += 1;
                    }
                    continue;
                }
                if(lists[minMarker].val >= lists[i].val && minMarker != i)
                {
                    minMarker = i;
                }
            }
            if (nullCounter == 0) break;
            ptr.next = new ListNode(lists[minMarker].val);
            ptr = ptr.next;
            lists[minMarker] = lists[minMarker].next;
            nullCounter = lists.length;
        }
        return head.next;
    }
}
