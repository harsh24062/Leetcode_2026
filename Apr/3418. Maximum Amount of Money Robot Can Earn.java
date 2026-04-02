// memorization
class Solution {
    int m,n;
    int dp[][][];
    int recur(int row, int col, int coins[][], int neutralize){
        // destination reached
       if(row==m-1 && col==n-1){
        if(coins[row][col]>=0)return coins[row][col];
        return (neutralize>0)?0:coins[row][col];
       }
       
       // out of bound
       if(row==m || col==n)return Integer.MIN_VALUE;
       if(dp[row][col][neutralize]!=Integer.MIN_VALUE)return dp[row][col][neutralize];
       // positive value
       if(coins[row][col]>=0){
         int down = recur(row+1,col,coins,neutralize);
         int right = recur(row,col+1,coins,neutralize);
         return dp[row][col][neutralize] = Math.max(down,right)+coins[row][col];
       }
       
       // negative value
       int isNeutralize=Integer.MIN_VALUE;
       if(neutralize>0){
         int down = recur(row+1,col,coins,neutralize-1);
         int right = recur(row,col+1,coins,neutralize-1);
         isNeutralize = Math.max(down,right);
       }

       int down = recur(row+1,col,coins,neutralize);
       int right = recur(row,col+1,coins,neutralize);
       int notNeutralize = Math.max(down,right)+coins[row][col];

       return dp[row][col][neutralize]=Math.max(notNeutralize,isNeutralize);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;
        dp = new int[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        return recur(0,0,coins,2);
    }
}
