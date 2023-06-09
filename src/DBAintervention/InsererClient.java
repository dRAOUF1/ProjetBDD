package DBAintervention;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import component.MonBoutton;
import component.MonTextField;
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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsererClient {

	private JFrame frmNouveauClient;
	private MonTextField num;
	private MonTextField prenom;
	private MonTextField nom;
	private MonTextField ddn;
	private MonTextField adr;
	private MonTextField telpro;
	private JLabel lblNewLabel;
	private MonTextField telpriv;
	private JLabel lblNewLabel_2;
	private MonTextField fax;
	
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
					InsererClient window = new InsererClient();
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
	public InsererClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNouveauClient = new JFrame();
		frmNouveauClient.setTitle("Nouveau client");
		frmNouveauClient.setBackground(new Color(195, 214, 245));
		frmNouveauClient.setBounds(100, 100, 304, 490);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		frmNouveauClient.getContentPane().setBackground(new Color(195, 214, 245));
		
		JLabel lblNewLabel_1 = new JLabel("Numéro :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		num = new MonTextField();
		num.setColumns(10);
		num.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(num);
		
		JLabel lblNewLabel_1_1 = new JLabel("CIV :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 71, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 114, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		prenom = new MonTextField();
		prenom.setToolTipText("");
		prenom.setColumns(10);
		prenom.setBounds(52, 128, 180, 17);
		frmNouveauClient.getContentPane().add(prenom);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nom :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 153, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		nom = new MonTextField();
		nom.setToolTipText("");
		nom.setColumns(10);
		nom.setBounds(52, 167, 180, 17);
		frmNouveauClient.getContentPane().add(nom);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de naissance :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 192, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_4);
		
		ddn = new MonTextField();
		ddn.setToolTipText("");
		ddn.setColumns(10);
		ddn.setBounds(52, 206, 180, 17);
		frmNouveauClient.getContentPane().add(ddn);
		
		JLabel lblNewLabel_1_5 = new JLabel("Adresse :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 231, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		adr = new MonTextField();
		adr.setToolTipText("");
		adr.setColumns(10);
		adr.setBounds(52, 245, 180, 17);
		frmNouveauClient.getContentPane().add(adr);
		
		JLabel lblNewLabel_1_6 = new JLabel("Téléphone professionnel  :");
		lblNewLabel_1_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_6.setBounds(52, 270, 159, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_6);
		
		telpro = new MonTextField();
		telpro.setToolTipText("");
		telpro.setColumns(10);
		telpro.setBounds(52, 284, 180, 17);
		frmNouveauClient.getContentPane().add(telpro);
		
		lblNewLabel = new JLabel("Téléphone privé:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(52, 315, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel);
		
		telpriv = new MonTextField();
		telpriv.setToolTipText("");
		telpriv.setColumns(10);
		telpriv.setBounds(52, 329, 180, 17);
		frmNouveauClient.getContentPane().add(telpriv);
		
		lblNewLabel_2 = new JLabel("Fax :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(52, 354, 111, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_2);
		
		fax = new MonTextField();
		fax.setToolTipText("");
		fax.setColumns(10);
		fax.setBounds(52, 368, 180, 17);
		frmNouveauClient.getContentPane().add(fax);
		
		final JComboBox civ = new JComboBox();
		civ.setModel(new DefaultComboBoxModel(new String[] {"M", "Mle", "Mme"}));
		civ.setBounds(52, 85, 180, 22);
		frmNouveauClient.getContentPane().add(civ);
		
		JButton btnInserer = new MonBoutton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					rs=stmt.executeQuery("INSERT INTO CLIENT VALUES("+num.getText()+",'"+civ.getSelectedItem().toString()+"','"+prenom.getText()+"','"+nom.getText()+"','"+ddn.getText()+"','"+adr.getText()+"','"+telpro.getText()+"','"+telpriv.getText()+"','"+fax.getText()+"')");
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
		btnInserer.setBounds(98, 405, 84, 23);
		frmNouveauClient.getContentPane().add(btnInserer);
		

	}
}
