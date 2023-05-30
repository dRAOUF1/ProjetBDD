package Employes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import DBAintervention.InsererClient;
import DBAintervention.InsererEmploye;
import component.ModernButton;
import component.ModernTextField;
import component.MyJTable;

import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormSpecs;
import component.*;
import javax.swing.DefaultComboBoxModel;

public class RechercherEmploye {

	private JFrame frame;
	private JTable tableEmploye;
	private JTable tableInt;
	private JLabel lblNewLabel_2;
	private JScrollPane tabl;
	private JScrollPane table;
	private JTextField numemp;

	private Connection connection = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private JButton btnRecherceher;
	private ModernButton btnNewButton_1;
	private ModernButton btnNewButton_2;
	private JPanel maj;
	JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercherEmploye window = new RechercherEmploye();
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
	public RechercherEmploye() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 717, 320);
		frame.setBackground(new Color(195, 214, 245));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(195, 214, 245));
		frame.getContentPane().setLayout(new MigLayout("", "[80.00:84.00][grow]", "[grow]"));

		JSplitPane splitPane = new JSplitPane();
		frame.getContentPane().add(splitPane, "cell 0 0 2 1,grow");
		splitPane.setBackground(new Color(195, 214, 245));
		splitPane.setDividerSize(1);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		panel.setBackground(new Color(195, 214, 245));
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("132px:grow"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("max(5dlu;default)"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, RowSpec.decode("6dlu"), FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		btnRecherceher = new ModernButton("Recherche un employé");

		panel.add(btnRecherceher, "1, 4");

		btnNewButton_1 = new ModernButton("Mettre à jour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InsererEmploye fInsererEmploye = new InsererEmploye();

				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		btnNewButton_1.setText("Insérer un employé");
		panel.add(btnNewButton_1, "1, 6");

		btnNewButton_2 = new ModernButton("Mettre à jour");
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton_2.setText("Mettre à jour \r\nun employé");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changerPannel(maj);
				} catch (Exception E) {
					E.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton_2, "1, 8");

		layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setBackground(new Color(195, 214, 245));

		final JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_1422538456230300");
		panel_1.setLayout(new MigLayout("", "[115.00][391.00px,grow][9.00:8.00][108px]",
				"[9.00][19px][11px][36px,grow][11px][85px,grow][][]"));
		panel_1.setBackground(new Color(195, 214, 245));
		JLabel lblNewLabel = new JLabel("Entrer un numéro d'employé :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblNewLabel, "cell 0 1,alignx left,aligny center");

		numemp = new ModernTextField();
		numemp.setMaximumSize(new Dimension(1500, 17));
		panel_1.add(numemp, "cell 1 1,growx,aligny center");
		numemp.setColumns(10);

		JButton btnNewButton = new ModernButton("Rechercher");
		btnNewButton.setMaximumSize(new Dimension(75, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection = DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					rs = stmt.executeQuery("SELECT * FROM EMPLOYE where NUMEMPLOYE=" + numemp.getText());
					tableEmploye.setModel(DbUtils.resultSetToTableModel(rs));
					rs = stmt.executeQuery("SELECT * FROM INTERVENANTS where NUMEMPLOYE=" + numemp.getText());
					tableInt.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception E) {
					E.printStackTrace();
				}

			}
		});

		btnRecherceher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changerPannel(panel_1);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(btnNewButton, "cell 3 1,alignx left,aligny center");

		JLabel lblNewLabel_1 = new JLabel("Informations de l'employé :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel_1.add(lblNewLabel_1, "cell 0 2,alignx left,growy");

		table = new JScrollPane();
		panel_1.add(table, "cell 0 3 4 1,grow");

		tableEmploye = new MyJTable();
		table.setViewportView(tableEmploye);
		tableEmploye.setFont(new Font("Arial", Font.PLAIN, 12));

		lblNewLabel_2 = new JLabel("Informations de l'intervenant :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		panel_1.add(lblNewLabel_2, "cell 0 4,alignx left,growy");

		tabl = new JScrollPane();
		panel_1.add(tabl, "cell 0 5 4 1,grow");

		tableInt = new MyJTable();
		tabl.setViewportView(tableInt);
		tableInt.setFont(new Font("Arial", Font.PLAIN, 12));

		maj = new JPanel();
		layeredPane.add(maj, "name_1473949022574300");
		maj.setLayout(new MigLayout("", "[86.00:n][115.00][208.00px:230.00px,grow][130.00px][108px,grow]",
				"[][12px][12px][14px][][12px][][]"));
		maj.setBackground(new Color(195, 214, 245));

		maj.setBackground(new Color(195, 214, 245));

		maj.setBounds(100, 100, 308, 366);

		JLabel lblNewLabel_11 = new JLabel("Numéro :");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(52, 28, 111, 11);
		maj.add(lblNewLabel_11, "cell 1 1,alignx left,aligny center");

		final ModernTextField num = new ModernTextField();
		num.setToolTipText("");
		num.setColumns(10);
		num.setBounds(52, 42, 180, 17);
		maj.add(num, "cell 2 1,growx");

		JLabel lblNewLabel_1_2 = new JLabel("Nom :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 67, 111, 11);
		maj.add(lblNewLabel_1_2, "cell 1 2,alignx left,aligny center");

		final ModernTextField nom = new ModernTextField();
		nom.setToolTipText("");
		nom.setColumns(10);
		nom.setBounds(52, 81, 180, 17);
		maj.add(nom, "cell 2 2,growx");

		JButton btnMajNom = new ModernButton("Inserer");
		btnMajNom.setText("Mettre à jour");
		

		btnMajNom.setFont(new Font("Arial", Font.PLAIN, 10));
		btnMajNom.setBounds(94, 255, 84, 23);
		maj.add(btnMajNom, "cell 3 2,alignx center,aligny center");

		JLabel lblNewLabel_1_3 = new JLabel("Prenom :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 106, 111, 11);
		maj.add(lblNewLabel_1_3, "cell 1 3,alignx left,aligny center");

		final ModernTextField prenom = new ModernTextField();
		prenom.setToolTipText("");
		prenom.setColumns(10);
		prenom.setBounds(52, 120, 180, 17);
		maj.add(prenom, "cell 2 3,growx");

		ModernButton btnMajPrenom = new ModernButton("Inserer");
		btnMajPrenom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection = DriverManager.getConnection(
							"jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					rs = stmt.executeQuery("UPDATE EMPLOYE SET PRENOMEMP='"+prenom.getText()+"' WHERE NUMEMPLOYE=" + num.getText());
					rs = stmt.executeQuery("commit");

				} catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");
				}
			}
		});
		btnMajPrenom.setText("Mettre à jour");
		btnMajPrenom.setFont(new Font("Arial", Font.PLAIN, 10));
		maj.add(btnMajPrenom, "cell 3 3,alignx center,aligny center");

		JLabel lblNewLabel_1_4 = new JLabel("Catégorie :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 145, 111, 11);
		maj.add(lblNewLabel_1_4, "cell 1 4,alignx left,aligny center");

		final ModernComboBox categorie = new ModernComboBox();
		categorie.setFont(new Font("Arial", Font.PLAIN, 12));
		categorie.setModel(new DefaultComboBoxModel(new String[] { "Mécanicien", "Assistant" }));
		categorie.setBounds(52, 159, 180, 17);
		maj.add(categorie, "cell 2 4,growx");

		ModernButton btnMajCat = new ModernButton("Inserer");
		btnMajCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection = DriverManager.getConnection(
							"jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					rs = stmt.executeQuery("UPDATE EMPLOYE SET CATEGORIE='"+categorie.getSelectedItem().toString()+"' WHERE NUMEMPLOYE=" + num.getText());
					rs = stmt.executeQuery("commit");

				} catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");
				}
			}
		});
		btnMajCat.setText("Mettre à jour");
		btnMajCat.setFont(new Font("Arial", Font.PLAIN, 10));
		maj.add(btnMajCat, "cell 3 4,alignx center,aligny center");

		JLabel lblNewLabel_1_5 = new JLabel("Salaire :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 184, 111, 11);
		maj.add(lblNewLabel_1_5, "cell 1 5,alignx left,aligny center");

		final ModernTextField salaire = new ModernTextField();
		salaire.setToolTipText("");
		salaire.setColumns(10);
		salaire.setBounds(52, 198, 180, 17);
		maj.add(salaire, "cell 2 5,growx");

		ModernButton btnMajSalaire = new ModernButton("Inserer");
		btnMajSalaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection = DriverManager.getConnection(
							"jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					rs = stmt.executeQuery("UPDATE EMPLOYE SET SALAIRE='"+salaire.getText()+"' WHERE NUMEMPLOYE=" + num.getText());
					rs = stmt.executeQuery("commit");

				} catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");
				}
			}
		});
		btnMajSalaire.setText("Mettre à jour");
		btnMajSalaire.setFont(new Font("Arial", Font.PLAIN, 10));
		maj.add(btnMajSalaire, "cell 3 5,alignx center,aligny center");
		
		btnMajNom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection = DriverManager.getConnection(
							"jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt = connection.createStatement();
					rs = stmt.executeQuery("UPDATE EMPLOYE SET NOMEMP='"+nom.getText()+"' WHERE NUMEMPLOYE=" + num.getText());
					rs = stmt.executeQuery("commit");

				} catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");
				}

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
