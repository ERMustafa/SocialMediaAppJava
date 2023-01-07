package pages;
import javax.swing.*;

import panels.ContentPanel;
import panels.NextLine;
import panels.SearchContentsPanel;
import panels.SearchGroupsPanel;
import panels.SearchUsersPanel;
import storage.User;
import utilityFrames.CNC_API;
import storage.Group;
import storage.Content;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePage implements ActionListener {
	
	JFrame homePage;
	JLabel topLabel;
	
	ArrayList<Content> groupContents;
	ArrayList<Content> userContents;
	
	JMenuItem profile;
	JMenuItem logout;
	JMenu options;
	JMenuBar menuBar;
	
	int userContentCount;
	int yourContentCount;
	int groupContentCount;
	
	JButton yourContentButton;
	JButton usersContentButton;
	JButton groupsContentButton;
	
	JButton nextButton;
	JButton previousButton;
	
	ContentPanel cPanel;
	NextLine nl1;
	NextLine nl2;
	NextLine nl3;
	
	
	
	
	SignInPage signInPage;
	
	User user;
	
	int currentPosition;
	
	JButton createButton;
	
	JLabel noContent;
	
	public HomePage(User user) {
		
		userContents = new ArrayList<Content>();
		groupContents = new ArrayList<Content>();
		
		this.user = user;
		
		homePage = new JFrame();
		homePage.setLayout(new FlowLayout());
		homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		homePage.setSize(1200, 800);
		homePage.setLocationRelativeTo(null);
		homePage.setResizable(false);
		
		menuBar = new JMenuBar();
		
		options = new JMenu("Options");
		options.setHorizontalAlignment(SwingConstants.RIGHT);
		
		profile = new JMenuItem("Profile");
		logout = new JMenuItem("Log out");
		
		SearchUsersPanel searchUsers = new SearchUsersPanel(homePage, user);
		SearchGroupsPanel searchGroups = new SearchGroupsPanel(homePage, user);
		SearchContentsPanel searchContents = new SearchContentsPanel(homePage, user);
		
		createButton = new JButton("Create");
		createButton.addActionListener(this);
		
		
		logout.addActionListener(this);
		profile.addActionListener(this);
		
		options.add(profile);
		options.add(logout);
		menuBar.add(options);
		
		
		
		userContentCount = 0;
		yourContentCount = 0;
		groupContentCount = 0;
		
		currentPosition = 0; //0 for user's  // 1 for other users'  // 2 for groups' for Content Display
		
		yourContentButton = new JButton("Your Contents");
		usersContentButton = new JButton("Users' Contents");
		groupsContentButton = new JButton("Groups' Contents");
		
		yourContentButton.addActionListener(this);
		usersContentButton.addActionListener(this);
		groupsContentButton.addActionListener(this);
		
		nextButton = new JButton("Next");
		previousButton = new JButton("Previous");
		
		nextButton.addActionListener(this);
		previousButton.addActionListener(this);
		
		for (Group group : user.getGroups()) {
			for (Content content : group.getContents()) {
				groupContents.add(content);
			}
		}
		
		for (User following : user.getFollowings()) {
			for (Content content : following.getContents()) {
				userContents.add(content);
				
			}
		}
		
		if (user.getContents().size()== 0) {
			noContent = new JLabel("No content to show");
		} else {
			cPanel = new ContentPanel(user.getContents().get(0));
		}
		
		
		nl1 = new NextLine();
		nl2 = new NextLine();
		nl3 = new NextLine();
		
		homePage.setJMenuBar(menuBar);
		homePage.add(createButton);
		homePage.add(nl1);
		homePage.add(searchUsers);
		homePage.add(searchGroups);
		homePage.add(searchContents);
		homePage.add(nl3);
		homePage.add(yourContentButton);
		homePage.add(usersContentButton);
		homePage.add(groupsContentButton);
		homePage.add(nl2);
		homePage.add(nextButton);
		homePage.add(previousButton);
		if(cPanel != null) {
			homePage.add(cPanel);
			
			
		}	else {
			homePage.add(noContent);
			
		}

		homePage.setVisible(true);
		
	}
	
	/**
	 * 
	 * if action equals to profile
	 * go to user's profile with YourProfilePage class
	 * 
	 * if action equals to logout
	 * it returns to sign in page
	 * 
	 * if action equals to createButton
	 * it opens a new window to create a new content
	 * 
	 * if action equals to removeButton
	 * it deletes the currently displayed content and
	 * returns to your profile page again
	 * 
	 * if action equals to edit
	 * it opens a edit content panel to edit the currently displayed content
	 * 
	 * if action equals to next
	 * it displays the next content if any
	 * 
	 * if action equals to previous
	 * it displays the previous content if any
	 * 
	 * current position = 0 if currently displayed contents are user's contents
	 * current position = 1 if currently displayed contents are users' contents
	 * current position = 2 if currently displayed contents are group members contents
	 * 
	 * if action equals to groupContentButton
	 * it sets the current position to 2
	 * it displays the group contents
	 * 
	 * if action equals to yourContentButton
	 * it sets the current position to 0
	 * it displays your contents
	 * 
	 * if action equals to usersContentButton
	 * it sets the current position to 1
	 * it displays following users' contents
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logout) {
			homePage.dispose();
			signInPage = new SignInPage();
		}
		
		else if (e.getSource()==profile) {
			homePage.dispose();
			YourProfilePage yourProfilePage = new YourProfilePage(user);
		}
		
		else if (e.getSource() == yourContentButton) {
			homePage.remove(cPanel);
			cPanel = new ContentPanel(user.getContents().get(yourContentCount));
			
			homePage.add(cPanel);
			homePage.setVisible(true);
			currentPosition = 0;
		}
		
		else if (e.getSource() == createButton) {
			homePage.dispose();
			CNC_API createNewContent = new CNC_API(user, null, 0);
		}
		else if (e.getSource() == usersContentButton) {
			currentPosition = 1;
			homePage.remove(cPanel);
			cPanel = new ContentPanel(userContents.get(userContentCount));
			homePage.remove(cPanel);
			homePage.add(cPanel);
			homePage.setVisible(true);
		}
		else if (e.getSource() == groupsContentButton) {
			currentPosition = 2;
			homePage.remove(cPanel);
			cPanel = new ContentPanel(groupContents.get(groupContentCount));
			
			homePage.add(cPanel);
			homePage.setVisible(true);
		}
		else if (e.getSource() == nextButton) {
			
			if (currentPosition == 0) {
			
				if (yourContentCount+1 != user.getContents().size()) {
					yourContentCount ++;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(user.getContents().get(yourContentCount));
					homePage.add(cPanel);
					homePage.setVisible(true);
				
				}
			}
			if (currentPosition == 1) {
				if (userContentCount+1 != userContents.size()) {
					userContentCount ++;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(userContents.get(userContentCount));
					
					homePage.add(cPanel);
					homePage.setVisible(true);
				}
			}
			if (currentPosition ==2) {
				if (groupContentCount+1 != groupContents.size()) {
					groupContentCount ++;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(groupContents.get(groupContentCount));
					
					homePage.add(cPanel);
					homePage.setVisible(true);
				}
			}
		}
		else if (e.getSource() == previousButton) {
			
			if (currentPosition == 0) {
				if (yourContentCount > 0) {
					yourContentCount --;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(user.getContents().get(yourContentCount));
					
					homePage.add(cPanel);
					homePage.setVisible(true);
				}
			}
			if (currentPosition == 1) {
				if (userContentCount > 0) {
					userContentCount --;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(userContents.get(userContentCount));
					homePage.add(cPanel);
					homePage.setVisible(true);
				}
			}
			if (currentPosition ==2) {
				if (groupContentCount > 0) {
					groupContentCount --;
					homePage.remove(cPanel);
					cPanel = new ContentPanel(groupContents.get(groupContentCount));
					homePage.add(cPanel);
					homePage.setVisible(true);
				}
			}
		
		
		}
	}
}
