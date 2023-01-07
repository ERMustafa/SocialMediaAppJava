package panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import storage.Content;
import storage.User;

public class ContentPanel extends JPanel{
	public ContentPanel(Content content) {
		
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(1200,300));
		
		if (content != null) {
			JPanel imagePanel = new JPanel();
			JPanel textPanel = new JPanel();
			JPanel titlePanel = new JPanel();
			JPanel authorPanel = new JPanel();
			JPanel cTimePanel = new JPanel();
			
			imagePanel.setPreferredSize(new Dimension(1200,100));
			textPanel.setPreferredSize(new Dimension(1200,100));
			titlePanel.setPreferredSize(new Dimension(1200,30));
			authorPanel.setPreferredSize(new Dimension(1200,30));
			cTimePanel.setPreferredSize(new Dimension(1200,30));
			
			imagePanel.setLayout(new FlowLayout());
			textPanel.setLayout(new FlowLayout());
			titlePanel.setLayout(new FlowLayout());
			authorPanel.setLayout(new FlowLayout());
			cTimePanel.setLayout(new FlowLayout());
			
			
			JLabel imageLabel = new JLabel();
			JLabel textLabel = new JLabel();
			JLabel titleLabel = new JLabel();
			JLabel authorLabel = new JLabel();
			JLabel cTimeLabel = new JLabel();
			
			ImageIcon image = content.getImage();
			String text = content.getText();
			String title = content.getTitle();
			String author = content.getAuthor().getNickname();
			LocalDateTime creationTime = content.getCreationTime();
			
			imageLabel.setLayout(new FlowLayout());
			textLabel.setLayout(new FlowLayout());
			titleLabel.setLayout(new FlowLayout());
			authorLabel.setLayout(new FlowLayout());
			cTimeLabel.setLayout(new FlowLayout());
			
			imageLabel.setIcon(image);
			textLabel.setText(text);
			titleLabel.setText(title);
			authorLabel.setText(author);
			cTimeLabel.setText(creationTime.toString());
			
			imagePanel.add(imageLabel);
			textPanel.add(textLabel);
			titlePanel.add(titleLabel);
			authorPanel.add(authorLabel);
			cTimePanel.add(cTimeLabel);
			
			this.add(titlePanel);
			this.add(authorPanel);
			this.add(cTimePanel);
			this.add(imagePanel);
			this.add(textPanel);
			
		} else {
			JLabel noContentLabel = new JLabel("There is no content");
			noContentLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
			noContentLabel.setPreferredSize(new Dimension(1200, 300));
			
			this.add(noContentLabel);
		}
		
		
		
	}
}
