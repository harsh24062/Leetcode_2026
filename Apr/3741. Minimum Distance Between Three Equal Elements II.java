class Solution {
    public int minimumDistance(int[] nums) {
          int minDis = Integer.MAX_VALUE;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            List<Integer> list = map.get(nums[i]);
            list.add(i);
            int size = list.size();
            if(size>2){
               int x = (int)Math.abs(list.get(size-1)-list.get(size-2));
               int y = (int)Math.abs(list.get(size-1)-list.get(size-3));
               int z = (int)Math.abs(list.get(size-2)-list.get(size-3));
               minDis = Math.min(minDis,x+y+z);
            }
        }
        return (minDis==Integer.MAX_VALUE)?-1:minDis;
    }
}
