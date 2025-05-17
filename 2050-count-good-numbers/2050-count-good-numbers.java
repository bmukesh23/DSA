class Solution {
    private static final long MOD = 1_000_000_007;
    
    public int countGoodNumbers(long n) {
        long evenCnt = (n + 1)/2;
        long oddCnt = n / 2;

        long evenWays = modPow(5, evenCnt, MOD);
        long oddWays = modPow(4, oddCnt, MOD);

        return (int)((evenWays * oddWays) % MOD);
    }

    private long modPow(long base, long exp, long mod){
        long res = 1;
        base %= mod;

        while(exp > 0){
            if((exp & 1) == 1){
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}