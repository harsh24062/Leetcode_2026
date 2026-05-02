class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            if(isValid(i))ans++;
        }
        return ans;
    }

    boolean isValid(int num){
        int original=num;
        int newNum=0;
        int len=0;
        while(num>0){
            int x = num%10;
            if(x==3 || x==4 || x==7)return false;
            if(x==2 || x==5) x=((x==2)?5:2);
            else if(x==6 || x==9) x=((x==6)?9:6);
            newNum = (x*(int)Math.pow(10,len))+newNum;
            num=num/10;
            len++;
        }
        if(newNum==original)return false;
        return true;
    }
}

// n  should not contain 3,4,7
