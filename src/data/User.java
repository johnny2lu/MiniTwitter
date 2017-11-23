package data;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.*;
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
	private DefaultListModel<String> newsFeed;
	private long creationTime;
	private long lastUpdateTime;
	
	public User(String userID) {
		uniqueID = userID;
		followers = new HashSet<>();
		following = new HashSet<>();
		newsFeed = new DefaultListModel<>();
		creationTime = System.currentTimeMillis();
	}
	
	/**
	 * Implement observer pattern
	 * @param obs
	 */
	public void addObserver(User obs) {
		super.addObserver(obs);
		followers.add(obs);
		obs.following.add(this);
	}

	/** 
	 * Reach out to observer objects and notify state change
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String) {
			System.out.println("update called");
			newsFeed.add(0, (String) arg);
		}
		
	}

	@Override
	public User getUser(String user) {
		if (uniqueID.equals(user)) {
			return this;
		}
		return null;
	}

	public void postTweet(String tweet) {
		newsFeed.addElement(tweet);
		setChanged();
		notifyObservers(tweet);
		System.out.println("observers notified");
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public String toString() {
		return uniqueID;
	}

	public DefaultListModel<String> getFeed() {
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
		return this;
	}

	@Override
	public int getChildCount() {
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
		return true;
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
