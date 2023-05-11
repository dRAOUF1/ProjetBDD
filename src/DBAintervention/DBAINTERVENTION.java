package DBAintervention;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class DBAINTERVENTION {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBAINTERVENTION window = new DBAINTERVENTION();
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
	public DBAINTERVENTION() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("Clients");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Client fClient=new Client();
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.setBounds(41, 41, 122, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnMarque = new JButton("Marque");
		btnMarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMarque.setFont(new Font("Arial", Font.BOLD, 14));
		btnMarque.setBounds(41, 90, 122, 29);
		frame.getContentPane().add(btnMarque);
		
		JButton btnVehicule = new JButton("Vehicule");
		btnVehicule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVehicule.setFont(new Font("Arial", Font.BOLD, 14));
		btnVehicule.setBounds(41, 141, 122, 29);
		frame.getContentPane().add(btnVehicule);
		
		JButton btnEmploye = new JButton("Employe");
		btnEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Employe fEmploye=new Employe();
			}
		});
		btnEmploye.setFont(new Font("Arial", Font.BOLD, 14));
		btnEmploye.setBounds(282, 41, 122, 29);
		frame.getContentPane().add(btnEmploye);
		
		JButton btnModele = new JButton("Modele");
		btnModele.setFont(new Font("Arial", Font.BOLD, 14));
		btnModele.setBounds(282, 90, 122, 29);
		frame.getContentPane().add(btnModele);
		
		JButton btnInterventions = new JButton("Interventions");
		btnInterventions.setFont(new Font("Arial", Font.BOLD, 14));
		btnInterventions.setBounds(282, 141, 122, 29);
		frame.getContentPane().add(btnInterventions);
		
		JButton btnIntervenants = new JButton("Intervenants");
		btnIntervenants.setFont(new Font("Arial", Font.BOLD, 14));
		btnIntervenants.setBounds(282, 197, 122, 29);
		frame.getContentPane().add(btnIntervenants);
		
		JButton btnSeDeconnecter = new JButton("Se deconnecter");
		btnSeDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSeDeconnecter.setFont(new Font("Arial", Font.BOLD, 14));
		btnSeDeconnecter.setBounds(41, 197, 122, 29);
		frame.getContentPane().add(btnSeDeconnecter);
	}
}
