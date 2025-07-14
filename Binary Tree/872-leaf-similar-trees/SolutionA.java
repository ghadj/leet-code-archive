/**
 * # [Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees)
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
 */
class SolutionA {

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private List<Integer> getLeaves(TreeNode root) {
        List<Integer> leaves = new LinkedList<>();
        if (root == null) return leaves;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
        
            if (isLeaf(node)) {
                leaves.add(node.val);
            } else {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            }
        }
        return leaves;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);
        return leaves1.equals(leaves2);
    }
}