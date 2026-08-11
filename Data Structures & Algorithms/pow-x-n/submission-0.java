class Solution {
    private double pow(double x,int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        double res = pow(x,n/2) * pow(x,n/2);
        if(n % 2 != 0) {
            res = res * x;
        }
        return res;
    }
    public double myPow(double x, int n) {
        boolean inv = false;
        int sign = 1;
        double ans = pow(Math.abs(x),Math.abs(n));
        if(x < 0 && n % 2 != 0) sign = -1;
        if(n < 0) inv = true;
        if(inv) {
            ans = 1 / ans;
        }
        ans = ans * sign;
        return ans;
    }
}
