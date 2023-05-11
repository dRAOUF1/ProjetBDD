package DBAintervention;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

public class Employe {

	private JFrame frame;
	private JTable table;
	private JButton btnNewButton;
	private JButton btnInserer;

	private Connection connection=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employe window = new Employe();
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
	public Employe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 654, 404);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(new MigLayout("", "[178px][265px,grow][183px]", "[18px][255px,grow][23px]"));
		
		JLabel lblNewLabel = new JLabel("Employé");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, "cell 0 0 3 1,growx,aligny top");
		
		scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, "cell 0 1 3 1,grow");
		
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
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(btnNewButton, "cell 0 2,alignx right,aligny top");
		
		
		btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					frame.dispose();
					InsererEmploye fInsererEmploye= new InsererEmploye();
					
					}
				catch (Exception E) {
				E.printStackTrace();}
			}
		});
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		frame.getContentPane().add(btnInserer, "cell 2 2,alignx left,aligny top");
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM EMPLOYE");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}
	}

}
