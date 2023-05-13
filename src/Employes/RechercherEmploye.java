package Employes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
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
		frame.setBounds(100, 100, 529, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[115.00][391.00px,grow][108px]", "[9.00][19px][11px][36px,grow][11px][85px,grow][][]"));
		
		JLabel lblNewLabel = new JLabel("Entrer un numéro d'employé :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel, "cell 0 1,alignx trailing,aligny center");
		
		numemp = new JTextField();
		frame.getContentPane().add(numemp, "cell 1 1,grow");
		numemp.setColumns(10);
		
		JButton btnNewButton = new JButton("Rechercher");
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
		frame.getContentPane().add(btnNewButton, "cell 2 1,alignx left,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Informations de l'employé :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_1, "cell 0 2,alignx left,growy");
		
		table = new JScrollPane();
		frame.getContentPane().add(table, "cell 0 3 3 1,grow");
		
		tableEmploye = new JTable();
		table.setViewportView(tableEmploye);
		tableEmploye.setFont(new Font("Arial", Font.PLAIN, 12));
		
		lblNewLabel_2 = new JLabel("Informations de l'employé :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(lblNewLabel_2, "cell 0 4,alignx left,growy");
		
		tabl = new JScrollPane();
		frame.getContentPane().add(tabl, "cell 0 5 3 1,grow");
		
		tableInt = new JTable();
		tabl.setViewportView(tableInt);
		tableInt.setFont(new Font("Arial", Font.PLAIN, 12));
	}
}
