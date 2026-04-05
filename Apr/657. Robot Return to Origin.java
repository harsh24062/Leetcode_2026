class Solution {
    public boolean judgeCircle(String moves) {
        int row=0,col=0;
        for(char ch:moves.toCharArray()){
           if(ch=='R')col++;
           else if(ch=='L')col--;
           else if(ch=='U')row--;
           else row++;
        }
        if(row==0&&col==0)return true;
        return false;
    }
}
