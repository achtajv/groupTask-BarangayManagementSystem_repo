
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class blotterDetailsRespondent extends JDialog {

	private blotterDetailsComplainant frameComplainantInfo;

	private JPanel contentPane;
	private JTextArea txtAIncidentReport;
	private JScrollPane scrollPane_1;
	private JTextArea txtAAddress;
	private JScrollPane scrollPane;
	private JLabel lblSexInfo;
	private JLabel lblCivilStatusInfo;
	private JLabel lblContactInfo;
	private JLabel lblAgeInfo;
	private JLabel lblNameInfo;
	private JLabel lblViolationInfo;
	private JLabel lblAccusationInfo;

	private JLabel lblNewLabel;

	public blotterDetailsRespondent() {
		setUndecorated(true);
		setModal(true);
		setBounds(100, 100, 400, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExit = new JLabel("X");
		lblExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblExit.setForeground(Color.WHITE);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // if the user click "X"
				blotterDetailsRespondent.this.dispose();
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(376, 0, 24, 19);
		contentPane.add(lblExit);
//   	 ===================== making labels =======================
		JLabel lblRespondentInfo = new JLabel("Respondent's Information");
		lblRespondentInfo.setForeground(Color.WHITE);
		lblRespondentInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRespondentInfo.setBounds(23, 22, 233, 15);
		contentPane.add(lblRespondentInfo);

		JLabel lblName = new JLabel("Name     :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(74, 48, 62, 15);
		contentPane.add(lblName);

		JLabel lblAge = new JLabel("Age     :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(74, 71, 62, 15);
		contentPane.add(lblAge);

		JLabel lblSex = new JLabel("Sex     :");
		lblSex.setForeground(Color.WHITE);
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSex.setBounds(74, 96, 62, 15);
		contentPane.add(lblSex);

		JLabel lblCivilStatus = new JLabel("Civil Status     :");
		lblCivilStatus.setForeground(Color.WHITE);
		lblCivilStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCivilStatus.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCivilStatus.setBounds(33, 145, 103, 15);
		contentPane.add(lblCivilStatus);

		JLabel lblAddress = new JLabel("Address     :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAddress.setBounds(47, 170, 89, 15);
		contentPane.add(lblAddress);

		JLabel lblContact = new JLabel("Contact#     :");
		lblContact.setForeground(Color.WHITE);
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContact.setFont(new Font("Dialog", Font.BOLD, 12));
		lblContact.setBounds(47, 120, 89, 15);
		contentPane.add(lblContact);

		JLabel lblIncidentReport = new JLabel("Incident Report     :");
		lblIncidentReport.setForeground(Color.WHITE);
		lblIncidentReport.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncidentReport.setFont(new Font("Dialog", Font.BOLD, 12));
		lblIncidentReport.setBounds(23, 239, 113, 15);
		contentPane.add(lblIncidentReport);

		JLabel lblAccusation = new JLabel("Accusation     :");
		lblAccusation.setForeground(Color.WHITE);
		lblAccusation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccusation.setFont(new Font("Dialog", Font.BOLD, 12));
		lblAccusation.setBounds(47, 370, 89, 15);
		contentPane.add(lblAccusation);

		JLabel lblViolation = new JLabel("Violation     :");
		lblViolation.setForeground(Color.WHITE);
		lblViolation.setHorizontalAlignment(SwingConstants.RIGHT);
		lblViolation.setFont(new Font("Dialog", Font.BOLD, 12));
		lblViolation.setBounds(33, 394, 103, 15);
		contentPane.add(lblViolation);
//====================== making null labels for data inputs
		lblNameInfo = new JLabel("");
		lblNameInfo.setForeground(Color.WHITE);
		lblNameInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNameInfo.setBounds(146, 47, 234, 13);
		contentPane.add(lblNameInfo);

		lblAgeInfo = new JLabel("");
		lblAgeInfo.setForeground(Color.WHITE);
		lblAgeInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAgeInfo.setBounds(146, 73, 234, 13);
		contentPane.add(lblAgeInfo);

		lblContactInfo = new JLabel("");
		lblContactInfo.setForeground(Color.WHITE);
		lblContactInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblContactInfo.setBounds(146, 122, 234, 13);
		contentPane.add(lblContactInfo);

		lblCivilStatusInfo = new JLabel("");
		lblCivilStatusInfo.setForeground(Color.WHITE);
		lblCivilStatusInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCivilStatusInfo.setBounds(146, 147, 234, 13);
		contentPane.add(lblCivilStatusInfo);

		lblSexInfo = new JLabel("");
		lblSexInfo.setForeground(Color.WHITE);
		lblSexInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblSexInfo.setBounds(146, 98, 234, 13);
		contentPane.add(lblSexInfo);

		scrollPane = new JScrollPane();
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(135, 170, 245, 59);
		contentPane.add(scrollPane);

		txtAAddress = new JTextArea();
		txtAAddress.setOpaque(false);
		txtAAddress.setForeground(Color.WHITE);
		txtAAddress.setLineWrap(true);
		txtAAddress.setEditable(false);
		txtAAddress.setFont(new Font("Times New Roman", Font.BOLD, 13));
		scrollPane.setViewportView(txtAAddress);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setOpaque(false);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(135, 239, 245, 123);
		contentPane.add(scrollPane_1);

		txtAIncidentReport = new JTextArea();
		txtAIncidentReport.setOpaque(false);
		txtAIncidentReport.setForeground(Color.WHITE);
		txtAIncidentReport.setLineWrap(true);
		txtAIncidentReport.setEditable(false);
		txtAIncidentReport.setFont(new Font("Times New Roman", Font.BOLD, 13));
		scrollPane_1.setViewportView(txtAIncidentReport);

		JButton btnComplainantInfo = new JButton("<<<<");
		btnComplainantInfo.setBackground(Color.decode(MainTabBMS.blue));
		btnComplainantInfo.setForeground(Color.WHITE);
		btnComplainantInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnComplainantInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameComplainantInfo = new blotterDetailsComplainant();
				blotterDetailsRespondent.this.dispose();
				frameComplainantInfo.setVisible(true);
			}
		});
		btnComplainantInfo.setBounds(23, 419, 85, 21);
		contentPane.add(btnComplainantInfo);

		lblAccusationInfo = new JLabel("");
		lblAccusationInfo.setForeground(Color.WHITE);
		Font font = lblAccusationInfo.getFont();
		lblAccusationInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAccusationInfo.setBounds(146, 370, 234, 13);
		contentPane.add(lblAccusationInfo);

		lblViolationInfo = new JLabel("");
		lblViolationInfo.setForeground(Color.WHITE);
		lblViolationInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblViolationInfo.setBounds(146, 396, 234, 13);
		contentPane.add(lblViolationInfo);

		lblNewLabel = new JLabel("Generate Report");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			// Change color
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(new Color(47, 79, 79)); // if the user cursor enter the label
				lblNewLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) { // if the user cursor exit the label
				lblNewLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mousePressed(MouseEvent e) {// if the user cursor pressed the label
				lblNewLabel.setForeground(new Color(112, 128, 144));
			}

			@Override
			public void mouseReleased(MouseEvent e) {// if the user cursor released the label
				lblNewLabel.setForeground(new Color(47, 79, 79));
				blotterGenerateReport genRep = new blotterGenerateReport();
				genRep.setVisible(true);
			}
		});
		lblNewLabel.setBounds(261, 420, 119, 18);
		contentPane.add(lblNewLabel);

		JLabel lblBGDetailRespondent = new JLabel("");
		lblBGDetailRespondent
				.setIcon(new ImageIcon(blotterDetailsRespondent.class.getResource("/Images/BGLightBlueGreen.png")));
		lblBGDetailRespondent.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGDetailRespondent.setBounds(0, 0, 400, 450);
		contentPane.add(lblBGDetailRespondent);

		gettingInfoRespondent();

		setLocationRelativeTo(null);
	}

	private void gettingInfoRespondent() {// getting the data and displaying it

		int selectedRow = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNum = MainTabBMS.tblBlotterRecords.getValueAt(selectedRow, 0).toString();

		int selectedIndexRespondentTable = -1;
		for (int index = 0; index < MainTabBMS.tblStoredDataRespondent.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataRespondent.getValueAt(index, 11).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexRespondentTable = index;
				break;
			}
		}
		;

		lblNameInfo.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 0) + " "
				+ MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 1) + " "
				+ MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 2));
		lblAgeInfo.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 5).toString());

		String sexInfo = "";
		int indexSex = Integer
				.parseInt(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 10).toString());
		if (indexSex == 0) {
			sexInfo = "Male";
		} else {
			sexInfo = "Female";
		}
		lblSexInfo.setText(sexInfo);

		lblContactInfo
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 6).toString());

		String civilStatusInfo = "";
		int indexCivilStatus = Integer
				.parseInt(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 9).toString());
		if (indexCivilStatus == 0) {
			civilStatusInfo = "Single";
		} else if (indexCivilStatus == 1) {
			civilStatusInfo = "Married";
		} else {
			civilStatusInfo = "Widowed";
		}
		lblCivilStatusInfo.setText(civilStatusInfo);
		txtAAddress.setText(
				"     " + MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 7).toString());
		txtAIncidentReport
				.setText("     " + MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 8));

		lblAccusationInfo
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 3).toString());
		lblViolationInfo
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 4).toString());
	}
}
