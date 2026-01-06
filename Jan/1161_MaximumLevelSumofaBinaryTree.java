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
    List<Integer> list;
    void dfs(TreeNode root, int level){
        if(root==null)return;
        if(level==list.size()){
          list.add(root.val);
        }else{
          int val = list.get(level);
          list.set(level,root.val+val); 
        }

        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    public int maxLevelSum(TreeNode root) {
        list = new ArrayList<>();
        dfs(root,0);

        int max  = list.get(0);
        int ans=1;
        
        for(int i=1;i<list.size();i++){
            int val = list.get(i);
            if(val>max){
                max=val;
                ans=i+1;
            }
        }

        return ans;
    }
}
