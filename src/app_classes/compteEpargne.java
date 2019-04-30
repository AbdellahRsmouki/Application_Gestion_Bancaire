package app_classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import App_interfaces.DBConnection;
import App_interfaces.signIn;

public class compteEpargne extends Compte{
	
	private static final double tauxInteret=0.2;
	
	

	public static void deposer(double montant) {
		double sld=getSolde();
		sld =sld + montant*(1-tauxInteret);
		compteEpargne.setSolde(sld); 
		
	}
	
	void compteEpargne() {
			try {
			DBConnection.DBconnect();
			PreparedStatement prep2 = DBConnection.getCon().prepareStatement( "select code from compte where cin ='"+Client.getCIN()+"'and type_compte='epargne'"); 
			ResultSet rs =prep2.executeQuery();
			if(rs.next()) {
				Compte.setCode(rs.getString("compte.code"));
				Compte.setNom(rs.getString("compte.type_compte"));
				Compte.setSolde(rs.getDouble("compte.solde"));
				
			}
			}catch(Exception e) {
				System.out.println("error while getting compte infos : "+e);
			}
		
	}
}
