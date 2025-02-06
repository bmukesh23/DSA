class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> productCount = new HashMap<>();
        int cnt = 0;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];

                if (productCount.containsKey(product)) {
                    int freq = productCount.get(product);
                    cnt += freq * 8;
                }

                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }
        
        return cnt;
    }
}