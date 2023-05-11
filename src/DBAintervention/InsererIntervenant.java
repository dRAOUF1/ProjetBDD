package DBAintervention;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsererIntervenant {

	private JFrame frmNouveauClient;
	private JTextField NUMINTERVENTION;
	private JTextField NUMEMPLOYE;
	private JTextField DATEDEBUT;
	private JTextField DATEFIN;
	
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
					InsererIntervenant window = new InsererIntervenant();
					window.frmNouveauClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsererIntervenant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauClient = new JFrame();
		frmNouveauClient.setTitle("Nouvel intervenant");
		frmNouveauClient.setBounds(100, 100, 308, 298);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro de l'intervention :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 151, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		NUMINTERVENTION = new JTextField();
		NUMINTERVENTION.setToolTipText("");
		NUMINTERVENTION.setColumns(10);
		NUMINTERVENTION.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(NUMINTERVENTION);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numéro de l'employé :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 67, 137, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		NUMEMPLOYE = new JTextField();
		NUMEMPLOYE.setToolTipText("");
		NUMEMPLOYE.setColumns(10);
		NUMEMPLOYE.setBounds(52, 81, 180, 17);
		frmNouveauClient.getContentPane().add(NUMEMPLOYE);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date du debut de l'intervention :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 106, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		DATEDEBUT = new JTextField();
		DATEDEBUT.setToolTipText("");
		DATEDEBUT.setColumns(10);
		DATEDEBUT.setBounds(52, 120, 180, 17);
		frmNouveauClient.getContentPane().add(DATEDEBUT);
		
				
		JLabel lblNewLabel_1_5 = new JLabel("Date de la fin de l'intervention :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 145, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		DATEFIN = new JTextField();
		DATEFIN.setToolTipText("");
		DATEFIN.setColumns(10);
		DATEFIN.setBounds(52, 159, 180, 17);
		frmNouveauClient.getContentPane().add(DATEFIN);
		
	
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost?useUnicode=true&characterEncoding=utf8");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO Intervenants VALUES("+NUMINTERVENTION.getText()+","+NUMEMPLOYE.getText()+",'"+DATEDEBUT.getText()+"','"+DATEFIN.getText()+"')");
					rs=stmt.executeQuery("commit");
     
					frmNouveauClient.dispose();
					Intervenant fIntervenant=new Intervenant();
					
					
				}catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");}
				
				
			}
		});
		
		frmNouveauClient.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNouveauClient.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        frmNouveauClient.dispose(); // ferme la fenêtre principale sans quitter l'application
		        Intervenant fIntervenant=new Intervenant();
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(94, 204, 84, 23);
		frmNouveauClient.getContentPane().add(btnInserer);
		

	}
}
