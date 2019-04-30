package App_interfaces;


import java.awt.BorderLayout;
import java.lang.Exception;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import app_classes.Client;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class supprimerClient extends JFrame {

	private JPanel contentPane;
	private String[] clientrow = {null,null,null};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerClient frame = new supprimerClient();
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
	public supprimerClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(405, 470, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Vous voulez vraiment supprimer le client");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					DBConnection.DBconnect();
					Connection con = DBConnection.getCon();
					clientrow = DBConnection.getClientInfos(Client.getCIN());
					
					  Document document = new Document();
				        try {
				        	PdfWriter.getInstance(document, new FileOutputStream("data_saving_for"+Client.getCIN()+".pdf"));
				            // open document
				            document.open();
				            // ajouter table dans le document
				            PdfPTable table = new PdfPTable(4);
				            PdfPCell cell =
				            new PdfPCell(
				            new Paragraph("Clients informations"));                
				            cell.setColspan(4);
				           // cell.setBackgroundColor(Color.red);
				            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				            table.addCell(cell);
				 
				            //Définir le texte d'en-tête de la Table

				            cell = new PdfPCell(new Paragraph("cin"));
				            //cell.setBackgroundColor(Color.blue);
				            table.addCell(cell);
				 
				            cell = new PdfPCell(new Paragraph("name"));
				           // cell.setBackgroundColor(Color.blue);
				            table.addCell(cell);
				 
				            cell = new PdfPCell(new Paragraph("agence"));
				           // cell.setBackgroundColor(Color.blue);
				            table.addCell(cell);

				            cell = new PdfPCell(new Paragraph("image"));
				            //cell.setBackgroundColor(Color.blue);
				            table.addCell(cell);
				 
				            //Fill data to the table                       
				            for (int j = 0; j < 2; j++) {
			                    table.addCell(clientrow[j]);
			                }
				            
				            document.add(table);
				        } catch (DocumentException de) {
				            System.err.println(de.getMessage());
				        } catch (IOException ioe) {
				            System.err.println(ioe.getMessage());
				        }
				 // close the document
				        document.close();
				     
					String rq=" select * FROM compte where cin ='"+Client.getCIN()+"'";
					PreparedStatement create=con.prepareStatement(rq);
					ResultSet rs=create.executeQuery();
					while(rs.next() ) { 
						
						supprimerCompteAuto.sup(rs.getString("CODE"));
				}
					
					
						String rq3=" DELETE FROM client WHERE cin='"+Client.getCIN()+"'";
						PreparedStatement create3=con.prepareStatement(rq3);
						create3.executeUpdate();
						JOptionPane.showMessageDialog(null,"L'opération a été effectué avec succés");
						Home_Page frame =  new Home_Page();
						frame.setVisible(true);
						fermer();
					
			}
				catch(Exception e1) {System.out.println(e1);}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(40, 86, 351, 40);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile frame = new Profile();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBounds(155, 169, 89, 23);
		panel.add(btnNewButton_1);
	}

}
