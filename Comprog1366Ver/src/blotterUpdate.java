
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

public class blotterUpdate extends JDialog {

	private JPanel contentPane;

	public static JTextField txtRespondentFirstName;
	public static JTextField txtRespondentMiddleName;
	public static JTextField txtRespondentLastName;
	public static JTextField txtRespondentAge;
	public static JTextField txtRespondentContactNum;
	public static JTextField txtAccusation;
	private JTextField txtViolation;

	public static JTextArea txtAIncidentReport;
	public static JTextArea txtARespondentAdress;
	private JScrollPane scrollPaneAdressComplainant;
	private JScrollPane scrollPaneIncidentReport;
	public static JComboBox cboCompalinantCivilStatus;

	public static ButtonGroup groupSex;
	public static JRadioButton rdoMale;
	public static JRadioButton rdoFemale;

	public static JButton btnSave;
	public static JButton btnCancel;

	public static int caseNumCounter = 1;

	public static String[] finalInputsRespondent = new String[12];

	public blotterUpdate() {
		setUndecorated(true);
		setResizable(false);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		groupSex = new ButtonGroup();
//========================================================================= creating text fields, text area, combo box and radio buttons
		txtRespondentFirstName = new JTextField();
		txtRespondentFirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentFirstName.setOpaque(false);
		txtRespondentFirstName.setForeground(Color.WHITE);
		txtRespondentFirstName.setBounds(26, 55, 96, 20);
		contentPane.add(txtRespondentFirstName);
		txtRespondentFirstName.setColumns(10);

		txtRespondentMiddleName = new JTextField();
		txtRespondentMiddleName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentMiddleName.setOpaque(false);
		txtRespondentMiddleName.setForeground(Color.WHITE);
		txtRespondentMiddleName.setColumns(10);
		txtRespondentMiddleName.setBounds(155, 55, 96, 20);
		contentPane.add(txtRespondentMiddleName);

		txtRespondentLastName = new JTextField();
		txtRespondentLastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentLastName.setOpaque(false);
		txtRespondentLastName.setForeground(Color.WHITE);
		txtRespondentLastName.setColumns(10);
		txtRespondentLastName.setBounds(284, 55, 96, 20);
		contentPane.add(txtRespondentLastName);

		txtRespondentAge = new JTextField();
		txtRespondentAge.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentAge.setOpaque(false);
		txtRespondentAge.setForeground(Color.WHITE);
		txtRespondentAge.setColumns(10);
		txtRespondentAge.setBounds(100, 88, 96, 20);
		contentPane.add(txtRespondentAge);

		txtRespondentContactNum = new JTextField();
		txtRespondentContactNum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtRespondentContactNum.setOpaque(false);
		txtRespondentContactNum.setForeground(Color.WHITE);
		txtRespondentContactNum.setColumns(10);
		txtRespondentContactNum.setBounds(100, 223, 96, 20);
		contentPane.add(txtRespondentContactNum);

		txtAccusation = new JTextField();
		txtAccusation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtAccusation.setOpaque(false);
		txtAccusation.setForeground(Color.WHITE);
		txtAccusation.setColumns(10);
		txtAccusation.setBounds(100, 253, 96, 20);
		contentPane.add(txtAccusation);

		txtViolation = new JTextField();
		txtViolation.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtViolation.setOpaque(false);
		txtViolation.setForeground(Color.WHITE);
		txtViolation.setColumns(10);
		txtViolation.setBounds(303, 253, 96, 20);
		contentPane.add(txtViolation);

		scrollPaneAdressComplainant = new JScrollPane();
		scrollPaneAdressComplainant.getViewport().setOpaque(false);
		scrollPaneAdressComplainant.setBounds(100, 146, 284, 56);
		contentPane.add(scrollPaneAdressComplainant);

		txtARespondentAdress = new JTextArea();
		txtARespondentAdress.setOpaque(false);
		txtARespondentAdress.setForeground(Color.WHITE);
		scrollPaneAdressComplainant.setViewportView(txtARespondentAdress);
		txtARespondentAdress.setLineWrap(true);

		scrollPaneIncidentReport = new JScrollPane();
		scrollPaneIncidentReport.getViewport().setOpaque(false);
		scrollPaneIncidentReport.setBounds(30, 303, 369, 99);
		contentPane.add(scrollPaneIncidentReport);

		txtAIncidentReport = new JTextArea();
		txtAIncidentReport.setOpaque(false);
		txtAIncidentReport.setForeground(Color.WHITE);
		txtAIncidentReport.setLineWrap(true);
		scrollPaneIncidentReport.setViewportView(txtAIncidentReport);

		String[] cboItems = { "Single", "Married", "Widowed" };
		cboCompalinantCivilStatus = new JComboBox(cboItems);
		cboCompalinantCivilStatus.setRequestFocusEnabled(false);
		cboCompalinantCivilStatus.setSelectedIndex(-1);
		cboCompalinantCivilStatus.setBounds(100, 116, 96, 21);
		contentPane.add(cboCompalinantCivilStatus);

		rdoMale = new JRadioButton("Male");
		rdoMale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoMale.setOpaque(false);
		rdoMale.setForeground(Color.WHITE);
		rdoMale.setFocusable(false);
		rdoMale.setBounds(251, 110, 67, 21);
		contentPane.add(rdoMale);
		groupSex.add(rdoMale);

		rdoFemale = new JRadioButton("Female");
		rdoFemale.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdoFemale.setOpaque(false);
		rdoFemale.setForeground(Color.WHITE);
		rdoFemale.setFocusable(false);
		rdoFemale.setBounds(317, 110, 67, 21);
		contentPane.add(rdoFemale);
		groupSex.add(rdoFemale);
//=============================================================================  creating Labels 
		JLabel lblRespondentInfo = new JLabel("RESPONDENT'S INFORMATION");
		lblRespondentInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRespondentInfo.setForeground(Color.WHITE);
		lblRespondentInfo.setBounds(26, 11, 248, 13);
		contentPane.add(lblRespondentInfo);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(26, 34, 86, 13);
		contentPane.add(lblFirstName);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setBounds(155, 34, 86, 13);
		contentPane.add(lblMiddleName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(284, 33, 86, 13);
		contentPane.add(lblLastName);

		JLabel lblAge = new JLabel("Age: ");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(26, 93, 86, 13);
		contentPane.add(lblAge);

		JLabel lblCivilStatus = new JLabel("Civil Status:");
		lblCivilStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCivilStatus.setForeground(Color.WHITE);
		lblCivilStatus.setBounds(26, 122, 86, 13);
		contentPane.add(lblCivilStatus);

		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContact.setForeground(Color.WHITE);
		lblContact.setBounds(26, 227, 86, 13);
		contentPane.add(lblContact);

		JLabel lblAdress = new JLabel("Address:");
		lblAdress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setBounds(26, 154, 86, 13);
		contentPane.add(lblAdress);

		JLabel lblAccusation = new JLabel("Accusation:");
		lblAccusation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAccusation.setForeground(Color.WHITE);
		lblAccusation.setBounds(26, 256, 86, 13);
		contentPane.add(lblAccusation);

		JLabel lblFullIncidentReport = new JLabel("Full Incident Report:");
		lblFullIncidentReport.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFullIncidentReport.setForeground(Color.WHITE);
		lblFullIncidentReport.setBounds(26, 280, 133, 13);
		contentPane.add(lblFullIncidentReport);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setForeground(Color.WHITE);
		lblSex.setHorizontalAlignment(SwingConstants.CENTER);
		lblSex.setBounds(265, 91, 86, 13);
		contentPane.add(lblSex);

		JLabel lblViolation = new JLabel("Violation:");
		lblViolation.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblViolation.setForeground(Color.WHITE);
		lblViolation.setBounds(229, 256, 86, 13);
		contentPane.add(lblViolation);

		// =================================================================================
		// user clicks save button
		btnSave = new JButton("Save");
		btnSave.setBackground(Color.decode(MainTabBMS.blue));
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checker = validChecker();
				if (checker == true) {
					if (MainTabBMS.updateBlotter == true) {
						rowData();
						JOptionPane.showMessageDialog(contentPane, "Blotter Updated Successfully!");
						MainTabBMS.lblOngoingCases2.setText(String.valueOf(MainTabBMS.modelOngoingRecords.getRowCount()));

						int solveCounterCount = 0;
						
						for(int index = 0; index < MainTabBMS.modelBlotterRecords.getRowCount(); index++) {
							String determineSolveString = MainTabBMS.modelBlotterRecords.getValueAt(index, 9).toString();
							if (determineSolveString.equals("Solved")) {
								solveCounterCount++;
							}
						}
						MainTabBMS.lblSolvedCases.setText(String.valueOf(solveCounterCount));
						MainTabBMS.lblOverallCases.setText(String.valueOf(MainTabBMS.modelBlotterRecords.getRowCount()));
					}
				}
			}
		});
		btnSave.setFocusable(false);
		btnSave.setBounds(219, 412, 85, 21);
		contentPane.add(btnSave);
		// ======================================================================== user
		// clicks cancel button
		btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.decode(MainTabBMS.blue));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				blotterUpdate.this.dispose();
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBounds(314, 412, 85, 21);
		contentPane.add(btnCancel);

		JLabel lblBGRespondentInfo = new JLabel("");
		lblBGRespondentInfo.setIcon(new ImageIcon(blotterUpdate.class.getResource("/Images/BGLightBlueGreen.png")));
		lblBGRespondentInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGRespondentInfo.setBounds(0, 0, 420, 450);
		contentPane.add(lblBGRespondentInfo);

		blotterUpdate.this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				clear();
			}
		});

		setLocationRelativeTo(null);
	}

	public boolean validChecker() { // checks if the inputs are valid
		boolean valid = true;
		JTextField[] userInputsAlphaNum = { txtRespondentFirstName, txtRespondentMiddleName, txtRespondentLastName,
				txtAccusation, txtViolation, txtRespondentAge, txtRespondentContactNum, };
		JTextArea[] userInputsSentence = { txtARespondentAdress, txtAIncidentReport };

		for (int index = 0; index < userInputsAlphaNum.length; index++) {
			if (index < 5) { // if  null
				if (userInputsAlphaNum[index].getText().equals("")) {
					JOptionPane.showMessageDialog(contentPane, "Incomplete Information!");
					userInputsAlphaNum[index].requestFocus();
					valid = false;
					break;
				}
			}
			if (index >= 5) {
				try {
					if (index == 5) {
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

					if (index == 6) { // if not 11 digits and not starts with 09
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
				if (index == 1) { // if null
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

		if (cboCompalinantCivilStatus.getSelectedIndex() == -1) { // if null
			JOptionPane.showMessageDialog(contentPane, "No selected Civil Status!");
			cboCompalinantCivilStatus.requestFocus();
			valid = false;
		}

		if (groupSex.isSelected(null)) { // if null
			JOptionPane.showMessageDialog(contentPane, "No selected Sex!");
			valid = false;
		}

		return valid;
	}

	public void clear() { // clear all the fields and inputs
		txtRespondentFirstName.setText("");
		txtRespondentMiddleName.setText("");
		txtRespondentLastName.setText("");
		txtRespondentAge.setText("");
		txtRespondentContactNum.setText("");

		txtAccusation.setText("");
		txtViolation.setText("");

		txtARespondentAdress.setText("");
		txtAIncidentReport.setText("");

		cboCompalinantCivilStatus.setSelectedIndex(-1);

		MainTabBMS.updateBlotter = false;
	}

	public void rowData() { // storing the data in blotter records table, ongoing records table, respondent data table

		int selectedIndexRowFinal = 0;
		int selectedRow = MainTabBMS.tblOngoingRecords.getSelectedRow();
		String caseNum = MainTabBMS.tblOngoingRecords.getValueAt(selectedRow, 0).toString();
		for (int index = 0; index < MainTabBMS.tblStoredDataComplainant.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblStoredDataComplainant.getValueAt(index, 0).toString();
			if (caseNum == caseNumCompare) {
				selectedIndexRowFinal = index;
			}
		}
		;

		String selectedSex = "";
		int determineIndexSex = 0;
		JRadioButton[] sexArray = { rdoMale, rdoFemale };
		for (int index = 0; index < sexArray.length; index++) {
			if (sexArray[index].isSelected()) {
				selectedSex = sexArray[index].getText();
				determineIndexSex = index;
			}
		}
		;

		int selectedSexIndex = Integer
				.parseInt(MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 10).toString());
		sexArray[selectedSexIndex].setSelected(true);
		String selectedSexNew = "";
		for (int index = 0; index < sexArray.length; index++) {
			if (sexArray[index].isSelected()) {
				selectedSexNew = sexArray[index].getText();
				break;
			}
		}
		;
//============================= storing data in blotter records and respondent data table
		DateTimeFormatter timeAndDate = DateTimeFormatter.ofPattern("MM/dd/yyyy   HH:mm");
		LocalDateTime timeChecker = LocalDateTime.now();

		String[] DataBlotterRecords = new String[10];
		DataBlotterRecords[0] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 0).toString();
		DataBlotterRecords[1] = timeAndDate.format(timeChecker);
		DataBlotterRecords[2] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 1).toString()
				+ " " + MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 2).toString() + " "
				+ MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 3).toString();
		DataBlotterRecords[3] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 7).toString();
		DataBlotterRecords[4] = selectedSexNew;
		DataBlotterRecords[5] = txtRespondentFirstName.getText() + " " + txtRespondentMiddleName.getText() + " "
				+ txtRespondentLastName.getText();
		DataBlotterRecords[6] = txtARespondentAdress.getText();
		DataBlotterRecords[7] = selectedSex;
		DataBlotterRecords[8] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 4).toString();
		DataBlotterRecords[9] = "Solved";

		JTextField[] userInputsAlphaNum = { txtRespondentFirstName, txtRespondentMiddleName, txtRespondentLastName,
				txtAccusation, txtViolation, txtRespondentAge, txtRespondentContactNum };
		JTextArea[] userInputsSentence = { txtARespondentAdress, txtAIncidentReport };
		for (int index = 0; index < 7; index++) { // storing data from text fields
			finalInputsRespondent[index] = userInputsAlphaNum[index].getText();
		}
		for (int index = 0; index < 2; index++) { // storing data from text area
			finalInputsRespondent[index + 7] = userInputsSentence[index].getText();
		}

		finalInputsRespondent[9] = Integer.toString(cboCompalinantCivilStatus.getSelectedIndex()); // storing data from
																									// combo box
		finalInputsRespondent[10] = Integer.toString(determineIndexSex); // storing data from radio button group
		finalInputsRespondent[11] = MainTabBMS.tblStoredDataComplainant.getValueAt(selectedIndexRowFinal, 0).toString();

		MainTabBMS.modelDataStoredRespondent.addRow(finalInputsRespondent);
		
		for (int index = 0; index < MainTabBMS.tblBlotterRecords.getRowCount(); index++) {
			String caseNumCompare = MainTabBMS.tblBlotterRecords.getValueAt(index, 0).toString();
			if (caseNum == caseNumCompare) {
				MainTabBMS.modelBlotterRecords.removeRow(index);
				break;
			}
		}
		;

		MainTabBMS.modelBlotterRecords.addRow(DataBlotterRecords);
		// remove the selected row in ongoing records table
		MainTabBMS.modelOngoingRecords.removeRow(selectedRow);
		blotterUpdate.this.dispose();
		clear();
	}
}
