// O(1) space using two pointer approach (Floyd's cicle detection algorithm)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// DFS with hash set to keep visited
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (visited.contains(cur))
                return cur;
            visited.add(cur);
            cur = cur.next;
        }
        return null;
    }
}