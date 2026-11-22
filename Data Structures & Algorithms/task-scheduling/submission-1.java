class Solution {

    private class TaskTime {
        private int taskFreq;
        private int time;

        public TaskTime(int taskFreq, int time) {
            this.taskFreq = taskFreq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for (Character c : freq.keySet()) {
            pq.offer(freq.get(c));
        }
        Queue<TaskTime> q = new LinkedList<>();
        int time = 0; 
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            if (!q.isEmpty() && q.peek().time == time) {
                TaskTime curr = q.poll();
                pq.offer(curr.taskFreq);
            }
            if (!pq.isEmpty()) {
                int curr = pq.poll();
                // process task
                curr--;
                if (curr > 0) {
                    q.offer(new TaskTime(curr, time + n + 1));
                }
            }
        }
        return time;
    }
}
