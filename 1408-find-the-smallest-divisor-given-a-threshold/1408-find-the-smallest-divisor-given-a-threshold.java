class Solution {
    public int sumByD(int[] nums, int mid){
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        if(nums.length > threshold) return -1;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int low = 0, high = max;
        while(low <= high){
            int mid  = (low + high)/2;
            if(sumByD(nums, mid) <= threshold){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}