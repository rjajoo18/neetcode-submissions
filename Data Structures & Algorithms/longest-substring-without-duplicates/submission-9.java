class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int max = 1;
        int l = 0;
        int r = 0;
        HashSet<Character> set = new HashSet<>();
        while(r < s.length()){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                r++;
                max = Math.max(max, r - l);
            } else {
                while(l < r && set.contains(c)){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
        }
        return max;
    }
}
