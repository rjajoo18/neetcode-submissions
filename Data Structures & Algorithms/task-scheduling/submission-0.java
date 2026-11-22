class Solution {

    private class TaskFreq {
        private char c;
        private int freq;

        public TaskFreq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    private class TaskTime {
        private TaskFreq taskFreq;
        private int time;

        public TaskTime(TaskFreq taskFreq, int time) {
            this.taskFreq = taskFreq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : tasks) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<TaskFreq> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.freq, a.freq)
        );
        for (Character c : freq.keySet()) {
            pq.offer(new TaskFreq(c, freq.get(c)));
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
                TaskFreq curr = pq.poll();
                // process task
                curr.freq--;
                if (curr.freq > 0) {
                    q.offer(new TaskTime(curr, time + n + 1));
                }
            }
        }
        return time;
    }
}
