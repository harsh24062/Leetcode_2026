class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        // store index
        for(int i=0;i<n;i++){
          map.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for(int q:queries){
            int element=nums[q];
            List<Integer> list = map.get(element);

            if(list.size()==1){
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(list,q);
            int min = Integer.MAX_VALUE;

            //right
            int right = list.get((pos+1)%list.size());
            int dis = Math.abs(right-q);
            int curDis = n-dis;
            min =Math.min(min,Math.min(dis,curDis));

            //left
            int left = list.get((list.size()+pos-1)%list.size());
            dis = Math.abs(left-q);
            curDis = n-dis;
            min =Math.min(min,Math.min(dis,curDis));

            result.add(min);
        }
        return result;
    }
}
