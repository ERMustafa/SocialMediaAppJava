package utilityFrames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pages.YourProfilePage;
import storage.Group;
import storage.User;

public class CreateGroup implements ActionListener {
	User user;
	
	JFrame createGroup;
	
	JPanel countryPanel;
	JPanel namePanel;
	JPanel hobbiesPanel;
	
	JTextField countryTextField;
	JTextField nameTextField;
	JTextField hobbiesTextField;
	
	JLabel countryLabel;
	JLabel nameLabel;
	JLabel hobbiesLabel;
	JLabel errorMassage;
	
	JButton backButton;
	JButton createButton;
	
	public CreateGroup(User user) {
		this.user = user;
		
		createGroup = new JFrame("Create Group");
		createGroup.setPreferredSize(new Dimension(1200,600));
		createGroup.setLayout(new FlowLayout(FlowLayout.CENTER));
		createGroup.setMinimumSize(new Dimension(1200,600));
		createGroup.setLocationRelativeTo(null);
		
		countryPanel = new JPanel();
		namePanel = new JPanel();
		hobbiesPanel = new JPanel();
		
		countryTextField = new JTextField();
		nameTextField = new JTextField();
		hobbiesTextField = new JTextField();
		
		countryTextField.setPreferredSize(new Dimension(400,50));
		nameTextField.setPreferredSize(new Dimension(400,50));
		hobbiesTextField.setPreferredSize(new Dimension(400,50));
		
		countryLabel = new JLabel("Country: ");
		nameLabel = new JLabel("Name: ");
		hobbiesLabel = new JLabel("Hobbies with -: ");
		
		backButton = new JButton("Back");
		createButton = new JButton("Create");
		
		backButton.addActionListener(this);
		createButton.addActionListener(this);
		
		namePanel.setPreferredSize(new Dimension(1200,50));
		namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		countryPanel.setPreferredSize(new Dimension(1200,50));
		countryPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		hobbiesPanel.setPreferredSize(new Dimension(1200,50));
		hobbiesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		errorMassage = new JLabel("This name exists, please pick another one.");
		
		namePanel.add(nameLabel);
		namePanel.add(nameTextField);
		
		countryPanel.add(countryLabel);
		countryPanel.add(countryTextField);
		
		hobbiesPanel.add(hobbiesLabel);
		hobbiesPanel.add(hobbiesTextField);
		
		createGroup.add(namePanel);
		createGroup.add(countryPanel);
		createGroup.add(hobbiesPanel);
		createGroup.add(createButton);
		createGroup.add(backButton);
		
		createGroup.setVisible(true);
	
		
	}
	
	/**
	 * if action equals to create button then create a group with Group class according to given information
	 * in the textfields.
	 * 
	 * if action equals to back button then go your profile with YourProfilePage class with disposing current frame.
	 * 
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==createButton) {
			String[] hobbiesArray = hobbiesTextField.getText().split("-");
			ArrayList<String> hobbiesAList = new ArrayList<String>();
			
			for (String hobby : hobbiesArray) {
				hobbiesAList.add(hobby);
			}
			
			int response = Group.createGroup(nameTextField.getText(), countryTextField.getText(), hobbiesAList, user);
			
			if (response == 1) {
				
				createGroup.dispose();
				YourProfilePage yPP = new YourProfilePage(user);
				
			} else if (response == 0) {
				createGroup.add(errorMassage);
				createGroup.setVisible(true);
			}
			
		} else if (e.getSource()== backButton) {
			createGroup.dispose();
			YourProfilePage yPP = new YourProfilePage(user);
		}
		
	}
}
