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

public class InsererEmploye {

	private JFrame frmNouveauClient;
	private JTextField num;
	private JTextField nom;
	private JTextField prenom;
	private JTextField salaire;
	
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
					InsererEmploye window = new InsererEmploye();
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
	public InsererEmploye() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauClient = new JFrame();
		frmNouveauClient.setTitle("Nouveau employé");
		frmNouveauClient.setBounds(100, 100, 308, 366);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		num = new JTextField();
		num.setToolTipText("");
		num.setColumns(10);
		num.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(num);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nom :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 67, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		nom = new JTextField();
		nom.setToolTipText("");
		nom.setColumns(10);
		nom.setBounds(52, 81, 180, 17);
		frmNouveauClient.getContentPane().add(nom);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prenom :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 106, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		prenom = new JTextField();
		prenom.setToolTipText("");
		prenom.setColumns(10);
		prenom.setBounds(52, 120, 180, 17);
		frmNouveauClient.getContentPane().add(prenom);
		
		JLabel lblNewLabel_1_4 = new JLabel("Catégorie :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 145, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Salaire :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 184, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		salaire = new JTextField();
		salaire.setToolTipText("");
		salaire.setColumns(10);
		salaire.setBounds(52, 198, 180, 17);
		frmNouveauClient.getContentPane().add(salaire);
		
		final JComboBox categorie = new JComboBox();
		categorie.setFont(new Font("Arial", Font.PLAIN, 12));
		categorie.setModel(new DefaultComboBoxModel(new String[] {"Mécanicien", "Assistant"}));
		categorie.setBounds(52, 159, 180, 17);
		frmNouveauClient.getContentPane().add(categorie);
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");

					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost?useUnicode=true&characterEncoding=utf8");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO EMPLOYE VALUES("+num.getText()+",'"+nom.getText()+"','"+prenom.getText()+"','"+categorie.getSelectedItem().toString()+"',"+salaire.getText()+")");
					rs=stmt.executeQuery("commit");
					     
					frmNouveauClient.dispose();
					Employe fEmploye=new Employe();
					
					
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
		        Employe fEmploye=new Employe();
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(94, 255, 84, 23);
		frmNouveauClient.getContentPane().add(btnInserer);
		

	}
}
