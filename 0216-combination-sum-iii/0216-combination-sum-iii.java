class Solution {
    public void findCombinations(int ind, int k, int n, List<List<Integer>> ans, List<Integer> curr) {
        if(curr.size() == k && n == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(curr.size() > k || n < 0){
            return;
        }

        for(int i = ind; i <= 9; i++){
            curr.add(i);
            findCombinations(i + 1, k, n - i, ans, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(1, k, n, ans, new ArrayList<>());
        return ans;
    }
}