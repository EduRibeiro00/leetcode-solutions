// Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }
    
    public void postorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.val);
    }
}


// Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.addFirst(node.val);
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
        }

        return ans;
    }
}