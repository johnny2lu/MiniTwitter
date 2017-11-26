package data;

import javax.swing.tree.TreeNode;

import info.Visitor;

import java.awt.*;

/**
 * Composite class to manage User and UserGroup
 * @author johnnylu
 *
 */
public interface TwitterTree extends TreeNode {
	
	public User getUser(String user);

	public long printCreationTime();
	/**
	 * Accept visitor object
	 * @param visitor User or UserGroup
	 */
	public void accept(Visitor visitor);

	boolean contains(Visitor visitor);
}
