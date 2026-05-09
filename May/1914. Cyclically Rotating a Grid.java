class Solution {
    int m,n;
  
    public int[][] rotateGrid(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int top=0,bottom=m-1;
        int left=0,right=n-1;
        while(top<bottom && left<right){
             List<Integer> nums = new ArrayList<>();
           // Top row (left -> right)
            for (int j = left; j <= right; j++) {
                nums.add(grid[top][j]);
            }

            // Right column (top -> bottom)
            // Skip corners because they are already included
            for (int i = top + 1; i <= bottom - 1; i++) {
                nums.add(grid[i][right]);
            }

            // Bottom row (right -> left)
            for (int j = right; j >= left; j--) {
                nums.add(grid[bottom][j]);
            }

            // Left column (bottom -> top)
            // Skip corners because they are already included
            for (int i = bottom - 1; i >= top + 1; i--) {
                nums.add(grid[i][left]);
            }

            int len = nums.size();

            int normalizedK = k % len;

            // Rotate left by normalizedK
            Collections.rotate(nums, -normalizedK);

            int idx = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = nums.get(idx++);
            }

            // Right column
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = nums.get(idx++);
            }

            // Bottom row
            for (int j = right; j >= left; j--) {
                grid[bottom][j] = nums.get(idx++);
            }

            // Left column
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = nums.get(idx++);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
        return grid;
    }
}
