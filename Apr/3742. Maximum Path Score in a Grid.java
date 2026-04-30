//recurion
class Solution {
    int m,n;
    int dp[][][];
    int solve(int row, int col, int grid[][], int k, int cost){
        if(row>=m || col>=n)return -1000000007;
        int newCost = cost + ((grid[row][col]==0)?0:1);
        if(newCost>k)return -1000000007;
        if(row==m-1 && col==n-1){
            return grid[row][col];
        }
        
        if(dp[row][col][cost]!=Integer.MIN_VALUE) return dp[row][col][cost];
        // right
        int right = grid[row][col]+solve(row,col+1,grid,k,newCost);
        //down
        int left = grid[row][col]+solve(row+1,col,grid,k,newCost);

        return dp[row][col][cost]= Math.max(right,left);
    }
    public int maxPathScore(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        dp = new int[m][n][k+1];
        for(int d[][]:dp){
            for(int arr[]:d){
                Arrays.fill(arr,Integer.MIN_VALUE);
            }
        }
        int value = solve(0,0,grid,k,0);
        return (value<0?-1:value);
    }
}
