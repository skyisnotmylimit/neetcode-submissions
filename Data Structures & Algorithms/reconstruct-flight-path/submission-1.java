class Solution {
    private HashMap<String, PriorityQueue<String>> adj;
    private List<String> path;

    private void dfs(String src) {
        PriorityQueue<String> nbour = adj.get(src);
        while (nbour != null && !nbour.isEmpty()) {
            String dst = nbour.poll();
            dfs(dst);
        }
        path.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        path = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        String src = "JFK";
        dfs(src);

        Collections.reverse(path);
        return path;
    }
}
