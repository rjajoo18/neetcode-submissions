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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode node){
        if(node == null) return 0;
        int left = getHeight(node.left), right = getHeight(node.right);
        int height = 1 + Math.max(left, right);
        int diam = left + right;
        if(diam > max) max = diam;
        return height;
    }
}
