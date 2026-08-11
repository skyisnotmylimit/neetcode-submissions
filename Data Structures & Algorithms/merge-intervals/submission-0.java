class Solution {
    public int[][] merge(int[][] intervals) {
       ArrayList<int[]> result = new ArrayList<>();
       Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
       int[] prev = intervals[0];
       for(int i=1;i<intervals.length;i++) {
        int[] cur = intervals[i];
        if(cur[0] <= prev[1]) {
            prev[1] = Math.max(cur[1],prev[1]);
        }
        else {
            result.add(prev);
            prev = cur;
        }
       }
       result.add(prev);
       int[][] ans = new int[result.size()][2];
       for(int i=0;i<result.size();i++) {
        ans[i] = result.get(i);
       }
       return ans;
    }
}
