class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()) {
            char c = s.charAt(r);
            if(set.contains(c)) {
                int len = r - l;
                if(len > max) max = len;
                while(set.contains(c) && l < r){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(c);
            r++;
            if(r - l > max) max = r - l;
        }
        return max;
    }
}
