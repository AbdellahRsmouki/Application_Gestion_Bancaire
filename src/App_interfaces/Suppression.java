package App_interfaces;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Suppression extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	void fermer() {
		dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppression frame = new Suppression();
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
	public Suppression() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 841, 512);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 305, 561);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInformations = new JButton("Informations");
		btnInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile i=new Profile();
				i.setVisible(true);
				fermer();
			}
		});
		btnInformations.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnInformations.setBorderPainted(false);
		btnInformations.setBackground(Color.DARK_GRAY);
		btnInformations.setForeground(new Color(255, 255, 255));
		btnInformations.setBounds(87, 64, 176, 53);
		panel_1.add(btnInformations);
		
		JButton btnTransactions = new JButton("Transaction");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction t=new transaction();
				t.setVisible(true);
				fermer();
				
			}
		});
		btnTransactions.setForeground(Color.WHITE);
		btnTransactions.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnTransactions.setBorderPainted(false);
		btnTransactions.setBackground(Color.DARK_GRAY);
		btnTransactions.setBounds(87, 144, 176, 60);
		panel_1.add(btnTransactions);
		
		JButton btnInformations_1 = new JButton("Suppression");
		btnInformations_1.setForeground(Color.WHITE);
		btnInformations_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnInformations_1.setBorderPainted(false);
		btnInformations_1.setBackground(new Color(0, 255, 0));
		btnInformations_1.setBounds(87, 228, 176, 55);
		panel_1.add(btnInformations_1);
		
		JButton btnTransactionsEffectues = new JButton("Operations");
		btnTransactionsEffectues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operations o=new Operations();
				o.setVisible(true);
				fermer();

			}
		});
		btnTransactionsEffectues.setBorderPainted(false);
		btnTransactionsEffectues.setForeground(Color.WHITE);
		btnTransactionsEffectues.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnTransactionsEffectues.setBackground(Color.DARK_GRAY);
		btnTransactionsEffectues.setBounds(87, 316, 176, 53);
		panel_1.add(btnTransactionsEffectues);
		
		JButton btnNewButton = new JButton("Deconnection");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Home_Page a=new Home_Page();
						a.setVisible(true);
						fermer();
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(619, 425, 185, 53);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Supprimer le compte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supprimerCompte c=new supprimerCompte();
				c.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_1.setBounds(386, 193, 256, 53);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer le client");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerClient p=new supprimerClient();
				p.setVisible(true);
				fermer();
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_2.setBounds(389, 276, 253, 53);
		panel.add(btnNewButton_2);
		
		
	}
}

