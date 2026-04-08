class Solution {
    int MOD=1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int q[]:queries){
            int index=q[0];
            int endIndex=q[1];
            int k=q[2];
            int v=q[3];
            while(index<=endIndex){
                nums[index] = (int)((1L*nums[index]*v)%MOD);
                index+=k;
            } 
        }
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        return xor;
    }
}
