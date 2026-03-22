class Solution {
     public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // transpose
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
               int temp = matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=temp;
            }
        }
       
       // reverse every row
       for(int i=0;i<n;i++){
        for(int j=0;j<n/2;j++){
            int temp = matrix[i][j];
            matrix[i][j]=matrix[i][n-j-1];
            matrix[i][n-j-1]=temp;
        }
       }

    }

    boolean check(int mat[][], int target[][]){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat.length;j++){
                if(mat[i][j]!=target[i][j])return false;
            }
        }
        return true;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        if(check(mat,target))return true;
        // there will be 4 rotations
        for(int i=0;i<=2;i++){
            rotate(mat);
            if(check(mat,target))return true;
        }
        return false;
    }
}
