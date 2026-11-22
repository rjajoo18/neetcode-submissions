class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int l = 0, r = 0, maxLen = 0, maxFreq = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            maxFreq = Math.max(++counts[c - 'A'], maxFreq);
            while (l < r && r - l + 1 - maxFreq > k) {
                maxFreq = Math.max(maxFreq, --counts[s.charAt(l) - 'A']);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
