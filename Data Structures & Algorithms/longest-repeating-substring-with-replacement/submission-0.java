class Solution {
    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int maxF = 0, l = 0, maxLen = 0;
        for(int r = 0; r < s.length(); r++) {
            counts[s.charAt(r) - 'A']++;
            maxF = Math.max(maxF, counts[s.charAt(r) - 'A']);
            while(r - l + 1 - maxF > k) {
                counts[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
        }
        return maxLen;
    }
}
