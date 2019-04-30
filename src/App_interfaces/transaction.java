package App_interfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Client;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transaction extends JFrame {

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
					transaction frame = new transaction();
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
	public transaction() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 863, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 0, 841, 512);
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
				
			}
		});
		btnTransactions.setForeground(Color.GRAY);
		btnTransactions.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnTransactions.setBorderPainted(false);
		btnTransactions.setBackground(new Color(0, 255, 0));
		btnTransactions.setBounds(87, 144, 176, 60);
		panel_1.add(btnTransactions);
		
		JButton btnInformations_1 = new JButton("Suppression");
		btnInformations_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppression d=new Suppression();
				d.setVisible(true);
				fermer();
			}
		});
		btnInformations_1.setForeground(Color.WHITE);
		btnInformations_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnInformations_1.setBorderPainted(false);
		btnInformations_1.setBackground(Color.DARK_GRAY);
		btnInformations_1.setBounds(87, 228, 176, 55);
		panel_1.add(btnInformations_1);
		
		JButton btnTransactionsEffectues = new JButton("Operations");
		btnTransactionsEffectues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operations frame = new Operations();
				frame.setVisible(true);
				fermer();
			}
		});
		btnTransactionsEffectues.setBorderPainted(false);
		btnTransactionsEffectues.setForeground(Color.WHITE);
		btnTransactionsEffectues.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnTransactionsEffectues.setBackground(Color.DARK_GRAY);
		btnTransactionsEffectues.setBounds(87, 316, 176, 53);
		panel_1.add(btnTransactionsEffectues);
		
		JButton btnNewButton = new JButton("deposer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Client.getCompteEpargne()==1) {
				deposer t=new deposer();
				t.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous n'avez pas un compte Epargne ");
				}
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnNewButton.setBounds(353, 74, 276, 64);
		panel.add(btnNewButton);
		
		JButton btnRetirer = new JButton("retirer");
		btnRetirer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Client.getCompteCourant()==1) {
				retirer r= new retirer();
				r.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous n'avez pas un compte Courant ");
				}
			}
		});
		btnRetirer.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnRetirer.setBounds(353, 165, 276, 64);
		panel.add(btnRetirer);
		
		JButton btnEffectuerUnVirement = new JButton("Effectuer un virement");
		btnEffectuerUnVirement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Virer v=new Virer();
				v.setVisible(true);
				
			}
		});
		btnEffectuerUnVirement.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 23));
		btnEffectuerUnVirement.setBounds(353, 262, 276, 64);
		panel.add(btnEffectuerUnVirement);
		
		JButton Retour = new JButton("Deconnection");
		Retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home_Page frame=new Home_Page();
				frame.setVisible(true);
				fermer();
			}
		});
		Retour.setBorder(null);
		Retour.setBackground(new Color(0, 255, 0));
		Retour.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Retour.setBounds(639, 394, 169, 69);
		panel.add(Retour);
		
		
	}
}
