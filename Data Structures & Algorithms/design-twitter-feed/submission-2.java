class Twitter {

    private class TweetPriority implements Comparable<TweetPriority> {
        private int time;
        private int tweetId;
        private int followee;
        private int index;

        public TweetPriority (int time, int tweetId, int followee, int index) {
            this.time = time;
            this.tweetId = tweetId;
            this.followee = followee;
            this.index = index;
        }

        public int compareTo(TweetPriority tp) {
            return (tp.time - this.time);
        }
    }

    private int time = 0;
    private Map<Integer, Set<Integer>> followees;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{tweetId, time++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        List<TweetPriority> pqInit = new ArrayList<>();
        Set<Integer> userFollowees = new HashSet<>(followees.getOrDefault(userId, new HashSet<>()));
        userFollowees.add(userId);
        
        for (Integer followee : userFollowees) {
            List<int[]> tweetsForUser = tweets.getOrDefault(followee, new ArrayList<>());
            if (tweetsForUser.size() > 0) {
                int index = tweetsForUser.size() - 1;
                int tweetId = tweetsForUser.get(index)[0];
                int tweetTime = tweetsForUser.get(index)[1];
                pqInit.add(new TweetPriority(tweetTime, tweetId, followee, index));
            }
        }
        PriorityQueue<TweetPriority> pq = new PriorityQueue<>(pqInit);
        while (!pq.isEmpty() && res.size() < 10) {
            TweetPriority tp = pq.poll();
            res.add(tp.tweetId);
            int nextIndex = tp.index - 1;
            if (nextIndex >= 0) {
                int[] nextTweet = tweets.get(tp.followee).get(nextIndex);
                pq.add(new TweetPriority(
                    nextTweet[1],
                    nextTweet[0],
                    tp.followee,
                    nextIndex
                ));
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followees.containsKey(followerId)) {
            followees.get(followerId).remove(followeeId);
        }
    }
}
