
public class Tweet {
    private TwitterAccount owner;
    private String text;
    private Tweet originalTweet;
    private int retweetCount;

    public Tweet(TwitterAccount owner, String text) {
        this.owner = owner;
        this.text = text;
        this.originalTweet = null;
        this.retweetCount = 0;
    }

    public Tweet(TwitterAccount owner, Tweet originalTweet) {
        if (owner == originalTweet.getOwner()) {
            throw new IllegalArgumentException("Can't retweet your own tweet");
        }
        this.owner = owner;
        this.originalTweet = originalTweet.getOriginalTweet() == null ? originalTweet
                : originalTweet.getOriginalTweet();
        this.text = originalTweet.getText();
        this.retweetCount = 0;
        originalTweet.increaseRetweetCount();
    }

    public TwitterAccount getOwner() {
        return owner;
    }

    public String getText() {
        return text;
    }

    public Tweet getOriginalTweet() {
        return originalTweet;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    private void increaseRetweetCount() {
        retweetCount++;
        if (originalTweet != null) {
            originalTweet.increaseRetweetCount();

        }
    }
}
