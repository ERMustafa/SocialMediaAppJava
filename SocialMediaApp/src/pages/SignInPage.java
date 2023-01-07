package pages;
import storage.User;
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInPage implements ActionListener{
	JFrame signInPage;
	JPanel container;
	JPanel usernamePanel;
	JPanel passwordPanel;
	JPanel introducePanel;
	JTextField usernameText;
	JTextField passwordText;
	JLabel usernameLabel;
	JLabel passwordLabel;
	JLabel introduceLabel;
	JButton signInButton;
	JButton signUpButton;
	
	JPanel errorPanel;
	JLabel errorMassage1;
	JLabel errorMassage2;
	
	
	
	public SignInPage() {
		signInPage = new JFrame();
		
		
		// panels
		
		container = new JPanel();
		usernamePanel = new JPanel();
		passwordPanel = new JPanel();
		introducePanel = new JPanel();
		
		//labels
		
		usernameLabel = new JLabel();
		passwordLabel = new JLabel();
		introduceLabel = new JLabel();
		
		// buttons
		
		signInButton = new JButton("Sign-in");
		signUpButton = new JButton("Sign-up");
		
		// for errors
		
		errorPanel = new JPanel();
		errorMassage1 = new JLabel();
		errorMassage2 = new JLabel();
		
		// error styling
		
		errorMassage1.setText("This nickname does not exist.");
		errorMassage2.setText("The password is wrong.");
		
		errorMassage1.setFont(new Font("Calibri", Font.PLAIN, 25));
		errorMassage2.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		errorMassage1.setForeground(Color.red);
		errorMassage2.setForeground(Color.red);
		
		errorPanel.setPreferredSize(new Dimension(600,50));
		errorPanel.setLayout(new FlowLayout());
		
		
		usernameLabel.setText("Username");
		passwordLabel.setText("Password");
		introduceLabel.setText("Sociall");
		
		signInPage.setTitle("myApp");
		signInPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInPage.setSize(600,600);
		signInPage.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
		signInPage.setLocationRelativeTo(null);
		signInPage.setResizable(false);
		
		usernamePanel.setPreferredSize(new Dimension(600,50));
		passwordPanel.setPreferredSize(new Dimension(600,50));
		container.setPreferredSize(new Dimension(600,600));
		introducePanel.setPreferredSize(new Dimension(600,300));
		
		usernamePanel.setLayout(new FlowLayout());
		passwordPanel.setLayout(new FlowLayout());
		container.setLayout(new FlowLayout());
		introducePanel.setLayout(new FlowLayout());
		
		usernameText = new JTextField();
		usernameText.setPreferredSize(new Dimension(300,50));
		usernameText.setFont(new Font("Consolas", Font.PLAIN, 30));
		usernameText.setForeground(Color.BLACK);
		
		passwordText = new JTextField();
		passwordText.setPreferredSize(new Dimension(300,50));
		passwordText.setFont(new Font("Consolas", Font.PLAIN, 30));
		passwordText.setForeground(Color.BLACK);
		
		signInButton.addActionListener(this);
		signUpButton.addActionListener(this);
		
		//addition
		
		usernamePanel.add(usernameLabel);
		usernamePanel.add(usernameText);
		passwordPanel.add(passwordLabel);
		passwordPanel.add(passwordText);
		introducePanel.add(introduceLabel);
		container.add(introducePanel);
		container.add(usernamePanel);
		container.add(passwordPanel);
		container.add(signInButton);
		container.add(signUpButton);
		signInPage.add(container);
		
		//add colors
		
		container.setBackground(Color.decode("#5BD8E5"));
		usernamePanel.setBackground(Color.decode("#5BD8E5"));
		passwordPanel.setBackground(Color.decode("#5BD8E5"));
		introducePanel.setBackground(Color.decode("#5BD8E5"));
		signInPage.setBackground(Color.decode("#5BD8E5"));
		
		
		signInPage.setVisible(true);
		
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signInButton) {
			String nickname = usernameText.getText();
			String password = passwordText.getText();
			int indicator = 0;
			for (User user : User.getUsers()) {
				
				if(user.getNickname().equals(nickname)) {
					
					indicator = 1;
					if (user.getPassword().equals(password)) {
						
						HomePage homePage = new HomePage(user);	
						signInPage.dispose();
						
					} else {
						errorPanel.add(errorMassage2);
						container.add(errorPanel);
						signInPage.setVisible(true);
						
					}
					
				}
			}
			
			
			if (indicator == 0) {
				errorPanel.add(errorMassage1);
				container.add(errorPanel);
				signInPage.setVisible(true);
			}
			
		} else if (e.getSource() ==signUpButton) {
			signInPage.dispose();
			SignUpPage signUpPage = new SignUpPage();
		}
		
	}
	
}
