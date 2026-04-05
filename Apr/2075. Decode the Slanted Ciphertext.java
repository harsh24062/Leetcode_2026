class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
       
       int cols = encodedText.length()/rows;

       char ch[][] = new char[rows][cols];
       int index=0;

       for(int i=0;i<rows;i++){
         for(int j=0;j<cols;j++){
            ch[i][j]=encodedText.charAt(index);
            index++;
         }
       }

       StringBuilder sb = new StringBuilder();
       for(int j=0;j<cols;j++){
         int i=0;
         int col=j;
         while(i<rows && col<cols){
            sb.append(ch[i][col]);
            i++;
            col++;
         }
       }
       return sb.toString().stripTrailing();
    }
}
