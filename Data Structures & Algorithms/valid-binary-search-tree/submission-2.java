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
    Long prev = null;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode node) {
        if(node == null) return true;
        if(!inorder(node.left)) return false;

        if(prev == null) {
            prev = (long) node.val;
        } else if (prev >= node.val) {
            return false;
        }
        prev = (long)node.val;

        return inorder(node.right);
    }
}
