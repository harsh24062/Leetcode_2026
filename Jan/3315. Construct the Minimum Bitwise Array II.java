class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
          int num = nums.get(i);
          if(num==2){
            ans[i]=-1;
            continue;
          }
          
          boolean flag=false;

          for(int j=1;j<32;j++){
            if((num & (1<<j)) == 0){
                ans[i]=num^(1<<(j-1));
                flag=true;
                break;
            }
          }
          if(!flag) ans[i]=-1;
        }
        return ans;
    }
}
