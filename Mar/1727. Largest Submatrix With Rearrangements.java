class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
               if(matrix[i][j]==1 && i>0){
                 matrix[i][j]=matrix[i][j]+matrix[i-1][j];
               }
            }

            int curRow[] = matrix[i].clone();
            Arrays.sort(curRow);
            for(int base=n-1;base>=0;base--){
                result=Math.max(result,curRow[base]*(n-base));
            }
        }

       return result;
    }
}
