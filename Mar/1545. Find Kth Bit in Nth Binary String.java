class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i=1;i<n && k>sb.length();i++){
            sb.append("1");
            for(int j=sb.length()-2;j>=0;j--){
               char invertedBit = (sb.charAt(j) == '1') ? '0' : '1';
               sb.append(invertedBit);
            } 
        }
        return sb.charAt(k-1);
    }
}

// better 
class Solution {
char recur(int len,int k){
  if(len==1) return '0';
  int half=len/2;
  if(half==k-1)return '1';
  else if(k-1<half) return recur(half,k);
  else{
    char ch=recur(half,len-k+1);
    return (ch=='1')?'0':'1';
  }
}
    public char findKthBit(int n, int k) {
        int len=(int)Math.pow(2,n)-1;
        return recur(len,k);
    }
}
