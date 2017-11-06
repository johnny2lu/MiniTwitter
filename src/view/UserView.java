package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import data.User;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JLabel;

public class UserView extends JFrame implements Observer {
	
	private User user;
	private JTextArea txtUser;
	private JButton btnFollowUser;
	private JScrollPane scrollPaneFollowings;
	private JTextArea txtTweet;	
	private JButton btnPostTweet;	
	private JScrollPane scrollPaneFeed;
	private JList<String> listFeed;
	private JList<User> listFollowings;
	
	public UserView(User user) {
		this.user = user;
		txtUser = new JTextArea();
		btnFollowUser = new JButton("Follow User");
		scrollPaneFollowings = new JScrollPane();
		txtTweet = new JTextArea();	
		btnPostTweet = new JButton("Post Tweet");
		scrollPaneFeed = new JScrollPane();
		listFeed = new JList<>();
		listFollowings = new JList<>();
		initComponents();
		initFollowUser();
		initPostTweet();
	}

	private void initPostTweet() {
		btnPostTweet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				postTweetActionPerformed(e);
			}
			
		});
		
	}

	protected void postTweetActionPerformed(ActionEvent e) {
		user.postTweet(txtTweet.getText());
		txtTweet.setText("");
	}

	private void initFollowUser() {
		btnFollowUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				followUserActionPerformed(e);				
			}			
		});	
	}

	protected void followUserActionPerformed(ActionEvent e) {
		user.addObserver(new User(txtUser.getText()));
		txtUser.setText("");
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
	public void initComponents() {
		
		JLabel lblCurrentlyFollowing = new JLabel("Currently Following");
		
		JLabel lblTweetMessage = new JLabel("Tweet Message");
		
		JLabel lblNewsFeed = new JLabel("News Feed");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewsFeed)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(lblTweetMessage)
								.addContainerGap())
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCurrentlyFollowing)
									.addContainerGap())
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(scrollPaneFeed, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
										.addContainerGap())
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(txtTweet, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnPostTweet)
											.addContainerGap())
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPaneFollowings, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(btnFollowUser, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
											.addContainerGap(17, Short.MAX_VALUE))))))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtUser, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFollowUser))
					.addGap(5)
					.addComponent(lblCurrentlyFollowing)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPaneFollowings, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblTweetMessage)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtTweet)
							.addGap(8)
							.addComponent(lblNewsFeed)
							.addGap(6))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPostTweet)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(scrollPaneFeed, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		scrollPaneFeed.setViewportView(listFeed);
		scrollPaneFollowings.setViewportView(listFollowings);
		
		getContentPane().setLayout(groupLayout);
	}
}
