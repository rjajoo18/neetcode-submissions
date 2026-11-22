class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        int max = findMax(piles);
        if(len == h) return max;
        int l = 1, r = max;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(sum(piles, mid) <= h){
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public int sum(int[] piles, int k){
        int total = 0;
        for(int val : piles){
            if(val % k != 0){
                total += ((val / k) + 1);
            } else {
                total += (val / k);
            }
        }
        return total;
    }

    public int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int val : arr){
            if(val > max) max = val;
        }
        return max;
    }
}
