class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = max(piles);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (time(piles, mid) > h) {
                l = mid + 1;
            } else if (time(piles, mid) <= h) {
                r = mid;
            }
        }
        return r;
    }

    public int time(int[] piles, int k) {
        int hours = 0;
        for (int pile : piles) {
            if (pile % k == 0) {
                hours += (pile / k);
            } else {
                hours += ((pile / k) + 1);
            }
        }
        return hours;
    }

    public int max(int[] arr) {
        int max = 0;
        for (int x : arr) {
            max = Math.max(max, x);
        }
        return max;
    }
}
