// In my first solution I tried to do a Inorder traversal, but this one is better.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return aux(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean aux(TreeNode root, long lower, long upper) {
        if (root == null) return true;
        if (lower >= root.val || upper <= root.val) return false;
        
        return aux(root.left, lower, root.val) && aux(root.right, root.val, upper);
    }
   
}