class Solution {
    public int minOperations(int[][] grid, int x) {

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int ans=0;
        int midIdx = list.size()/2;
        int midElement = list.get(midIdx);

        for(int i=0;i<list.size();i++){
            if(Math.abs(list.get(i)-midElement)%x!=0)return -1;
            ans+=Math.abs(list.get(i)-midElement)/x;
        }

        return ans;
    }
}
