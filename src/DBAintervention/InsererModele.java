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

public class InsererModele {

	private JFrame frmNouveauModele;
	private JTextField nummodele;
	private JTextField nummarque;
	private JTextField modele;
	
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
					InsererModele window = new InsererModele();
					window.frmNouveauModele.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InsererModele() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauModele = new JFrame();
		frmNouveauModele.setTitle("Nouveau modèle ");
		frmNouveauModele.setBounds(100, 100, 304, 263);
		frmNouveauModele.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauModele.getContentPane().setLayout(null);
		frmNouveauModele.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro du modèle :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 130, 11);
		frmNouveauModele.getContentPane().add(lblNewLabel_1);
		
		nummodele = new JTextField();
		nummodele.setToolTipText("");
		nummodele.setColumns(10);
		nummodele.setBounds(52, 42, 180, 17);
		frmNouveauModele.getContentPane().add(nummodele);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numéro de la marque :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 71, 159, 11);
		frmNouveauModele.getContentPane().add(lblNewLabel_1_1);
		
		nummarque = new JTextField();
		nummarque.setToolTipText("");
		nummarque.setColumns(10);
		nummarque.setBounds(52, 85, 180, 17);
		frmNouveauModele.getContentPane().add(nummarque);
		
		JLabel lblNewLabel_1_2 = new JLabel("Modèle :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 114, 111, 11);
		frmNouveauModele.getContentPane().add(lblNewLabel_1_2);
		
		modele = new JTextField();
		modele.setToolTipText("");
		modele.setColumns(10);
		modele.setBounds(52, 128, 180, 17);
		frmNouveauModele.getContentPane().add(modele);
		
		
		JButton btnInserer = new JButton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO modele VALUES("+nummodele.getText()+",'"+nummarque.getText()+"','"+modele.getText()+"')");
					rs=stmt.executeQuery("commit");
     
					frmNouveauModele.dispose();
					Modele fModele=new Modele();
					
				}catch (Exception E) {
					E.printStackTrace();
					System.out.print("erreur");}
				
				
			}
		});
		
		frmNouveauModele.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmNouveauModele.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        frmNouveauModele.dispose(); // ferme la fenêtre principale sans quitter l'application
		        Modele fModele=new Modele();
		    }
		});
		
		btnInserer.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInserer.setBounds(98, 170, 84, 23);
		frmNouveauModele.getContentPane().add(btnInserer);
	}
}
