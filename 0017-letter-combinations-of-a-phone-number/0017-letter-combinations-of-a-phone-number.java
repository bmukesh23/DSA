class Solution {
    private static final Map<Character, String> phoneMap = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    private void findCombinations(int ind, String digits, StringBuilder curr, List<String> res) {
        if(ind == digits.length()){
            res.add(curr.toString());
            return;
        }

        char digit = digits.charAt(ind);
        String letters = phoneMap.get(digit);

        for(char letter: letters.toCharArray()){
            curr.append(letter);
            findCombinations(ind + 1, digits, curr, res);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0 || digits == null) return res;
        findCombinations(0, digits, new StringBuilder(), res);
        return res;
    }
}