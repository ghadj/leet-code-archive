/**
 * ---
 * [https://leetcode.com/problems/count-good-nodes-in-binary-tree]
 * 1448. Count Good Nodes in Binary Tree
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 *
 * Return the number of good nodes in the binary tree.
 * ---
 */
class Solution {
    
    private int dfs(TreeNode node, int maxValue) {
        if (node == null)
            return 0;
        
        int count = 0;
        if (node.val >= maxValue)
            count = 1;
        
        int newMax = Math.max(maxValue, node.val);
        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);        
        return count;
    }
    
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}
