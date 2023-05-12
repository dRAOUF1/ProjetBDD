package DBAintervention;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

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

public class InsererInterventions {

	private JFrame frmNouveauClient;
	private JTextField numint;
	private JTextField numvehicule;
	private JTextField TYPEINTERVENTION;
	private JTextField DATEDEBINTERV;
	private JTextField DATEFININTERV;
	private JTextField COUTINTERV;

	
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
					InsererInterventions window = new InsererInterventions();
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
	public InsererInterventions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauClient = new JFrame();
		frmNouveauClient.setTitle("Nouvelle intervention");
		frmNouveauClient.setBounds(100, 100, 304, 370);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro d'intervention :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		numint = new JTextField();
		numint.setToolTipText("");
		numint.setColumns(10);
		numint.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(numint);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numéro du véhicule :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 71, 130, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_1);
		
		numvehicule = new JTextField();
		numvehicule.setToolTipText("");
		numvehicule.setColumns(10);
		numvehicule.setBounds(52, 85, 180, 17);
		frmNouveauClient.getContentPane().add(numvehicule);
		
		JLabel lblNewLabel_1_2 = new JLabel("Type de l'intervention :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 114, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		TYPEINTERVENTION = new JTextField();
		TYPEINTERVENTION.setToolTipText("");
		TYPEINTERVENTION.setColumns(10);
		TYPEINTERVENTION.setBounds(52, 128, 180, 17);
		frmNouveauClient.getContentPane().add(TYPEINTERVENTION);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date du debut de l'intervention :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 153, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		DATEDEBINTERV = new JTextField();
		DATEDEBINTERV.setToolTipText("");
		DATEDEBINTERV.setColumns(10);
		DATEDEBINTERV.setBounds(52, 167, 180, 17);
		frmNouveauClient.getContentPane().add(DATEDEBINTERV);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de la fin de l'intervention :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 192, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_4);
		
		DATEFININTERV = new JTextField();
		DATEFININTERV.setToolTipText("");
		DATEFININTERV.setColumns(10);
		DATEFININTERV.setBounds(52, 206, 180, 17);
		frmNouveauClient.getContentPane().add(DATEFININTERV);
		
		JLabel lblNewLabel_1_5 = new JLabel("Coût de l'intervention :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 231, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		COUTINTERV = new JTextField();
		COUTINTERV.setToolTipText("");
		COUTINTERV.setColumns(10);
		COUTINTERV.setBounds(52, 245, 180, 17);
		frmNouveauClient.getContentPane().add(COUTINTERV);
		
		
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO Interventions VALUES("+numint.getText()+","+numvehicule.getText()+",'"+TYPEINTERVENTION.getText()+"','"+DATEDEBINTERV.getText()+"','"+DATEFININTERV.getText()+"',"+COUTINTERV.getText()+")");
					rs=stmt.executeQuery("commit");
     
					frmNouveauClient.dispose();
					
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
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(98, 285, 84, 23);
		frmNouveauClient.getContentPane().add(btnInserer);
	}
}
