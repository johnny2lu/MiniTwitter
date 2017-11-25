package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

import com.oracle.tools.packager.Log;
import data.TwitterTree;
import data.User;
import data.UserGroup;
import info.GroupTotal;
import info.MessageTotal;
import info.PositiveTotal;
import info.UserTotal;
import info.Visitor;

/**
 * Main UI view
 * 
 * @author johnnylu
 *
 */
public class MiniTwitterGUI extends JFrame {

	private JPanel contentPane;
	private static MiniTwitterGUI INSTANCE;
	private JTextArea txtrGroupid;
	private JTextArea txtrUserid;
	private JButton btnAddUser;
	private JButton btnAddGroup;
	private JButton btnOpenUserView;
	private JScrollPane jscrollPane;
	private JButton btnShowUserTotal;
	private JButton btnShowGroupTotal;
	private JButton btnShowMessageTotal;
	private JButton btnShowPositivePercentage;
	private JButton btnValidateIDs;
	private JTree tree;
	private UserGroup root;
	private DefaultTreeModel defaultTree;
	private Set<String> users;
	private Set<String> groups;

	/**
	 * Create the frame.
	 */
	public MiniTwitterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 696);
		contentPane = new JPanel(new GridLayout(3, 1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		users = new HashSet<String>();
		groups = new HashSet<String>();
		initComponents();
	}

	/**
	 * Initialize Java Swing components in UI
	 */
	public void initComponents() {
		JFrame frame = new JFrame("Control Panel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		root = new UserGroup("root");

		defaultTree = new DefaultTreeModel(root);

		tree = new JTree(defaultTree);
		tree.setRootVisible(true);
		updateTree();

		jscrollPane = new JScrollPane(tree);

		txtrGroupid = new JTextArea();

		txtrUserid = new JTextArea();

		btnAddUser = new JButton("Add User");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addUserButtonActionPerformed(e);
			}

		});

		btnAddGroup = new JButton("Add Group");
		btnAddGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGroupButtonActionPerformed(e);
			}

		});

		btnOpenUserView = new JButton("Open User View");
		btnOpenUserView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openUserViewActionPerformed(e);
			}
		});

		btnShowUserTotal = new JButton("Show User Total");
		btnShowUserTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showUserTotalActionPerformed(e);
			}
		});

		btnShowGroupTotal = new JButton("Show Group Total");
		btnShowGroupTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGroupTotalActionPerformed(e);
			}
		});

		btnShowMessageTotal = new JButton("Show Message Total");
		btnShowMessageTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMessageTotalActionPerformed(e);
			}
		});

		btnShowPositivePercentage = new JButton("Show Positive Percentage");
		btnShowPositivePercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPercentageTotalActionPerformed(e);
			}
		});

		btnValidateIDs = new JButton("Validate IDs");
		btnValidateIDs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validateIDActionPerformed(e);
			}
		});

		// Align JPanel window
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(jscrollPane, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnShowUserTotal).addComponent(btnShowMessageTotal,
														GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnShowPositivePercentage, GroupLayout.PREFERRED_SIZE,
														201, Short.MAX_VALUE)
												.addComponent(btnShowGroupTotal, GroupLayout.PREFERRED_SIZE, 201,
														Short.MAX_VALUE)))
								.addComponent(btnOpenUserView, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtrGroupid).addComponent(txtrUserid,
														GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnAddGroup, GroupLayout.DEFAULT_SIZE, 205,
														Short.MAX_VALUE)
												.addComponent(btnAddUser, GroupLayout.DEFAULT_SIZE, 205,
														Short.MAX_VALUE))))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(20)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtrUserid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnAddGroup)
						.addComponent(txtrGroupid, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnOpenUserView).addGap(365)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnShowUserTotal)
						.addComponent(btnShowGroupTotal, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnShowMessageTotal)
						.addComponent(btnShowPositivePercentage, GroupLayout.PREFERRED_SIZE, 29,
								GroupLayout.PREFERRED_SIZE))
				.addGap(80))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(jscrollPane, GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE).addContainerGap()));

		jscrollPane.setColumnHeaderView(tree);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Check for duplicate User or Group IDs
	 *
	 * @param e
	 */
	protected void validateIDActionPerformed(ActionEvent e) {
		// check for spaces
		String s = " ";

		if (root == null) {
			JOptionPane.showMessageDialog(null, "There are no duplicates");
		}

	}

	protected void showPercentageTotalActionPerformed(ActionEvent e) {
		TreeNode current = (TreeNode) tree.getLastSelectedPathComponent();
		if (current != null) {
			Visitor visitor = new PositiveTotal();
			((TwitterTree) current).accept(visitor);
			JOptionPane.showMessageDialog(null, ((PositiveTotal) visitor).getTotal());
		} else {
			JOptionPane.showMessageDialog(null, "There are no percentages available for this user");
		}
	}

	protected void showMessageTotalActionPerformed(ActionEvent e) {
		TreeNode current = (TreeNode) tree.getLastSelectedPathComponent();
		if (current != null) {
			Visitor visitor = new MessageTotal();
			((TwitterTree) current).accept(visitor);
			JOptionPane.showMessageDialog(null, ((MessageTotal) visitor).getTotal());
		} else {
			JOptionPane.showMessageDialog(null, "There are no messages for this user");
		}
	}

	protected void showGroupTotalActionPerformed(ActionEvent e) {
		TreeNode current = (TreeNode) tree.getLastSelectedPathComponent();
		if (current != null) {
			Visitor visitor = new GroupTotal();
			((TwitterTree) current).accept(visitor);
			JOptionPane.showMessageDialog(null, ((GroupTotal) visitor).getTotal());
		} else {
			JOptionPane.showMessageDialog(null, "Please select a group");
		}
	}

	protected void showUserTotalActionPerformed(ActionEvent e) {
		TreeNode current = (TreeNode) tree.getLastSelectedPathComponent();
		if (current != null) {
			Visitor visitor = new UserTotal();
			((TwitterTree) current).accept(visitor);
			JOptionPane.showMessageDialog(null, ((UserTotal) visitor).getTotal());
		} else {
			JOptionPane.showMessageDialog(null, "There are no users");
		}

	}

	/**
	 * Initialize Singleton
	 * 
	 * @return
	 */
	public static MiniTwitterGUI getInstance() {
		if (INSTANCE == null) {
			synchronized (MiniTwitterGUI.class) {
				if (INSTANCE == null) {
					try {
						INSTANCE = new MiniTwitterGUI();
						INSTANCE.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return INSTANCE;
	}

	protected void addUserButtonActionPerformed(ActionEvent e) {
		TreeNode selected = (TreeNode) tree.getLastSelectedPathComponent();
		if (txtrUserid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a user to add");
		} else if (users.contains(txtrUserid.getText())) {
			JOptionPane.showMessageDialog(null, "User ID already exists");
		} else if (selected == null) {
			JOptionPane.showMessageDialog(null, "Please select a group to add user to");
		} else {
			if (selected instanceof UserGroup) {
				users.add(txtrUserid.getText());
				((UserGroup) selected).add(new User(txtrUserid.getText()));
				updateTree();
				txtrUserid.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "Please select a group to add user to");
			}
		}
	}

	protected void addGroupButtonActionPerformed(ActionEvent e) {

		if (txtrGroupid.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter a group to add");
		} else if (users.contains(txtrGroupid.getText())) {
			JOptionPane.showMessageDialog(null, "Group ID already exists");
		} else {
			TreeNode selected = (TreeNode) tree.getLastSelectedPathComponent();
			if (selected == null) {
				root.add(new UserGroup(txtrGroupid.getText()));
			} else {
				((UserGroup) selected).add(new UserGroup(txtrGroupid.getText()));
				groups.add(txtrGroupid.getText());
				updateTree();
				txtrGroupid.setText("");
			}
		}
	}

	protected void openUserViewActionPerformed(ActionEvent e) {
		TreeNode selected = (TreeNode) tree.getLastSelectedPathComponent();
		if (selected == null) {
			JOptionPane.showMessageDialog(null, "Please select a user");
		} else if (selected instanceof UserGroup) {
			JOptionPane.showMessageDialog(null, "Please select a user, not a group");
		} else {
			new UserView((User) selected).setVisible(true);
		}
	}

	/**
	 * Refresh tree and expand nodes
	 */
	private void updateTree() {
		defaultTree.reload(root);
		for (int i = 0; i < tree.getRowCount(); i++)
			tree.expandRow(i);
	}
}
