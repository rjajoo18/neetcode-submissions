class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(check(s1, s2.substring(i, i + s1.length()))) return true;
        }
        return false;
    }

    public boolean check(String str1, String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        String sr1 = String.valueOf(s1);
        String sr2 = String.valueOf(s2);
        return sr1.equals(sr2);
    }
}
