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
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        cal(root);
        return res;
    }

    private int cal(TreeNode root){
        if(root == null) return 0;

        int lmax = cal(root.left);
        int rmax = cal(root.right);

        res = Math.max(res,lmax+rmax);

        return Math.max(lmax,rmax)+1;

    }
}