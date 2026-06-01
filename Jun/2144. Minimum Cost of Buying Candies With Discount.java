class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int value=0;
        int idx=n-1;
        while(idx>=0){
           value+=cost[idx];
           if(idx>0)value+=cost[idx-1];
           idx-=3; 
        }
        return value;
    }
}
