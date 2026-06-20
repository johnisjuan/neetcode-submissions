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
    
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        hcheck(root);
        return res;

    }

    private int hcheck(TreeNode root){
        if(root == null){
            return 0;
        }

        int lheight = hcheck(root.left);
        int rheight = hcheck(root.right);

        int hdiff = Math.abs(lheight - rheight);

        if(hdiff > 1){
            res = false; 
        }

        return Math.max(lheight,rheight) + 1;
    }

}
