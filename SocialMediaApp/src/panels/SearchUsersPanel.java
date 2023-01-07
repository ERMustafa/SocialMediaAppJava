package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pages.OtherProfilePage;
import pages.SignInPage;
import storage.User;

public class SearchUsersPanel extends JPanel implements ActionListener{
	JTextField searchForUsers;
	JButton confirmSearchForUsers;
	JLabel notFoundLabel;
	JFrame frame;
	User currentUser;

	public SearchUsersPanel(JFrame frame, User currentUser) {
		
		this.frame = frame;
		this.currentUser = currentUser;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setPreferredSize(new Dimension(500,40));
		
		searchForUsers = new JTextField("Search For Users");
		searchForUsers.setPreferredSize(new Dimension(200, 40));
		
		confirmSearchForUsers = new JButton();
		confirmSearchForUsers.setText("Search");
		confirmSearchForUsers.setSize(new Dimension(60,40));
		

		confirmSearchForUsers.addActionListener(this);
		
		notFoundLabel = new JLabel("Not Found!");
		notFoundLabel.setVisible(false);
		
		this.add(searchForUsers);
		this.add(confirmSearchForUsers);
		this.add(notFoundLabel);
		
		
		
	}
	
	/**
	 * 
	 * if action equals to "Search" 
	 * 
	 * it iterates the users array and find if any matches found
	 * 
	 * if matches found, it opens the user's profile page with OtherProfilePage class
	 * 
	 * if not, it shows an error message
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==confirmSearchForUsers) {
			int indicator = 0;
			String nickname = searchForUsers.getText();
			
			for (User user : User.getUsers()) {
				
				if (user.getNickname().equals(nickname)) {
					frame.dispose();
					OtherProfilePage otherProfilePage = new OtherProfilePage(currentUser, user);
					indicator = 1;
				}
			}
			
			
			if(indicator == 0) {
				notFoundLabel.setVisible(true);
			}
		}
		
	}

}
