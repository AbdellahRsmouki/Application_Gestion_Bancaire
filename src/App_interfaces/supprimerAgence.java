package App_interfaces;

import java.lang.Exception;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class supprimerAgence extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private static String str;
	

	public static String getStr() {
		return str;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerAgence frame = new supprimerAgence();
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
	public supprimerAgence() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 541, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("entrer le code de l'agence \u00E0 supprimer :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 505, 58);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(89, 103, 208, 53);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientEmployeAgence a=new clientEmployeAgence();
				 
				try {
					
					DBConnection.DBconnect();
					java.sql.Connection con=DBConnection.getCon();
						
						
						String rq1=" select nom FROM agence WHERE code=?";
						PreparedStatement create1=con.prepareStatement(rq1);
						double d=Double.parseDouble(textField.getText());
						create1.setDouble(1,d );
						ResultSet rs1=create1.executeQuery();
						if(rs1.next()) {
							String rq4=" delete FROM agence WHERE code=?";
							PreparedStatement create4=con.prepareStatement(rq4);
							create4.setDouble(1,d );
							create4.execute();
							str=rs1.getString(1);
							
							String rq2=" select * FROM client WHERE agence=?";
							PreparedStatement create2=con.prepareStatement(rq2);
							create2.setString(1,str );
							ResultSet rs2=create2.executeQuery();
							while(rs2.next()) {
								methodes.supprimerClientAuto.supprimerAuto(rs2.getString("cin"));
							
							}
							fermer();
							a.setVisible(true);
							
						}
						else {
							JOptionPane.showMessageDialog(null,"pas d'agence correspondante à ce code,entrer un code valide");
						}

					
				}catch(Exception e1) {System.out.println(e1);}
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(332, 103, 183, 52);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fermer();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		btnNewButton_1.setBounds(159, 220, 208, 53);
		contentPane.add(btnNewButton_1);
	}

}

