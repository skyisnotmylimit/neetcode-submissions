class Solution {
    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public int[][] kClosest(int[][] points, int k) {
        // Use a max-heap to keep the k closest points
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(distanceSquared(b), distanceSquared(a))
        );

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) {
                pq.poll(); // Remove the farthest point if the heap exceeds size k
            }
        }

        // Prepare the result array
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}
