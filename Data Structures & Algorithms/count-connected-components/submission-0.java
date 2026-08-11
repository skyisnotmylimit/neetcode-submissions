class Solution {
    private void bfs(ArrayList<ArrayList<Integer>> adj,HashSet<Integer> vis,int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        vis.add(src);
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int nbour : adj.get(cur)) {
                if(!vis.contains(nbour)) {
                    q.add(nbour);
                    vis.add(nbour);
                }
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        HashSet<Integer> vis = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for(int i=0;i<n;i++) {
            if(!vis.contains(i)) {
                count++;
                bfs(adj,vis,i);
            }
        }
        return count;
    }
}
