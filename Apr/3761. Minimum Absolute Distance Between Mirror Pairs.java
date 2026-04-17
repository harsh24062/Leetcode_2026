class Solution {
    int reverse(int num){
        String str = num+"";
        char ch[] = str.toCharArray();
        for(int i=0;i<ch.length/2;i++){
           char temp = ch[ch.length-1-i];
           ch[ch.length-1-i]=ch[i];
           ch[i]=temp;
        }
        return Integer.parseInt(new String(ch));
    }
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                ans = Math.min(ans,i-map.get(nums[i]));
            }
            int num = reverse(nums[i]);
            map.put(num,i);
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
}
