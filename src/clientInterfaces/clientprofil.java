package clientInterfaces;

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

public class clientprofil extends JFrame {

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
					clientprofil frame = new clientprofil();
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
	public clientprofil() {
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
				clientSignin frame = new clientSignin();
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
			App_interfaces.DBConnection.DBconnect();
		String rq = "select code from compte where cin ='"+clientSignin.getClientcin()+"'and type_compte='courant'";
		PreparedStatement prep = App_interfaces.DBConnection.getCon().prepareStatement(rq);
		ResultSet rs = prep.executeQuery();
		if(rs.next()){codecomptecourant = rs.getString("code");}
		code.setText(codecomptecourant);
		String rq1 = "select code from compte where cin ='"+clientSignin.getClientcin()+"'and type_compte='epargne'";
		PreparedStatement prep1 = App_interfaces.DBConnection.getCon().prepareStatement(rq1);
		ResultSet rs1 = prep1.executeQuery();
		if(rs1.next()){codecompteepargne = rs1.getString("code");}
		code1.setText(codecompteepargne);
		String[] rw = App_interfaces.DBConnection.getClientInfos(clientSignin.getClientcin());
		ImageIcon images = new ImageIcon(App_interfaces.DBConnection.getImg());
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
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientHome frame = new clientHome();
				frame.setVisible(true);
				fermer();
			}
		});
		btnRetour.setForeground(Color.BLACK);
		btnRetour.setBorderPainted(false);
		btnRetour.setBackground(Color.GREEN);
		btnRetour.setBounds(261, 390, 116, 34);
		panel.add(btnRetour);
		
		
		}catch(Exception exx) {System.out.println("ERROR while getting the image : " + exx);
	}
}	
}

