class Pair implements Comparable<Pair> {
    int node;
    int dist;
    Pair(int node,int dist) {
        this.node = node;
        this.dist = dist;
    }
    @Override
    public int compareTo(Pair other) {
        return this.dist - other.dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<Pair>());
        }
        for(int edge[] : times) {
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        int dis[] = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k] = 0;
        pq.add(new Pair(k,0));
        while(!pq.isEmpty()) {
            int cur = pq.peek().node;
            int dist = pq.peek().dist;
            pq.remove();
            for(Pair nbour : adj.get(cur)) {
                if(nbour.dist + dist < dis[nbour.node]) {
                    dis[nbour.node] = nbour.dist + dist;
                    pq.add(new Pair(nbour.node,dis[nbour.node]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++) {
            max = Math.max(max,dis[i]);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}
