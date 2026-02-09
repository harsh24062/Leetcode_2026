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
    List<Integer> inorderList; 
    TreeNode constructTree(int start,int end){
        if(end<start)return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(inorderList.get(mid));

        node.left=constructTree(start,mid-1);
        node.right=constructTree(mid+1,end);
        return node;
    }
    void inorder(TreeNode node){
        if(node==null)return;
        inorder(node.left);
        inorderList.add(node.val);
        inorder(node.right);
    }
    public TreeNode balanceBST(TreeNode root) {
        inorderList = new ArrayList<>();
        inorder(root);
        //System.out.print(inorderList);
        return constructTree(0,inorderList.size()-1);
    }
}
