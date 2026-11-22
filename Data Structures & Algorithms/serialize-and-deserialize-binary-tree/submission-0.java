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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        dfsSerialize(root, res)    ;
        return res.toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder res) {
        if(root == null){
            res.append("N,");
            return;
        }
        res.append(root.val).append(",");
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] idx = new int[]{0};
        return dfs(arr, idx);        
    }

    private TreeNode dfs(String[] arr, int[] idx){
        if(idx[0] >= arr.length) return null;

        String token = arr[idx[0]++];
        if(token.equals("N")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = dfs(arr, idx);
        node.right = dfs(arr, idx);
        return node;
    }
}
