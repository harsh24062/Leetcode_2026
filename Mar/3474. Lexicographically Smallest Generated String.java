class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        
        int N = n+m-1;
        char ans[] = new char[N];
        boolean canChange[] = new boolean[N];

        for(int i=0;i<N;i++){
            ans[i]='$';
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='T'){
                int index=i;
                for(int j=0;j<m;j++){
                    if(ans[index]!='$' && ans[index]!=str2.charAt(j))return "";
                    ans[index]=str2.charAt(j);
                    index++;
                }
            }
        }

        for(int i=0;i<N;i++){
          if(ans[i]=='$'){
            ans[i]='a';
            canChange[i]=true;
          }
        }

        for(int i=0;i<n;i++){
            if(str1.charAt(i)=='F'){
                if(isSame(i,ans,str2)){
                   boolean isChange = false;
                   for(int j=i+m-1;j>=i;j--){
                      if(canChange[j]){
                        ans[j]='b';
                        canChange[j]=false;
                        isChange=true;
                         break;
                      }  
                   }
                   if(!isChange)return "";
                }
            }
        }

        return new String(ans);
    }

    boolean isSame(int i, char ans[],String str2){
        for(int j=0;j<str2.length();j++){
            if(str2.charAt(j)!=ans[i])return false;
            i++;
        }
        return true;
    }
}
