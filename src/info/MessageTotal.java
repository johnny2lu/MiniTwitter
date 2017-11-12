package info;

import java.util.ArrayList;
import java.util.List;

import data.User;
import data.UserGroup;

public class MessageTotal implements Visitor {

	private List<String> message;
	
	public MessageTotal() {
		message = new ArrayList<>();
	}
	
	@Override
	public void visit(UserGroup visitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(User visitor) {
		for (int i = 0;i < visitor.getFeed().size(); i++) {
			message.add(visitor.getFeed().get(i));
		}
		
	}
	
	public int getTotal() {
		return message.size();
	}

}
