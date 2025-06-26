class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];

        // Previous less element count
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevLess[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        // Clear stack for next computation
        stack.clear();

        // Next less element count
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextLess[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            long prod = (long) arr[i] * prevLess[i] * nextLess[i];
            result = (result + prod) % MOD;
        }

        return (int) result;
    }
}