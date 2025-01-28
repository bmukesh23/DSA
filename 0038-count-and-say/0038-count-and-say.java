class Solution {
    public String countAndSay(int n) {
        String result = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder current = new StringBuilder();
            char[] prevTerm = result.toCharArray();
            int count = 1;
            
            for (int j = 1; j < prevTerm.length; j++) {
                if (prevTerm[j] == prevTerm[j - 1]) {
                    count++;
                } else {
                    current.append(count).append(prevTerm[j - 1]);
                    count = 1;
                }
            }
            current.append(count).append(prevTerm[prevTerm.length - 1]);
            result = current.toString();
        }
        
        return result;
    }
}