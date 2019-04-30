package App_interfaces;

import java.awt.BorderLayout;
import java.lang.Exception;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Agence extends JFrame {

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
					Agence frame = new Agence();
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
	public Agence() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 464);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.shadow"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("CREATION AGENCE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creationAgence z=new creationAgence();
				z.setVisible(true);
				fermer();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBounds(155, 60, 319, 62);
		contentPane.add(btnNewButton);
		
		JButton btnModificationAgence = new JButton("MODIFICATION AGENCE");
		btnModificationAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificationAgence m=new modificationAgence();
				m.setVisible(true);
				fermer();
				
			}
		});
		btnModificationAgence.setBackground(Color.GREEN);
		btnModificationAgence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnModificationAgence.setBounds(155, 160, 319, 62);
		contentPane.add(btnModificationAgence);
		
		JButton btnSuppressionAgence = new JButton("SUPPRESSION AGENCE");
		btnSuppressionAgence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerAgence i=new supprimerAgence();
				i.setVisible(true);
				
				
			}
		});
		btnSuppressionAgence.setBackground(Color.GREEN);
		btnSuppressionAgence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		btnSuppressionAgence.setBounds(155, 255, 319, 62);
		contentPane.add(btnSuppressionAgence);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientEmployeAgence frame = new clientEmployeAgence();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setBounds(266, 349, 104, 34);
		contentPane.add(btnNewButton_1);
	}
}
