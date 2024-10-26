class Solution {
    public int goodNodes(TreeNode root) {
        return this.dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode root, int max){
        if (root == null) {
            return 0;
        }

        int res = root.val >= max ? 1 : 0;  // Count node as a "good node" if root.val >= max
        max = Math.max(max, root.val);      // Update max for the path

        // Add good nodes found in left and right subtrees to res
        res += dfs(root.left, max);
        res += dfs(root.right, max);

        return res;  // Return total good nodes for this subtree
    }
}
