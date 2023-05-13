package app;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import DBAintervention.DBAINTERVENTION;
import Employes.RechercherEmploye;
import component.ModernButton;
import component.ModernTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Application {

	private JFrame frmSeConnecter;
	private JTextField Username;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	
	private Connection connection=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frmSeConnecter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSeConnecter = new JFrame();
		frmSeConnecter.getContentPane().setBackground(new Color(195, 214, 245));
		frmSeConnecter.setTitle("Se Connecter");
		frmSeConnecter.setResizable(false);
		frmSeConnecter.setBounds(100, 100, 335, 330);
		frmSeConnecter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSeConnecter.getContentPane().setLayout(null);
		frmSeConnecter.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Se Connecter");
		lblNewLabel.setBounds(90, 56, 139, 26);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		frmSeConnecter.getContentPane().add(lblNewLabel);
		
		Username = new ModernTextField();
		Username.setToolTipText("");
		Username.setBounds(68, 116, 180, 17);
		frmSeConnecter.getContentPane().add(Username);
		Username.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nom d'utilisateur :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(70, 102, 111, 11);
		frmSeConnecter.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Mot de passe :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(70, 157, 111, 11);
		frmSeConnecter.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new ModernButton("Se connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						String username=Username.getText();
						String password=Password.getText();
						
						if (username.toLowerCase().contentEquals("dbaintervention") && password.contentEquals("orcl1234")) {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							connection=DriverManager.getConnection("jdbc:oracle:thin:"+username+"/"+password+"@localhost");
							stmt=connection.createStatement();
							
							frmSeConnecter.dispose();
							DBAINTERVENTION f1= new DBAINTERVENTION();
						
						}
						else if (username.toLowerCase().contentEquals("employedba") && password.contentEquals("1234")) {
							Class.forName("oracle.jdbc.driver.OracleDriver");
							connection=DriverManager.getConnection("jdbc:oracle:thin:dbaintervention/orcl1234@localhost");
							stmt=connection.createStatement();
							
							frmSeConnecter.dispose();
							RechercherEmploye f2= new RechercherEmploye();
						}
						else {
							System.out.println("Ereur");
						}
				}
				catch (Exception E) {
					E.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton.setBounds(104, 204, 104, 25);
		frmSeConnecter.getContentPane().add(btnNewButton);
		
		Password = new JPasswordField();
		Password.setPreferredSize(new Dimension(200, 30));
		Password.setFont(new Font("Arial", Font.PLAIN, 12));
        Border line = BorderFactory.createLineBorder(Color.GRAY, 1);
        Border empty = BorderFactory.createEmptyBorder(0, 5, 0, 5);
        Password.setBorder(BorderFactory.createCompoundBorder(line, empty));
        Password.setBackground(Color.WHITE);
        Password.setForeground(Color.BLACK);
        Password.setCaretColor(Color.BLACK);
		Password.setBounds(68, 171, 180, 17);
		frmSeConnecter.getContentPane().add(Password);
	}
}
