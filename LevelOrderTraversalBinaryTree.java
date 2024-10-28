class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        
        // base case: root is empty
        if (root == null) {
            return res;
        }
        
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode removed = queue.poll();  // Remove the front node
                list.add(removed.val);
                
                // Add children of the removed node to the queue
                if (removed.left != null) {
                    queue.add(removed.left);
                }
                if (removed.right != null) {
                    queue.add(removed.right);
                }
            }
            
            res.add(list);  // Add current level to result
        }
        
        return res;
    }
}
