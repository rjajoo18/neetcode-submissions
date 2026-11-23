class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resList = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] curr = intervals[0];
        for (int i = 1; i < n; i++) {
            if (curr[1] >= intervals[i][0]) {
                curr = new int[]{curr[0], Math.max(curr[1], intervals[i][1])};
            } else {
                resList.add(curr);
                curr = intervals[i];
            }
        }
        resList.add(curr);
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i][0] = resList.get(i)[0];
            res[i][1] = resList.get(i)[1];
        }
        return res;
    }
}
