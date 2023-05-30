package DBAintervention;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import component.MonBoutton;
import component.MaComboBox;
import component.MonTextField;
import net.proteanit.sql.DbUtils;

import javax.swing.DefaultComboBoxModel;
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
		frmNouveauClient.setBackground(new Color(195, 214, 245));
		frmNouveauClient.getContentPane().setBackground(new Color(195, 214, 245));
		frmNouveauClient.setBounds(100, 100, 304, 370);
		frmNouveauClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNouveauClient.getContentPane().setLayout(null);
		frmNouveauClient.setVisible(true);
		
		JLabel lblNewLabel_1 = new JLabel("Numéro d'intervention :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(52, 28, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1);
		
		numint = new MonTextField();
		numint.setToolTipText("");
		numint.setColumns(10);
		numint.setBounds(52, 42, 180, 17);
		frmNouveauClient.getContentPane().add(numint);
		
		JLabel lblNewLabel_1_1 = new JLabel("Numéro du véhicule :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(52, 71, 130, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_1);
		
		numvehicule = new MonTextField();
		numvehicule.setToolTipText("");
		numvehicule.setColumns(10);
		numvehicule.setBounds(52, 85, 180, 17);
		frmNouveauClient.getContentPane().add(numvehicule);
		
		JLabel lblNewLabel_1_2 = new JLabel("Type de l'intervention :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(52, 114, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_2);
		
		TYPEINTERVENTION = new MonTextField();
		TYPEINTERVENTION.setToolTipText("");
		TYPEINTERVENTION.setColumns(10);
		TYPEINTERVENTION.setBounds(52, 128, 180, 17);
		frmNouveauClient.getContentPane().add(TYPEINTERVENTION);
		
		JLabel lblNewLabel_1_3 = new JLabel("Date du debut de l'intervention :");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(52, 153, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date de la fin de l'intervention :");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(52, 192, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Coût de l'intervention :");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(52, 231, 180, 11);
		frmNouveauClient.getContentPane().add(lblNewLabel_1_5);
		
		COUTINTERV = new MonTextField();
		COUTINTERV.setToolTipText("");
		COUTINTERV.setColumns(10);
		COUTINTERV.setBounds(52, 245, 180, 17);
		frmNouveauClient.getContentPane().add(COUTINTERV);
		
		final MaComboBox jourd = new MaComboBox();
		jourd.setFont(new Font("Arial", Font.PLAIN, 11));
		jourd.setBounds(52, 165, 63, 17);
		jourd.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		frmNouveauClient.getContentPane().add(jourd);
		
		final MaComboBox moisd = new MaComboBox();
		moisd.setFont(new Font("Arial", Font.PLAIN, 11));
		moisd.setBounds(119, 165, 65, 17);
		moisd.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		frmNouveauClient.getContentPane().add(moisd);
		
		final MaComboBox anneed = new MaComboBox();
		anneed.setFont(new Font("Arial", Font.PLAIN, 11));
		anneed.setBounds(188, 165, 67, 17);
		anneed.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		frmNouveauClient.getContentPane().add(anneed);
		
		final MaComboBox jourf = new MaComboBox();
		jourf.setFont(new Font("Arial", Font.PLAIN, 11));
		jourf.setBounds(52, 206, 63, 17);
		jourf.setModel(new DefaultComboBoxModel(new String[] { "Jour", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		frmNouveauClient.getContentPane().add(jourf);
		
		final MaComboBox moisf = new MaComboBox();
		moisf.setFont(new Font("Arial", Font.PLAIN, 11));
		moisf.setBounds(119, 206, 65, 17);
		moisf.setModel(new DefaultComboBoxModel(
				new String[] { "Mois", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		frmNouveauClient.getContentPane().add(moisf);
		
		final MaComboBox anneef = new MaComboBox();
		anneef.setFont(new Font("Arial", Font.PLAIN, 11));
		anneef.setBounds(188, 206, 67, 17);
		anneef.setModel(new DefaultComboBoxModel(new String[] { "Année ", "1995", "1996", "1997", "1998", "1999",
				"2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012",
				"2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));
		frmNouveauClient.getContentPane().add(anneef);
		
		
		
		JButton btnInserer = new MonBoutton("Inserer");
		btnInserer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
					stmt=connection.createStatement();
					String datedebString = jourd.getSelectedItem().toString() + "/"
							+ moisd.getSelectedItem().toString() + "/"
							+ anneed.getSelectedItem().toString();
					String datefinString = jourf.getSelectedItem().toString() + "/"
							+ moisf.getSelectedItem().toString() + "/"
							+ anneef.getSelectedItem().toString();
					rs=stmt.executeQuery("INSERT INTO Interventions VALUES("+numint.getText()+","+numvehicule.getText()+",'"+TYPEINTERVENTION.getText()+"','"+datedebString+"','"+datefinString+"',"+COUTINTERV.getText()+")");
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
