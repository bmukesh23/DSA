class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;

        for(int i = n-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverseArray(nums, 0, n-1);
            System.out.println(Arrays.toString(nums));
            return;
        }

        for(int i = n - 1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverseArray(nums, index + 1, n-1);
        System.out.println(Arrays.toString(nums));
    }

    public static void reverseArray(int[] arr, int start, int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
}