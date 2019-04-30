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
public class codeAgenceModification extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					codeAgenceModification frame = new codeAgenceModification();
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
	public codeAgenceModification() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 340, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saisir le nom de l'agence :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(15, 16, 354, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(111, 67, 196, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					employeSiegeSignin a=new employeSiegeSignin();
					creationAgence g=new creationAgence();
					
				
				try {
					
					DBConnection.DBconnect();
					java.sql.Connection con=DBConnection.getCon();
					String rq1="UPDATE agence SET code=? where nom=?";
					PreparedStatement create1=(PreparedStatement) con.prepareStatement(rq1);
					create1.setString(2, textField.getText());
					create1.setString(1, textField_1.getText());
					create1.executeUpdate();
							
							
							
				}catch(Exception e1) {System.out.println(e1);}
				finally {JOptionPane.showMessageDialog(null,"bien effectué");}
				fermer();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(132, 231, 155, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblSvpsaisirLeNom = new JLabel("Saisir le  nouveau code :");
		lblSvpsaisirLeNom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblSvpsaisirLeNom.setBounds(15, 121, 277, 40);
		contentPane.add(lblSvpsaisirLeNom);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 157, 196, 47);
		contentPane.add(textField_1);
		
		btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(132, 300, 155, 35);
		contentPane.add(btnNewButton_1);
	}

}
