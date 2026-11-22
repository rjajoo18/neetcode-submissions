class Solution {
    public boolean isPalindrome(String s) {
        String t = s.toLowerCase();
        
        int l = 0;
        int r = s.length() - 1;

        while(l < r){
            while(!Character.isLetterOrDigit(s.charAt(l))){
                l++;
                if(l >= t.length()){
                    return true;
                }
            }
            if(!Character.isLetterOrDigit(s.charAt(r))){
                r--;
                continue;
            }
            if(t.charAt(l) != t.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}
