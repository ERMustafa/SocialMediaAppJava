package panels;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import storage.Group;

public class GroupInformation extends JPanel {
	
	
	JLabel nameLabel;
	JLabel countryLabel;
	JLabel hobbiesLabel;
	
	
	public GroupInformation(Group group) {
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(1200, 200));
		
		String hobbies = "";
		
		for (String hobby : group.getHobbies()) {
			hobbies = hobby + ", " + hobbies;
		}
		
		nameLabel = new JLabel("Name: " + group.getName());
		countryLabel = new JLabel("Country: " + group.getCountry());
		hobbiesLabel = new JLabel("Hobbies: " + hobbies);
		
		nameLabel.setPreferredSize(new Dimension(300,200));
		countryLabel.setPreferredSize(new Dimension(300,200));
		hobbiesLabel.setPreferredSize(new Dimension(300,200));
		
		this.add(nameLabel);
		this.add(countryLabel);
		this.add(hobbiesLabel);
	}
}
