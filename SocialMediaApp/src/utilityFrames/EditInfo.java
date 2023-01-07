package utilityFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fileFilterForImages.FileFilterForImages;
import pages.YourProfilePage;
import storage.User;

public class EditInfo implements ActionListener{
	JFrame frame;
		
	JPanel container;
	JPanel passwordPanel;
	JPanel realNamePanel;
	JPanel realSurnamePanel;
	JPanel countryPanel;
	JPanel agePanel;
	JPanel emailPanel;
	JPanel isPremiumPanel;
	JPanel editButtonPanel;
	JPanel hobbyPanel;
	JPanel chooseImagePanel;

	JTextField passwordText;
	JTextField realNameText;
	JTextField realSurnameText;
	JTextField countryText;
	JTextField ageText;
	JTextField emailText;
	JTextField hobbyText;
	
	JCheckBox isPremiumCheck;
	
	JLabel passwordLabel;
	JLabel realNameLabel;
	JLabel realSurnameLabel;
	JLabel countryLabel;
	JLabel ageLabel;
	JLabel emailLabel;
	JLabel isPremiumLabel;
	JLabel hobbyLabel;
	JLabel chooseImageLabel;
		
	JButton editButton;
	JButton backButton;
	JButton uploadImage;
	
	User user;
	
	JFileChooser fileChooser;
	JButton chooseImage;
	ImageIcon image = null;
	
	public EditInfo(User user) {
   
		
		this.user = user;
		
		// Frame
		
		frame = new JFrame("Edit Info");
		
		frame.setSize(1000,600);
		frame.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		// Panels
		
		container = new JPanel();
	
		passwordPanel = new JPanel();
		realNamePanel = new JPanel();
		realSurnamePanel = new JPanel();
		countryPanel = new JPanel();
		agePanel = new JPanel();
		emailPanel = new JPanel();
		isPremiumPanel = new JPanel();
		editButtonPanel = new JPanel();
		hobbyPanel = new JPanel();
		chooseImagePanel = new JPanel();
		
		container.setPreferredSize(new Dimension(1000,600));
		
		passwordPanel.setPreferredSize(new Dimension(800,50));
		realNamePanel.setPreferredSize(new Dimension(800,50));
		realSurnamePanel.setPreferredSize(new Dimension(800,50));
		countryPanel.setPreferredSize(new Dimension(800,50));
		agePanel.setPreferredSize(new Dimension(800,50));
		emailPanel.setPreferredSize(new Dimension(800,50));
		isPremiumPanel.setPreferredSize(new Dimension(800,50));
		editButtonPanel.setPreferredSize(new Dimension(800,50));
		hobbyPanel.setPreferredSize(new Dimension(800,50));
		chooseImagePanel.setPreferredSize(new Dimension(800,50));
		
		container.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		realNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		realSurnamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		countryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		agePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		isPremiumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		hobbyPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		editButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		chooseImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		
		//Text Fields
		
		
		passwordText = new JTextField();
		realNameText = new JTextField();
		realSurnameText = new JTextField();
		countryText = new JTextField();
		ageText = new JTextField();
		emailText = new JTextField();
		hobbyText = new JTextField();
		
		
		
		passwordText.setPreferredSize(new Dimension(500,50));
		
		passwordText.setForeground(Color.BLACK);
		
		realNameText.setPreferredSize(new Dimension(500,50));
		
		realNameText.setForeground(Color.BLACK);
		
		realSurnameText.setPreferredSize(new Dimension(500,50));
		
		realSurnameText.setForeground(Color.BLACK);
		
		countryText.setPreferredSize(new Dimension(500,50));
		
		countryText.setForeground(Color.BLACK);
		
		ageText.setPreferredSize(new Dimension(500,50));
		
		ageText.setForeground(Color.BLACK);
		
		emailText.setPreferredSize(new Dimension(500,50));
		
		emailText.setForeground(Color.BLACK);
		
		hobbyText.setPreferredSize(new Dimension(500,50));
		
		hobbyText.setForeground(Color.BLACK);
		
		isPremiumCheck = new JCheckBox();
		isPremiumCheck.setFocusable(false);
		
		passwordText.setText(user.getPassword());
		realNameText.setText(user.getRealName());
		realSurnameText.setText(user.getRealSurname());
		countryText.setText(user.getCountry());
		ageText.setText(user.getAge());
		emailText.setText(user.getEmail());
		
		String hobbies = "";
		for (String hobby : user.getHobbies()) {
			hobbies = hobbies + " " + hobby;
		}
		hobbyText.setText(hobbies);
		
		
		
		//Labels
		
		
		passwordLabel = new JLabel();
		realNameLabel = new JLabel();
		realSurnameLabel = new JLabel();
		countryLabel = new JLabel();
		ageLabel = new JLabel();
		emailLabel = new JLabel();
		isPremiumLabel = new JLabel();
		hobbyLabel = new JLabel();
		chooseImageLabel = new JLabel();
	
		passwordLabel.setText("Password                ");
		realNameLabel.setText("Real Name               ");
		realSurnameLabel.setText("Real Surname            ");
		countryLabel.setText("Country         ");
		ageLabel.setText("Age                     ");
		emailLabel.setText("Email                   ");
		isPremiumLabel.setText("Is premium?");
		hobbyLabel.setText("Enter your hobbies with -");
		chooseImageLabel.setText("Choose Image            ");
		
		
		//Button
		
		editButton = new JButton("Save");
		editButton.addActionListener(this);
		editButton.setBorder(BorderFactory.createEtchedBorder());
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBorder(BorderFactory.createEtchedBorder());
		
		// Save Image
		
		chooseImage = new JButton("Choose Profile Image");
		chooseImage.addActionListener(this);
		chooseImage.setBorder(BorderFactory.createEtchedBorder());
		
		//Panel additions
		
		chooseImagePanel.add(chooseImageLabel);
		chooseImagePanel.add(chooseImage);
		
		hobbyPanel.add(hobbyLabel);
		hobbyPanel.add(hobbyText);
		
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordText);
		
		realNamePanel.add(realNameLabel);
		realNamePanel.add(realNameText);
		
		realSurnamePanel.add(realSurnameLabel);
		realSurnamePanel.add(realSurnameText);
		
		countryPanel.add(countryLabel);
		countryPanel.add(countryText);
		
		agePanel.add(ageLabel);
		agePanel.add(ageText);
		
		emailPanel.add(emailLabel);
		emailPanel.add(emailText);
		
		isPremiumPanel.add(isPremiumLabel);
		isPremiumPanel.add(isPremiumCheck);
		
		editButtonPanel.add(editButton);
		
		//Addition of Panels to Container
		
		container.add(passwordPanel);
		container.add(realNamePanel);
		container.add(realSurnamePanel);
		container.add(countryPanel);
		container.add(agePanel);
		container.add(emailPanel);
		container.add(hobbyPanel);
		container.add(chooseImagePanel);
		container.add(isPremiumPanel);
		container.add(editButtonPanel);
		container.add(backButton);
		
		//Finally, addition of container to frame
		
		frame.add(container);
		
		
		
		frame.setVisible(true);
	
		
	}

	/**
	 * 
	 * @param e
	 * 
	 * If action equals to edit, then edit user's information according to textFields
	 * 
	 * If action equals to back, then go back to homePage with HomePage class
	 * 
	 * If action equals to choose image run a JFileChooser
	 * 
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==editButton) {
			
			
			String password = passwordText.getText();
			String realName = realNameText.getText();
			String realSurname = realSurnameText.getText();
			String country = countryText.getText();
			String age = ageText.getText();
			String email = emailText.getText();
			boolean isPremium = isPremiumCheck.isSelected();
			
			String[] hobbies = hobbyText.getText().split("-");
			
			ArrayList<String> hobbiesA = new ArrayList<String>();
			
			for (String hobby: hobbies) {
				hobbiesA.add(hobby);
			}
			
			user.setPassword(password);
			user.setRealName(realName);
			user.setRealSurname(realSurname);
			user.setCountry(country);
			user.setAge(age);
			user.setEmail(email);
			user.setIsPremium(isPremium);
			user.setHobbies(hobbiesA);
			
			if(image != null) {
				user.setProfilePhoto(image);
			}
			
			frame.dispose();
			YourProfilePage yPP = new YourProfilePage(user);
			
		} else if (e.getSource()==backButton) {
			frame.dispose();
			YourProfilePage yPP = new YourProfilePage(user);
		} else if (e.getSource()==chooseImage) {
			fileChooser = new JFileChooser();
			fileChooser.setFileFilter(new FileFilterForImages());
			fileChooser.setCurrentDirectory(new File("."));
			int response = fileChooser.showSaveDialog(null);
			if (response == JFileChooser.APPROVE_OPTION) {
				image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());
			}
		}
		
	}
}
