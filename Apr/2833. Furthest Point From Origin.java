class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0,right=0,underScore=0;
        for(char ch:moves.toCharArray()){
            if(ch=='L')left++;
            else if(ch=='R')right++;
            else underScore++;
        }
        return Math.max(left,right)-Math.min(left,right)+underScore;
    }
}
