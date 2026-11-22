class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] cts1 = new int[26];
        int[] cts2 = new int[26];
        
        for(int i = 0; i < s1.length(); i++){
            cts1[s1.charAt(i) - 'a']++;
            cts2[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s2.length() - s1.length(); i++) {
            if(Arrays.equals(cts1, cts2)) return true;
            cts2[s2.charAt(i) - 'a']--;
            cts2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return Arrays.equals(cts1, cts2);
    }
}
