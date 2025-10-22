class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];
                if (sum == goal) count++;
            }
        }
        return count;
    }
}