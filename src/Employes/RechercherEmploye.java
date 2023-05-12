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

public class RechercherEmploye {

	private JFrame frame;
	private JTable tableEmploye;
	private JTable tableInt;
	private JLabel lblNewLabel_2;
	private JScrollPane tabl;
	private JScrollPane table;
	private JTextField numemp;
	
	private Connection connection=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private JButton btnRecherceher;
	private JButton btnNewButton_2;

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
		frame.setBounds(100, 100, 567, 310);
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
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("132px:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(5dlu;default)"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				RowSpec.decode("6dlu"),
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		btnRecherceher = new ModernButton("Recherche un employé");
		btnRecherceher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnRecherceher, "1, 4");
		
		btnNewButton_2 = new ModernButton("Mettre à jour");
		panel.add(btnNewButton_2, "1, 6");
		
		JLayeredPane layeredPane = new JLayeredPane();
		splitPane.setRightComponent(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		layeredPane.setBackground(new Color(195, 214, 245));
		
		JPanel panel_1 = new JPanel();
		layeredPane.add(panel_1, "name_1422538456230300");
		panel_1.setLayout(new MigLayout("", "[115.00][391.00px,grow][108px]", "[9.00][19px][11px][36px,grow][11px][85px,grow][][]"));
		panel_1.setBackground(new Color(195, 214, 245));
		JLabel lblNewLabel = new JLabel("Entrer un numéro d'employé :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(lblNewLabel, "cell 0 1,alignx left,aligny center");
		
		numemp = new ModernTextField();
		numemp.setMaximumSize(new Dimension(1500,17));
		panel_1.add(numemp, "cell 1 1,growx,aligny center");
		numemp.setColumns(10);
		
		JButton btnNewButton = new ModernButton("Rechercher");
		btnNewButton.setMaximumSize(new Dimension(75,22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("SELECT * FROM EMPLOYE where NUMEMPLOYE="+numemp.getText());
					tableEmploye.setModel(DbUtils.resultSetToTableModel(rs));
					rs=stmt.executeQuery("SELECT * FROM INTERVENANTS where NUMEMPLOYE="+numemp.getText());
					tableInt.setModel(DbUtils.resultSetToTableModel(rs));
				}
					catch(Exception E) {
						E.printStackTrace();
					}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(btnNewButton, "cell 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Informations de l'employé :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		panel_1.add(lblNewLabel_1, "cell 0 2,alignx left,growy");
		
		table = new JScrollPane();
		panel_1.add(table, "cell 0 3 3 1,grow");
		
		tableEmploye = new MyJTable();
		table.setViewportView(tableEmploye);
		tableEmploye.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNewLabel_2 = new JLabel("Informations de l'employé :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		panel_1.add(lblNewLabel_2, "cell 0 4,alignx left,growy");
		
		tabl = new JScrollPane();
		panel_1.add(tabl, "cell 0 5 3 1,grow");
		
		tableInt = new MyJTable();
		tabl.setViewportView(tableInt);
		tableInt.setFont(new Font("Arial", Font.PLAIN, 12));
		


		
		
	}
}
