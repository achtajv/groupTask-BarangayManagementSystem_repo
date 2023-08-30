import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.PublicKey;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

public class MainTabBMS extends JFrame {

//	======Color Palette=======
	static String blue = "#1e5192";
	static String green = "#4aba7d";
	static String lightBlue = "#2cbec1";

	private JPanel contentPane;

	public static JTabbedPane tabbedPane;

	private JLabel lblBMS;

	private JTable tblOfficials;

	private JLabel lblTotalPopulation;
	private JLabel lblFemale;
	private JLabel lblRegisteredVoters;
	private JLabel lblMale;

	public static JLabel lblOverallCases;
	public static  JLabel lblSolvedCases;
	public static JLabel lblOngoingCases2;

	
	public static  JLabel lblcasesongoing;
	
	private JButton btnEnter;
	private JLabel lblBGAccountSettings;
	public static JButton btnAddAcc;
	public static JButton btnUpdateAcc;
	public static JButton btnDelete;
	public static JButton btnSetAvatar;
	private JLabel lblAccounts;
	private JScrollPane scrollPaneAccounts;
	private JPanel pnlAccountSettings;
	public static JLabel lblProfile;
	private JLabel lblSummaryRecordBG;
	private JScrollPane scrollPaneBlotterRecords;
	private JScrollPane scrollPaneOngoingRecords;
	private JLabel lblFilterBy;
	private JPanel pnlSearch;
	public static JDialog dialog;
	public static JPanel contentPanel;
	public static JLabel lblImgIcon;
	public static JLabel lblHeaderText;
	public static JButton btnBack;
	public static String[] columnheader = { "Account-ID", "Username", "Password", "Role", "Image" };
	public static DefaultTableModel tableNew = new DefaultTableModel();
	public static JScrollPane scrTable;
	public static JLabel lblImageIcon;
	public static DefaultTableCellRenderer accDatatoRender = new DefaultTableCellRenderer();
	public static JLabel lblAccountPic;
	public static JLabel lblNameLabel;
	public static JLabel lblStatusLabel;
	public static JLabel lblAccIdLabel;
	public static JLabel lblHeaderLabel;
	public static int selectedRow;
	public static String getRowAccIDforUpdate;
	public static String getRowPassword;
	public static JTable tableforShowingtheData;
	private JFileChooser setAvatar;
	String selectedImageRelativePath;
	String currentDirectoryofImg;
	public static int selectedRowForImg;
	public static JButton btnSaveChanges;
	public static JLabel lblChangeMessagePrompt;

//	==================Blotter Tab==========================
	private blotterAdd frameBlotterAdd;
	private blotterUpdate frameOngoingCasesUpdate;
	private blotterEdit frameEditCases;
	private blotterDetailsComplainant frameDetails;

	public static JTable tblBlotterRecords;
	public static DefaultTableModel modelBlotterRecords = new DefaultTableModel();
	public static String[] columnsBlottterRecords = { "Brgy. Case #", "Date/Time", "Complainant's Name",
			"Complainant's Address", "Complainant's Sex", "Respondent's Name", "Respondent's Address",
			"Respondent's Sex", "Incident", "Case Status" };

	public static JTable tblOngoingRecords;
	public static DefaultTableModel modelOngoingRecords = new DefaultTableModel();
	public static String[] columnsOngoingRecords = { "Case #", "Date/Time", "Complainant's Name", "Incident",
			"Summon Level" };
	
	public static JTable tblStoredDataComplainant;
	public static DefaultTableModel modelDataStoredComplainant = new DefaultTableModel();
	public static String[] columnDataStoredComplainant = new String[11];

	public static JTable tblStoredDataRespondent;
	public static DefaultTableModel modelDataStoredRespondent = new DefaultTableModel();
	public static String[] columnDataStoredRespondent = new String[12];
	private JButton btnEditOfficials;
	public static boolean canTheOfficialsBeEdited = false;

	private JButton btnAddBlotter;
	private JButton btnEditBlotter;
	private JButton btnDeleteBlotter;
	private JButton btnViewDetailsBlotter;
	public static JLabel lblRecords;

	private JComboBox comboBoxFilter;
	private String[] items = { "All", "Ongoing", "Solved" };
	private JTextField txtSearch;
	private JButton btnUpdateOngoing;

	public static boolean addBlotter = false, updateBlotter = false, editBlotter = false, detailsBlotter = false;
	
	public static TableRowSorter<DefaultTableModel> sorterBlotter = new TableRowSorter<DefaultTableModel>(modelBlotterRecords);
	
	private int makingInitialDataCounter = 0;
	
	public MainTabBMS(AccountManagement account) {
		setResizable(false);
		setBounds(100, 100, 1366, 768);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		========================Title=====================
		lblBMS = new JLabel(" Barangay Management System");
		lblBMS.setForeground(Color.WHITE);
		lblBMS.setFont(new Font("Arial Black", Font.BOLD, 35));
		lblBMS.setBounds(697, 0, 643, 75);
		contentPane.add(lblBMS);
//		==================================================

//		================TabbedPane===================
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		tabbedPane.setFont(new Font("Arial", Font.BOLD, 15));
		tabbedPane.setFocusable(false);
		tabbedPane.setBounds(0, 54, 1350, 675);
		contentPane.add(tabbedPane);
//		=============================================

		JPanel pnlHome = new JPanel();
		pnlHome.setOpaque(false);
		pnlHome.setBackground(new Color(0, 255, 255));
		tabbedPane.addTab("Home", new ImageIcon(MainTabBMS.class.getResource("/Images/HomeIconBlue.png")), pnlHome,
				null);
		tabbedPane.setForegroundAt(0, Color.decode(blue));
		pnlHome.setLayout(null);

		JPanel pnlSummaryRecord = new JPanel();
		pnlSummaryRecord.setOpaque(false);
		pnlSummaryRecord.setBackground(Color.WHITE);
		pnlSummaryRecord.setBounds(-1, 0, 685, 670);
		pnlSummaryRecord.setLayout(null);
		pnlHome.add(pnlSummaryRecord);

		lblOngoingCases2 = new JLabel("3");
		lblOngoingCases2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOngoingCases2.setForeground(Color.WHITE);
		lblOngoingCases2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblOngoingCases2.setBounds(267, 493, 100, 73);
		pnlSummaryRecord.add(lblOngoingCases2);

		lblSolvedCases = new JLabel("2");
		lblSolvedCases.setHorizontalAlignment(SwingConstants.CENTER);
		lblSolvedCases.setForeground(Color.WHITE);
		lblSolvedCases.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSolvedCases.setBounds(449, 492, 100, 74);
		pnlSummaryRecord.add(lblSolvedCases);

		lblRegisteredVoters = new JLabel("9845");
		lblRegisteredVoters.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisteredVoters.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRegisteredVoters.setBounds(232, 232, 116, 34);
		pnlSummaryRecord.add(lblRegisteredVoters);

		lblFemale = new JLabel("3654");
		lblFemale.setHorizontalAlignment(SwingConstants.CENTER);
		lblFemale.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblFemale.setBounds(434, 129, 70, 34);
		pnlSummaryRecord.add(lblFemale);

		lblTotalPopulation = new JLabel("15,754");
		lblTotalPopulation.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPopulation.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTotalPopulation.setBounds(232, 129, 116, 34);
		pnlSummaryRecord.add(lblTotalPopulation);

		lblMale = new JLabel("5323");
		lblMale.setHorizontalAlignment(SwingConstants.CENTER);
		lblMale.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMale.setBounds(434, 232, 70, 34);
		pnlSummaryRecord.add(lblMale);

		lblOverallCases = new JLabel("5");
		lblOverallCases.setHorizontalAlignment(SwingConstants.CENTER);
		lblOverallCases.setForeground(Color.WHITE);
		lblOverallCases.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblOverallCases.setBounds(70, 493, 98, 73);
		pnlSummaryRecord.add(lblOverallCases);

		lblSummaryRecordBG = new JLabel("");
		lblSummaryRecordBG.setBounds(-17, 0, 692, 640);
		lblSummaryRecordBG.setIcon(new ImageIcon(setImageIcon("Images/SummaryRecords.png", lblSummaryRecordBG)));
		pnlSummaryRecord.add(lblSummaryRecordBG);

//		============BlotterAndRecordTab===========
		JPanel pnlBlotterAndRecords = new JPanel();
		pnlBlotterAndRecords.setBackground(Color.WHITE);
		tabbedPane.addTab("Blotter And Records",
				new ImageIcon(MainTabBMS.class.getResource("/Images/BlotterIconWhite.png")), pnlBlotterAndRecords,
				null);

		tabbedPane.setForegroundAt(1, Color.WHITE);
		pnlBlotterAndRecords.setLayout(null);

		btnUpdateOngoing = new JButton("UPDATE");
		btnUpdateOngoing.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {

				btnUpdateOngoing.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnUpdateOngoing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (showMessage(tblOngoingRecords, contentPane, "update!") == false) { // getting the update blotter class
					frameOngoingCasesUpdate = new blotterUpdate();// create new frame
					updateBlotter = true;
					frameOngoingCasesUpdate.setVisible(true);
				}
			}
		});
		btnUpdateOngoing.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnUpdateOngoing.setBorderPainted(false);
		btnUpdateOngoing.setFocusable(false);
		btnUpdateOngoing.setBackground(new Color(74, 186, 125));
		btnUpdateOngoing.setForeground(new Color(255, 255, 255));
		btnUpdateOngoing.setBounds(28, 590, 130, 42);
		pnlBlotterAndRecords.add(btnUpdateOngoing);

		scrollPaneOngoingRecords = new JScrollPane();
		scrollPaneOngoingRecords.setBorder(new MatteBorder(3, 3, 3, 3, Color.decode(lightBlue)));
		scrollPaneOngoingRecords.setBounds(28, 378, 1289, 201);
		pnlBlotterAndRecords.add(scrollPaneOngoingRecords);

		tblOngoingRecords = new JTable(modelOngoingRecords) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tblOngoingRecords.setFont(new Font("Montserrat", Font.BOLD, 12));
		tblOngoingRecords.setFocusable(false);
		tblOngoingRecords.getTableHeader().setReorderingAllowed(false);
		tblOngoingRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelOngoingRecords.setColumnIdentifiers(columnsOngoingRecords);
		tblOngoingRecords.setAutoCreateRowSorter(true);
		tblOngoingRecords.setShowGrid(false);
		tblOngoingRecords.setIntercellSpacing(new Dimension(0, 0));
		scrollPaneOngoingRecords.setViewportView(tblOngoingRecords);

		lblcasesongoing = new JLabel("Ongoing Cases:");
		lblcasesongoing.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblcasesongoing.setBounds(38, 346, 201, 32);
		pnlBlotterAndRecords.add(lblcasesongoing);

		btnEditBlotter = new JButton("EDIT");
		btnEditBlotter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnEditBlotter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnEditBlotter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tblBlotterRecords.getRowCount() == 0) {
					JOptionPane.showMessageDialog(contentPane, "There is no existing rows to be edited!", null,
							DO_NOTHING_ON_CLOSE);
				} else {
					if (tblBlotterRecords.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null, "Please select a row that you want to be edited!", null,
								DO_NOTHING_ON_CLOSE);
					} else { // getting the edit blotter class
						frameEditCases = new blotterEdit();
						editBlotter = true;
						frameEditCases.setVisible(true);
					}
				}
			}
		});
		btnEditBlotter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnEditBlotter.setBorderPainted(false);
		btnEditBlotter.setFocusable(false);
		btnEditBlotter.setBackground(new Color(74, 186, 125));
		btnEditBlotter.setForeground(new Color(255, 255, 255));
		btnEditBlotter.setBounds(1225, 165, 113, 39);
		pnlBlotterAndRecords.add(btnEditBlotter);

		btnAddBlotter = new JButton("ADD");
		btnAddBlotter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnAddBlotter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnAddBlotter.addActionListener(new ActionListener() { // getting the add blotter class
			public void actionPerformed(ActionEvent e) {
				frameBlotterAdd = new blotterAdd();
				addBlotter = true;
				frameBlotterAdd.setVisible(true);
			}
		});
		btnAddBlotter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAddBlotter.setBorderPainted(false);
		btnAddBlotter.setFocusable(false);
		btnAddBlotter.setBackground(new Color(74, 186, 125));
		btnAddBlotter.setForeground(new Color(255, 255, 255));
		btnAddBlotter.setBounds(1225, 67, 113, 39);
		pnlBlotterAndRecords.add(btnAddBlotter);

		btnDeleteBlotter = new JButton("DELETE");
		btnDeleteBlotter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnDeleteBlotter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnDeleteBlotter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (showMessage(tblBlotterRecords, contentPane, "deleted!") == false) {

					int selectedRow = tblBlotterRecords.getSelectedRow();
					String caseNum = tblBlotterRecords.getValueAt(selectedRow, 0).toString();
					
					// finding if there's a match in data table complainant
					int selectedIndexComplainantTable = -1;
					for (int index = 0; index < tblStoredDataComplainant.getRowCount(); index++) {
						String caseNumCompare = tblStoredDataComplainant.getValueAt(index, 0).toString();
						if (caseNum == caseNumCompare) {
							selectedIndexComplainantTable = index;
							break;
						}
					} // end for
					// finding if there's a match in data ongoing records
					int selectedIndexOngoingRecordsTable = -1;
					for (int index = 0; index < tblOngoingRecords.getRowCount(); index++) {
						String caseNumCompare = tblOngoingRecords.getValueAt(index, 0).toString();
						if (caseNum == caseNumCompare) {
							selectedIndexOngoingRecordsTable = index;
							break;
						}
					} // end for

					int solveCounterCount = 0;
					
					if (selectedIndexOngoingRecordsTable > -1) { // if the selected row is solved case
						int choice = JOptionPane.showConfirmDialog(contentPane,
								"The Case is still Ongoing. Are you sure you want to delete case# "
										+ modelBlotterRecords.getValueAt(selectedRow, 0),
								"Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice == 0) { // if choose yes
							
							sorterBlotter.allRowsChanged();
							modelBlotterRecords.removeRow(selectedRow);
							modelOngoingRecords.removeRow(selectedIndexOngoingRecordsTable);
							MainTabBMS.lblRecords.setText("Records: " + MainTabBMS.modelBlotterRecords.getRowCount());
							JOptionPane.showMessageDialog(null, "Successfully Deleted!");
							
							for(int index = 0; index < tblBlotterRecords.getRowCount(); index++) {
								String determineSolveString = modelBlotterRecords.getValueAt(index, 9).toString();
								if (determineSolveString.equals("Solved")) {
									solveCounterCount++;
								}
							}
							lblSolvedCases.setText(String.valueOf(solveCounterCount));
							lblOngoingCases2.setText(String.valueOf(modelOngoingRecords.getRowCount()));
							lblOverallCases.setText(String.valueOf(modelBlotterRecords.getRowCount()));

						}
					} else {// if the selected row is not ongoing case
						int choice = JOptionPane.showConfirmDialog(contentPane,
								"Are you sure you want to delete case# "
										+ modelBlotterRecords.getValueAt(selectedRow, 0),
								"Confirmation", JOptionPane.YES_NO_OPTION);
						if (choice == 0) { // if choose yes
							
							sorterBlotter.allRowsChanged();
							modelBlotterRecords.removeRow(selectedRow);
							modelDataStoredComplainant.removeRow(selectedIndexComplainantTable);
							MainTabBMS.lblRecords.setText("Records: " + MainTabBMS.modelBlotterRecords.getRowCount());
							JOptionPane.showMessageDialog(null, "Successfully Deleted!");
							
							for(int index = 0; index < tblBlotterRecords.getRowCount(); index++) {
								String determineSolveString = modelBlotterRecords.getValueAt(index, 9).toString();
								if (determineSolveString.equals("Solved")) {
									solveCounterCount++;
								}
							}
							lblSolvedCases.setText(String.valueOf(solveCounterCount));
							lblOverallCases.setText(String.valueOf(modelBlotterRecords.getRowCount()));

						}
					}

				} // end of if
			}// end of event
		});
		btnDeleteBlotter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnDeleteBlotter.setBorderPainted(false);
		btnDeleteBlotter.setFocusable(false);
		btnDeleteBlotter.setBackground(new Color(74, 186, 125));
		btnDeleteBlotter.setForeground(new Color(255, 255, 255));
		btnDeleteBlotter.setBounds(1225, 115, 113, 39);
		pnlBlotterAndRecords.add(btnDeleteBlotter);

		btnViewDetailsBlotter = new JButton("DETAILS");
		btnViewDetailsBlotter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnViewDetailsBlotter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnViewDetailsBlotter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {// getting the details class
				if (showMessage(tblBlotterRecords, contentPane, "view!") == false) {
					frameDetails = new blotterDetailsComplainant();
					detailsBlotter = true;
					frameDetails.setVisible(true);
				}
			}
		});
		btnViewDetailsBlotter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnViewDetailsBlotter.setBorderPainted(false);
		btnViewDetailsBlotter.setFocusable(false);
		btnViewDetailsBlotter.setBackground(new Color(74, 186, 125));
		btnViewDetailsBlotter.setForeground(new Color(255, 255, 255));
		btnViewDetailsBlotter.setBounds(1225, 271, 113, 39);
		pnlBlotterAndRecords.add(btnViewDetailsBlotter);

		comboBoxFilter = new JComboBox(items);
		comboBoxFilter.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedItemFilter = comboBoxFilter.getSelectedItem().toString();
				TableRowSorter<DefaultTableModel> sorterBlotter = new TableRowSorter<DefaultTableModel>(
						modelBlotterRecords);
				tblBlotterRecords.setRowSorter(sorterBlotter);
				if (selectedItemFilter == "All") {
					sorterBlotter.setRowFilter(null);
					btnAddBlotter.setEnabled(true);
					btnEditBlotter.setEnabled(true);
					btnViewDetailsBlotter.setEnabled(true);
					btnDeleteBlotter.setEnabled(true);
					btnUpdateOngoing.setEnabled(true);
				} else {
					sorterBlotter.setRowFilter(RowFilter.regexFilter(selectedItemFilter));
					btnAddBlotter.setEnabled(false);
					btnEditBlotter.setEnabled(false);
					btnViewDetailsBlotter.setEnabled(false);
					btnDeleteBlotter.setEnabled(false);
					btnUpdateOngoing.setEnabled(false);
				}
			}
		});
		comboBoxFilter.setFont(new Font("Montserrat", Font.BOLD, 14));
		comboBoxFilter.setFocusable(false);
		comboBoxFilter.setBorder(null);
		comboBoxFilter.setBounds(1030, 14, 154, 27);
		pnlBlotterAndRecords.add(comboBoxFilter);

		lblFilterBy = new JLabel("Filter By:");
		lblFilterBy.setFont(new Font("Montserrat", Font.BOLD, 14));
		lblFilterBy.setBounds(960, 21, 85, 13);
		pnlBlotterAndRecords.add(lblFilterBy);

		btnEnter = new JButton("ENTER");
		btnEnter.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				
				btnEnter.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnEnter.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				String userInputText = txtSearch.getText().toString();
				// finding and filtering the table
				TableRowSorter<DefaultTableModel> sorterBlotter = new TableRowSorter<DefaultTableModel>(
						modelBlotterRecords);
				tblBlotterRecords.setRowSorter(sorterBlotter);

				if (userInputText.length() != 0) {
					//
					sorterBlotter.setRowFilter(RowFilter.regexFilter("(?i)" + userInputText));
				}

			}
		});
		btnEnter.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnEnter.setBorderPainted(false);
		btnEnter.setFocusable(false);
		btnEnter.setBackground(new Color(74, 186, 125));
		btnEnter.setForeground(new Color(255, 255, 255));
		btnEnter.setBounds(325, 13, 96, 27);
		pnlBlotterAndRecords.add(btnEnter);

		scrollPaneBlotterRecords = new JScrollPane();

		scrollPaneBlotterRecords.setBorder(new MatteBorder(3, 3, 3, 3, Color.decode(lightBlue)));
		scrollPaneBlotterRecords.setBounds(28, 57, 1187, 266);
		pnlBlotterAndRecords.add(scrollPaneBlotterRecords);

		tblBlotterRecords = new JTable(modelBlotterRecords) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tblBlotterRecords.setFont(new Font("Montserrat", Font.BOLD, 12));

		tblBlotterRecords.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblBlotterRecords.setFocusable(false);
		tblBlotterRecords.getTableHeader().setReorderingAllowed(false);
		tblBlotterRecords.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelBlotterRecords.setColumnIdentifiers(columnsBlottterRecords);
		tblBlotterRecords.setAutoCreateRowSorter(true);
		scrollPaneBlotterRecords.setViewportView(tblBlotterRecords);

		pnlSearch = new JPanel();
		pnlSearch.setLayout(null);
		pnlSearch.setRequestFocusEnabled(false);
		pnlSearch.setFocusable(false);
		pnlSearch.setFocusTraversalKeysEnabled(false);
		pnlSearch.setOpaque(false);
		pnlSearch.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
		pnlSearch.setBackground(Color.WHITE);
		pnlSearch.setBounds(41, 11, 233, 35);
		pnlBlotterAndRecords.add(pnlSearch);

		txtSearch = new JTextField("Search");
		txtSearch.setForeground(new Color(255, 255, 255));
		txtSearch.setFocusable(false);
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override // when user lost focus on search bar
			public void focusLost(FocusEvent e) {
				if (txtSearch.getText().equals("")) {
					txtSearch.setText("Search");
				}
			}
		});
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override// if the user click the search textfield
			public void mouseClicked(MouseEvent e) {
				txtSearch.setFocusable(true);
				if (txtSearch.getText().equals("Search")) {
					txtSearch.setText("");
					txtSearch.requestFocus();
				} else {
					txtSearch.requestFocus();
					txtSearch.selectAll();
				}
			}
		});
		txtSearch.setFont(new Font("Montserrat", Font.BOLD, 15));
		txtSearch.setOpaque(false);
		txtSearch.setFocusable(false);
		txtSearch.setBorder(null);
		txtSearch.setBounds(0, 4, 233, 29);
		pnlSearch.add(txtSearch);

		JLabel lblSearchIcon = new JLabel("");
		lblSearchIcon.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
		lblSearchIcon.setIcon(new ImageIcon(this.getClass().getResource("/search.png")));
		lblSearchIcon.setBounds(249, 14, 46, 32);
		pnlBlotterAndRecords.add(lblSearchIcon);

		JLabel lblBGBlotter = new JLabel("");
		lblBGBlotter.setHorizontalAlignment(SwingConstants.CENTER);
		lblBGBlotter.setBounds(0, 0, 1357, 651);
		lblBGBlotter.setIcon(new ImageIcon(setImageIcon("Images/BGBlotter.png", lblBGBlotter)));
		pnlBlotterAndRecords.add(lblBGBlotter);
//		==========================================

//		===========BrgOfficalList========
		JPanel pnlCBOList = new JPanel();
		pnlCBOList.setBackground(Color.WHITE);
		pnlCBOList.setOpaque(false);
		pnlCBOList.setLayout(null);
		pnlCBOList.setBounds(708, 18, 627, 562);
		pnlHome.add(pnlCBOList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setBounds(4, 79, 609, 479);
		pnlCBOList.add(scrollPane);
//		==================================

//		==========================JTable===========================
		Icon profileICon = new ImageIcon(this.getClass().getResource("Images/PlaceHolderProfile.png"));

//		@formatter:off
		String[] columnHeader = {"Profile","Name","Position"};
		
		Object[][] data = {
		{profileICon,"Violanta", "Barangay Captain"},
		{profileICon,"Danmel", "Barangay Secretary"},
		{profileICon,"Macalde", "Barangay Treasurer"},
		{profileICon,"Nadela", "Barangay Councilor"},
		{profileICon,"Saymo", "Barangay Councilor"},
		{profileICon,"Reyes", "Barangay Councilor"},
		{profileICon,"Nilbert", "Barangay Councilor"},
		{profileICon,"Conato", "Barangay Councilor"},
		{profileICon,"Ilagan", "Barangay Councilor"},
		{profileICon,"Jones", "Barangay Chairman"},
		{profileICon,"Saymo", "President"}};
//		@formatter:on

		DefaultTableModel model = new DefaultTableModel(data, columnHeader) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Class getColumnClass(int column) {
				return getValueAt(0, column).getClass();
			}
		};
		tblOfficials = new JTable(model);
		tblOfficials.setFont(new Font("Arial", Font.BOLD, 14));
		tblOfficials.setFocusable(false);
		tblOfficials.getTableHeader().setReorderingAllowed(false);
		tblOfficials.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));// JTable header font
		tblOfficials.setRowHeight(100);

		int columnSize = 230;
		TableColumnModel columnModelHome = tblOfficials.getColumnModel();// Used to be able to edit column
		columnModelHome.getColumn(1).setPreferredWidth(columnSize);// size you want, big number = smaller
		columnModelHome.getColumn(1).setMaxWidth(columnSize);

		columnModelHome.getColumn(2).setPreferredWidth(columnSize);// size you want, big number = smaller
		columnModelHome.getColumn(2).setMaxWidth(columnSize);
		scrollPane.setViewportView(tblOfficials);
//		=================================================================

//		==============Center the column 1 text===================
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		columnModelHome.getColumn(1).setCellRenderer(centerRenderer);
		columnModelHome.getColumn(2).setCellRenderer(centerRenderer);
// 		=========================================================

//		===========BrgOfficalList============
		JLabel lblCBOListBG = new JLabel("");
		lblCBOListBG.setBounds(0, 0, 617, 562);
		lblCBOListBG.setFont(new Font("Segoe UI", Font.PLAIN, 7));
		lblCBOListBG.setIcon(new ImageIcon(setImageIcon("Images/CBO BG.png", lblCBOListBG)));
		pnlCBOList.add(lblCBOListBG);

		btnEditOfficials = new JButton("EDIT");
		btnEditOfficials.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (canTheOfficialsBeEdited) {

					forUpdatingOfficialTable();

					btnEditOfficials.setText("EDIT");
					tblOfficials.setEnabled(false);

					tblOfficials.clearSelection();

					canTheOfficialsBeEdited = false;

				} else {

					tblOfficials.setEnabled(true);

					btnEditOfficials.setText("SAVE");

					canTheOfficialsBeEdited = true;
				}

			}
		});
		btnEditOfficials.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				btnEditOfficials.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnEditOfficials.setForeground(Color.WHITE);
		btnEditOfficials.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnEditOfficials.setFocusable(false);
		btnEditOfficials.setBorderPainted(false);
		btnEditOfficials.setBackground(new Color(74, 186, 125));
		btnEditOfficials.setBounds(1147, 591, 113, 39);
		pnlHome.add(btnEditOfficials);
//		====================================

//		============AccountSettingsTab==========
		pnlAccountSettings = new JPanel();
		pnlAccountSettings.setBackground(Color.WHITE);
		tabbedPane.addTab("Account Settings",
				new ImageIcon(this.getClass().getResource("/Images/AccountSettingsIconWhite.png")), pnlAccountSettings,
				null);
		tabbedPane.setForegroundAt(2, Color.WHITE);
		pnlAccountSettings.setLayout(null);

//		============Account JTable=============
		scrollPaneAccounts = new JScrollPane();
		scrollPaneAccounts.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 202, 101)));
		scrollPaneAccounts.setFont(new Font("Montserrat", Font.PLAIN, 20));
		scrollPaneAccounts.setBounds(48, 316, 1260, 296);
		pnlAccountSettings.add(scrollPaneAccounts);
		// set the columns
		tableNew.setColumnIdentifiers(columnheader);

		tableforShowingtheData = new JTable(tableNew) {
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}
		};
		tableforShowingtheData.setGridColor(new Color(103, 103, 103));
		tableforShowingtheData.setForeground(new Color(255, 255, 255));
		tableforShowingtheData.setFont(new Font("Montserrat", Font.PLAIN, 15));
		tableforShowingtheData.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnDelete.setEnabled(true);
				// enable disable the buttons
				btnUpdateAcc.setEnabled(true);
				// get the current row selected
				selectedRow = tableforShowingtheData.getSelectedRow();
				// check if the row is valid or empty
				if (tableforShowingtheData.getSelectedRow() >= -1) {
					// set first the border for the default account pic
					lblAccountPic.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 183, 91)));
					// get the row index
					int rowIndex = tableforShowingtheData.getSelectedRow();
					// get the value of image in the column of image
					Object imageUsedForReflect = tableNew.getValueAt(rowIndex, 4);
					// check first if the it is null then if is equal or is of the image icon
					if (imageUsedForReflect != null && imageUsedForReflect.getClass().equals(ImageIcon.class)) {
						// cast the value and set it as the icon for the selected row
						ImageIcon imageIcon = (ImageIcon) imageUsedForReflect;
						lblAccountPic.setIcon(imageIcon);
					} else {
						// default if there's nothing assigned image
						lblAccountPic.setIcon(new ImageIcon(this.getClass().getResource("/defaultProfilePic.png")));
					}
				}
				// show the details of each account user or admin
				int rowIndex = tableforShowingtheData.getSelectedRow();
				lblAccIdLabel.setText("ACC ID:   " + tableNew.getValueAt(rowIndex, 0).toString());
				lblNameLabel.setText("ACC NAME:   " + tableNew.getValueAt(rowIndex, 1).toString());
				lblStatusLabel.setText("ROLE:   " + tableNew.getValueAt(rowIndex, 3).toString());

			}
		});

		// after login, get the table now
		// run a for each to store and get all list of users to the user variable
		for (String[] user : account.getListOfUsers().passedToOtherArray()) {
			// set size to 5 (test size if there's any details needed to be added in the
			// row)
			String[] rowData = new String[5];
			rowData[0] = user[0]; // index for accID
			rowData[1] = user[1]; // index for username
			rowData[2] = user[2]; // index for password
			rowData[3] = user[3]; // index for current role
			tableNew.addRow(rowData);
		}

		tableforShowingtheData.setShowGrid(false);
		tableforShowingtheData.setIntercellSpacing(new Dimension(0, 0));
		// make the image column non visible since it's doesn't need to be reflected in
		// the table
		tableforShowingtheData.getColumnModel().getColumn(4).setMinWidth(0);
		tableforShowingtheData.getColumnModel().getColumn(4).setMaxWidth(0);

		// set the background of viewport to ivory or transparent
		scrollPaneAccounts.getViewport().setBackground((Color.decode("#FFFFF0")));

		accDatatoRender.setHorizontalAlignment(JLabel.CENTER);
		tableforShowingtheData.getTableHeader().setDefaultRenderer(accDatatoRender);
		accDatatoRender.setBackground(Color.decode("#a6a6a6"));
		tableforShowingtheData.getColumnModel().getColumn(1).setCellRenderer(accDatatoRender);

		for (int indexExplore = 0; indexExplore < tableforShowingtheData.getColumnCount(); indexExplore++) {
			TableColumn columnGet = tableforShowingtheData.getColumnModel().getColumn(indexExplore);
			columnGet.setCellRenderer(accDatatoRender);
		}

		scrollPaneAccounts.setViewportView(tableforShowingtheData);

//		=======================================

		lblAccounts = new JLabel("ACCOUNTS");
		lblAccounts.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccounts.setFont(new Font("Montserrat", Font.BOLD, 25));
		lblAccounts.setBounds(50, 263, 150, 34);
		pnlAccountSettings.add(lblAccounts);

		btnUpdateAcc = new JButton("UPDATE");
		btnUpdateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getRowAccIDforUpdate = tableNew.getValueAt(selectedRow, 0).toString();

				getRowPassword = tableNew.getValueAt(selectedRow, 2).toString();

				fillUpforUpdate frame = new fillUpforUpdate(account);
				frame.lblUpdateSubTextforAccId.setText(getRowAccIDforUpdate);

				// validate first if that account truly exist in the array
				if (account.validateUser(Integer.parseInt(getRowAccIDforUpdate),
						account.getPasscode(Integer.parseInt(getRowAccIDforUpdate)))) {
					JOptionPane.showMessageDialog(null, "Account Found!", "Checking " + getRowAccIDforUpdate,
							JOptionPane.INFORMATION_MESSAGE);
					frame.txtpsdField.setEnabled(true);
					frame.txtUpdateUsername.setEnabled(true);
					frame.setVisible(true);
				} else {
					// prompts to create a new account now
					JOptionPane.showMessageDialog(null, "Not found!!",
							"Account in table is not in the Array, please create a new account first",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

			}
		});
		btnUpdateAcc.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnUpdateAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		btnUpdateAcc.setEnabled(false);
		btnUpdateAcc.setFocusable(false);
		btnUpdateAcc.setForeground(Color.WHITE);
		btnUpdateAcc.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnUpdateAcc.setBorderPainted(false);
		btnUpdateAcc.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnUpdateAcc.setFocusable(false);
		btnUpdateAcc.setBackground(new Color(74, 186, 125));
		btnUpdateAcc.setBounds(1176, 102, 117, 44);
		pnlAccountSettings.add(btnUpdateAcc);

		btnAddAcc = new JButton("ADD");
		btnAddAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				addAccFillUpAdmin dialog = new addAccFillUpAdmin(account);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);

			}
		});
		btnAddAcc.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAddAcc.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});

		btnAddAcc.setBorderPainted(false);
		btnAddAcc.setFocusable(false);
		btnAddAcc.setForeground(new Color(255, 255, 255));
		btnAddAcc.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnAddAcc.setFocusable(false);
		btnAddAcc.setBackground(new Color(74, 186, 125));
		btnAddAcc.setBounds(1176, 27, 117, 44);
		pnlAccountSettings.add(btnAddAcc);

		btnSetAvatar = new JButton("ADD IMAGE");
		btnSetAvatar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				selectedRowForImg = tableforShowingtheData.getSelectedRow();
				btnSetAvatar.setCursor(new Cursor(Cursor.HAND_CURSOR));

			}
		});
		btnSetAvatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Initial directory for the JFileChooser
				setAvatar = new JFileChooser();
				// filter files to allow only images
				setAvatar.setDialogTitle("Select Images for Avatar");

				int openResult = setAvatar.showSaveDialog(contentPane);

				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
				setAvatar.addChoosableFileFilter(filter);
				// prompts the JFile Chooser

				// If save..
				if (openResult == JFileChooser.APPROVE_OPTION) {
					File fileSelected = setAvatar.getSelectedFile();
					// get the the absolute of the selected file
					String path = fileSelected.getAbsolutePath();
					// Resize the image and create an Imageicon through this
					ImageIcon imageIcon = resizeTheImage(path);
					// Set the image to the label
					lblAccountPic.setIcon(imageIcon);
					// Get the selected row Index from the table
					int rowIndex = tableforShowingtheData.getSelectedRow();
					// Check first if a valid row is selected
					if (rowIndex >= 0) {
						// set the image through the column for the purpose of retrieving it during the
						// mouse event
						tableNew.setValueAt(imageIcon, rowIndex, 4);
					}

				}
				// if choose no
				else if (openResult == JFileChooser.CANCEL_OPTION) {
					// shows message
					JOptionPane.showMessageDialog(null, "No File Selected", "Adding Image Cancelled",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnSetAvatar.setForeground(Color.WHITE);
		btnSetAvatar.setFont(new Font("Montserrat", Font.BOLD, 11));
		btnSetAvatar.setFocusable(false);
		btnSetAvatar.setBorderPainted(false);
		btnSetAvatar.setBackground(new Color(74, 186, 125));
		btnSetAvatar.setBounds(1176, 261, 117, 44);
		pnlAccountSettings.add(btnSetAvatar);

		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String getRowSpecificUsername = tableNew.getValueAt(selectedRow, 1).toString();

		        int responseDialog = JOptionPane.showConfirmDialog(null,
		                "Performing to remove " + getRowSpecificUsername + " ? ", "Confirmation for Deletion",
		                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

		        if (responseDialog == JOptionPane.YES_OPTION) {
		            String getRowSpecificAccID = tableNew.getValueAt(selectedRow, 0).toString();

		        
		            if (loginPage.getUsernametoLocate.equals(getRowSpecificUsername) && loginPage.getUsernameRole.equals("Administrator")) {
		                JOptionPane.showMessageDialog(null, "Please log out first and delete this account using the initial admin.", "Deleting a logged on Account ",JOptionPane.ERROR_MESSAGE);
		                return;
		            } else if (selectedRow > 0) {
		            	tableNew.removeRow(selectedRow);
		                account.removeUserInfo(Integer.parseInt(getRowSpecificAccID));
		            } else {
		                JOptionPane.showMessageDialog(null, "Cannot delete the initial admin.", "Error in Deleting", JOptionPane.ERROR_MESSAGE);

		            }
		          
		            btnDelete.setEnabled(false);
		            btnUpdateAcc.setEnabled(false);
		            lblAccIdLabel.setText("");
		            lblNameLabel.setText("");
		            lblStatusLabel.setText("");
		            tableforShowingtheData.clearSelection();
		        } else if (responseDialog == JOptionPane.NO_OPTION) {
		            btnDelete.setEnabled(false);
		            btnUpdateAcc.setEnabled(false);
		            return;
		        }
		    }
		});

		btnDelete.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnDelete.setEnabled(false);
		btnDelete.setFocusable(false);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Montserrat", Font.BOLD, 15));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(74, 186, 125));
		btnDelete.setBounds(1176, 181, 117, 44);
		pnlAccountSettings.add(btnDelete);

		btnSaveChanges = new JButton("SAVE");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear the table before closing so the data will not be duplicated
				tableNew.getDataVector().clear();
				// close the window
				dispose();
				// open a new instance of loginuserform
				loginPage newLogin = new loginPage(account);
				// set it visible to login again
				newLogin.setVisible(true);
			}
		});
		btnSaveChanges.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSaveChanges.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		btnSaveChanges.setIcon(new ImageIcon(this.getClass().getResource("/SAVE.png")));
		btnSaveChanges.setOpaque(false);
		btnSaveChanges.setVisible(false);
		btnSaveChanges.setEnabled(false);
		btnSaveChanges.setForeground(Color.WHITE);
		btnSaveChanges.setFont(new Font("Montserrat", Font.BOLD, 10));
		btnSaveChanges.setFocusable(false);
		btnSaveChanges.setContentAreaFilled(false);
		btnSaveChanges.setBorderPainted(false);
		btnSaveChanges.setBackground(new Color(0, 0, 0, 0));
		btnSaveChanges.setBounds(363, 261, 111, 48);
		pnlAccountSettings.add(btnSaveChanges);

		lblChangeMessagePrompt = new JLabel("Changes Made, Please Save First");
		lblChangeMessagePrompt.setVisible(false);
		lblChangeMessagePrompt.setForeground(new Color(0, 0, 0));
		lblChangeMessagePrompt.setFont(new Font("Montserrat", Font.BOLD, 15));
		lblChangeMessagePrompt.setBounds(498, 259, 265, 48);
		pnlAccountSettings.add(lblChangeMessagePrompt);

		lblNameLabel = new JLabel("ACC NAME:");
		lblNameLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblNameLabel.setBounds(280, 106, 275, 34);
		pnlAccountSettings.add(lblNameLabel);

		lblAccIdLabel = new JLabel("ACC ID: ");
		lblAccIdLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblAccIdLabel.setBounds(280, 27, 275, 34);
		pnlAccountSettings.add(lblAccIdLabel);

		lblStatusLabel = new JLabel("ROLE: ");
		lblStatusLabel.setFont(new Font("Montserrat", Font.PLAIN, 16));
		lblStatusLabel.setBounds(280, 191, 275, 34);
		pnlAccountSettings.add(lblStatusLabel);

		lblAccountPic = new JLabel("");
		lblAccountPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountPic.setBounds(50, 27, 220, 198);
		pnlAccountSettings.add(lblAccountPic);

		lblBGAccountSettings = new JLabel("");
		lblBGAccountSettings.setBounds(0, 0, 1359, 643);
		lblBGAccountSettings.setIcon(new ImageIcon(setImageIcon("/Images/BGAccount.png", lblBGAccountSettings)));
		pnlAccountSettings.add(lblBGAccountSettings);
//		=============================================

//		===========LogoutTab===========
		JPanel pnlLogout = new JPanel();
		tabbedPane.addTab("Logout", new ImageIcon(MainTabBMS.class.getResource("/Images/LogoutIconWhite.png")),
				pnlLogout, null);
		tabbedPane.setIconAt(3, new ImageIcon(this.getClass().getResource("Images/LogoutIconWhite.png")));
		tabbedPane.setForegroundAt(3, Color.WHITE);

		lblProfile = new JLabel("");
		lblProfile.setFont(new Font("Montserrat", Font.BOLD, 20));
		lblProfile.setForeground(new Color(255, 255, 255));
		lblProfile.setBounds(188, 11, 364, 42);
		contentPane.add(lblProfile);
//		=============================== 

		lblProfile.setText(loginPage.getUsernameRole + "   " + loginPage.getUsernametoLocate);

		if (loginPage.getUsernameRole.equals("User")) {
			tabbedPane.setEnabledAt(2, false);
			btnEditOfficials.setVisible(false);

		}

		JLabel lblBGHome = new JLabel("");
		lblBGHome.setBounds(0, 0, 1350, 761);
		lblBGHome.setIcon(new ImageIcon(setImageIcon("Images/BGHome.png", lblBGHome)));
		contentPane.add(lblBGHome);
//      ============= make column center===============
		TableColumnModel columnModel = tblBlotterRecords.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(80);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setPreferredWidth(200);
		columnModel.getColumn(3).setPreferredWidth(250);
		columnModel.getColumn(4).setPreferredWidth(150);
		columnModel.getColumn(5).setPreferredWidth(200);
		columnModel.getColumn(6).setPreferredWidth(250);
		columnModel.getColumn(7).setPreferredWidth(150);
		columnModel.getColumn(8).setPreferredWidth(150);
		columnModel.getColumn(9).setPreferredWidth(100);
		//make the column immovable and resizable
		DefaultTableCellRenderer centerRendererBlotter = new DefaultTableCellRenderer();
		centerRendererBlotter.setHorizontalAlignment(JLabel.CENTER);
		for (int index = 0; index < 10; index++) {
			tblBlotterRecords.getColumnModel().getColumn(index).setCellRenderer(centerRendererBlotter);
			tblBlotterRecords.getColumnModel().getColumn(index).setResizable(false);
		}

		for (int index = 0; index < 5; index++) {
			tblOngoingRecords.getColumnModel().getColumn(index).setCellRenderer(centerRendererBlotter);
			tblOngoingRecords.getColumnModel().getColumn(index).setResizable(false);
		}

// ======================================================================================= Table that data stored
		tblStoredDataComplainant = new JTable(modelDataStoredComplainant);
		tblStoredDataComplainant.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelDataStoredComplainant.setColumnIdentifiers(columnDataStoredComplainant);

		tblStoredDataRespondent = new JTable(modelDataStoredRespondent);
		tblStoredDataRespondent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		modelDataStoredRespondent.setColumnIdentifiers(columnDataStoredRespondent);
		
		//If the blotter records has no data and counter is 0, add the initial data in the tables
		if (modelBlotterRecords.getRowCount() == 0 && makingInitialDataCounter == 0) {
			initialDataForBlotterRecords();
			makingInitialDataCounter++; // add 1 so that the data don't repeat and only print at start 
		}
		
		lblRecords = new JLabel("Records: " + MainTabBMS.modelBlotterRecords.getRowCount());
		lblRecords.setFont(new Font("Montserrat", Font.BOLD, 19));
		lblRecords.setBounds(1030, 322, 185, 32);
		pnlBlotterAndRecords.add(lblRecords);
		
//		=============Iterate JTabs=============
		int tabCount = tabbedPane.getTabCount();
		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				int selectedIndex = tabbedPane.getSelectedIndex();// get selected tab
				tabbedPane.setForegroundAt(selectedIndex, Color.decode(blue));// set that tab text to blue if its selected

				for (int index = 0; index < tabCount; index++) {// scan which tab is not selected and set text to blue
					if (selectedIndex != index) {
						tabbedPane.setForegroundAt(index, Color.white);
					}
				}

				if (selectedIndex == 3) {// Logout
					// clears the table before disposing for accounts
					tableNew.getDataVector().clear();
					dispose();
					loginPage login = new loginPage(account);
					login.setVisible(true);

				}

				setTabIcons(selectedIndex);
			}
		});
//		=======================================

	}// end constructor

	public static int isMatch(JTable tbl, int col, String caseNum) {
		int negIndex = -1;
		for (int index = 0; index < tbl.getRowCount(); index++) {
			String caseNumCompare = tbl.getValueAt(index, col).toString();
			if (caseNum == caseNumCompare) {// if = get its index
				negIndex = index;
				break;
			}
		} // end for
		return negIndex;

	}// end method

	public static boolean showMessage(JTable tbl, JComponent component, String text) {

		if (tbl.getRowCount() == 0) {// if no data
			JOptionPane.showMessageDialog(component, "There is no existing rows to be " + text, null,
					DO_NOTHING_ON_CLOSE);
			return true;
		}

		if (tbl.getSelectedRow() == -1) {// if no selected
			JOptionPane.showMessageDialog(component, "Please select a row that you want to " + text, null,
					DO_NOTHING_ON_CLOSE);
			return true;
		}
		return false;// if there is selected row

	}

	public static void setTabIcons(int selectedIndex) {

//		==============HomeTab===================
		if (selectedIndex != 0) {// HomeIcon
			tabbedPane.setIconAt(0, new ImageIcon(MainTabBMS.class.getResource("Images/HomeIconWhite.png")));

		} else {
			tabbedPane.setIconAt(0, new ImageIcon(MainTabBMS.class.getResource("Images/HomeIconBlue.png")));
		}
//		========================================

//		==============BlotterAndRecordsTab===================
		if (selectedIndex != 1) {// BlotterAndRecords Icon // if selected isn't 1
			tabbedPane.setIconAt(1, new ImageIcon(MainTabBMS.class.getResource("Images/BlotterIconWhite.png")));
		} else {
			tabbedPane.setIconAt(1, new ImageIcon(MainTabBMS.class.getResource("Images/BlotterIconBlue.png")));
		}
//		=====================================================

//		==============AccountSettingsTab===================
		if (selectedIndex != 2) {// Account Settings Icon // if selected isn't 2
			tabbedPane.setIconAt(2, new ImageIcon(MainTabBMS.class.getResource("Images/AccountSettingsIconWhite.png")));
		} else {
			tabbedPane.setIconAt(2, new ImageIcon(MainTabBMS.class.getResource("Images/AccountSettingsIconBlue.png")));
		}
//		==================================================

//		==============Log outTab===================
		if (selectedIndex != 3) {// Logout Icon
			tabbedPane.setIconAt(3, new ImageIcon(MainTabBMS.class.getResource("Images/LogoutIconWhite.png")));
		} else {
			tabbedPane.setIconAt(3, new ImageIcon(MainTabBMS.class.getResource("Images/LogoutIconBlue.png")));
		}
//		===========================================

	}

//	======================Resize Image========================
	public static Image setImageIcon(String path, JLabel lbl) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(MainTabBMS.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image img = image.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
		return img;
	}

	// resize the image of avatar using getScaledInstance
	public ImageIcon resizeTheImage(String imagePath) {
		// create an imageicon from the imagepath
		ImageIcon setImage = new ImageIcon(imagePath);
		// get the image object from the imageicon
		Image image = setImage.getImage();
		// scale the image to fit lblAccountPic using the getScaledInstance
		Image newImg = image.getScaledInstance(lblAccountPic.getWidth(), lblAccountPic.getHeight(), Image.SCALE_SMOOTH);
		// new image now resized
		ImageIcon newImage = new ImageIcon(newImg);
		// return the resize image
		return newImage;
	}

	public void forUpdatingOfficialTable() {

		for (int rowIndex = 0; rowIndex < tblOfficials.getRowCount(); rowIndex++) {
			for (int columnIndex = 0; columnIndex < tblOfficials.getColumnCount(); columnIndex++) {
				// object since there's an imageicon in the table
				Object getTheValueUpdated = tblOfficials.getValueAt(rowIndex, columnIndex);

				tblOfficials.setValueAt(getTheValueUpdated, rowIndex, columnIndex);
			}
		}
	}
	
	public void initialDataForBlotterRecords() {
		//Initial Datas for the Blotter Records
				String[] caseNum1Complainant = {"1", "Alex", "Gabriel", "Cruz", "Theft", "40", "09123456789", 
						"BLK 206 LOT 17 PH.2 SANGRILA VILLAGE", "On March 27, 2023, I discovered that valuable items, including electronics and jewelry, were stolen from my port yard and I saw a man in a hoodie jacket running away. The incident was reported to the local police, who are currently investigating the burglary and found that Mr. Aron Sinaing Vello is the culprit.",
						"1", "0"};
				String[] caseNum2Complainant = {"2", "Sophia", "Marie", "Santos", "Assault and Battery", "28", "09179876543", 
						"456 Elm Street, Makati Subdivision", "On April 8, 2023, I was physically assaulted by an individual in Makati Subdivision near palengke. The incident occurred during a heated argument and resulted in injuries. I immediately reported the incident to the local authorities and provided them with all the necessary details, including the identity of the accused, Mr. Mark Johnson. I am seeking justice and appropriate legal action against him for the assault.",
						"0", "1"};
				String[] caseNum3Complainant = {"3", "Gabriel", "Andres", "Reyes", "Identity Theft", "35", "09221112222", 
						"789 Mango Street, MABUHAY Subdivision", "On May 11, 2023, I discovered that my personal information was fraudulently used for unauthorized financial transactions. I suspect that my identity was stolen and used for illegal activities. I immediately reported the incident to the local authorities, and I am seeking their assistance in identifying the perpetrator and holding them accountable for their actions.",
						"1", "0"};
				String[] caseNum4Complainant = {"4", "Mia", "Isabel", "Garcia", "Online Scam", "25", "09553334444", 
						"111 Sunflower Street, VILLA ASTELA", "On May 10, 2023, I fell victim to an online scam where I was deceived into making a payment for a product that was never delivered\r\n"
								+ "\r\n"
								+ ". I have evidence of the fraudulent transaction and I want to report this incident to seek legal action against the scammer and recover my money.\r\n",
						"0", "1"};
				String[] caseNum5Complainant = {"5", "Lucas", "Antonio", "Martinez", "Property Damage", "45", "09178889999", 
						"789 Oak Street, VILLA PALAW", "On May 24, 2023, my property was significantly damaged due to a nearby construction project. The construction activities caused structural issues and resulted in substantial financial loss. I have documented evidence of the damage and the impact it has had on my property. I am seeking compensation and resolution for the damages caused.",
						"1", "0"};
				
				modelDataStoredComplainant.addRow(caseNum1Complainant);
				modelDataStoredComplainant.addRow(caseNum2Complainant);
				modelDataStoredComplainant.addRow(caseNum3Complainant);
				modelDataStoredComplainant.addRow(caseNum4Complainant);
				modelDataStoredComplainant.addRow(caseNum5Complainant);
				
				String[] caseNum1Respondent = {"Aron", "Sinaing", "Vello", "Theft", "Article 308 of the Revised Penal Code - Theft", "35", "09123456789", 
						"BLK 135 LOT  04 PH.2 Mabuhay Subdivision", "On April 1, 2023, I was just in my neighborhood’s house. I am also wearing a hoodie jacket but I did not go anywhere aside from my friend’s house.",
						"0", "0", "1"};
				String[] caseNum2Respondent = {"Mark", "Johnson", "Cruz", "Assault and Battery", " Article 266 of the Revised Penal Code - Physical Injuries", "30", "09221112222", 
						"789 Maple Street, Makati SUbdivision", "On April 10, 2023, I was just in my neighborhood’s house. I am also wearing a hoodie jacket but I did not go anywhere aside from my friend’s house.",
						"0", "0", "2"};
				
				modelDataStoredRespondent.addRow(caseNum1Respondent);
				modelDataStoredRespondent.addRow(caseNum2Respondent);

				String[] caseNum1Blotter = {"1", "04/01/2023   14:53", "Alex Gabriel Cruz", "BLK 206 LOT 17 PH.2 SANGRILA VILLAGE", "Male", "Aron Sinaing Vello", "BLK 135 LOT  04 PH.2 Mabuhay Subdivision", "Male", "Theft", "Solved"};
				String[] caseNum2Blotter = {"2", "04/10/2023   10:26", "Sophia Marie Santos", "456 Elm Street, Makati Subdivision", "Female", "Mark Johnson Cruz", "789 Maple Street, Makati SUbdivision", "Female", "Assault and Battery", "Solved"};

				modelBlotterRecords.addRow(caseNum1Blotter);
				modelBlotterRecords.addRow(caseNum2Blotter);

				String[] caseNum3Blotter = {"3", "05/15/2023   08:32", "Gabriel Andres Reyes", "789 Mango Street, MABUHAY Subdivision", "Male", "N/A", "N/A", "N/A", "Identity Theft", "Ongoing"};
				String[] caseNum4Blotter = {"4", "05/18/2023   09:49", "Mia Isabel Garcia", "111 Sunflower Street, VILLA ASTELA", "Female", "N/A", "N/A", "N/A", "Online Scam", "Ongoing"};
				String[] caseNum5Blotter = {"5", "05/25/2023   18:32", "Lucas Antonio Martinez", "789 Oak Street, VILLA PALAW", "Male", "N/A", "N/A", "N/A", "Property Damage", "Ongoing"};

				modelBlotterRecords.addRow(caseNum3Blotter);
				modelBlotterRecords.addRow(caseNum4Blotter);
				modelBlotterRecords.addRow(caseNum5Blotter);

				String[] caseNum3Blotter1 = {"3", "05/15/2023   08:32", "Gabriel Andres Reyes", "Identity Theft", "Barangay Level"};
				String[] caseNum4Blotter1 = {"4", "05/18/2023   09:49", "Mia Isabel Garcia", "Online Scam", "Barangay Level"};
				String[] caseNum5Blotter1 = {"5", "05/25/2023   18:32", "Lucas Antonio Martinez", "Property Damage", "Barangay Level"};

				modelOngoingRecords.addRow(caseNum3Blotter1);
				modelOngoingRecords.addRow(caseNum4Blotter1);
				modelOngoingRecords.addRow(caseNum5Blotter1);
	}
}
