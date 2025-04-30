class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        int n = nums.length;

        for(int i = 0; i < n; i++){
            Set<Integer> hs = new HashSet<>();
            for(int j = i + 1; j < n; j++){
                int third = -(nums[i]  + nums[j]);

                if(hs.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    st.add(temp);
                }
                hs.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
}