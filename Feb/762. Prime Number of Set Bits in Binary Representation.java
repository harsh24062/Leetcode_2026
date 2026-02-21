class Solution {
    public int countPrimeSetBits(int left, int right) {
        Set<Integer> set = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17,19,23,29,31));
        int ans=0;
        for(int num=left;num<=right;num++){
            int i=num;
            int count=0;
            for(int j=0;j<32;j++){
                count+= (i & 1);
                i=i>>1;
            }
            if(set.contains(count))ans++;
        }
        return ans;
    }
}

// Better answer
class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans=0;
        for(int i=left;i<=right;i++){
          int setBit = Integer.bitCount(i);
          if(isPrime(setBit))ans++;
        }
        return ans;
    }

    boolean isPrime(int n){
       if(n<2)return false;
       for(int i=2;i*i<=n;i++){
        if(n%i==0)return false;
       }
       return true;
    }
}
