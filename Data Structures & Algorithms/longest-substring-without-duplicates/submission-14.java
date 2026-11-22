class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 0, max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (seen.contains(c)) {
                while (seen.contains(c)) {
                    seen.remove(s.charAt(l));
                    l++;
                }
            }
            seen.add(c);
            r++;
            max = Math.max(max, r - l);
        }
        return max;
    }
}
