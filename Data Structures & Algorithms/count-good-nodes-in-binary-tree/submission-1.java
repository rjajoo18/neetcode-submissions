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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        validate(root, Integer.MIN_VALUE);
        return count;
    }

    public void validate(TreeNode node, int currMax) {
        if(node == null) return;
        if(node.val >= currMax) {
            count++;
        }
        if(node.val > currMax) currMax = node.val;
        validate(node.left, currMax);
        validate(node.right, currMax);
    }
}
