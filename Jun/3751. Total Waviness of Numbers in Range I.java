class Solution {
    int solve(int n){
        int prev=-1;
        int count=0;
        while(n>0){
          int cur=n%10;
          n=n/10;
          if(n==0)break;
          int next = n%10;
          if(prev!=-1){
            if((cur>prev && cur>next) || (cur<prev && cur<next))count++;
          }
          prev=cur;
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            count+=solve(i);
        }
        return count;
    }
}
