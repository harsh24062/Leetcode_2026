class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=1;i<arr.length;i++){
            int curDiff = Math.abs(arr[i]-arr[i-1]);
            if(curDiff<diff)  {
                diff=curDiff;
                ans = new ArrayList<>();
            }

            if(curDiff<=diff){
              List<Integer> temp = new ArrayList<>();
              temp.add(arr[i-1]);
              temp.add(arr[i]);
              ans.add(new ArrayList<>(temp));
            }
        }

        return ans;
    }
}
