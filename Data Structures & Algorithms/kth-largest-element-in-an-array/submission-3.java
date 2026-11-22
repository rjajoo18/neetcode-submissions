class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        quickSelect(nums, k, 0, n - 1);
        return nums[k];
    }

    public void quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[l];
        int i = l + 1, j = r;

        while (i <= j) {
            while (i <= j && nums[i] < pivot) i++;
            while (i <= j && nums[j] > pivot) j--;
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }

        nums[l] = nums[j];
        nums[j] = pivot;

        if (j == k) {
            return;
        } else if (j > k) {
            quickSelect(nums, k, l, j - 1);
        } else {
            quickSelect(nums, k, j + 1, r);
        }

    }
}
