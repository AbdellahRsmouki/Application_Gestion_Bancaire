package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class employeSiegeSignin extends JFrame {

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
					employeSiegeSignin frame = new employeSiegeSignin();
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
	public employeSiegeSignin() {
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
				  String getcode = textField_1.getText();
		
					String query = "select * from  employesiege where NOM ='"+getname+"' and Code ='"+getcode+"'";
					Connection con = DBConnection.getCon();
					PreparedStatement create1=con.prepareStatement(query);
					ResultSet rs = create1.executeQuery(query);
					if(rs.next()) {
					clientEmployeAgence frame = new clientEmployeAgence();
					frame.setVisible(true);
					fermer();
					}
				else {
					JOptionPane.showMessageDialog(null,"Name or code incorrect");
				}
				}catch(Exception ex) {
					System.out.println("Error :"+ ex);
				}
				}});
		
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
		
		JLabel lblPassword = new JLabel("Code");
		lblPassword.setBounds(355, 194, 67, 23);
		contentPane.add(lblPassword);
		
		Button button_2 = new Button("Retour");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home_Page frame = new Home_Page();
				frame.setVisible(true);
				fermer();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.GRAY);
		button_2.setBounds(355, 390, 256, 38);
		contentPane.add(button_2);
		
		
		
	}
}

