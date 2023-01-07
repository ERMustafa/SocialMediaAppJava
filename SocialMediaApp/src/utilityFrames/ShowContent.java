package utilityFrames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import pages.HomePage;
import panels.ContentPanel;
import storage.Content;
import storage.User;

public class ShowContent extends JFrame implements ActionListener{
	
	JButton backButton;
	User user;
	
	public ShowContent(Content content, User user) {
		
		this.user = user;
		
		this.setTitle("Content");
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(1200,500));
		this.setMinimumSize(new Dimension(1200,500));
		this.setLocationRelativeTo(null);
		
		
		ContentPanel cPanel = new ContentPanel(content);
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		
		this.add(cPanel);
		this.add(backButton);
		
		this.setVisible(true);
	}
	
	/**
	 * If action equals to "back" go back to the home page with HomePage class
	 * 
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == backButton) {
			this.dispose();
			HomePage hp = new HomePage(user);
		}
		
	}
}
