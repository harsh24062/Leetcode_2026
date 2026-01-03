class Solution {
    
    int MOD = 1000000007;
    List<String> row_Combination;
    char colors[] = {'r','y','g'};
    int dp[][];

    void generateRow(String s, char prev, int i){
        if(i==3){
            row_Combination.add(s);
            return;
        }

        for(char c:colors){
            if(c==prev)continue;
            generateRow(s+c,c,i+1);
        }
    }

    public int numOfWays(int n) {

        row_Combination = new ArrayList<>(); // find out all color combination for a row
    
        generateRow("",'#',0);

        int result = 0;
        dp = new int[n][row_Combination.size()];
        for(int i=0;i<row_Combination.size();i++){
            result = (result+solve(n-1,i))%MOD;
        }

        return result;
    }

    int solve(int remRow, int p){
        if(remRow==0)return 1;
        if(dp[remRow][p]!=0)return dp[remRow][p];
        String prev = row_Combination.get(p);
        int result=0;
        for(int i=0;i<row_Combination.size();i++){
            boolean flag=true;
            String s = row_Combination.get(i);

            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==prev.charAt(j)){
                    flag=false;
                    break;
                }
            }
           if(flag){
            result = (result+solve(remRow-1,i))%MOD;
           }
        }
        return dp[remRow][p]=result;
    }
}
