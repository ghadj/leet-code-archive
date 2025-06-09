/**
 * ---
 * [https://leetcode.com/problems/delete-node-in-a-bst]
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
 * Return the root node reference (possibly updated) of the BST.
 *
 * The deletion can be divided into two stages:
 * - Search for a node to remove.
 * - If the node is found, delete the node.
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

    public TreeNode deleteNode(TreeNode node, int key) {
        if (node == null) return null;

        if (key < node.val) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.val) {
            node.right = deleteNode(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: get the inorder successor (smallest in the right subtree)
            node.val = minValue(node.right);
            // Delete the inorder successor
            node.right = deleteNode(node.right, node.val);
        }
        return node;
    }

    private int minValue(TreeNode node) {
        int minVal = node.val;
        while (node.left != null) {
            minVal = node.left.val;
            node = node.left;
        }
        return minVal;
    }
}