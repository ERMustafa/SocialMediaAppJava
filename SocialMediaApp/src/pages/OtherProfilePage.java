package pages;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.text.AbstractDocument.Content;

import panels.ContentPanel;
import panels.NextLine;
import panels.UserInformation;
import storage.User;

public class OtherProfilePage implements ActionListener {
	
	private User currentUser;
	private User otherUser;
	private JFrame otherProfilePage;
	
	private JButton followButton;
	private JButton unfollowButton;
	
	private ContentPanel cPanel;
	
	private JButton next;
	private JButton previous;

	int position;
	
	private JMenuBar menuBar;
	private JMenu options;
	private JMenuItem goHomePage;
	private JMenuItem logout;
	private JMenuItem profile;
	private NextLine nl1;
	
	public OtherProfilePage(User currentUser, User otherUser) {
		this.currentUser = currentUser;
		this.otherUser = otherUser;
		
		
		otherProfilePage = new JFrame();
		otherProfilePage.setLayout(new FlowLayout(FlowLayout.CENTER));
		otherProfilePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		otherProfilePage.setSize(1200, 800);
		otherProfilePage.setLocationRelativeTo(null);
		otherProfilePage.setResizable(false);
		
		menuBar = new JMenuBar();
	
		options = new JMenu("Options");
		options.setHorizontalAlignment(SwingConstants.RIGHT);
		
		profile = new JMenuItem("Profile");
		logout = new JMenuItem("Log out");
		goHomePage = new JMenuItem("Go to home");
		
		profile.addActionListener(this);
		logout.addActionListener(this);
		goHomePage.addActionListener(this);
		
		options.add(profile);
		options.add(goHomePage);
		options.add(logout);
		
		menuBar.add(options);
		
		otherProfilePage.setJMenuBar(menuBar);
		
		if (currentUser.getFollowings().contains(otherUser)) {
			
			UserInformation userInformation = new UserInformation(otherUser);
			
			position = 0;
			
			unfollowButton = new JButton("Unfollow");
			unfollowButton.addActionListener(this);
			unfollowButton.setPreferredSize(new Dimension(200,50));
			
			
			
			next = new JButton("next");
			previous = new JButton("previous");
			
			next.addActionListener(this);
			previous.addActionListener(this);
			
			cPanel = new ContentPanel(otherUser.getContents().get(position));
			nl1 = new NextLine();
			
			otherProfilePage.add(userInformation);
			otherProfilePage.add(unfollowButton);
			otherProfilePage.add(nl1);
			otherProfilePage.add(next);
			otherProfilePage.add(previous);
			otherProfilePage.getContentPane().add(cPanel);
			
			
			
		} else {
			UserInformation userInformation = new UserInformation(otherUser);
			
			followButton = new JButton("Follow");
			followButton.addActionListener(this);
			followButton.setPreferredSize(new Dimension(200,50));
			
			otherProfilePage.add(userInformation);
			otherProfilePage.add(followButton);
		}
		otherProfilePage.setVisible(true);
	}
	/**
	 * if action equals to profile
	 * go to user's profile with YourProfilePage class
	 * 
	 * if action equals to goHomePage
	 * it returns to home page
	 * 
	 * if action equals to logout
	 * it returns to sign in page
	 * 
	 * if action equals to followButton
	 * it starts to follow the user
	 * reopen the other user's profile page
	 * 
	 * if action equals to unfollowButton
	 * it starts to unfollow the user
	 * reopen the other user's profile page
	 * 
	 * if action equals to next
	 * it displays next content of user if any
	 * 
	 * if action equals to previous
	 * it displays previous content of user if any
	 * 
	 */
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == followButton) {
			otherProfilePage.dispose();
			currentUser.follow(otherUser);
			OtherProfilePage otherProfilePage = new OtherProfilePage(currentUser, otherUser);
		}
		else if (e.getSource() == unfollowButton) {
			otherProfilePage.dispose();
			currentUser.unfollow(otherUser);
			OtherProfilePage otherProfilePage = new OtherProfilePage(currentUser, otherUser);
		}
		else if (e.getSource() == next) {
			
			if(position+1<otherUser.getContents().size()) {
				otherProfilePage.getContentPane().remove(cPanel);
				position ++;
				cPanel = new ContentPanel(otherUser.getContents().get(position));
				otherProfilePage.getContentPane().add(cPanel);
				otherProfilePage.revalidate();
				otherProfilePage.repaint();
			}
			
			
		} 
		else if (e.getSource() == previous) {
			
			if(position>0) {
				
				otherProfilePage.getContentPane().remove(cPanel);
				position --;
				cPanel = new ContentPanel(otherUser.getContents().get(position));
				otherProfilePage.getContentPane().add(cPanel);
				otherProfilePage.revalidate();
				otherProfilePage.repaint();
			}
		}
		else if (e.getSource() == profile) {
			otherProfilePage.dispose();
			YourProfilePage ypp = new YourProfilePage(currentUser);
		}
		else if (e.getSource() == logout) {
			otherProfilePage.dispose();
			SignInPage sip = new SignInPage();
		}
		else if (e.getSource() == goHomePage) {
			otherProfilePage.dispose();
			HomePage homePage = new HomePage(currentUser);
		}
	
		
	}
}
