class KthLargest {
    private PriorityQueue<Integer> pq;
    private int cap;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue<>();
        this.cap = k;
        for (int num : nums) {
            if (pq.size() < cap) {
                pq.add(num);
            } else {
                if (pq.peek() < num) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
    }
    
    public int add(int val) {
        if (pq.size() < cap) {
                pq.add(val);
        } else {
            if (pq.peek() < val) {
                pq.poll();
                pq.add(val);
            }
        }
        return pq.peek();
    }
}
