public /**
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
       ListNode currentL1 = l1;
       ListNode currentL2 = l2;
       int plus1 = 0;
       ListNode result = new ListNode();
       ListNode currentNode = result;
       ListNode previousNode = null;
       
       while (currentL1 != null && currentL2 != null) {           
           currentNode.val = ((currentL1.val + currentL2.val + plus1) % 10);
           
           if (previousNode != null)
               previousNode.next = currentNode;
           
           previousNode = currentNode;
           currentNode = new ListNode();
           
           if (currentL1.val + currentL2.val + plus1 >= 10)
               plus1 = 1;
           else
               plus1 = 0;
           
           currentL1 = currentL1.next;
           currentL2 = currentL2.next;
       }
       
       while (currentL1 != null) {
           currentNode.val = (currentL1.val + plus1) % 10;
           
           if (previousNode != null)
               previousNode.next = currentNode;
           
           previousNode = currentNode;
           currentNode = new ListNode();
           
           if (currentL1.val + plus1 >= 10)
               plus1 = 1;
           else
               plus1 = 0;
           
           currentL1 = currentL1.next;
       }
       
       while (currentL2 != null) {
           currentNode.val = (currentL2.val + plus1) % 10;
           
           if (previousNode != null)
               previousNode.next = currentNode;
           
           previousNode = currentNode;
           currentNode = new ListNode();
           
           if (currentL2.val + plus1 >= 10)
               plus1 = 1;
           else
               plus1 = 0;
           
           currentL2 = currentL2.next;
       }
       
       if (plus1 > 0) {
           currentNode.val = plus1;
           
           if (previousNode != null)
               previousNode.next = currentNode;
       }
       
       
       return result;
   }
}class AddTwoNumbers {
    
}
