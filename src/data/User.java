package data;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import observer.Subject;
import view.TwitterTree;

public class User extends Observable implements Observer, TwitterTree{
	
	private String uniqueID;
	private Set<User> followers;
	private Set<User> following;
	private Set<String> newsFeed;
	
	public User(String userID) {
		uniqueID = userID;
		followers = new HashSet<>();
		following = new HashSet<>();
		newsFeed = new HashSet<>();
	}
	
	public void addObserver(User obs) {
		followers.add(obs);
		obs.following.add(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String) {
			newsFeed.add((String) arg);
		}
		
	}

	@Override
	public User getUser(User user) {
		return user;
	}

	public void postTweet(String tweet) {
		newsFeed.add(tweet);
		notifyObservers(tweet);
	}

	public Set<String> getFeed() {
		return newsFeed;
	}
	
	public Set<User> getFollowing() {
		return following;
	}
	
	public Set<User> getFollowers() {
		return followers;
	}
}
