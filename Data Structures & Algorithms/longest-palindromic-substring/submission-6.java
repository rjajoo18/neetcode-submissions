class Solution {
    public String longestPalindrome(String s) {
        int len = 1;
        String longest = s.substring(0, 1);
        for(int i = 0; i < s.length() - 1; i++) {
            int k = 1;
            int curr = 1;
            while((i - k >= 0) && (i + k < s.length()) && s.charAt(i - k) == s.charAt(i + k)) {
                curr += 2;
                if(curr > len) {
                    len = curr;
                    longest = s.substring(i - k, i + k + 1);
                }
                k++;
            }
            curr = 1;
        }

        for(int i = 0; i < s.length() - 1; i++) {
            int k = 0;
            int curr = 0;
            while((i - k) >= 0 && (i + k + 1) < s.length() && s.charAt(i - k) == s.charAt(i + 1 + k)) {
                curr += 2;
                if(curr > len) {
                    len = curr;
                    longest = s.substring(i - k, i + k + 2);
                }
                k++;
            }
            curr = 0;
        }

        return longest;
    }
}
