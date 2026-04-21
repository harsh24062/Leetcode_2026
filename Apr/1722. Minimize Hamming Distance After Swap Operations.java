class Solution {
    int n,parent[];
    int findParent(int num){
        if(parent[num]==num)return num;
        return parent[num]=findParent(parent[num]);
    }
    void union(int num1,int num2){
        int parent1 = findParent(num1);
        int parent2  = findParent(num2);

        if(parent1!=parent2){
            parent[parent2]=parent1;
        }
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        n = source.length;
        parent = new int[n];
        for(int i=0;i<n;i++)parent[i]=i;

        for(int swaps[]:allowedSwaps){
            union(swaps[0],swaps[1]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int i=0;i<n;i++){
          int parent = findParent(i);
           list.get(parent).add(i);
        }
        
        int ans=0;
        for(List<Integer> l:list){
           Map<Integer,Integer> map = new HashMap<>();
           for(int i:l){
             map.put(source[i],map.getOrDefault(source[i],0)+1);
             map.put(target[i],map.getOrDefault(target[i],0)-1);
           }
           int value=0;
           for (int v : map.values()) {
              value+=Math.abs(v);
           }
           ans+=value/2;
        }
        return ans;
    }
}
