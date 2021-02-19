class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}

// *********************
// Another solution:
// *********************

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[3];
        res[1] = k;
        res[2] = 0;
        kthSmallestAux(root, res);
        return res[0];
    }
    
    public void kthSmallestAux(TreeNode root, int[] res) {
        if (res[2] == 1) return;
        
        if (root.left != null) {
            kthSmallestAux(root.left, res);
        }
        
        if (res[1] == 1 && res[2] != 1) {
            res[0] = root.val;
            res[2] = 1;
        }
        else {
            res[1]--;
            if (root.right != null) {
                kthSmallestAux(root.right, res);
            }
        }
    }
}

