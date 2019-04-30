package App_interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import com.itextpdf.text.Document;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import app_classes.Client;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Exception;

public class supprimerCompteAuto {

	private static String row1[]= {null,null,null,null};
	private static ArrayList<String[]> rowss = new ArrayList<String[]>();
    private ResultSet rs;
    
	/**
	 * Launch the application.
	 */
	
		public static void sup(String code) {
			try {
			String rq7=" select * FROM transaction,compte where transaction.cin = compte.cin and compte.code='"+code+"'";
			PreparedStatement prep7 = DBConnection.getCon().prepareStatement(rq7); 
			ResultSet rs7=prep7.executeQuery(rq7);
			if(rs7.next()) {
			
			try{
				Connection con = DBConnection.getCon();
				String rq=" select * FROM compte where code ='"+code+"'";
				PreparedStatement prep = DBConnection.getCon().prepareStatement(rq); 
				ResultSet rs=prep.executeQuery();				
				if(rs.next()) {
					row1[0]=rs.getString("CIN");
					row1[1]=rs.getString("code");
					row1[2]=rs.getString("decouvert");
					row1[3]=rs.getString("solde");		
				}
				// on va tester si le client a fait des transactions par ce compte.
				
				
				String rq1=" select * FROM transaction,compte where transaction.cin = compte.cin and compte.code='"+code+"'";
				PreparedStatement prep1 = DBConnection.getCon().prepareStatement(rq1); 
				rs=prep1.executeQuery(rq1);
				while(rs.next()) { 
						String [] addrow = {null,null,null,null} ;
						addrow[0]=rs.getString("date");
						addrow[1]=rs.getString("type");
						addrow[2]=rs.getString("montant");
						addrow[3]=rs.getString("total");	
						rowss.add(addrow);
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
		            new Paragraph("Compte infos : cin : "+row1[0]+",code : "+row1[1]+", decouvert : "+row1[2]+", solde : "+row1[3]));                
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
		 
		            for (int i = 0; i < rowss.size(); i++) {
		 
		                for (int j = 0; j < 4; j++) {
		                    table.addCell(rowss.get(i)[j]);
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
		        try {
				//on va supprimer les données deja sauvgarder
				String rq2="DELETE transaction FROM transaction inner join compte on transaction.CIN = compte.cin where compte.code='"+code+"'";
				PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
				prep2.executeUpdate();
		        }
		        catch(Exception e) {
		        	System.out.println("error while deleting transactions"+e);
		        }
		        try {
				String rq3="DELETE FROM compte where code ='"+code+"'";
				PreparedStatement prep3 = DBConnection.getCon().prepareStatement(rq3); 
				prep3.executeUpdate();
		        }
		        catch(Exception e) {
		        	System.out.println("error while deleting account"+e);
		        }
			}
			
}