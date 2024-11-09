class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean flag;
        
        for(int i = 0; i <= n; i++){
            flag = false;
            for(int j = 0; j < n; j++){
                if(nums[j] == i){
                    flag = true;
                    break;
                } 
            }
            if(flag == false) return i;
        }
        return -1;
    }
}