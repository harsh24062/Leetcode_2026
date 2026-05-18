class Solution {
    public int minJumps(int[] arr) {
        int time=0;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[arr.length];
        visited[0]=true;
        queue.offer(0);

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        while(!queue.isEmpty()){
           int size = queue.size();
           while(size-->0){
           int index = queue.poll();
           if(index==arr.length-1)return time;
           //left
           int left = index-1;
           if(left>=0 && !visited[left]){
            visited[left]=true;
            queue.offer(left);
           }
           //right
           int right = index+1;
           if(right<arr.length && !visited[right]){
            visited[right]=true;
            queue.offer(right);
           }
          
           for(int idx:map.getOrDefault(arr[index],new ArrayList<>())){
             if(!visited[idx]){
                queue.offer(idx);
                visited[idx]=true;
             }
           }


           map.remove(arr[index]);
         }
         time++;
        }
        return time;
    }
}
