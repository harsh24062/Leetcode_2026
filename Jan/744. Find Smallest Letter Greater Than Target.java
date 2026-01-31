class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        for(char c:letters){
            if(c>target)return c;
        }
        return letters[0];
    }
}

// binary search
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low=0,high=letters.length-1;
        char ans = letters[0];
        while(low<=high){
            int mid = (low+high)/2;

            char c = letters[mid];
            if(c>target){
                ans=c;
                high=mid-1;
            }else low = mid+1;
        }
        return ans;
    }
}
