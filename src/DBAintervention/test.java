package DBAintervention;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;

public class test {

	private JFrame frame;
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JTextField num;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 763, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, "cell 0 0,grow");
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("79px"),},
			new RowSpec[] {
				RowSpec.decode("17dlu"),
				RowSpec.decode("19px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(12dlu;default)"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, "2, 2, left, top");
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2, "2, 4, left, top");
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1, "2, 6, left, top");
		
		final JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new MigLayout("",
				"[57.00:n,grow][10.00:n][73.00px:82.00px][38px][3px][7px][48px][316px][10.00,grow][]",
				"[][20px][18px][18px][17px][19px][136px]"));
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "• Changer la date et l’heure de l’intervention",
				"• Afficher les noms et prénoms des employes ayant fait plus de 3 interventions",
				"• Afficher la liste des véhicules", "• Afficher les détails d’une intervention",
				"• Afficher les modèles et leur marque",
				"• Afficher les véhicules sur lesquels il y a au moins une intervention.",
				"• Afficher les employés dont le nom commence par un T",
				"• Afficher la liste des interventions faites par un employé",
				"• Déterminer la liste des interventions faites dans une période donnée" }));
		panel_1.add(comboBox, "cell 2 1 6 1,alignx left,aligny top");
		
		final JLabel lblDateDeDebut = new JLabel("Date de debut :");
		lblDateDeDebut.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");

		final JComboBox jourd = new JComboBox();
		jourd.setFont(new Font("Arial", Font.PLAIN, 11));
		jourd.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		panel_1.add(jourd, "cell 3 2 3 1,growx,aligny center");

		final JComboBox moisd = new JComboBox();
		moisd.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisd.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(moisd, "cell 6 2,growx,aligny center");

		final JComboBox anneed = new JComboBox();
		anneed.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneed.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(anneed, "cell 7 2,alignx left,aligny center");

		final JComboBox anneef = new JComboBox();
		anneef.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneef.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(anneef, "cell 7 3,alignx left,aligny center");

		final JComboBox moisf = new JComboBox();
		moisf.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisf.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(moisf, "cell 6 3,growx,aligny center");

		final JComboBox jourf = new JComboBox();
		jourf.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		jourf.setFont(new Font("Arial", Font.PLAIN, 11));
		panel_1.add(jourf, "cell 3 3 3 1,growx,aligny center");

		final JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");

		final JLabel numText = new JLabel("Numéro de l'intervention :");
		numText.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(numText, "cell 2 4 3 1,alignx left,aligny center");

		final JTextField num = new JTextField();
		panel_1.add(num, "cell 5 4 3 1,alignx left,aligny top");
		num.setColumns(10);

		final JButton Exec = new JButton("Exécuter ");

		panel_1.add(Exec, "cell 6 5 2 1,alignx left,aligny top");

		final JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "cell 1 6 8 1,grow");

		final JTable table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedItem().toString()) {
				case "• Changer la date et l’heure de l’intervention": {
					scrollPane.setVisible(false);
					panel_1.add(scrollPane, "cell 1 6 8 1,grow");
					panel_1.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");
					lblDateDeDebut.setVisible(true);
					panel_1.add(jourd, "cell 3 2 3 1,growx,aligny center");
					jourd.setVisible(true);
					panel_1.add(moisd, "cell 6 2,growx,aligny center");
					moisd.setVisible(true);
					panel_1.add(anneed, "cell 7 2,alignx left,aligny center");
					anneed.setVisible(true);
					panel_1.add(anneef, "cell 7 3,alignx left,aligny center");
					anneef.setVisible(true);
					panel_1.add(moisf, "cell 6 3,growx,aligny center");
					moisf.setVisible(true);
					panel_1.add(jourf, "cell 3 3 3 1,growx,aligny center");
					jourf.setVisible(true);
					panel_1.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");
					lblDateDeFin.setVisible(true);
					panel_1.add(numText, "cell 2 4 3 1,alignx left,aligny center");
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					panel_1.add(num, "cell 5 4 3 1,alignx left,aligny top");
					num.setVisible(true);
					panel_1.add(Exec, "cell 6 5 2 1,alignx left,aligny top");
					Exec.setVisible(true);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								String datedebString = jourd.getSelectedItem().toString() + "/"
										+ moisd.getSelectedItem().toString() + "/"
										+ anneed.getSelectedItem().toString();
								String datefinString = jourf.getSelectedItem().toString() + "/"
										+ moisf.getSelectedItem().toString() + "/"
										+ anneef.getSelectedItem().toString();
								String sqlString = String.format(
										"Update interventions set DATEDEBINTERV=%s and DATEFININTERV=%s where NUMINTERVENTION=%s",
										datedebString, datefinString, num.getText());
								rs = stmt.executeQuery(sqlString);
								System.out.print(sqlString);

							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Afficher les noms et prénoms des employes ayant fait plus de 3 interventions": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(false);
					num.setVisible(false);
					Exec.setVisible(false);
					panel_1.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(num, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					panel_1.add(scrollPane, "cell 2 2 6 4,grow ");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery(
								"SELECT nomemp, prenomemp FROM employe WHERE numemploye = (SELECT numemploye FROM intervenants GROUP BY numemploye HAVING COUNT(*) > 3)");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}

				case "• Afficher la liste des véhicules": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(false);
					num.setVisible(false);
					Exec.setVisible(false);
					panel_1.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(num, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					panel_1.add(scrollPane, "cell 2 2 6 4,grow ");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery("SELECT * FROM vehicule ");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}
				case "• Afficher les détails d’une intervention": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					panel_1.add(numText, "cell 2 2 3 1,alignx left,aligny center");
					num.setVisible(true);
					panel_1.add(num, "cell 5 2 3 1,alignx left,aligny top");
					Exec.setVisible(true);
					panel_1.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					panel_1.add(scrollPane, "cell 2 4 6 4,grow ");
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								rs = stmt.executeQuery(
										"SELECT * FROM interventions WHERE NUMINTERVENTION =" + num.getText());
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Afficher les modèles et leur marque": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(false);
					num.setVisible(false);
					Exec.setVisible(false);
					panel_1.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(num, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					panel_1.add(scrollPane, "cell 2 2 6 4,grow ");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery(
								"SELECT distinct MARQUE,MODELE FROM MARQUE ,MODELE WHERE MARQUE.NUMMARQUE=MODELE.NUMMARQUE");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}
				case "• Afficher les véhicules sur lesquels il y a au moins une intervention.": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(false);
					num.setVisible(false);
					Exec.setVisible(false);
					panel_1.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(num, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					panel_1.add(scrollPane, "cell 2 2 6 4,grow ");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery(
								"SELECT distinct VEHICULE.* FROM VEHICULE,INTERVENTIONS WHERE VEHICULE.NUMVEHICULE=INTERVENTIONS.NUMVEHICULE");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}
				case "• Afficher les employés dont le nom commence par un T": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(false);
					num.setVisible(false);
					Exec.setVisible(false);
					panel_1.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(num, "cell 9 5 1 1,alignx left,aligny top");
					panel_1.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					panel_1.add(scrollPane, "cell 2 2 6 4,grow ");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery("SELECT * FROM EMPLOYE WHERE NOMEMP LIKE 'T%'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}
				case "• Afficher la liste des interventions faites par un employé": {
					scrollPane.setVisible(true);
					lblDateDeDebut.setVisible(false);
					panel_1.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'employé :");
					panel_1.add(numText, "cell 2 2 3 1,alignx left,aligny center");
					num.setVisible(true);
					panel_1.add(num, "cell 5 2 3 1,alignx left,aligny top");
					Exec.setVisible(true);
					panel_1.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					panel_1.add(scrollPane, "cell 2 4 6 4,grow ");
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								rs = stmt.executeQuery("SELECT * FROM intervenants WHERE numemploye =" + num.getText());
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Déterminer la liste des interventions faites dans une période donnée": {
					scrollPane.setVisible(true);
					panel_1.add(scrollPane, "cell 1 5 8 1,grow");
					panel_1.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");
					lblDateDeDebut.setVisible(true);
					panel_1.add(jourd, "cell 3 2 3 1,growx,aligny center");
					jourd.setVisible(true);
					panel_1.add(moisd, "cell 6 2,growx,aligny center");
					moisd.setVisible(true);
					panel_1.add(anneed, "cell 7 2,alignx left,aligny center");
					anneed.setVisible(true);
					panel_1.add(anneef, "cell 7 3,alignx left,aligny center");
					anneef.setVisible(true);
					panel_1.add(moisf, "cell 6 3,growx,aligny center");
					moisf.setVisible(true);
					panel_1.add(jourf, "cell 3 3 3 1,growx,aligny center");
					jourf.setVisible(true);
					panel_1.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");
					lblDateDeFin.setVisible(false);
					panel_1.add(numText, "cell 9 5 3 1,alignx left,aligny center");
					numText.setVisible(false);
					numText.setText("Numéro de l'intervention :");
					panel_1.add(num, "cell 9 5 3 1,alignx left,aligny top");
					num.setVisible(true);
					panel_1.add(Exec, "cell 6 4 2 1,alignx left,aligny top");
					Exec.setVisible(true);
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								String datedebString = jourd.getSelectedItem().toString() + "/"
										+ moisd.getSelectedItem().toString() + "/"
										+ anneed.getSelectedItem().toString();
								String datefinString = jourf.getSelectedItem().toString() + "/"
										+ moisf.getSelectedItem().toString() + "/"
										+ anneef.getSelectedItem().toString();
								String sqlString = String.format(
										"select * from interventions where DATEDEBINTERV>'%s' and DATEFININTERV<'%s'",
										datedebString, datefinString);
								rs = stmt.executeQuery(sqlString);
								table.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				}
				;
			}

		});

		
		
		
	}

}
