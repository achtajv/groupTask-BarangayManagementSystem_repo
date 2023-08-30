

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class addAccFillUpAdmin extends JDialog {
	private JLabel lblImageIcon;
	private JLabel lblHeaderText;
	private JTextField txtUsername;
	private JButton btnAddAsAdmin;
	private JButton btnAddAsUser;
	private String username, password;
	protected AccountManagement storeUserInfo;
	private String lvlofRoleforStaff;
	private JPasswordField txtprdPass;
	private JPasswordField txtprdRePass;
	public static boolean incompleteEntry = false, invalidPassword = false, weakPassword = false, unmatchingPassword = false,
			passwordRequirement = false, invalidEntry = false, invalidEmail = false, IsthePasswordVisible = true,
			errorFound = false;
    public static boolean testUsernameIfValid;

	
	public  CustomforAccManage getUsers = new CustomforAccManage();
	private JToggleButton tglbtnShowPassword;
	private JButton btnAddBackButton;
      
	public addAccFillUpAdmin(AccountManagement storeUserInfo) {
		this.storeUserInfo = storeUserInfo;
		setModal(true);
		setUndecorated(true);
		setSize(400, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tglbtnShowPassword = new JToggleButton("");
		tglbtnShowPassword.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				tglbtnShowPassword.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
		tglbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tglbtnShowPassword.isSelected()) {
					if (String.valueOf(txtprdPass.getPassword()).equals("Enter Password") && (String.valueOf(txtprdRePass.getPassword()).equals("Re-Enter Password"))) {
					} else {
						txtprdPass.setEchoChar((char) 0);
						txtprdRePass.setEchoChar((char) 0);
					}

					tglbtnShowPassword.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleswitchHide.png")));
					txtprdPass.setEchoChar((char) 0);
				} else {
					if (String.valueOf(txtprdPass.getPassword()).equals("Enter Password") && (String.valueOf(txtprdRePass.getPassword()).equals("Re-Enter Password"))){
					} else {
						txtprdPass.setEchoChar('*');
						txtprdRePass.setEchoChar('*');

					}

					tglbtnShowPassword.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
				}
				
			}
		});
		tglbtnShowPassword.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				tglbtnShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		tglbtnShowPassword.setIcon(new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
		tglbtnShowPassword.setOpaque(false);
		tglbtnShowPassword.setFocusable(false);
		tglbtnShowPassword.setContentAreaFilled(false);
		tglbtnShowPassword.setBorderPainted(false);
		tglbtnShowPassword.setBackground(new Color(0, 0, 0, 0));
		tglbtnShowPassword.setBounds(347, 184, 44, 30);
		getContentPane().add(tglbtnShowPassword);
		
		lblHeaderText = new JLabel("ADD ACCOUNT");
		lblHeaderText.setForeground(new Color(255, 255, 255));
		lblHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderText.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblHeaderText.setBounds(10, 11, 201, 51);
		getContentPane().add(lblHeaderText);
		
		txtUsername = new JTextField();
		txtUsername.setText("Enter Username");
		txtUsername.setForeground(new Color(192, 192, 192));
		txtUsername.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtUsername.getText()).equals("Enter Username")) {
					txtUsername.setText("");
					txtUsername.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtUsername.getText()).isEmpty()) {
					txtUsername.setText("Enter Username");
					txtUsername.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtUsername.setOpaque(false);
		txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtUsername.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtUsername.setBounds(38, 103, 331, 51);
		getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		btnAddAsAdmin = new JButton("ADD (ADMIN)");
		btnAddAsAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    lvlofRoleforStaff = "Administrator";

				 int responseDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want " + txtUsername.getText() + " to become Admin", "Confirmation for Access", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				    if (responseDialog == JOptionPane.YES_OPTION) {
				    	
						ValidateInputUser();
						dispose();
						MainTabBMS.btnSaveChanges.setVisible(true);
						MainTabBMS.btnSaveChanges.setEnabled(true);
						MainTabBMS.lblChangeMessagePrompt.setVisible(true);
					

				    } else if (responseDialog == JOptionPane.NO_OPTION) {
				        return;
				    }
			}
		});
		btnAddAsAdmin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddAsAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnAddAsAdmin.setForeground(new Color(0, 128, 0));
		btnAddAsAdmin.setOpaque(false);
		btnAddAsAdmin.setBorderPainted(false);
		btnAddAsAdmin.setFocusable(false);
		btnAddAsAdmin.setContentAreaFilled(false);
		btnAddAsAdmin.setBackground(new Color(0, 0, 0, 0));		
		btnAddAsAdmin.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnAddAsAdmin.setBounds(266, 19, 119, 41);
		getContentPane().add(btnAddAsAdmin);
		
		btnAddAsUser = new JButton("ADD (USER)");
		btnAddAsUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    lvlofRoleforStaff = "User";

				ValidateInputUser();
				dispose();
			    
			   
			}
		});
		btnAddAsUser.setOpaque(false);
		btnAddAsUser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddAsUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnAddAsUser.setForeground(new Color(0, 128, 0));
		btnAddAsUser.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnAddAsUser.setContentAreaFilled(false);
		btnAddAsUser.setBorderPainted(false);
		btnAddAsUser.setBackground(new Color(0, 0, 0, 0));
		btnAddAsUser.setBounds(143, 407, 119, 41);
		getContentPane().add(btnAddAsUser);
		
		txtprdPass = new JPasswordField();
		txtprdPass.setText("Enter Password");
		txtprdPass.setEchoChar((char) 0);
		txtprdPass.setForeground(new Color(192, 192, 192));
		txtprdPass.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtprdPass.getPassword()).equals("Enter Password")) {
					txtprdPass.setText("");
					txtprdPass.setEchoChar('*');					
					txtprdPass.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtprdPass.getPassword()).isEmpty()) {
					txtprdPass.setText("Enter Password");
					txtprdPass.setEchoChar((char) 0);
					txtprdPass.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtprdPass.setOpaque(false);
		txtprdPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtprdPass.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtprdPass.setBounds(38, 179, 331, 41);
		getContentPane().add(txtprdPass);
		
		txtprdRePass = new JPasswordField();
		txtprdRePass.setText("Re-Enter Password");
		txtprdRePass.setEchoChar((char) 0);
		txtprdRePass.setForeground(new Color(192, 192, 192));
		txtprdRePass.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtprdRePass.getPassword()).equals("Re-Enter Password")) {
					txtprdRePass.setText("");
					txtprdRePass.setEchoChar('*');					
					txtprdRePass.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtprdRePass.getPassword()).isEmpty()) {
					txtprdRePass.setText("Re-Enter Password");
					txtprdRePass.setEchoChar((char) 0);
					txtprdRePass.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtprdRePass.setOpaque(false);
		txtprdRePass.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtprdRePass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtprdRePass.setBounds(38, 248, 331, 41);
		getContentPane().add(txtprdRePass);
		
		btnAddBackButton = new JButton("");
		btnAddBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			MainTabBMS.btnUpdateAcc.setEnabled(false);
			MainTabBMS.btnDelete.setEnabled(false);
			MainTabBMS.tableforShowingtheData.clearSelection();
			dispose();
			}
		});
		btnAddBackButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddBackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnAddBackButton.setOpaque(false);
		btnAddBackButton.setIcon(new ImageIcon(this.getClass().getResource("/backwhite.png")));
		btnAddBackButton.setForeground(new Color(0, 128, 0));
		btnAddBackButton.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnAddBackButton.setContentAreaFilled(false);
		btnAddBackButton.setBorderPainted(false);
		btnAddBackButton.setBackground(new Color(0, 0, 0, 0));
		btnAddBackButton.setBounds(345, 449, 40, 40);
		getContentPane().add(btnAddBackButton);
		
		lblImageIcon = new JLabel("");
		lblImageIcon.setIcon(new ImageIcon(this.getClass().getResource("/AddAccount.png")));
		lblImageIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageIcon.setBounds(0, 0, 400, 500);
		getContentPane().add(lblImageIcon);
	}
	
	void ValidateInputUser() {
		
		testUsernameIfValid = validateUsername(txtUsername.getText());
		if (txtUsername.getText().equals("Enter Username") || String.valueOf(txtprdPass.getPassword()).equals("Enter Password") || String.valueOf(txtprdRePass.getPassword()).equals("Re-Enter Password") ) {
			JOptionPane.showMessageDialog(null, "Please Answer All the Empty Fields", "Empty User Input", JOptionPane.WARNING_MESSAGE);
			return;
		} else if(!String.valueOf(txtprdPass.getPassword()).equals(String.valueOf(txtprdRePass.getPassword()))) {
			JOptionPane.showMessageDialog(null, "Passwords do not match", "Invalid Password", JOptionPane.WARNING_MESSAGE);
		} else if (!testUsernameIfValid) {
		        	JOptionPane.showMessageDialog(null, "Username is Not Valid", "Invalid UserName", JOptionPane.WARNING_MESSAGE);
		} else {
			
			  Random random = new Random();
              int accId = random.nextInt(900000) + 100000;
            username = txtUsername.getText();
            password = String.valueOf(txtprdPass.getPassword());
            
            String[] user = {Integer.toString(accId), username, password, lvlofRoleforStaff};
            if (storeUserInfo == null) {
               addAccFillUpAdmin.this.storeUserInfo = new AccountManagement(new int[]{}, new String[]{}, new String[]{}, new String[]{} );
            }
    		
            CreateAccount access = new CreateAccount(storeUserInfo);
            access.passwordChecker();
           
			
			if (!errorFound) {
			 storeUserInfo.getUserInfo(accId);		
			 
			 getUsers = storeUserInfo.getListOfUsers();
				
			getUsers.addUser(accId, user);
			 
			MainTabBMS.tableNew.addRow(user);
			
			}

		}
		
	}
	
	public boolean validateUsername(String username) {
		
		boolean isUserNameConsideredValid = true;
		
		if (username.length() >= 30) {
	        isUserNameConsideredValid = false;
	        
	    } else {
		for (int iteratesUsername = 0; iteratesUsername < username.length(); iteratesUsername++ ) {
			char storeIteratesUsername = username.charAt(iteratesUsername);
			
			if (!Character.isLetterOrDigit(storeIteratesUsername) && storeIteratesUsername != '-') {
				isUserNameConsideredValid = false;
				break;
			}	
			}
			
		}
		return isUserNameConsideredValid;
	}
	
	public void passwordChecker() {
		
		invalidPassword = false;
		weakPassword = false;
		passwordRequirement = false;
		errorFound = false;
		
		
		String[] notAllowedCharacters = { "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\"", //index 0
		"`¬!\"#$%&'()*+,./:;<=>?@[\\]^_`{|}~\"0123456789" }; //index 1
		
		char[] password = txtprdPass.getPassword(); // get the user input in textPassword
		char[] convertedPasswordNotAllowedChars = notAllowedCharacters[0].toCharArray(); // convert the not allowed in index 0 characters to charArray

		int passwordIntCounter = 0; // count the digits in the password
		int capitalLetter = 0; // number of capital letters present

		boolean isNotAllowedChar = false;
		for (int arrayIndex = 0; arrayIndex < password.length; arrayIndex++) {

			if (isNotAllowedChar == true) {// check if its true
				break;// if it is break this method

			} else {// else run the code again

				for (int notAllowedCharIndex = 0; notAllowedCharIndex < convertedPasswordNotAllowedChars.length; notAllowedCharIndex++) {
					if (password[arrayIndex] == convertedPasswordNotAllowedChars[notAllowedCharIndex]) { // detects if a invalid character is present
						invalidPassword = true;
						errorFound = true;
						isNotAllowedChar = true;
						break;// break this for loop
					}
				}

			} // end if else

//	@formatter:on
		} // end for

		if (password.length < 10) { // detects if the password is less than 10 characters
			weakPassword = true; // show the weak password message
			errorFound = true; // show the errorFound message
		}

		// loop for counting how many upper case letters and digits are present
		for (int index = 0; index < password.length; index++) {
			if (Character.isUpperCase(password[index])) { // for upper case
				capitalLetter++;
			}

			if (Character.isDigit(password[index])) { // for digits
				passwordIntCounter++;
			}
		} // end for

		if (capitalLetter < 1 && passwordIntCounter < 2) { // required number of letters and numbers
			passwordRequirement = true; // show the password requirement message
			errorFound = true; // show the errorFound message
		}
		String errorMessage = "";

	    if (invalidPassword) {
	        errorMessage += "Invalid Character.\n"; 
	    }

	    if (weakPassword) {
	        errorMessage += "Password should be at least 10 characters long.\n";
	    }

	    if (passwordRequirement) {
	        errorMessage += "Password should contain at least 1 uppercase letter and 2 digits.\n";
	    }

	    if (errorFound) {
	        JOptionPane.showMessageDialog(null, errorMessage, "Password Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	}// end method
}
