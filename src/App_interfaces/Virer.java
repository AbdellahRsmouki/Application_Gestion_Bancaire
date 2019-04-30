package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Compte;
import app_classes.compteEpargne;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Virer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private String cinavirer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Virer frame = new Virer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void fermer() {
		dispose();
	}

	/**
	 * Create the frame.
	 */
	public Virer() {
		Compte _compte =new compteEpargne();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 205);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaption);
		textField.setBounds(220, 33, 140, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.inactiveCaption);
		textField_1.setColumns(10);
		textField_1.setBounds(220, 81, 140, 20);
		panel.add(textField_1);
		
		btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compte.compteconnecting();
				DBConnection.DBconnect();
				String rq="select cin from compte where code = '"+textField.getText()+"'";
				try {
				PreparedStatement prep = DBConnection.getCon().prepareStatement(rq);
				ResultSet rs= prep.executeQuery();
				if(rs.next()) {cinavirer = rs.getString("cin");
				compteEpargne.deposer(Double.parseDouble(textField_1.getText()));
				String rq2="INSERT INTO transaction VALUES ('"+DBConnection.getDate()+"','"+cinavirer+"','Virer','"+Double.parseDouble(textField_1.getText())+"','"+compteEpargne.getSolde()+"')";
				PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2);
				prep2.executeUpdate();
				DBConnection.Updatecompte();
				JOptionPane.showMessageDialog(null,"L'opération a été effectué avec succés");
				fermer();}
				else {	JOptionPane.showMessageDialog(null,"invalid informations");}
			} catch (Exception e) {
				System.out.println("error while using virer class :"+e);;
			}
		}});
		btnNewButton.setBounds(220, 129, 140, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Code compte");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setBounds(55, 33, 117, 20);
		panel.add(lblNewLabel);
		
		JLabel lblMontant = new JLabel("Montant");
		lblMontant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMontant.setEnabled(false);
		lblMontant.setBackground(Color.CYAN);
		lblMontant.setBounds(55, 81, 117, 20);
		panel.add(lblMontant);
	}
}
