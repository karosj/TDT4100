import java.util.ArrayList;

public class TwitterAccount {

    private String userName;
    private ArrayList<TwitterAccount> follows = new ArrayList<>();
    private int tweetCount;
    private int retweetCount;
    private ArrayList<Tweet> tweets = new ArrayList<>();

    public TwitterAccount(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getTweetCount() {
        return this.tweetCount;
    }

    public int getRetweetCount() {
        return this.retweetCount;
    }

    public void follow(TwitterAccount account) {
        if (this == account) {
            throw new IllegalStateException("Can't follow yourself");
        }
        if (!this.follows.contains(account)) {
            this.follows.add(account);
        }
    }

    public void unfollow(TwitterAccount account) {
        if (this.follows.contains(account)) {
            this.follows.remove(account);
        }
    }

    public boolean isFollowing(TwitterAccount account) {
        return this.follows.contains(account);
    }

    public boolean isFollowedBy(TwitterAccount account) {
        return account.follows.contains(this);
    }

    public void tweet(String text) {
        Tweet newTweet = new Tweet(this, text);
        this.tweetCount++;
        this.tweets.add(0, newTweet);
    }

    public void retweet(Tweet tweet) {
        Tweet newTweet = new Tweet(this, tweet);
        newTweet.getOriginalTweet().getOwner().incrementRetweetCount();
        this.tweets.add(0, newTweet);
        this.tweetCount++;
    }

    public Tweet getTweet(int i) {
        return this.tweets.get(i - 1);
    }

    public void incrementRetweetCount() {
        retweetCount++;
    }
}
