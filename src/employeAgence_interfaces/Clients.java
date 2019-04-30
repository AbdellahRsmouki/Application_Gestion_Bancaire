package employeAgence_interfaces;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Panel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import App_interfaces.DBConnection;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.lang.Exception;

public class Clients extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ArrayList<String[]> clientrows = new ArrayList<String[]>();
	
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
					Clients frame = new Clients();
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
	public Clients() {
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
		
		JLabel operations = new JLabel("Clients de cette agence");
		operations.setHorizontalAlignment(SwingConstants.CENTER);
		operations.setFont(new Font("Arial Black", Font.BOLD, 18));
		operations.setBounds(164, 11, 339, 38);
		panel.add(operations);
		
		

			String[] head= {" nom", " cin"};
	        DefaultTableModel model = new DefaultTableModel(head, 0);
	        table = new JTable(model);
	        table.setBounds(0, 67, 687, 282);
			panel.add(table);

			table.setBackground(Color.LIGHT_GRAY);
			table.setForeground(Color.black);

			Font font = new  Font("",5,10);
			table.setFont(font);
			
			JButton btnNewButton = new JButton("Retour");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					employeAgenceHom frame = new employeAgenceHom();
					frame.setVisible(true);
					fermer();
				}
			});
			btnNewButton.setBorder(null);
			btnNewButton.setBackground(Color.GRAY);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnNewButton.setBounds(495, 395, 182, 38);
			panel.add(btnNewButton);
			
			JButton btnDownload = new JButton("Download");
			btnDownload.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						App_interfaces.DBConnection.DBconnect();
						
						Document doc=new Document();
						PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Rsmouki Adellah\\Desktop\\agenceClients_for"+employeAgenceSignin.getagence()+".pdf"));
						doc.open();
						doc.add(new Paragraph("                       "));
						doc.add(new Paragraph("Listes des clients et leurs comptes:"));
						doc.add(new Paragraph(" "));
						
						/////////////////////////////////
						PdfPTable table=new PdfPTable(3);
						table.setWidthPercentage(100);
						PdfPCell cell;
						cell=new PdfPCell(new Phrase("nom",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell=new PdfPCell(new Phrase("cin ",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell=new PdfPCell(new Phrase("agence ",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						
						
						
						
						 Statement st= App_interfaces.DBConnection.getCon().createStatement();
						String query = "select * from client where agence ='"+employeAgenceSignin.getagence()+"'";
						ResultSet resultat1 = st.executeQuery(query); 
							while(resultat1.next()) {
								cell=new PdfPCell(new Phrase(resultat1.getString("nom").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								cell=new PdfPCell(new Phrase(resultat1.getString("cin").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								
								cell=new PdfPCell(new Phrase(resultat1.getString("agence").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
						}
						
						doc.add(table);
						doc.close();
						Desktop.getDesktop().open(new File("C:\\Users\\Rsmouki Adellah\\Desktop\\agenceClients_for"+employeAgenceSignin.getagence()+".pdf"));
					
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				}
			});
			btnDownload.setFont(new Font("Tahoma", Font.PLAIN, 16));
			btnDownload.setBorder(null);
			btnDownload.setBackground(Color.GRAY);
			btnDownload.setBounds(105, 360, 283, 73);
			panel.add(btnDownload);
			model.addRow(head);

			try {
				App_interfaces.DBConnection.DBconnect();
				 ResultSet rs;
				 Statement st= App_interfaces.DBConnection.getCon().createStatement();;
			
				String row[]= {null,null};
				String query = "select * from client where agence ='"+employeAgenceSignin.getagence()+"'";
				rs = st.executeQuery(query);

				while(rs.next()) {
				row[0]=rs.getString("nom");
				row[1]=rs.getString("cin");
				model.addRow(row);
				}}
				catch(Exception e){
					System.out.println("ERROR in client Operations :"+e);
				};

}	
}
