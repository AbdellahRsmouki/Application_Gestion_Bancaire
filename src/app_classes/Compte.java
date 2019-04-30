package app_classes;
import java.sql.PreparedStatement;
import java.lang.Exception;
import java.sql.ResultSet;
import java.util.ArrayList;
import App_interfaces.DBConnection;
import App_interfaces.signIn;
import clientInterfaces.clientSignin;
import employeAgence_interfaces.employeAgenceHome;

public abstract class Compte {
	
	private static String code;
	private static String nom;
	private static double solde;
	
public static void compteconnecting() {
		
		try {
			DBConnection.DBconnect();
			String rq2="select * from compte where cin ='"+Client.getCIN()+"'";
			PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
			ResultSet rs =prep2.executeQuery();
			if(rs.next()) {
				Compte.solde=rs.getDouble("solde");
			}
			}catch(Exception e) {
				System.out.println("error while getting client infos : "+e);
			}
	}
	
	public Compte() {
		
	}
	public static String getCode() {
		return code;
	}
	public static void setCode(String cde) {
		code = cde;
	}
	public static String getNom() {
		return nom;
	}
	public static void setNom(String nm) {
		nom = nm;
	}
	public static double getSolde() {
		return solde;
	}
	public static void setSolde(double sld) {
		solde=sld;
	}


}
