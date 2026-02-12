class Solution { 
    //TC - O(N*N*26)
    boolean isBalance(int freq[]){
        int lastFreq=-1;

        for(int i:freq){
          if(i>0){
            if(lastFreq==-1)lastFreq=i;
            else if(lastFreq!=i)return false;
          }
        }
        return true;
    }
    public int longestBalanced(String s) {
       int max=0;
       for(int i=0;i<s.length();i++){
         int freq[] = new int[26];
        for(int j=i;j<s.length();j++){
          freq[s.charAt(j)-'a']++;
          if(isBalance(freq))max=Math.max(max,j-i+1);
        }
       }

       return max; 
    }
}
