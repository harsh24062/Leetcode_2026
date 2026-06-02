class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int time=Integer.MAX_VALUE;
        int n1=landStartTime.length;
        int n2=waterStartTime.length;
        for(int i=0;i<n1;i++){ // land
           int lStart=landStartTime[i];
           int lTime=landDuration[i];
            for(int j=0;j<n2;j++){ // water
             int curTime=0;
             int wStart=waterStartTime[j];
             int wTime=waterDuration[j];
              if(lStart<=wStart){
                curTime=lStart+lTime;
                if(wStart<=curTime)curTime+=wTime;
                else curTime=wStart+wTime;
              }else{
                curTime=wStart+wTime;
                if(lStart<=curTime)curTime+=lTime;
                else curTime=lStart+lTime;
              }
              time=Math.min(time,curTime);
            }
        }
        return time;
    }
}
