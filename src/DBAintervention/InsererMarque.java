package DBAintervention;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import component.ModernButton;
import component.ModernTextField;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class InsererMarque {

	private JFrame frmNouvelleMarque;
	private JTextField num;
	private JTextField marque;
	private JTextField pays;
	
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
					InsererMarque window = new InsererMarque();
					window.frmNouvelleMarque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsererMarque() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouvelleMarque = new JFrame();
		frmNouvelleMarque.setTitle("Nouvelle marque");
		frmNouvelleMarque.setBackground(new Color(195, 214, 245));
		frmNouvelleMarque.getContentPane().setBackground(new Color(195, 214, 245));
		frmNouvelleMarque.setBounds(100, 100, 304, 263);
		frmNouvelleMarque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouvelleMarque.getContentPane().setLayout(null);
		frmNouvelleMarque.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 111, 11);
		frmNouvelleMarque.getContentPane().add(lblNewLabel_1);
		
		num = new ModernTextField();
		num.setToolTipText("");
		num.setColumns(10);
		num.setBounds(52, 42, 180, 17);
		frmNouvelleMarque.getContentPane().add(num);
		
		JLabel lblNewLabel_1_1 = new JLabel("Marque :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 71, 111, 11);
		frmNouvelleMarque.getContentPane().add(lblNewLabel_1_1);
		
		marque = new ModernTextField();
		marque.setToolTipText("");
		marque.setColumns(10);
		marque.setBounds(52, 85, 180, 17);
		frmNouvelleMarque.getContentPane().add(marque);
		
		JLabel lblNewLabel_1_2 = new JLabel("Pays :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 114, 111, 11);
		frmNouvelleMarque.getContentPane().add(lblNewLabel_1_2);
		
		pays = new ModernTextField();
		pays.setToolTipText("");
		pays.setColumns(10);
		pays.setBounds(52, 128, 180, 17);
		frmNouvelleMarque.getContentPane().add(pays);
		
		
		JButton btnInserer = new ModernButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO Marque VALUES("+num.getText()+",'"+marque.getText()+"','"+pays.getText()+"')");
					rs=stmt.executeQuery("commit");
     
					frmNouvelleMarque.dispose();
					
				}catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");}
				
				
			}
		});
		
		frmNouvelleMarque.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNouvelleMarque.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        frmNouvelleMarque.dispose(); // ferme la fenêtre principale sans quitter l'application
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(98, 170, 84, 23);
		frmNouvelleMarque.getContentPane().add(btnInserer);
	}
}
