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
    int maxHeight;
    TreeNode ans;

    int height(TreeNode node,int level){
        if(node==null)return 0;

        int left = height(node.left,level+1);
        int right = height(node.right,level+1);

        if(left==right){
            int max = Math.max(left,level);
            if(max>=maxHeight){
               maxHeight=max;
               ans=node;
            }
        }
      return Math.max(level,Math.max(left,right));
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans=root;
        maxHeight=0;

        height(root,0);

        return ans;
    }
}
