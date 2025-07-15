/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * 
 * The deletion can be divided into two stages:
 * - Search for a node to remove.
 * - If the node is found, delete the node.
 * 
 * Definition for a binary tree node.
 * 
 * ```java
 * public class TreeNode {
 *     
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * 
 *     TreeNode() {}
 *     
 *     TreeNode(int val) { this.val = val; }
 *     
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * ```
 *
 * @see <a href="https://leetcode.com/problems/delete-node-in-a-bst">LeetCode</a>
 */
class Solution {

    private TreeNode getNextNode(TreeNode node) {
        if (node == null) return null;
        if (node.right == null) return node.left;
        TreeNode leftMostLeaf = getLeftMostLeaf(node.right);
        leftMostLeaf.left = node.left;
        leftMostLeaf.right = node.right == leftMostLeaf ? node.right.right : node.right;
        return leftMostLeaf;
    }

    private TreeNode getLeftMostLeaf(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node;
        while (node.left.left != null) node = node.left;
        TreeNode leaf = node.left;
        node.left = getNextNode(node.left);
        return leaf;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val == key) return getNextNode(root);

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null && curr.left.val == key) {
                curr.left = getNextNode(curr.left);
                break;
            } else if (curr.right != null && curr.right.val == key){
                curr.right = getNextNode(curr.right);
                break;
            }
            curr = curr.val < key ? curr.right : curr.left;
        }

        return root;
    }
}