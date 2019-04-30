package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class modificationAgence extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificationAgence frame = new modificationAgence();
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
	public void fermer() {
		dispose();
	}
	public modificationAgence() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("nom");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomAgenceModification m=new nomAgenceModification();
				m.setVisible(true);
				
			}
		});
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBounds(140, 125, 198, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("code");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codeAgenceModification c=new codeAgenceModification();
				c.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1.setBounds(464, 125, 198, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnVille = new JButton("Ville");
		btnVille.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				villeAgenceModification c=new villeAgenceModification();
				c.setVisible(true);
			}
		});
		btnVille.setBackground(Color.ORANGE);
		btnVille.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btnVille.setBounds(464, 245, 198, 64);
		contentPane.add(btnVille);
		
		JButton btnAdresse = new JButton("Adresse");
		btnAdresse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adresseAgenceModifier c=new adresseAgenceModifier();
				c.setVisible(true);
			}
		});
		btnAdresse.setBackground(Color.ORANGE);
		btnAdresse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btnAdresse.setBounds(140, 245, 198, 64);
		contentPane.add(btnAdresse);
		
		JLabel lblNewLabel = new JLabel("importer les modifications au niveau :");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(60, 29, 477, 64);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("RETOUR");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
				Agence a =new Agence();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_2.setBounds(332, 390, 141, 41);
		contentPane.add(btnNewButton_2);
	}
}

