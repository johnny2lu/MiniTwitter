package data;

import javax.swing.tree.TreeNode;

import info.Visitor;

import java.util.*;

/**
 * Component class of TwitterTree
 * @author johnnylu
 *
 */
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
	
	public String getID() {
		return uniqueID;
	}

	public void add(TwitterTree child) {
		children.add(child);
	}

	@Override
	public TreeNode getChildAt(int childIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
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
		return false;
	}

	@Override
	public Enumeration<?> children() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
		for (TwitterTree tree: children) {
			tree.accept(visitor);
		}
	}

}
