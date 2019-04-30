package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app_classes.Client;
import app_classes.Compte;
import app_classes.compteEpargne;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;

public class deposer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Date date = new Date();

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
					deposer frame = new deposer();
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
	public deposer() {
		compteEpargne compte = new compteEpargne();
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
		textField.setBounds(188, 57, 107, 38);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Effectuer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Compte.compteconnecting();
					DBConnection.DBconnect();
					try {
					compteEpargne.deposer(Double.parseDouble(textField.getText()));
					String rq2="INSERT INTO transaction VALUES ('"+DBConnection.getDate()+"','"+Client.getCIN()+"','deposer','"+Double.parseDouble(textField.getText())+"','"+compteEpargne.getSolde()+"')";
					PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2);
					prep2.executeUpdate();
					
					DBConnection.Updatecompte();
					JOptionPane.showMessageDialog(null,"L'opération a été effectué avec succés");
					fermer();
				} catch (Exception ec) {
					System.out.println("error while using deposer class :"+ec);
				}
			}});
		btnNewButton.setBounds(113, 132, 117, 38);
		panel.add(btnNewButton);
		
		JLabel montant = new JLabel("Montant");
		montant.setHorizontalAlignment(SwingConstants.CENTER);
		montant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		montant.setBounds(28, 57, 117, 38);
		panel.add(montant);
		}}
