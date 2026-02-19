class Solution {
    public int countBinarySubstrings(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('0',0);
        map.put('1',0);

        char current='0',other='1';
        if(s.charAt(0)=='1'){
            current='1';
            other='0';
        }

        map.put(current,1);
        int ans=0;
        for(int i=1;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch==current){
                map.put(current,map.get(current)+1);
            }else{
                if(current=='1'){
                    current='0';
                    other='1';
                }else{
                    current='1';
                    other='0';
                }
                map.put(current,1);
            }

            if(map.get(other)>=map.get(current)){
                ans++;
            }
        }
        return ans;
    }
}
