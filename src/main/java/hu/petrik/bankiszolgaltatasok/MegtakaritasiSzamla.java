package hu.petrik.bankiszolgaltatasok;

public class MegtakaritasiSzamla extends Szamla {
	
	private double kamat;
	public static double alapKamat;
	
	public MegtakaritasiSzamla(Tulajdonos tulajdonos) {
		super(tulajdonos);
	}
	
	public double getKamat() {
		return kamat;
	}
	
	public void setKamat(double kamat) {
		this.kamat = kamat;
	}
	
	public static void setAlapKamat() {
		MegtakaritasiSzamla.alapKamat = 10;
	}
	
	public boolean kivesz(int osszeg) {
		boolean kiveszHelyesE = false;
		if (aktualisEgyenleg - osszeg >= 0) {
			aktualisEgyenleg -= osszeg;
			kiveszHelyesE = true;
		}
		return kiveszHelyesE;
	}
	
	public void kamatJovairas() {
		int ujEgyenleg = (int) (getAktualisEgyenleg() * alapKamat / 100);
		aktualisEgyenleg = ujEgyenleg;
	}
	
}
