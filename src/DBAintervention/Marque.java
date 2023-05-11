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

public class Marque {

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
					Marque window = new Marque();
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
	public Marque() {
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
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Marque");
		lblNewLabel.setBounds(7, 16, 626, 18);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 46, 626, 255);
		frame.getContentPane().add(scrollPane);
		
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
		frame.getContentPane().add(btnNewButton);
		
		
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
		frame.getContentPane().add(btnInserer);
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
		stmt=connection.createStatement();
		rs=stmt.executeQuery("SELECT * FROM Marque");
		table.setModel(DbUtils.resultSetToTableModel(rs));}
		catch(Exception E) {
			E.printStackTrace();
		}
	}

}
