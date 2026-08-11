class Solution {
    public boolean solve(int piles[],int h,int mid) {
        int total = 0;
        for(int i : piles) {
            total += (i + mid - 1) / mid;
            if(total > h) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for(int i : piles) {
            right = Math.max(i,right);
        }
        int ans = -1;
        while(left <= right) {
            int mid = (right - left)/2 + left;
            if(solve(piles,h,mid)) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
