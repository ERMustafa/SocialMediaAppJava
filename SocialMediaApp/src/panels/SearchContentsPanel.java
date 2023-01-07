package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pages.OtherProfilePage;
import storage.Content;
import storage.User;
import utilityFrames.ShowContent;

public class SearchContentsPanel extends JPanel implements ActionListener {
	JTextField searchForContents;
	JButton confirmSearchForContents;
	JLabel notFoundLabel;
	JFrame frame;
	User user;
	
	public SearchContentsPanel(JFrame frame, User user) {
		
		this.frame = frame;
		this.user = user;
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		this.setPreferredSize(new Dimension(500,40));
		
		searchForContents = new JTextField("Search For Contents");
		searchForContents.setPreferredSize(new Dimension(200, 40));
		
		confirmSearchForContents = new JButton();
		confirmSearchForContents.setText("Search");
		confirmSearchForContents.setSize(new Dimension(50,40));
		
		confirmSearchForContents.addActionListener(this);

		
		notFoundLabel = new JLabel("Not Found!");
		notFoundLabel.setVisible(false);
		
		this.add(searchForContents);
		this.add(confirmSearchForContents);
		this.add(notFoundLabel);
		
		
		
	}

	/**
	 * 
	 * if action equals to "Search" 
	 * 
	 * it iterates the titles array and find if any matches found
	 * 
	 * if matches found, it opens the content with the class ShowContent
	 * 
	 * if not, it shows an error message
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource()==confirmSearchForContents) {
			int indicator = 0;
			String title = searchForContents.getText();
			
			if (Content.getTitles().contains(title)) {
				indicator = 1;
				frame.dispose();
				ShowContent sc = new ShowContent(Content.getContents().get(title), user);
			}
			
			
			if(indicator == 0) {
				notFoundLabel.setVisible(true);
			}
		
	}
}
}
