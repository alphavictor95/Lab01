package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Parole {
	
	private List<String> parole;
	public Parole() {
		this.parole = new ArrayList<String>();
	}
	
	public void addParola(String p) {
		this.parole.add(p);
	}
	
	public List<String> getElenco() {
		Collections.sort(parole);
		//TODO
		return parole;
	}
	
	public void reset() {
		parole.clear();
	}

	public void cancella(String parolaSelezionata) {
		for(String p : parole) {
			if(p.compareTo(parolaSelezionata)==0) {
				parole.remove(p);
			}
		}
		
	}

}
