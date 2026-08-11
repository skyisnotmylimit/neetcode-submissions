class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> vis = new HashSet<>();
        int[] inDegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            for(int node : adj.get(i)) {
                inDegree[node]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(inDegree[i] == 0) {
                q.add(i);
                vis.add(i);
            }
        }
        while(!q.isEmpty()) {
            int cur = q.remove();
            for(int nbour : adj.get(cur)) {
                inDegree[nbour]--;
                if(inDegree[nbour] == 0) {
                    vis.add(nbour);
                    q.add(nbour);
                }
            }
        }
        return vis.size() == numCourses;
    }
}
