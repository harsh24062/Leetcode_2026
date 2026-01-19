class Solution {
    boolean isEqual(double midY, int[][] squares){
       
       double lowerArea=0,upperArea=0;

       for(int sq[]:squares){
        double bottomY=sq[1], side=sq[2], topY=bottomY+side; 

        if(topY<=midY) lowerArea+=side*side;
        else if(bottomY>=midY) upperArea+=side*side;
        else{
            double upperSide = topY-midY;
            upperArea+= upperSide*side;

            double lowerSide = midY-bottomY;
            lowerArea+= lowerSide*side;
        }
       }

       return (lowerArea>=upperArea)?true:false;
    }
    public double separateSquares(int[][] squares) {
        double maxY = Double.MIN_VALUE;
        double minY = Double.MAX_VALUE;

        for(int s[]:squares){
           minY = Math.min(minY,s[1]);
           maxY = Math.max(maxY,s[1]+s[2]);
        }
        
        double precision = 1e-5;

        while(maxY-minY>precision){
            double midY = (maxY+minY)/2;
            
            if(isEqual(midY,squares)){
              maxY=midY;
            }
            else{
              minY=midY;
            }
        }
        return maxY;
    }
}
