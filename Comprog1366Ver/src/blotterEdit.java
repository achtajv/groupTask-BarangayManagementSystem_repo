
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class blotterEdit extends JDialog {

	private JPanel contentPane;
	public static JTextField txtComplainantFirstName;
	public static JTextField txtComplainantMiddleName;
	public static JTextField txtCompalainantLastName;
	public static JTextField txtComplainantAge;
	public static JTextField txtComplainantContactNum;
	public static JTextField txtRespondentContactNum;
	public static JTextField txtRespondentAge;
	public static JTextField txtRespondentFirstName;
	public static JTextField txtRespondentMiddleName;
	public static JTextField txtRespondentLastName;
	public static JTextArea txtAComplainantIncidentReport;
	public static JTextArea txtAComplainantAdress;
	public static JTextArea txtARespondentAdress;
	private JScrollPane scrollPaneAdressComplainant;
	private JScrollPane scrollPaneAdressRespondent;
	private JScrollPane scrollPaneComplainantIncidentReport;
	private JScrollPane scrollPaneRespondentIncidentReport;
	public static JTextField txtIncident;
	public static JTextField txtViolation;
	public static JTextField txtAccusation;

	public static JButton btnSave;
	public static JButton btnCancel;

	private JComboBox cboCompalinantCivilStatus;
	private JComboBox cboRespondentCivilStatus;

	private JRadioButton rdoComplainantMale;
	private JRadioButton rdoComplainantFemale;
	private JRadioButton rdoRespondentMale;
	private JRadioButton rdoRespondentFemale;
	public static ButtonGroup groupSexComplainant = new ButtonGroup();
	public static ButtonGroup groupSexRespondentt = new ButtonGroup();

	private JTextArea txtARespondentIncidentReport;
	private JLabel lblBGBlotterEdit;

	public blotterEdit() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

// =============================================================================   making Text Fields for user inputs

		txtComplainantFirstName = new JTextField();
		txtComplainantFirstName.setOpaque(false);
		txtComplainantFirstName.setForeground(Color.WHITE);
		txtComplainantFirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantFirstName.setBounds(26, 55, 96, 20);
		contentPane.add(txtComplainantFirstName);
		txtComplainantFirstName.setColumns(10);

		txtComplainantMiddleName = new JTextField();
		txtComplainantMiddleName.setOpaque(false);
		txtComplainantMiddleName.setForeground(Color.WHITE);
		txtComplainantMiddleName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantMiddleName.setColumns(10);
		txtComplainantMiddleName.setBounds(155, 55, 96, 20);
		contentPane.add(txtComplainantMiddleName);

		txtCompalainantLastName = new JTextField();
		txtCompalainantLastName.setOpaque(false);
		txtCompalainantLastName.setForeground(Color.WHITE);
		txtCompalainantLastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtCompalainantLastName.setColumns(10);
		txtCompalainantLastName.setBounds(284, 55, 96, 20);
		contentPane.add(txtCompalainantLastName);

		txtComplainantAge = new JTextField();
		txtComplainantAge.setOpaque(false);
		txtComplainantAge.setForeground(Color.WHITE);
		txtComplainantAge.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantAge.setColumns(10);
		txtComplainantAge.setBounds(100, 88, 96, 20);
		contentPane.add(txtComplainantAge);

		txtComplainantContactNum = new JTextField();
		txtComplainantContactNum.setOpaque(false);
		txtComplainantContactNum.setForeground(Color.WHITE);
		txtComplainantContactNum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantContactNum.setColumns(10);
		txtComplainantContactNum.setBounds(100, 223, 96, 20);
		contentPane.add(txtComplainantContactNum);

		txtRespondentFirstName = new JTextField();
		txtRespondentFirstName.setOpaque(false);
		txtRespondentFirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentFirstName.setForeground(Color.WHITE);
		txtRespondentFirstName.setColumns(10);
		txtRespondentFirstName.setBounds(450, 55, 96, 20);
		contentPane.add(txtRespondentFirstName);

		txtRespondentMiddleName = new JTextField();
		txtRespondentMiddleName.setOpaque(false);
		txtRespondentMiddleName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentMiddleName.setForeground(Color.WHITE);
		txtRespondentMiddleName.setColumns(10);
		txtRespondentMiddleName.setBounds(579, 55, 96, 20);
		contentPane.add(txtRespondentMiddleName);

		txtRespondentLastName = new JTextField();
		txtRespondentLastName.setOpaque(false);
		txtRespondentLastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentLastName.setForeground(Color.WHITE);
		txtRespondentLastName.setColumns(10);
		txtRespondentLastName.setBounds(708, 55, 96, 20);
		contentPane.add(txtRespondentLastName);

		txtRespondentAge = new JTextField();
		txtRespondentAge.setOpaque(false);
		txtRespondentAge.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentAge.setForeground(Color.WHITE);
		txtRespondentAge.setColumns(10);
		txtRespondentAge.setBounds(525, 88, 96, 20);
		contentPane.add(txtRespondentAge);

		txtRespondentContactNum = new JTextField();
		txtRespondentContactNum.setOpaque(false);
		txtRespondentContactNum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentContactNum.setForeground(Color.WHITE);
		txtRespondentContactNum.setColumns(10);
		txtRespondentContactNum.setBounds(525, 223, 96, 20);
		contentPane.add(txtRespondentContactNum);

		txtIncident = new JTextField();
		txtIncident.setOpaque(false);
		txtIncident.setForeground(Color.WHITE);
		txtIncident.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtIncident.setColumns(10);
		txtIncident.setBounds(100, 253, 96, 20);
		contentPane.add(txtIncident);

		txtAccusation = new JTextField();
		txtAccusation.setOpaque(false);
		txtAccusation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtAccusation.setForeground(Color.WHITE);
		txtAccusation.setColumns(10);
		txtAccusation.setBounds(525, 252, 96, 20);
		contentPane.add(txtAccusation);

		txtViolation = new JTextField();
		txtViolation.setOpaque(false);
		txtViolation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtViolation.setForeground(Color.WHITE);
		txtViolation.setColumns(10);
		txtViolation.setBounds(712, 253, 96, 20);
		contentPane.add(txtViolation);

		scrollPaneAdressComplainant = new JScrollPane();
		scrollPaneAdressComplainant.getViewport().setOpaque(false);
		scrollPaneAdressComplainant.setBounds(100, 146, 284, 56);
		contentPane.add(scrollPaneAdressComplainant);

		txtAComplainantAdress = new JTextArea();
		txtAComplainantAdress.setOpaque(false);
		txtAComplainantAdress.setForeground(Color.WHITE);
		scrollPaneAdressComplainant.setViewportView(txtAComplainantAdress);
		txtAComplainantAdress.setLineWrap(true);

		scrollPaneAdressRespondent = new JScrollPane();
		scrollPaneAdressRespondent.getViewport().setOpaque(false);
		scrollPaneAdressRespondent.setBounds(525, 146, 283, 56);
		contentPane.add(scrollPaneAdressRespondent);

		txtARespondentAdress = new JTextArea();
		txtARespondentAdress.setOpaque(false);
		txtARespondentAdress.setForeground(Color.WHITE);
		txtARespondentAdress.setLineWrap(true);
		scrollPaneAdressRespondent.setViewportView(txtARespondentAdress);

		scrollPaneComplainantIncidentReport = new JScrollPane();
		scrollPaneComplainantIncidentReport.getViewport().setOpaque(false);
		scrollPaneComplainantIncidentReport.setBounds(30, 303, 354, 99);
		contentPane.add(scrollPaneComplainantIncidentReport);

		txtAComplainantIncidentReport = new JTextArea();
		txtAComplainantIncidentReport.setOpaque(false);
		txtAComplainantIncidentReport.setForeground(Color.WHITE);
		txtAComplainantIncidentReport.setLineWrap(true);
		scrollPaneComplainantIncidentReport.setViewportView(txtAComplainantIncidentReport);

		scrollPaneRespondentIncidentReport = new JScrollPane();
		scrollPaneRespondentIncidentReport.getViewport().setOpaque(false);
		scrollPaneRespondentIncidentReport.setBounds(454, 303, 354, 99);
		contentPane.add(scrollPaneRespondentIncidentReport);

		txtARespondentIncidentReport = new JTextArea();
		txtARespondentIncidentReport.setOpaque(false);
		txtARespondentIncidentReport.setForeground(Color.WHITE);
		txtARespondentIncidentReport.setText("Complainant's Report: <dynamic>");
		txtARespondentIncidentReport.setLineWrap(true);
		scrollPaneRespondentIncidentReport.setViewportView(txtARespondentIncidentReport);

		String[] cboItems = { "Single", "Married", "Widowed" };
		cboCompalinantCivilStatus = new JComboBox(cboItems);
		cboCompalinantCivilStatus.setRequestFocusEnabled(false);
		cboCompalinantCivilStatus.setSelectedIndex(-1);
		cboCompalinantCivilStatus.setBounds(100, 116, 96, 21);
		contentPane.add(cboCompalinantCivilStatus);

		cboRespondentCivilStatus = new JComboBox(cboItems);
		cboRespondentCivilStatus.setRequestFocusEnabled(false);
		cboRespondentCivilStatus.setSelectedIndex(-1);
		cboRespondentCivilStatus.setBounds(525, 118, 96, 21);
		contentPane.add(cboRespondentCivilStatus);

		rdoComplainantMale = new JRadioButton("Male");
		rdoComplainantMale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoComplainantMale.setForeground(Color.WHITE);
		rdoComplainantMale.setOpaque(false);
		rdoComplainantMale.setFocusable(false);
		rdoComplainantMale.setBounds(246, 104, 63, 21);
		contentPane.add(rdoComplainantMale);
		groupSexComplainant.add(rdoComplainantMale);

		rdoComplainantFemale = new JRadioButton("Female");
		rdoComplainantFemale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoComplainantFemale.setForeground(Color.WHITE);
		rdoComplainantFemale.setOpaque(false);
		rdoComplainantFemale.setFocusable(false);
		rdoComplainantFemale.setBounds(309, 104, 71, 21);
		contentPane.add(rdoComplainantFemale);
		groupSexComplainant.add(rdoComplainantFemale);

		rdoRespondentMale = new JRadioButton("Male");
		rdoRespondentMale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoRespondentMale.setOpaque(false);
		rdoRespondentMale.setForeground(Color.WHITE);
		rdoRespondentMale.setFocusable(false);
		rdoRespondentMale.setBounds(670, 107, 63, 21);
		contentPane.add(rdoRespondentMale);
		groupSexRespondentt.add(rdoRespondentMale);

		rdoRespondentFemale = new JRadioButton("Female");
		rdoRespondentFemale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoRespondentFemale.setOpaque(false);
		rdoRespondentFemale.setForeground(Color.WHITE);
		rdoRespondentFemale.setFocusable(false);
		rdoRespondentFemale.setBounds(733, 107, 71, 21);
		contentPane.add(rdoRespondentFemale);
		groupSexRespondentt.add(rdoRespondentFemale);

// ============================================================================ making Labels for each text fields
		JLabel lblComplainantsName = new JLabel("COMPLAINANT'S NAME");
		lblComplainantsName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplainantsName.setForeground(Color.WHITE);
		lblComplainantsName.setBounds(26, 10, 145, 13);
		contentPane.add(lblComplainantsName);

		JLabel lblRespondentsName = new JLabel("RESPONDENT'S NAME");
		lblRespondentsName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRespondentsName.setForeground(Color.WHITE);
		lblRespondentsName.setBounds(450, 10, 145, 13);
		contentPane.add(lblRespondentsName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(26, 33, 86, 13);
		contentPane.add(lblFirstName);

		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName_1.setForeground(Color.WHITE);
		lblFirstName_1.setBounds(450, 33, 86, 13);
		contentPane.add(lblFirstName_1);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setBounds(155, 33, 86, 13);
		contentPane.add(lblMiddleName);

		JLabel lblMiddleName_1 = new JLabel("Middle Name");
		lblMiddleName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMiddleName_1.setForeground(Color.WHITE);
		lblMiddleName_1.setBounds(579, 33, 86, 13);
		contentPane.add(lblMiddleName_1);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(284, 33, 86, 13);
		contentPane.add(lblLastName);

		JLabel lblLastName_1 = new JLabel("Last Name");
		lblLastName_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName_1.setForeground(Color.WHITE);
		lblLastName_1.setBounds(708, 33, 86, 13);
		contentPane.add(lblLastName_1);

		JLabel lblAge_1 = new JLabel("Age:");
		lblAge_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge_1.setForeground(Color.WHITE);
		lblAge_1.setBounds(450, 89, 86, 13);
		contentPane.add(lblAge_1);

		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(26, 92, 86, 13);
		contentPane.add(lblAge);

		JLabel lblCivilStatus = new JLabel("Civil Status:");
		lblCivilStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCivilStatus.setForeground(Color.WHITE);
		lblCivilStatus.setBounds(26, 121, 86, 13);
		contentPane.add(lblCivilStatus);

		JLabel lblCivilStatus_1 = new JLabel("Civil Status:");
		lblCivilStatus_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCivilStatus_1.setForeground(Color.WHITE);
		lblCivilStatus_1.setBounds(450, 121, 86, 13);
		contentPane.add(lblCivilStatus_1);

		JLabel lblAdress_1 = new JLabel("Address:");
		lblAdress_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdress_1.setForeground(Color.WHITE);
		lblAdress_1.setBounds(450, 153, 86, 13);
		contentPane.add(lblAdress_1);

		JLabel lblContact_1 = new JLabel("Contact #: ");
		lblContact_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContact_1.setForeground(Color.WHITE);
		lblContact_1.setBounds(450, 227, 86, 13);
		contentPane.add(lblContact_1);

		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContact.setForeground(Color.WHITE);
		lblContact.setBounds(26, 227, 86, 13);
		contentPane.add(lblContact);

		JLabel lblAdress = new JLabel("Address:");
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setBounds(26, 153, 86, 13);
		contentPane.add(lblAdress);

		JLabel lblComplainantFullIncidentReport = new JLabel("Complainant's Full Incident Report:");
		lblComplainantFullIncidentReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplainantFullIncidentReport.setForeground(Color.WHITE);
		lblComplainantFullIncidentReport.setBounds(26, 280, 225, 13);
		contentPane.add(lblComplainantFullIncidentReport);

		JLabel lblIncident = new JLabel("Incident:");
		lblIncident.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIncident.setForeground(Color.WHITE);
		lblIncident.setBounds(26, 256, 86, 13);
		contentPane.add(lblIncident);

		JLabel lblAccusation = new JLabel("Accusation");
		lblAccusation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAccusation.setForeground(Color.WHITE);
		lblAccusation.setBounds(450, 256, 86, 13);
		contentPane.add(lblAccusation);

		JLabel lblViolation = new JLabel("Violation:");
		lblViolation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblViolation.setForeground(Color.WHITE);
		lblViolation.setBounds(647, 256, 86, 14);
		contentPane.add(lblViolation);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setForeground(Color.WHITE);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setBounds(280, 85, 45, 13);
		contentPane.add(lblSex);

		JLabel lblSex_1 = new JLabel("Sex");
		lblSex_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex_1.setForeground(Color.WHITE);
		lblSex_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex_1.setBounds(704, 88, 45, 13);
		contentPane.add(lblSex_1);

		JLabel lblRespondentFullIncidentReport = new JLabel("Respondent's Full Incident Report:");
		lblRespondentFullIncidentReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRespondentFullIncidentReport.setForeground(Color.WHITE);
		lblRespondentFullIncidentReport.setBounds(450, 280, 225, 13);
		contentPane.add(lblRespondentFullIncidentReport);

		blotterEdit.this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				clear();
			}
		});

		gettingData();
		//======================= SAVE BUTTON ============================
		btnSave = new JButton("Save");
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBackground(Color.decode(MainTabBMS.blue));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//gets the selected row index
				int selectedIndexRespondentTable = -1;
				int selectedRow = MainTabBMS.tblBlotterRecords.getSelectedRow();
				String caseNum = MainTabBMS.tblBlotterRecords.getValueAt(selectedRow, 0).toString();
				for (int index = 0; index < MainTabBMS.tblStoredDataRespondent.getRowCount(); index++) {
					String caseNumCompare = MainTabBMS.tblStoredDataRespondent.getValueAt(index, 11).toString();
					if (caseNum == caseNumCompare) {
						selectedIndexRespondentTable = index;
						break;
					}
				}
				
				//if there is a selected index, this will execute
				if (selectedIndexRespondentTable > -1) {
					boolean valid = validChecker();
					if (valid == true) {
						int choice = JOptionPane.showConfirmDialog(contentPane,
								"Are you sure you want the changes to be saved?", "Confirmation",
								JOptionPane.YES_NO_OPTION);
						if (choice == 0) {
							int selectedIndexComplainantTable = -1;
							for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
								String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0)
										.toString();
								if (caseNum == caseNumCompare) {
									selectedIndexComplainantTable = index;
									break;
								}
							}
							;
							//for identifying the compliant's sex
							JRadioButton[] sexArrayComplainant = { rdoComplainantMale, rdoComplainantFemale };
							String selectedSexComplainant = "";
							int determineIndexSexComplainant = 0;
							for (int index = 0; index < sexArrayComplainant.length; index++) {
								if (sexArrayComplainant[index].isSelected()) {
									selectedSexComplainant = sexArrayComplainant[index].getText();
									determineIndexSexComplainant = index;
									break;
								}
							}
							;
							
							//for identifying the respondent's sex
							JRadioButton[] sexArrayRespondent = { rdoRespondentMale, rdoRespondentFemale };
							String selectedSexRespondent = "";
							int determineIndexSexRespondent = 0;
							for (int index = 0; index < sexArrayRespondent.length; index++) {
								if (sexArrayRespondent[index].isSelected()) {
									selectedSexRespondent = sexArrayRespondent[index].getText();
									determineIndexSexRespondent = index;
									break;
								}
							}
							;

							DateTimeFormatter timeAndDate = DateTimeFormatter.ofPattern("MM/dd/yyyy   HH:mm");
							LocalDateTime timeChecker = LocalDateTime.now();
							
							//Stores the right information in the right columns on the tablemodel for blotter records
							String[] DataBlotterRecords = new String[10];
							DataBlotterRecords[0] = MainTabBMS.tblStoredDataComplainant
									.getValueAt(selectedIndexComplainantTable, 0).toString();
							DataBlotterRecords[1] = timeAndDate.format(timeChecker);
							DataBlotterRecords[2] = txtComplainantFirstName.getText() + " "
									+ txtComplainantMiddleName.getText() + " " + txtCompalainantLastName.getText();
							DataBlotterRecords[3] = txtAComplainantAdress.getText();
							DataBlotterRecords[4] = selectedSexComplainant;
							DataBlotterRecords[5] = txtRespondentFirstName.getText() + " "
									+ txtRespondentMiddleName.getText() + " " + txtRespondentLastName.getText();
							DataBlotterRecords[6] = txtARespondentAdress.getText();
							DataBlotterRecords[7] = selectedSexRespondent;
							DataBlotterRecords[8] = txtIncident.getText();
							DataBlotterRecords[9] = "Solved";

							MainTabBMS.sorterBlotter.allRowsChanged();
							MainTabBMS.modelBlotterRecords.removeRow(selectedRow);
							MainTabBMS.modelBlotterRecords.addRow(DataBlotterRecords);

							// for retaining the compliant's information whenever the edit button has been pressed
							String[] complainantData = new String[11];
							JTextField[] userInputsAlphaNumComplainant = { txtComplainantFirstName,
									txtComplainantMiddleName, txtCompalainantLastName, txtIncident, txtComplainantAge,
									txtComplainantContactNum };
							JTextArea[] userInputsSentenceComplainant = { txtAComplainantAdress,
									txtAComplainantIncidentReport };

							complainantData[0] = MainTabBMS.modelDataStoredComplainant
									.getValueAt(selectedIndexComplainantTable, 0).toString();
							for (int index = 0; index < 6; index++) {
								complainantData[index + 1] = userInputsAlphaNumComplainant[index].getText();
							}
							for (int index = 0; index < 2; index++) {
								complainantData[index + 7] = userInputsSentenceComplainant[index].getText();
							}

							complainantData[9] = Integer.toString(cboCompalinantCivilStatus.getSelectedIndex());
							complainantData[10] = Integer.toString(determineIndexSexComplainant);

							MainTabBMS.modelDataStoredComplainant.removeRow(selectedIndexComplainantTable);
							MainTabBMS.modelDataStoredComplainant.addRow(complainantData);

							// for retaining the respondent's information whenever the edit button has been pressed
							String[] respondenttData = new String[12];
							JTextField[] userInputsAlphaNumRespondent = { txtRespondentFirstName,
									txtRespondentMiddleName, txtRespondentLastName, txtAccusation, txtViolation,
									txtRespondentAge, txtRespondentContactNum };
							JTextArea[] userInputsSentenceRespondent = { txtARespondentAdress,
									txtARespondentIncidentReport };
							for (int index = 0; index < 7; index++) {
								respondenttData[index] = userInputsAlphaNumRespondent[index].getText();
							}
							for (int index = 0; index < 2; index++) {
								respondenttData[index + 7] = userInputsSentenceRespondent[index].getText();
							}

							respondenttData[9] = Integer.toString(cboRespondentCivilStatus.getSelectedIndex());
							respondenttData[10] = Integer.toString(determineIndexSexRespondent);
							respondenttData[11] = MainTabBMS.tblStoredDataRespondent
									.getValueAt(selectedIndexRespondentTable, 11).toString();

							MainTabBMS.modelDataStoredRespondent.removeRow(selectedIndexRespondentTable);
							MainTabBMS.modelDataStoredRespondent.addRow(respondenttData);

							blotterEdit.this.dispose();
							JOptionPane.showMessageDialog(contentPane, "Blotter Successfully Edited!");
							clear();
						}
					} else {
						gettingData();
					}
				} else {
					boolean valid = validCheckerComplainantOnly();
					if (valid == true) {
						editRowDataComplainant();
					}
				}

			}
		});
		btnSave.setFocusable(false);
		btnSave.setBounds(625, 412, 85, 21);
		contentPane.add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBackground(Color.decode(MainTabBMS.blue));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				blotterEdit.this.dispose();
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBounds(718, 412, 85, 21);
		contentPane.add(btnCancel);

		lblBGBlotterEdit = new JLabel("");
		lblBGBlotterEdit.setForeground(Color.WHITE);
		lblBGBlotterEdit.setIcon(new ImageIcon(blotterEdit.class.getResource("/Images/BGBlotterEdit.png")));
		lblBGBlotterEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGBlotterEdit.setBounds(0, 0, 837, 441);
		contentPane.add(lblBGBlotterEdit);

		setLocationRelativeTo(null);
	}

	public void gettingData() { //getting the data for both complainant and respondent
		if (MainTabBMS.editBlotter == true) {
			clear();
		}

		// ======================================================================================================
		// setting the texts, radio buttons, combo boxes, and text area
		int selectedIndexComplainantTable = -1;
		int selectedRow = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNum = MainTabBMS.tblBlotterRecords.getValueAt(selectedRow, 0).toString();
		for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexComplainantTable = index;
			}
		}
		;

		// =======================================================================================================
		// for Complainant's info edit
		JTextField[] userInputsAlphaNumComplainant = { txtComplainantFirstName, txtComplainantMiddleName,
				txtCompalainantLastName, txtIncident, txtComplainantAge, txtComplainantContactNum };
		// geting all the values from data table complainant
		for (int index = 0; index < 6; index++) {
			userInputsAlphaNumComplainant[index].setText(MainTabBMS.tblStoredDataComplainant
					.getValueAt(selectedIndexComplainantTable, index + 1).toString());
		}
		txtAComplainantAdress
				.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 7).toString());
		txtAComplainantIncidentReport
				.setText(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 8).toString());

		int selectedIndexCivilStatusC = Integer
				.parseInt(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 9).toString());
		for (int index = 0; index < 2; index++) {
			if (selectedIndexCivilStatusC == index) {
				cboCompalinantCivilStatus.setSelectedIndex(index);
			}
		}

		int selectedIndexSexC = Integer
				.parseInt(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 10).toString());
		if (selectedIndexSexC == 0) {
			rdoComplainantMale.setSelected(true);
		} else if (selectedIndexSexC == 1) {
			rdoComplainantFemale.setSelected(true);
		}

		// =======================================================================================================
		// for Respondent's info edit
		int selectedIndexRespondentTable = -1;
		for (int index = 0; index < MainTabBMS.tblStoredDataRespondent.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataRespondent.getValueAt(index, 11).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexRespondentTable = index;
			}
		}

		if (selectedIndexRespondentTable > -1) { // if there's respondent info
			JTextField[] userInputsAlphaNumRespondent = { txtRespondentFirstName, txtRespondentMiddleName,
					txtRespondentLastName, txtAccusation, txtViolation, txtRespondentAge, txtRespondentContactNum };
			// geting all the values from data table respondent
			for (int index = 0; index < 7; index++) {
				userInputsAlphaNumRespondent[index].setText(
						MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, index).toString());
			}
			txtARespondentAdress
					.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 7).toString());
			txtARespondentIncidentReport
					.setText(MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 8).toString());

			int selectedIndexCivilStatusR = Integer.parseInt(
					MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 9).toString());
			for (int index = 0; index < 2; index++) {
				if (selectedIndexCivilStatusR == index) {
					cboRespondentCivilStatus.setSelectedIndex(index);
				}
			}

			int selectedIndexSexR = Integer.parseInt(
					MainTabBMS.tblStoredDataRespondent.getValueAt(selectedIndexRespondentTable, 10).toString());
			if (selectedIndexSexR == 0) {
				rdoRespondentMale.setSelected(true);
			} else if (selectedIndexSexR == 1) {
				rdoRespondentFemale.setSelected(true);
			}
		} else { // make all the respondent form uneditable
			JTextField[] userInputsAlphaNumRespondent = { txtRespondentFirstName, txtRespondentMiddleName,
					txtRespondentLastName, txtAccusation, txtViolation, txtRespondentAge, txtRespondentContactNum };

			for (int index = 0; index < 7; index++) {
				userInputsAlphaNumRespondent[index].setText("N/A");
				userInputsAlphaNumRespondent[index].setEnabled(false);
			}

			txtARespondentAdress.setEnabled(false);
			txtARespondentIncidentReport.setText("");
			txtARespondentIncidentReport.setEnabled(false);

			cboRespondentCivilStatus.setSelectedIndex(-1);
			cboRespondentCivilStatus.setEnabled(false);

			rdoRespondentMale.setEnabled(false);
			rdoRespondentFemale.setEnabled(false);

			scrollPaneAdressComplainant.setEnabled(false);
			scrollPaneAdressRespondent.setEnabled(false);
			scrollPaneComplainantIncidentReport.setEnabled(false);
			scrollPaneRespondentIncidentReport.setEnabled(false);
		}
	}

	public void clear() { //clear all the fields and inputs
		txtComplainantFirstName.setText("");
		txtComplainantMiddleName.setText("");
		txtCompalainantLastName.setText("");
		txtComplainantAge.setText("");
		txtComplainantContactNum.setText("");

		txtRespondentFirstName.setText("");
		txtRespondentMiddleName.setText("");
		txtRespondentLastName.setText("");
		txtRespondentAge.setText("");
		txtRespondentContactNum.setText("");

		txtIncident.setText("");
		txtAccusation.setText("");
		txtViolation.setText("");

		cboRespondentCivilStatus.setSelectedIndex(-1);

		rdoRespondentMale.setSelected(false);
		rdoRespondentFemale.setSelected(false);

		txtAComplainantAdress.setText("");
		txtARespondentAdress.setText("");
		txtAComplainantIncidentReport.setText("");

		cboCompalinantCivilStatus.setSelectedIndex(-1);
		cboRespondentCivilStatus.setSelectedIndex(-1);

		MainTabBMS.addBlotter = false;
		MainTabBMS.updateBlotter = false;
	}

	public void editRowDataComplainant() {
		int selectedIndexComplainantTable = 0;
		int selectedRow = MainTabBMS.tblBlotterRecords.getSelectedRow();
		String caseNum = MainTabBMS.tblBlotterRecords.getValueAt(selectedRow, 0).toString();
		for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexComplainantTable = index;
				break;
			}
		}
		;

		String selectedSex = "";
		int determineIndexSex = 0;
		JRadioButton[] sexArray = { rdoComplainantMale, rdoComplainantFemale };
		for (int index = 0; index < sexArray.length; index++) {
			if (sexArray[index].isSelected()) {
				selectedSex = sexArray[index].getText();
				determineIndexSex = index;
				break;
			}
		}
		;
		// storing in blotter records
		DateTimeFormatter timeAndDate = DateTimeFormatter.ofPattern("MM/dd/yyyy   HH:mm");
		LocalDateTime timeChecker = LocalDateTime.now();

		String[] DataBlotterRecords = new String[10];
		DataBlotterRecords[0] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexComplainantTable, 0)
				.toString();
		DataBlotterRecords[1] = timeAndDate.format(timeChecker);
		DataBlotterRecords[2] = txtComplainantFirstName.getText() + " " + txtComplainantMiddleName.getText() + " "
				+ txtCompalainantLastName.getText();
		DataBlotterRecords[3] = txtAComplainantAdress.getText();
		DataBlotterRecords[4] = selectedSex;
		DataBlotterRecords[5] = "N/A";
		DataBlotterRecords[6] = "N/A";
		DataBlotterRecords[7] = "N/A";
		DataBlotterRecords[8] = txtIncident.getText();
		DataBlotterRecords[9] = "Ongoing";

		String[] complainantData = new String[11];
		// storing in data table complainant
		JTextField[] userInputsAlphaNum = { txtComplainantFirstName, txtComplainantMiddleName, txtCompalainantLastName,
				txtIncident, txtComplainantAge, txtComplainantContactNum };
		JTextArea[] userInputsSentence = { txtAComplainantAdress, txtAComplainantIncidentReport };

		complainantData[0] = MainTabBMS.modelDataStoredComplainant.getValueAt(selectedIndexComplainantTable, 0)
				.toString();
		for (int index = 0; index < 6; index++) {
			complainantData[index + 1] = userInputsAlphaNum[index].getText();
		}
		for (int index = 0; index < 2; index++) {
			complainantData[index + 7] = userInputsSentence[index].getText();
		}

		complainantData[9] = Integer.toString(cboCompalinantCivilStatus.getSelectedIndex());
		complainantData[10] = Integer.toString(determineIndexSex);

		int choice = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want the changes to be saved?",
				"Confirmation", JOptionPane.YES_NO_OPTION);
		if (choice == 0) { // if yes
			
			MainTabBMS.modelBlotterRecords.removeRow(selectedRow);
			MainTabBMS.sorterBlotter.allRowsChanged();
			MainTabBMS.modelBlotterRecords.addRow(DataBlotterRecords);

			MainTabBMS.modelDataStoredComplainant.removeRow(selectedIndexComplainantTable);
			MainTabBMS.modelDataStoredComplainant.addRow(complainantData);

			blotterEdit.this.dispose();
			JOptionPane.showMessageDialog(contentPane, "Blotter Successfully Edited!");
			clear();
		} else { // get the data back
			gettingData();
		}
	}

	public boolean validChecker() { //checking if all the value for both complainant and respondent is valid
		boolean valid = true;
		JTextField[] userInputsAlphaNum = { txtComplainantFirstName, txtComplainantMiddleName, txtCompalainantLastName,
				txtIncident, txtRespondentFirstName, txtRespondentMiddleName, txtRespondentLastName, txtAccusation,
				txtViolation, txtComplainantAge, txtRespondentAge, txtComplainantContactNum, txtRespondentContactNum };
		JTextArea[] userInputsSentence = { txtAComplainantAdress, txtARespondentAdress, txtAComplainantIncidentReport,
				txtARespondentIncidentReport };

		for (int index = 0; index < userInputsAlphaNum.length; index++) {
			if (index < 9) { // if null
				if (userInputsAlphaNum[index].getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Incomplete Information!");
					userInputsAlphaNum[index].requestFocus();
					valid = false;
					break;
				}
			}
			if (index >= 9) {
				try {
					if (index == 9 || index == 10) {
						int inputNum = Integer.parseInt(userInputsAlphaNum[index].getText());
						if (inputNum > 200 || inputNum < 18) { // if not 18 to 200 years old
							JOptionPane.showMessageDialog(contentPane, "Invalid Age!");
							userInputsAlphaNum[index].requestFocus();
							userInputsAlphaNum[index].selectAll();
							;
							valid = false;
							break;
						}
					}

					if (index == 11 || index == 12) { // if not 11 digits and if not starts with 09
						String inputText = userInputsAlphaNum[index].getText();
						if (inputText.length() > 11 || inputText.length() < 11 || inputText.charAt(0) != '0'
								|| inputText.charAt(1) != '9') {
							JOptionPane.showMessageDialog(contentPane, "Invalid Contact Number!");
							userInputsAlphaNum[index].requestFocus();
							userInputsAlphaNum[index].selectAll();
							;
							valid = false;
							break;
						}
					}
				} catch (Exception e1) { // if not digits
					JOptionPane.showMessageDialog(contentPane, " Invalid Input!");
					userInputsAlphaNum[index].requestFocus();
					userInputsAlphaNum[index].selectAll();
					;
					valid = false;
					break;
				}
			}
		}
		;

		for (int index = 0; index < userInputsSentence.length; index++) {
			if (userInputsSentence[index].getText().equals("")) {
				if (index == 2 || index == 3) { // if null
					JOptionPane.showMessageDialog(contentPane, "Please give the Full Details!");
					valid = false;
					break;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Please put your Information Address!");
					valid = false;
					break;
				}
			}
		}
		return valid;
	}

	public boolean validCheckerComplainantOnly() { // checking if the value is for complainant is valid 
		boolean valid = true;
		JTextField[] userInputsAlphaNum = { txtComplainantFirstName, txtComplainantMiddleName, txtCompalainantLastName,
				txtIncident, txtComplainantAge, txtComplainantContactNum };
		JTextArea[] userInputsSentence = { txtAComplainantAdress, txtAComplainantIncidentReport };

		for (int index = 0; index < userInputsAlphaNum.length; index++) {
			if (index < 4) {
				if (userInputsAlphaNum[index].getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Incomplete Information!");
					userInputsAlphaNum[index].requestFocus();
					valid = false;
					break;
				}
			}
			if (index >= 4) {
				try {
					if (index == 4) {
						int inputNum = Integer.parseInt(userInputsAlphaNum[index].getText());
						if (inputNum > 200 || inputNum < 18) {
							JOptionPane.showMessageDialog(contentPane, "Invalid Age!");
							userInputsAlphaNum[index].requestFocus();
							userInputsAlphaNum[index].selectAll();
							;
							valid = false;
							break;
						}
					}

					if (index == 5) {
						String inputText = userInputsAlphaNum[index].getText();
						if (inputText.length() > 11 || inputText.length() < 11 || inputText.charAt(0) != '0'
								|| inputText.charAt(1) != '9') {
							JOptionPane.showMessageDialog(contentPane, "Invalid Contact Number!");
							userInputsAlphaNum[index].requestFocus();
							userInputsAlphaNum[index].selectAll();
							;
							valid = false;
							break;
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, " Invalid Input!");
					userInputsAlphaNum[index].requestFocus();
					userInputsAlphaNum[index].selectAll();
					;
					valid = false;
					break;
				}
			}
		}
		;

		for (int index = 0; index < userInputsSentence.length; index++) {
			if (userInputsSentence[index].getText().equals("")) {
				if (index == 1) {
					JOptionPane.showMessageDialog(contentPane, "Please give the Full Details!");
					valid = false;
					break;
				} else {
					JOptionPane.showMessageDialog(contentPane, "Please put your Information Address!");
					valid = false;
					break;
				}
			}
		}
		return valid;
	}
}
