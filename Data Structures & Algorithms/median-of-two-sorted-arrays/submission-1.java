class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = total / 2;

        if (B.length < A.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int l = 0, r = A.length;
        while (l <= r) {
            int midA = (l + r) / 2;
            int midB = half - midA;

            int Aleft = (midA > 0) ? A[midA - 1] : Integer.MIN_VALUE;
            int Aright = (midA < A.length) ? A[midA] : Integer.MAX_VALUE;
            int Bleft = (midB > 0) ? B[midB - 1] : Integer.MIN_VALUE;
            int Bright = (midB < B.length) ? B[midB] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                return (total % 2 == 0) ? (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0 : Math.min(Aright, Bright) / 1.0;
            } else if (Aleft > Bright) {
                r = midA - 1;
            } else {
                l = midA + 1;
            }
        }

        return 0.0;
    }
}
