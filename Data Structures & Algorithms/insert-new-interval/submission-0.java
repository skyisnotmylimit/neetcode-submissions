class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        for(int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        Collections.sort(list,(a,b)->(a[0] - b[0]));
        for(int[] interval : list) {
            System.out.println(Arrays.toString(interval));
        }
        ArrayList<int[]> result = new ArrayList<>();
        int prev[] = list.get(0);
        for(int i=1;i<list.size();i++) {
            int cur[] = list.get(i);
            if(cur[0] <= prev[1]) {
                prev[1] = Math.max(cur[1],prev[1]);
            }
            else {
                result.add(prev);
                prev = cur;
            }
        }
        result.add(prev);
        int ans[][] = new int[result.size()][2];
        int k = 0;
        for(int[] interval : result) {
            ans[k++] = interval;
        }
        return ans;
    }
}
