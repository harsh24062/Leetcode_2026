class Solution {
    public int minOperations(String s) {
        int n = s.length();
        // 0101010 start with zero
        // at even index it expect 0
        // at odd index it expect 1

        // 1010101 start with one
        // at even index it expect 1
        // at odd index it expect 0

        int start_zero=0,start_one=0;

        for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          if(i%2==0){
            if(ch=='0')start_one++;
            else start_zero++;
          }else{
            if(ch=='0')start_zero++;
            else start_one++;
          }
        }

        return Math.min(start_zero,start_one);
    }
}
