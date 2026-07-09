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

    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        findsum(root);

        return res;
    }

    private int findsum(TreeNode root){

        if(root == null){
            return 0;
        }

        int lgain = Math.max(0,findsum(root.left));
        int rgain = Math.max(0,findsum(root.right));

        int throughRoot = root.val + rgain + lgain;

        res = Math.max(res,throughRoot);

        return root.val + Math.max(lgain,rgain);
    }
}
