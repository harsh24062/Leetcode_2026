class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
       Arrays.sort(asteroids);
       long prev=mass;
       for(int i:asteroids){
        if(i>prev)return false;
        prev+=i;
       }
       return true; 
    }
}
