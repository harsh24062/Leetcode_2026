class Solution {
    public int binaryGap(int n) {
        int pos=-1;
        int maxDis=0;
        for(int i=0;i<32;i++){
            int isOne = n & 1;
            if(isOne==1){
              if(pos!=-1)maxDis = Math.max(maxDis,Math.abs(pos-i));
              pos=i;
            }
            n=n>>1;
        }
        return maxDis;
    }
}
 
