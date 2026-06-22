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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode res = root;

        while(res != null){

            if(p.val > res.val && q.val > res.val){
                res = res.right;
            }
            else if(p.val < res.val && q.val < res.val){
                res = res.left;
            }
            else{
                return res;
            }
        }
        
        return res;
        
    }
}
