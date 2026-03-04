class Solution {
    public int numSpecial(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;
        int count=0;

        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(mat[i][j]==1){
                    if(check(i,j,mat))count++;
                }
            }
        }
        return count;
    }

    boolean check(int row, int col, int mat[][]){
        //check row 
        for(int i=0;i<mat[0].length;i++){
            if(i!=col && mat[row][i]==1)return false;
        }
        //check col
        for(int i=0;i<mat.length;i++){
            if(i!=row && mat[i][col]==1)return false;
        }
        return true;
    }
}


// better 

class Solution {
    public int numSpecial(int[][] mat) {
        int rowLen = mat.length;
        int colLen = mat[0].length;

        int rowCount[] = new int[rowLen];
        int colCount[] = new int[colLen];
        int count=0;

        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(mat[i][j]==1){
                   rowCount[i]++;
                   colCount[j]++;
                }
            }
        }

        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                if(mat[i][j]==1 && rowCount[i]==1 && colCount[j]==1){
                   count++;
                }
            }
        }

        return count;
    }

   
}
