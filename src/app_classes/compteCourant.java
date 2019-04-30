package app_classes;

import java.sql.PreparedStatement;
import java.lang.Exception;
import java.sql.ResultSet;

import App_interfaces.DBConnection;
import App_interfaces.signIn;
import clientInterfaces.clientSignin;
import employeAgence_interfaces.employeAgenceHome;

public class compteCourant extends Compte {
	
	private static double decouvertAutorise;

	public static double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public static void setDecouvertAutorise(double dtAutorise) {
		decouvertAutorise = dtAutorise;
	}
	
	public static void retirer(double montant) {
		double sld=getSolde();
		sld =sld - montant;
		Compte.setSolde(sld);
		
	}
	void compteCourant() {
		try {
			DBConnection.DBconnect();
			PreparedStatement prep2 = DBConnection.getCon().prepareStatement("select * from compte where cin='"+Client.getCIN()+"' and type_compte='courant'"); 
			ResultSet rs =prep2.executeQuery();
			if(rs.next()) {
				Compte.setCode(rs.getString("code"));
				Compte.setNom(rs.getString("type_compte"));
				Compte.setSolde(rs.getDouble("solde"));
				compteCourant.setDecouvertAutorise(rs.getDouble("decouvert"));
				
			}
			}catch(Exception e) {
				System.out.println("error while getting compte infos : "+e);
			}
	
	}
}
