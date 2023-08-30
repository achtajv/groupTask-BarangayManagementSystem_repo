

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class CreateAccount extends JDialog {
	
	JPanel panel;
	
	private JLabel lblImageIcon;
	private JLabel lblCreateAccountText;
	private JLabel lblSubText;
	private JLabel lblSubTextLogin;
	private JButton btnSignUp;
	private JTextField txtUserName;
	private JPasswordField txtPass;
	private JButton btncreateAcc;
	private String username, password;
	AccountManagement storeUserInfo;
	private JPasswordField repassField;
	private String lvlofRoleforStaff = "User";
	private CustomforAccManage getUsers = new CustomforAccManage();
    private JLabel lblImgIcon;
    private JButton btnBackToLogin;
    public static boolean testUsernameIfValid;

    public static boolean incompleteEntry = false, invalidPassword = false, weakPassword = false, unmatchingPassword = false,
			passwordRequirement = false, invalidEntry = false, invalidEmail = false, IsthePasswordVisible = true,
			errorFound = false;
    private JToggleButton tglbtnShowPassword;

      
  		
	public CreateAccount(final AccountManagement storeUserInfo) {
		setUndecorated(true);
		this.storeUserInfo = storeUserInfo;
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		setTitle("BMS-Login");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setModal(true);
		
			btncreateAcc = new JButton("");
			btncreateAcc.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					
					btncreateAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			});
			btncreateAcc.setIcon(new ImageIcon(this.getClass().getResource("/CREATE ACCOUNT.png")));
			btncreateAcc.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	
			    	
			    	testUsernameIfValid = validateUsername(txtUserName.getText());
			    	
			    	//if the user did not meet a certain requirements for creating an account a dialog will pop-up
			    	//displaying a certain error the user has made
			        if (txtUserName.getText().equals("Enter Username") || String.valueOf(txtPass.getPassword()).equals("Enter Password")|| String.valueOf(repassField.getPassword()).equals("Re - enter Password")) {
			            JOptionPane.showMessageDialog(null, "All fields are required", "Returns Empty Field", JOptionPane.WARNING_MESSAGE);
			        } else if (!String.valueOf(txtPass.getPassword()).equals(String.valueOf(repassField.getPassword()))) {
			        	JOptionPane.showMessageDialog(null, "Passwords do not match", "Invalid Password", JOptionPane.WARNING_MESSAGE);
			        } else if (!testUsernameIfValid) {
		        	JOptionPane.showMessageDialog(null, "Username is Not Valid", "Invalid UserName", JOptionPane.WARNING_MESSAGE);
		        
			        } else {
		        	// generates 6 random digit that will serve as account ID
		        	  Random random = new Random();
		              int accId = random.nextInt(900000) + 100000;
		            username = txtUserName.getText();
		            password = String.valueOf(txtPass.getPassword());
		            
		            String[] user = {Integer.toString(accId), username, password, lvlofRoleforStaff};
		            if (storeUserInfo == null) {
		               CreateAccount.this.storeUserInfo = new AccountManagement(new int[]{}, new String[]{}, new String[]{}, new String[]{} );
		            }
		    		
		            passwordChecker();
		            
		            
		            if (!errorFound) { 
		                storeToCustom2DArray(storeUserInfo, accId, user);
		            }
		            		            
		            
		            

		        }
		    }
		    //store it to the array and prompts a message 
			private void storeToCustom2DArray(final AccountManagement storeUserInfo, int accId, String[] user) {
				getUsers = storeUserInfo.getListOfUsers();
				
				getUsers.addUser(accId, user);
				
				storeUserInfo.getUserInfo(accId);
				
				JOptionPane.showMessageDialog(null, "Account details\n" + "Username: " + username + "\n" + "Password: " + password + "\n" + "Account Id: " + accId , "Successfully created an Account", JOptionPane.INFORMATION_MESSAGE);
				
				
				dispose();
		
				loginPage openForm = new loginPage(storeUserInfo);
				openForm.setVisible(true);
			}	
			
			
		});
		btncreateAcc.setBorderPainted(false);
		btncreateAcc.setContentAreaFilled(false);
		btncreateAcc.setOpaque(false);
		btncreateAcc.setBounds(78, 291, 239, 41);
		panel.add(btncreateAcc);
		
		lblCreateAccountText = new JLabel("Create An Account");
		lblCreateAccountText.setForeground(new Color(255, 255, 255));
		lblCreateAccountText.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblCreateAccountText.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccountText.setBounds(35, 60, 328, 41);
		panel.add(lblCreateAccountText);
		
		lblSubText = new JLabel("Create an account to open the service");
		lblSubText.setForeground(new Color(255, 255, 255));
		lblSubText.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubText.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblSubText.setBounds(35, 81, 328, 41);
		panel.add(lblSubText);
		
		lblSubTextLogin = new JLabel("Already have an account?");
		lblSubTextLogin.setForeground(new Color(255, 255, 255));
		lblSubTextLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubTextLogin.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblSubTextLogin.setBounds(49, 343, 303, 41);
		panel.add(lblSubTextLogin);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				dispose();
				loginPage openForm = new loginPage(storeUserInfo);
				openForm.setVisible(true);
				
			}
		});
		btnSignUp.setForeground(new Color(255, 255, 255));
		btnSignUp.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnSignUp.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSignUp.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
		btnSignUp.setBounds(153, 386, 89, 23);
		btnSignUp.setOpaque(false);
		btnSignUp.setFocusable(false);
		btnSignUp.setBackground(new Color(0, 0, 0, 0));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setContentAreaFilled(false);
		panel.add(btnSignUp);
		
		txtUserName = new JTextField();
		txtUserName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtUserName.getText()).equals("Enter Username")) {
				txtUserName.setText("");
				txtUserName.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtUserName.getText()).isEmpty()) {
					txtUserName.setText("Enter Username");
					txtUserName.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtUserName.setForeground(new Color(192, 192, 192));
		txtUserName.setFont(new Font("Montserrat", Font.PLAIN, 17));
		txtUserName.setText("Enter Username");
		txtUserName.setOpaque(false);
		txtUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtUserName.setBounds(41, 135, 303, 41);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtPass.getPassword()).equals("Enter Password")) {
					txtPass.setText("");
					txtPass.setEchoChar('*');					
					txtPass.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtPass.getPassword()).isEmpty()) {
					txtPass.setText("Enter Password");
					txtPass.setEchoChar((char) 0);
					txtPass.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtPass.setForeground(new Color(192, 192, 192));
		txtPass.setEchoChar((char) 0);
		txtPass.setText("Enter Password");
		txtPass.setOpaque(false);
		txtPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtPass.setFont(new Font("Montserrat", Font.PLAIN, 17));
		txtPass.setBounds(41, 187, 303, 41);
		panel.add(txtPass);
		
		repassField = new JPasswordField();
		repassField.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(repassField.getPassword()).equals("Re-Enter Password")) {
					repassField.setText("");
					repassField.setEchoChar('*');					
					repassField.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(repassField.getPassword()).isEmpty()) {
					repassField.setText("Re-Enter Password");
					repassField.setEchoChar((char) 0);
					repassField.setForeground(new Color(192, 192, 192));
				}
			}
		});
		repassField.setForeground(new Color(192, 192, 192));
		repassField.setEchoChar((char) 0);
		repassField.setText("Re-Enter Password");
		repassField.setOpaque(false);
		repassField.setFont(new Font("Montserrat", Font.PLAIN, 17));
		repassField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		repassField.setBounds(41, 239, 303, 41);
		panel.add(repassField);
		
		btnBackToLogin = new JButton("New button");
		btnBackToLogin = new JButton("BACK(LOGIN)");
		btnBackToLogin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				
				btnBackToLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnBackToLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				loginPage openForm = new loginPage(storeUserInfo);
				openForm.setVisible(true);
			}
		});
		btnBackToLogin.setForeground(new Color(0, 128, 0));
		btnBackToLogin.setOpaque(false);
		btnBackToLogin.setBorderPainted(false);
		btnBackToLogin.setContentAreaFilled(false);
		btnBackToLogin.setFocusable(false);
		btnBackToLogin.setBackground(new Color(0, 0, 0, 0));
		btnBackToLogin.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnBackToLogin.setBounds(269, 20, 117, 41);
		getContentPane().add(btnBackToLogin);
		
		btnBackToLogin.setBounds(264, 19, 119, 41);
		panel.add(btnBackToLogin);
		
		tglbtnShowPassword = new JToggleButton("");
		tglbtnShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tglbtnShowPassword.isSelected()) {
					if (String.valueOf(txtPass.getPassword()).equals("Enter Password") && (String.valueOf(repassField.getPassword()).equals("Re-Enter Password"))) {
					} else {
						txtPass.setEchoChar((char) 0);
						repassField.setEchoChar((char) 0);
					}

					tglbtnShowPassword.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleswitchHide.png")));
					txtPass.setEchoChar((char) 0);
				} else {
					if (String.valueOf(txtPass.getPassword()).equals("Enter Password") && (String.valueOf(repassField.getPassword()).equals("Re-Enter Password"))){
					} else {
						txtPass.setEchoChar('*');
						repassField.setEchoChar('*');

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
		tglbtnShowPassword.setBackground(new Color(0, 0, 0, 0));
		tglbtnShowPassword.setFocusable(false);
		tglbtnShowPassword.setBorderPainted(false);
		tglbtnShowPassword.setContentAreaFilled(false);
		tglbtnShowPassword.setBounds(322, 193, 44, 30);
		panel.add(tglbtnShowPassword);
		
		lblImgIcon = new JLabel("");
		lblImgIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgIcon.setIcon(new ImageIcon(this.getClass().getResource("/Justviewacc.png")));
		lblImgIcon.setBounds(0, 0, 400, 500);
		panel.add(lblImgIcon);
		
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
	
	// method for password checking
				public void passwordChecker() {
					
					invalidPassword = false;
					weakPassword = false;
					passwordRequirement = false;
					errorFound = false;
					
					
					String[] notAllowedCharacters = { "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~\"", //index 0
					"`¬!\"#$%&'()*+,./:;<=>?@[\\]^_`{|}~\"0123456789" }; //index 1
					
					char[] password = txtPass.getPassword(); // get the user input in textPassword
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

//				@formatter:on
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
