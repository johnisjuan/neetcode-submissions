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

    public int goodNodes(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        countNodes(root.left,root.val);
        countNodes(root.right,root.val);

        return res + 1; 
    }

    private void countNodes(TreeNode node,int maxVal){
        
        if(node == null){
            return;
        }

        if(node.val >= maxVal){
            res++;
        }

        int pathMax = Math.max(maxVal,node.val);

        countNodes(node.left,pathMax);
        countNodes(node.right,pathMax);

    }
}
