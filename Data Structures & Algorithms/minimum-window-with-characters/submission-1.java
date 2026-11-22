class Solution {
    public String minWindow(String s, String t) {
        int[] ctsT = new int[58];
        for (int i = 0; i < t.length(); i++) {
            ctsT[t.charAt(i) - 'A']++;
        }
        int l = 0, r = 0;
        String minSub = "";
        int[] ctsS = new int[58];
        int have = 0, need = t.length();
        while (r < s.length() && ctsT[s.charAt(l) - 'A'] == 0) {
            l++;
            r++;
        }
        while (r < s.length()) {
            char c = s.charAt(r);
            ctsS[c - 'A']++;
            if (ctsS[c - 'A'] == ctsT[c - 'A']) {
                have += ctsS[c - 'A'];
            }
            while (need == have) {
                if (minSub.length() == 0 || minSub.length() > r - l + 1) {
                    minSub = s.substring(l, r + 1);
                }
                ctsS[s.charAt(l) - 'A']--;
                if (ctsS[s.charAt(l) - 'A'] < ctsT[s.charAt(l) - 'A']) {
                    have -= ctsT[s.charAt(l) - 'A'];
                }
                l++;
            }
            r++;
        }
        return minSub;
    }

    public boolean validate(int[] ctsS, int[] ctsT) {
        for (int i = 0; i < 58; i++) {
            if (ctsS[i] < ctsT[i]) {
                return false;
            }
        }
        return true;
    }
}
