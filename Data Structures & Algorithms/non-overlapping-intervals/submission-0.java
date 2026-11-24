class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, 
            (a, b) -> Integer.compare(a[0], b[0])
        );
        int[] currInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currInterval[1] > intervals[i][0]) {
                res++;
                currInterval = new int[]{currInterval[0], Math.min(currInterval[1], intervals[i][1])};
            } else {
                currInterval = intervals[i];
            }
        }
        return res;
    }
}
