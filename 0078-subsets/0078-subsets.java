class Solution {
    public void findSubsets(int ind, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));

        for(int i = ind; i < nums.length; i++){
            curr.add(nums[i]);
            findSubsets(i + 1, nums, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}