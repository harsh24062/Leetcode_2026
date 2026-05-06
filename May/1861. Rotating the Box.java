class Solution {
    int m,n;
    public char[][] rotateTheBox(char[][] boxGrid) {
        m = boxGrid.length;
        n = boxGrid[0].length;

        for(int i=0;i<m;i++){
            int j=0;
            int count=0;
            while(j<n){
              if(boxGrid[i][j]=='#'){count++; boxGrid[i][j]='.';}
              else if(boxGrid[i][j]=='*'){
               int k=j-1;
               while(count>0){
                boxGrid[i][k]='#';
                k--;
                count--;
               }
              }
              j++;
            }
            while(count-->0){
                boxGrid[i][--j]='#';
            }
        }

        char ans[][] = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
             ans[i][j]=boxGrid[m-1-j][i];
            }
        }
        return ans;
    }
}

