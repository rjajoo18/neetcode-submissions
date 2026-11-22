class Solution {
    public double myPow(double x, int n) {
        if(x == 0.0) return 0.0;
        if(n == 1) return x;
        if(n == 0) return 1.0;
        long N = n;
        if(N < 0) { 
            x = 1.0 / x;
            N = -N;
        }
        
        return pow(x, n);
        }

    public double pow(double x, long n) {
        if(n == 0) return 1.0;
        double half = pow(x, n / 2);
        if(n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}