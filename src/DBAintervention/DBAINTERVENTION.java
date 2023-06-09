package DBAintervention;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jgoodies.forms.layout.*;

import component.MonBoutton;
import component.MaComboBox;
import component.MonTextField;
import component.MonTableau;

import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class DBAINTERVENTION {

	private JFrame frame;
	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JTextField num;
	private JScrollPane scrollPane;
	JLayeredPane layeredPane;
	private MonBoutton btnClient;

	private JPanel client;
	private JPanel Employe;
	private JPanel marque;
	private JPanel modele;
	private JPanel vehicule;
	private JPanel intervenant;
	private JPanel intervention;
	private JPanel requete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBAINTERVENTION window = new DBAINTERVENTION();
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
	public DBAINTERVENTION() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(195, 214, 245));
		frame.setBackground(new Color(195, 214, 245));
		frame.setBounds(100, 100, 763, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		frame.setVisible(true);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(195, 214, 245));
		frame.getContentPane().add(splitPane, "cell 0 0,grow");
		splitPane.setDividerSize(1);

		final JPanel panel = new JPanel();
		panel.setBackground(new Color(0xC3D6F5));
		splitPane.setLeftComponent(panel);
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("108px"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("5px"), },
				new RowSpec[] { RowSpec.decode("28dlu"), RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"),
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("21px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), }));

		MonBoutton btnNewButton;
		btnClient = new MonBoutton("Clients");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(client);
			}
		});
		btnClient.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnClient, "2, 2, fill, fill");

		MonBoutton btnEmploye = new MonBoutton("Employés");
		btnEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(Employe);
			}
		});
		btnEmploye.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnEmploye, "2, 4, fill, fill");

		MonBoutton btnMarque = new MonBoutton("Marques");
		btnMarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(marque);
			}
		});
		btnMarque.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnMarque, "2, 6, fill, top");

		MonBoutton btnModele = new MonBoutton("Modèles");
		btnModele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(modele);
			}
		});
		btnModele.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnModele, "2, 8, fill, default");

		MonBoutton btnVehicule = new MonBoutton("Véhicules");
		btnVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(vehicule);
			}
		});
		btnVehicule.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnVehicule, "2, 10, fill, default");

		MonBoutton btnIntervenant = new MonBoutton("Intervenants");
		btnIntervenant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(intervenant);
			}
		});
		btnIntervenant.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnIntervenant, "2, 12, fill, default");

		MonBoutton btnIntervention = new MonBoutton("Interventions");
		btnIntervention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(intervention);
			}
		});
		btnIntervention.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnIntervention, "2, 14, fill, default");

		MonBoutton btnRequete = new MonBoutton("Requêtes");
		btnRequete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changerPannel(requete);
			}
		});
		btnRequete.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(btnRequete, "2, 16, fill, default");

		layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));

		client = new JPanel();
		client.setBackground(new Color(0xC3D6F5));
		layeredPane.add(client, "name_1394139862364500");
		client.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][271.00px,grow][23px]"));

		JLabel lblNewLabel = new JLabel("Client");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		client.add(lblNewLabel, "cell 0 0 3 1,growx,aligny top");

		scrollPane = new JScrollPane();
		JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
		verticalScrollBar.setPreferredSize(new Dimension(0, 0));

		client.add(scrollPane, "cell 0 1 3 1,grow");

		final MonTableau tableClient = new MonTableau();
		scrollPane.setViewportView(tableClient);

		MonBoutton btnInserer = new MonBoutton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererClient fInsererClient = new InsererClient();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		MonBoutton btnRefreshClient = new MonBoutton("Actualisé ");
		btnRefreshClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM client");
					tableClient.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnRefreshClient.setFont(new Font("Arial", Font.PLAIN, 12));
		client.add(btnRefreshClient, "cell 0 2,alignx right,aligny center");
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		client.add(btnInserer, "cell 2 2,alignx left,aligny center");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM CLIENT");
			tableClient.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		Employe = new JPanel();
		Employe.setBackground(new Color(0xC3D6F5));
		layeredPane.add(Employe, "name_1393584470435300");
		Employe.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		JLabel lblNewLabel1 = new JLabel("Employé");
		lblNewLabel1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		Employe.add(lblNewLabel1, "cell 0 0 3 1,growx,aligny top");

		scrollPane = new JScrollPane();
		Employe.add(scrollPane, "cell 0 1 3 1,grow");
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));

		final MonTableau tableEmploye = new MonTableau();
		scrollPane.setViewportView(tableEmploye);
		tableEmploye.setFont(new Font("Arial", Font.PLAIN, 12));

		btnInserer = new MonBoutton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererEmploye fInsererEmploye = new InsererEmploye();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		MonBoutton btnRefreshEmploye = new MonBoutton("Actualisé ");
		btnRefreshEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM Employe");
					tableEmploye.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}

		});
		btnRefreshEmploye.setFont(new Font("Arial", Font.PLAIN, 12));
		Employe.add(btnRefreshEmploye, "cell 0 2,alignx right,aligny center");
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		Employe.add(btnInserer, "cell 2 2,alignx left,aligny top");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMPLOYE");
			tableEmploye.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		marque = new JPanel();
		marque.setBackground(new Color(0xC3D6F5));
		layeredPane.add(marque, "name_1393635257920800");
		marque.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		JLabel lblNewLabelMarque = new JLabel("Marque");
		lblNewLabelMarque.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelMarque.setHorizontalAlignment(SwingConstants.CENTER);
		marque.add(lblNewLabelMarque, "cell 1 0,growx,aligny top");

		scrollPane = new JScrollPane();
		marque.add(scrollPane, "cell 0 1 3 1,grow");
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));

		final MonTableau tableMarque = new MonTableau();
		scrollPane.setViewportView(tableMarque);
		tableMarque.setFont(new Font("Arial", Font.PLAIN, 12));
		tableMarque.setModel(DbUtils.resultSetToTableModel(rs));
		tableMarque.setFont(new Font("Arial", Font.PLAIN, 12));
		tableMarque.setModel(DbUtils.resultSetToTableModel(rs));

		MonBoutton btnRefreshMarque = new MonBoutton("Actualisé ");
		btnRefreshMarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM marque");
					tableMarque.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}

		});
		btnRefreshMarque.setFont(new Font("Arial", Font.PLAIN, 12));
		marque.add(btnRefreshMarque, "cell 0 2,alignx right,aligny center");

		btnInserer = new MonBoutton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererMarque fInsererMarque = new InsererMarque();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		marque.add(btnInserer, "cell 2 2,alignx left,aligny center");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Marque");
			tableMarque.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		modele = new JPanel();
		modele.setBackground(new Color(0xC3D6F5));
		layeredPane.add(modele, "name_1393637987395500");
		modele.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		MonBoutton btnRefreshModele = new MonBoutton("Actualisé ");

		JLabel lblNewLabelModele = new JLabel("Modèle ");
		lblNewLabelModele.setBounds(7, 16, 626, 18);
		lblNewLabelModele.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelModele.setHorizontalAlignment(SwingConstants.CENTER);
		modele.add(lblNewLabelModele, "cell 1 0,growx");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		modele.add(scrollPane, "cell 0 1 3 1,grow");

		final MonTableau tableModele = new MonTableau();
		scrollPane.setViewportView(tableModele);
		btnRefreshModele.setFont(new Font("Arial", Font.PLAIN, 12));

		btnRefreshModele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM modele");
					tableModele.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		modele.add(btnRefreshModele, "cell 0 2,alignx right,aligny center");

		btnInserer = new MonBoutton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererModele fInsererModele = new InsererModele();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		modele.add(btnInserer, "cell 2 2");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM modele");
			tableModele.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		vehicule = new JPanel();
		vehicule.setBackground(new Color(195, 214, 245));
		layeredPane.add(vehicule, "name_1393640284669700");
		vehicule.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[:18px:18px][255px,grow][23px]"));

		JLabel lblNewLabelVehicule = new JLabel("Véhicule ");
		lblNewLabelVehicule.setBounds(7, 16, 626, 18);
		lblNewLabelVehicule.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabelVehicule.setHorizontalAlignment(SwingConstants.CENTER);
		vehicule.add(lblNewLabelVehicule, "cell 1 0,growx");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		vehicule.add(scrollPane, "cell 0 1 3 1,grow");

		final MonTableau tableVehicule = new MonTableau();
		scrollPane.setViewportView(tableVehicule);
		tableVehicule.setFont(new Font("Arial", Font.PLAIN, 12));
		tableVehicule.setModel(DbUtils.resultSetToTableModel(rs));

		MonBoutton btnRefreshVehicule = new MonBoutton("Actualisé ");
		btnRefreshVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM vehicule");
					tableVehicule.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		btnRefreshVehicule.setFont(new Font("Arial", Font.PLAIN, 12));
		vehicule.add(btnRefreshVehicule, "cell 0 2,alignx right,aligny center");

		btnInserer = new MonBoutton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererVehicule fInsererVehicule = new InsererVehicule();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		vehicule.add(btnInserer, "cell 2 2");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM vehicule");
			tableVehicule.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		intervenant = new JPanel();
		intervenant.setBackground(new Color(0xC3D6F5));
		layeredPane.add(intervenant, "name_1393738788754100");
		intervenant.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		JLabel lblNewLabel1Intervenant = new JLabel("Intervenants");
		lblNewLabel1Intervenant.setBounds(7, 16, 626, 18);
		lblNewLabel1Intervenant.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1Intervenant.setHorizontalAlignment(SwingConstants.CENTER);
		intervenant.add(lblNewLabel1Intervenant, "cell 1 0,growx");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		intervenant.add(scrollPane, "cell 0 1 3 1,grow");

		final MonTableau tableIntervenant = new MonTableau();
		scrollPane.setViewportView(tableIntervenant);
		tableIntervenant.setFont(new Font("Arial", Font.PLAIN, 12));
		tableIntervenant.setModel(DbUtils.resultSetToTableModel(rs));

		MonBoutton btnRefreshIntervenant = new MonBoutton("Actualisé ");
		btnRefreshIntervenant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM intervenants");
					tableIntervenant.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		btnRefreshIntervenant.setFont(new Font("Arial", Font.PLAIN, 12));
		intervenant.add(btnRefreshIntervenant, "cell 0 2,alignx right,aligny center");

		btnInserer = new MonBoutton("Inserer");
		btnInserer.setBounds(450, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererIntervenant fInsererIntervenant = new InsererIntervenant();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		intervenant.add(btnInserer, "cell 2 2");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Intervenants");
			tableIntervenant.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		intervention = new JPanel();
		intervention.setBackground(new Color(0xC3D6F5));
		layeredPane.add(intervention, "name_1393742143025600");
		intervention.setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));

		JLabel lblNewLabel1Intervention = new JLabel("Interventions");
		lblNewLabel1Intervention.setBounds(5, 12, 626, 18);
		lblNewLabel1Intervention.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel1Intervention.setHorizontalAlignment(SwingConstants.CENTER);
		intervention.add(lblNewLabel1Intervention, "cell 1 0,growx");

		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 42, 626, 255);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		intervention.add(scrollPane, "cell 0 1 3 1,grow");

		final MonTableau tableInterventions = new MonTableau();
		scrollPane.setViewportView(tableInterventions);
		tableInterventions.setFont(new Font("Arial", Font.PLAIN, 12));
		tableInterventions.setModel(DbUtils.resultSetToTableModel(rs));

		MonBoutton btnRefreshInterventions = new MonBoutton("Actualisé ");
		btnRefreshInterventions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs = stmt.executeQuery("SELECT * FROM interventions");
					tableInterventions.setModel(DbUtils.resultSetToTableModel(rs));

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnRefreshInterventions.setFont(new Font("Arial", Font.PLAIN, 12));
		intervention.add(btnRefreshInterventions, "cell 0 2,alignx right,aligny center");

		btnInserer = new MonBoutton("Inserer");
		btnInserer.setBounds(443, 305, 84, 23);
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					InsererInterventions fInsererInterventions = new InsererInterventions();
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		intervention.add(btnInserer, "cell 2 2");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Interventions");
			tableInterventions.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception E) {
			E.printStackTrace();
		}

		requete = new JPanel();
		requete.setBackground(new Color(0xC3D6F5));
		layeredPane.add(requete, "name_1392722723516900");
		requete.setLayout(new MigLayout("",
				"[57.00:n,grow][10.00:n][73.00px:93.00px][38px,grow][3px][7px][48px,grow][316px][10.00,grow][]",
				"[][20px][18px][][18px][][17px][19px][136px]"));

		final JComboBox comboBox = new MaComboBox();
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
		requete.add(comboBox, "cell 2 1 6 1,alignx left,aligny center");

		final JLabel lblDateDeDebut = new JLabel("Date de début :");
		lblDateDeDebut.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");

		final JComboBox jourd = new MaComboBox();
		jourd.setFont(new Font("Arial", Font.PLAIN, 11));
		jourd.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		requete.add(jourd, "cell 3 2 3 1,growx,aligny center");

		final JComboBox moisd = new MaComboBox();
		moisd.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisd.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(moisd, "cell 6 2,growx,aligny center");

		final JComboBox anneed = new MaComboBox();
		anneed.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneed.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(anneed, "cell 7 2,alignx left,aligny center");

		final JLabel lblHeureDeDebut = new JLabel("Heure de début :");
		lblHeureDeDebut.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblHeureDeDebut, "cell 2 3,alignx left");

		final MaComboBox heured = new MaComboBox();
		heured.setModel(new DefaultComboBoxModel(new String[] { "Heure", "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		heured.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(heured, "cell 3 3 3 1,growx");

		final MaComboBox mind = new MaComboBox();
		mind.setModel(new DefaultComboBoxModel(
				new String[] { "Minute", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
						"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
						"29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
						"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		mind.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(mind, "cell 6 3,growx");

		final JComboBox anneef = new MaComboBox();
		anneef.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		anneef.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(anneef, "cell 7 4,alignx left,aligny center");

		final JComboBox moisf = new MaComboBox();
		moisf.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		moisf.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(moisf, "cell 6 4,growx,aligny center");

		final JComboBox jourf = new MaComboBox();
		jourf.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		jourf.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(jourf, "cell 3 4 3 1,growx,aligny center");

		final JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblDateDeFin, "cell 2 4,alignx left,aligny center");

		final JLabel lblHeureDeFin = new JLabel("Heure de fin :");
		lblHeureDeFin.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(lblHeureDeFin, "cell 2 5,alignx left");

		final MaComboBox heuref = new MaComboBox();
		heuref.setModel(new DefaultComboBoxModel(new String[] { "Heure", "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		heuref.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(heuref, "cell 3 5 3 1,growx");

		final MaComboBox minf = new MaComboBox();
		minf.setModel(new DefaultComboBoxModel(
				new String[] { "Minute", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12",
						"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28",
						"29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44",
						"45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
		minf.setFont(new Font("Arial", Font.PLAIN, 11));
		requete.add(minf, "cell 6 5,growx");

		final JLabel numText = new JLabel("Numéro de l'intervention :");
		numText.setFont(new Font("Arial", Font.PLAIN, 12));
		requete.add(numText, "cell 2 6 3 1,alignx left,aligny center");

		final JTextField num = new MonTextField();
		requete.add(num, "cell 5 6 3 1,alignx left,aligny top");
		num.setColumns(10);

		final MonBoutton Exec = new MonBoutton("Exécuter ");
		Exec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					String datedebString = jourd.getSelectedItem().toString() + "-" + moisd.getSelectedItem().toString()
							+ "-" + anneed.getSelectedItem().toString();
					String datefinString = jourf.getSelectedItem().toString() + "-" + moisf.getSelectedItem().toString()
							+ "-" + anneef.getSelectedItem().toString();
					String sqlString = String.format(
							"Update interventions set DATEDEBINTERV=TO_DATE('%s %s:%s','DD-MM-RRRR HH24:MI') where NUMINTERVENTION=%s",
							datedebString, heured.getSelectedItem().toString(), mind.getSelectedItem().toString(),
							num.getText());
					rs = stmt.executeQuery(sqlString);

					sqlString = String.format(
							"Update interventions set DATEFININTERV=TO_DATE('%s %s:%s','DD-MM-RRRR HH24:MI') where NUMINTERVENTION=%s",
							datefinString, heuref.getSelectedItem().toString(), minf.getSelectedItem().toString(),
							num.getText());
					;
					rs = stmt.executeQuery(sqlString);

					System.out.println(sqlString);

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});

		requete.add(Exec, "cell 6 7 2 1,alignx left,aligny top");

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
		requete.add(scrollPane, "cell 1 8 7 1,grow");

		final MonTableau table = new MonTableau();
		scrollPane.setViewportView(table);

		scrollPane.setVisible(false);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (comboBox.getSelectedItem().toString()) {
				case "• Changer la date et l’heure de l’intervention": {
					scrollPane.setVisible(false);
					requete.remove(scrollPane);
					requete.add(lblDateDeDebut, "cell 2 2,alignx left,aligny center");
					lblDateDeDebut.setVisible(true);
					requete.add(jourd, "cell 3 2 3 1,growx,aligny center");
					jourd.setVisible(true);
					requete.add(moisd, "cell 6 2,growx,aligny center");
					moisd.setVisible(true);
					requete.add(anneed, "cell 7 2,alignx left,aligny center");
					anneed.setVisible(true);
					requete.add(anneef, "cell 7 4,alignx left,aligny center");
					anneef.setVisible(true);
					requete.add(moisf, "cell 6 4,growx,aligny center");
					moisf.setVisible(true);
					requete.add(jourf, "cell 3 4 3 1,growx,aligny center");
					jourf.setVisible(true);
					requete.add(lblDateDeFin, "cell 2 4,alignx left,aligny center");
					lblDateDeFin.setVisible(true);
					requete.add(numText, "cell 2 6 3 1,alignx left,aligny center");
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					requete.add(num, "cell 5 6 3 1,alignx left,aligny top");
					num.setVisible(true);
					requete.add(heured, "cell 3 3 3 1,growx");
					heured.setVisible(true);
					requete.add(mind, "cell 6 3,growx");
					mind.setVisible(true);
					requete.add(heuref, "cell 3 5 3 1,growx");
					heuref.setVisible(true);
					requete.add(minf, "cell 6 5,growx");
					requete.add(lblHeureDeDebut, "cell 2 3,alignx left");
					requete.add(lblHeureDeFin, "cell 2 5,alignx left");
					minf.setVisible(true);
					requete.add(Exec, "cell 6 7 2 1,alignx left,aligny top");

					Exec.setVisible(true);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {
								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								String datedebString = jourd.getSelectedItem().toString() + "-"
										+ moisd.getSelectedItem().toString() + "-"
										+ anneed.getSelectedItem().toString();
								String datefinString = jourf.getSelectedItem().toString() + "-"
										+ moisf.getSelectedItem().toString() + "-"
										+ anneef.getSelectedItem().toString();
								String sqlString = String.format(
										"Update interventions set DATEDEBINTERV=TO_DATE('%s %s:%s','DD-MM-RRRR HH24:MI') where NUMINTERVENTION=%s",
										datedebString, heured.getSelectedItem().toString(),
										mind.getSelectedItem().toString(), num.getText());
								rs = stmt.executeQuery(sqlString);

								sqlString = String.format(
										"Update interventions set DATEFININTERV=TO_DATE('%s %s:%s','DD-MM-RRRR HH24:MI') where NUMINTERVENTION=%s",
										datefinString, heuref.getSelectedItem().toString(),
										minf.getSelectedItem().toString(), num.getText());
								;
								rs = stmt.executeQuery(sqlString);

								System.out.println(sqlString);

							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Afficher les noms et prénoms des employes ayant fait plus de 3 interventions": {
					scrollPane.setVisible(true);
					scrollPane.setViewportView(table);
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
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
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
					scrollPane.setViewportView(table);
					lblDateDeDebut.setVisible(false);
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					requete.add(scrollPane, "cell 2 2 6 4,grow ");
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
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
					requete.add(Exec, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(num, "cell 9 5 1 1,alignx left,aligny top");
					requete.add(numText, "cell 9 5 1 1,alignx left,aligny center");

					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
						stmt = connection.createStatement();
						rs = stmt.executeQuery("SELECT * FROM vehicule ");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						System.out.print(1);
					} catch (Exception E) {
						E.printStackTrace();
					}
					break;
				}
				case "• Afficher les détails d’une intervention": {
					scrollPane.setVisible(true);
					final JTable tableRequteIntervention = new MonTableau();
					scrollPane.setViewportView(tableRequteIntervention);
					lblDateDeDebut.setVisible(false);
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'intervention :");
					requete.add(numText, "cell 2 2 1 1,alignx left,aligny center");
					num.setVisible(true);
					requete.add(num, "cell 5 2 2 1,growx,aligny top");
					Exec.setVisible(true);
					requete.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					requete.add(scrollPane, "cell 1 4 8 4,grow ");


					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								rs = stmt.executeQuery(
										"SELECT * FROM interventions WHERE NUMINTERVENTION =" + num.getText());
								tableRequteIntervention.setModel(DbUtils.resultSetToTableModel(rs));
							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Afficher les modèles et leur marque": {
					scrollPane.setVisible(true);
					scrollPane.setViewportView(table);
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
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
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
					scrollPane.setViewportView(table);
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
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
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
					scrollPane.setViewportView(table);
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
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
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
					final JTable tableRequteInterventionEmploye = new MonTableau();
					scrollPane.setViewportView(tableRequteInterventionEmploye);
					lblDateDeDebut.setVisible(false);
					requete.add(lblDateDeDebut, "cell 9 6,alignx left,aligny center");
					jourd.setVisible(false);
					requete.remove(jourd);
					requete.remove(moisd);
					requete.remove(anneed);
					requete.remove(anneef);
					requete.remove(moisf);
					requete.remove(jourf);
					requete.remove(lblDateDeDebut);
					requete.remove(lblDateDeFin);
					moisd.setVisible(false);
					anneed.setVisible(false);
					anneef.setVisible(false);
					moisf.setVisible(false);
					jourf.setVisible(false);
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
					lblDateDeFin.setVisible(false);
					numText.setVisible(true);
					numText.setText("Numéro de l'employé :");
					requete.add(numText, "cell 2 2 3 1,alignx left,aligny center");
					num.setVisible(true);
					requete.add(num, "cell 5 2 3 1,alignx left,aligny top");
					Exec.setVisible(true);
					requete.add(Exec, "cell 6 3 2 1,alignx left,aligny top");
					requete.add(scrollPane, "cell 1 4 7 4,grow ");


					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								rs = stmt.executeQuery("SELECT * FROM intervenants WHERE numemploye =" + num.getText());
								tableRequteInterventionEmploye.setModel(DbUtils.resultSetToTableModel(rs));
								System.out.print(rs);
							} catch (Exception E) {
								E.printStackTrace();
							}
						}
					});
					break;
				}
				case "• Déterminer la liste des interventions faites dans une période donnée": {
					scrollPane.setVisible(true);
					scrollPane.setViewportView(table);
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
					lblDateDeFin.setVisible(true);
					requete.add(numText, "cell 9 5 3 1,alignx left,aligny center");
					numText.setVisible(false);
					numText.setText("Numéro de l'intervention :");
					requete.add(num, "cell 9 5 3 1,alignx left,aligny top");
					num.setVisible(false);
					requete.add(Exec, "cell 6 4 2 1,alignx left,aligny top");
					Exec.setVisible(true);
					requete.remove(heured);
					requete.remove(mind);
					requete.remove(heuref);
					requete.remove(minf);
					requete.remove(lblHeureDeFin);
					requete.remove(lblHeureDeDebut);
					DefaultTableModel model = new DefaultTableModel();
					table.setModel(model);

					Exec.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							try {

								Class.forName("oracle.jdbc.driver.OracleDriver");
								connection = DriverManager
										.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
								stmt = connection.createStatement();
								String datedebString = jourd.getSelectedItem().toString() + "-"
										+ moisd.getSelectedItem().toString() + "-"
										+ anneed.getSelectedItem().toString();
								String datefinString = jourf.getSelectedItem().toString() + "-"
										+ moisf.getSelectedItem().toString() + "-"
										+ anneef.getSelectedItem().toString();
								String sqlString = String.format(
										"select * from interventions where DATEDEBINTERV>'%s' and DATEFININTERV<'%s'",
										datedebString, datefinString);
								rs = stmt.executeQuery(sqlString);
								table.setModel(DbUtils.resultSetToTableModel(rs));
								System.out.print(sqlString);
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

	public void changerPannel(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
