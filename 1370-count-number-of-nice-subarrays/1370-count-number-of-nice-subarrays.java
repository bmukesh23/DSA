class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] arr, int k){
        if(k < 0) return 0;
        int left = 0, count = 0, sum = 0;

        for(int right = 0; right < arr.length; right++){
            sum += (arr[right] % 2);
            while(sum > k){
                sum -= (arr[left] % 2);
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}