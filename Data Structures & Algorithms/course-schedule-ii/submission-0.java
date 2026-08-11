class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] order = new int[numCourses];
        int p = 0;
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
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
            }
        }
        while(!q.isEmpty()) {
            int cur = q.remove();
            order[p++] = cur;
            for(int nbour : adj.get(cur)) {
                inDegree[nbour]--;
                if(inDegree[nbour] == 0) {
                    q.add(nbour);
                }
            }
        }
        order = (p == numCourses) ? order : new int[]{};
        return order;
    }
}

