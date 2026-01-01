class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int leading = 0;
        List<Integer> list = new ArrayList<>();

        if(digits[n-1]+1>=10){
            int value = digits[n-1]+1;
            leading=1;
            list.add(value%10);
        }else{
            list.add(digits[n-1]+1);
        }

        for(int i=n-2;i>=0;i--){
            if(leading==1){
             int value = digits[i]+1;
             leading=0;
             if(value>=10){
               list.add(value%10);
               leading=1;
             }else{
                list.add(value);
             }
            }else{
                list.add(digits[i]);
            }
        }

        if(leading==1)list.add(1);
        int ans[] = new int[list.size()];

        for(int i=0;i<ans.length;i++){
          ans[i] = list.get(ans.length-1-i);
        }
        
        return ans;
    }
}
