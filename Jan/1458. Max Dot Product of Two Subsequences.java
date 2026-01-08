class Solution {
    int recur(int index1,int index2, int nums1[], int nums2[],int dp[][]){
        if(index1==nums1.length || index2==nums2.length)return -100000000;
        if(dp[index1][index2]!=-100000000)return dp[index1][index2];
        int val=nums1[index1]*nums2[index2];
        // pick
        int pick = val+recur(index1+1,index2+1,nums1,nums2,dp);
        // dontPick
        int dontPick2 = recur(index1,index2+1,nums1,nums2,dp);
        int dontPick1 = recur(index1+1,index2,nums1,nums2,dp);

        return dp[index1][index2]=Math.max(pick,Math.max(dontPick1,Math.max(dontPick2,val)));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int dp[][] = new int[nums1.length][nums2.length];
        for(int d[]:dp){
            Arrays.fill(d,-100000000);
        }
        return recur(0,0,nums1,nums2,dp);
    }
}
