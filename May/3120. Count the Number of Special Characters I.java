class Solution {
    public int numberOfSpecialChars(String word) {
        boolean small[] = new boolean[26];
        boolean large[] = new boolean[26];

        for(char ch:word.toCharArray()){
            if(Character.isUpperCase(ch)){
                large[ch-'A']=true;
            }else{
                small[ch-'a']=true;
            }
        }

        int count=0;
        for(int i=0;i<26;i++){
            if(large[i] && small[i])count++;
        }
        return count;
    }
}
