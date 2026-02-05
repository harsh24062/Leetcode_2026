class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        
        for(int i=0;i<nums.length;i++){
            int shift = nums[i]%n;
            int index = (i+shift)%n;
            if(index<0) index+=n;
            result[i]=nums[index];
        }

        return result;
    }
}
