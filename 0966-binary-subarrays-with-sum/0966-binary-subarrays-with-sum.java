class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countNumSubarrayWithSum(nums, goal) - countNumSubarrayWithSum(nums, goal - 1);
    }

    public int countNumSubarrayWithSum(int[] arr, int k){
        if(k < 0) return 0;
        
        int left = 0;
        int count = 0;
        int sum = 0;

        for(int right = 0; right < arr.length; right++){
            sum += arr[right];
            while(sum > k){
                sum -= arr[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}