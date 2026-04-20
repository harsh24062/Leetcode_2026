// brute force
class Solution {
    public int maxDistance(int[] colors) {
        int max=0;
        for(int i=0;i<colors.length-1;i++){
            for(int j=colors.length-1;j>i;j--){
                if(colors[i]!=colors[j]){
                    max=Math.max(max,j-i);
                }
            }
        }
        return max;
    }
}

// recursion
class Solution {
    int recur(int start,int end,int colors[]){
        if(start==end)return 0;
        if(colors[start]!=colors[end])return end-start;
        int left = recur(start+1,end,colors);
        int right = recur(start,end-1,colors);
        return Math.max(left,right);
    }
    public int maxDistance(int[] colors) {
        return recur(0,colors.length-1,colors);
    }
}

//dp
class Solution {
    int dp[][];
    int recur(int start,int end,int colors[]){
        if(start==end)return 0;
        if(dp[start][end]!=-1)return dp[start][end];
        if(colors[start]!=colors[end])return dp[start][end]=end-start;
        int left = recur(start+1,end,colors);
        int right = recur(start,end-1,colors);
        return dp[start][end]=Math.max(left,right);
    }
    public int maxDistance(int[] colors) {
        dp = new int[colors.length][colors.length];
        for(int d[]:dp){
            Arrays.fill(d,-1);
        }
        return recur(0,colors.length-1,colors);
    }
}


// otimized
class Solution {
    public int maxDistance(int[] colors) {
        int max=0;
        for(int i=0;i<colors.length;i++){
            if(colors[0]!=colors[i]){
                max=Math.max(max,i);
            }
            if(colors[colors.length-1]!=colors[i]){
                max=Math.max(max,(colors.length-1-i));
            }
        }
        return max;
    }
}
