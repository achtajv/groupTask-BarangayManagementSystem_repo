
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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.UIManager;

//Main Method
public class Main {
	public static void main(String[] args) {
		
	BMSTheme.setup();// custom look and feel for design
	
	//Initial Account for the Admin
	int[] accId = {420690};
	String[] username = {"group1Admin"};
	String[] password = {"admin123"};
	String[] roles = {"Administrator"};
	
	 AccountManagement storeUserInfo = new AccountManagement(accId, username, password, roles);

		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
				
					loginPage login = new loginPage(storeUserInfo);
					login.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
	}

}
