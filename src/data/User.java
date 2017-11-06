package data;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import observer.Subject;
import view.TwitterTree;

public class User extends Observable implements Observer, TwitterTree{
	
	private String uniqueID;
	private Set<String> followers;
	private Set<String> following;
	private Set<String> newsFeed;
	
	public User() {
		
	}

	@Override
	public String getUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
