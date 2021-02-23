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
        ListNode dummyHead = new ListNode();
        int carry = 0;
        ListNode curNodeResult = dummyHead;
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        
        while (curNode1 != null || curNode2 != null) {
            int parcel1 = curNode1 != null ? curNode1.val : 0;
            int parcel2 = curNode2 != null ? curNode2.val : 0;
            
            int result = parcel1 + parcel2 + carry;
            carry = result / 10;
            result %= 10;
            
            ListNode nextNodeResult = new ListNode(result);
            curNodeResult.next = nextNodeResult;
            curNodeResult = nextNodeResult;
            curNode1 = curNode1 == null ? null : curNode1.next;
            curNode2 = curNode2 == null ? null : curNode2.next;
        }
        
        if (carry != 0) {
            ListNode nextNodeResult = new ListNode(carry);
            curNodeResult.next = nextNodeResult;
        }
        
        return dummyHead.next;
    }
}