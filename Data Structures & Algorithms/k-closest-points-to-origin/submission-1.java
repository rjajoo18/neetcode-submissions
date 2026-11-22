class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, k, 0, points.length - 1);
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    public void quickSelect(int[][] points, int k, int l, int r) {
        if (l >= r) return;
        int pivotDist = dist(points[l]);
        int i = l + 1, j = r;
        while (i <= j) {
            while (i <= j && dist(points[i]) <= pivotDist) {
                i++;
            }
            while (i <= j + 1 && dist(points[j]) > pivotDist) {
                j--;
            }
            if (i > j) break;
            int[] temp = points[i];
            points[i] = points[j];
            points[j] = temp;
        }
        int[] temp = points[l];
        points[l] = points[j];
        points[j] = temp;
        if (j == k - 1) {
            return;
        } else if (j > k - 1) {
            quickSelect(points, k, l, j - 1);
        } else {
            quickSelect(points, k, j + 1, r);
        }
    }

    public int dist(int[] point) {
        return (point[0] * point[0] + point[1] * point[1]);
    }
}
