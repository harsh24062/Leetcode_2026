class Solution {
    public int numberOfSpecialChars(String word) {
        int lower[] = new int[26];
        int higher[] = new int[26];
        Arrays.fill(lower,-1);
        Arrays.fill(higher,-1);
        char ch[] = word.toCharArray();
        Set<Character> inValidSet = new HashSet<>();

        for(int i=0;i<ch.length;i++){
            if(Character.isUpperCase(ch[i]) && higher[ch[i]-'A']==-1){
                higher[ch[i]-'A']=i;
            }else if(Character.isLowerCase(ch[i])){
               if(higher[ch[i]-'a']!=-1)inValidSet.add(ch[i]);
               else lower[ch[i]-'a']=i;
            }
        }

        int count=0;
        for(int i=0;i<26;i++){
            char c= (char)('a'+i);
            if(inValidSet.contains(c))continue;
            if(higher[i]!=-1 && lower[i]!=-1)count++;
        }
        return count;
    }
}
