package app_classes;
import java.util.Date;

public class Transaction {
	
	private Date date;
	private int Type;
	private double Montant;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public double getMontant() {
		return Montant;
	}
	public void setMontant(double montant) {
		Montant = montant;
	}
	
	public String toString() {
		
		return " ";
		
	}

}
