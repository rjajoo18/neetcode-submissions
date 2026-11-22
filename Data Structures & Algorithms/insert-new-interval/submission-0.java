class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resList = new ArrayList<>();
        int[][] res;
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval[0] > interval[1]) {
                resList.add(interval);
            } else if (newInterval[1] < interval[0]) {
                resList.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    resList.add(intervals[j]);
                }
                res = new int[resList.size()][2];
                for (int j = 0; j < res.length; j++) {
                    res[j][0] = resList.get(j)[0];
                    res[j][1] = resList.get(j)[1];
                }
                return res;
            } else {
                newInterval = new int[]{Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            }
        }
        resList.add(newInterval);
        res = new int[resList.size()][2];
        for (int j = 0; j < res.length; j++) {
            res[j][0] = resList.get(j)[0];
            res[j][1] = resList.get(j)[1];
        }
        return res;
    }
}
