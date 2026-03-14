class Solution {
    String result;
    int count;
    boolean func(int n, int k , StringBuilder str){
        if(str.length()==n){
            count++;
            if(count==k){
                result=str.toString();
                return true;
            }
            return false;
        }

        for(char ch='a';ch<='c';ch++){
            if(str.length()>0 && str.charAt(str.length()-1)==ch)continue;
            str.append(ch);
            if(func(n,k,str))return true;
            str.deleteCharAt(str.length()-1);
        }
        return false;
    }
    public String getHappyString(int n, int k) {
        result="";
        count=0;
        func(n,k,new StringBuilder(""));
        return result;
    }
}
