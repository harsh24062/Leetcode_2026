class Solution {
     int histogram(int arr[]){
        int max=0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0;i<arr.length;i++){
            while(stack.peek()!=-1 && arr[i]<arr[stack.peek()]){
                int h = arr[stack.pop()];
                max = Math.max(max,h*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        while(stack.peek()!=-1){
            int h = arr[stack.pop()];
            max=Math.max(max,h*(arr.length-stack.peek()-1));
        }

        return max;
     }
    public int maximalRectangle(char[][] matrix) {
        int max=0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int arr[] = new int[cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]=='0')arr[j]=0;
                else arr[j]++;
            }
            max=Math.max(max,histogram(arr));
        }
        return max;
    }
}
