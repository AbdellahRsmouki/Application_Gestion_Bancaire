package clientInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Client;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class clientHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void fermer() {
		dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientHome frame = new clientHome();
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
	public clientHome() {
		Client.clientconnecting();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 504);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Retirer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Client.getCompteCourant()==1) {
				clientretirer z=new clientretirer();
				z.setVisible(true);
				
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous ne pouvez pas faire des transactions ");
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(155, 90, 319, 62);
		contentPane.add(btnNewButton);
		
		JButton btnModificationAgence = new JButton("Profile");
		btnModificationAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientprofil m=new clientprofil();
				m.setVisible(true);
				fermer();
				
			}
		});
		btnModificationAgence.setBackground(Color.GREEN);
		btnModificationAgence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnModificationAgence.setBounds(155, 190, 319, 62);
		contentPane.add(btnModificationAgence);
		
		JButton btnSuppressionAgence = new JButton("Operations");
		btnSuppressionAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientoperation i=new clientoperation();
				i.setVisible(true);
				fermer();
				
				
			}
		});
		btnSuppressionAgence.setBackground(Color.GREEN);
		btnSuppressionAgence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnSuppressionAgence.setBounds(155, 285, 319, 62);
		contentPane.add(btnSuppressionAgence);
		
		JButton btnNewButton_1 = new JButton("Deconnection");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientSignin frame = new clientSignin();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setBounds(247, 406, 145, 34);
		contentPane.add(btnNewButton_1);
	
	}
}
