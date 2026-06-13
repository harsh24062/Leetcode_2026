class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
       StringBuilder sb = new StringBuilder();
       for(String s:words){
         int weight=0;
         for(char ch:s.toCharArray()){
          weight+=weights[ch-'a'];
         }
         weight=weight%26;
         sb.append((char)('z'-weight));
       }
       return sb.toString();
    }
}
