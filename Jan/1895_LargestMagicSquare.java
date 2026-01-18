class Solution {
    int m,n;
        boolean isMagic(int sr, int sc, int er, int ec, int[][] grid){
      //check daigonal
       int d1=0;
       int i=sr;
       int j=sc;
       while(i<=er && j<=ec){
         d1+=grid[i][j];
         i++;
         j++;
      }

       int d2=0;
       i=er;
       j=sc;
       while(i>=sr && j<=ec){
         d2+=grid[i][j];
         i--;
         j++;
       }

       if(d1!=d2)return false;

      //check rows
      //check cols

      int cols[]=new int[er-sr+1];
      int rows[]=new int[er-sr+1];

      for(int row=sr;row<=er;row++){
        for(int col=sc;col<=ec;col++){
            int value=grid[row][col];
            cols[col-sc]+=value;
            rows[row-sr]+=value;
        }
      }

      for(int k=1;k<rows.length;k++){
        if(cols[k]!=cols[k-1] || rows[k]!=rows[k-1])return false;
      }

      if(d1!=rows[0] || d2!=cols[0])return false;

      return true;

    }
    public int largestMagicSquare(int[][] grid) {
       m = grid.length; 
       n = grid[0].length;

       int ans=0;

       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            int row=i;
            int col=j;
            while(row<m && col<n){
                if(isMagic(i,j,row,col,grid)){
                    ans = Math.max(ans,row-i+1);
                }
                row++;
                col++;
            }
        }
       }
       
       return ans;
    }
}
