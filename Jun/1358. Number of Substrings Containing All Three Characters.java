class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int count=0;
        int left=0,right=0;
        while(right<n){
          char ch = s.charAt(right);
          map.put(ch,map.getOrDefault(ch,0)+1);
          while(map.size()==3){
            count+=n-right;
            map.put(s.charAt(left),map.get(s.charAt(left))-1);
            if(map.get(s.charAt(left))==0)map.remove(s.charAt(left));
            left++;
          }
          right++;
        }
        return count;
    }
}
