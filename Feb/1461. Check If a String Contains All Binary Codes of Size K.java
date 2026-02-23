class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int totalWay = (int)Math.pow(2,k);
       
        Set<String> set = new HashSet<>();
        int left=0,right=k-1;
        while(right<n){
            String str = s.substring(left,right+1);
            set.add(str);
            left++;
            right++;
        }
        return (set.size()==totalWay)?true:false;
    }
}
