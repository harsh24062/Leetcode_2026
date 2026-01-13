// tabulation 
class Solution {
    int m,n;
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {
        m=s1.length();
        n=s2.length();
        dp = new int[m+1][n+1];

        // return statement
        // i1==m
        for(int j=n-1;j>=0;j--){
            dp[m][j] = s2.charAt(j) + dp[m][j+1]; 
        }
        // i2==n
        for(int i=m-1;i>=0;i--){
            dp[i][n] = s1.charAt(i) + dp[i+1][n]; 
        }
        

        for(int i1 = m-1;i1>=0;i1--){
            for(int i2 = n-1;i2>=0;i2--){
                
              if(s1.charAt(i1)==s2.charAt(i2)){
                dp[i1][i2] = dp[i1+1][i2+1];
               }
             
             else{
               int take1 = s1.charAt(i1)+dp[i1+1][i2];
               int take2 = s2.charAt(i2)+dp[i1][i2+1];

                dp[i1][i2] = Math.min(take1,take2);
             }
            }
        }

        return dp[0][0];
    }
}
