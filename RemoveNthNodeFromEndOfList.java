// There is another solution, using two pointers
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int cnt = 0;
        while (cnt < n) {
            fast = fast.next;
            cnt++;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}

// Two loops; first one gets the length of list
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