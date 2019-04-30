package App_interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.RandomStringUtils;

import app_classes.Client;
import app_classes.compteCourant;
import app_classes.compteEpargne;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class solde extends JFrame {

	private JPanel contentPane;
	private JTextField txtSaisirIci;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					solde frame = new solde();
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
	public solde() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(405, 315, 386, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(-260, 0, 625, 199);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("continuer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 try {//générer un password
					 String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
					 String pwd = RandomStringUtils.random( 4, characters );
					 	
					 	double solde = compteEpargne.getSolde()+Double.parseDouble(txtSaisirIci.getText());
						//on va ajouter un compte 
						String rq2="insert into compte values('"+Client.getCIN()+"','"+pwd+"','0','"+solde+"','epargne')";
						PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
						prep2.executeUpdate();
						//on va ajouter une transaction
						String rq3="INSERT INTO transaction VALUES ('"+DBConnection.getDate()+"','"+Client.getCIN()+"','deposer','"+Double.parseDouble(txtSaisirIci.getText())+"','"+solde+"')";
						PreparedStatement prep3 = DBConnection.getCon().prepareStatement(rq3); 
						prep3.executeUpdate();
						Client.setCompteEpargne(1);
						DBConnection.Updateclient();
						signIn frame = new signIn();
						frame.setVisible(true);
						fermer();
				        }
				 catch(Exception e) {
			        	System.out.println("error while adding compte Epargne : "+e);
			        }
			}
		});
		btnNewButton_1.setBounds(339, 127, 214, 42);
		panel.add(btnNewButton_1);
		
		txtSaisirIci = new JTextField();
		txtSaisirIci.setText("Saisir ici");
		txtSaisirIci.setBounds(354, 74, 188, 42);
		panel.add(txtSaisirIci);
		txtSaisirIci.setColumns(10);
		
		lblNewLabel = new JLabel("SOLDE INITIAL :");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(354, 16, 206, 42);
		panel.add(lblNewLabel);
	}
}

