/**
 * # [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view)
 * 
 * Given the root of a binary tree, imagine yourself standing on the
 * right side of it, return the values of the nodes you can see ordered
 * from top to bottom.
 */
class SolutionDFS {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null)
            return;

        if (depth == result.size())
            result.add(node.val);

        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
