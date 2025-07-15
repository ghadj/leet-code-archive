/**
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
 * @see <a href="https://leetcode.com/problems/leaf-similar-trees">LeetCode</a>
 */
class SolutionB {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root1);
        stack2.push(root2);
        
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            Integer leaf1 = getNextLeaf(stack1);
            Integer leaf2 = getNextLeaf(stack2);

            if (leaf1 == null || leaf2 == null || !leaf1.equals(leaf2))
                return false;
        }
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private Integer getNextLeaf(Stack<TreeNode> stack) {
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            
            if (isLeaf(node)) return node.val;
            
            // Push right first so that left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return null; // No more leaves
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}