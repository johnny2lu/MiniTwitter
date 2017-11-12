package info;

import data.User;
import data.UserGroup;

public class GroupTotal implements Visitor{
	private int count;

	public GroupTotal() {
		count = 0;
	}
	
	@Override
	public void visit(UserGroup visitor) {
		count++;	
	}

	@Override
	public void visit(User visitor) {
			
	}
	
	/**
	 * 
	 * @return Total number of all groups
	 */
	public int getTotal() {
		return count;
	}
}
