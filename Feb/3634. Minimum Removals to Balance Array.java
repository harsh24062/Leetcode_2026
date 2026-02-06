class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int start=0,end=0;
        int maxLen=1;

        while(end<n){
            if(end-start+1==1){end++;continue;}

            while((long)nums[start]*k<nums[end]){
                start++;
            }
            maxLen=Math.max(maxLen,end-start+1);
            end++;
        }

        return n-maxLen;
    }
}
