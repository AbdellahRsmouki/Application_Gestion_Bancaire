package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Exception;

public class nomAgenceModification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nomAgenceModification frame = new nomAgenceModification();
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
	public nomAgenceModification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 340, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SVP,Saisir le nom Ancien:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(15, 16, 277, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(193, 72, 196, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					employeSiegeSignin a=new employeSiegeSignin();
					creationAgence g=new creationAgence();
					
				
				try {
					
					DBConnection.DBconnect();
					String rq1="UPDATE agence SET nom=? where nom=?";
					PreparedStatement create1=(PreparedStatement) DBConnection.getCon().prepareStatement(rq1);
					create1.setString(2, textField.getText());
					create1.setString(1, textField_1.getText());
					create1.executeUpdate();
					
					
					String rq2="UPDATE client SET agence=? where agence=?";
					PreparedStatement create2=(PreparedStatement) DBConnection.getCon().prepareStatement(rq2);
					create2.setString(2, textField.getText());
					create2.setString(1, textField_1.getText());
					create2.executeUpdate();
							
							
							
				}catch(Exception e1) {System.out.println(e1);}
				finally {JOptionPane.showMessageDialog(null,"bien effectué");}
				fermer();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(273, 204, 155, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblSvpsaisirLeNom = new JLabel("SVP,Saisir le nom nouveau:");
		lblSvpsaisirLeNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblSvpsaisirLeNom.setBounds(15, 121, 277, 40);
		contentPane.add(lblSvpsaisirLeNom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(193, 157, 196, 47);
		contentPane.add(textField_1);
	}

}
