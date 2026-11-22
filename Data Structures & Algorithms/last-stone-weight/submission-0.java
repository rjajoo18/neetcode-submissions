class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );
        for(int val : stones) {
            pq.offer(val);
        }
        
        while(pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if(x < y) pq.offer(y-x);
            else if(x > y) pq.offer(x - y);
        }

        return (pq.size() == 0) ? 0 : pq.peek();
    }
}
