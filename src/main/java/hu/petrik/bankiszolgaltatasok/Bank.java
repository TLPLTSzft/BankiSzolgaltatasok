package hu.petrik.bankiszolgaltatasok;

import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import java.util.ArrayList;

public class Bank {
	private ArrayList<Szamla> szamlaLista;
	
	public Bank() {
		szamlaLista = new ArrayList<>();
		Tulajdonos tulajdonos = new Tulajdonos("Gipsz Jakab");
	}
	
	public Szamla szamlaNyitas(Tulajdonos tulajdonos, int hitelKeret) {
		if (hitelKeret == 0) {
			MegtakaritasiSzamla megtakaritasiSzamla = new MegtakaritasiSzamla(tulajdonos);
			szamlaLista.add(megtakaritasiSzamla);
			return megtakaritasiSzamla;
		} else if (hitelKeret > 0) {
			HitelSzamla hitelSzamla = new HitelSzamla(tulajdonos, hitelKeret);
			szamlaLista.add(hitelSzamla);
			return hitelSzamla;
		} else {
			throw new IllegalArgumentException("Negatív hitel keret nem érvényes");
		}
	}
	
	public int getOsszEgyenleg(Tulajdonos tulajdonos) {
		int osszEgyenleg = 0;
		for (Szamla szamla : szamlaLista) {
			if (szamla.getTulajdonos() == tulajdonos) {
				osszEgyenleg += szamla.aktualisEgyenleg;
			}
		}
		return osszEgyenleg;
	}
	
	public Szamla getLegnagyobbEgyenleguSzamla(Tulajdonos tulajdonos) {
		int egyenlegMax = 0;
		int egyenlegMaxIndex = 0;
		for (int i = 0; i < szamlaLista.size(); i++) {
			if (szamlaLista.get(i).getTulajdonos() == tulajdonos) {
				if (egyenlegMax < szamlaLista.get(i).aktualisEgyenleg) {
					egyenlegMax = szamlaLista.get(i).aktualisEgyenleg;
					egyenlegMaxIndex = i;
				}
			}
		}
		return szamlaLista.get(egyenlegMaxIndex);
	}
	
	public long getOsszHitelkeret() {
		long osszHitelkeret = 0;
		for (Szamla szamla : szamlaLista) {
			if (szamla instanceof HitelSzamla) {
				osszHitelkeret += ((HitelSzamla) szamla).getHitelKeret();
			}
		}
		return osszHitelkeret;
	}
	
}
