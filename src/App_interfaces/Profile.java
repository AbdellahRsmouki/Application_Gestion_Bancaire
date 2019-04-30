package App_interfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import app_classes.Client;
import app_classes.Compte;

public class Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	void fermer() {
		dispose();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		Client.clientconnecting();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 11, 687, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 203, 461);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInformations = new JButton("Informations");
		btnInformations.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnInformations.setBorderPainted(false);
		btnInformations.setBackground(Color.GREEN);
		btnInformations.setForeground(new Color(255, 255, 255));
		btnInformations.setBounds(10, 65, 168, 41);
		panel_1.add(btnInformations);
		
		JButton btnTransactions = new JButton("Transaction");
		btnTransactions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				transaction frame = new transaction();
				frame.setVisible(true);
				fermer();
			}
		});
		btnTransactions.setForeground(Color.WHITE);
		btnTransactions.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnTransactions.setBorderPainted(false);
		btnTransactions.setBackground(Color.DARK_GRAY);
		btnTransactions.setBounds(28, 143, 129, 41);
		panel_1.add(btnTransactions);
		
		JButton btnInformations_1 = new JButton("Suppression");
		btnInformations_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppression frame = new Suppression();
				frame.setVisible(true);
				fermer();
			}
		});
		btnInformations_1.setForeground(Color.WHITE);
		btnInformations_1.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnInformations_1.setBorderPainted(false);
		btnInformations_1.setBackground(Color.DARK_GRAY);
		btnInformations_1.setBounds(28, 220, 129, 41);
		panel_1.add(btnInformations_1);
		
		JButton btnTransactionsEffectues = new JButton("Operations");
		btnTransactionsEffectues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operations frame = new Operations();
				frame.setVisible(true);
				fermer();    
			}
		});
		btnTransactionsEffectues.setBorderPainted(false);
		btnTransactionsEffectues.setForeground(Color.WHITE);
		btnTransactionsEffectues.setFont(new Font("Monospaced", Font.PLAIN, 13));
		btnTransactionsEffectues.setBackground(Color.DARK_GRAY);
		btnTransactionsEffectues.setBounds(28, 299, 129, 41);
		panel_1.add(btnTransactionsEffectues);
		
		JLabel lblName = new JLabel("     Name");
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(213, 119, 98, 47);
		panel.add(lblName);
		
		JLabel lblCin = new JLabel("      CIN");
		lblCin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCin.setBounds(213, 187, 85, 34);
		panel.add(lblCin);
		
		JLabel lblAgence = new JLabel("     Agence");
		lblAgence.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAgence.setBounds(213, 246, 85, 34);
		panel.add(lblAgence);
		
		JButton btnNewButton = new JButton("Deconnection");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home_Page frame = new Home_Page();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setBounds(518, 390, 116, 34);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Profile informations");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(261, 37, 176, 47);
		panel.add(lblNewLabel);
		
		JLabel name = new JLabel("");
		name.setBounds(350, 124, 123, 41);
		panel.add(name);
		
		JLabel cin = new JLabel("");
		cin.setHorizontalAlignment(SwingConstants.CENTER);
		cin.setBounds(314, 180, 123, 41);
		panel.add(cin);
		
		JLabel agence = new JLabel("");
		agence.setHorizontalAlignment(SwingConstants.CENTER);
		agence.setBounds(314, 239, 123, 41);
		panel.add(agence);
		
		JLabel image = new JLabel("");
		image.setBounds(501, 37, 176, 184);
		panel.add(image);
		JLabel code = new JLabel("Vous n'avez pas encore un compte");
		code.setBounds(418, 291, 232, 41);
		panel.add(code);
		JLabel code1 = new JLabel("Vous n'avez pas encore un compte");
		code1.setBounds(418, 338, 232, 41);
		panel.add(code1);
		
		try {
			String codecomptecourant="Vous n'avez pas encore un compte";
			String codecompteepargne="Vous n'avez pas encore un compte";
		DBConnection.DBconnect();
		String rq = "select code from compte where (cin ='"+Client.getCIN()+"' )and type_compte='courant'";
		PreparedStatement prep = DBConnection.getCon().prepareStatement(rq);
		ResultSet rs = prep.executeQuery();
		if(rs.next()){codecomptecourant = rs.getString("code");}
		code.setText(codecomptecourant);
		String rq1 = "select code from compte where (cin ='"+Client.getCIN()+"')and type_compte='epargne'";
		PreparedStatement prep1 = DBConnection.getCon().prepareStatement(rq1);
		ResultSet rs1 = prep1.executeQuery();
		if(rs1.next()){codecompteepargne = rs1.getString("code");}
		code1.setText(codecompteepargne);
		String[] rw;
		rw = DBConnection.getClientInfos(Client.getCIN());
		Client.clientconnecting();
		ImageIcon images = new ImageIcon(DBConnection.getImg());
		Image im = images.getImage();
		Image myImg = im.getScaledInstance(image.getWidth(), image.getHeight(),Image.SCALE_SMOOTH);
		ImageIcon newimg = new ImageIcon(myImg);
		image.setIcon(newimg);
		cin.setText(rw[0]);
		name.setText(rw[1]);
		agence.setText(rw[2]);
		

		JLabel lblAccountCode = new JLabel("     code du compte courant");
		lblAccountCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountCode.setBounds(213, 291, 176, 34);
		panel.add(lblAccountCode);
		
		
		JLabel lblAccountCodeEpargne = new JLabel("     code du compte epargne");
		lblAccountCodeEpargne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAccountCodeEpargne.setBounds(213, 338, 176, 34);
		panel.add(lblAccountCodeEpargne);
		
		JButton btnNewButton_1 = new JButton("Cr\u00E9ation d'un compte");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(((Client.getCompteCourant()==1)&&(Client.getCompteEpargne()==1))||(Client.getCompteCourant()==1)&&(Client.getCompteEpargne()==2)||(Client.getCompteCourant()==1)&&(Client.getCompteEpargne()==2)||(Client.getCompteCourant()==2)&&(Client.getCompteEpargne()==2)){
					JOptionPane.showMessageDialog(null,"Vous ne pouvez pas ajouter d'autres comptes ");
				}
				else {
					creationCompte frame = new creationCompte();
					frame.setVisible(true);
					fermer();
				}
			}
		});
		btnNewButton_1.setBounds(240, 393, 197, 29);
		panel.add(btnNewButton_1);
		
		
		}catch(Exception exx) {System.out.println("ERROR while getting the image : " + exx);
	}
}	
}
