package utilityFrames;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fileFilterForImages.FileFilterForImages;
import pages.GroupPage;
import pages.HomePage;
import pages.YourProfilePage;
import storage.Group;
import storage.User;

public class CNC_API implements ActionListener {
	// Create new content api
	
	JTextField textField;
	JTextField title;
	
	JPanel container;
	
	JFrame frame;
	
	JButton backButton;
	JButton button;
	JButton chooseButton;
	JFileChooser fileChooser;
	
	User user;
	
	JPanel buttons;
	JPanel titleAndText;
	
	ImageIcon image = null;
	int indicator;
	
	Group group;
	
	
	
	public CNC_API(User user, Group group, int indicator) {

		//indicator states: 0=homePage 1=profilePage 2=groupPage
		
		frame = new JFrame("Create Content");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.setPreferredSize(new Dimension(1200,250));
		frame.setMinimumSize(new Dimension(1200,300));
		
		
		this.user = user;
		this.group = group;
		this.indicator = indicator;
		
		container = new JPanel();
		
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		container.setPreferredSize(new Dimension(1200,300));
		
		
		
		chooseButton = new JButton();
		chooseButton.setText("Select an Image");
		chooseButton.addActionListener(this);
		chooseButton.setPreferredSize(new Dimension(200,30));
		
		
		button = new JButton();
		button.setText("Post");
		button.addActionListener(this);
		button.setPreferredSize(new Dimension(200,30));
		
		backButton = new JButton();
		backButton.setText("Back");
		backButton.addActionListener(this);
		backButton.setPreferredSize(new Dimension(200,30));
		
		
		textField = new JTextField();
		textField.setText("Type here");
		textField.setPreferredSize(new Dimension(800,200));
		
		title = new JTextField();
		title.setText("Title");
		title.setPreferredSize(new Dimension(800,50));
		
		buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		buttons.setPreferredSize(new Dimension(200,250));
		
		buttons.add(button);
		buttons.add(chooseButton);
		buttons.add(backButton);
		
		titleAndText = new JPanel();
		titleAndText.setLayout(new FlowLayout());
		titleAndText.setPreferredSize(new Dimension(800,270));
		
		titleAndText.add(textField);
		titleAndText.add(title);
		
		container.add(titleAndText);
		container.add(buttons);
		
		frame.add(container);
		
		frame.setVisible(true);
		
	}
	
	/**
	 * 
	 * if action equals to button and indicator that can be obtained from constructor
	 * equals to 2 add a content to the group, else add a content to your profile. 
	 * Then return to group page if indicator equals to 2
	 * return to your profile page if indicator equals to 1 
	 * return to home page if indicator equals to 0
	 * 
	 * if action equals to chooseButton it runs a JFileChooser to upload an image for content
	 * 
	 * if action equals to backButton, 
	 * return to group page if indicator equals to 2
	 * return to your profile page if indicator equals to 1 
	 * return to home page if indicator equals to 0
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button) {
			
			if (indicator == 2) {
				if (image != null) {
					user.addContentGroup(title.getText(), textField.getText(), group, image);
				} else {
					user.addContentGroup(title.getText(), textField.getText(), group);
				}
			} else {
				if (image != null) {
					user.addContent(title.getText(), textField.getText(), image);
				} else {
					user.addContent(title.getText(), textField.getText());
				}
			}
			
			
			if (indicator == 2) {
				frame.dispose();
				GroupPage gp = new GroupPage(group, user);
			} else if (indicator == 1){
				frame.dispose();
				YourProfilePage ypp = new YourProfilePage(user);
			} else if (indicator == 0) {
				frame.dispose();
				HomePage homePage = new HomePage(user);
			}
			
			
		}
		else if (e.getSource()==chooseButton) {
			
			
				fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileFilterForImages());
				fileChooser.setCurrentDirectory(new File("."));
				int response = fileChooser.showSaveDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					image = new ImageIcon(fileChooser.getSelectedFile().getAbsolutePath());

					
				}
		
		} else if (e.getSource()==backButton){
				if(indicator ==2) {
					frame.dispose();
					GroupPage gp = new GroupPage(group, user);
				} else if (indicator == 1) {
					frame.dispose();
					YourProfilePage ypp = new YourProfilePage(user);
				} else if (indicator == 0) {
					frame.dispose();
					HomePage homePage = new HomePage(user);
				}
			}
			
		}
	}
		
	

