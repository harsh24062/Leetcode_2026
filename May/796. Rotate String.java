class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        s = s+s;
        for(int i=0;i<n;i++){
            if(s.substring(i,i+n).equals(goal))return true;
        }
        return false;
    }
}
