package hu.petrik.bankiszolgaltatasok;

public abstract class Szamla extends BankiSzolgaltatas {
	
	public int aktualisEgyenleg;
	
	public Szamla(Tulajdonos tulajdonos) {
		super(tulajdonos);
	}
	
	public int getAktualisEgyenleg() {
		return aktualisEgyenleg;
	}
	
	public void befizet(int osszeg) {
		aktualisEgyenleg += osszeg;
	}
	
	public Kartya ujKartya() {
		Tulajdonos tulajdonos = new Tulajdonos("Gipsz_Jakab");
		Szamla szamla = new Szamla(tulajdonos) {
			@Override
			public boolean kivesz(int osszeg) {
				boolean kiveszHelyesE = false;
				if (aktualisEgyenleg - osszeg >= 0) {
					aktualisEgyenleg -= osszeg;
					kiveszHelyesE = true;
				}
				return kiveszHelyesE;
			}
		};
		Kartya kartya = new Kartya(getTulajdonos(), szamla, "1234-5678");
		return kartya;
	}
	
	public abstract boolean kivesz(int osszeg);
	
}
