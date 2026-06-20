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

    boolean res = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null){
            return true;
        }

        if(root == null){
            return false;
        }

        if(root.val == subRoot.val){
            res = checkSubTree(root,subRoot);

            if(res) return true;

        }

        isSubtree(root.left,subRoot);
        isSubtree(root.right,subRoot);

        return res;
    }

    private boolean checkSubTree(TreeNode root,TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }

        if(root == null || subRoot == null){
            return false;
        }

        boolean lcheck = checkSubTree(root.left,subRoot.left);
        boolean rcheck = checkSubTree(root.right,subRoot.right);
    
        boolean fcheck = false;

        if(root.val == subRoot.val){
            fcheck = true;
        } else {
            fcheck = false;
        }

        if(lcheck && rcheck && fcheck){
            return true;
        } else {
            return false;
        }
    }
}
