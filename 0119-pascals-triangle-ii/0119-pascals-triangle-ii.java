class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);

        for(int i = 1; i <= rowIndex; i++){
            long ans = (long) row.get(i - 1) * (rowIndex - i + 1) / i;
            row.add((int)ans);
        }

        return row;
    }
}