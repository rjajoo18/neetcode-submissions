class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i <= 25; i++) {
            if (freq[i] > 0) pq.offer(freq[i]);
        }
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int curr = pq.poll();
                if (curr - 1 > 0) q.offer(new int[]{curr - 1, time + n});
            }

            if (!q.isEmpty()) {
                if (time == q.peek()[1]) {
                    int[] curr = q.poll();
                    pq.offer(curr[0]);
                }
            }
        }
        return time;
    }
}
