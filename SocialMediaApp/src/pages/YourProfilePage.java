package pages;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import panels.ContentPanel;
import panels.NextLine;
import panels.UserInformation;
import storage.Content;
import storage.Group;
import storage.User;
import utilityFrames.CNC_API;
import utilityFrames.CreateGroup;
import utilityFrames.EditContentProfile;
import utilityFrames.EditInfo;

public class YourProfilePage implements ActionListener{
	User user;
	JFrame yourProfilePage;
	
	ContentPanel cPanel = null;
	
	JPanel listing;
	JList<String> yourFollowings;
	JList<String> yourGroups;
	JList<String> yourSuggestedUsersList;
	JList<String> yourSuggestedGroupsList;
	
	JLabel yourFollowingUsers;
	JLabel yourFollowingGroups;
	JLabel yourSuggestedUsers;
	JLabel yourSuggestedGroups;
	
	JMenuItem createGroup;
	JMenuItem goHomePage;
	JMenuItem logout;
	JMenuItem editInformation;
	JMenuItem profile; 
	JMenuItem deleteAccount;
	JMenu options;
	JMenuBar menuBar;
	
	
	ArrayList<String> followingNicknames;
	ArrayList<String> followingGroupnames;
	
	JScrollPane yourFollowingsScroll;
	JScrollPane yourGroupsScroll;
	JScrollPane suggestedUsersScroll;
	JScrollPane suggestedGroupsScroll;
	
	JButton next;
	JButton previous;
	JButton edit;
	
	NextLine nl1;
	NextLine nl2;
	
	int position;
	
	JButton createButton;
	JButton removeButton;
	
	JLabel noContent;

	
	public YourProfilePage(User user) {
		
		this.user = user;
		
		
		yourProfilePage = new JFrame("Your Profile");
		yourProfilePage.setPreferredSize(new Dimension(1200,800));
		yourProfilePage.setMinimumSize(new Dimension(1200,800));
		yourProfilePage.setLayout(new FlowLayout(FlowLayout.CENTER));
		yourProfilePage.setLocationRelativeTo(null);
		yourProfilePage.setResizable(false);
		
		menuBar = new JMenuBar();
		
		options = new JMenu("Options");
		//options.setHorizontalAlignment(SwingConstants.RIGHT);
		
		profile = new JMenuItem("Profile");
		logout = new JMenuItem("Log out");
		editInformation = new JMenuItem("Edit Your Personal Info");
		goHomePage = new JMenuItem("Go to home");
		createGroup = new JMenuItem("Create Group");
		deleteAccount = new JMenuItem("Delete Account");
		
		profile.addActionListener(this);
		logout.addActionListener(this);
		editInformation.addActionListener(this);
		goHomePage.addActionListener(this);
		createGroup.addActionListener(this);
		deleteAccount.addActionListener(this);
		
		options.add(profile);
		options.add(editInformation);
		if(user.getIsPremium()) {
			options.add(createGroup);
		}
		options.add(goHomePage);
		options.add(deleteAccount);
		options.add(logout);
		
		menuBar.add(options);
		
		yourProfilePage.setJMenuBar(menuBar);
		
		UserInformation userInfoPanel = new UserInformation(user);
		userInfoPanel.setSize(new Dimension(600,200));
		
		followingNicknames = new ArrayList<String>();
		followingGroupnames = new ArrayList<String>();
		
		yourFollowingUsers = new JLabel("Your Following Users");
		yourFollowingGroups = new JLabel("Your Following Groups");
		yourSuggestedUsers = new JLabel("Suggested Users");
		yourSuggestedGroups = new JLabel("Suggested Groups");
		
		yourSuggestedGroups.setPreferredSize(new Dimension(300,50));
		
		
		for(User us : user.getFollowings()) {
			followingNicknames.add(us.getNickname());
		}
		for(Group gr : user.getGroups()) {
			followingGroupnames.add(gr.getName());
		}
		
		
		yourFollowings = new JList(followingNicknames.toArray());
		yourFollowings.setVisibleRowCount(4);
		yourFollowings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		yourGroups = new JList(followingGroupnames.toArray());
		yourGroups.setVisibleRowCount(4);
		yourGroups.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		yourSuggestedUsersList = new JList(user.getSuggestedUsers().toArray());
		yourSuggestedUsersList.setVisibleRowCount(4);
		yourSuggestedUsersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		yourSuggestedGroupsList = new JList(user.getSuggestedGroups().toArray());
		yourSuggestedGroupsList.setVisibleRowCount(4);
		yourSuggestedGroupsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		listing = new JPanel();
		listing.setPreferredSize(new Dimension(1200, 100));
		
		yourFollowingsScroll = new JScrollPane(yourFollowings);
		yourGroupsScroll = new JScrollPane(yourGroups);
		suggestedUsersScroll = new JScrollPane(yourSuggestedUsersList);
		suggestedGroupsScroll = new JScrollPane(yourSuggestedGroupsList);
		
		yourFollowingsScroll.setPreferredSize(new Dimension(200,50));
		yourGroupsScroll.setPreferredSize(new Dimension(200,50));
		suggestedUsersScroll.setPreferredSize(new Dimension(200,50));
		suggestedGroupsScroll.setPreferredSize(new Dimension(200,50));
		
		
		createButton = new JButton("Create");
		createButton.addActionListener(this);
		
		removeButton = new JButton("Remove");
		removeButton.addActionListener(this);
		
		
		position = 0;
		
		if(user.getContents().size() != 0) {
			cPanel = new ContentPanel(user.getContents().get(position));
		} else {
			noContent = new JLabel("There is no content to show :(");
			nl2 = new NextLine();
		}
		
		nl1 = new NextLine();
		
		next = new JButton("next");
		previous = new JButton("previous");
		edit = new JButton("edit");
		
		next.addActionListener(this);
		previous.addActionListener(this);
		edit.addActionListener(this);
		
		listing.add(yourFollowingUsers);
		listing.add(yourFollowingsScroll);
		listing.add(yourFollowingGroups);
		listing.add(yourGroupsScroll);
		listing.add(yourSuggestedUsers);
		listing.add(suggestedUsersScroll);
		listing.add(yourSuggestedGroups);
		listing.add(suggestedGroupsScroll);
		
		yourProfilePage.add(userInfoPanel);
		yourProfilePage.add(listing);
		yourProfilePage.add(createButton);
		yourProfilePage.add(next);
		yourProfilePage.add(previous);
		yourProfilePage.add(nl1);
		yourProfilePage.add(removeButton);
		yourProfilePage.add(edit);
		if (cPanel == null) {
			yourProfilePage.add(nl2);
			yourProfilePage.add(noContent);
		} else {
			yourProfilePage.add(cPanel);
		}
		
	
		yourProfilePage.setVisible(true);
	
	
	}
	
	/**
	 * 
	 * if action equals to profile
	 * go to user's profile with YourProfilePage class
	 * 
	 * if action equals to editInformation
	 * opens a edit info panel with EditInfo class
	 * 
	 * if action equals to createGroup
	 * opens a window to create a group with CreateGroup class
	 * 
	 * if action equals to deleteAccount
	 * it deletes the user's account from the application and return to sign in page
	 * 
	 * if action equals to goHomePage
	 * it returns to home page
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
	 * it opens a edit content panel to edit the content
	 * 
	 * if action equals to next
	 * it displays the next content if any
	 * 
	 * if action equals to previous
	 * it displays the previous content if any
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==profile) {
			yourProfilePage.dispose();
			YourProfilePage yP = new YourProfilePage(user);
		} else if (e.getSource()==editInformation) {
			yourProfilePage.dispose();
			EditInfo editInfo = new EditInfo(user);
		} else if (e.getSource()==createGroup) {
			yourProfilePage.dispose();
			CreateGroup createGroup = new CreateGroup(user);
			
		} else if (e.getSource()==deleteAccount) {
			User.deleteAccount(user);
			yourProfilePage.dispose();
			SignInPage signInPage = new SignInPage();
		}
		
		
		else if (e.getSource()==goHomePage) {
			yourProfilePage.dispose();
			HomePage homePage = new HomePage(user);
		} else if (e.getSource()==logout) {
			yourProfilePage.dispose();
			SignInPage signInPage = new SignInPage();
		} else if(e.getSource()==createButton) {
			yourProfilePage.dispose();
			CNC_API cnc_api = new CNC_API(user, null, 1);
		} else if(e.getSource()==removeButton) {
			yourProfilePage.dispose();
			if(user.getGroupContents().containsKey(user.getContents().get(position))) {
				Content c = user.getContents().get(position);
				user.deleteContentGroup(c, user.getGroupContents().get(c));
			} else {
				user.deleteContent(user.getContents().get(position));
			}
			YourProfilePage ypp = new YourProfilePage(user);
		}
		
		
		else if (e.getSource() == next) {

			if (position+1<user.getContents().size()) {
				position ++;
				yourProfilePage.remove(cPanel);
				cPanel = new ContentPanel(user.getContents().get(position));
				yourProfilePage.add(cPanel);
				yourProfilePage.setVisible(true);
			}
		} else if (e.getSource() == previous) {
			if (position>0) {
				System.out.println(position);
				position --;
				yourProfilePage.remove(cPanel);
				cPanel = new ContentPanel(user.getContents().get(position));
				yourProfilePage.add(cPanel);
				yourProfilePage.setVisible(true);
			}
			
			
		} else if (e.getSource() == edit) {
			yourProfilePage.dispose();
			EditContentProfile editContent = new EditContentProfile(user.getContents().get(position), user);
		}
	}
}
