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
    int sum;
    void recur(TreeNode node, String binary){
        if(node==null)return;
        String newBinary = binary+node.val;
        if(node.left==null && node.right==null){
            sum+=Integer.parseInt(newBinary,2);
            return;
        }
        recur(node.left,newBinary);
        recur(node.right,newBinary);
    }
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        recur(root,"");
        return sum;
    }
}


class Solution {
    int sum;
    void recur(TreeNode node, int binary){
        if(node==null)return;
        binary = (binary<<1)|node.val;
        if(node.left==null && node.right==null){
            sum+=binary;
            return;
        }
        recur(node.left,binary);
        recur(node.right,binary);
    }
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        recur(root,0);
        return sum;
    }
}
