package data;

import java.util.HashSet;
import java.util.Set;

import view.TwitterTree;

public class UserGroup implements TwitterTree {
	
	private String uniqueID;
	private Set<TwitterTree> children;
	
	public UserGroup(String groupID) {
		uniqueID = groupID;
		children = new HashSet<>();
	}

	@Override
	public User getUser(User user) {
		return user;

	}

	public void appendChild(TwitterTree child) {
		children.add(child);
	}

}
