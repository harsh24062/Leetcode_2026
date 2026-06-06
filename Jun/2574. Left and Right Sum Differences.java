class Solution {
    public int[] leftRightDifference(int[] nums) {
        int totalSum=0;
        for(int i:nums)totalSum+=i;
        int leftSum=0;
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            totalSum-=nums[i];
            ans[i]=Math.abs(totalSum-leftSum);
            leftSum+=nums[i];
        }
        return ans;
    }
}
