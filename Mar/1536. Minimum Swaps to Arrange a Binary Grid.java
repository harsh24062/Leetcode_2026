class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int zeros[] = new int[n];

        for(int i=0;i<n;i++){
            int j=n-1;
            int count=0;
            while(j>=0 && grid[i][j]==0){
               count++;
               j--;
            }
            zeros[i]=count;
        }

        int steps=0;
        for(int i=0;i<n;i++){
            int need = n-i-1;
            int j=i;
            while(j<n && zeros[j]<need){
                j++;
            }
            if(j==n)return -1;
            steps+=(j-i);

            while(j>i){
                int temp = zeros[j];
                zeros[j]=zeros[j-1];
                zeros[j-1]=temp;
                j--;
            }
        }
        return steps;
    }
}
