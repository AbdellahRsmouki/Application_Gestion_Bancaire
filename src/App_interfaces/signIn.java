package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Client;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Button;
import java.awt.SystemColor;
import java.sql.*;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	/*
	 * cin is a String variable where i can put cin of user and use it in other interfaces
	 */
	
	public void fermer() {
		this.dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signIn frame = new signIn();
					frame.setUndecorated(true);
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
	public signIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Sign In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				  DBConnection.DBconnect();
				  String getname = textField.getText();
				  String getcin = textField_1.getText();
				  //enregitrer CIN in cin to use it in other places
				  Client.setCIN(getcin);
				if(DBConnection.checkData(getname,getcin)) {
					Profile frame = new Profile();
					frame.setVisible(true);
					fermer();
					}
				else {
					JOptionPane.showMessageDialog(null,"Name or CIN incorrect");
				}
				}catch(Exception ex) {
					System.out.println("Error :"+ ex);
				}
			}
		});
		
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241,57,83));
		button.setBounds(355, 326, 256, 38);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(-1, -3, 333, 503);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("                YOUR INFORMATIONS ARE SAFE");
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(9, 280, 271, 29);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(355, 151, 256, 28);
		contentPane.add(textField);
		
		JLabel lblUserName = new JLabel("Name");
		lblUserName.setBounds(355, 118, 67, 23);
		contentPane.add(lblUserName);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(355, 227, 256, 28);
		contentPane.add(textField_1);
		
		JLabel lblPassword = new JLabel("CIN");
		lblPassword.setBounds(355, 194, 67, 23);
		contentPane.add(lblPassword);
		
		Button button_1 = new Button("Retour");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientEmployeAgence frame = new clientEmployeAgence();
				frame.setVisible(true);
				fermer();
			}
		});
		button_1.setActionCommand("");
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.setBounds(355, 383, 256, 38);
		contentPane.add(button_1);
	}
}
