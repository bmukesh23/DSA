class Solution {
    public int firstPosition(int[]nums,int n, int k){
        int low = 0, high = n - 1;
        int first = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == k){
                first = mid;
                high = mid - 1;
            }
            else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return first;
    }

    public int lastPosition(int[]nums, int n, int k){
        int low = 0, high = n - 1;
        int last = -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == k){
                last = mid;
                low = mid + 1;
            }
            else if(nums[mid] < k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstPosition(nums, n, target);
        if(first == -1) return new int[]{-1, -1};
        int last = lastPosition(nums, n, target);
        return new int[]{first, last};
    }
}