class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        int curr = 0;
        while(n >= 1) {
            curr += (n % 10) * (n % 10);
            n /= 10;
        }
        if(curr == 1) return true;
        if(set.contains(curr)) return false;
        set.add(curr);
        return isHappy(curr);
    }
}
