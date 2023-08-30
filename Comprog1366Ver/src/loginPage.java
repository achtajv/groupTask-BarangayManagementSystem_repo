

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class loginPage extends JFrame {

	private JPanel contentPane;
	private JLabel lblImageIcon;
	private JLabel lblLoginForm;
	private JLabel lblUserForm;
	private JLabel lblPassForm;
	private JTextField txtUsername;
	private JPasswordField txtPassForm;
	private JToggleButton tglShowHide;
	private JLabel lblPassForm_1;
	private JButton btnLoginButton;
	private JButton btnForgotPassword;
	private JLabel lbllogincontainer;
	private JLabel lbllogo;
	private JLabel lbllogincontainer_2;
	private JLabel lblUserIcon;
	private JButton btnCreateAccount;
	private JLabel lbllockIcon;
	private fillUpforUpdate fillUpdate;
	public static String getUsernametoLocate;
	public static String getUsernameRole;

	public loginPage(AccountManagement storeUserInfo) {
		setTitle("BMS - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);

		tglShowHide = new JToggleButton("");
		tglShowHide.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				tglShowHide.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
		tglShowHide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (tglShowHide.isSelected()) {
					if (String.valueOf(txtPassForm.getPassword()).equals("Enter Password")) {
					} else {
						txtPassForm.setEchoChar((char) 0);
					}

					tglShowHide.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleswitchHide.png")));
					txtPassForm.setEchoChar((char) 0);
				} else {
					if (String.valueOf(txtPassForm.getPassword()).equals("Enter Password")) {
					} else {
						txtPassForm.setEchoChar('*');

					}

					tglShowHide.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
				}
			}

		});

		btnLoginButton = new JButton("");
		btnLoginButton.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) { 

		         getUsernametoLocate = txtUsername.getText();

		        if (storeUserInfo.validateUserinLoginPage(getUsernametoLocate, storeUserInfo.getUserInfobyString(getUsernametoLocate))) {
		        	
			        getUsernameRole = storeUserInfo.getUserRoleByUsername(getUsernametoLocate);

		        	if (getUsernameRole.equalsIgnoreCase("Administrator")) {
		        		JOptionPane.showMessageDialog(null, "Welcome, Administrator " + getUsernametoLocate + " !", "An Administrator Logins", JOptionPane.INFORMATION_MESSAGE);
		        		
		        	} else {
		        		JOptionPane.showMessageDialog(null, "Welcome, User " + getUsernametoLocate, "An User Logins", JOptionPane.INFORMATION_MESSAGE);
		        		
		        	}	
		        	
		        	dispose();
		        	
		        	MainTabBMS openBMS = new MainTabBMS(storeUserInfo);
		        	openBMS.setVisible(true);
		        	

		        } else {
		        	JOptionPane.showMessageDialog(null, "Account doesn't Exist", "Create an Account First!",JOptionPane.WARNING_MESSAGE);
		        }

		    }
		});
		btnLoginButton.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				btnLoginButton.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
				
				btnCreateAccount = new JButton("Create Account");
				btnLoginButton.addMouseListener(new MouseAdapter() {

					public void mouseEntered(MouseEvent e) {
						btnCreateAccount.setCursor((new Cursor(Cursor.HAND_CURSOR)));
					}
				});
				btnCreateAccount.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {	
							
							dispose();
						
							CreateAccount dialog = new CreateAccount(storeUserInfo);
							dialog.setVisible(true);
						
					}
				});
				btnCreateAccount.setOpaque(false);
				btnCreateAccount.setForeground(new Color(108, 108, 255));
				btnCreateAccount.setFont(new Font("Montserrat", Font.BOLD, 12));
				btnCreateAccount.setFocusable(false);
				btnCreateAccount.setContentAreaFilled(false);
				btnCreateAccount.setBorderPainted(false);
				btnCreateAccount.setBackground(new Color(0, 0, 0, 0));
				btnCreateAccount.setBounds(108, 386, 164, 26);
				contentPane.add(btnCreateAccount);
				
				lbllockIcon = new JLabel("");
				lbllockIcon.setIcon(new ImageIcon(this.getClass().getResource("/lockIcon.png")));
				lbllockIcon.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
				lbllockIcon.setBounds(21, 265, 53, 40);
				contentPane.add(lbllockIcon);
		
				lblUserIcon = new JLabel("");
				lblUserIcon.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
				lblUserIcon.setIcon(new ImageIcon(this.getClass().getResource("/userIcon.png")));
				lblUserIcon.setBounds(20, 184, 55, 40);
				contentPane.add(lblUserIcon);	

		lbllogo = new JLabel("");
		lbllogo.setIcon(new ImageIcon(this.getClass().getResource("/Logo.png")));
		lbllogo.setBounds(280, -12, 125, 115);
		contentPane.add(lbllogo);

		lblLoginForm = new JLabel("BMS Portal");
		lblLoginForm.setForeground(new Color(255, 255, 255));
		lblLoginForm.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setBounds(11, -3, 142, 56);
		contentPane.add(lblLoginForm);

		lbllogincontainer = new JLabel("");
		lbllogincontainer.setIcon(new ImageIcon(this.getClass().getResource("/container.png")));
		contentPane.add(lbllogincontainer);
		btnLoginButton.setOpaque(false);
		btnLoginButton.setBackground(new Color(0, 0, 0, 0));
		btnLoginButton.setFocusable(false);
		btnLoginButton.setBorderPainted(false);
		btnLoginButton.setContentAreaFilled(false);
		btnLoginButton.setIcon(new ImageIcon(this.getClass().getResource("/Login.png")));
		btnLoginButton.setBounds(130, 344, 113, 40);
		contentPane.add(btnLoginButton);

		btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				resetPassword dialog = new resetPassword(storeUserInfo);
				dialog.setVisible(true);
			}
		});
		btnForgotPassword.setForeground(new Color(108, 108, 255));
		btnForgotPassword.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				btnForgotPassword.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
		btnForgotPassword.setFont(new Font("Montserrat", Font.BOLD, 12));
		btnForgotPassword.setOpaque(false);
		btnForgotPassword.setBackground(new Color(0, 0, 0, 0));
		btnForgotPassword.setFocusable(false);
		btnForgotPassword.setBorderPainted(false);
		btnForgotPassword.setContentAreaFilled(false);
		btnForgotPassword.setBounds(206, 307, 164, 26);
		contentPane.add(btnForgotPassword);
		
		tglShowHide.setIcon(new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
		tglShowHide.setOpaque(false);
		tglShowHide.setBackground(new Color(0, 0, 0, 0));
		tglShowHide.setFocusable(false);
		tglShowHide.setBorderPainted(false);
		tglShowHide.setContentAreaFilled(false);
		tglShowHide.setBounds(329, 268, 44, 30);
		contentPane.add(tglShowHide);

		txtPassForm = new JPasswordField();
		txtPassForm.setEchoChar((char) 0);
		txtPassForm.setText("Enter Password");
		
		txtPassForm.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				txtPassForm.setEchoChar('*');
				txtPassForm.removeMouseListener(this);
			}
		});
		txtPassForm.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtPassForm.getPassword()).equals("Enter Password")) {
				txtPassForm.setText("");
				txtPassForm.setEchoChar('*');
			}
				
			} public void focusLost(FocusEvent e) {
				if(String.valueOf(txtPassForm.getPassword()).isEmpty()) {
				txtPassForm.setText("Enter Password");
					txtPassForm.setEchoChar((char) 0);
				}
			}
			
		});
		
		
		txtPassForm.setFont(new Font("Montserrat", Font.PLAIN, 15));
		txtPassForm.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		txtPassForm.setOpaque(false);
		txtPassForm.setBounds(74, 261, 275, 44);
		contentPane.add(txtPassForm);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Montserrat", Font.PLAIN, 15));
		txtUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		txtUsername.setOpaque(false);
		txtUsername.setBounds(74, 180, 275, 44);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		lblPassForm = new JLabel("Password");
		lblPassForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassForm.setForeground(Color.BLACK);
		lblPassForm.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblPassForm.setBounds(-10, 231, 167, 32);
		contentPane.add(lblPassForm);

		lblUserForm = new JLabel("Username");
		lblUserForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserForm.setForeground(Color.BLACK);
		lblUserForm.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblUserForm.setBounds(-10, 150, 167, 32);
		contentPane.add(lblUserForm);

		lblImageIcon = new JLabel("");
		lblImageIcon.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblImageIcon.setIcon(new ImageIcon(this.getClass().getResource("/LoginBackground.png")));
		lblImageIcon.setBounds(0, 0, 384, 461);
		contentPane.add(lblImageIcon);

		lblPassForm_1 = new JLabel("Password");
		lblPassForm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassForm_1.setForeground(Color.BLACK);
		lblPassForm_1.setFont(new Font("Montserrat", Font.PLAIN, 20));
		lblPassForm_1.setBounds(96, 312, 167, 32);
		contentPane.add(lblPassForm_1);

		lbllogincontainer_2 = new JLabel("");
		lbllogincontainer_2.setBounds(2, 149, 153, 56);
		contentPane.add(lbllogincontainer_2);
	}
}
