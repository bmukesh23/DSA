class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, index = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
            index++;
        } else if (s.charAt(0) == '+') index++;

        long num = 0;
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!Character.isDigit(c)) break;

            num = num * 10 + (c - '0');

            if (num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }

        return (int) num * sign;
    }
}