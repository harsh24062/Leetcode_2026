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
    public TreeNode createBinaryTree(int[][] descriptions) {
       Map<Integer,TreeNode> nodeMap = new HashMap<>();
       Map<Integer,Integer> parMap = new HashMap<>();

       for(int i[]:descriptions){
         TreeNode node1=null;
         TreeNode node2=null;
         if(nodeMap.containsKey(i[0]))node1=nodeMap.get(i[0]);
         else node1=new TreeNode(i[0]);
         if(nodeMap.containsKey(i[1]))node2=nodeMap.get(i[1]);
         else node2=new TreeNode(i[1]);
         if(i[2]==1)node1.left=node2;
         else node1.right=node2;
         nodeMap.put(i[0],node1);
         nodeMap.put(i[1],node2);
         parMap.put(i[1],i[0]);
       }

       for(Map.Entry<Integer,TreeNode> k:nodeMap.entrySet()){
          int key = k.getKey();
          TreeNode value = k.getValue();
          if(!parMap.containsKey(key))return value;
       }
       return null;
    }
}
