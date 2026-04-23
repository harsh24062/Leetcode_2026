class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long ans[] = new long[n];
        Map<Integer,Long> indexFreq = new HashMap<>();
        Map<Integer,Long> indexSum = new HashMap<>();
        
        //prefix
        for(int i=0;i<nums.length;i++){
            long freq = indexFreq.getOrDefault(nums[i],0L);
            long sum = indexSum.getOrDefault(nums[i],0L);

            ans[i]+=(freq*i) - sum;
            indexFreq.put(nums[i],freq+1);
            indexSum.put(nums[i],sum+i);
        }

        indexFreq.clear();
        indexSum.clear();

        //suffix
        for(int i=n-1;i>=0;i--){
            long freq = indexFreq.getOrDefault(nums[i],0L);
            long sum = indexSum.getOrDefault(nums[i],0L);

            ans[i]+=sum-(freq*i);
            indexFreq.put(nums[i],freq+1);
            indexSum.put(nums[i],sum+i);
        }
        return ans;
    }
}

// prefix
// x y z (calculate answer for z)
// => (z-y)+(z-x)
// => 2*z - (y+z)

// 2 is indexFreq before z and y+z is sum of same digit before z
