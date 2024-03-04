import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {

    private String userName;
    private ArrayList<TwitterAccount> following = new ArrayList<TwitterAccount>();
	private ArrayList<TwitterAccount> followers = new ArrayList<TwitterAccount>();
    private ArrayList<Tweet> tweets = new ArrayList<>();

    public TwitterAccount(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void follow(TwitterAccount account) {
		if (this == account) {
			System.out.println("Can't follow yourself!");
		}
		if (!following.contains(account)) {
			following.add(account);
			account.followers.add(this);
		}
	}

    public void unfollow(TwitterAccount account) {
		if (following.contains(account)) {
			following.remove(account);
			account.followers.remove(this);
		}
	}
    public boolean isFollowing(TwitterAccount account) {
		return following.contains(account);
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		return followers.contains(account);
	}
	
	public void tweet(String text) {
		tweets.add(new Tweet(this, text));
	}
	
	public void retweet(Tweet tweet) {
		tweets.add(new Tweet(this, tweet));
	}
	
	public Tweet getTweet(int i) {
		return tweets.get(tweets.size() - i);
	}
	
	public int getTweetCount() {
		return tweets.size();
	}

	public int getRetweetCount() {
		int tweetCount = 0;
		for (Tweet tweet : tweets) {
			tweetCount += tweet.getRetweetCount();
		}
		return tweetCount;
	}
	public int getFollowerCount(){
		return followers.size();
	}
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator){
		if(comparator == null){
			throw new IllegalArgumentException();
		}
		
		List<TwitterAccount> followersCopy = new ArrayList<TwitterAccount>(followers);
		Collections.sort(followersCopy, comparator);
		return followersCopy;
	}
}
