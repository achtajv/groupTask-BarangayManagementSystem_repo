
import java.awt.Color;
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

public class blotterDetailsComplainant extends JDialog {

	private blotterDetailsRespondent frameRespondentInfo;

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
	private final JLabel lblBGComplainantsInfo = new JLabel("");

	public blotterDetailsComplainant() {
		setUndecorated(true);
		setModal(true);
		setBounds(100, 100, 400, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExit = new JLabel("X");
		lblExit.setForeground(Color.WHITE);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // if click the "X"
				blotterDetailsComplainant.this.dispose();
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(376, 0, 24, 19);
		contentPane.add(lblExit);
//      ================== making labels ==============================
		JLabel lblComplainantInfo = new JLabel("Complainant's Information");
		lblComplainantInfo.setForeground(Color.WHITE);
		lblComplainantInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComplainantInfo.setBounds(23, 22, 233, 15);
		contentPane.add(lblComplainantInfo);

		JLabel lblName = new JLabel("Name     :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(74, 47, 62, 15);
		contentPane.add(lblName);

		JLabel lblAge = new JLabel("Age     :");
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setBounds(74, 71, 62, 15);
		contentPane.add(lblAge);

		JLabel lblSex = new JLabel("Sex     :");
		lblSex.setForeground(Color.WHITE);
		lblSex.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSex.setBounds(74, 96, 62, 15);
		contentPane.add(lblSex);

		JLabel lblCivilStatus = new JLabel("Civil Status     :");
		lblCivilStatus.setForeground(Color.WHITE);
		lblCivilStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCivilStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCivilStatus.setBounds(33, 145, 103, 15);
		contentPane.add(lblCivilStatus);

		JLabel lblAddress = new JLabel("Address     :");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAddress.setBounds(47, 170, 89, 15);
		contentPane.add(lblAddress);

		JLabel lblContact = new JLabel("Contact#     :");
		lblContact.setForeground(Color.WHITE);
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContact.setBounds(47, 120, 89, 15);
		contentPane.add(lblContact);

		JLabel lblIncidentReport = new JLabel("Incident Report     :");
		lblIncidentReport.setForeground(Color.WHITE);
		lblIncidentReport.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIncidentReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIncidentReport.setBounds(23, 239, 113, 15);
		contentPane.add(lblIncidentReport);
//==================== making null label for any data inputs
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
		scrollPane.setOpaque(false);
		scrollPane.setBorder(null);
		scrollPane.setBounds(134, 170, 246, 59);
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
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBorder(null);
		scrollPane_1.setBounds(134, 239, 246, 133);
		contentPane.add(scrollPane_1);

		txtAIncidentReport = new JTextArea();
		txtAIncidentReport.setOpaque(false);
		txtAIncidentReport.setForeground(Color.WHITE);
		txtAIncidentReport.setLineWrap(true);
		txtAIncidentReport.setEditable(false);
		txtAIncidentReport.setFont(new Font("Times New Roman", Font.BOLD, 13));
		scrollPane_1.setViewportView(txtAIncidentReport);

		JButton btnRespondentInfo = new JButton(">>>>");
		btnRespondentInfo.setBackground(Color.decode(MainTabBMS.green));
		btnRespondentInfo.setForeground(Color.WHITE);
		btnRespondentInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRespondentInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameRespondentInfo = new blotterDetailsRespondent();
				blotterDetailsComplainant.this.dispose();
				frameRespondentInfo.setVisible(true);
			}
		});
		btnRespondentInfo.setVisible(false);
		btnRespondentInfo.setBounds(295, 383, 85, 21);
		contentPane.add(btnRespondentInfo);
		lblBGComplainantsInfo
				.setIcon(new ImageIcon(blotterDetailsComplainant.class.getResource("/Images/BGVioletBlue.png")));
		lblBGComplainantsInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGComplainantsInfo.setBounds(0, 0, 400, 415);
		contentPane.add(lblBGComplainantsInfo);

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

		if (selectedIndexRespondentTable > -1) { // if there's no respondent info
			btnRespondentInfo.setVisible(true);
			gettingInfoComplainant();
		} else { // if there's respondent info
			gettingInfoComplainant();
		}
		setLocationRelativeTo(null);
	}

	private void gettingInfoComplainant() { // getting the data and dislaying it

		int selectedRow = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNum = MainTabBMS.tblBlotterRecords.getValueAt(selectedRow, 0).toString();

		int selectedIndexComplainantTable = -1;
		for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexComplainantTable = index;
				break;
			}
		}
		;

		lblNameInfo.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 1) + " "
				+ MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 2) + " "
				+ MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 3));
		lblAgeInfo.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 5).toString());

		String sexInfo = "";
		int indexSex = Integer
				.parseInt(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 10).toString());
		if (indexSex == 0) {
			sexInfo = "Male";
		} else {
			sexInfo = "Female";
		}
		lblSexInfo.setText(sexInfo);

		lblContactInfo
				.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 6).toString());

		String civilStatusInfo = "";
		int indexCivilStatus = Integer
				.parseInt(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 9).toString());
		if (indexCivilStatus == 0) {
			civilStatusInfo = "Single";
		} else if (indexCivilStatus == 1) {
			civilStatusInfo = "Married";
		} else {
			civilStatusInfo = "Widowed";
		}
		lblCivilStatusInfo.setText(civilStatusInfo);
		txtAAddress.setText(
				"     " + MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 7).toString());
		txtAIncidentReport
				.setText("     " + MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 8));

	}
}
