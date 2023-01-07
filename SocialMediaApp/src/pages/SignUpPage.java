package pages;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import storage.User;

public class SignUpPage implements ActionListener{
	JFrame signUpPage;
	
	JPanel container;
	JPanel nicknamePanel;
	JPanel passwordPanel;
	JPanel realNamePanel;
	JPanel realSurnamePanel;
	JPanel countryPanel;
	JPanel agePanel;
	JPanel emailPanel;
	JPanel isPremiumPanel;
	JPanel signUpButtonPanel;
	
	JTextField nicknameText;
	JTextField passwordText;
	JTextField realNameText;
	JTextField realSurnameText;
	JTextField countryText;
	JTextField ageText;
	JTextField emailText;
	
	JCheckBox isPremiumCheck;
	
	JLabel nicknameLabel;
	JLabel passwordLabel;
	JLabel realNameLabel;
	JLabel realSurnameLabel;
	JLabel countryLabel;
	JLabel ageLabel;
	JLabel emailLabel;
	JLabel isPremiumLabel;
	
	JButton signUpButton;
	
	JLabel errorMassage1;
	JLabel errorMassage2;
	
	JPanel errorPanel;
	
	JButton backButton;
	
	
	public SignUpPage() {
		
		// Frame
		
		signUpPage = new JFrame("Sign Up");
		
		signUpPage.setSize(1000,700);
		signUpPage.setLayout(new FlowLayout(FlowLayout.LEFT));
		signUpPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpPage.setLocationRelativeTo(null);
		signUpPage.setResizable(false);
		
		// Panels
		
		container = new JPanel();
		nicknamePanel = new JPanel();
		passwordPanel = new JPanel();
		realNamePanel = new JPanel();
		realSurnamePanel = new JPanel();
		countryPanel = new JPanel();
		agePanel = new JPanel();
		emailPanel = new JPanel();
		isPremiumPanel = new JPanel();
		signUpButtonPanel = new JPanel();
		
		container.setPreferredSize(new Dimension(1000,700));
		nicknamePanel.setPreferredSize(new Dimension(800,50));
		passwordPanel.setPreferredSize(new Dimension(800,50));
		realNamePanel.setPreferredSize(new Dimension(800,50));
		realSurnamePanel.setPreferredSize(new Dimension(800,50));
		countryPanel.setPreferredSize(new Dimension(800,50));
		agePanel.setPreferredSize(new Dimension(800,50));
		emailPanel.setPreferredSize(new Dimension(800,50));
		isPremiumPanel.setPreferredSize(new Dimension(800,50));
		signUpButtonPanel.setPreferredSize(new Dimension(800,50));
		
		container.setLayout(new FlowLayout(FlowLayout.LEFT));
		nicknamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		realNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		realSurnamePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		countryPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		agePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		isPremiumPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		signUpButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Text Fields
		
		nicknameText = new JTextField();
		passwordText = new JTextField();
		realNameText = new JTextField();
		realSurnameText = new JTextField();
		countryText = new JTextField();
		ageText = new JTextField();
		emailText = new JTextField();
		
		
		nicknameText.setPreferredSize(new Dimension(500,50));
		nicknameText.setFont(new Font("Consolas", Font.PLAIN, 30));
		nicknameText.setForeground(Color.BLACK);
		
		passwordText.setPreferredSize(new Dimension(500,50));
		passwordText.setFont(new Font("Consolas", Font.PLAIN, 30));
		passwordText.setForeground(Color.BLACK);
		
		realNameText.setPreferredSize(new Dimension(500,50));
		realNameText.setFont(new Font("Consolas", Font.PLAIN, 30));
		realNameText.setForeground(Color.BLACK);
		
		realSurnameText.setPreferredSize(new Dimension(500,50));
		realSurnameText.setFont(new Font("Consolas", Font.PLAIN, 30));
		realSurnameText.setForeground(Color.BLACK);
		
		countryText.setPreferredSize(new Dimension(500,50));
		countryText.setFont(new Font("Consolas", Font.PLAIN, 30));
		countryText.setForeground(Color.BLACK);
		
		ageText.setPreferredSize(new Dimension(500,50));
		ageText.setFont(new Font("Consolas", Font.PLAIN, 30));
		ageText.setForeground(Color.BLACK);
		
		emailText.setPreferredSize(new Dimension(500,50));
		emailText.setFont(new Font("Consolas", Font.PLAIN, 30));
		emailText.setForeground(Color.BLACK);
		
		isPremiumCheck = new JCheckBox();
		isPremiumCheck.setFocusable(false);
		
		//Labels
		
		nicknameLabel = new JLabel();
		passwordLabel = new JLabel();
		realNameLabel = new JLabel();
		realSurnameLabel = new JLabel();
		countryLabel = new JLabel();
		ageLabel = new JLabel();
		emailLabel = new JLabel();
		isPremiumLabel = new JLabel();
	
		nicknameLabel.setText("Nickname    ");
		passwordLabel.setText("Password    ");
		realNameLabel.setText("Real Name   ");
		realSurnameLabel.setText("Real Surname");
		countryLabel.setText("Country      ");
		ageLabel.setText("Age         ");
		emailLabel.setText("Email       ");
		isPremiumLabel.setText("Is premium?");
		
		nicknameLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		realNameLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		realSurnameLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		countryLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		ageLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		emailLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		isPremiumLabel.setFont(new Font("Consolas", Font.PLAIN, 30));
		
		//Button
		
		signUpButton = new JButton("Sign-up!");
		signUpButton.addActionListener(this);
		signUpButton.setBorder(BorderFactory.createEtchedBorder());
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		backButton.setBorder(BorderFactory.createEtchedBorder());
		
		
		// For errors
		
		errorPanel = new JPanel();
		errorPanel.setPreferredSize(new Dimension(800,50));
		errorPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		errorMassage1 = new JLabel();
		errorMassage2 = new JLabel();
		
		errorMassage1.setText("This username was taken. Please choose another username.");
		errorMassage2.setText("Please fill all the blanks.");
		
		errorMassage1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		errorMassage2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		errorMassage1.setForeground(Color.red);
		errorMassage2.setForeground(Color.red);
		
		
		//Panel additions
		
		nicknamePanel.add(nicknameLabel);
		nicknamePanel.add(nicknameText);
		
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
		
		signUpButtonPanel.add(backButton);
		signUpButtonPanel.add(signUpButton);
		
		//Addition of Panels to Container
		
		container.add(nicknamePanel);
		container.add(passwordPanel);
		container.add(realNamePanel);
		container.add(realSurnamePanel);
		container.add(countryPanel);
		container.add(agePanel);
		container.add(emailPanel);
		container.add(isPremiumPanel);
		container.add(signUpButtonPanel);
		
		//Finally, addition of container to frame
		
		signUpPage.add(container);
		
		// add colors
		
		container.setBackground(Color.decode("#F3AE49"));
		nicknamePanel.setBackground(Color.decode("#F3AE49"));
		passwordPanel.setBackground(Color.decode("#F3AE49"));
		realNamePanel.setBackground(Color.decode("#F3AE49"));
		realSurnamePanel.setBackground(Color.decode("#F3AE49"));
		countryPanel.setBackground(Color.decode("#F3AE49"));
		agePanel.setBackground(Color.decode("#F3AE49"));
		emailPanel.setBackground(Color.decode("#F3AE49"));
		isPremiumPanel.setBackground(Color.decode("#F3AE49"));
		signUpButtonPanel.setBackground(Color.decode("#F3AE49"));
		
		
		signUpPage.setVisible(true);
	}
	
	public void error1() {
		errorPanel.add(errorMassage1);
		container.add(errorPanel);
		signUpPage.setVisible(true);
	}
	
	public void error2() {
		errorPanel.add(errorMassage2);
		container.add(errorPanel);
		signUpPage.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==signUpButton) {
			String nickname = nicknameText.getText();
			String password = passwordText.getText();
			String realName = realNameText.getText();
			String realSurname = realSurnameText.getText();
			String country = countryText.getText();
			String age = ageText.getText();
			String email = emailText.getText();
			boolean isPremium = isPremiumCheck.isSelected();
			
			int register = User.register(nickname, password, realName, realSurname, age, email, country, isPremium);
		
			if (register == -1) {
				error1();
			} else if (register == 0) {
				error2();
			} else if (register == 1) {
				signUpPage.dispose();
				HomePage homePage = new HomePage(User.getUsers().get(User.getUsers().size()-1));
			}
			
			
		} else if (e.getSource()==backButton) {
			signUpPage.dispose();
			SignInPage sip = new SignInPage();
		}
		
	}
}
