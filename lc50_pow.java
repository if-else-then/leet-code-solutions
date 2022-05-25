class Solution {
    public double myPow(double x, int n) {
        // return bruteForce(x, n);
        return halfTimeSol(x,n);
    }
    private double halfTimeSol(double x, int n) {
        if (n==0) {
            return 1.0;
        }
        if (n<0) {
           return  halfTimeSol(1/x, -1*n);
        }
        double half = halfTimeSol(x, n/2);
        if (n%2 == 0) {
            return half * half;
        } 
        return half * half * x;
    }
    
    private double bruteForce(double x, int n) {
        if (n<0) {
            return myPow(1/x, -1*n);
        }
        if (n==0) {
            return 1;
        }
        return (x * myPow(x, n-1));
    }
}
