class Solution {
    long dp[][];
    long recur(int i, int j, List<Integer> robot, List<Integer> factoryList){
        if(i==robot.size())return 0;
        if(j==factoryList.size())return (long)Math.pow(10,12);
        
        if(dp[i][j]!=0)return dp[i][j];

        // pick the factory
        long pick = recur(i+1,j+1,robot,factoryList) + (long)Math.abs(robot.get(i)-factoryList.get(j));

        // dont pick
        long dontPick = recur(i,j+1,robot,factoryList);

        return dp[i][j]=Math.min(pick,dontPick);
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));

        List<Integer> factoryList = new ArrayList<>();
        for(int f[]:factory){
            int limit = f[1];
            while(limit-->0){
                factoryList.add(f[0]);
            }
        }
        dp = new long[robot.size()][factoryList.size()];
        return recur(0,0,robot,factoryList);
    }
}



// tabulation
class Solution {
    long dp[][];
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->Integer.compare(a[0],b[0]));

        List<Integer> factoryList = new ArrayList<>();
        for(int f[]:factory){
            int limit = f[1];
            while(limit-->0){
                factoryList.add(f[0]);
            }
        }
        dp = new long[robot.size()+1][factoryList.size()+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
               dp[i][j]=(long)Math.pow(10,12);
            }
        }

        for(int i=0;i<=factoryList.size();i++)dp[robot.size()][i]=0;

        for(int i=robot.size()-1;i>=0;i--){
            for(int j=factoryList.size()-1;j>=i;j--){
                // pick the factory
                long pick = dp[i+1][j+1] + (long)Math.abs(robot.get(i)-factoryList.get(j));
                // dont pick
                long dontPick = dp[i][j+1];
                dp[i][j]=Math.min(pick,dontPick);
            }
        }

        return dp[0][0];
    }
}
