

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class fillUpforUpdate extends JDialog {

	private JPanel contentPane;
	private JLabel lblImgIcon;
	private JLabel lblHeaderText;
	public static JTextField txtUpdateUsername;
	public static JPasswordField txtpsdField;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JLabel lblUpdateSubText;
	public static JLabel lblUpdateSubTextforAccId;
	private JRadioButton rdnlvlAccessForAdmin;
	private JToggleButton tglbtnShowPassUpdate;
	
	public fillUpforUpdate(AccountManagement accounDatabase) {
		
		setModal(true);
		setUndecorated(true);
		setSize(400, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		tglbtnShowPassUpdate = new JToggleButton("");
		tglbtnShowPassUpdate.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {
				tglbtnShowPassUpdate.setCursor((new Cursor(Cursor.HAND_CURSOR)));
			}
		});
		tglbtnShowPassUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (tglbtnShowPassUpdate.isSelected()) {
					if (String.valueOf(txtpsdField.getPassword()).equals("Enter New Password to Update")) {
					} else {
						txtpsdField.setEchoChar((char) 0);
					}

					tglbtnShowPassUpdate.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleswitchHide.png")));
					txtpsdField.setEchoChar((char) 0);
				} else {
					if (String.valueOf(txtpsdField.getPassword()).equals("Enter New Password to Update")) {
					} else {
						txtpsdField.setEchoChar('*');

					}

					tglbtnShowPassUpdate.setIcon(
							new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
				}
			}

		});
		tglbtnShowPassUpdate.setIcon(new ImageIcon(this.getClass().getResource("/ToggleSwitch.png")));
		tglbtnShowPassUpdate.setOpaque(false);
		tglbtnShowPassUpdate.setFocusable(false);
		tglbtnShowPassUpdate.setContentAreaFilled(false);
		tglbtnShowPassUpdate.setBorderPainted(false);
		tglbtnShowPassUpdate.setBackground(new Color(0, 0, 0, 0));
		tglbtnShowPassUpdate.setBounds(346, 185, 44, 30);
		getContentPane().add(tglbtnShowPassUpdate);
		
		lblHeaderText = new JLabel("UPDATE ACCOUNT");
		lblHeaderText.setForeground(new Color(255, 255, 255));
		lblHeaderText.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeaderText.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblHeaderText.setBounds(10, 11, 201, 51);
		getContentPane().add(lblHeaderText);
				
		txtUpdateUsername = new JTextField();
		txtUpdateUsername.setText("Enter New Username to Update");
		txtUpdateUsername.setEnabled(false);
		txtUpdateUsername.setForeground(new Color(192, 192, 192));
		txtUpdateUsername.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtUpdateUsername.getText()).equals("Enter New Username to Update")) {
					txtUpdateUsername.setText("");
					txtUpdateUsername.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtUpdateUsername.getText()).isEmpty()) {
					txtUpdateUsername.setText("Enter New Username to Update");
					txtUpdateUsername.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtUpdateUsername.setOpaque(false);
		txtUpdateUsername.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtUpdateUsername.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtUpdateUsername.setBounds(38, 103, 331, 51);
		getContentPane().add(txtUpdateUsername);
		txtUpdateUsername.setColumns(10);
		
		txtpsdField = new JPasswordField();
		txtpsdField.setText("Enter New Password to Update");
		txtpsdField.setEnabled(false);
		txtpsdField.setEchoChar((char) 0);
		txtpsdField.setForeground(new Color(192, 192, 192));
		txtpsdField.addFocusListener(new FocusAdapter() { 
			public void focusGained(FocusEvent e) {
				if(String.valueOf(txtpsdField.getPassword()).equals("Enter New Password to Update")) {
					txtpsdField.setText("");
					txtpsdField.setEchoChar('*');					
					txtpsdField.setForeground(Color.WHITE);
				}
				
			} 	public void focusLost(FocusEvent e) {
				if(String.valueOf(txtpsdField.getPassword()).isEmpty()) {
					txtpsdField.setText("Enter New Password to Update");
					txtpsdField.setEchoChar((char) 0);
					txtpsdField.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtpsdField.setOpaque(false);
		txtpsdField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		txtpsdField.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtpsdField.setBounds(38, 179, 331, 41);
		getContentPane().add(txtpsdField);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				
				btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Disable the buttons and selection indicates a new user modification to the accounts
				MainTabBMS.btnUpdateAcc.setEnabled(false);
				MainTabBMS.btnDelete.setEnabled(false);
				MainTabBMS.tableforShowingtheData.clearSelection();
				//immediately close the frame
				dispose();
				
				
			}
		});
		btnCancel.setForeground(new Color(0, 128, 0));
		btnCancel.setOpaque(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setFocusable(false);
		btnCancel.setBackground(new Color(0, 0, 0, 0));
		btnCancel.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnCancel.setBounds(269, 20, 117, 41);
		getContentPane().add(btnCancel);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// get the accountID since it will be needed to find the row need to be updated
				int getAccId = Integer.parseInt(lblUpdateSubTextforAccId.getText());
				// get the new username
				String newUserName = txtUpdateUsername.getText();
				// get the new password
				String newUserPass = String.valueOf(txtpsdField.getPassword());
				// get the new role (if admin wants user to be admin)
				String getLvlAccess = rdnlvlAccessForAdmin.getText();
				//update the username first in the array
				accounDatabase.updateUsername(getAccId, newUserName);
				//update the password first in the array
				accounDatabase.updatePassUser(getAccId, newUserPass);
				
				if (txtUpdateUsername.getText().equals("Enter New Username to Update") || String.valueOf(txtpsdField.getPassword()).equals("Enter New Password to Update")) {
		            JOptionPane.showMessageDialog(null, "All fields are required", "Returns Empty Field", JOptionPane.WARNING_MESSAGE);
		            return;
				}
				
				//if radio button for admin is selected
				if (rdnlvlAccessForAdmin.isSelected()) {
					//update the user role in the array
					accounDatabase.updateUserRole(getAccId, getLvlAccess);
					
					 int responseDialog = JOptionPane.showConfirmDialog(null, "Are you sure you want " + txtUpdateUsername.getText() + " to become Admin", "Confirmation for Access", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					    if (responseDialog == JOptionPane.YES_OPTION) {
					    	
					    	MainTabBMS.btnSaveChanges.setVisible(true);
					    	MainTabBMS.btnSaveChanges.setEnabled(true);
					    	MainTabBMS.lblChangeMessagePrompt.setVisible(true);

							dispose();

					    } else if (responseDialog == JOptionPane.NO_OPTION) {
					        return;
					    }
				}
				// used the method of find the current row first is get the accID and store it to an int variable
				int locateIndexofRow = findTheCurrentRow(MainTabBMS.tableNew, getAccId);
				//set the value of the new user name , password, role (locateIndexofRow is the index of row)
				MainTabBMS.tableNew.setValueAt(newUserName, locateIndexofRow, 1); // 1 since its the username index
				MainTabBMS.tableNew.setValueAt(newUserPass, locateIndexofRow, 2); // 2 since its the password index
				MainTabBMS.tableNew.setValueAt(getLvlAccess, locateIndexofRow, 3); // 3 since its the roles index
				// show prompt message of successfull update
				JOptionPane.showMessageDialog(null, "Successfully Updated " + getAccId, "Update Change", JOptionPane.INFORMATION_MESSAGE);
				
				//Disable the buttons and selection indicates a new user modification to the accounts
				MainTabBMS.btnUpdateAcc.setEnabled(false);
				MainTabBMS.btnDelete.setEnabled(false);
				MainTabBMS.tableforShowingtheData.clearSelection();

				//close the frame
				dispose();
				
			}
		});
		btnUpdate.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				
				btnUpdate.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnUpdate.setOpaque(false);
		btnUpdate.setForeground(new Color(0, 128, 0));
		btnUpdate.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnUpdate.setFocusable(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBackground(new Color(0, 0, 0, 0));
		btnUpdate.setBounds(145, 407, 117, 41);
		getContentPane().add(btnUpdate);
		
		lblUpdateSubText = new JLabel("Update User:");
		lblUpdateSubText.setForeground(new Color(255, 255, 255));
		lblUpdateSubText.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblUpdateSubText.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSubText.setBounds(102, 281, 201, 34);
		getContentPane().add(lblUpdateSubText);
		
		lblUpdateSubTextforAccId = new JLabel("");
		lblUpdateSubTextforAccId.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateSubTextforAccId.setForeground(Color.WHITE);
		lblUpdateSubTextforAccId.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblUpdateSubTextforAccId.setBounds(102, 326, 201, 34);
		getContentPane().add(lblUpdateSubTextforAccId);
		
		rdnlvlAccessForAdmin = new JRadioButton("Administrator");
		rdnlvlAccessForAdmin.setForeground(new Color(255, 255, 255));
		rdnlvlAccessForAdmin.setOpaque(false);
		rdnlvlAccessForAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		rdnlvlAccessForAdmin.setFont(new Font("Montserrat", Font.PLAIN, 15));
		rdnlvlAccessForAdmin.setBounds(33, 238, 137, 23);
		getContentPane().add(rdnlvlAccessForAdmin);
		
		
		lblImgIcon = new JLabel("");
		lblImgIcon.setIcon(new ImageIcon(this.getClass().getResource("/AddAccount.png")));
		lblImgIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblImgIcon.setBounds(0, 0, 400, 500);
		getContentPane().add(lblImgIcon);
	}
	
	// method on getting the currentRow (used for updating)
	public int findTheCurrentRow(DefaultTableModel customModel, int accId) {
		//Get the total row count of the model (tableNew)
		int totalAdminUserCount = customModel.getRowCount();
		// 
		for (int iterateThroughRows = 0; iterateThroughRows < totalAdminUserCount; iterateThroughRows++ ) {
			// since accID is the first in column also in index of data in every row, get the row matching with the accID and store to an int variable  
			int findIndexofId = Integer.parseInt(customModel.getValueAt(iterateThroughRows, 0).toString());
			//compares all iterated retrieve account ID to check if that is the specific row needed
			if (findIndexofId == accId) {
				//return the index
				return iterateThroughRows;
			}
			
		}
		//if not found return -1 since it indicates that there's no match for the account ID give 
		return -1;
	}
	
	
}
