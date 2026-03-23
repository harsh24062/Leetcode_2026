class Solution {
    int m,n;
    long ans=Integer.MIN_VALUE;

    void dfs(int row,int col, int[][] grid,long product){
      if(row<0 || col<0 || row==m || col==n)return ;
       if(product==0){ ans=Math.max(ans,0); return;}
      if(row==m-1 && col==n-1){
        ans=Math.max(ans,product*grid[row][col]);
        return;
      }

      //move right
      dfs(row,col+1,grid,product*grid[row][col]);
      //move down
      dfs(row+1,col,grid,product*grid[row][col]);

      
    }

    public int maxProductPath(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        
        dfs(0,0,grid,1);

        if(ans<0)return -1;
        return (int)(ans%1000000007);
    }
}



class Solution {
    Pair<Long,Long> dp[][];
    int mod=1000000007;

    Pair<Long,Long> solve(int i, int j, int grid[][]){
        if(i==grid.length-1 && j==grid[0].length-1){
            return new Pair((long)grid[i][j],(long)grid[i][j]);
        }
         if(dp[i][j]!=null)return dp[i][j];
        Long maxVal = Long.MIN_VALUE; 
        Long minVal = Long.MAX_VALUE; 

        if(i<grid.length-1){
            Pair<Long,Long> t = solve(i+1,j,grid);
            maxVal = Math.max(maxVal,Math.max(grid[i][j]*t.getKey(),grid[i][j]*t.getValue()));
            minVal = Math.min(minVal,Math.min(grid[i][j]*t.getKey(),grid[i][j]*t.getValue()));
        }
        if(j<grid[0].length-1){
            Pair<Long,Long> t = solve(i,j+1,grid);
            maxVal = Math.max(maxVal,Math.max(grid[i][j]*t.getKey(),grid[i][j]*t.getValue()));
            minVal = Math.min(minVal,Math.min(grid[i][j]*t.getKey(),grid[i][j]*t.getValue()));
        }

        dp[i][j] = new Pair(maxVal,minVal);
        return dp[i][j];
    }

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Pair[m][n];

        Pair<Long,Long> result = solve(0,0,grid);
        return result.getKey()<0?-1:(int)(result.getKey()%mod);
    }
}
