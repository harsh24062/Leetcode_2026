class Solution {
    public int numSteps(String s) {
        int count=0;
        int carry=0;
        int n = s.length();
        for(int i=n-1;i>0;i--){
            char ch = s.charAt(i);
            if(ch=='1'){ // odd make it even
               if(carry==1){
                 count++;
               }else{
                 count+=2;
                 carry=1;
               }
            }else{
             if(carry==1){
                 count+=2;
                 carry=1;
               }else{
                 count++;
               }
            }
        }
        if(carry==1)count++;
        return count;
    }
}
