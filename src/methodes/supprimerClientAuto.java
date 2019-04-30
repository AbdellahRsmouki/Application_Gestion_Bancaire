package methodes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import App_interfaces.DBConnection;
import App_interfaces.Home_Page;
import App_interfaces.signIn;
import App_interfaces.supprimerCompteAuto;
import employeAgence_interfaces.employeAgenceHome;

import java.lang.Exception;
		
public class supprimerClientAuto {
	
	private static String[] clientrow = {null,null,null};
	
	public static void supprimerAuto(String cin) {
	try {
		DBConnection.DBconnect();
		Connection con = DBConnection.getCon();
		
		
			clientrow = DBConnection.getClientInfos(cin);
	
		
		  Document document = new Document();
	        try {
	        	PdfWriter.getInstance(document, new FileOutputStream("data_saving_for"+cin+".pdf"));
	            // open document
	            document.open();
	            // ajouter table dans le document
	            PdfPTable table = new PdfPTable(3);
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
	     
		String rq=" select * FROM compte where cin ='"+cin+"'";
		PreparedStatement create=con.prepareStatement(rq);
		ResultSet rs=create.executeQuery();
		while(rs.next() ) { 
			
			supprimerCompteAuto.sup(rs.getString("CODE"));
	}
		
		
			String rq3=" DELETE FROM client WHERE cin='"+cin+"'";
			PreparedStatement create3=con.prepareStatement(rq3);
			create3.executeUpdate();

			
		
}
	catch(Exception e1) {System.out.println(e1);}
	
	
}}


