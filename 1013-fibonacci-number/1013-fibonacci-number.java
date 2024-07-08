class Solution {
    int a = 0, b = 1, count = 2;

    public int fib(int n) {
        if (n == 0){
            b = n;
        }
        
        while(count <= n){
            int temp = b;
            b = b + a;
            a = temp;
            count++;
        }
        
        return b;
    }
}