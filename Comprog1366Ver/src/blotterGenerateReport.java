
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class blotterGenerateReport extends JDialog {

	private final JPanel contentPane;
	private JLabel lblNameRespondent;
	private JLabel lblAgeRespondent;
	private JLabel lblContactNumRespondent;
	private JLabel lblSexRespondent;
	private JLabel lblCivilStatusRespondent;
	private JLabel lblNameComplainant;
	private JLabel lblAgeComplainant;
	private JLabel lblSexComplainant;
	private JLabel lblCivilStatusComplainant;
	private JLabel lblContactNumComplainant;
	private JLabel lblStatus;
	private JLabel lblAccusation;
	private JLabel lblViolation;
	private JTextArea txtAIncidentReports;
	private JLabel lblCaseNum;

	public blotterGenerateReport() {

		setUndecorated(true);
		setModal(true);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 0, 500, 600);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
// 		========================= making the display ===========================
		JLabel lblPhilippinesDisplay = new JLabel("Republic of the Philippines");
		lblPhilippinesDisplay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhilippinesDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhilippinesDisplay.setBounds(148, 10, 204, 13);
		panel.add(lblPhilippinesDisplay);

		JLabel lblProvinceDisplay = new JLabel("Province of Laguna");
		lblProvinceDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblProvinceDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblProvinceDisplay.setBounds(148, 24, 204, 13);
		panel.add(lblProvinceDisplay);

		JLabel lblExit = new JLabel("X");
		lblExit.setBounds(474, 0, 24, 19);
		panel.add(lblExit);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				blotterGenerateReport.this.dispose();
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblMunicipalityDisplay = new JLabel("Municipality of Maharlika");
		lblMunicipalityDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblMunicipalityDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblMunicipalityDisplay.setBounds(148, 38, 204, 13);
		panel.add(lblMunicipalityDisplay);

		JLabel lblBarangayDisplay = new JLabel("Barangay Tayo");
		lblBarangayDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblBarangayDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarangayDisplay.setBounds(148, 50, 204, 13);
		panel.add(lblBarangayDisplay);

		JLabel lblLupongTagapamayapaDisplay = new JLabel("Office of the Lupong Tagapamayapa");
		lblLupongTagapamayapaDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblLupongTagapamayapaDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblLupongTagapamayapaDisplay.setBounds(95, 73, 300, 13);
		panel.add(lblLupongTagapamayapaDisplay);

		JLabel lblCaseNumDisplay = new JLabel("Barangay Case Number:");
		lblCaseNumDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaseNumDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblCaseNumDisplay.setBounds(319, 96, 133, 13);
		panel.add(lblCaseNumDisplay);

		JLabel lblStatusDisplay = new JLabel("Status:");
		lblStatusDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStatusDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblStatusDisplay.setBounds(192, 169, 127, 13);
		panel.add(lblStatusDisplay);

		JLabel lblAccusationDisplay = new JLabel("Accusation:");
		lblAccusationDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAccusationDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblAccusationDisplay.setBounds(192, 186, 127, 13);
		panel.add(lblAccusationDisplay);

		JLabel lblViolationDisplay = new JLabel("Violation:");
		lblViolationDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblViolationDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblViolationDisplay.setBounds(315, 243, 48, 13);
		panel.add(lblViolationDisplay);

		JLabel lblComplainantDisplay = new JLabel("Complainant");
		lblComplainantDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblComplainantDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblComplainantDisplay.setBounds(38, 96, 127, 13);
		panel.add(lblComplainantDisplay);

		JLabel lblRespondentDisplay = new JLabel("Respondent");
		lblRespondentDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblRespondentDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblRespondentDisplay.setBounds(38, 195, 127, 13);
		panel.add(lblRespondentDisplay);

		JLabel lblAgainstDisplay = new JLabel("---against---");
		lblAgainstDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgainstDisplay.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblAgainstDisplay.setBounds(38, 181, 127, 13);
		panel.add(lblAgainstDisplay);

		lblNameRespondent = new JLabel("");
		lblNameRespondent.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNameRespondent.setBounds(38, 213, 150, 13);
		panel.add(lblNameRespondent);

		lblAgeRespondent = new JLabel("");
		lblAgeRespondent.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblAgeRespondent.setBounds(38, 228, 95, 13);
		panel.add(lblAgeRespondent);

		lblContactNumRespondent = new JLabel("");
		lblContactNumRespondent.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblContactNumRespondent.setBounds(38, 259, 127, 13);
		panel.add(lblContactNumRespondent);

		lblSexRespondent = new JLabel("");
		lblSexRespondent.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblSexRespondent.setBounds(100, 229, 88, 13);
		panel.add(lblSexRespondent);

		lblCivilStatusRespondent = new JLabel("");
		lblCivilStatusRespondent.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblCivilStatusRespondent.setBounds(38, 243, 176, 13);
		panel.add(lblCivilStatusRespondent);

		JLabel lblIncidentReportsDisplay = new JLabel("Full Incident Reports");
		lblIncidentReportsDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncidentReportsDisplay.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblIncidentReportsDisplay.setBounds(148, 296, 188, 13);
		panel.add(lblIncidentReportsDisplay);

		txtAIncidentReports = new JTextArea();
		txtAIncidentReports.setRequestFocusEnabled(false);
		txtAIncidentReports.setFocusable(false);
		txtAIncidentReports.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		txtAIncidentReports.setLineWrap(true);
		txtAIncidentReports.setBounds(38, 325, 426, 273);
		panel.add(txtAIncidentReports);
// 		================ making null labels for the inputs ====================
		lblNameComplainant = new JLabel("");
		lblNameComplainant.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblNameComplainant.setBounds(38, 112, 202, 13);
		panel.add(lblNameComplainant);

		lblAgeComplainant = new JLabel("");
		lblAgeComplainant.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblAgeComplainant.setBounds(38, 127, 127, 13);
		panel.add(lblAgeComplainant);

		lblSexComplainant = new JLabel("");
		lblSexComplainant.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblSexComplainant.setBounds(100, 127, 88, 13);
		panel.add(lblSexComplainant);

		lblCivilStatusComplainant = new JLabel("");
		lblCivilStatusComplainant.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblCivilStatusComplainant.setBounds(38, 142, 127, 13);
		panel.add(lblCivilStatusComplainant);

		lblContactNumComplainant = new JLabel("");
		lblContactNumComplainant.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblContactNumComplainant.setBounds(38, 158, 127, 13);
		panel.add(lblContactNumComplainant);

		lblStatus = new JLabel("");
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblStatus.setBounds(325, 169, 127, 13);
		panel.add(lblStatus);

		lblAccusation = new JLabel("");
		lblAccusation.setHorizontalAlignment(SwingConstants.LEFT);
		lblAccusation.setFont(new Font("Times New Roman", Font.BOLD, 10));
		lblAccusation.setBounds(325, 186, 163, 13);
		panel.add(lblAccusation);

		lblViolation = new JLabel("");
		lblViolation.setHorizontalAlignment(SwingConstants.CENTER);
		lblViolation.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblViolation.setBounds(216, 259, 248, 13);
		panel.add(lblViolation);

		lblCaseNum = new JLabel("");
		lblCaseNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaseNum.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblCaseNum.setBounds(329, 111, 123, 13);
		panel.add(lblCaseNum);
		gettingInfoComplainantAndRespondent();

		setLocationRelativeTo(null);
	}

	private void gettingInfoComplainantAndRespondent() {
		// ================================================================================================================
		// getting data for complainant
		int selectedRowComplainant = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNumComplainant = MainTabBMS.tblBlotterRecords.getValueAt(selectedRowComplainant, 0).toString();

		int selectedIndexComplainantTable = -1;
		for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0).toString();
			if (caseNumComplainant == caseNumCompare) {
				selectedIndexComplainantTable = index;
				break;
			}
		};

		lblCaseNum.setText(
				MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 0).toString());
		lblNameComplainant.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 1)
				+ " " + MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 2) + " "
				+ MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 3));
		lblAgeComplainant.setText(
				MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 5).toString());

		String sexInfoComplainant = "";
		int indexSexComplainant = Integer.parseInt(
				MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 10).toString());
		if (indexSexComplainant == 0) {
			sexInfoComplainant = "Male";
		} else {
			sexInfoComplainant = "Female";
		}
		lblSexComplainant.setText(sexInfoComplainant);

		lblContactNumComplainant.setText(
				MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 6).toString());

		String civilStatusInfoComplainant = "";
		int indexCivilStatusComplainant = Integer.parseInt(
				MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 9).toString());
		if (indexCivilStatusComplainant == 0) {
			civilStatusInfoComplainant = "Single";
		} else if (indexCivilStatusComplainant == 1) {
			civilStatusInfoComplainant = "Married";
		} else {
			civilStatusInfoComplainant = "Widowed";
		}
		lblCivilStatusComplainant.setText(civilStatusInfoComplainant);
		// ===========================================================================================================
		// getting data for respondent
		int selectedRowRespondent = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNumRespondent = MainTabBMS.tblBlotterRecords.getValueAt(selectedRowRespondent, 0).toString();

		int selectedIndexRespondentTable = -1;
		for (int index = 0; index < MainTabBMS.tblStoredDataRespondent.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataRespondent.getValueAt(index, 11).toString();
			if (caseNumRespondent == caseNumCompare) {
				selectedIndexRespondentTable = index;
				break;
			}
		}
		;

		lblNameRespondent.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 0)
				+ " " + MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 1) + " "
				+ MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 2));
		lblAgeRespondent
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 5).toString());

		String sexInfoRespondent = "";
		int indexSexRespondent = Integer.parseInt(
				MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 10).toString());
		if (indexSexRespondent == 0) {
			sexInfoRespondent = "Male";
		} else {
			sexInfoRespondent = "Female";
		}
		lblSexRespondent.setText(sexInfoRespondent);

		lblContactNumRespondent
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 6).toString());

		String civilStatusInfoRespondent = "";
		int indexCivilStatusRespondent = Integer.parseInt(
				MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 9).toString());
		if (indexCivilStatusRespondent == 0) {
			civilStatusInfoRespondent = "Single";
		} else if (indexCivilStatusRespondent == 1) {
			civilStatusInfoRespondent = "Married";
		} else {
			civilStatusInfoRespondent = "Widowed";
		}

		lblCivilStatusRespondent.setText(civilStatusInfoRespondent);

		txtAIncidentReports.setText("Complainant: \n     "
				+ MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexComplainantTable, 8)
				+ "\nRespondent: \n     "
				+ MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRespondentTable, 8));
		lblStatus.setText("Solved");
		lblAccusation
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 3).toString());
		lblViolation
				.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 4).toString());
	}
}
