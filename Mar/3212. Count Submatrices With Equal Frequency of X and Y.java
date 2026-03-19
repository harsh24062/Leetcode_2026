class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int x[][] = new int[rowLen][colLen];
        int y[][] = new int[rowLen][colLen];
        int count=0;
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                x[i][j] = (grid[i][j]=='X')?1:0;
                y[i][j] = (grid[i][j]=='Y')?1:0;
                if(i>0){
                   x[i][j]+=x[i-1][j];
                   y[i][j]+=y[i-1][j];
                }
                if(j>0){
                   x[i][j]+=x[i][j-1];
                   y[i][j]+=y[i][j-1];
                }
                if(i>0 && j>0){
                   x[i][j]-=x[i-1][j-1];
                   y[i][j]-=y[i-1][j-1];
                }
                if(x[i][j]>0 && x[i][j]==y[i][j])count++;
            }
        }
        return count;
    }
}
