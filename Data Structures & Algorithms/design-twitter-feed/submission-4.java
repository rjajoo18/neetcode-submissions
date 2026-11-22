class Twitter {

    private int timestamp;

    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    private class User {
        Set<Integer> followees;
        Tweet tweetHead;

        User() {
            followees = new HashSet<>();
        }
    }

    private Map<Integer, User> users;

    public Twitter() {
        timestamp = 0;
        users = new HashMap<>();
    }

    private User getUser(int userId) {
        users.putIfAbsent(userId, new User());
        return users.get(userId);
    }

    public void postTweet(int userId, int tweetId) {
        User user = getUser(userId);

        Tweet tweet = new Tweet(tweetId, timestamp++);
        tweet.next = user.tweetHead;
        user.tweetHead = tweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq =
                new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        User user = users.get(userId);

        if (user != null) {
            if (user.tweetHead != null) {
                pq.offer(user.tweetHead);
            }

            for (int followeeId : user.followees) {
                User followee = users.get(followeeId);

                if (followee != null && followee.tweetHead != null) {
                    pq.offer(followee.tweetHead);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet tweet = pq.poll();
            result.add(tweet.id);

            if (tweet.next != null) {
                pq.offer(tweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        User follower = getUser(followerId);
        getUser(followeeId);

        follower.followees.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);

        if (follower != null) {
            follower.followees.remove(followeeId);
        }
    }
}