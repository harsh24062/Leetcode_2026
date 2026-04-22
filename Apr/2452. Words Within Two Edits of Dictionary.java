class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for(String str:queries){
            for(String dic:dictionary){
                int mismatch=0;
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)!=dic.charAt(i))mismatch++;
                    if(mismatch>2)break;
                }
                if(mismatch<=2){
                    ans.add(str);
                    break;
                }
            }
        }
        return ans;
    }
}
