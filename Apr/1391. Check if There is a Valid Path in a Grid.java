class Solution {
    public boolean hasValidPath(int[][] grid) {

       Map<Integer,int[][]> directions = new HashMap<>();
       directions.put(1,new int[][]{{0,-1},{0,1}});
       directions.put(2,new int[][]{{1,0},{-1,0}});
       directions.put(3,new int[][]{{0,-1},{1,0}});
       directions.put(4,new int[][]{{0,1},{1,0}});
       directions.put(5,new int[][]{{0,-1},{-1,0}});
       directions.put(6,new int[][]{{0,1},{-1,0}});

       int m = grid.length;
       int n = grid[0].length;

       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[]{0,0});

       boolean visited[][] = new boolean[m][n];
       visited[0][0]=true;

       while(!queue.isEmpty()){
        int arr[] = queue.poll();
        int row = arr[0];
        int col = arr[1];
        if(row==m-1 && col==n-1) return true;
        for(int d[]:directions.get(grid[row][col])){
            int newRow = d[0]+row;
            int newCol = d[1]+col;
            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol]){
               for(int newD[]:directions.get(grid[newRow][newCol])){
                  if(d[0]+newD[0]==0 && d[1]+newD[1]==0){
                    visited[newRow][newCol]=true;
                    queue.offer(new int[]{newRow,newCol});
                  }
               }
            }
        }
       } 
      
       return false;
    }
}
