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

    TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p == null){
            return q;
        }

        if(q == null){
            return p;
        }

        res = root;

        findLCA(root,p,q);

        return res;
    }

    private void findLCA(TreeNode root,TreeNode p,TreeNode q){
        if(root == null){
            return;
        }

        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)){
            res = root;
            return;
        }

        if(p.val == root.val && (q.val > p.val || q.val < p.val)){
            res = p;
            return;
        }

        if(q.val == root.val && (p.val > q.val || p.val < q.val)){
            res = q;
            return;
        }

        if(p.val > root.val && q.val > root.val){
            findLCA(root.right,p,q);
        } else {
            findLCA(root.left,p,q);
        }

    }
}
