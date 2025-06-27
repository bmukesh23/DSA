class Solution {
    public long subArrayRanges(int[] nums) {
        return getSubarraySum(nums, true) - getSubarraySum(nums, false);
    }

    private long getSubarraySum(int[] nums, boolean isMax) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        long sum = 0;

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || 
                (isMax && nums[stack.peek()] < (i < n ? nums[i] : Integer.MAX_VALUE)) || 
                (!isMax && nums[stack.peek()] > (i < n ? nums[i] : Integer.MIN_VALUE)))) {

                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                long count = (mid - left) * (right - mid);
                sum += count * nums[mid];
            }
            stack.push(i);
        }

        return sum;
    }
}