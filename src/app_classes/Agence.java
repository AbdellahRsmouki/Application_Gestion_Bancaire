package app_classes;


public class Agence {
	
	private int code_Agence;
	private String nom;
	private Client client;
	
	
	public int getCode_Agence() {
		return code_Agence;
	}
	public void setCode_Agence(int code_Agence) {
		this.code_Agence = code_Agence;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public String toString() {
		
		
		return "Hello";
	
	}
	
	

}
