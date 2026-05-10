class Solution {
    int dp[];
    int solve(int index, int nums[], int target){
        if(index==nums.length-1)return 0;
        if(dp[index]!=Integer.MAX_VALUE)return dp[index];
        int jumps=-1;
        for(int j = index+1;j<nums.length;j++){
          if(Math.abs(nums[j]-nums[index])<=target){
            jumps = Math.max(solve(j,nums,target)+1,jumps);
          }
        }
        if(jumps<0)return dp[index]=-1000000007;
        return dp[index]=jumps;
    }
    public int maximumJumps(int[] nums, int target) {
        dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int jumps = solve(0,nums,target);
        return (jumps<0)?-1:jumps;
    }
}
