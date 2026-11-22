class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0) return 0.0;
        if(n == 1) return x;
        if(n == 0) return 1.0;
        if(n < 0) return 1 / myPow(x, -n);
        
        if(n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            return myPow(x, n / 2) * myPow(x, n / 2) * x;
        }
    }
}
