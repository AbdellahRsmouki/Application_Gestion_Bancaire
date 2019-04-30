package App_interfaces;

import java.awt.BorderLayout;
import java.lang.Exception;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientEmployeAgence extends JFrame {

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
					clientEmployeAgence frame = new clientEmployeAgence();
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
	public clientEmployeAgence() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 781, 413);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				signIn frame = new signIn();
				frame.setVisible(true);
				fermer();
			}
		});
		
		JButton btnAgences = new JButton("Agences");
		btnAgences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agence frame = new Agence();
				frame.setVisible(true);
				fermer();
			}
		});
		btnAgences.setBounds(293, 264, 199, 60);
		panel.add(btnAgences);
		btnAgences.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgences.setBorderPainted(false);
		btnAgences.setBackground(Color.CYAN);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 264, 199, 60);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp frame = new signUp();
				frame.setVisible(true);
				fermer();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(Color.CYAN);
		btnSignUp.setBounds(572, 264, 199, 60);
		panel.add(btnSignUp);
		
		JButton btnNewButton_1 = new JButton("Deconnection");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home_Page frame = new Home_Page();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(324, 360, 137, 42);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 781, 413);
		lblNewLabel.setIcon(new ImageIcon(clientEmployeAgence.class.getResource("/images/home.png")));
		panel.add(lblNewLabel);
	}
}
