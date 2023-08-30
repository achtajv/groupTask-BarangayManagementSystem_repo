

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class resetPassword extends JDialog {
	private JLabel lblforPassPrompt;
	private JTextField txtAccIdField;
	private JButton btnValidate;
	private JTextField txtNewPass;
	
	private JButton btnValidateNewPass;
	private JLabel lblforPassPromptsec;
	private JLabel lblImageIcon;
	private JButton btnBackToLogin;

	public resetPassword(AccountManagement storeUserInfo) {
		setUndecorated(true);
		JPanel panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);
		btnValidate = new JButton("");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int getAccId = Integer.parseInt(txtAccIdField.getText());
				
				if (storeUserInfo.validateUser(getAccId, storeUserInfo.getPasscode(getAccId))) {
					lblforPassPrompt.setText("Verified Successfully!");
					lblforPassPromptsec.setText("You can change your password now! " + storeUserInfo.getUserInfo(getAccId) + " !") ;
					txtAccIdField.setVisible(false);
					btnValidate.setVisible(false); 
					txtNewPass.setVisible(true);
					btnValidateNewPass.setVisible(true);
				} else {
					lblforPassPrompt.setText("Invalid account ID");
					lblforPassPromptsec.setText("");
				}

			}
		});
		btnValidate.setIcon(new ImageIcon(this.getClass().getResource("/verify.png")));
		btnValidate.setOpaque(false);
		btnValidate.setBorderPainted(false);
		btnValidate.setContentAreaFilled(false);
		btnValidate.setBackground(new Color (0, 0, 0, 0));
		btnValidate.setBounds(144, 197, 89, 41);
		panel.add(btnValidate);
		JLabel label = new JLabel();
		label.setBounds(192, 5, 0, 0);
		getContentPane().add(label);
		
		lblforPassPrompt = new JLabel("Forgot Password?");
		lblforPassPrompt.setForeground(new Color(255, 255, 255));
		lblforPassPrompt.setHorizontalAlignment(SwingConstants.CENTER);
		lblforPassPrompt.setFont(new Font("Montserrat", Font.BOLD, 22));
		lblforPassPrompt.setBounds(12, 43, 249, 40);
		panel.add(lblforPassPrompt);
		
		lblforPassPromptsec = new JLabel("Don't worry, just enter account ID number");
		lblforPassPromptsec.setHorizontalAlignment(SwingConstants.LEFT);
		lblforPassPromptsec.setForeground(Color.WHITE);
		lblforPassPromptsec.setFont(new Font("Montserrat", Font.BOLD, 10));
		lblforPassPromptsec.setBounds(33, 75, 307, 40);
		panel.add(lblforPassPromptsec);
		
		txtAccIdField = new JTextField();
		txtAccIdField.setForeground(new Color(255, 255, 255));
		txtAccIdField.setOpaque(false);
		txtAccIdField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtAccIdField.setHorizontalAlignment(SwingConstants.CENTER);
		txtAccIdField.setFont(new Font("Montserrat", Font.PLAIN, 24));
		txtAccIdField.setBounds(106, 126, 159, 53);
		panel.add(txtAccIdField);
		txtAccIdField.setColumns(10);
		
		txtNewPass = new JTextField();
		txtNewPass.setOpaque(false);
		txtNewPass.setHorizontalAlignment(SwingConstants.LEFT);
		txtNewPass.setForeground(Color.WHITE);
		txtNewPass.setFont(new Font("Montserrat", Font.PLAIN, 15));
		txtNewPass.setColumns(10);
		txtNewPass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtNewPass.setBounds(43, 126, 269, 53);
		txtNewPass.setVisible(false);
		panel.add(txtNewPass);
		
		btnValidateNewPass = new JButton("");
		btnValidateNewPass.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int getAccId = Integer.parseInt(txtAccIdField.getText());
		        String newUserPass = txtNewPass.getText();
		        
		        if (!CreateAccount.errorFound) { 
		            storeUserInfo.updatePassUser(getAccId, newUserPass);
		            dispose();
		            
		            loginPage userForm = new loginPage(storeUserInfo);
		            userForm.setVisible(true);
		        }
		    }
		});


		btnValidateNewPass.setIcon(new ImageIcon(this.getClass().getResource("/SubmitImg.png")));
		btnValidateNewPass.setOpaque(false);
		btnValidateNewPass.setContentAreaFilled(false);
		btnValidateNewPass.setBorderPainted(false);
		btnValidateNewPass.setVisible(true);
		btnValidateNewPass.setBackground(new Color(0, 0, 0, 0));
		btnValidateNewPass.setBounds(144, 197, 89, 41);
		panel.add(btnValidateNewPass);
		
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
		btnBackToLogin.setBounds(264, 20, 117, 41);
		getContentPane().add(btnBackToLogin);
		
		lblImageIcon = new JLabel("");
		lblImageIcon.setIcon(new ImageIcon(this.getClass().getResource("/Justviewacc.png")));
		lblImageIcon.setBounds(0, 0, 400, 500);
		panel.add(lblImageIcon);
		setTitle("BMS - Login");
		setSize(400, 500);
		setLocationRelativeTo(null);
		setModal(true);

	}
	
	
	
}
