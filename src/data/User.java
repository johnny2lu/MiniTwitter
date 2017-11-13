package data;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.tree.TreeNode;

import info.Visitor;

/**
 * Component class of TwitterTree
 * @author johnnylu
 *
 */
public class User extends Observable implements Observer, TwitterTree{
	
	private String uniqueID;
	private Set<User> followers;
	private Set<User> following;
	private List<String> newsFeed;
	
	public User(String userID) {
		uniqueID = userID;
		followers = new HashSet<>();
		following = new HashSet<>();
		newsFeed = new ArrayList<>();
	}
	
	/**
	 * Implement observer pattern
	 * @param obs
	 */
	public void addObserver(User obs) {
		followers.add(obs);
		obs.following.add(this);
	}

	/** 
	 * Reach out to observer objects and notify state change
	 */
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

	public List<String> getFeed() {
		return newsFeed;
	}
	
	public Set<User> getFollowing() {
		return following;
	}
	
	public Set<User> getFollowers() {
		return followers;
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TreeNode getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex(TreeNode node) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getAllowsChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Enumeration<?> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		
	}

}
