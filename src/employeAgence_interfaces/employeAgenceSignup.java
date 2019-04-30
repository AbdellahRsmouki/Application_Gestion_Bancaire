package employeAgence_interfaces;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JFileChooser;


public class employeAgenceSignup extends JFrame {

	private JPanel contentPane;
	private JTextField nom;
	private JTextField cin;
	private JTextArea area;
	private JLabel label;
	private String s;

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
					employeAgenceSignup frame = new employeAgenceSignup();
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
	public employeAgenceSignup() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 692, 549);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    area = new JTextArea("DESCRIPTION",100, 100);
	    
	    JScrollPane pane = new JScrollPane(area);
	    pane.setBounds(450, 270, 200, 100);
	    
	    label = new JLabel();
	    label.setBounds(10,10,670,250);   
	  
	    //button to browse the image into jlabel
		JButton addImg = new JButton("ADD Image");
		addImg.setBounds(355, 291, 256, 46);
		contentPane.add(addImg);
	    addImg.addActionListener(new ActionListener(){
	        @Override
	     public void actionPerformed(ActionEvent e){
	        	
	         JFileChooser fileChooser = new JFileChooser();
	         fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
	         FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","gif","png");
	         fileChooser.addChoosableFileFilter(filter);
	         int result = fileChooser.showSaveDialog(null);
	         if(result == JFileChooser.APPROVE_OPTION){
	             File selectedFile = fileChooser.getSelectedFile();
	             String path = selectedFile.getAbsolutePath();
	             s = path;
	              }
	         else if(result == JFileChooser.CANCEL_OPTION){
	             System.out.println("No Data");
	         }
	     }
	    });

		Button button = new Button("Sign Up");
		 button.addActionListener(new ActionListener(){
		        @Override
		     public void actionPerformed(ActionEvent e){
				try {
					App_interfaces.DBConnection.DBconnect();
					String rq="insert into client values (?,?,'"+employeAgenceSignin.getagence()+"',?,0,0)";
					PreparedStatement create=App_interfaces.DBConnection.getCon().prepareStatement(rq);
					InputStream is = new FileInputStream(new File(s));
					create.setString(1, cin.getText());
					create.setString(2, nom.getText());
					create.setBlob(3,is);
					create.executeUpdate();
					employeAgenceHom frame= new employeAgenceHom();
					frame.setVisible(true);
					fermer();
				}catch(Exception exx) {System.out.println("error : "+exx);
				JOptionPane.showMessageDialog(null,"Il faut saisir tout les informations");}
		        }
		 });
		button.setForeground(Color.WHITE);
		button.setBackground(Color.PINK);
		button.setBounds(355, 389, 256, 38);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 11, 332, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("  YOUR INFORMATIONS ARE SAFE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(29, 205, 267, 85);
		panel.add(lblNewLabel_1);
		
		 nom = new JTextField();
		 nom.setForeground(SystemColor.textHighlight);
		 nom.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 22));
		nom.setColumns(10);
		nom.setBounds(355, 126, 256, 28);
		contentPane.add(nom);
		
		JLabel dlnom = new JLabel("NOM :");
		dlnom.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		dlnom.setBounds(355, 93, 67, 23);
		contentPane.add(dlnom);
		
		cin = new JTextField();
		cin.setForeground(SystemColor.textHighlight);
		cin.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 21));
		cin.setColumns(10);
		cin.setBounds(355, 202, 256, 28);
		contentPane.add(cin);
		
		JLabel dlCIN = new JLabel("CIN :");
		dlCIN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		dlCIN.setBounds(355, 169, 67, 23);
		contentPane.add(dlCIN);
		
		JButton btnNewButton = new JButton("RETOUR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				App_interfaces.Home_Page frame = new App_interfaces.Home_Page();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.GRAY);
		btnNewButton.setBounds(429, 453, 129, 46);
		contentPane.add(btnNewButton);
		

	}
}

