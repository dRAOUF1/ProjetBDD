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
import javax.swing.SwingConstants;
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

import com.jgoodies.forms.layout.*;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;

public class test {

	private JFrame frame;
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JTextField num;
	private JTable table;
	private JScrollPane scrollPane;

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
		panel.setLayout(new FormLayout(new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("79px"), },
				new RowSpec[] { RowSpec.decode("17dlu"), RowSpec.decode("19px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("max(12dlu;default)"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton, "2, 2, left, top");

		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2, "2, 4, left, top");

		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1, "2, 6, left, top");

		JLayeredPane layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		JPanel client = new JPanel();
		layeredPane.add(client, "name_1394139862364500");
		client.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][271.00px,grow][23px]"));

		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		client.add(lblNewLabel, "cell 0 0 3 1,growx,aligny top");

		scrollPane = new JScrollPane();
		client.add(scrollPane, "cell 0 1 3 1,grow");

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));

		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention = new DBAINTERVENTION();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		client.add(btnNewButton, "cell 0 2,alignx right,aligny top");

		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					frame.dispose();
					InsererClient fInsererClient = new InsererClient();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		client.add(btnInserer, "cell 2 2,alignx left,aligny top");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CLIENT");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		JPanel Employe = new JPanel();
		layeredPane.add(Employe, "name_1393584470435300");
		Employe.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		JLabel lblNewLabel1 = new JLabel("Employé");
		lblNewLabel1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		Employe.add(lblNewLabel1, "cell 0 0 3 1,growx,aligny top");

		scrollPane = new JScrollPane();
		Employe.add(scrollPane, "cell 0 1 3 1,grow");

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));

		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention = new DBAINTERVENTION();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		Employe.add(btnNewButton, "cell 0 2,alignx right,aligny top");

		btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					frame.dispose();
					InsererEmploye fInsererEmploye = new InsererEmploye();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		Employe.add(btnInserer, "cell 2 2,alignx left,aligny top");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYE");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		JPanel marque = new JPanel();
		layeredPane.add(marque, "name_1393635257920800");
marque.setLayout(null);
		
		JLabel lblNewLabelMarque = new JLabel("Marque");
		lblNewLabelMarque.setBounds(7, 16, 626, 18);
		lblNewLabelMarque.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelMarque.setHorizontalAlignment(SwingConstants.CENTER);
		marque.add(lblNewLabelMarque);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		marque.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention=new DBAINTERVENTION();
			}
		});
		btnNewButton.setBounds(101, 305, 84, 23);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		marque.add(btnNewButton);
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererMarque fInsererMarque= new InsererMarque();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		marque.add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM Marque");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}



		JPanel modele = new JPanel();
		layeredPane.add(modele, "name_1393637987395500");
modele.setLayout(null);
		
		JLabel lblNewLabelModele = new JLabel("Modèle ");
		lblNewLabelModele.setBounds(7, 16, 626, 18);
		lblNewLabelModele.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelModele.setHorizontalAlignment(SwingConstants.CENTER);
		modele.add(lblNewLabelModele);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		modele.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention=new DBAINTERVENTION();
			}
		});
		btnNewButton.setBounds(101, 305, 84, 23);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		modele.add(btnNewButton);
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererModele fInsererModele=new InsererModele();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		modele.add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM modele");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}

		JPanel vehicule = new JPanel();
		layeredPane.add(vehicule, "name_1393640284669700");
vehicule.setLayout(null);
		
		JLabel lblNewLabelVehicule = new JLabel("Véhicule ");
		lblNewLabelVehicule.setBounds(7, 16, 626, 18);
		lblNewLabelVehicule.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		vehicule.add(lblNewLabelVehicule);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		vehicule.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention=new DBAINTERVENTION();
			}
		});
		btnNewButton.setBounds(101, 305, 84, 23);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		vehicule.add(btnNewButton);
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererVehicule fInsererVehicule= new InsererVehicule();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		vehicule.add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM vehicule");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}


		

		JPanel intervenant = new JPanel();
		layeredPane.add(intervenant, "name_1393738788754100");
intervenant.setLayout(null);
		
		JLabel lblNewLabel1Intervenant = new JLabel("Intervenants");
		lblNewLabel1Intervenant.setBounds(7, 16, 626, 18);
		lblNewLabel1Intervenant.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1Intervenant.setHorizontalAlignment(SwingConstants.CENTER);
		intervenant.add(lblNewLabel1Intervenant);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		intervenant.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention=new DBAINTERVENTION();
			}
		});
		btnNewButton.setBounds(101, 305, 84, 23);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		intervenant.add(btnNewButton);
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererIntervenant fInsererIntervenant= new InsererIntervenant();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		intervenant.add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM Intervenants");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}



		JPanel intervention = new JPanel();
		layeredPane.add(intervention, "name_1393742143025600");
intervention.setLayout(null);
		
		JLabel lblNewLabel1Intervention = new JLabel("Interventions");
		lblNewLabel1Intervention.setBounds(5, 12, 626, 18);
		lblNewLabel1Intervention.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1Intervention.setHorizontalAlignment(SwingConstants.CENTER);
		intervention.add(lblNewLabel1Intervention);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 42, 626, 255);
		intervention.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		
		btnNewButton = new JButton("Retour");
		btnNewButton.setBounds(111, 305, 84, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				DBAINTERVENTION fDbaintervention=new DBAINTERVENTION();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		intervention.add(btnNewButton);
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.setBounds(443, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererInterventions fInsererInterventions= new InsererInterventions();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		intervention.add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM Interventions");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}



		final JPanel requete = new JPanel();
		layeredPane.add(requete, "name_1392722723516900");
		requete.setLayout(
				new MigLayout("", "[57.00:n,grow][10.00:n][73.00px:82.00px][38px][3px][7px][48px][316px][10.00,grow][]",
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
		requete.add(comboBox, "cell 2 1 6 1,alignx left,aligny top");

		final JLabel lblDateDeDebut = new JLabel("Date de debut :");
		lblDateDeDebut.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");

		final JComboBox jourd = new JComboBox();
		jourd.setFont(new Font("Arial", Font.PLAIN, 11));
		jourd.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		requete.add(jourd, "cell 3 2 3 1,growx,aligny center");

		final JComboBox moisd = new JComboBox();
		moisd.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisd.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(moisd, "cell 6 2,growx,aligny center");

		final JComboBox anneed = new JComboBox();
		anneed.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneed.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(anneed, "cell 7 2,alignx left,aligny center");

		final JComboBox anneef = new JComboBox();
		anneef.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneef.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(anneef, "cell 7 3,alignx left,aligny center");

		final JComboBox moisf = new JComboBox();
		moisf.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisf.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(moisf, "cell 6 3,growx,aligny center");

		final JComboBox jourf = new JComboBox();
		jourf.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		jourf.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(jourf, "cell 3 3 3 1,growx,aligny center");

		final JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");

		final JLabel numText = new JLabel("Numéro de l'intervention :");
		numText.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(numText, "cell 2 4 3 1,alignx left,aligny center");

		final JTextField num = new JTextField();
		requete.add(num, "cell 5 4 3 1,alignx left,aligny top");
		num.setColumns(10);

		final JButton Exec = new JButton("Exécuter ");

		requete.add(Exec, "cell 6 5 2 1,alignx left,aligny top");

		final JScrollPane scrollPane = new JScrollPane();
		requete.add(scrollPane, "cell 1 6 8 1,grow");

		final JTable table = new JTable();
		scrollPane.setViewportView(table);

		scrollPane.setVisible(false);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedItem().toString()) {
				case "• Changer la date et l’heure de l’intervention": {
					scrollPane.setVisible(false);
					requete.add(scrollPane, "cell 1 6 8 1,grow");
					requete.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");
					lblDateDeDebut.setVisible(true);
					requete.add(jourd, "cell 3 2 3 1,growx,aligny center");
					jourd.setVisible(true);
					requete.add(moisd, "cell 6 2,growx,aligny center");
					moisd.setVisible(true);
					requete.add(anneed, "cell 7 2,alignx left,aligny center");
					anneed.setVisible(true);
					requete.add(anneef, "cell 7 3,alignx left,aligny center");
					anneef.setVisible(true);
					requete.add(moisf, "cell 6 3,growx,aligny center");
					moisf.setVisible(true);
					requete.add(jourf, "cell 3 3 3 1,growx,aligny center");
					jourf.setVisible(true);
					requete.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");
					lblDateDeFin.setVisible(true);
					requete.add(numText, "cell 2 4 3 1,alignx left,aligny center");
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					requete.add(num, "cell 5 4 3 1,alignx left,aligny top");
					num.setVisible(true);
					requete.add(Exec, "cell 6 5 2 1,alignx left,aligny top");
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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
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
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");

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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
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
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");

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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					requete.add(numText, "cell 2 2 3 1,alignx left,aligny center");
					num.setVisible(true);
					requete.add(num, "cell 5 2 3 1,alignx left,aligny top");
					Exec.setVisible(true);
					requete.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					requete.add(scrollPane, "cell 2 4 6 4,grow ");
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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
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
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");

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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
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
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");

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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
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
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");

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
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'employé :");
					requete.add(numText, "cell 2 2 3 1,alignx left,aligny center");
					num.setVisible(true);
					requete.add(num, "cell 5 2 3 1,alignx left,aligny top");
					Exec.setVisible(true);
					requete.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					requete.add(scrollPane, "cell 2 4 6 4,grow ");
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
					requete.add(scrollPane, "cell 1 5 8 1,grow");
					requete.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");
					lblDateDeDebut.setVisible(true);
					requete.add(jourd, "cell 3 2 3 1,growx,aligny center");
					jourd.setVisible(true);
					requete.add(moisd, "cell 6 2,growx,aligny center");
					moisd.setVisible(true);
					requete.add(anneed, "cell 7 2,alignx left,aligny center");
					anneed.setVisible(true);
					requete.add(anneef, "cell 7 3,alignx left,aligny center");
					anneef.setVisible(true);
					requete.add(moisf, "cell 6 3,growx,aligny center");
					moisf.setVisible(true);
					requete.add(jourf, "cell 3 3 3 1,growx,aligny center");
					jourf.setVisible(true);
					requete.add(lblDateDeFin, "cell 2 3,alignx left,aligny center");
					lblDateDeFin.setVisible(false);
					requete.add(numText, "cell 9 5 3 1,alignx left,aligny center");
					numText.setVisible(false);
					numText.setText("Numéro de l'intervention :");
					requete.add(num, "cell 9 5 3 1,alignx left,aligny top");
					num.setVisible(true);
					requete.add(Exec, "cell 6 4 2 1,alignx left,aligny top");
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
