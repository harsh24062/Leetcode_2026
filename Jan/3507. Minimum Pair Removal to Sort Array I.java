class Solution {
    
    boolean isSorted(List<Integer> list){
       for(int i=0;i<list.size()-1;i++){
           if(list.get(i)>list.get(i+1))return false;
       } 
        return true;
    }

    int  pairSum(List<Integer> list){
        int index=-1;
        int minSum=Integer.MAX_VALUE;

        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)+list.get(i+1)<minSum){
                index=i;
                minSum=list.get(i)+list.get(i+1);
            }
        }
        return index;
    }
    
    public int minimumPairRemoval(int[] nums) {
        if(nums.length==1)return 0;
        
        int ans=0;
        List<Integer> list=new ArrayList<>();
        for(int i:nums)list.add(i);
        
        while(!isSorted(list)){

            int minIndex=pairSum(list);
            int sum=list.get(minIndex)+list.get(minIndex+1);
            list.set(minIndex,sum);
            list.remove(minIndex+1);
            ans++;
        }
        return ans;
    }
}
