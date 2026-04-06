class Solution {
    int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    // top, right, bottom, left
    public int robotSim(int[] commands, int[][] obstacles) {
        int index=0; // it point to dir
        int max=0;
        int row=0,col=0;

        Set<String> set = new HashSet<>();
        for(int o[]:obstacles){
            String str = o[0]+"*"+o[1];
            set.add(str);
        }
        
        for(int i=0;i<commands.length;i++){
            if(commands[i]==-2){
              // turn left in dir
              index = (index-1+4)%4;
            }else if(commands[i]==-1){
              // turn right in dir
              index = (index+1)%4;
            }else{
               for(int j=1;j<=commands[i];j++){
                 int newRow = row+dir[index][0];
                 int newCol = col+dir[index][1];
                 String str = newRow+"*"+newCol;
                 if(set.contains(str))break;
                 row=newRow;
                 col=newCol;
                 max = Math.max(max,(int)Math.pow(row,2)+(int)Math.pow(col,2));
               }
            }
        }

        return max;
    }
}
