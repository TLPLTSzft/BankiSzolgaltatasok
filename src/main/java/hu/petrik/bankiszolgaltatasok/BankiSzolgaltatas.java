package hu.petrik.bankiszolgaltatasok;

public abstract class BankiSzolgaltatas {
	
	private Tulajdonos tulajdonos = new Tulajdonos("Gipsz_Jakab");
	
	public BankiSzolgaltatas(Tulajdonos tulajdonos) {
		this.tulajdonos = tulajdonos;
	}
	
	public Tulajdonos getTulajdonos() {
		return tulajdonos;
	}
	
}
