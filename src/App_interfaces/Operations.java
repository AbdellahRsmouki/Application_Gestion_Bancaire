package App_interfaces;

import java.awt.BorderLayout;
import java.lang.Exception;
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
import java.sql.ResultSet;
import java.sql.Statement;

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

import app_classes.Client;
import employeAgence_interfaces.employeAgenceSignin;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Operations extends JFrame {

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
					Operations frame = new Operations();
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
	public Operations() {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 197, 461);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnInformations = new JButton("Informations");
		btnInformations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Profile frame = new Profile();
			frame.setVisible(true);
			fermer();
			}
		});
		btnInformations.setFont(new Font("Arial", Font.BOLD, 15));
		btnInformations.setBorderPainted(false);
		btnInformations.setBackground(Color.DARK_GRAY);
		btnInformations.setForeground(new Color(255, 255, 255));
		btnInformations.setBounds(28, 72, 159, 50);
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
		btnTransactions.setFont(new Font("Arial", Font.BOLD, 15));
		btnTransactions.setBorderPainted(false);
		btnTransactions.setBackground(Color.DARK_GRAY);
		btnTransactions.setBounds(28, 150, 159, 41);
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
		btnInformations_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnInformations_1.setBorderPainted(false);
		btnInformations_1.setBackground(Color.DARK_GRAY);
		btnInformations_1.setBounds(28, 227, 159, 41);
		panel_1.add(btnInformations_1);
		
		JButton btnTransactionsEffectues = new JButton("Operations");
		btnTransactionsEffectues.setBorder(null);
		btnTransactionsEffectues.setBorderPainted(false);
		btnTransactionsEffectues.setForeground(Color.WHITE);
		btnTransactionsEffectues.setFont(new Font("Arial", Font.BOLD, 15));
		btnTransactionsEffectues.setBackground(Color.GREEN);
		btnTransactionsEffectues.setBounds(28, 306, 159, 41);
		panel_1.add(btnTransactionsEffectues);
		
		JLabel operations = new JLabel("Operations");
		operations.setHorizontalAlignment(SwingConstants.CENTER);
		operations.setFont(new Font("Arial Black", Font.BOLD, 18));
		operations.setBounds(357, 11, 153, 38);
		panel.add(operations);
		
		

			String[] head= {" Date", " Type", " Montant", "Total "};
	        DefaultTableModel model = new DefaultTableModel(head, 0);
	        table = new JTable(model);
	        table.setBounds(199, 60, 488, 346);
			panel.add(table);

			table.setBackground(Color.LIGHT_GRAY);
			table.setForeground(Color.black);

			Font font = new  Font("",5,10);
			table.setFont(font);
			
			JButton Download = new JButton("Download");
			Download.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					try {
						DBConnection.DBconnect();
						
						Document doc=new Document();
						PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Rsmouki Adellah\\Desktop\\transactions_for"+Client.getCIN()+".pdf"));
						doc.open();
						doc.add(new Paragraph("                       "));
						doc.add(new Paragraph("Les transactiions éfféctué :"));
						doc.add(new Paragraph(" "));
						
						/////////////////////////////////
						PdfPTable table=new PdfPTable(4);
						table.setWidthPercentage(100);
						PdfPCell cell;
						cell=new PdfPCell(new Phrase("Date",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell=new PdfPCell(new Phrase("type ",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell=new PdfPCell(new Phrase("Montant ",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						cell=new PdfPCell(new Phrase("total ",FontFactory.getFont("commic sans RS",12)));
						cell.setHorizontalAlignment(Element.ALIGN_CENTER);
						cell.setBackgroundColor(BaseColor.GRAY);
						table.addCell(cell);
						
						
						
						
						
						 Statement st= App_interfaces.DBConnection.getCon().createStatement();
						String query = "select * from transaction where CIN ='"+Client.getCIN()+"'";
						ResultSet resultat1 = st.executeQuery(query); 
							while(resultat1.next()) {
								cell=new PdfPCell(new Phrase(resultat1.getString("Date").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								cell=new PdfPCell(new Phrase(resultat1.getString("type").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								
								cell=new PdfPCell(new Phrase(resultat1.getString("Montant").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								
								cell=new PdfPCell(new Phrase(resultat1.getString("Total").toString(),FontFactory.getFont("commic sans RS",12)));
								cell.setHorizontalAlignment(Element.ALIGN_CENTER);
								cell.setBackgroundColor(BaseColor.GRAY);
								table.addCell(cell);
								
						}
						
						doc.add(table);
						doc.close();
						Desktop.getDesktop().open(new File("C:\\Users\\Rsmouki Adellah\\Desktop\\transactions_for"+Client.getCIN()+".pdf"));
					
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
			Download.setBackground(Color.CYAN);
			Download.setFont(new Font("Tahoma", Font.PLAIN, 14));
			Download.setBounds(378, 417, 132, 34);
			panel.add(Download);
			model.addRow(head);

			try {
				DBConnection.DBconnect();
				 ResultSet rs;
				 Statement st= DBConnection.getCon().createStatement();;
			
				String row[]= {null,null,null,null};
				String query = "select * from transaction where CIN ='"+Client.getCIN()+"'";
				rs = st.executeQuery(query);

				while(rs.next()) {
				row[0]=rs.getString("DATE");
				row[1]=rs.getString("TYPE");
				row[2]=rs.getString("MONTANT");
				row[3]=rs.getString("TOTAL");
				model.addRow(row);
				}}
				catch(Exception e){
					System.out.println("ERROR in Operations :"+e);
				};

}	
}
