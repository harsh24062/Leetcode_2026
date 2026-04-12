class Solution {
    Map<String,Integer> map;
    int func(int index, String word, int finger1[], int finger2[]){
        if(index==word.length())return 0;
        String s = ""+index+Arrays.toString(finger1)+Arrays.toString(finger2);
        if(map.containsKey(s))return map.get(s);
        int i = word.charAt(index)-'A';
        int row = i/6;
        int col = i%6;
        //finger1
        int fing1 = func(index+1,word,new int[]{row,col},finger2) + ((finger1[0]==-1)?0:(Math.abs(finger1[0]-row)+Math.abs(finger1[1]-col)));
        //finger2
        int fing2 = func(index+1,word,finger1,new int[]{row,col}) + ((finger2[0]==-1)?0:(Math.abs(finger2[0]-row)+Math.abs(finger2[1]-col)));

        int value = Math.min(fing1,fing2);
        map.put(s,value);
        return value;
    }
    public int minimumDistance(String word) {
        map = new HashMap<>();
        return func(0,word,new int[]{-1,-1},new int[]{-1,-1});
    }
}
