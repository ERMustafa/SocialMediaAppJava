package pages;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import panels.ContentPanel;
import panels.GroupInformation;
import panels.NextLine;
import storage.Content;
import storage.Group;
import storage.User;
import utilityFrames.CNC_API;
import utilityFrames.EditContentGroup;

public class GroupPage implements ActionListener {
	JFrame groupPage;
	JMenuBar menuBar;
	JMenu options;
	JMenuItem profile;
	JMenuItem removeMember;
	JMenuItem logout;
	JMenuItem goHomePage;
	JMenuItem deleteGroup;
	
	User user;
	JButton join;
	JButton leave;
	
	JButton yourContentButton;
	JButton membersContentButton;
	
	JButton editButton;
	JButton createButton;
	JButton removeButton;
	
	JButton next;
	JButton previous;
	
	JList<String> membersList;
	JLabel creatorLabel;
	JLabel membersLabel;
	
	int currentPosition;
	int yourCount;
	int membersCount;
	
	
	JPanel listing;
	
	ContentPanel cPanel;
	
	ArrayList<Content> yourContent;
	ArrayList<Content> othersContent;
	
	NextLine nl1;
	NextLine nl2;
	NextLine nl3;
	NextLine nl4;
	
	JScrollPane membersScroll;
	
	Group group;
	
	JLabel noContent;
	
	


	public GroupPage(Group group, User user) {
		
		currentPosition = 0; // 0 for yours 1 for other members'
		yourCount = 0;
		membersCount = 0;
		
		this.group = group;
		this.user = user;
		
		groupPage = new JFrame();
		groupPage.setLayout(new FlowLayout(FlowLayout.CENTER));
		groupPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		groupPage.setSize(1200, 900);
		groupPage.setLocationRelativeTo(null);
		groupPage.setMinimumSize(new Dimension(1200,800));
		groupPage.setResizable(false);
		
		
		menuBar = new JMenuBar();
	
		options = new JMenu("Options");
		options.setHorizontalAlignment(SwingConstants.RIGHT);
		
		profile = new JMenuItem("Profile");
		logout = new JMenuItem("Log out");
		goHomePage = new JMenuItem("Go to home");
		removeMember = new JMenuItem("Remove a Member");
		deleteGroup = new JMenuItem("Delete this group");
		
		
		profile.addActionListener(this);
		logout.addActionListener(this);
		goHomePage.addActionListener(this);
		removeMember.addActionListener(this);
		deleteGroup.addActionListener(this);
		
		options.add(profile);
		options.add(goHomePage);
		if(user == group.getCreator()) {
			options.add(removeMember);
			options.add(deleteGroup);
		}
		options.add(logout);
		
		menuBar.add(options);
		
		groupPage.setJMenuBar(menuBar);
	
		if(user.getGroups().contains(group)) {
			GroupInformation groupInfoPanel = new GroupInformation(group);
			
			ArrayList<String> memberNames = new ArrayList<String>();
			
			for (User us : group.getUsers()) {
				memberNames.add(us.getNickname());
			}
			
			listing = new JPanel();
			listing.setLayout(new FlowLayout(FlowLayout.CENTER));
			listing.setPreferredSize(new Dimension(600,100));
			
			membersLabel = new JLabel("Members: ");
			
			membersList = new JList(memberNames.toArray());
			membersList.setVisibleRowCount(4);
			membersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			membersScroll = new JScrollPane(membersList);
			
			membersScroll.setPreferredSize(new Dimension(200,50));
			
			listing.add(membersLabel);
			listing.add(membersScroll);
			
			
			creatorLabel = new JLabel("Creator: " + group.getCreator().getNickname());
			creatorLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
			creatorLabel.setPreferredSize(new Dimension(300,100));
			
			leave = new JButton("Leave");
			leave.setPreferredSize(new Dimension(100,50));
			leave.addActionListener(this);
			
			groupPage.add(groupInfoPanel);
			groupPage.add(listing);
			groupPage.add(creatorLabel);
			groupPage.add(leave);
			
			yourContentButton = new JButton("Your Content");
			membersContentButton = new JButton("Other Members' Content");
			
			next = new JButton("Next");
			previous = new JButton("Previous");
			
			editButton = new JButton("Edit");
			createButton = new JButton("Create");
			removeButton = new JButton("Remove: ");
			
			yourContentButton.addActionListener(this);
			membersContentButton.addActionListener(this);
			
			next.addActionListener(this);
			previous.addActionListener(this);
			
			editButton.addActionListener(this);
			createButton.addActionListener(this);
			removeButton.addActionListener(this);
			
			othersContent = new ArrayList<Content>();
			yourContent = new ArrayList<Content>();
			
			for (Content content : group.getContents()) {
				if (content.getAuthor()==user) {
					yourContent.add(content);
				} else {
					othersContent.add(content);
				}
			}
			
			if(yourContent.size()==0) {
				noContent = new JLabel("No content to show :(");
				nl4 = new NextLine();
			} else {
				cPanel = new ContentPanel(yourContent.get(yourCount));
			}
			
			
			
			nl1 = new NextLine();
			nl2 = new NextLine();
			nl3 = new NextLine();
			
			groupPage.add(nl3);
			groupPage.add(yourContentButton);
			groupPage.add(membersContentButton);
			groupPage.add(nl1);
			groupPage.add(editButton);
			groupPage.add(removeButton);
			groupPage.add(createButton);
			groupPage.add(nl2);
			groupPage.add(previous);
			groupPage.add(next);
			if (cPanel == null) {
				groupPage.add(nl4);
				groupPage.add(noContent);
			} else {
				groupPage.add(cPanel);
			}
			
			
			
			
		} else {
			GroupInformation groupInfoPanel = new GroupInformation(group);
			join = new JButton("Join");
			join.setPreferredSize(new Dimension(200,200));
			join.addActionListener(this);
			
			groupPage.add(groupInfoPanel);
			groupPage.add(join);
		}
		
		groupPage.setVisible(true);
		
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
	 * if action equals to removeMember
	 * it removes the indicated member of the group from the group
	 * 
	 * if action equals to yourContentButton
	 * it starts to display your contents
	 * 
	 * if action equals to membersContentButton
	 * it starts to display members' contents
	 * 
	 * if action equals to leave
	 * the current user leaves the group
	 * reopen the group page
	 * 
	 * if action equals to join
	 * the current user joins the group
	 * reopen the group page
	 * 
	 * if action equals to editButton
	 * it opens a panel to edit the currently displayed content in the group
	 * 
	 * if action equals to createButton
	 * it opens a panel to create new contents in the group
	 * 
	 * if action equals to removeButton
	 * it deletes the currently displayed content
	 * 
	 */


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == profile) {
			groupPage.dispose();
			YourProfilePage ypp = new YourProfilePage(user);
		}
		else if (e.getSource() == logout) {
			groupPage.dispose();
			SignInPage sip = new SignInPage();
		}
		else if (e.getSource() == goHomePage) {
			groupPage.dispose();
			HomePage homePage = new HomePage(user);
		} else if (e.getSource() == removeMember) {
			
			
			User whoToRemove = null;
			
			String nickname = JOptionPane.showInputDialog("Enter a Nickname to Remove");
			
			for (User user : group.getUsers()) {
				if (user.getNickname().equals(nickname)) {
					
					whoToRemove = user;
				}
			}
			
			whoToRemove.leaveGroup(group);
			
			if (whoToRemove != null) {
				for (Content content : group.getContents()) {
					if (content.getAuthor() == whoToRemove) {
						group.deleteContent(content);
					}
				}
			}
			
			groupPage.dispose();
			GroupPage gp = new GroupPage(group, user);
			
		}  else if (e.getSource() == deleteGroup) {
			Group.deleteGroup(group);
			groupPage.dispose();
			HomePage hp = new HomePage(user);
		}
		
		
		else if (e.getSource() == yourContentButton) {
			
			editButton.setVisible(true);
			removeButton.setVisible(true);
			
			currentPosition = 0;
			groupPage.remove(cPanel);
			cPanel = new ContentPanel(yourContent.get(yourCount));
			groupPage.add(cPanel);
			groupPage.setVisible(true);
			
		} 
		
		
		else if (e.getSource()==leave) {
			user.leaveGroup(group);
			groupPage.dispose();
			GroupPage ogp = new GroupPage(group, user);
		} else if (e.getSource()==join) {
			user.getIntoGroup(group);
			groupPage.dispose();
			GroupPage ogp = new GroupPage(group, user);
		}
		
		
		
		else if (e.getSource() == membersContentButton) {
			
			if(noContent != null) {
				noContent.setVisible(false);
			}
			
			editButton.setVisible(false);
			removeButton.setVisible(false);
			
			currentPosition = 1;
			if(cPanel != null) {
				groupPage.remove(cPanel);
			}
			
			cPanel = new ContentPanel(othersContent.get(yourCount));
			groupPage.add(cPanel);
			groupPage.setVisible(true);
			
		} else if (e.getSource() == editButton) {
			
			groupPage.dispose();
			EditContentGroup ecg = new EditContentGroup(yourContent.get(yourCount), user, group);
			
			
			
		} else if (e.getSource() == createButton) {
			groupPage.dispose();
			CNC_API cnc_api = new CNC_API(user, group, 2);
			
		}  else if (e.getSource() == removeButton) {
			user.deleteContentGroup(yourContent.get(yourCount), group);
			groupPage.dispose();
			GroupPage ogp = new GroupPage(group, user);
		}
		
		else if (e.getSource() == next) {
			
			if(currentPosition == 0) {
				if(yourCount+1<yourContent.size()) {
					yourCount ++;
					groupPage.remove(cPanel);
					cPanel = new ContentPanel(yourContent.get(yourCount));
					groupPage.add(cPanel);
					groupPage.setVisible(true);
				}
			} else if (currentPosition == 1) {
				if(membersCount+1<othersContent.size()) {
					membersCount ++;
					groupPage.remove(cPanel);
					cPanel = new ContentPanel(othersContent.get(membersCount));
					groupPage.add(cPanel);
					groupPage.setVisible(true);
				}
			}
			
		} else if (e.getSource() == previous) {
			if(currentPosition == 0) {
				if(yourCount>0) {
					yourCount --;
					groupPage.remove(cPanel);
					cPanel = new ContentPanel(yourContent.get(yourCount));
					groupPage.add(cPanel);
					groupPage.setVisible(true);
				}
			} else if (currentPosition == 1) {
				if(membersCount>0) {
					membersCount --;
					groupPage.remove(cPanel);
					cPanel = new ContentPanel(othersContent.get(membersCount));
					groupPage.add(cPanel);
					groupPage.setVisible(true);
				}
			}
		} 
		
	}
}
