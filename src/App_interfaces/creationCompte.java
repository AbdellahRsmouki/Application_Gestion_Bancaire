package App_interfaces;

import java.awt.BorderLayout;
import java.lang.Exception;
import java.util.UUID;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Client;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class creationCompte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	void fermer() {
		dispose();
	}
	


	    public static String generateString() {
	        String uuid = UUID.randomUUID().toString();
	        return  uuid;
	    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creationCompte frame = new creationCompte();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public creationCompte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 546, 333);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Epargne");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Client.getCompteEpargne()==0) {
					solde s=new solde();
					s.setVisible(true);
					fermer();
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous avez déjà un compte Epargne ");
				}
			}
		});
		btnNewButton.setBounds(114, 131, 236, 58);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Courant");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Client.getCompteCourant()==0) {
					decouvert s=new decouvert();
					s.setVisible(true);
					fermer();
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous avez déjà un compte Courant ");
				}
			}
		});
		btnNewButton_1.setBounds(114, 205, 236, 57);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("se connecter");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signIn s=new signIn();
				s.setVisible(true);
				fermer();
			}
		});
		btnNewButton_2.setForeground(Color.CYAN);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(144, 278, 176, 43);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RETOUR");
		btnNewButton_3.setBorder(null);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile z=new Profile();
				z.setVisible(true);
				fermer();
			}
		});
		btnNewButton_3.setBackground(Color.CYAN);
		btnNewButton_3.setForeground(Color.LIGHT_GRAY);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBounds(424, 278, 115, 43);
		panel.add(btnNewButton_3);
		
		JLabel creation_compte = new JLabel("Creation compte");
		creation_compte.setBorder(null);
		creation_compte.setHorizontalAlignment(SwingConstants.CENTER);
		creation_compte.setBackground(Color.GRAY);
		creation_compte.setFont(new Font("Arial", Font.BOLD, 24));
		creation_compte.setBounds(56, 31, 329, 73);
		panel.add(creation_compte);
	}
}
