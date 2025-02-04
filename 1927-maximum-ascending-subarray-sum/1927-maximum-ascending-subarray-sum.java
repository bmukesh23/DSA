class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                curr += nums[i];
            } else {
                curr = nums[i];
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}