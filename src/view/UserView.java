package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import data.User;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class UserView extends JFrame {
	
	private User user;
	private JTextArea txtUser;
	private JButton btnFollowUser;
	private JScrollPane scrollPaneFollowings;
	private JTextArea txtTweet;	
	private JButton btnPostTweet;	
	private JScrollPane scrollPaneFeed;
	private JList<String> listFeed;
	private JList<User> listFollowings;
	private JPanel contentPane;
	
	/**
	 * Initialize UI components for UserView
	 * 
	 * @author johnnylu
	 */
	public UserView(User user) {
		setBounds(100, 100, 400, 600);
		contentPane = new JPanel(new GridLayout(3, 1));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.user = user;
		txtUser = new JTextArea();
		btnFollowUser = new JButton("Follow User");
		scrollPaneFollowings = new JScrollPane();
		txtTweet = new JTextArea();	
		btnPostTweet = new JButton("Post Tweet");
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
		listFeed.setModel(user.getFeed());
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
	
	/**
	 * Initialize Java Swing components for UserView
	 */
	public void initComponents() {
		
		JLabel lblCurrentlyFollowing = new JLabel("Currently Following");
		
		JLabel lblTweetMessage = new JLabel("Tweet Message");
		
		JLabel lblNewsFeed = new JLabel("News Feed");

		DefaultListModel<String> userNewsFeed = user.getFeed();
		/**
		 * Retrieve newsFeed if exists, otherwise create new
		 */
		if (userNewsFeed != null) {
			listFeed = new JList(userNewsFeed);
		}
		else {
			listFeed = new JList<>();
		}
		scrollPaneFeed = new JScrollPane(listFeed);

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
