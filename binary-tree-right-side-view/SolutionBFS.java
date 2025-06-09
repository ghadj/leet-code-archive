/**
 * ---
 * [https://leetcode.com/problems/binary-tree-right-side-view]
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the
 * right side of it, return the values of the nodes you can see ordered
 * from top to bottom.
 * ---
 */
class SolutionBFS {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        List<Integer> result = new ArrayList<>();
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, root));

        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> node = queue.remove();
            Integer depth = node.getKey();
            TreeNode treeNode = node.getValue();

            if (result.size() <= depth)
                result.add(treeNode.val);

            if (treeNode.right != null)
                queue.add(new Pair(depth + 1, treeNode.right));

            if (treeNode.left != null)
                queue.add(new Pair(depth + 1, treeNode.left));
        }
        return result;
    }
}