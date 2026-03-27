class Solution {
      void reverse(int nums[][],int row ,int start, int end){
        int i=start;
        int j=end;

        while(i<j){
            int temp = nums[row][i];
            nums[row][i]=nums[row][j];
            nums[row][j]=temp;
            i++;
            j--;
        }
    }
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        int m = mat.length;
        k = k % n;
        int orig[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                orig[i][j]=mat[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
          if(i%2==0){
             reverse(mat,i,0,n-1);
             reverse(mat,i,0,k-1);
             reverse(mat,i,k,n-1);
          }else{
             reverse(mat,i,0,n-1);
             reverse(mat,i,0,n-k-1);
             reverse(mat,i,n-k,n-1);
          }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(orig[i][j]!=mat[i][j])return false;
            }
        }
        return true;
    }
}
