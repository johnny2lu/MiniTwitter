package data;

import javax.swing.tree.TreeNode;

import info.Visitor;

/**
 * Composite class to manage User and UserGroup
 * @author johnnylu
 *
 */
public interface TwitterTree extends TreeNode {
	
	public User getUser(User user);
	
	/**
	 * Accept visitor object
	 * @param visitor User or UserGroup
	 */
	public void accept(Visitor visitor);
}