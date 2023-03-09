package hu.petrik.bankiszolgaltatasok;

public class Kartya extends BankiSzolgaltatas {
	
	private Szamla szamla;
	private String kartyaSzam;
	
	public Kartya(Tulajdonos tulajdonos, Szamla szamla, String kartyaSzam) {
		super(tulajdonos);
		this.szamla = szamla;
		this.kartyaSzam = kartyaSzam;
	}
	
	public void setKartyaSzam(String kartyaSzam) {
		this.kartyaSzam = kartyaSzam;
	}
	
	public boolean vasarlas(int osszeg) {
		boolean vasarlasHelyesE=false;
		if (szamla.aktualisEgyenleg-osszeg>=0) {
			szamla.aktualisEgyenleg-=osszeg;
			vasarlasHelyesE=true;
		}
		return vasarlasHelyesE;
	}
	
	public String getKartyaSzam() {
		return kartyaSzam;
	}
	
}
