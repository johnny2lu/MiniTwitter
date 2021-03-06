package info;

import data.User;
import data.UserGroup;

public class UserTotal implements Visitor {
	
	private int count;

	public UserTotal() {
		count = 0;
	}
	
	@Override
	public void visit(UserGroup visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(User visitor) {
		count++;	
	}
	
	/**
	 * 
	 * @return Total number of users in selected group
	 */
	public int getTotal() {
		return count;
	}

}
