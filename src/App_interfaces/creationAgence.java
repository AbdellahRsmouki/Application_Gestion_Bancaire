package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class creationAgence extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creationAgence frame = new creationAgence();
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
	public creationAgence() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("code :");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(210, 154, 116, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblAnneeDeCreation = new JLabel("annee de creation :");
		lblAnneeDeCreation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAnneeDeCreation.setBackground(Color.GREEN);
		lblAnneeDeCreation.setBounds(149, 213, 197, 43);
		contentPane.add(lblAnneeDeCreation);
		
		JLabel lblVille = new JLabel("Ville :");
		lblVille.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblVille.setBackground(Color.GREEN);
		lblVille.setBounds(210, 272, 116, 43);
		contentPane.add(lblVille);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAdresse.setBackground(Color.GREEN);
		lblAdresse.setBounds(210, 334, 136, 43);
		contentPane.add(lblAdresse);
		
		textField_1 = new JTextField();
		textField_1.setBounds(341, 155, 222, 43);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(341, 214, 222, 43);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(341, 273, 222, 43);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(338, 335, 222, 43);
		contentPane.add(textField_4);
		
		JLabel lblNomDeLagence = new JLabel("Nom de l'agence :");
		lblNomDeLagence.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNomDeLagence.setBackground(Color.GREEN);
		lblNomDeLagence.setBounds(149, 95, 177, 43);
		contentPane.add(lblNomDeLagence);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(341, 96, 222, 43);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DBConnection.DBconnect();
					Connection con=DBConnection.getCon();
					String rq="insert into agence values (?,?,?,?,?)";
					PreparedStatement create=con.prepareStatement(rq);
					create.setString(1, textField.getText());
					double c2=Double.parseDouble( textField_1.getText());
					create.setDouble(2,c2);
					int c3=Integer.parseInt( textField_2.getText());
					create.setInt(3,c3);
					create.setString(4, textField_3.getText());
					create.setString(5, textField_4.getText());
					create.executeUpdate();
					
					JOptionPane.showMessageDialog(null,"opération éfféctué");
					clientEmployeAgence s=new clientEmployeAgence();
					s.setVisible(true);
					fermer();
					
				}catch(Exception e1) {System.out.println("error while saving agence infos :"+e1);}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		btnNewButton.setBounds(381, 399, 158, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fermer();
				Agence a =new Agence();
				a.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(UIManager.getColor("CheckBox.focus"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_1.setBounds(635, 415, 135, 36);
		contentPane.add(btnNewButton_1);
	}
}

