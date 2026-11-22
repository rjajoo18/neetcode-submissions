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
    Integer prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> traversal = new ArrayList<>();
        inorder(root, traversal);
        for(int i = 1; i < traversal.size(); i++){
            if(traversal.get(i) <= traversal.get(i - 1)) return false;
        }
        return true;
    }

    public void inorder(TreeNode node, List<Integer> curr) {
        if(node == null) return;
        inorder(node.left, curr);
        curr.add(node.val);
        inorder(node.right, curr);
    }
}
