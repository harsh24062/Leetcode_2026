class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean visited[] = new boolean[arr.length];
        visited[start]=true;
        while(!queue.isEmpty()){
           int index = queue.poll();
           if(arr[index]==0)return true;

           //move left
           int leftIndex = index-arr[index];
           if(leftIndex>=0 && !visited[leftIndex]){queue.offer(leftIndex); visited[leftIndex]=true;}
           //move right
           int rightIndex = index+arr[index];
           if(rightIndex<arr.length && !visited[rightIndex]){queue.offer(rightIndex); visited[rightIndex]=true;}
        }
        return false;
    }
}

//3755
