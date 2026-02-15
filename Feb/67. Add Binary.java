class Solution {
    public String addBinary(String a, String b) {
        boolean carry=false;
        int i=a.length()-1;
        int j=b.length()-1;

        StringBuilder sb = new StringBuilder();

        while(i>=0 && j>=0){
            char a_ch=a.charAt(i);
            char b_ch=b.charAt(j);
            if(a_ch=='1'){ //a_ch=1
                if(carry){
                    // b_ch=0 && carry=true
                    // b_ch=1 && carry=true
                 if(b_ch=='1') sb.append("1");
                 else sb.append("0");
                }else{
                  // b_ch=0 && carry=false
                  // b_ch=1 && carry=false
                  if(b_ch=='1'){sb.append("0"); carry=true;}
                  else sb.append("1");
                }
            }else{   //a_ch=0
               if(carry){
                 if(b_ch=='1')sb.append("0");
                 else{sb.append("1"); carry=false;}
               }else{
                  if(b_ch=='1')sb.append("1");
                  else sb.append("0");
               }
            }
            i--;
            j--;
        }

        while(i>=0){
          char ch = a.charAt(i);
           if(carry){
            if(ch=='1')sb.append("0");
            else{sb.append("1"); carry=false;}
           }else{
            sb.append(ch);
           }
          i--;
        }

        while(j>=0){
            char ch = b.charAt(j);
           if(carry){
            if(ch=='1')sb.append("0");
            else{sb.append("1"); carry=false;}
           }else{
            sb.append(ch);
           }
          j--;
        }

        if(carry)sb.append("1");

        return sb.reverse().toString();
    }
}




class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int sum=0;
        int carry=0;
        
        int i=a.length()-1;
        int j=b.length()-1;

        while(i>=0 || j>=0){

            sum = carry;

            if(i>=0){
                int a_ch = a.charAt(i)-'0';
                sum+=a_ch;
                i--; 
            }
            if(j>=0){
                int b_ch = b.charAt(j)-'0';
                sum+=b_ch;
                j--; 
            }

            sb.append((sum%2==0)?'0':'1');

            carry = sum/2;
        }

        if(carry>0){
            sb.append('1');
        }

        return sb.reverse().toString();
    }
}

// bit sum
// 0 + 1 = 1 with 0 carry (1 -> 01)
// 1 + 1 = 0 with 1 carry (2 -> 10)
// 1 + 1 + 1 = 1 with 1 carry (3 -> 11) 
