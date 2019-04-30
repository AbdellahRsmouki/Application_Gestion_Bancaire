package app_classes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import App_interfaces.DBConnection;
import App_interfaces.signIn;
import clientInterfaces.clientSignin;
import employeAgence_interfaces.employeAgenceHome;

public class Client {
	
	private static String CIN;
	private static String nom;
	private static String agence;
	private static int compteCourant=0;
	private static int compteEpargne=0;

public static void clientconnecting() {
		
		try {
			DBConnection.DBconnect();
			String rq2="select * from client where cin =?";
			PreparedStatement prep2 = DBConnection.getCon().prepareStatement(rq2); 
			prep2.setString(1, Client.getCIN());
			ResultSet rs =prep2.executeQuery();
			if(rs.next()) {
				Client.compteCourant=rs.getInt("compte_courant");
				Client.compteEpargne=rs.getInt("compte_epargne");
				Client.agence=rs.getString("agence");
				Client.nom=rs.getString("nom");
			}
			}catch(Exception e) {
				System.out.println("error while getting client infos : "+e);
			}
	}
	
	public static int getCompteCourant() {
		return Client.compteCourant;
	}
	public static void setCompteCourant(int compteCrant) {
		Client.compteCourant = compteCrant;
	}
	public static int getCompteEpargne() {
		return Client.compteEpargne;
	}
	public static void setCompteEpargne(int compteEpne) {
		Client.compteEpargne = compteEpne;
	}
	public static String getAgence() {
		return agence;
	}
	public static void setAgence(String agce) {
		agence = agce;
	}


	public static String getCIN() {
		return CIN;
	}
	public static void setCIN(String string) {
		CIN = string;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

}
