// O(1) space using two pointer approach (slow and fast)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            
            if (fastPointer == slowPointer)
                return true;
        }
        return false;
    }
}

// DFS with hash set to keep visited
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (visited.contains(cur))
                return true;
            
            visited.add(cur);
            cur = cur.next;
        }
        return false;
    }
}