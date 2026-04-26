class Solution {
   int n;
   long perimeter;

   int findNextIndex(long arr[],int left,int right,long target){
       int ans = right;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
   }

   boolean canPick(int mid, long[] extended, int k){
       
       for(int i=0;i<n;i++){
         int count=1;
         int lastIdx = i;
         long lastPos = extended[lastIdx];
         
         for(int j=1;j<k;j++){
           long target = lastPos+mid;
           int nextIdx = findNextIndex(extended,lastIdx+1,i+n,target);
           if(nextIdx==i+n)break;
           lastIdx = nextIdx;
           lastPos = extended[lastIdx];
           count++;
         }
         if(count==k && (extended[i] + perimeter - lastPos >= mid))return true;
       }
       return false;
   }

    public int maxDistance(int side, int[][] points, int k) {
        n = points.length;
        perimeter = 4L * side;
        List<Long> arr = new ArrayList<>();

        for(int point[]:points){
           int x = point[0];
           int y = point[1];
           if(y==0)arr.add(1L*x);
           else if(x==side)arr.add(1L*side+y);
           else if(y==side)arr.add(3L*side-x);
           else arr.add(4L*side-y);
        }
        
        Collections.sort(arr);

        // Step 2: Duplicate array for circular handling
        long[] extended = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = arr.get(i);
            extended[i + n] = arr.get(i) + perimeter;
        }

        int ans=0;

        int left=0,right=2*side;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(canPick(mid,extended,k)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return ans;
    }
}
