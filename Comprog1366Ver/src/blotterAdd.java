
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

public class blotterAdd extends JDialog {

	private JPanel contentPane;

	public static JTextField txtComplainantFirstName;
	public static JTextField txtComplainantMiddleName;
	public static JTextField txtCompalainantLastName;
	public static JTextField txtComplainantAge;
	public static JTextField txtComplainantContactNum;
	public static JTextField txtIncident;

	public static JTextArea txtAIncidentReport;
	public static JTextArea txtAComplainantAdress;
	private JScrollPane scrollPaneAdressComplainant;
	private JScrollPane scrollPaneIncidentReport;
	public static JComboBox cboCompalinantCivilStatus;

	public static ButtonGroup groupSex;
	public static JRadioButton rdoMale;
	public static JRadioButton rdoFemale;

	public static JButton btnSave;
	public static JButton btnCancel;

	public static int caseNumCounter = 6;

	public static String[] finalInputsComplainant = new String[11];

	private String[] DataOngoingRecords = new String[5];
	private JLabel lblBGCompliantsInfo;

	public blotterAdd() {
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
//      =============== creating text fields, text area, combo box and radio buttons =================
		txtComplainantFirstName = new JTextField();
		txtComplainantFirstName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantFirstName.setForeground(Color.WHITE);
		txtComplainantFirstName.setOpaque(false);
		txtComplainantFirstName.setBounds(26, 55, 96, 20);
		contentPane.add(txtComplainantFirstName);
		txtComplainantFirstName.setColumns(10);

		txtComplainantMiddleName = new JTextField();
		txtComplainantMiddleName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantMiddleName.setForeground(Color.WHITE);
		txtComplainantMiddleName.setOpaque(false);
		txtComplainantMiddleName.setColumns(10);
		txtComplainantMiddleName.setBounds(155, 55, 96, 20);
		contentPane.add(txtComplainantMiddleName);

		txtCompalainantLastName = new JTextField();
		txtCompalainantLastName.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtCompalainantLastName.setForeground(Color.WHITE);
		txtCompalainantLastName.setOpaque(false);
		txtCompalainantLastName.setColumns(10);
		txtCompalainantLastName.setBounds(284, 55, 96, 20);
		contentPane.add(txtCompalainantLastName);

		txtComplainantAge = new JTextField();
		txtComplainantAge.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantAge.setForeground(Color.WHITE);
		txtComplainantAge.setOpaque(false);
		txtComplainantAge.setColumns(10);
		txtComplainantAge.setBounds(100, 88, 96, 20);
		contentPane.add(txtComplainantAge);

		txtComplainantContactNum = new JTextField();
		txtComplainantContactNum.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtComplainantContactNum.setForeground(Color.WHITE);
		txtComplainantContactNum.setOpaque(false);
		txtComplainantContactNum.setColumns(10);
		txtComplainantContactNum.setBounds(100, 223, 96, 20);
		contentPane.add(txtComplainantContactNum);

		txtIncident = new JTextField();
		txtIncident.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		txtIncident.setForeground(Color.WHITE);
		txtIncident.setOpaque(false);
		txtIncident.setColumns(10);
		txtIncident.setBounds(100, 253, 96, 20);
		contentPane.add(txtIncident);

		scrollPaneAdressComplainant = new JScrollPane();
		scrollPaneAdressComplainant.getViewport().setOpaque(false);
		scrollPaneAdressComplainant.setBounds(100, 146, 284, 56);
		contentPane.add(scrollPaneAdressComplainant);

		txtAComplainantAdress = new JTextArea();
		txtAComplainantAdress.setForeground(Color.WHITE);
		txtAComplainantAdress.setOpaque(false);
		scrollPaneAdressComplainant.setViewportView(txtAComplainantAdress);
		txtAComplainantAdress.setLineWrap(true);

		scrollPaneIncidentReport = new JScrollPane();
		scrollPaneIncidentReport.getViewport().setOpaque(false);
		scrollPaneIncidentReport.setBounds(30, 303, 369, 99);
		contentPane.add(scrollPaneIncidentReport);

		txtAIncidentReport = new JTextArea();
		txtAIncidentReport.setForeground(Color.WHITE);
		txtAIncidentReport.setOpaque(false);
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
//		======================  creating Labels ========================== 
		JLabel lblComplainantsInfo = new JLabel("COMPLAINANT'S INFORMATION");
		lblComplainantsInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblComplainantsInfo.setForeground(Color.WHITE);
		lblComplainantsInfo.setBounds(26, 10, 292, 13);
		contentPane.add(lblComplainantsInfo);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setBounds(26, 33, 86, 13);
		contentPane.add(lblFirstName);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMiddleName.setForeground(Color.WHITE);
		lblMiddleName.setBounds(155, 33, 86, 13);
		contentPane.add(lblMiddleName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(284, 33, 86, 13);
		contentPane.add(lblLastName);

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

		JLabel lblIncident = new JLabel("Incident:");
		lblIncident.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIncident.setForeground(Color.WHITE);
		lblIncident.setBounds(26, 256, 86, 13);
		contentPane.add(lblIncident);

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

		//===============user clicks save button
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.decode(MainTabBMS.green));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checker = validChecker();
				if (checker == true) {
					if (MainTabBMS.addBlotter == true) {
						rowData();
						MainTabBMS.lblRecords.setText("Records: " + MainTabBMS.modelBlotterRecords.getRowCount());
						JOptionPane.showMessageDialog(contentPane, "Blotter Added Successfully!");
						MainTabBMS.lblOverallCases.setText(String.valueOf(MainTabBMS.modelBlotterRecords.getRowCount()));
						MainTabBMS.lblOngoingCases2.setText(String.valueOf(MainTabBMS.modelOngoingRecords.getRowCount()));

					}
				}
			}
		});
		btnSave.setFocusable(false);
		btnSave.setBounds(219, 412, 85, 21);
		contentPane.add(btnSave);

		//============== user clicks cancel button
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(Color.decode(MainTabBMS.green));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
				blotterAdd.this.dispose();
			}
		});
		btnCancel.setFocusable(false);
		btnCancel.setBounds(314, 412, 85, 21);
		contentPane.add(btnCancel);

		lblBGCompliantsInfo = new JLabel("");
		lblBGCompliantsInfo.setIcon(new ImageIcon(blotterAdd.class.getResource("/Images/BGVioletBlue.png")));
		lblBGCompliantsInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGCompliantsInfo.setBounds(0, 0, 420, 450);
		contentPane.add(lblBGCompliantsInfo);

		blotterAdd.this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				clear();
			}
		});

		setLocationRelativeTo(null);
	}

	public boolean validChecker() { // checking if the inputs aare valid
		boolean valid = true;
		JTextField[] userInputsAlphaNum = { txtComplainantFirstName, txtComplainantMiddleName, txtCompalainantLastName,
				txtIncident, txtComplainantAge, txtComplainantContactNum };
		JTextArea[] userInputsSentence = { txtAComplainantAdress, txtAIncidentReport };

		for (int index = 0; index < userInputsAlphaNum.length; index++) { // make a loop for the textFields
			if (index < 4) {
				if (userInputsAlphaNum[index].getText().equals("")) { // if null
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
						if (inputNum > 200 || inputNum < 18) { // if the input are not 18 to 200 years old
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
								|| inputText.charAt(1) != '9') { // must be 11 digits and 0 and 9 in the first 2 indices char
							JOptionPane.showMessageDialog(contentPane, "Invalid Contact Number!");
							userInputsAlphaNum[index].requestFocus();
							userInputsAlphaNum[index].selectAll();
							;
							valid = false;
							break;
						}
					}
				} catch (Exception e1) { // if not number
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
			if (userInputsSentence[index].getText().equals("")) {	// if null
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

	public void clear() { // clear all the text fields
		txtComplainantFirstName.setText("");
		txtComplainantMiddleName.setText("");
		txtCompalainantLastName.setText("");
		txtComplainantAge.setText("");
		txtComplainantContactNum.setText("");

		txtIncident.setText("");

		txtAComplainantAdress.setText("");
		txtAIncidentReport.setText("");

		cboCompalinantCivilStatus.setSelectedIndex(-1);

		MainTabBMS.addBlotter = false;
	}

	public void rowData() { // adding the data in table blotter records, table ongoing records and complainant data table
		DateTimeFormatter timeAndDate = DateTimeFormatter.ofPattern("MM/dd/yyyy   HH:mm");
		LocalDateTime timeChecker = LocalDateTime.now();

		String selectedSex = "";
		int determineIndexSex = 0;
		JRadioButton[] sexArray = { rdoMale, rdoFemale };
		for (int index = 0; index < sexArray.length; index++) {
			if (sexArray[index].isSelected()) {
				selectedSex = sexArray[index].getText();
				determineIndexSex = index;
				break;
			}
		}
		;
//================================= putting data in an array and adding the array in blotter records
		String count = Integer.toString(caseNumCounter++);
		String[] DataBlotterRecords = new String[10];
		DataBlotterRecords[0] = count;
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

		MainTabBMS.modelBlotterRecords.addRow(DataBlotterRecords);
//=================================  putting data in an array and addin the array in ongoing records
		DataOngoingRecords[0] = count;
		DataOngoingRecords[1] = timeAndDate.format(timeChecker);
		DataOngoingRecords[2] = txtComplainantFirstName.getText() + " " + txtComplainantMiddleName.getText() + " "
				+ txtCompalainantLastName.getText();
		DataOngoingRecords[3] = txtIncident.getText();
		DataOngoingRecords[4] = "Barangay Level";
//=================================  putting data in an array and addin the array in data table complainant
		DataOngoingRecords[0] = count;
		MainTabBMS.modelOngoingRecords.addRow(DataOngoingRecords);

		JTextField[] userInputsAlphaNum = { txtComplainantFirstName, txtComplainantMiddleName, txtCompalainantLastName,
				txtIncident, txtComplainantAge, txtComplainantContactNum };
		JTextArea[] userInputsSentence = { txtAComplainantAdress, txtAIncidentReport };

		finalInputsComplainant[0] = count.toString(); // storing case number
		for (int index = 0; index < 6; index++) { // storing data from text fields
			finalInputsComplainant[index + 1] = userInputsAlphaNum[index].getText();
		}
		for (int index = 0; index < 2; index++) { // storing data from text area
			finalInputsComplainant[index + 7] = userInputsSentence[index].getText();
		}

		finalInputsComplainant[9] = Integer.toString(cboCompalinantCivilStatus.getSelectedIndex()); // storing data from
																									// combo box
		finalInputsComplainant[10] = Integer.toString(determineIndexSex); // storing data from radio button group

		MainTabBMS.modelDataStoredComplainant.addRow(finalInputsComplainant);

		blotterAdd.this.dispose();
		clear();
	}
}
