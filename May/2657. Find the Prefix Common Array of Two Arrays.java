class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int ans[] = new int[A.length];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int prefix=0;
        for(int i=0;i<A.length;i++){
            int ch1 = A[i];
            int ch2 = B[i];
            set1.add(ch1);
            set2.add(ch2);
            if(ch1==ch2)prefix++;
            else{
              if(set1.contains(ch2))prefix++;
              if(set2.contains(ch1))prefix++;
            }
            ans[i]=prefix;
        }
        return ans;
    }
}
