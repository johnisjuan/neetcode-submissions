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
    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean lcheck = check(root.left,root.val,Integer.MIN_VALUE);
        boolean rcheck = check(root.right,Integer.MAX_VALUE,root.val);

        return lcheck && rcheck;
    }

    private boolean check(TreeNode root, int maxval,int minval){

        if(root == null){
            return true;
        }

        boolean lcheck = check(root.left,root.val,minval);
        boolean rcheck = check(root.right,maxval,root.val);

        boolean curcheck = root.val > minval && root.val < maxval;

        return curcheck && lcheck && rcheck;

    }
}
