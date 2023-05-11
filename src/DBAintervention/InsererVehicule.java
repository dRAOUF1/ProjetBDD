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
import javax.swing.JCheckBoxMenuItem;

public class InsererVehicule {

	private JFrame frmNouveauClient;
	private JTextField numVehicule;
	private JTextField numClient;
	private JTextField numModele;
	private JTextField annee;
	
	private Connection connection=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private JTextField numImat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsererVehicule window = new InsererVehicule();
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
	public InsererVehicule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauClient = new JFrame();
		frmNouveauClient.setTitle("Nouveau véhicule ");
		frmNouveauClient.setBounds(100, 100, 308, 366);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro du véhicule :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 140, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		numVehicule = new JTextField();
		numVehicule.setToolTipText("");
		numVehicule.setColumns(10);
		numVehicule.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(numVehicule);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numéro du client :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 67, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		numClient = new JTextField();
		numClient.setToolTipText("");
		numClient.setColumns(10);
		numClient.setBounds(52, 81, 180, 17);
		frmNouveauClient.getContentPane().add(numClient);
		
		JLabel lblNewLabel_1_3 = new JLabel("Numéro du modèle :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 106, 140, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		numModele = new JTextField();
		numModele.setToolTipText("");
		numModele.setColumns(10);
		numModele.setBounds(52, 120, 180, 17);
		frmNouveauClient.getContentPane().add(numModele);
		
		JLabel lblNewLabel_1_4 = new JLabel("Numéro d'immatriculation  :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 145, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Année :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 184, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		annee = new JTextField();
		annee.setToolTipText("");
		annee.setColumns(10);
		annee.setBounds(52, 198, 180, 17);
		frmNouveauClient.getContentPane().add(annee);
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost?useUnicode=true&characterEncoding=utf8");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO Vehicule VALUES("+numVehicule.getText()+","+numClient.getText()+","+numModele.getText()+","+numImat.getText()+","+annee.getText()+")");
					rs=stmt.executeQuery("commit");
     
					frmNouveauClient.dispose();
					Vehicule fVehicule=new Vehicule();
					
					
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
		        Vehicule fVehicule=new Vehicule();
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(94, 255, 84, 23);
		frmNouveauClient.getContentPane().add(btnInserer);
		
		numImat = new JTextField();
		numImat.setToolTipText("");
		numImat.setColumns(10);
		numImat.setBounds(52, 159, 180, 17);
		frmNouveauClient.getContentPane().add(numImat);
		

	}
}
