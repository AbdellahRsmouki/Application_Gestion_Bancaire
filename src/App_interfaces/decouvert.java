package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.RandomStringUtils;

import app_classes.Client;
import app_classes.compteCourant;
import app_classes.compteEpargne;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class decouvert extends JFrame {

	private JPanel contentPane;
	private JTextField txtSaisirIci;
	private JTextField textField_2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					decouvert frame = new decouvert();
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
	void fermer() {
		dispose();
	}
	public decouvert() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(234, 11, 440, 279);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("continuer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {//générer un password
					 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
					 String pwd = RandomStringUtils.random( 4, characters );
					 	double solde = compteCourant.getSolde()+Double.parseDouble(txtSaisirIci.getText());
						//on va ajouter un compte 
						String rq2="insert into compte values('"+Client.getCIN()+"','"+pwd+"','"+Double.parseDouble(textField_2.getText())+"','"+solde+"','courant')";
						PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
						prep2.executeUpdate();
						//on va ajouter une transaction
						String rq3="INSERT INTO transaction VALUES ('"+DBConnection.getDate()+"','"+Client.getCIN()+"','deposer','"+Double.parseDouble(txtSaisirIci.getText())+"','"+solde+"')";
						PreparedStatement prep3 = DBConnection.getCon().prepareStatement(rq3); 
						prep3.executeUpdate();
						Client.setCompteCourant(1);
						DBConnection.Updateclient();
						signIn frame = new signIn();
						frame.setVisible(true);
						fermer();
				        }
				 catch(Exception ec) {
			        	System.out.println("error while adding compte Courant : "+ec);
			        }
			}
		});
		btnNewButton_1.setBounds(171, 210, 214, 42);
		panel.add(btnNewButton_1);
		
		txtSaisirIci = new JTextField();
		txtSaisirIci.setBackground(SystemColor.inactiveCaptionBorder);
		txtSaisirIci.setText("Saisir ici");
		txtSaisirIci.setBounds(171, 44, 214, 42);
		panel.add(txtSaisirIci);
		txtSaisirIci.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(SystemColor.inactiveCaptionBorder);
		textField_2.setText("Saisir ici");
		textField_2.setColumns(10);
		textField_2.setBounds(171, 123, 214, 42);
		panel.add(textField_2);
		
		btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Profile frame = new Profile();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(29, 210, 89, 42);
		panel.add(btnNewButton);
		
		JLabel solde_initial = new JLabel("Solde initial");
		solde_initial.setHorizontalAlignment(SwingConstants.CENTER);
		solde_initial.setHorizontalTextPosition(SwingConstants.CENTER);
		solde_initial.setBorder(null);
		solde_initial.setBackground(Color.LIGHT_GRAY);
		solde_initial.setBounds(29, 53, 100, 25);
		panel.add(solde_initial);
		
		JLabel lblDecouvert = new JLabel("Decouvert");
		lblDecouvert.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDecouvert.setHorizontalAlignment(SwingConstants.CENTER);
		lblDecouvert.setBorder(null);
		lblDecouvert.setBackground(Color.LIGHT_GRAY);
		lblDecouvert.setBounds(29, 137, 100, 25);
		panel.add(lblDecouvert);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 234, 301);
		contentPane.add(panel_1);
	}
}
