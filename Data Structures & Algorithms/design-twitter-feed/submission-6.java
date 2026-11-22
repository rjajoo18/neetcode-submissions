class Twitter {

    private class Tweet {
        private int time;
        private int tweetId;
        private int userId;
        private int nextIndex;

        public Tweet(int time, int tweetId, int userId, int nextIndex) {
            this.time = time;
            this.tweetId = tweetId;
            this.userId = userId;
            this.nextIndex = nextIndex;
        }
    }

    private int currTime = 0;
    private Map<Integer, Set<Integer>> followeeMap;
    private Map<Integer, List<int[]>> tweetMap;

    public Twitter() {
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{currTime++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        followeeMap.putIfAbsent(userId, new HashSet<>());
        Set<Integer> followees = followeeMap.get(userId);
        followees.add(userId);

        for (int id : followees) {
            if (!tweetMap.containsKey(id)) continue;

            List<int[]> tweets = tweetMap.get(id);
            int index = tweets.size() - 1;
            int[] currTweet = tweets.get(index);

            pq.offer(new Tweet(currTweet[0], currTweet[1], id, index - 1));
        }
        
        while (!pq.isEmpty() && res.size() < 10) {
            Tweet curr = pq.poll();
            res.add(curr.tweetId);
            if (curr.nextIndex >= 0) {
                List<int[]> tweets = tweetMap.get(curr.userId);
                int[] currTweet = tweets.get(curr.nextIndex);
                pq.offer(new Tweet(currTweet[0], currTweet[1], curr.userId, curr.nextIndex - 1));
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followeeMap.putIfAbsent(followerId, new HashSet<>());
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}
