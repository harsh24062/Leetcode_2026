class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int f_O = 0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            f_O = f_O + (i*nums[i]);
        }
        int max=f_O;
        for(int k=1;k<n;k++){
            int f_cur = f_O + sum - n*nums[n-k];
            max=Math.max(f_cur,max);
            f_O = f_cur;
        }
        return max;
    }
}

// calculate f(0) and f(1) by assuming [x,y,z,w] array
// subtract f(0) from f(1)
// equation comes => f[k] = f[k-1] + sum - n*nums[n-k]
// n is nums length
// sum is sum of elements in nums
