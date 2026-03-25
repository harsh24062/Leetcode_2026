class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long colSum[] = new long[n];
        long rowSum[] = new long[m];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               colSum[j]+=grid[i][j];
               rowSum[i]+=grid[i][j];
            }
        }

        // total
        long colT=0L;
        long rowT=0L;
        for(int i=0;i<m;i++)rowT+=rowSum[i];
        for(int i=0;i<n;i++)colT+=colSum[i];

        long curColSum=0L;
        long curRowSum=0L;

        for(int i=0;i<m;i++){
            curRowSum+=rowSum[i];
            if(curRowSum==rowT-curRowSum)return true;
        }
        for(int i=0;i<n;i++){
            curColSum+=colSum[i];
            if(curColSum==colT-curColSum)return true;
        }
        return false;
    }
}
