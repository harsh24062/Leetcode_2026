class Solution {
    public int minCost(int n, int[][] edges) {
        int dist[] = new int[n];

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int e[]:edges){
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],2*e[2]});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);

        dist[0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0});

        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int dis=arr[0];
            int node=arr[1];

            //if(dis>dist[node])continue;
            
            if(node==n-1)return dis;
            for(int a[]:adj.get(node)){
                int newdis = dis+a[1];
                if(newdis<dist[a[0]]){
                    pq.offer(new int[]{newdis,a[0]});
                    dist[a[0]]=newdis;
                }
            }
        }

        return -1;
    }
}
