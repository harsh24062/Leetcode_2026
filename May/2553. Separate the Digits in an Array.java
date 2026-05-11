class Solution {
    List<Integer> ansList;
    void solve(int num){
       List<Integer> list = new ArrayList<>();
       while(num>0){
        list.add(num%10);
        num=num/10;
       }
       Collections.reverse(list);
       for(int i:list){
        ansList.add(i);
       }
    }
    public int[] separateDigits(int[] nums) {
        ansList = new ArrayList<>();
        for(int i:nums){
            solve(i);
        }
        int ans[] = new int[ansList.size()];
        for(int i=0;i<ans.length;i++){
         ans[i]=ansList.get(i);
        }
        return ans;
    }
}
