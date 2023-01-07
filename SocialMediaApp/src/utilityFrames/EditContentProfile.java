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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fileFilterForImages.FileFilterForImages;
import pages.YourProfilePage;
import panels.NextLine;
import storage.Content;
import storage.User;

public class EditContentProfile implements ActionListener{
	
	JFrame editContent;
	Content content;
	
	JPanel textPanel;
	JPanel imagePanel;
	
	JLabel textLabel;
	JLabel textTitle;
	
	JTextField textField;
	
	JFileChooser fileChooser;
	
	JButton uploadImage;
	JButton saveButton;
	JButton cancelButton;
	
	NextLine nl1;
	
	ImageIcon image = null;
	
	User user;

	public EditContentProfile(Content content, User user) {
		
		this.user = user;
		
		this.content = content;
		
		editContent = new JFrame("Edit Content");
		editContent.setLayout(new FlowLayout(FlowLayout.CENTER));
		editContent.setPreferredSize(new Dimension(1200,500));
		editContent.setMinimumSize(new Dimension(1200,500));
		editContent.setLocationRelativeTo(null);
		
		textPanel = new JPanel();
		imagePanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(1100,200));
		
		textTitle = new JLabel("Title: "+ content.getTitle());
		textTitle.setPreferredSize(new Dimension(500,150));
		
		textField = new JTextField();
		textField.setText(content.getText());
		textField.setPreferredSize(new Dimension(500,150));
		
		textPanel.add(textTitle);
		textPanel.add(textField);
		
		nl1 = new NextLine();
		
		saveButton = new JButton("Save");
		cancelButton = new JButton("Cancel");
		uploadImage = new JButton("Upload an image");
		
		saveButton.addActionListener(this);
		cancelButton.addActionListener(this);
		uploadImage.addActionListener(this);
		
		editContent.add(textPanel);
		editContent.add(uploadImage);
		editContent.add(nl1);
		editContent.add(saveButton);
		editContent.add(cancelButton);
		
		
		editContent.setVisible(true);
	}
	
	/**
	 * 
	 * if action equals to "save" then change the content according to text field and chosen image.
	 * 
	 * if action equals to "cancel" then cancel the operation with disposing and opening your profile with YourProfilePage
	 * 
	 * if action equals to "upload" then run a JFileChooser to choose and save an image
	 * 
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveButton) {
			content.setText(textField.getText());
			if(image != null) {
				content.setImage(image);
			}
			editContent.dispose();
			YourProfilePage ypp = new YourProfilePage(user);
		} else if(e.getSource()==cancelButton) {
			editContent.dispose();
			YourProfilePage ypp = new YourProfilePage(user);
		} else if(e.getSource()==uploadImage) {
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
