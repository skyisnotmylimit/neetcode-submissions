class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        boolean flag = true;
        while(true) {
            int sum = 0;
            while(n != 0) {
                int rem = n % 10;
                sum = sum + (int)Math.pow(rem,2);
                n = n / 10;
            }
            if(sum == 1) return true;
            if(set.contains(sum)) {
                flag = false;
                break;
            }
            set.add(sum);
            n = sum;
        }
        return flag;
    }
}
