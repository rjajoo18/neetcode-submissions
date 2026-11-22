class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        // odd palindromes
        for (int i = 0; i < n; i++) {
            int k = 0;
            while (i - k >= 0 && i + k < n) {
                if (s.charAt(i - k) == s.charAt(i + k)) {
                    count++;
                    k++;
                } else {
                    break;
                }
            }
        }
        // even palindromes
        for (int i = 0; i < n - 1; i++) {
            int k = 0;
            while (i - k >= 0 && i + k + 1 < n) {
                if (s.charAt(i - k) == s.charAt(i + k + 1)) {
                    count++;
                    k++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
