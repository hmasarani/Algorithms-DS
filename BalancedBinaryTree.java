/**
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
    public boolean isBalanced(TreeNode root) {
        // DFS algorithm: look through every node and return + 1;
        if(root == null){
            return true;
        }
        if(dfs(root)==-1){
            return false;
        }
        else{
        return true;
        }
    }
    public int dfs(TreeNode node){

        if(node == null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if(Math.abs(left-right) > 1 || left == -1 || right == -1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}
