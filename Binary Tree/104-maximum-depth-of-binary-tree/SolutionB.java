import java.util.Stack;

/**
 * ---
 * [https://leetcode.com/problems/maximum-depth-of-binary-tree]
 * 104. Maximum Depth of Binary Tree
 * ---
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        // Return the maximum of the two depths plus one for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}