class Solution {
    int reverse(int num){
        int r=0;
        while(num>0){
            r=r*10 + num%10;
            num=num/10;
        }
        return r;
    }
    public int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
}
