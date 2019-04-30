package clientInterfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Compte;
import app_classes.compteCourant;
import app_classes.compteEpargne;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientretirer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	void fermer() {
		dispose();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientretirer frame = new clientretirer();
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
	public clientretirer() {
		compteCourant compte = new compteCourant();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 358, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 342, 203);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.inactiveCaptionBorder);
		textField.setBounds(154, 57, 141, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Compte.compteconnecting();
				compteCourant  cmpte = new compteCourant();
				if((compteCourant.getDecouvertAutorise() + Compte.getSolde())>=Double.parseDouble(textField.getText())) {
				App_interfaces.DBConnection.DBconnect();
				try {
				compteCourant.retirer(Double.parseDouble(textField.getText()));
				String rq2="INSERT INTO transaction VALUES ('"+App_interfaces.DBConnection.getDate()+"','"+clientSignin.getClientcin()+"','retirer','"+Double.parseDouble(textField.getText())+"','"+compteCourant.getSolde()+"')";
				PreparedStatement prep2 = App_interfaces.DBConnection.getCon().prepareStatement(rq2);
				prep2.executeUpdate();
				App_interfaces.DBConnection.Updatecompte();
				JOptionPane.showMessageDialog(null,"L'opération a été effectué avec succés");
				fermer();
				} catch (Exception e) {
					System.out.println("error while using retirer class :"+e);
				}
				}
				else {
					JOptionPane.showMessageDialog(null,"Vous n'avez pas le droit à retirer cette somme");

				}
			
			}
		});
		btnNewButton.setBounds(70, 132, 200, 38);
		panel.add(btnNewButton);
		
		JLabel Montant = new JLabel("Montant");
		Montant.setHorizontalAlignment(SwingConstants.CENTER);
		Montant.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Montant.setBounds(40, 57, 117, 38);
		panel.add(Montant);
	
	

    }
}
