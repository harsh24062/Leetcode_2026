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
    long totalSum;
    long ans;

    void findSum(TreeNode root){
        if(root==null)return ;
        totalSum+=root.val;
        findSum(root.left);
        findSum(root.right);
    }

    long findMax(TreeNode root){
        if(root==null)return 0;
        long left = findMax(root.left);
        long right = findMax(root.right);

        long sum = root.val+left+right;
        long product = sum*(totalSum-sum);
        ans=Math.max(ans,product);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        totalSum=0;
        ans=0;

        findSum(root);
        
        findMax(root);

        return (int)(ans%1000000007);
    }
}
