package view;

import data.User;
import javax.swing.tree.TreeNode;
import data.UserGroup;
import info.Visitor;

public interface TwitterTree extends TreeNode {
	
	public User getUser(User user);
	
	/**
	 * Accept visitor object
	 * @param visitor User or UserGroup
	 */
	public void accept(Visitor visitor);
}
