// Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    
    public void preorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.val);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
}


// Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            res.add(cur.val);
            if (cur.right != null) s.push(cur.right);
            if (cur.left != null) s.push(cur.left);
        }
        
        return res;
    }
}