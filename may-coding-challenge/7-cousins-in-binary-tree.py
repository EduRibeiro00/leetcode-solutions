# In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

# Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

# We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

# Return true if and only if the nodes corresponding to the values x and y are cousins.

 

# Example 1:


# Input: root = [1,2,3,4], x = 4, y = 3
# Output: false
# Example 2:


# Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
# Output: true
# Example 3:



# Input: root = [1,2,3,null,4], x = 2, y = 3
# Output: false
 

# Constraints:

# The number of nodes in the tree will be between 2 and 100.
# Each node has a unique integer value from 1 to 100.


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root.val == x or root.val == y:
            return False
        
        depth_x, parent_x = self.findNode(x, 0, root)
        depth_y, parent_y = self.findNode(y, 0, root)
        return depth_x == depth_y and parent_x != parent_y
        
        
    def findNode(self, node_val: int, cur_depth: int, cur_node: TreeNode) -> [int, int]:
        """
        Returns the depth and the parent value.
        """ 
        # extract left and right children
        left_node = cur_node.left
        right_node = cur_node.right

        # found in direct children
        if (left_node is not None and left_node.val == node_val) or (right_node is not None and right_node.val == node_val):
            return [cur_depth, cur_node]

        # search with recursion on the left
        if left_node is not None:
            left_depth, left_parent = self.findNode(node_val, cur_depth+1, left_node)
            if left_depth != -1 and left_parent != -1:
                return left_depth, left_parent

        # search with recursion on the right
        if right_node is not None:
            return self.findNode(node_val, cur_depth+1, right_node)

        return -1, -1
                
                