class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n1=landStartTime.length;
        int n2=waterStartTime.length;
        int land_water=Integer.MAX_VALUE;
        int water_land=Integer.MAX_VALUE;
        int land=Integer.MAX_VALUE;
        int water=Integer.MAX_VALUE;
        for(int i=0;i<n1;i++){
            land=Math.min(land,landStartTime[i]+landDuration[i]);
        }
        for(int i=0;i<n2;i++){
            water=Math.min(water,waterStartTime[i]+waterDuration[i]);
            land_water=Math.min(land_water,Math.max(land,waterStartTime[i])+waterDuration[i]);
        }
        for(int i=0;i<n1;i++){
            water_land=Math.min(water_land,Math.max(water,landStartTime[i])+landDuration[i]);
        }

        return Math.min(land_water,water_land);
    }
}
