class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n2 < n1) return findMedianSortedArrays(nums2, nums1);
        int half = (n1 + n2 + 1) / 2;
        int l = 0, r = n1;
        // binary search on number of elements taken from nums1
        while(l <= r) {
            int mid1 = l + (r - l) / 2;
            int mid2 = half - mid1;

            int L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int R1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];
            int L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int R2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            if(L1 <= R2 && L2 <= R1) {
                if((n1 + n2) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return (double) Math.max(L1, L2);
                }
            }

            else if (L1 > R2) {
                r = mid1 - 1;
            }

            else {
                l = mid1 + 1;
            }
        }
        
        return 0.0;
    }
}
