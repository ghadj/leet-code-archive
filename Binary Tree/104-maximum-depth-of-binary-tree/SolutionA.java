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

        int maxDepth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        
        stack.push(root);
        depths.push(1);
        
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            int currentDepth = depths.pop();
            
            if (currentNode != null) {
                maxDepth = Math.max(maxDepth, currentDepth);
                stack.push(currentNode.left);
                depths.push(currentDepth + 1);
                stack.push(currentNode.right);
                depths.push(currentDepth + 1);
            }
        }
        
        return maxDepth;
    }
}