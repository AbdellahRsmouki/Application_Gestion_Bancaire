package App_interfaces;
import java.sql.Connection;
import java.lang.Exception;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import app_classes.Client;
import app_classes.Compte;

public class DBConnection {
	
	
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	private static byte[] img;
	private static Date date;
	private static double clientsolde;
	
	public static byte[] getImg() {
		return img;
	}
	public static Connection getCon() {
		return con;
	}
	
	public static String getDate() {
		date=new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(date);
	}
	/*
	 * making connection with database
	 */
	public static void  DBconnect() {
		
	try {		
			
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_projet_java","root","");
		st = con.createStatement();
		}
		
	catch(Exception e) {
		
		System.out.println("ERROR while connecting to database : "+ e);
	}
		
	}
	/*
	 * searching for an element in the table client
	 * probably used in SignIn
	 */
	public static boolean checkData(String testnom,String testcin) {

		try {
		String query = "select * from  CLIENT where NOM ='"+testnom+"' and CIN ='"+testcin+"'";
		rs = st.executeQuery(query);
			if(rs.next()==true) {
					return true;
			}
		return false;
		}
		catch(Exception e)
		{
			System.out.println("ERROR :" + e);
		}
		return false;
	}
	
	
	public static String[] getClientInfos(String cin) {
		try {
			String row[]= {null,null,null};
			String query = "select * from CLIENT where CIN ='"+cin+"'";
			rs = st.executeQuery(query);
			if(rs.next()) {
			row[0]=rs.getString("CIN");
			row[1]=rs.getString("NOM");
			row[2]=rs.getString("AGENCE");
			img=rs.getBytes("IMAGE");
			return row;}
			else {System.out.println("ERROR 1 while getting client infos");}
		}catch(Exception eex) {System.out.println("ERROR 2 while getting client infos :"+eex);}
		return null;
		
	}
	
	public static void Updatecompte() {
		try {
			String query = "Update compte set solde ='"+Compte.getSolde()+"' where cin = '"+Client.getCIN()+"'";
			PreparedStatement create=con.prepareStatement(query);
			create.executeUpdate();
			}catch(Exception eex) {System.out.println("ERROR while updating compte infos :"+eex);}
	}
	
	public static void Updateclient() {
		try {
			String query = "Update client set compte_courant ='"+Client.getCompteCourant()+"', compte_epargne ='"+Client.getCompteEpargne()+"' where cin = '"+Client.getCIN()+"'";
			PreparedStatement create=con.prepareStatement(query);
			create.executeUpdate();
			}catch(Exception eex) {System.out.println("ERROR while updating client	 infos :"+eex);}
		
	}
}
