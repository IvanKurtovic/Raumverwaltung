package de.hdm.raumverwaltung.shared;

public class Raum extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bezeichnung;
	private int raumKapazitaet;
	
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public int getRaumKapazitaet() {
		return raumKapazitaet;
	}
	public void setRaumKapazitaet(int raumKapazitaet) {
		this.raumKapazitaet = raumKapazitaet;
	}
	

}
