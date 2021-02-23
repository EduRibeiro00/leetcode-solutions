class Solution {
    private ListNode head;
    
    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);
        this.head = head;
        return convertListToBST(0, size - 1);
    }
    
    private int findSize(ListNode head) {
        ListNode ptr = head;
        int len = 0;
        while (ptr != null) {
            ptr = ptr.next;
            len++;
        }
        return len;
    }
    
    private TreeNode convertListToBST(int l, int r) {
        if (l > r) {
            return null;
        }
        
        int mid = l + (r - l) / 2;
        
        // first step of the simulated inorder traversal 
        TreeNode left = this.convertListToBST(l, mid - 1);
            
        // once left half is traversed, process current node
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        
        this.head = this.head.next;
        
        // recursive on the right subtree
        node.right = this.convertListToBST(mid + 1, r);
        
        return node;
    }
}