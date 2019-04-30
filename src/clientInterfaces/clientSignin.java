package clientInterfaces;

import java.awt.BorderLayout;
import java.sql.ResultSet;
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

public class clientSignin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static String clientcin;
	/*
	 * cin is a String variable where i can put cin of user and use it in other interfaces
	 */
	
	
	public static String getClientcin() {
		return clientcin;
	}
	
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
					clientSignin frame = new clientSignin();
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
	public clientSignin() {
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
				  App_interfaces.DBConnection.DBconnect();
				  String query = "select * from client where nom ='"+textField.getText()+"' and cin ='"+textField_1.getText()+"'";
				  PreparedStatement perp = App_interfaces.DBConnection.getCon().prepareStatement(query);
				  ResultSet rs = perp.executeQuery(query);
				  if(rs.next()) {
					clientcin = rs.getString("cin");
					System.out.println("hhh");
					clientHome frame = new clientHome();
					System.out.println("hhh");
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
				App_interfaces.Home_Page frame = new App_interfaces.Home_Page();
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
