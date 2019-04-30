package App_interfaces;


import java.awt.BorderLayout;
import java.lang.Exception;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientInterfaces.clientSignin;
import employeAgence_interfaces.employeAgenceSignin;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home_Page extends JFrame {

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
					Home_Page frame = new Home_Page();
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
	public Home_Page() {
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
		
		JButton btnNewButton = new JButton("Employe Agence");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				employeAgenceSignin frame = new employeAgenceSignin();
				frame.setVisible(true);
				fermer();
			}
		});
		
		JButton btnAgences = new JButton("Client");
		btnAgences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientSignin frame = new clientSignin();
				frame.setVisible(true);
				fermer();
			}
		});
		btnAgences.setBounds(293, 309, 199, 60);
		panel.add(btnAgences);
		btnAgences.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAgences.setBorderPainted(false);
		btnAgences.setBackground(Color.CYAN);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 309, 199, 60);
		panel.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Employe Si\u00E8ge");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				employeSiegeSignin frame = new employeSiegeSignin();
				frame.setVisible(true);
				fermer();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(Color.CYAN);
		btnSignUp.setBounds(572, 309, 199, 60);
		panel.add(btnSignUp);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 781, 413);
		lblNewLabel.setIcon(new ImageIcon(clientEmployeAgence.class.getResource("/images/home.png")));
		panel.add(lblNewLabel);
	}
}
