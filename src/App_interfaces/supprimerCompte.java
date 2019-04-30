package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.itextpdf.text.Document;
import java.lang.Exception; 
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

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class supprimerCompte extends JFrame {

	private JPanel contentPane;
	private String row[]= {null,null,null,null};
	private ArrayList<String[]> rows = new ArrayList<String[]>();
    private ResultSet rs;
    private JTextField txtSaisir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supprimerCompte frame = new supprimerCompte();
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
	public supprimerCompte() {
		DBConnection.DBconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Vous voulez vraiment supprimer ce compte");
		btnNewButton.setBorder(null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					String rq7=" select * FROM transaction,compte where transaction.cin = compte.cin and compte.code='"+txtSaisir.getText()+"'";
					PreparedStatement prep7 = DBConnection.getCon().prepareStatement(rq7); 
					ResultSet rs7=prep7.executeQuery(rq7);
					if(rs7.next()) {
				
				try {
					String rq5=" select * FROM client,compte where client.cin = compte.cin and compte.code='"+txtSaisir.getText()+"'";
					PreparedStatement prep5 = DBConnection.getCon().prepareStatement(rq5); 
					ResultSet rs5=prep5.executeQuery(rq5);
					if(rs5.next()) {
					if(rs5.getString("type_compte").equals("epargne")) {
						Client.setCompteEpargne(2);
					}
					else {
						Client.setCompteCourant(2);
					}
					DBConnection.Updateclient();
					}
					}catch(Exception exc) {
						System.out.println("error while setting client accounts :"+exc);
					}
				
				
			try{
				
				Connection con = DBConnection.getCon();
				String rq=" select * FROM compte where code ='"+txtSaisir.getText()+"'";
				PreparedStatement prep = DBConnection.getCon().prepareStatement(rq); 
				rs=prep.executeQuery(rq);				
				if(rs.next()) {
					
					row[0]=rs.getString("CIN");
					row[1]=rs.getString("code");
					row[2]=rs.getString("decouvert");
					row[3]=rs.getString("solde");		
				}
				
				
				// on va tester si le client a fait des transactions par ce compte.
				String rq1=" select * FROM transaction,compte where transaction.cin = compte.cin and compte.code='"+txtSaisir.getText()+"'";
				PreparedStatement prep1 = DBConnection.getCon().prepareStatement(rq1); 
				rs=prep1.executeQuery(rq1);
				while(rs.next()) { 
						String [] addrow = {null,null,null,null} ;
						addrow[0]=rs.getString("date");
						addrow[1]=rs.getString("type");
						addrow[2]=rs.getString("montant");
						addrow[3]=rs.getString("total");	
						rows.add(addrow);
						}
			}
				catch(Exception e){System.out.println("error while saving the compte : "+e);}
				
				//on va sauvgarder les donner dans un pdf
		        // creation of a document-object
		        Document document = new Document();
		        try {
		            // create a writer that listens to the document and directs a PDF-stream to a file
		            PdfWriter.getInstance(document, new FileOutputStream("data_saving_for"+Client.getCIN()+".pdf"));
		            // open document
		            document.open();
		            // ajouter table dans le document
		            PdfPTable table = new PdfPTable(4);
		            PdfPCell cell =
		            new PdfPCell(
		            new Paragraph("Compte infos : cin : "+row[0]+",code : "+row[1]+", decouvert : "+row[2]+", solde : "+row[3]));                
		            cell.setColspan(5);
		           // cell.setBackgroundColor(Color.red);
		            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		            table.addCell(cell);
		 
		            //Définir le texte d'en-tête de la Table

		            cell = new PdfPCell(new Paragraph("date"));
		            //cell.setBackgroundColor(Color.blue);
		            table.addCell(cell);
		 
		            cell = new PdfPCell(new Paragraph("type"));
		           // cell.setBackgroundColor(Color.blue);
		            table.addCell(cell);
		 
		            cell = new PdfPCell(new Paragraph("montant"));
		           // cell.setBackgroundColor(Color.blue);
		            table.addCell(cell);

		            cell = new PdfPCell(new Paragraph("total"));
		            //cell.setBackgroundColor(Color.blue);
		            table.addCell(cell);
		 
		            //Fill data to the table                       
		 
		            for (int i = 0; i < rows.size(); i++) {
		 
		                for (int j = 0; j < 4; j++) {
		                    table.addCell(rows.get(i)[j]);
		                }
		            }
		 
		            document.add(table);
		        } catch (DocumentException de) {
		            System.err.println(de.getMessage());
		        } catch (IOException ioe) {
		            System.err.println(ioe.getMessage());
		        }
		 
		        // close the document
		        document.close();	
		        
					}}catch(Exception exc) {
			        	System.out.println("error while saving transactions"+exc);
					}
		        
		        Connection con = DBConnection.getCon();
		        try {
				//on va supprimer les données deja sauvgarder
				String rq2="DELETE transaction FROM transaction inner join compte on transaction.cin = compte.cin where compte.code='"+txtSaisir.getText()+"'";
				PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
				prep2.executeUpdate();
		        }
		        catch(Exception ez) {
		        	System.out.println("error while deleting transactions :"+ez);
		        }
		        try {
				String rq3="DELETE FROM compte where code ='"+txtSaisir.getText()+"'";
				PreparedStatement prep3 = DBConnection.getCon().prepareStatement(rq3); 
				prep3.executeUpdate();
				JOptionPane.showMessageDialog(null,"L'opération a été effectué avec succés");
		        }
		        catch(Exception e) {
		        	System.out.println("error while deleting account"+e);
		        }
		        signIn frame = new signIn();
		        frame.setVisible(true);
		        fermer();
				}});
			
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(83, 118, 254, 54);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Profile frame =new Profile();
				frame.setVisible(true);
				fermer();
			}
		});
		btnNewButton_1.setBackground(Color.GRAY);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(168, 209, 89, 23);
		panel.add(btnNewButton_1);
		
		txtSaisir = new JTextField();
		txtSaisir.setText("Saisir le code du compte \u00E0 supprimer");
		txtSaisir.setBounds(83, 58, 254, 30);
		panel.add(txtSaisir);
		txtSaisir.setColumns(10);
		

	}
}
