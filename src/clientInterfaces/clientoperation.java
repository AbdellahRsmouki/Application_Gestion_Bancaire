package clientInterfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientoperation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	
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
					clientoperation frame = new clientoperation();
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
	public clientoperation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 703, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 687, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel operations = new JLabel("Operations");
		operations.setHorizontalAlignment(SwingConstants.CENTER);
		operations.setFont(new Font("Arial Black", Font.BOLD, 18));
		operations.setBounds(254, 11, 153, 38);
		panel.add(operations);
		
		

			String[] head= {" Date", " Type", " Montant", "Total "};
	        DefaultTableModel model = new DefaultTableModel(head, 0);
	        table = new JTable(model);
	        table.setBounds(0, 67, 687, 330);
			panel.add(table);

			table.setBackground(Color.LIGHT_GRAY);
			table.setForeground(Color.black);

			Font font = new  Font("",5,10);
			table.setFont(font);
			
			JButton btnNewButton = new JButton("Retour");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clientHome frame = new clientHome();
					frame.setVisible(true);
					fermer();
				}
			});
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(Color.GRAY);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(254, 412, 153, 38);
			panel.add(btnNewButton);
			model.addRow(head);

			try {
				App_interfaces.DBConnection.DBconnect();
				 ResultSet rs;
				 Statement st= App_interfaces.DBConnection.getCon().createStatement();;
			
				String row[]= {null,null,null,null};
				String query = "select * from transaction where CIN ='"+clientSignin.getClientcin()+"'";
				rs = st.executeQuery(query);

				while(rs.next()) {
				row[0]=rs.getString("DATE");
				row[1]=rs.getString("TYPE");
				row[2]=rs.getString("MONTANT");
				row[3]=rs.getString("TOTAL");
				model.addRow(row);
				}
				
			}
				catch(Exception e){
					System.out.println("ERROR in client Operations :"+e);
				};

}	
}
