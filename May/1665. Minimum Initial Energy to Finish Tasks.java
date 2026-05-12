class Solution {
    boolean isPossible(int[][] tasks, int mid){
        for(int t[]:tasks){
            if(t[1]>mid)return false;
            mid-=t[0];
        }
        return true;
    }
    public int minimumEffort(int[][] tasks) {
        int totalSum=0;
        int maxMin=0;
        for(int t[]:tasks){
            totalSum+=t[0];
            maxMin=Math.max(maxMin,t[1]);
        }


        int left=totalSum;
        int right=totalSum+maxMin;

         Arrays.sort(tasks, (task1, task2) -> {
            int diff1 = task1[1] - task1[0];
            int diff2 = task2[1] - task2[0];

            return diff2 - diff1;
        });


        int result=0;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(isPossible(tasks,mid)){
               result=mid;
               right = mid-1;
            }else{
              left = mid+1;
            }
        }
        return result;
    }
}
