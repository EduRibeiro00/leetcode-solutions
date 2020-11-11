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
        int listLength = 0;
        ListNode current = head;
        
        while (current != null) {
            current = current.next;
            listLength++;
        }
        
        int nFront = listLength - n;
        
        int cnt = 0;
        current = head;
        ListNode previous = null;
        
        while (current != null && cnt < nFront) {
            previous = current;
            current = current.next;
            cnt++;
        }
        
        if (previous != null) {
            previous.next = current.next;
        }
        
        return previous == null ? current.next : head;
    }
}