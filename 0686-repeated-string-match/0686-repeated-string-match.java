public class Solution {
    public int repeatedStringMatch(String A, String B) {
        int n = A.length(), m = B.length();
        int[] lps = buildLPS(B);

        int i = 0, j = 0;
        while (i < n * 2 + m) { 
            if (A.charAt(i % n) == B.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return (i - 1) / n + 1;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    private int[] buildLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}