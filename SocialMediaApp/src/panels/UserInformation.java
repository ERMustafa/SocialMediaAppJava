package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import storage.User;

public class UserInformation extends JPanel{
	

	
	JLabel profilePhoto;
	JLabel nickname;
	JLabel realName;
	JLabel realSurname;
	JLabel country;
	
	JPanel profilePhotoPanel;
	JPanel infoPanel;
	
	
	
	public UserInformation(User user) {
		
		
		this.setPreferredSize(new Dimension(1200,230));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		profilePhotoPanel = new JPanel();
		infoPanel = new JPanel();
		
		profilePhotoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		profilePhotoPanel.setPreferredSize(new Dimension(400,200));
		infoPanel.setPreferredSize(new Dimension(400,220));

		
		nickname = new JLabel("Nickname = " + user.getNickname());
		realName = new JLabel("Real Name = " + user.getRealName());
		realSurname = new JLabel("Surname = " + user.getRealSurname());
		country = new JLabel("Country = " + user.getCountry());
		profilePhoto = new JLabel();
		
		profilePhoto.setIcon(user.getProfilePhoto());
		
		
		profilePhoto.setPreferredSize(new Dimension(250,150));
		nickname.setPreferredSize(new Dimension(250,50));
		realName.setPreferredSize(new Dimension(250,50));
		realSurname.setPreferredSize(new Dimension(250,50));
		country.setPreferredSize(new Dimension(250,50));
		
		
		profilePhotoPanel.add(profilePhoto);
		infoPanel.add(nickname);
		infoPanel.add(realName);
		infoPanel.add(realSurname);
		infoPanel.add(country);
		
		this.add(profilePhotoPanel);
		this.add(infoPanel);

	}


	
		
	}

