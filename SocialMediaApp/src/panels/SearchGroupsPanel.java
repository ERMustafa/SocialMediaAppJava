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

import pages.GroupPage;
import pages.SignInPage;
import storage.Group;
import storage.User;

public class SearchGroupsPanel extends JPanel implements ActionListener{
	JTextField searchForGroups;
	JButton confirmSearchForGroups;
	JLabel notFoundLabel;
	JFrame frame;
	User user;
	
	public SearchGroupsPanel(JFrame frame, User user) {
		
		this.frame = frame;
		this.user = user;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setPreferredSize(new Dimension(500,40));
		
		searchForGroups = new JTextField("Search For Groups");
		searchForGroups.setPreferredSize(new Dimension(200, 40));
		
		confirmSearchForGroups = new JButton();
		confirmSearchForGroups.setText("Search");
		confirmSearchForGroups.setSize(new Dimension(50,40));
		
		confirmSearchForGroups.addActionListener(this);

		
		notFoundLabel = new JLabel("Not Found!");
		notFoundLabel.setVisible(false);
		
		this.add(searchForGroups);
		this.add(confirmSearchForGroups);
		this.add(notFoundLabel);
		
		
		
	}

	/**
	 * 
	 * if action equals to "Search" 
	 * 
	 * it iterates the groups array and find if any matches found
	 * 
	 * if matches found, it opens the group's page with the GroupPage class
	 * 
	 * if not, it shows an error message
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==confirmSearchForGroups) {
			boolean indicator = true;
			String name = searchForGroups.getText();
			for (Group gr : Group.getGroups()) {
				if(gr.getName().equals(name)) {
					frame.dispose();
					GroupPage ogp = new GroupPage(gr, user);
					indicator = false;
				}
			}
			if(indicator) {
				notFoundLabel.setVisible(true);
			}
		} 
		
	}

}
