class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int countN=0;
        int min=1000000007;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<0)countN++;
                min=Math.min(min,(int)Math.abs(matrix[i][j]));
                sum = sum + (int)Math.abs(matrix[i][j]);
            }
        }

        if(countN%2!=0) sum-=2*min;

        return sum;
    }
}
