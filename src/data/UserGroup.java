package data;

import java.util.HashSet;
import java.util.Set;

import view.TwitterTree;

public class UserGroup implements TwitterTree {
	
	private String uniqueID;
	private Set<User> users;
	
	public UserGroup(String groupID) {
		uniqueID = groupID;
		users = new HashSet<>();
	}

	@Override
	public User getUser(User user) {
		return user;

	}

}
